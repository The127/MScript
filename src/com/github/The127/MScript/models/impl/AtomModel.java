/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;

/**
 * This class represents the smallest unit (literal, variable) or a paranthesis expression in the MScript language.
 * @author Karolin Kostial
 */
public abstract class AtomModel extends AbstractModel {
	
	public AtomModel(FileContext ctx) {
		super(ctx);
	}
}
