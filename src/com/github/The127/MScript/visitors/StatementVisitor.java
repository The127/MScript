package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.AssignmentStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.ConditionalStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.FnCallStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.LoopStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.ReadStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.ReturnStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.SleepStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.StatementContext;
import com.github.The127.MScript.antlr.MScriptParser.ThisIsFineStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.WriteStatementContext;
import com.github.The127.MScript.antlr.MScriptParser.YieldStatementContext;
import com.github.The127.MScript.models.impl.StatementModel;
import com.github.The127.MScript.models.impl.ThisIsFineStatementModel;
import com.github.The127.MScript.models.impl.YieldStatementModel;

public class StatementVisitor extends MScriptBaseVisitor<StatementModel>{

	@Override
	public StatementModel visitStatement(StatementContext ctx) {
		if(ctx.loopStatement() != null)
			return visitLoopStatement(ctx.loopStatement());
		
		else if(ctx.conditionalStatement() != null)
			return visitConditionalStatement(ctx.conditionalStatement());
		
		else if(ctx.assignmentStatement() != null)
			return visitAssignmentStatement(ctx.assignmentStatement());
		
		else if(ctx.readStatement() != null)
			return visitReadStatement(ctx.readStatement());
		
		else if(ctx.writeStatement() != null)
			return visitWriteStatement(ctx.writeStatement());
		
		else if(ctx.yieldStatement() != null)
			return visitYieldStatement(ctx.yieldStatement());
		
		else if(ctx.sleepStatement() != null)
			return visitSleepStatement(ctx.sleepStatement());
		
		else if(ctx.returnStatement() != null)
			return visitReturnStatement(ctx.returnStatement());
		
		else if(ctx.fnCallStatement() != null)
			return visitFnCallStatement(ctx.fnCallStatement());
		
		else if(ctx.thisIsFineStatement() != null)
			return visitThisIsFineStatement(ctx.thisIsFineStatement());
		
		else
			throw new MScriptCompilationException("Unknown statement.", 
					new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
	@Override
	public StatementModel visitLoopStatement(LoopStatementContext ctx) {
		return new LoopStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitConditionalStatement(ConditionalStatementContext ctx) {
		return new ConditionalStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitAssignmentStatement(AssignmentStatementContext ctx) {
		return new AssignmentStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitReadStatement(ReadStatementContext ctx) {
		return new ReadStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitWriteStatement(WriteStatementContext ctx) {
		return new WriteStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitYieldStatement(YieldStatementContext ctx) {
		return new YieldStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
	@Override
	public StatementModel visitSleepStatement(SleepStatementContext ctx) {
		return new SleepStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitReturnStatement(ReturnStatementContext ctx) {
		return new ReturnStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitFnCallStatement(FnCallStatementContext ctx) {
		return new FnCallStatementVisitor().visit(ctx);
	}
	
	@Override
	public StatementModel visitThisIsFineStatement(ThisIsFineStatementContext ctx) {
		return new ThisIsFineStatementModel(new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
}
