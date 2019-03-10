package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ElseStatementContext;
import com.github.The127.MScript.models.impl.ElseStatementModel;

public class ElseStatementVisitor extends MScriptBaseVisitor<ElseStatementModel>{

	@Override
	public ElseStatementModel visitElseStatement(ElseStatementContext ctx) {
		var model = new ElseStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setBlock(new BlockVisitor().visit(ctx.block()));
		
		return model;
	}
}
