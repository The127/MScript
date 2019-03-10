package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ScriptContext;
import com.github.The127.MScript.models.impl.ScriptModel;

public class ScriptVisitor extends MScriptBaseVisitor<ScriptModel> {

	@Override
	public ScriptModel visitScript(ScriptContext ctx) {
		var model = new ScriptModel();
		
		for(var alias : ctx.alias()) {
			// TODO: update grammar first
			// check if device type is provided
				// check if device type exists
					// throw error if not
			model.addAlias(alias.Identifier().getText(),
					alias.Device().getText(),
					new FileContext(alias.getStart().getLine(), alias.getText()));
		}
		
		for(var constant : ctx.constant()) {
			model.addConst(constant.Const().getText(),
					Double.parseDouble(constant.Number().getText()),
					new FileContext(constant.getStart().getLine(), constant.getText()));
		}
		
		for(var fn : ctx.function()) {
			// use function visitor to handle the function
			model.addFunction(new FunctionVisitor().visit(fn));
		}
		
		return model;
	}
}
