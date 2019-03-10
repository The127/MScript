package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ArgsContext;
import com.github.The127.MScript.antlr.MScriptParser.FunctionCallContext;
import com.github.The127.MScript.models.impl.FunctionCallModel;

public class FunctionCallVisitor extends MScriptBaseVisitor<FunctionCallModel>{

	private FunctionCallModel model;
	
	@Override
	public FunctionCallModel visitFunctionCall(FunctionCallContext ctx) {
		model = new FunctionCallModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.Identifier().getText());
		
		visitArgs(ctx.args());
		
		return model;
	}
	
	@Override
	public FunctionCallModel visitArgs(ArgsContext ctx) {
		for(var expression : ctx.expression())
			model.addArg(new ExpressionVisitor().visit(expression));
		return null;
	}
}
