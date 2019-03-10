/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a sleep statement in the MScript language.
 * @author Julian Baehr
 */
public class SleepStatementModel extends StatementModel  {

	private ExpressionModel expression;
	
	public SleepStatementModel(FileContext ctx) {
		super(ctx);
	}
	
	public void setExpression(ExpressionModel expression) {
		this.expression = expression;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return expression.compile(ctx)
				+ "pop r12" + System.lineSeparator()
				+ "sleep r12" + System.lineSeparator();
	}

}
