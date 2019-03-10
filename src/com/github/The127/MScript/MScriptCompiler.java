package com.github.The127.MScript;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.github.The127.MScript.antlr.MScriptLexer;
import com.github.The127.MScript.antlr.MScriptParser;
import com.github.The127.MScript.visitors.ScriptVisitor;

public class MScriptCompiler {
	public static void main(String[] args) throws IOException {
		var code = new String(Files.readAllBytes(Paths.get("res/test.ms")));
		var lexer = new MScriptLexer(new ANTLRInputStream(code));
		var tokens = new CommonTokenStream(lexer);
		var parser = new MScriptParser(tokens);
		var visitor = new ScriptVisitor();
		var model = visitor.visitScript(parser.script());
		var pseudo = model.doCompile();
		var compiled = new LabelResolver().resolveLabels(pseudo);
		System.out.println(compiled);
	}
}
