package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.SleepHardcodedContext;
import com.github.The127.MScript.antlr.MScriptParser.SleepStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.SleepVarContext;
import com.github.The127.MScript.models.impl.SleepStatementModel;

public class SleepStatementVisitor extends MScriptBaseVisitor<SleepStatementModel>{

	@Override
	public SleepStatementModel visitSleepStatement(SleepStatementContext ctx) {
		if(ctx.sleepHardcoded() != null)
			return visitSleepHardcoded(ctx.sleepHardcoded());
		
		else if(ctx.sleepVar() != null)
			return visitSleepVar(ctx.sleepVar());
		
		else
			throw new MScriptCompilationException("Unknown sleep statement.", new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
	@Override
	public SleepStatementModel visitSleepHardcoded(SleepHardcodedContext ctx) {
		var model = new SleepStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setNumber(Double.parseDouble(ctx.Number().getText()));
		
		return model;
	}
	
	@Override
	public SleepStatementModel visitSleepVar(SleepVarContext ctx) {
		var model = new SleepStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()));
		
		model.setExpression(new ExpressionVisitor().visit(ctx.expression()));
		
		return model;
	}
}
