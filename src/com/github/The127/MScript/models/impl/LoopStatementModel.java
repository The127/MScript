package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class LoopStatementModel extends StatementModel  {

	private final String label = "__loop__" + MScriptRuntime.generateLabelName();
	
	private ExpressionModel condition;
	
	public LoopStatementModel(FileContext ctx) {
		super(ctx);
	}

	public void setCondition(ExpressionModel condition) {
		this.condition = condition;
	}
	
	@Override
	public String compile(IScriptContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
