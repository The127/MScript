package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.AssignmentStatementContext;
import com.github.The127.MScript.models.impl.AssignmentStatementModel;

public class AssignmentStatementVisitor extends MScriptBaseVisitor<AssignmentStatementModel>{

	@Override
	public AssignmentStatementModel visitAssignmentStatement(AssignmentStatementContext ctx) {
		var model = new AssignmentStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()), 
				ctx.Identifier().getText());
		
		model.setExpression(new ExpressionVisitor().visit(ctx.expression()));
		
		return model;
	}
}
