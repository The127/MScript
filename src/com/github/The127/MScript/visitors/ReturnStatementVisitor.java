package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ReturnStatementContext;
import com.github.The127.MScript.models.impl.ReturnStatementModel;

public class ReturnStatementVisitor extends MScriptBaseVisitor<ReturnStatementModel>{

	@Override
	public ReturnStatementModel visitReturnStatement(ReturnStatementContext ctx) {
		var model = new ReturnStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		if(ctx.expression() != null)
			model.setExpression(new ExpressionVisitor().visit(ctx.expression()));
		
		return model;
	}
}
