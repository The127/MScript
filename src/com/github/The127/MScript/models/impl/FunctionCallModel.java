/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

/**
 * This class represents a function call expression in the MScript language.
 * @author Julian Baehr
 */
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
		
		// check if rt function or not
		if(MScriptRuntime.isRtFunctionName(name)) {
			// handle rt function (cheaper to call)
			
			// check argument count
			if(args.size() != MScriptRuntime.getParametersForRtFunction(name, getFileContext())) 
				throw compilerError("False argument count for runtime function '" + name + "'. Got " + args.size() + ", expected " + MScriptRuntime.getParametersForRtFunction(name, getFileContext()) + ".");
			for(var arg : args)
				sb.append(arg.compile(ctx));
			sb.append("jal ").append(MScriptRuntime.destGotoLabel("__" + name));
		}else {
			// check if function exists (main excluded)
			if(!ctx.doesFunctionExist(name))
				throw compilerError("Unknown function '" + name + "'.");
			
			// handle actual function call
			sb.append("jal ").append(MScriptRuntime.destGotoLabel("__push_regs")).append(System.lineSeparator());
			
			// check argument count
			if(args.size() != ctx.getFunctionParameterCount(name)) 
				throw compilerError("False argument count for function '" + name + "'. Got " + args.size() + ", expected " + ctx.getFunctionParameterCount(name) + ".");
			
			for(var arg : args)
				sb.append(arg.compile(ctx));
			if(args.size() > 0)
				sb.append("jal ").append(MScriptRuntime.destGotoLabel("__pop_params_" + args.size())).append(System.lineSeparator());
			
			sb.append("jal ").append(MScriptRuntime.destFunctionLabel(name)).append(System.lineSeparator());
			sb.append("jal ").append(MScriptRuntime.destGotoLabel("__pop_regs")).append(System.lineSeparator());
		}
		return sb.toString();
	}

}
