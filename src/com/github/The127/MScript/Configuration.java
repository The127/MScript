/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript;

import com.github.The127.MScript.rt.IFunctionOptimizer;
import com.github.The127.MScript.rt.NoFunctionOptimizer;

public class Configuration {

	private static IFunctionOptimizer functionOptimizer = new NoFunctionOptimizer();
	
	public static IFunctionOptimizer getFunctionOptimizer() {
		return functionOptimizer;
	}
	
	static void setFunctionOptimizer(IFunctionOptimizer functionOptimizer) {
		Configuration.functionOptimizer = functionOptimizer;
	}
}
