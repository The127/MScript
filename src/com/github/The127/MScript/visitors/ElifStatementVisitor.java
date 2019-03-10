package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ElifStatementContext;
import com.github.The127.MScript.models.impl.ElifStatementModel;

public class ElifStatementVisitor extends MScriptBaseVisitor<ElifStatementModel> {

	@Override
	public ElifStatementModel visitElifStatement(ElifStatementContext ctx) {
		var model = new ElifStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setCondition(new ExpressionVisitor().visit(ctx.expression()));
		model.setBlock(new BlockVisitor().visit(ctx.block()));
		
		return model;
	}
}
