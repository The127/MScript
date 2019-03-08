package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class ElifStatementModel extends AbstractModel {

	private ExpressionModel condition;
	private BlockModel block;

	public ElifStatementModel(FileContext ctx) {
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
		
		sb.append(block.compile(ctx));
		
		return sb.toString();
	}
}
