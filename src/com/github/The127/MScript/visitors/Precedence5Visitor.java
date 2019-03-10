package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.Precedence5Context;
import com.github.The127.MScript.models.impl.Precedence5Model;

public class Precedence5Visitor extends MScriptBaseVisitor<Precedence5Model>{

	@Override
	public Precedence5Model visitPrecedence5(Precedence5Context ctx) {
		var model = new Precedence5Model(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		for(int i = 0; i < ctx.atom().size(); i++) {
			var subModel = new AtomVisitor().visit(ctx.atom(i));
			if(i == 0) {
				model.setFirst(subModel);
			}else {
				model.add(
						Precedence5Model.Operation.fromString(
								ctx.precedence5Operators(i-1).getText(), 
								model.getFileContext()), 
						subModel);
			}
		}
	
		return model;
	}
}
