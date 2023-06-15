/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a sleep statement in the MScript language.
 * @author Karolin Kostial
 */
public class SleepStatementModel extends StatementModel  {

	private ExpressionModel expression;
	private double number;
	
	public SleepStatementModel(FileContext ctx) {
		super(ctx);
	}
	
	public void setNumber(double number) {
		this.number = number;
	}
	
	public void setExpression(ExpressionModel expression) {
		this.expression = expression;
	}

	@Override
	public String compile(IScriptContext ctx) {
		if(expression != null)
			return expression.compile(ctx)
					+ "pop r12" + System.lineSeparator()
					+ "sleep r12" + System.lineSeparator();
		else
			return "sleep " + number + System.lineSeparator();
	}

}
