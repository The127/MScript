/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models;

import com.github.The127.MScript.FileContext;

/**
 * This interface defines what compilation context is to be provided by the current compiled function.
 * @author Karolin Kostial
 */
public interface IFunctionContext {
	
	/**
	 * Converts a local variable name to the corresponding register.
	 * @param variableName The name of the local variable or parameter.
	 * @param ctx The file context of the access to the variable or parameter for error handling.
	 * @return The register at which the variable is located.
	 */
	String resolveRegister(String variableName, FileContext ctx);
}
