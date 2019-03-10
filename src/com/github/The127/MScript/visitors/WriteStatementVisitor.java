package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.WriteStatementContext;
import com.github.The127.MScript.models.impl.WriteStatementModel;

public class WriteStatementVisitor extends MScriptBaseVisitor<WriteStatementModel>{

	@Override
	public WriteStatementModel visitWriteStatement(WriteStatementContext ctx) {
		return new WriteStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.dev.getText(), ctx.target.getText(), ctx.id.getText());
	}
}
