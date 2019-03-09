/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class ScriptModel implements IScriptContext {

	private Map<String, String> aliases = new HashMap<>();
	private Map<String, Double> consts = new HashMap<>();
	
	private FunctionModel mainFunction;
	private List<FunctionModel> functions = new LinkedList<>();
	
	private FunctionModel currentCompileFunction = null;
	
	public ScriptModel() {
		// setup special variables
		consts.put("$True", 1d);
		consts.put("$False", 0d);
	}
	
	public void addAlias(String alias, String device, FileContext ctx) {
		if(aliases.containsKey(alias))
			throw new MScriptCompilationException("Duplicate alias '" + alias + "'.", ctx);
		aliases.put(alias, device);
	}
	
	public void addConst(String constant, double value, FileContext ctx) {
		if(consts.containsKey(constant))
			throw new MScriptCompilationException("Duplicate constant '" + constant + "'.", ctx);
		consts.put(constant, value);
	}

	@Override
	public double resolverConst(String name, FileContext ctx) {
		if(!consts.containsKey(name))
			throw new MScriptCompilationException("Constant '" + name + "' is not defined.", ctx);
		return consts.get(name);
	}

	@Override
	public String resolveAlias(String alias, FileContext ctx) {
		if(!aliases.containsKey(alias))
			throw new MScriptCompilationException("Device '" + alias + "' is not defined.", ctx);
		return aliases.get(alias);
	}

	public void addFunction(FunctionModel function) {
		if(function.getName().equals("main"))
			if(mainFunction != null)
				throw new MScriptCompilationException("Duplicate main function.", function.getFileContext());
			else
				mainFunction = function;
		else
			// check via list since we only will have very few functions
			if(functions.stream().anyMatch(m  -> m.getName().equals(function.getName())))
				throw new MScriptCompilationException("Duplicate function '" + function.getName() + "'.", function.getFileContext());
			else
				functions.add(function);
	}

	@Override
	public String resolveRegister(String variableName, FileContext ctx) {
		return currentCompileFunction.resolveRegister(variableName, ctx);
	}
	
	/**
	 * Entry point for the compilation.
	 * @return A pseudo compiled script as a String.
	 */
	public String doCompile() {		
		if(mainFunction == null)
			throw new MScriptCompilationException("Missing main function.");
		currentCompileFunction = mainFunction;
		
		var sb = new StringBuilder();
		
		//TODO nulls
		
		sb.append(mainFunction.compile(null));
		for(var f : functions) {
			currentCompileFunction = f;
			sb.append(f.compile(null));
		}
		
		// find function with most variables and create modular/optimized runtime
		var maxLocals = functions.stream().map(FunctionModel::getLocalCount).reduce(0, Integer::max).intValue();
		maxLocals = Integer.max(maxLocals, mainFunction.getLocalCount());
		// only push-/pop-registers to theoretically_max_params + maxLocals
		var registersUsed = FunctionModel.MAX_PARAMS + maxLocals;
		sb.append(MScriptRuntime.createRuntime(registersUsed));
		// remove any empty lines that might be inside the compiled file to reduce the line count
		return sb.toString().replaceAll("(?m)^[ \t]*\r?\n", "");
	}
}
