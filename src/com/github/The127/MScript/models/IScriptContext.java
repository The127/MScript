/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models;

import com.github.The127.MScript.FileContext;

/**
 * This interface defines the script/compile context api.
 * @author Julian Baehr
 */
public interface IScriptContext extends IFunctionContext {

	/**
	 * Resolves a device alias into a basic device name.
	 * @param alias The device alias.
	 * @param ctx The file context of the access to the device alias for error handling.
	 * @return The basic name of the device.
	 */
	String resolveAlias(String alias, FileContext ctx);

	/**
	 * Resolves a constant to its value.
	 * @param name The name of the constant.
	 * @param ctx The file context of the access to the constant for error handling.
	 * @return The value of the constant.
	 */
	double resolverConst(String name, FileContext ctx);

	/**
	 * Checks if a function (excluding the main function) exists.
	 * @param name The function name to check.
	 * @return True if the function exists.
	 */
	boolean doesFunctionExist(String name);
	
	/**
	 * @param name The name of the function.
	 * @return The parameter count for that function.
	 */
	int getFunctionParameterCount(String name);
}
