/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript;

import java.util.Objects;

public final class FileContext {
	
	private static final int NEAR_TEXT_MAX_LENGTH = 50;
	
	private final int line;
	private final String near;
	
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
