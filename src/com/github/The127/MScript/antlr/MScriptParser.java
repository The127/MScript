// Generated from MScript.g4 by ANTLR 4.4

package com.github.The127.MScript.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__42=1, T__41=2, T__40=3, T__39=4, T__38=5, T__37=6, T__36=7, T__35=8, 
		T__34=9, T__33=10, T__32=11, T__31=12, T__30=13, T__29=14, T__28=15, T__27=16, 
		T__26=17, T__25=18, T__24=19, T__23=20, T__22=21, T__21=22, T__20=23, 
		T__19=24, T__18=25, T__17=26, T__16=27, T__15=28, T__14=29, T__13=30, 
		T__12=31, T__11=32, T__10=33, T__9=34, T__8=35, T__7=36, T__6=37, T__5=38, 
		T__4=39, T__3=40, T__2=41, T__1=42, T__0=43, Number=44, Integer=45, Device=46, 
		Const=47, Identifier=48, BLOCK_COMMENT=49, LINE_COMMENT=50, WS=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'fine'", "'as'", "'def'", "'return'", "'!='", "'slot'", 
		"'reagent'", "'while'", "'{'", "';'", "'='", "'}'", "'^'", "'if'", "'<='", 
		"'&'", "'sleep'", "'('", "'is'", "'yield'", "'*'", "'this'", "','", "'.'", 
		"'var'", "'write'", "'>='", "'=='", "'<'", "'|'", "'elif'", "'>'", "'loop'", 
		"'!'", "'fn'", "'%'", "'into'", "'read'", "'else'", "')'", "'+'", "'-'", 
		"Number", "Integer", "Device", "Const", "Identifier", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final int
		RULE_script = 0, RULE_alias = 1, RULE_constant = 2, RULE_function = 3, 
		RULE_params = 4, RULE_fnBody = 5, RULE_varDeclaration = 6, RULE_statement = 7, 
		RULE_loopStatement = 8, RULE_whileCondition = 9, RULE_conditionalStatement = 10, 
		RULE_elifStatement = 11, RULE_elseStatement = 12, RULE_assignmentStatement = 13, 
		RULE_readStatement = 14, RULE_readBasic = 15, RULE_readReagent = 16, RULE_readSlot = 17, 
		RULE_writeStatement = 18, RULE_yieldStatement = 19, RULE_sleepStatement = 20, 
		RULE_sleepHardcoded = 21, RULE_sleepVar = 22, RULE_returnStatement = 23, 
		RULE_thisIsFineStatement = 24, RULE_fnCallStatement = 25, RULE_block = 26, 
		RULE_expression = 27, RULE_functionCall = 28, RULE_args = 29, RULE_evalExpression = 30, 
		RULE_precedence1Operators = 31, RULE_precedence2 = 32, RULE_precedence2Operators = 33, 
		RULE_precedence3 = 34, RULE_precedence3Operators = 35, RULE_precedence4 = 36, 
		RULE_precedence4Operators = 37, RULE_precedence5 = 38, RULE_precedence5Operators = 39, 
		RULE_atom = 40, RULE_variable = 41;
	public static final String[] ruleNames = {
		"script", "alias", "constant", "function", "params", "fnBody", "varDeclaration", 
		"statement", "loopStatement", "whileCondition", "conditionalStatement", 
		"elifStatement", "elseStatement", "assignmentStatement", "readStatement", 
		"readBasic", "readReagent", "readSlot", "writeStatement", "yieldStatement", 
		"sleepStatement", "sleepHardcoded", "sleepVar", "returnStatement", "thisIsFineStatement", 
		"fnCallStatement", "block", "expression", "functionCall", "args", "evalExpression", 
		"precedence1Operators", "precedence2", "precedence2Operators", "precedence3", 
		"precedence3Operators", "precedence4", "precedence4Operators", "precedence5", 
		"precedence5Operators", "atom", "variable"
	};

	@Override
	public String getGrammarFileName() { return "MScript.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public List<AliasContext> alias() {
			return getRuleContexts(AliasContext.class);
		}
		public AliasContext alias(int i) {
			return getRuleContext(AliasContext.class,i);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitScript(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84); alias();
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(90); constant();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(96); function();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public TerminalNode Device() { return getToken(MScriptParser.Device, 0); }
		public TerminalNode Identifier() { return getToken(MScriptParser.Identifier, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(T__39);
			setState(103); match(Device);
			setState(104); match(T__40);
			setState(105); match(Identifier);
			setState(106); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MScriptParser.Number, 0); }
		public TerminalNode Const() { return getToken(MScriptParser.Const, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(T__39);
			setState(109); match(Const);
			setState(110); match(T__40);
			setState(111); match(Number);
			setState(112); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MScriptParser.Identifier, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FnBodyContext fnBody() {
			return getRuleContext(FnBodyContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(T__7);
			setState(115); match(Identifier);
			setState(116); match(T__24);
			setState(118);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(117); params();
				}
			}

			setState(120); match(T__2);
			setState(121); fnBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(Identifier);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(124); match(T__19);
				setState(125); match(Identifier);
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnBodyContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public FnBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitFnBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnBodyContext fnBody() throws RecognitionException {
		FnBodyContext _localctx = new FnBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(T__33);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(132); varDeclaration();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__28) | (1L << T__25) | (1L << T__22) | (1L << T__20) | (1L << T__16) | (1L << T__9) | (1L << T__4) | (1L << Identifier))) != 0)) {
				{
				{
				setState(138); statement();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(T__17);
			setState(147); match(Identifier);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(148); match(T__19);
				setState(149); match(Identifier);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public YieldStatementContext yieldStatement() {
			return getRuleContext(YieldStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public ThisIsFineStatementContext thisIsFineStatement() {
			return getRuleContext(ThisIsFineStatementContext.class,0);
		}
		public FnCallStatementContext fnCallStatement() {
			return getRuleContext(FnCallStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public SleepStatementContext sleepStatement() {
			return getRuleContext(SleepStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); loopStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); conditionalStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159); assignmentStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160); readStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161); writeStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162); yieldStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(163); sleepStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(164); returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(165); fnCallStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(166); thisIsFineStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public WhileConditionContext whileCondition() {
			return getRuleContext(WhileConditionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_loopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(T__9);
			setState(171);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(170); whileCondition();
				}
			}

			setState(173); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitWhileCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileConditionContext whileCondition() throws RecognitionException {
		WhileConditionContext _localctx = new WhileConditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(T__34);
			setState(176); match(T__24);
			setState(177); expression();
			setState(178); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalStatementContext extends ParserRuleContext {
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElifStatementContext elifStatement(int i) {
			return getRuleContext(ElifStatementContext.class,i);
		}
		public List<ElifStatementContext> elifStatement() {
			return getRuleContexts(ElifStatementContext.class);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_conditionalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(T__28);
			setState(181); match(T__24);
			setState(182); expression();
			setState(183); match(T__2);
			setState(184); block();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(185); elifStatement();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(191); elseStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElifStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitElifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifStatementContext elifStatement() throws RecognitionException {
		ElifStatementContext _localctx = new ElifStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(T__11);
			setState(195); match(T__24);
			setState(196); expression();
			setState(197); match(T__2);
			setState(198); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(T__3);
			setState(201); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MScriptParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(Identifier);
			setState(204); match(T__31);
			setState(205); expression();
			setState(206); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadStatementContext extends ParserRuleContext {
		public ReadReagentContext readReagent() {
			return getRuleContext(ReadReagentContext.class,0);
		}
		public ReadBasicContext readBasic() {
			return getRuleContext(ReadBasicContext.class,0);
		}
		public ReadSlotContext readSlot() {
			return getRuleContext(ReadSlotContext.class,0);
		}
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitReadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_readStatement);
		try {
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208); readBasic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); readReagent();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210); readSlot();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadBasicContext extends ParserRuleContext {
		public Token dev;
		public Token target;
		public Token id;
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public ReadBasicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readBasic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitReadBasic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadBasicContext readBasic() throws RecognitionException {
		ReadBasicContext _localctx = new ReadBasicContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_readBasic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(T__4);
			setState(214); ((ReadBasicContext)_localctx).dev = match(Identifier);
			setState(215); match(T__18);
			setState(216); ((ReadBasicContext)_localctx).target = match(Identifier);
			setState(217); match(T__5);
			setState(218); ((ReadBasicContext)_localctx).id = match(Identifier);
			setState(219); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadReagentContext extends ParserRuleContext {
		public Token dev;
		public Token reagentMode;
		public Token reagent;
		public Token var;
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public ReadReagentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readReagent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitReadReagent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadReagentContext readReagent() throws RecognitionException {
		ReadReagentContext _localctx = new ReadReagentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_readReagent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(T__4);
			setState(222); match(T__35);
			setState(223); ((ReadReagentContext)_localctx).dev = match(Identifier);
			setState(224); match(T__18);
			setState(225); ((ReadReagentContext)_localctx).reagentMode = match(Identifier);
			setState(226); match(T__18);
			setState(227); ((ReadReagentContext)_localctx).reagent = match(Identifier);
			setState(228); match(T__5);
			setState(229); ((ReadReagentContext)_localctx).var = match(Identifier);
			setState(230); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadSlotContext extends ParserRuleContext {
		public Token dev;
		public Token slotNumber;
		public Token target;
		public Token var;
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public TerminalNode Integer() { return getToken(MScriptParser.Integer, 0); }
		public ReadSlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readSlot; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitReadSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadSlotContext readSlot() throws RecognitionException {
		ReadSlotContext _localctx = new ReadSlotContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_readSlot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(T__4);
			setState(233); match(T__36);
			setState(234); ((ReadSlotContext)_localctx).dev = match(Identifier);
			setState(235); match(T__18);
			setState(236); ((ReadSlotContext)_localctx).slotNumber = match(Integer);
			setState(237); match(T__18);
			setState(238); ((ReadSlotContext)_localctx).target = match(Identifier);
			setState(239); match(T__5);
			setState(240); ((ReadSlotContext)_localctx).var = match(Identifier);
			setState(241); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteStatementContext extends ParserRuleContext {
		public Token id;
		public Token dev;
		public Token target;
		public List<TerminalNode> Identifier() { return getTokens(MScriptParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MScriptParser.Identifier, i);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_writeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(T__16);
			setState(244); ((WriteStatementContext)_localctx).id = match(Identifier);
			setState(245); match(T__5);
			setState(246); ((WriteStatementContext)_localctx).dev = match(Identifier);
			setState(247); match(T__18);
			setState(248); ((WriteStatementContext)_localctx).target = match(Identifier);
			setState(249); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class YieldStatementContext extends ParserRuleContext {
		public YieldStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitYieldStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldStatementContext yieldStatement() throws RecognitionException {
		YieldStatementContext _localctx = new YieldStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_yieldStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(T__22);
			setState(252); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SleepStatementContext extends ParserRuleContext {
		public SleepHardcodedContext sleepHardcoded() {
			return getRuleContext(SleepHardcodedContext.class,0);
		}
		public SleepVarContext sleepVar() {
			return getRuleContext(SleepVarContext.class,0);
		}
		public SleepStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleepStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitSleepStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepStatementContext sleepStatement() throws RecognitionException {
		SleepStatementContext _localctx = new SleepStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sleepStatement);
		try {
			setState(256);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254); sleepHardcoded();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255); sleepVar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SleepHardcodedContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MScriptParser.Number, 0); }
		public SleepHardcodedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleepHardcoded; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitSleepHardcoded(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepHardcodedContext sleepHardcoded() throws RecognitionException {
		SleepHardcodedContext _localctx = new SleepHardcodedContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sleepHardcoded);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(T__25);
			setState(259); match(Number);
			setState(260); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SleepVarContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SleepVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleepVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitSleepVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepVarContext sleepVar() throws RecognitionException {
		SleepVarContext _localctx = new SleepVarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sleepVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(T__25);
			setState(263); expression();
			setState(264); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(T__38);
			setState(268);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__8) | (1L << T__0) | (1L << Number) | (1L << Const) | (1L << Identifier))) != 0)) {
				{
				setState(267); expression();
				}
			}

			setState(270); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThisIsFineStatementContext extends ParserRuleContext {
		public ThisIsFineStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisIsFineStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitThisIsFineStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThisIsFineStatementContext thisIsFineStatement() throws RecognitionException {
		ThisIsFineStatementContext _localctx = new ThisIsFineStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_thisIsFineStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); match(T__20);
			setState(273); match(T__23);
			setState(274); match(T__41);
			setState(275); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnCallStatementContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FnCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnCallStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitFnCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnCallStatementContext fnCallStatement() throws RecognitionException {
		FnCallStatementContext _localctx = new FnCallStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fnCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); functionCall();
			setState(278); match(T__32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(T__33);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__28) | (1L << T__25) | (1L << T__22) | (1L << T__20) | (1L << T__16) | (1L << T__9) | (1L << T__4) | (1L << Identifier))) != 0)) {
				{
				{
				setState(281); statement();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287); match(T__30);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public EvalExpressionContext evalExpression() {
			return getRuleContext(EvalExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expression);
		try {
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289); functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290); evalExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MScriptParser.Identifier, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(Identifier);
			setState(294); match(T__24);
			setState(296);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__8) | (1L << T__0) | (1L << Number) | (1L << Const) | (1L << Identifier))) != 0)) {
				{
				setState(295); args();
				}
			}

			setState(298); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); expression();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(301); match(T__19);
				setState(302); expression();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvalExpressionContext extends ParserRuleContext {
		public List<Precedence1OperatorsContext> precedence1Operators() {
			return getRuleContexts(Precedence1OperatorsContext.class);
		}
		public Precedence1OperatorsContext precedence1Operators(int i) {
			return getRuleContext(Precedence1OperatorsContext.class,i);
		}
		public List<Precedence2Context> precedence2() {
			return getRuleContexts(Precedence2Context.class);
		}
		public Precedence2Context precedence2(int i) {
			return getRuleContext(Precedence2Context.class,i);
		}
		public EvalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evalExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitEvalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalExpressionContext evalExpression() throws RecognitionException {
		EvalExpressionContext _localctx = new EvalExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_evalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); precedence2();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__26) | (1L << T__12))) != 0)) {
				{
				{
				setState(309); precedence1Operators();
				setState(310); precedence2();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence1OperatorsContext extends ParserRuleContext {
		public Precedence1OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence1Operators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence1Operators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence1OperatorsContext precedence1Operators() throws RecognitionException {
		Precedence1OperatorsContext _localctx = new Precedence1OperatorsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_precedence1Operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__26) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence2Context extends ParserRuleContext {
		public List<Precedence3Context> precedence3() {
			return getRuleContexts(Precedence3Context.class);
		}
		public List<Precedence2OperatorsContext> precedence2Operators() {
			return getRuleContexts(Precedence2OperatorsContext.class);
		}
		public Precedence2OperatorsContext precedence2Operators(int i) {
			return getRuleContext(Precedence2OperatorsContext.class,i);
		}
		public Precedence3Context precedence3(int i) {
			return getRuleContext(Precedence3Context.class,i);
		}
		public Precedence2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence2Context precedence2() throws RecognitionException {
		Precedence2Context _localctx = new Precedence2Context(_ctx, getState());
		enterRule(_localctx, 64, RULE_precedence2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); precedence3();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__27) | (1L << T__15) | (1L << T__14) | (1L << T__13) | (1L << T__10))) != 0)) {
				{
				{
				setState(320); precedence2Operators();
				setState(321); precedence3();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence2OperatorsContext extends ParserRuleContext {
		public Precedence2OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence2Operators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence2Operators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence2OperatorsContext precedence2Operators() throws RecognitionException {
		Precedence2OperatorsContext _localctx = new Precedence2OperatorsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_precedence2Operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__27) | (1L << T__15) | (1L << T__14) | (1L << T__13) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence3Context extends ParserRuleContext {
		public Precedence4Context precedence4() {
			return getRuleContext(Precedence4Context.class,0);
		}
		public Precedence3OperatorsContext precedence3Operators() {
			return getRuleContext(Precedence3OperatorsContext.class,0);
		}
		public Precedence3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence3Context precedence3() throws RecognitionException {
		Precedence3Context _localctx = new Precedence3Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_precedence3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if (_la==T__8 || _la==T__0) {
				{
				setState(330); precedence3Operators();
				}
			}

			setState(333); precedence4();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence3OperatorsContext extends ParserRuleContext {
		public Precedence3OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence3Operators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence3Operators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence3OperatorsContext precedence3Operators() throws RecognitionException {
		Precedence3OperatorsContext _localctx = new Precedence3OperatorsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_precedence3Operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence4Context extends ParserRuleContext {
		public List<Precedence4OperatorsContext> precedence4Operators() {
			return getRuleContexts(Precedence4OperatorsContext.class);
		}
		public List<Precedence5Context> precedence5() {
			return getRuleContexts(Precedence5Context.class);
		}
		public Precedence5Context precedence5(int i) {
			return getRuleContext(Precedence5Context.class,i);
		}
		public Precedence4OperatorsContext precedence4Operators(int i) {
			return getRuleContext(Precedence4OperatorsContext.class,i);
		}
		public Precedence4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence4Context precedence4() throws RecognitionException {
		Precedence4Context _localctx = new Precedence4Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_precedence4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); precedence5();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__0) {
				{
				{
				setState(338); precedence4Operators();
				setState(339); precedence5();
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence4OperatorsContext extends ParserRuleContext {
		public Precedence4OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence4Operators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence4Operators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence4OperatorsContext precedence4Operators() throws RecognitionException {
		Precedence4OperatorsContext _localctx = new Precedence4OperatorsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_precedence4Operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence5Context extends ParserRuleContext {
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<Precedence5OperatorsContext> precedence5Operators() {
			return getRuleContexts(Precedence5OperatorsContext.class);
		}
		public Precedence5OperatorsContext precedence5Operators(int i) {
			return getRuleContext(Precedence5OperatorsContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public Precedence5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence5Context precedence5() throws RecognitionException {
		Precedence5Context _localctx = new Precedence5Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_precedence5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); atom();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__21) | (1L << T__6))) != 0)) {
				{
				{
				setState(349); precedence5Operators();
				setState(350); atom();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Precedence5OperatorsContext extends ParserRuleContext {
		public Precedence5OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence5Operators; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitPrecedence5Operators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence5OperatorsContext precedence5Operators() throws RecognitionException {
		Precedence5OperatorsContext _localctx = new Precedence5OperatorsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_precedence5Operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__21) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode Number() { return getToken(MScriptParser.Number, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_atom);
		try {
			setState(365);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(359); match(Number);
				}
				break;
			case Const:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(360); variable();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(361); match(T__24);
				setState(362); expression();
				setState(363); match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MScriptParser.Identifier, 0); }
		public TerminalNode Const() { return getToken(MScriptParser.Const, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MScriptVisitor ) return ((MScriptVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ( !(_la==Const || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u0174\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\7\2X\n\2\f\2\16\2[\13\2\3\2\7\2^\n\2\f\2\16\2a\13\2\3\2\7\2d\n\2\f"+
		"\2\16\2g\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\5\5y\n\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u0081\n\6\f\6\16\6\u0084"+
		"\13\6\3\7\3\7\7\7\u0088\n\7\f\7\16\7\u008b\13\7\3\7\7\7\u008e\n\7\f\7"+
		"\16\7\u0091\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0099\n\b\f\b\16\b\u009c"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00aa\n\t\3"+
		"\n\3\n\5\n\u00ae\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00bd\n\f\f\f\16\f\u00c0\13\f\3\f\5\f\u00c3\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\5\20\u00d6\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\5\26\u0103\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\5\31\u010f\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\7\34\u011d\n\34\f\34\16\34\u0120\13\34\3\34\3\34"+
		"\3\35\3\35\5\35\u0126\n\35\3\36\3\36\3\36\5\36\u012b\n\36\3\36\3\36\3"+
		"\37\3\37\3\37\7\37\u0132\n\37\f\37\16\37\u0135\13\37\3 \3 \3 \3 \7 \u013b"+
		"\n \f \16 \u013e\13 \3!\3!\3\"\3\"\3\"\3\"\7\"\u0146\n\"\f\"\16\"\u0149"+
		"\13\"\3#\3#\3$\5$\u014e\n$\3$\3$\3%\3%\3&\3&\3&\3&\7&\u0158\n&\f&\16&"+
		"\u015b\13&\3\'\3\'\3(\3(\3(\3(\7(\u0163\n(\f(\16(\u0166\13(\3)\3)\3*\3"+
		"*\3*\3*\3*\3*\5*\u0170\n*\3+\3+\3+\2\2,\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT\2\b\5\2\20\20\23\23!!\6"+
		"\2\b\b\22\22\36 ##\4\2%%--\3\2,-\5\2\3\3\30\30\'\'\3\2\61\62\u016c\2Y"+
		"\3\2\2\2\4h\3\2\2\2\6n\3\2\2\2\bt\3\2\2\2\n}\3\2\2\2\f\u0085\3\2\2\2\16"+
		"\u0094\3\2\2\2\20\u00a9\3\2\2\2\22\u00ab\3\2\2\2\24\u00b1\3\2\2\2\26\u00b6"+
		"\3\2\2\2\30\u00c4\3\2\2\2\32\u00ca\3\2\2\2\34\u00cd\3\2\2\2\36\u00d5\3"+
		"\2\2\2 \u00d7\3\2\2\2\"\u00df\3\2\2\2$\u00ea\3\2\2\2&\u00f5\3\2\2\2(\u00fd"+
		"\3\2\2\2*\u0102\3\2\2\2,\u0104\3\2\2\2.\u0108\3\2\2\2\60\u010c\3\2\2\2"+
		"\62\u0112\3\2\2\2\64\u0117\3\2\2\2\66\u011a\3\2\2\28\u0125\3\2\2\2:\u0127"+
		"\3\2\2\2<\u012e\3\2\2\2>\u0136\3\2\2\2@\u013f\3\2\2\2B\u0141\3\2\2\2D"+
		"\u014a\3\2\2\2F\u014d\3\2\2\2H\u0151\3\2\2\2J\u0153\3\2\2\2L\u015c\3\2"+
		"\2\2N\u015e\3\2\2\2P\u0167\3\2\2\2R\u016f\3\2\2\2T\u0171\3\2\2\2VX\5\4"+
		"\3\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z_\3\2\2\2[Y\3\2\2\2\\^\5"+
		"\6\4\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`e\3\2\2\2a_\3\2\2\2bd"+
		"\5\b\5\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\3\3\2\2\2ge\3\2\2\2"+
		"hi\7\6\2\2ij\7\60\2\2jk\7\5\2\2kl\7\62\2\2lm\7\r\2\2m\5\3\2\2\2no\7\6"+
		"\2\2op\7\61\2\2pq\7\5\2\2qr\7.\2\2rs\7\r\2\2s\7\3\2\2\2tu\7&\2\2uv\7\62"+
		"\2\2vx\7\25\2\2wy\5\n\6\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7+\2\2{|\5\f"+
		"\7\2|\t\3\2\2\2}\u0082\7\62\2\2~\177\7\32\2\2\177\u0081\7\62\2\2\u0080"+
		"~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\13\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0089\7\f\2\2\u0086\u0088"+
		"\5\16\b\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008f\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e"+
		"\5\20\t\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2"+
		"\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093"+
		"\7\17\2\2\u0093\r\3\2\2\2\u0094\u0095\7\34\2\2\u0095\u009a\7\62\2\2\u0096"+
		"\u0097\7\32\2\2\u0097\u0099\7\62\2\2\u0098\u0096\3\2\2\2\u0099\u009c\3"+
		"\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7\r\2\2\u009e\17\3\2\2\2\u009f\u00aa\5\22\n"+
		"\2\u00a0\u00aa\5\26\f\2\u00a1\u00aa\5\34\17\2\u00a2\u00aa\5\36\20\2\u00a3"+
		"\u00aa\5&\24\2\u00a4\u00aa\5(\25\2\u00a5\u00aa\5*\26\2\u00a6\u00aa\5\60"+
		"\31\2\u00a7\u00aa\5\64\33\2\u00a8\u00aa\5\62\32\2\u00a9\u009f\3\2\2\2"+
		"\u00a9\u00a0\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a2\3\2\2\2\u00a9\u00a3"+
		"\3\2\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\21\3\2\2\2\u00ab\u00ad\7$\2\2"+
		"\u00ac\u00ae\5\24\13\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b0\5\66\34\2\u00b0\23\3\2\2\2\u00b1\u00b2\7\13\2\2\u00b2"+
		"\u00b3\7\25\2\2\u00b3\u00b4\58\35\2\u00b4\u00b5\7+\2\2\u00b5\25\3\2\2"+
		"\2\u00b6\u00b7\7\21\2\2\u00b7\u00b8\7\25\2\2\u00b8\u00b9\58\35\2\u00b9"+
		"\u00ba\7+\2\2\u00ba\u00be\5\66\34\2\u00bb\u00bd\5\30\r\2\u00bc\u00bb\3"+
		"\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\5\32\16\2\u00c2\u00c1\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\27\3\2\2\2\u00c4\u00c5\7\"\2\2\u00c5"+
		"\u00c6\7\25\2\2\u00c6\u00c7\58\35\2\u00c7\u00c8\7+\2\2\u00c8\u00c9\5\66"+
		"\34\2\u00c9\31\3\2\2\2\u00ca\u00cb\7*\2\2\u00cb\u00cc\5\66\34\2\u00cc"+
		"\33\3\2\2\2\u00cd\u00ce\7\62\2\2\u00ce\u00cf\7\16\2\2\u00cf\u00d0\58\35"+
		"\2\u00d0\u00d1\7\r\2\2\u00d1\35\3\2\2\2\u00d2\u00d6\5 \21\2\u00d3\u00d6"+
		"\5\"\22\2\u00d4\u00d6\5$\23\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2"+
		"\u00d5\u00d4\3\2\2\2\u00d6\37\3\2\2\2\u00d7\u00d8\7)\2\2\u00d8\u00d9\7"+
		"\62\2\2\u00d9\u00da\7\33\2\2\u00da\u00db\7\62\2\2\u00db\u00dc\7(\2\2\u00dc"+
		"\u00dd\7\62\2\2\u00dd\u00de\7\r\2\2\u00de!\3\2\2\2\u00df\u00e0\7)\2\2"+
		"\u00e0\u00e1\7\n\2\2\u00e1\u00e2\7\62\2\2\u00e2\u00e3\7\33\2\2\u00e3\u00e4"+
		"\7\62\2\2\u00e4\u00e5\7\33\2\2\u00e5\u00e6\7\62\2\2\u00e6\u00e7\7(\2\2"+
		"\u00e7\u00e8\7\62\2\2\u00e8\u00e9\7\r\2\2\u00e9#\3\2\2\2\u00ea\u00eb\7"+
		")\2\2\u00eb\u00ec\7\t\2\2\u00ec\u00ed\7\62\2\2\u00ed\u00ee\7\33\2\2\u00ee"+
		"\u00ef\7/\2\2\u00ef\u00f0\7\33\2\2\u00f0\u00f1\7\62\2\2\u00f1\u00f2\7"+
		"(\2\2\u00f2\u00f3\7\62\2\2\u00f3\u00f4\7\r\2\2\u00f4%\3\2\2\2\u00f5\u00f6"+
		"\7\35\2\2\u00f6\u00f7\7\62\2\2\u00f7\u00f8\7(\2\2\u00f8\u00f9\7\62\2\2"+
		"\u00f9\u00fa\7\33\2\2\u00fa\u00fb\7\62\2\2\u00fb\u00fc\7\r\2\2\u00fc\'"+
		"\3\2\2\2\u00fd\u00fe\7\27\2\2\u00fe\u00ff\7\r\2\2\u00ff)\3\2\2\2\u0100"+
		"\u0103\5,\27\2\u0101\u0103\5.\30\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2"+
		"\2\2\u0103+\3\2\2\2\u0104\u0105\7\24\2\2\u0105\u0106\7.\2\2\u0106\u0107"+
		"\7\r\2\2\u0107-\3\2\2\2\u0108\u0109\7\24\2\2\u0109\u010a\58\35\2\u010a"+
		"\u010b\7\r\2\2\u010b/\3\2\2\2\u010c\u010e\7\7\2\2\u010d\u010f\58\35\2"+
		"\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111"+
		"\7\r\2\2\u0111\61\3\2\2\2\u0112\u0113\7\31\2\2\u0113\u0114\7\26\2\2\u0114"+
		"\u0115\7\4\2\2\u0115\u0116\7\r\2\2\u0116\63\3\2\2\2\u0117\u0118\5:\36"+
		"\2\u0118\u0119\7\r\2\2\u0119\65\3\2\2\2\u011a\u011e\7\f\2\2\u011b\u011d"+
		"\5\20\t\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122"+
		"\7\17\2\2\u0122\67\3\2\2\2\u0123\u0126\5:\36\2\u0124\u0126\5> \2\u0125"+
		"\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u01269\3\2\2\2\u0127\u0128\7\62\2\2"+
		"\u0128\u012a\7\25\2\2\u0129\u012b\5<\37\2\u012a\u0129\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\7+\2\2\u012d;\3\2\2\2\u012e\u0133"+
		"\58\35\2\u012f\u0130\7\32\2\2\u0130\u0132\58\35\2\u0131\u012f\3\2\2\2"+
		"\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134=\3"+
		"\2\2\2\u0135\u0133\3\2\2\2\u0136\u013c\5B\"\2\u0137\u0138\5@!\2\u0138"+
		"\u0139\5B\"\2\u0139\u013b\3\2\2\2\u013a\u0137\3\2\2\2\u013b\u013e\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d?\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013f\u0140\t\2\2\2\u0140A\3\2\2\2\u0141\u0147\5F$\2\u0142\u0143"+
		"\5D#\2\u0143\u0144\5F$\2\u0144\u0146\3\2\2\2\u0145\u0142\3\2\2\2\u0146"+
		"\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148C\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u014a\u014b\t\3\2\2\u014bE\3\2\2\2\u014c\u014e\5"+
		"H%\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f"+
		"\u0150\5J&\2\u0150G\3\2\2\2\u0151\u0152\t\4\2\2\u0152I\3\2\2\2\u0153\u0159"+
		"\5N(\2\u0154\u0155\5L\'\2\u0155\u0156\5N(\2\u0156\u0158\3\2\2\2\u0157"+
		"\u0154\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015aK\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015d\t\5\2\2\u015dM\3\2"+
		"\2\2\u015e\u0164\5R*\2\u015f\u0160\5P)\2\u0160\u0161\5R*\2\u0161\u0163"+
		"\3\2\2\2\u0162\u015f\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164"+
		"\u0165\3\2\2\2\u0165O\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\t\6\2\2"+
		"\u0168Q\3\2\2\2\u0169\u0170\7.\2\2\u016a\u0170\5T+\2\u016b\u016c\7\25"+
		"\2\2\u016c\u016d\58\35\2\u016d\u016e\7+\2\2\u016e\u0170\3\2\2\2\u016f"+
		"\u0169\3\2\2\2\u016f\u016a\3\2\2\2\u016f\u016b\3\2\2\2\u0170S\3\2\2\2"+
		"\u0171\u0172\t\7\2\2\u0172U\3\2\2\2\33Y_ex\u0082\u0089\u008f\u009a\u00a9"+
		"\u00ad\u00be\u00c2\u00d5\u0102\u010e\u011e\u0125\u012a\u0133\u013c\u0147"+
		"\u014d\u0159\u0164\u016f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}