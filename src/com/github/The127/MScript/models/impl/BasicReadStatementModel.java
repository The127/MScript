/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a basic read statement in the MScript language.
 * @author Julian Baehr
 */
public class BasicReadStatementModel extends ReadStatementModel {
	
	public BasicReadStatementModel(FileContext ctx, String device, String target, String variable) {
		super(ctx, device, target, variable);
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "l" 
				+ " " + ctx.resolveRegister(getVariable(), getFileContext()) 
				+ " " + ctx.resolveAlias(getDevice(), getFileContext())
				+ " " + getTarget()
				+ System.lineSeparator();
	}
}
