/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.ICompilableModel;

public abstract class AbstractModel implements ICompilableModel {

	private final FileContext fileContext;
	
	public AbstractModel(FileContext ctx) {
		this.fileContext = ctx;
	}
	
	public FileContext getFileContext() {
		return fileContext;
	}
	
	protected MScriptCompilationException compilerError(String msg) {
		return new MScriptCompilationException(msg, fileContext);
	}
}
