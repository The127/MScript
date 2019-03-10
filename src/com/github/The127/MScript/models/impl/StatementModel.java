/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;

/**
 * This class represents an abstract statement in the MScript language.
 * @author Julian Baehr
 */
public abstract class StatementModel extends AbstractModel {

	public StatementModel(FileContext ctx) {
		super(ctx);
	}

}
