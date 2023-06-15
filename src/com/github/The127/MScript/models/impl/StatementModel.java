/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;

/**
 * This class represents an abstract statement in the MScript language.
 * @author Karolin Kostial
 */
public abstract class StatementModel extends AbstractModel {

	public StatementModel(FileContext ctx) {
		super(ctx);
	}

}
