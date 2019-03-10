package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.AtomContext;
import com.github.The127.MScript.models.impl.AtomModel;
import com.github.The127.MScript.models.impl.LiteralModel;
import com.github.The127.MScript.models.impl.ParanthesisModel;
import com.github.The127.MScript.models.impl.VariableModel;

public class AtomVisitor extends MScriptBaseVisitor<AtomModel>{

	@Override
	public AtomModel visitAtom(AtomContext ctx) {
		var fc = new FileContext(ctx.getStart().getLine(), ctx.getText());
		if(ctx.Number() != null)
			return new LiteralModel(fc, ctx.Number().getText());
		
		else if(ctx.variable() != null)
			return new VariableModel(fc, ctx.variable().getText());
		
		else if(ctx.expression() != null)
			return new ParanthesisModel(fc, new ExpressionVisitor().visit(ctx.expression()));
		
		else
			throw new MScriptCompilationException("Unknown atom.", fc);
	}
}
