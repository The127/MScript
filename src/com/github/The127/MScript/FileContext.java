/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript;

import java.util.Objects;

/**
 * This class represents the file context of a model.
 * This can be used to generate helpfull error messages or debugging instructions.
 * @author Julian Baehr
 */
public final class FileContext {
	
	private static final int NEAR_TEXT_MAX_LENGTH = 50;
	
	private final int line;
	private final String near;
	
	/**
	 * Creates a new <code>FileContext</code> instance.
	 * @param line The line in the source file.
	 * @param text The text of the model.
	 */
	public FileContext(int line, String text) {
		Objects.requireNonNull(text);
		this.line = line;
		// substring if provided text is too long
		if(text.length() <= NEAR_TEXT_MAX_LENGTH)
			this.near = text;
		else
			this.near = text.substring(0, NEAR_TEXT_MAX_LENGTH);
	}
	
	@Override
	public String toString() {
		return "line " + line + ", '" + near + "'";
	}
}
