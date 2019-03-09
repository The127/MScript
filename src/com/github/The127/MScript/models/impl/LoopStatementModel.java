/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class LoopStatementModel extends StatementModel  {

	private final String label = "__loop__" + MScriptRuntime.generateLabelName();
	
	private ExpressionModel condition;
	private BlockModel block;
	
	public LoopStatementModel(FileContext ctx) {
		super(ctx);
	}

	public void setCondition(ExpressionModel condition) {
		this.condition = condition;
	}
	
	public void setBlock(BlockModel block) {
		this.block = block;
	}
	
	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		sb.append(MScriptRuntime.sourceGotoLabel(label)).append(System.lineSeparator());
		
		sb.append(block.compile(ctx));
		
		if(condition == null)
			sb.append("j " + MScriptRuntime.destGotoLabel(label)).append(System.lineSeparator());
		else {
			sb.append(condition.compile(ctx)).append(System.lineSeparator());
			sb.append("jal ").append(MScriptRuntime.destGotoLabel("__round")).append(System.lineSeparator());
			sb.append("bne r12 0 ").append(MScriptRuntime.destGotoLabel(label)).append(System.lineSeparator());
		}
		
		return sb.toString();
	}

}
