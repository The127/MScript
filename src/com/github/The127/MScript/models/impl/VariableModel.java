/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class VariableModel extends AtomModel {

	private final String name;
	
	public VariableModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
	}

	@Override
	public String compile(IScriptContext ctx) {
		if(name.startsWith("$"))
			return "push " + ctx.resolverConst(name, getFileContext()) + System.lineSeparator();
		else
			return "push " + ctx.resolveRegister(name, getFileContext()) + System.lineSeparator();
	}

}
