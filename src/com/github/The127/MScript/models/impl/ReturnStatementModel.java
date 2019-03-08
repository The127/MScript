package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class ReturnStatementModel extends StatementModel  {

	private ExpressionModel expression;
	
	public ReturnStatementModel(FileContext ctx) {
		super(ctx);
	}
	
	public void setExpression(ExpressionModel expression) {
		this.expression = expression;
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		// pop return address into r14 (ra is used internally in rt)
		sb.append("pop r14").append(System.lineSeparator());//see function model (push ra)
		// set return value either to the actual value
		if(expression != null)
			sb.append(expression.compile(ctx));
		// or to 1/true on default
		else
			sb.append("push 1").append(System.lineSeparator());
		sb.append("j r14").append(System.lineSeparator());
		return sb.toString();
	}

}
