/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;

/**
 * This class represents an abstract expression in the MScript language.
 * @author Karolin Kostial
 */
public abstract class ExpressionModel extends AbstractModel {

	public ExpressionModel(FileContext ctx) {
		super(ctx);
	}
}
