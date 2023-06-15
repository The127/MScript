/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript;

/**
 * This class represents a compilation error. 
 * @author Karolin Kostial
 */
@SuppressWarnings("serial")
public class MScriptCompilationException extends RuntimeException {

	/**
	 * Creates a new compilation error with the specified message.
	 * The error will automatically output the file context for better debugging.
	 * @param msg The error message.
	 * @param ctx The file context of the error.
	 */
	public MScriptCompilationException(String msg, FileContext ctx) {
		super(msg + System.lineSeparator() + "Near: " + ctx.toString());
	}
	
	/**
	 * Creates a new general compilation error without a file context.
	 * @param msg The error message.
	 */
	public MScriptCompilationException(String msg) {
		super(msg);
	}
}
