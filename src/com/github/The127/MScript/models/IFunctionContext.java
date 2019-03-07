package com.github.The127.MScript.models;

import com.github.The127.MScript.FileContext;

public interface IFunctionContext {
	
	/**
	 * Converts a local variable name to the corresponding register.
	 * @param variableName The name of the local variable or parameter.
	 * @return The register at which the variable is located.
	 */
	String resolveRegister(String variableName, FileContext ctx);
}
