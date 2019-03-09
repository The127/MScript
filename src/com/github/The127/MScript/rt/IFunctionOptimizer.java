/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.rt;

/**
 * This interface defines the function optimization api.
 * @author Julian Baehr
 */
public interface IFunctionOptimizer {

	/**
	 * Optimizes the provided intermediate compiled function.
	 * @param pseudoCompiledFunction The intermediate compiled function code.
	 * @return An optimized intermediate function source code.
	 */
	String optimize(String pseudoCompiledFunction);
}
