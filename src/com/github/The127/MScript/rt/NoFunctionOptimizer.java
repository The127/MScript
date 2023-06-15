/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.rt;

/**
 * This class implements the default function optimization which is no optimization. 
 * @author Karolin Kostial
 */
public class NoFunctionOptimizer implements IFunctionOptimizer {

	@Override
	public String optimize(String pseudoCompiledFunction) {
		return pseudoCompiledFunction;
	}
}
