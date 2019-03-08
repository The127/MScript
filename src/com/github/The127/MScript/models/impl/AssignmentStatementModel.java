package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class AssignmentStatementModel extends StatementModel  {

	private final String variable;
	
	private ExpressionModel expression;
	
	public AssignmentStatementModel(FileContext ctx, String variable) {
		super(ctx);
		this.variable = variable;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void setExpression(ExpressionModel expression) {
		this.expression = expression;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return expression.toString()
				+ "pop " + ctx.resolveRegister(getVariable(), getFileContext()) + System.lineSeparator();
	}

}
