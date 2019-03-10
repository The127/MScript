/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a yield statement in the MScript language.
 * @author Julian Baehr
 *
 */
public class YieldStatementModel extends StatementModel  {

	public YieldStatementModel(FileContext ctx) {
		super(ctx);
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "yield" + System.lineSeparator();
	}

}
