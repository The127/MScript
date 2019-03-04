// Generated from MScript.g4 by ANTLR 4.4

package com.github.The127.MScript.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MScriptParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(@NotNull MScriptParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull MScriptParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(@NotNull MScriptParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#sleepHardcoded}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleepHardcoded(@NotNull MScriptParser.SleepHardcodedContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(@NotNull MScriptParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence2Operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence2Operators(@NotNull MScriptParser.Precedence2OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(@NotNull MScriptParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence5Operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence5Operators(@NotNull MScriptParser.Precedence5OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#elifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStatement(@NotNull MScriptParser.ElifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull MScriptParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull MScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(@NotNull MScriptParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull MScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#sleepStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleepStatement(@NotNull MScriptParser.SleepStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(@NotNull MScriptParser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(@NotNull MScriptParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull MScriptParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence4Operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence4Operators(@NotNull MScriptParser.Precedence4OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#readReagent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadReagent(@NotNull MScriptParser.ReadReagentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(@NotNull MScriptParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#whileCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCondition(@NotNull MScriptParser.WhileConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#evalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvalExpression(@NotNull MScriptParser.EvalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(@NotNull MScriptParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence1Operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence1Operators(@NotNull MScriptParser.Precedence1OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(@NotNull MScriptParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(@NotNull MScriptParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(@NotNull MScriptParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence3Operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence3Operators(@NotNull MScriptParser.Precedence3OperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(@NotNull MScriptParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#sleepVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleepVar(@NotNull MScriptParser.SleepVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#fnBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnBody(@NotNull MScriptParser.FnBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull MScriptParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence5(@NotNull MScriptParser.Precedence5Context ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull MScriptParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#readBasic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadBasic(@NotNull MScriptParser.ReadBasicContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence4(@NotNull MScriptParser.Precedence4Context ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#fnCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnCallStatement(@NotNull MScriptParser.FnCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence3(@NotNull MScriptParser.Precedence3Context ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#thisIsFineStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisIsFineStatement(@NotNull MScriptParser.ThisIsFineStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#precedence2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence2(@NotNull MScriptParser.Precedence2Context ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull MScriptParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MScriptParser#readSlot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadSlot(@NotNull MScriptParser.ReadSlotContext ctx);
}