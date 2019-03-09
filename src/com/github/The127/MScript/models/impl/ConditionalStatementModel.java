/**
 * MIT License
 * Copyright (c) 2019 Julian Bähr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class ConditionalStatementModel extends StatementModel  {

	private List<ElifStatementModel> elifStatements = new LinkedList<>();
	private ElseStatementModel elseStatement;
	
	private ExpressionModel condition;
	private BlockModel block;
	
	private final String label = "__conditionalIf__" + MScriptRuntime.generateLabelName();
	private final String end = "__conditionalEnd__" + MScriptRuntime.generateLabelName();
	
	public ConditionalStatementModel(FileContext ctx) {
		super(ctx);
	}
	
	public void setCondition(ExpressionModel condition) {
		this.condition = condition;
	}
	
	public void setBlock(BlockModel block) {
		this.block = block;
	}
	
	public void addElifStatement(ElifStatementModel elifStatement) {
		elifStatements.add(elifStatement);
		elifStatement.setEnd(end);
	}
	
	public void setElseStatement(ElseStatementModel elseStatement) {
		this.elseStatement = elseStatement;
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append(condition.compile(ctx));
		// read condition result into r12
		sb.append("pop r12").append(System.lineSeparator());
		// round to nearest int
		sb.append("round r12 r12").append(System.lineSeparator());
		// if is false jump to end of block
		sb.append("beq r12 0 ").append(MScriptRuntime.destGotoLabel(label)).append(System.lineSeparator());
		sb.append(block.compile(ctx));
		// if block executes jump to end of if-elif-else
		sb.append("j ").append(MScriptRuntime.destGotoLabel(end)).append(System.lineSeparator());
		// mark end of block
		sb.append(MScriptRuntime.sourceGotoLabel(label)).append(System.lineSeparator());
		
		for(var elif : elifStatements)
			sb.append(elif.compile(ctx));
		
		if(elseStatement != null)
			sb.append(elseStatement.compile(ctx));
		
		// mark end of if
		sb.append(MScriptRuntime.sourceGotoLabel(end)).append(System.lineSeparator());
		
		return sb.toString();
	}

}
