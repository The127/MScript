/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a function call statement in the MScript language.
 * @author Karolin Kostial
 */
public class FunctionCallStatementModel extends StatementModel  {

	private FunctionCallModel functionCall;
	
	public FunctionCallStatementModel(FileContext ctx) {
		super(ctx);
	}

	public void setFunctionCall(FunctionCallModel functionCall) {
		this.functionCall = functionCall;
	}
	
	@Override
	public String compile(IScriptContext ctx) {
		return functionCall.compile(ctx)
				// dont care for result in fn call stmt
				+ "pop r12" + System.lineSeparator();
	}

}
