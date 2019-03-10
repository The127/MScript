/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;

/**
 * This class represents an abstract read statement in the MScript language.
 * @author Julian Baehr
 */
public abstract class ReadStatementModel extends StatementModel {

	private final String device, target, variable;
	
	public ReadStatementModel(FileContext ctx, String device, String target, String variable) {
		super(ctx);
		this.device = device;
		this.target = target;
		this.variable = variable;
	}
	
	public String getDevice() {
		return device;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getVariable() {
		return variable;
	}
}
