package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.Precedence2Context;
import com.github.The127.MScript.models.impl.Precedence2Model;

public class Precedence2Visitor extends MScriptBaseVisitor<Precedence2Model>{

	@Override
	public Precedence2Model visitPrecedence2(Precedence2Context ctx) {
		var model = new Precedence2Model(new FileContext(ctx.getStart().getLine(), ctx.getText()));
	
		for(int i = 0; i < ctx.precedence3().size(); i++) {
			var subModel = new Precedence3Visitor().visit(ctx.precedence3(i));
			if(i == 0) {
				model.setFirst(subModel);
			}else {
				model.add(
						Precedence2Model.Operation.fromString(
								ctx.precedence2Operators(i-1).getText(), 
								model.getFileContext()), 
						subModel);
			}
		}
	
		return model;
	}
}
