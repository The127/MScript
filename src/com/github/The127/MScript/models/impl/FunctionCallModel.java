/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class FunctionCallModel extends ExpressionModel {

	private final String name;
	private List<ExpressionModel> args = new LinkedList<>();
	
	public FunctionCallModel(FileContext ctx, String name) {
		super(ctx);
		this.name = name;
	}
	
	public void addArg(ExpressionModel arg) {
		if(args.size() >= FunctionModel.MAX_PARAMS)
			throw new MScriptCompilationException("Too many funciton parameters. Only " + FunctionModel.MAX_PARAMS + " are allowed.", arg.getFileContext());
		args.add(arg);
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append("jal ").append(MScriptRuntime.destGotoLabel("__push_regs")).append(System.lineSeparator());
		
		for(var arg : args)
			sb.append(arg.compile(ctx));
		if(args.size() > 0)
			sb.append(MScriptRuntime.destGotoLabel("__pop_params_" + args.size()));
		
		sb.append("jal ").append(MScriptRuntime.destFunctionLabel(name)).append(System.lineSeparator());
		sb.append("jal ").append(MScriptRuntime.destGotoLabel("__pop_regs")).append(System.lineSeparator());
		return sb.toString();
	}

}
