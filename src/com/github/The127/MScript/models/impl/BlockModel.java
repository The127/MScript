/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a block ({ statement* }) in the MScript language.
 * @author Julian Baehr
 */
public class BlockModel extends AbstractModel {

	private List<StatementModel> statements = new LinkedList<>();
	
	public BlockModel(FileContext ctx) {
		super(ctx);
	}

	public void addStatement(StatementModel statement) {
		this.statements.add(statement);
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		for(var statement : statements)
			sb.append(statement.compile(ctx));
		return sb.toString();
	}

}
