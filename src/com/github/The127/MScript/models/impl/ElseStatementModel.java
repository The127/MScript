/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents an else block in the MScript language.
 * @author Karolin Kostial
 */
public class ElseStatementModel extends AbstractModel {
	
	private BlockModel block;

	public ElseStatementModel(FileContext ctx) {
		super(ctx);
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
