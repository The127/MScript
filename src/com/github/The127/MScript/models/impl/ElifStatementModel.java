/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

/**
 * This class represents an elif block in the MScript language.
 * @author Julian Baehr
 */
public class ElifStatementModel extends AbstractModel {

	private ExpressionModel condition;
	private BlockModel block;
	
	private final String label = "__conditionalElif__" + MScriptRuntime.generateLabelName();
	private String end;
	
	public ElifStatementModel(FileContext ctx) {
		super(ctx);
	}
	
	public void setCondition(ExpressionModel condition) {
		this.condition = condition;
	}
	
	public void setBlock(BlockModel block) {
		this.block = block;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append(condition.compile(ctx));
		// use internal condition evaluation to save space
		sb.append("jal ").append(MScriptRuntime.destGotoLabel("__condition")).append(System.lineSeparator());
		// if is false jump to end of block
		sb.append("beq r12 0 ").append(MScriptRuntime.destGotoLabel(label)).append(System.lineSeparator());
		sb.append(block.compile(ctx));
		// if block executes jump to end of if-elif-else
		sb.append("j ").append(MScriptRuntime.destGotoLabel(end)).append(System.lineSeparator());
		// mark end of block
		sb.append(MScriptRuntime.sourceGotoLabel(label)).append(System.lineSeparator());
		
		return sb.toString();
	}
}
