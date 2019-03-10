/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a reagent read statement in the MScript language.
 * @author Julian Baehr
 */
public class ReagentReadStatementModel extends ReadStatementModel {

	private final String reagentMode;
	
	public ReagentReadStatementModel(FileContext ctx, String device, String reagentMode, String reagent, String variable) {
		super(ctx, device, reagent, variable);
		this.reagentMode = reagentMode;
	}
	
	public String getReagentMode() {
		return reagentMode;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "lr" 
				+ " " + ctx.resolveRegister(getVariable(), getFileContext()) 
				+ " " + ctx.resolveAlias(getDevice(), getFileContext())
				+ " " + getReagentMode()
				+ " " + getTarget()
				+ System.lineSeparator();
	}
}
