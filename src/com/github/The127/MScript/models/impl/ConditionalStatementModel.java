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
	
	private final String label = "__conditional__" + MScriptRuntime.generateLabelName();
	
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
	}
	
	public void setElseStatement(ElseStatementModel elseStatement) {
		this.elseStatement = elseStatement;
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append(condition.compile(ctx));
		sb.append("jal ").append(MScriptRuntime.destGotoLabel("__round")).append(System.lineSeparator());
		sb.append("bne r12 0 ").append(MScriptRuntime.destGotoLabel(label)).append(System.lineSeparator());
		sb.append(block.compile(ctx));
		
		return sb.toString();
	}

}
