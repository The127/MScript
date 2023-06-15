/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents an expression in paranthesis in the MScript language.
 * @author Karolin Kostial
 */
public class ParanthesisModel extends AtomModel {

	private final ExpressionModel expression;
	
	public ParanthesisModel(FileContext ctx, ExpressionModel expression) {
		super(ctx);
		this.expression = expression;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return expression.compile(ctx);
	}

}
