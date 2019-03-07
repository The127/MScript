package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class WriteStatementModel extends StatementModel {

	private final String device, target, variable;
	
	public WriteStatementModel(FileContext ctx, String device, String target, String variable) {
		super(ctx);
		this.device = device;
		this.target = target;
		this.variable = variable;
	}
	
	public String getDevice() {
		return device;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getVariable() {
		return variable;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "s"
				+ " " + ctx.resolveAlias(getDevice(), getFileContext())
				+ " " + getTarget()
				+ " " + ctx.resolveRegister(getVariable(), getFileContext()) ;
	}

}
