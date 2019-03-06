/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.ICompilableModel;
import com.github.The127.MScript.models.IScriptContext;

public class FunctionModel extends AbstractModel implements ICompilableModel {

	private final String name;
	
	public FunctionModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String compile(IScriptContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
