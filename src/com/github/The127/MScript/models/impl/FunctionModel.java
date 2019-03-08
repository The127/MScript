/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.IFunctionContext;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class FunctionModel extends AbstractModel implements IFunctionContext {

	public static final int
		MAX_REGISTERS = 12,
		MAX_PARAMS = 4,
		MAX_LOCALS = MAX_REGISTERS - MAX_PARAMS;
	
	private final String name;
	
	private int localCount = 0;
	private Map<String, String> locals = new HashMap<>();
	private int paramCount = 0;
	private Map<String, String> params = new HashMap<>();

	private List<StatementModel> statements = new LinkedList<>();
	
	public FunctionModel(FileContext ctx, String name) {
		super(ctx);
		if(MScriptRuntime.isRtFunctionName(name))
			throw compilerError("Function name '" + name + "' is reserved for MScript Runtime.");
		this.name = name;
	}
	
	public int getParamCount() {
		return paramCount;
	}
	
	public int getLocalCount() {
		return localCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void addLocal(String local, FileContext ctx) {
		if(!isUniqueName(local))
			throw new MScriptCompilationException("Duplicate variable and/or param name '" + local + "'.", ctx);
		if(localCount >= MAX_LOCALS)
			throw new MScriptCompilationException("Too many local variables (only " + MAX_LOCALS + " are allowed).", ctx);
		locals.put(local, "r" + localCount++);
	}
	
	public void addParam(String param, FileContext ctx) {
		if(!isUniqueName(param))
			throw new MScriptCompilationException("Duplicate param and/or variable name '" + param + "'.", ctx);
		if(paramCount >= MAX_PARAMS)
			throw new MScriptCompilationException("Too many function parameters (only " + MAX_PARAMS + " are allowed).", ctx);
		params.put(param, "r" + paramCount++);
	}
	
	private boolean isUniqueName(String name) {
		return locals.containsKey(name) || params.containsKey(name);
	}

	public void addStatement(StatementModel statement) {
		statements.add(statement);
	}

	@Override
	public String resolveRegister(String variableName, FileContext ctx) {
		if(!params.containsKey(variableName))
			if(!locals.containsKey(variableName))
				throw new MScriptCompilationException("Unkown variable '" + variableName + "'", ctx);
			else
				return locals.get(variableName);
		else
			return params.get(variableName);
	}
	
	@Override
	public String compile(IScriptContext ctx) {
		// first add intermediary label
		var sb = new StringBuilder(MScriptRuntime.sourceFunctionLabel(getName())).append(System.lineSeparator());
		
		for(var statement : statements)
			sb.append(statement.compile(ctx));
		
		return sb.toString();
	}

}
