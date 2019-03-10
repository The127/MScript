package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.Precedence4Context;
import com.github.The127.MScript.models.impl.Precedence4Model;

public class Precedence4Visitor extends MScriptBaseVisitor<Precedence4Model>{

	@Override
	public Precedence4Model visitPrecedence4(Precedence4Context ctx) {
		var model = new Precedence4Model(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		for(int i = 0; i < ctx.precedence5().size(); i++) {
			var subModel = new Precedence5Visitor().visit(ctx.precedence5(i));
			if(i == 0) {
				model.setFirst(subModel);
			}else {
				model.add(
						Precedence4Model.Operation.fromString(
								ctx.precedence4Operators(i-1).getText(), 
								model.getFileContext()), 
						subModel);
			}
		}
	
		return model;
	}
}
