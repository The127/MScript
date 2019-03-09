/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript;

import com.github.The127.MScript.rt.IFunctionOptimizer;
import com.github.The127.MScript.rt.NoFunctionOptimizer;

/**
 * This class represents the configuration of the MScrtip compiler.
 * @author Julian Baehr
 */
public class Configuration {

	private static IFunctionOptimizer functionOptimizer = new NoFunctionOptimizer();
	
	/**
	 * @return The configured function optimization algorithm. 
	 */
	public static IFunctionOptimizer getFunctionOptimizer() {
		return functionOptimizer;
	}
	
	/**
	 * Sets the function optimization algorithm.
	 * @param functionOptimizer The optimization algorithm to be used.
	 */
	static void setFunctionOptimizer(IFunctionOptimizer functionOptimizer) {
		Configuration.functionOptimizer = functionOptimizer;
	}
}
