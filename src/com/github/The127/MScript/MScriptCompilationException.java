/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript;

@SuppressWarnings("serial")
public class MScriptCompilationException extends RuntimeException {

	public MScriptCompilationException(String msg, FileContext ctx) {
		super(msg + System.lineSeparator() + "Near: " + ctx.toString());
	}
	
	public MScriptCompilationException(String msg) {
		super(msg);
	}
}
