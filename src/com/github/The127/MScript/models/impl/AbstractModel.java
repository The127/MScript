/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.ICompilableModel;

/**
 * This class represents the base class for all models.
 * @author Julian Baehr
 */
public abstract class AbstractModel implements ICompilableModel {

	private final FileContext fileContext;
	
	/**
	 * Creates a new <code>AbstractModel</code> instance with the given file context.
	 * @param ctx The file context of this model.
	 */
	public AbstractModel(FileContext ctx) {
		this.fileContext = ctx;
	}
	
	/**
	 * @return The file context of this model.
	 */
	public FileContext getFileContext() {
		return fileContext;
	}
	
	/**
	 * Creates a new 'local' compiler error. That is to say it uses the file context of this model to create the error.
	 * @param msg The error message.
	 * @return A new compiler error with the provided message and the file context of this model.
	 */
	protected MScriptCompilationException compilerError(String msg) {
		return new MScriptCompilationException(msg, fileContext);
	}
}
