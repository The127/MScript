/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models;

/**
 * This interface defines the compilation/model api.
 * @author Julian Baehr
 */
public interface ICompilableModel {

	/**
	 * Compiles the model into an intermediate form where labels still have to be resolved.
	 * @param ctx The compilation context.
	 * @return A string representation of the model in an intermediate format.
	 */
	String compile(IScriptContext ctx);
}
