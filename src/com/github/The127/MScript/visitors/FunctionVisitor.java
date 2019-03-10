package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.FnBodyContext;
import com.github.The127.MScript.antlr.MScriptParser.FunctionContext;
import com.github.The127.MScript.antlr.MScriptParser.ParamsContext;
import com.github.The127.MScript.antlr.MScriptParser.VarDeclarationContext;
import com.github.The127.MScript.models.impl.FunctionModel;

public class FunctionVisitor extends MScriptBaseVisitor<FunctionModel> {

	private FunctionModel model;
	
	@Override
	public FunctionModel visitFunction(FunctionContext ctx) {
		model = new FunctionModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.Identifier().getText());
		
		// arguments
		visitParams(ctx.params());
		visitFnBody(ctx.fnBody());
		
		return model;
	}
	
	@Override
	public FunctionModel visitParams(ParamsContext ctx) {
		for(var param : ctx.Identifier()) {
			model.addParam(param.getText(), 
					new FileContext(ctx.getStart().getLine(), ctx.getText()));
		}
		return null;
	}
	
	@Override
	public FunctionModel visitFnBody(FnBodyContext ctx) {
		for(var varDecl : ctx.varDeclaration())
			visitVarDeclaration(varDecl);
		for(var stmt : ctx.statement())
			model.addStatement(new StatementVisitor().visit(stmt));
		return null;
	}
	
	@Override
	public FunctionModel visitVarDeclaration(VarDeclarationContext ctx) {
		for(var local : ctx.Identifier())
			model.addLocal(local.getText(), 
					new FileContext(ctx.getStart().getLine(), ctx.getText()));
		return null;
	}
}
