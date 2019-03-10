package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.BlockContext;
import com.github.The127.MScript.models.impl.BlockModel;

public class BlockVisitor extends MScriptBaseVisitor<BlockModel> {

	@Override
	public BlockModel visitBlock(BlockContext ctx) {
		var model = new BlockModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		for(var stmt : ctx.statement())
			model.addStatement(new StatementVisitor().visit(stmt));
		
		return model;
	}
}
