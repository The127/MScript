package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

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
				+ "" + System.lineSeparator();
	}

}
