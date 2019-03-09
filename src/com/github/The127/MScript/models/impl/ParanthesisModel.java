/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

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
