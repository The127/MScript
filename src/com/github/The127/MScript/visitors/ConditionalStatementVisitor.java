package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ConditionalStatementContext;
import com.github.The127.MScript.models.impl.ConditionalStatementModel;

public class ConditionalStatementVisitor extends MScriptBaseVisitor<ConditionalStatementModel>{

	@Override
	public ConditionalStatementModel visitConditionalStatement(ConditionalStatementContext ctx) {
		var model = new ConditionalStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setCondition(new ExpressionVisitor().visit(ctx.expression()));
		model.setBlock(new BlockVisitor().visit(ctx.block()));
		
		for(var elif : ctx.elifStatement())
			model.addElifStatement(new ElifStatementVisitor().visit(elif));
		
		if(ctx.elseStatement() != null)
			model.setElseStatement(new ElseStatementVisitor().visit(ctx.elseStatement()));
		
		return model;
	}
}
