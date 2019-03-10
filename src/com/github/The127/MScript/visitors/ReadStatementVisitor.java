package com.github.The127.MScript.visitors;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.antlr.MScriptBaseVisitor;
import com.github.The127.MScript.antlr.MScriptParser.ReadBasicContext;
import com.github.The127.MScript.antlr.MScriptParser.ReadReagentContext;
import com.github.The127.MScript.antlr.MScriptParser.ReadSlotContext;
import com.github.The127.MScript.antlr.MScriptParser.ReadStatementContext;
import com.github.The127.MScript.models.impl.BasicReadStatementModel;
import com.github.The127.MScript.models.impl.ReadStatementModel;
import com.github.The127.MScript.models.impl.ReagentReadStatementModel;
import com.github.The127.MScript.models.impl.SlotReadStatementModel;

public class ReadStatementVisitor extends MScriptBaseVisitor<ReadStatementModel>{
	
	@Override
	public ReadStatementModel visitReadStatement(ReadStatementContext ctx) {
		if(ctx.readBasic() != null)
			return visitReadBasic(ctx.readBasic());
		
		else if(ctx.readReagent() != null)
				return visitReadReagent(ctx.readReagent());
		
		else if(ctx.readSlot() != null)
				return visitReadSlot(ctx.readSlot());
		
		else
			throw new MScriptCompilationException("Unknown read statement.", 
					new FileContext(ctx.getStart().getLine(), ctx.getText()));
	}
	
	@Override
	public ReadStatementModel visitReadBasic(ReadBasicContext ctx) {
		return new BasicReadStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.dev.getText(), ctx.target.getText(), ctx.id.getText());
	}
	
	@Override
	public ReadStatementModel visitReadReagent(ReadReagentContext ctx) {
		return new ReagentReadStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.dev.getText(), ctx.reagentMode.getText(), ctx.reagent.getText(), ctx.var.getText());
	}
	
	@Override
	public ReadStatementModel visitReadSlot(ReadSlotContext ctx) {
		return new SlotReadStatementModel(
				new FileContext(ctx.getStart().getLine(), ctx.getText()),
				ctx.dev.getText(), Integer.parseInt(ctx.slotNumber.getText()), ctx.target.getText(), ctx.var.getText());
	}
}
