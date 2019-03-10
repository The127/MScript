package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.LoopStatementContext;
import com.github.The127.MScript.models.impl.LoopStatementModel;

public class LoopStatementVisitor extends MScriptBaseVisitor<LoopStatementModel>{

	@Override
	public LoopStatementModel visitLoopStatement(LoopStatementContext ctx) {
		var model = new LoopStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		if(ctx.whileCondition() != null)
			model.setCondition(new ExpressionVisitor().visit(ctx.whileCondition().expression()));
		
		model.setBlock(new BlockVisitor().visit(ctx.block()));
		
		return model;
	}
}
