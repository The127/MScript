package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.EvalExpressionContext;
import com.github.The127.MScript.antlr.MScriptParser.ExpressionContext;
import com.github.The127.MScript.antlr.MScriptParser.FunctionCallContext;
import com.github.The127.MScript.models.impl.ExpressionModel;

public class ExpressionVisitor extends MScriptBaseVisitor<ExpressionModel> {

	@Override
	public ExpressionModel visitExpression(ExpressionContext ctx) {
		if(ctx.functionCall() != null)
			return visitFunctionCall(ctx.functionCall());
		
		else if(ctx.evalExpression() != null)
			return visitEvalExpression(ctx.evalExpression());
		
		else
			throw new MScriptCompilationException("Unknown expression.", new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
	@Override
	public ExpressionModel visitFunctionCall(FunctionCallContext ctx) {
		return new FunctionCallVisitor().visit(ctx);
	}
	
	@Override
	public ExpressionModel visitEvalExpression(EvalExpressionContext ctx) {
		return new EvalExpressionVisitor().visit(ctx);
	}
}
