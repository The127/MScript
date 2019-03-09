/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.rt;

/**
 * This class implements the default function optimization which is no optimization. 
 * @author Julian Baehr
 */
public class NoFunctionOptimizer implements IFunctionOptimizer {

	@Override
	public String optimize(String pseudoCompiledFunction) {
		return pseudoCompiledFunction;
	}
}
