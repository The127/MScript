package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.FnCallStatementContext;
import com.github.The127.MScript.models.impl.FunctionCallStatementModel;

public class FnCallStatementVisitor extends MScriptBaseVisitor<FunctionCallStatementModel>{

	@Override
	public FunctionCallStatementModel visitFnCallStatement(FnCallStatementContext ctx) {
		var model = new FunctionCallStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setFunctionCall(new FunctionCallVisitor().visit(ctx.functionCall()));
		
		return model;
	}
}
