/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IFunctionContext;
import com.github.The127.MScript.models.IScriptContext;

public class FunctionModel extends AbstractModel implements IFunctionContext {

	private final String name;
	
	public FunctionModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
	}
	
	public String getName() {
		return name;
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
