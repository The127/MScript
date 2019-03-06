/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.IFunctionContext;
import com.github.The127.MScript.models.IScriptContext;

public class FunctionModel extends AbstractModel implements IFunctionContext {

	private final String name;
	
	private Map<String, String> locals = new HashMap<>();
	private Map<String, String> params = new HashMap<>();
	
	public FunctionModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addLocal(String local, FileContext ctx) {
		if(!isUniqueName(local))
			throw new MScriptCompilationException("Duplicate variable and/or param name.", ctx);
		//TODO
	}
	
	public void addParam(String param, FileContext ctx) {
		if(!isUniqueName(param))
			throw new MScriptCompilationException("Duplicate param and/or variable name.", ctx);
		//TODO
	}
	
	private boolean isUniqueName(String name) {
		return locals.containsKey(name) || params.containsKey(name);
	}

	@Override
	public String getLocal(String localName, FileContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParam(String paramName, FileContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String compile(IScriptContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
