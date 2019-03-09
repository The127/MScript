/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

public class LiteralModel extends AtomModel {

	private final String number;
	
	public LiteralModel(FileContext ctx, String number) {
		super(ctx);
		this.number = number;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "push " + number + System.lineSeparator();
	}
}
