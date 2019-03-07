package com.github.The127.MScript.models;

import com.github.The127.MScript.FileContext;

public interface IFunctionContext {
	
	/**
	 * Converts a local variable name to the corresponding register.
	 * @param localName The name of the local variable.
	 * @return The register at which the variable is located.
	 */
	String getLocal(String localName, FileContext ctx);
	/**
	 * Converts a parameter name to the corresponding register.
	 * @param paramName The name of the function parameter.
	 * @return The register at which the parameter is located.
	 */
	String getParam(String paramName, FileContext ctx);
}
