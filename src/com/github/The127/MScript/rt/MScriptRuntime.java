package com.github.The127.MScript.rt;

public final class MScriptRuntime {

	public static String createPushPopRegisters(int registersUsed) {
		var sb = new StringBuilder();
		
		sb.append(sourceFunctionLabel("__push_registers")).append(System.lineSeparator());
		for(int i = 0; i < registersUsed; i++)
			sb.append("push r" + i).append(System.lineSeparator());
		// return
		sb.append("j ra").append(System.lineSeparator());

		sb.append(sourceFunctionLabel("__push_registers")).append(System.lineSeparator());
		// save return value
		sb.append("push r12").append(System.lineSeparator());
		for(int i = registersUsed-1; i > 0; i--)
			sb.append("pop r" + i).append(System.lineSeparator());
		// push return value back on stack and return
		sb.append("j " + destGotoLabel("__ret")).append(System.lineSeparator());
		return sb.toString();
	}
	
	public static String sourceFunctionLabel(String name) {
		return sourceLabel("function", name);
	}
	
	public static String sourceGotoLabel(String name) {
		return sourceLabel("goto", name);
	}
	
	private static String sourceLabel(String type, String name) {
		return label("source", type, name);
	}
	
	public static String destFunctionLabel(String name) {
		return destLabel("function", name);
	}
	
	public static String destGotoLabel(String name) {
		return destLabel("goto", name);
	}
	
	private static String destLabel(String type, String name) {
		return label("dest", type, name);
	}
	
	private static String label(String target, String type, String name) {
		return "{" + target + "::" + type + "::" + name + "}";
	}
}
