package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.Precedence3Context;
import com.github.The127.MScript.models.impl.Precedence3Model;

public class Precedence3Visitor extends MScriptBaseVisitor<Precedence3Model>{

	@Override
	public Precedence3Model visitPrecedence3(Precedence3Context ctx) {
		var model = new Precedence3Model(new FileContext(ctx.getStart().getLine(), ctx.getText()));

		var subModel = new Precedence4Visitor().visit(ctx.precedence4());
		model.setFirst(Precedence3Model.Operation.fromString(
								ctx.precedence3Operators().getText(), 
								model.getFileContext()), 
						subModel);
	
		return model;
	}
}
