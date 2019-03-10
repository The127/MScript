/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a 'this is fine' statement in the MScript language.
 * @author Julian Baehr
 */
public class ThisIsFineStatementModel extends StatementModel  {

	public ThisIsFineStatementModel(FileContext ctx) {
		super(ctx);
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "hcf" + System.lineSeparator();
	}

}
