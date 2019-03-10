/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;

/**
 * This class represents a slot read statement in the MScript language.
 * @author Julian Baehr
 */
public class SlotReadStatementModel extends ReadStatementModel {

	private final int slotNumber;
	
	public SlotReadStatementModel(FileContext ctx, String device, int slotNumber, String target, String variable) {
		super(ctx, device, target, variable);
		this.slotNumber = slotNumber;
	}
	
	public int getSlotNumber() {
		return slotNumber;
	}

	@Override
	public String compile(IScriptContext ctx) {
		return "ls"
				+ " " + ctx.resolveRegister(getVariable(), getFileContext()) 
				+ " " + ctx.resolveAlias(getDevice(), getFileContext())
				+ " " + getSlotNumber()
				+ " " + getTarget()
				+ System.lineSeparator();
	}

}
