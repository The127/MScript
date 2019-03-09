/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.rt;

// default optimizer is no optimizer
public class NoFunctionOptimizer implements IFunctionOptimizer {

	@Override
	public String optimize(String pseudoCompiledFunction) {
		return pseudoCompiledFunction;
	}
}
