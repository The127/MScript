/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models;

import com.github.The127.MScript.FileContext;

public interface IScriptContext extends IFunctionContext {

	/**
	 * Resolves a device alias into a basic device name.
	 * @param alias The device alias.
	 * @return The basic name of the device.
	 */
	String resolveAlias(String alias, FileContext ctx);

	double resolverConst(String name, FileContext ctx);
}
