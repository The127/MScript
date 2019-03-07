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

	//TODO
	private List<Object> statements = new LinkedList<>();
	
	public FunctionModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
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

	@Override
	public String getLocal(String localName, FileContext ctx) {
		if(!locals.containsKey(localName))
			throw new MScriptCompilationException("Unkown local variable '" + localName + "'.", ctx);
		return locals.get(localName);
	}

	@Override
	public String getParam(String paramName, FileContext ctx) {
		if(!params.containsKey(paramName))
			throw new MScriptCompilationException("Uknown function parameter '" + paramName + "'", ctx);
		return params.get(paramName);
	}

	public void addStatement(Object statement) {
		//TODO
		statements.add(statement);
	}
	
	@Override
	public String compile(IScriptContext ctx) {
		// first add intermediary label
		var sb = new StringBuilder("{function::" + this.getName() + "}");
		
		//TODO
		
		return sb.toString();
	}

}
