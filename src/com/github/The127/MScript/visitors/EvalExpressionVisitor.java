package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.EvalExpressionContext;
import com.github.The127.MScript.models.impl.EvalExpressionModel;

public class EvalExpressionVisitor extends MScriptBaseVisitor<EvalExpressionModel>{

	@Override
	public EvalExpressionModel visitEvalExpression(EvalExpressionContext ctx) {
		var model = new EvalExpressionModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		for(int i = 0; i < ctx.precedence2().size(); i++) {
			var subModel = new Precedence2Visitor().visit(ctx.precedence2(i));
			if(i == 0) {
				model.setFirst(subModel);
			}else {
				model.add(
						EvalExpressionModel.Operation.fromString(
								ctx.precedence1Operators(i-1).getText(), 
								model.getFileContext()), 
						subModel);
			}
		}
		
		return model;
	}
}
