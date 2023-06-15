/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.rt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;

/**
 * This class provides a modular and dynamically generated runtime environment for MScript. 
 * @author Karolin Kostial
 */
public final class MScriptRuntime {
	
	private static final int Major = 0;
	private static final int Minor = 1;
	/**
	 * The current compiler version.
	 */
	public static final String COMPILER_VERSION = "MScriptV" + Major + "." + Minor;
	
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Set<String> labels = new HashSet<>();
	
	public static boolean isDebugEnabled = false;

	private static boolean
		isAddUsed = false,
		isSubUsed = false,
		isDivUsed = false,
		isMulUsed = false,
		isModUsed = false,
		isNegateUsed = false,
		isNotUsed = false,
		isAndUsed = false,
		isOrUsed = false,
		isXorUsed = false,
		isLessUsed = false,
		isLessOrEqualUsed = false,
		isGreaterUsed = false,
		isGreaterOrEqualUsed = false,
		isEqualUsed = false,
		isNotEqualUsed = false;
	
	private static boolean
		isFloorUsed = false,
		isCeilUsed = false,
		isRoundUsed = false,
		isBoolUsed = false,
		isAbsUsed = false,
		isLogUsed = false,
		isMaxUsed = false,
		isMinUsed = false,
		isRandUsed = false,
		isTruncUsed = false,
		isSqrtUsed = false,
		isExpUsed = false;
	
	private static boolean
		isFunctionCalled = false,
		isConditionEvaluated = false,
		isRetUsed = false,
		isRetTrueFalseUsed = false;
	
	private static final List<String> rtFunctionNames = Arrays.asList(new String[]{
		"floor",
		"ceil",
		"round",
		"bool",
		"abs",
		"log",
		"max",
		"min",
		"rand",
		"trunc",
		"sqrt",
		"exp",
	});
	
	private static final int[] rtFunctionParameterCount = {
		1, // floor
		1, // ceil
		1, // round
		1, // bool
		1, // abs
		1, // log
		2, // max
		2, // min
		0, // rand
		1, // trunc
		1, // sqrt
		1, // exp
	};

	public static void debugOutput()
	{
		if(!isDebugEnabled) return;

		System.out.println("BEGIN DEBUG Runtime-Output");
		if(isAddUsed) System.out.println("isAddUsed: " + isAddUsed);
		if(isSubUsed) System.out.println("isSubUsed: " + isSubUsed);
		if(isDivUsed) System.out.println("isDivUsed: " + isDivUsed);
		if(isMulUsed) System.out.println("isMulUsed: " + isMulUsed);
		if(isModUsed) System.out.println("isModUsed: " + isModUsed);
		if(isNegateUsed) System.out.println("isNegateUsed: " + isNegateUsed);
		if(isNotUsed) System.out.println("isNotUsed: " + isNotUsed);
		if(isAndUsed) System.out.println("isAndUsed: " + isAndUsed);
		if(isOrUsed) System.out.println("isOrUsed: " + isOrUsed);
		if(isXorUsed) System.out.println("isXorUsed: " + isXorUsed);
		if(isLessUsed) System.out.println("isLessUsed: " + isLessUsed);
		if(isLessOrEqualUsed) System.out.println("isLessOrEqualUsed: " + isLessOrEqualUsed);
		if(isGreaterUsed) System.out.println("isGreaterUsed: " + isGreaterUsed);
		if(isGreaterOrEqualUsed) System.out.println("isGreaterOrEqualUsed: " + isGreaterOrEqualUsed);
		if(isEqualUsed) System.out.println("isEqualUsed: " + isEqualUsed);
		if(isNotEqualUsed) System.out.println("isNotEqualUsed: " + isNotEqualUsed);
		if(isFloorUsed) System.out.println("isFloorUsed: " + isFloorUsed);
		if(isCeilUsed) System.out.println("isCeilUsed: " + isCeilUsed);
		if(isRoundUsed) System.out.println("isRoundUsed: " + isRoundUsed);
		if(isBoolUsed) System.out.println("isBoolUsed: " + isBoolUsed);
		if(isAbsUsed) System.out.println("isAbsUsed: " + isAbsUsed);
		if(isLogUsed) System.out.println("isLogUsed: " + isLogUsed);
		if(isMaxUsed) System.out.println("isMaxUsed: " + isMaxUsed);
		if(isMinUsed) System.out.println("isMinUsed: " + isMinUsed);
		if(isRandUsed) System.out.println("isRandUsed: " + isRandUsed);
		if(isTruncUsed) System.out.println("isTruncUsed: " + isTruncUsed);
		if(isSqrtUsed) System.out.println("isSqrtUsed: " + isSqrtUsed);
		if(isExpUsed) System.out.println("isExpUsed: " + isExpUsed);
		if(isFunctionCalled) System.out.println("isFunctionCalled: " + isFunctionCalled);
		if(isConditionEvaluated) System.out.println("isConditionEvaluated: " + isConditionEvaluated);
		if(isRetUsed) System.out.println("isRetUsed: " + isRetUsed);
		if(isRetTrueFalseUsed) System.out.println("isRetTrueFalseUsed: " + isRetTrueFalseUsed);
		System.out.println("END DEBUG Runtime-Output");

		System.out.println();
		
		System.out.println("BEGIN DEBUG Runtime-Code");
		var resetDebug = isDebugEnabled;
		isDebugEnabled = false;
		System.out.println(MScriptRuntime.createRuntime(0, 0));
		isDebugEnabled = resetDebug;
		System.out.println("END DEBUG Runtime-Code");
		System.out.println();
	}
	
	/**
	 * @param name The name of the internal runtime function.
	 * @param ctx The file context for better error handling.
	 * @return The amount of parameters for the specified runtime internal function.
	 */
	public static int getParametersForRtFunction(String name, FileContext ctx) {
		if(!isRtFunctionName(name))
			throw new MScriptCompilationException("Internal compiler/runtime error: detected '" + name + "' falsly as a rt function.", ctx); 
		int index = rtFunctionNames.indexOf(name);
		return rtFunctionParameterCount[index];
	}
	
	/**
	 * @param name The name of the internal runtime function.
	 * @return True if the provided name is the name of an internal runtime function.
	 */
	public static boolean isRtFunctionName(String name) {
		return rtFunctionNames.contains(name);
	}
	
	/**
	 * Dynamically generates a string representation of the modular MScript runtime.
	 * @param registersUsed The amount of maximum registers used by function parameters and variables.
	 * @return The runtime for the script.
	 */
	public static String createRuntime(int registersUsed, int maxParams) {
		var sb = new StringBuilder();
		
		sb.append(createPushPopRegisters(registersUsed, maxParams));
		sb.append(less());
		sb.append(lessOrEqual());
		sb.append(greater());
		sb.append(greaterOrEqual());
		sb.append(equal());
		sb.append(notEqual());
		sb.append(retTrueFalse());
		sb.append(and());
		sb.append(or());
		sb.append(xor());
		sb.append(add());
		sb.append(sub());
		sb.append(mul());
		sb.append(div());
		sb.append(mod());
		sb.append(negate());
		sb.append(not());
		sb.append(floor());
		sb.append(ceil());
		sb.append(round());
		sb.append(bool());
		sb.append(abs());
		sb.append(log());
		sb.append(max());
		sb.append(min());
		sb.append(rand());
		sb.append(trunc());
		sb.append(sqrt());
		sb.append(exp());
		sb.append(ret());
		sb.append(condition());

		// optimize last runtime feature to not use "j __ret"
		return sb.toString();
	}

	private static String createPushPopRegisters(int registersUsed, int maxParams) {
		// dont add this to the runtime if it is not needed
		if(!isFunctionCalled)
			return "";
		
		var sb = new StringBuilder();

		for(int i = maxParams-1; i >= 0; i--) {
			sb.append(sourceGotoLabel("__pop_params_" + (i+1))).append(System.lineSeparator());
			sb.append("pop r" + i).append(System.lineSeparator());
		}
		sb.append("j ra").append(System.lineSeparator());

		sb.append(sourceGotoLabel("__push_registers")).append(System.lineSeparator());
		for(int i = 0; i < registersUsed; i++)
			sb.append("push r" + i).append(System.lineSeparator());
		// return
		sb.append("j ra").append(System.lineSeparator());

		sb.append(sourceGotoLabel("__pop_registers")).append(System.lineSeparator());
		// save return value
		sb.append("pop r12").append(System.lineSeparator());
		for(int i = registersUsed-1; i >= 0; i--)
			sb.append("pop r" + i).append(System.lineSeparator());
		sb.append(jRet());
		return sb.toString();
	}	
	
	private static String twoOperator(boolean isUsed, String operation) {
		if(!isUsed)
			return "";
		return sourceGotoLabel("__" + operation) + System.lineSeparator() 
			+ "pop r13" + System.lineSeparator()
			+ "pop r12" + System.lineSeparator()
			+ operation + " r12 r12 r13" + System.lineSeparator()
			+ jRet();
	}
	
	private static String oneOperator(boolean isUsed, String operation) {
		if(!isUsed)
			return "";
		return sourceGotoLabel("__" + operation) + System.lineSeparator() 
			+ "pop r12" + System.lineSeparator()
			+ operation + " r12 r12" + System.lineSeparator()
			+ jRet();
	}
	
	private static String noOperator(boolean isUsed, String operation) {
		if(!isUsed)
			return "";
		return sourceGotoLabel("__" + operation) + System.lineSeparator() 
			+ operation + " r12" + System.lineSeparator()
			+ jRet();
	}
	
	private static String compareOp(boolean isUsed, String operation, String opName) {
		if(!isUsed)
			return "";
		return sourceGotoLabel("__" + opName) + System.lineSeparator() 
			 + "pop r13" + System.lineSeparator()
			 + "pop r12" + System.lineSeparator()
			 + operation + " r12 r13 " + jTrue()
			 + "j " + jFalse();
	}
	
	private static String less() {
		return compareOp(isLessUsed, "blt", "less");
	}
	
	private static String lessOrEqual() {
		return compareOp(isLessOrEqualUsed, "ble", "lessOrEqual");
	}
	
	private static String greater() {
		return compareOp(isGreaterUsed, "bgt", "greater");
	}
	
	private static String greaterOrEqual() {
		return compareOp(isGreaterOrEqualUsed, "bge", "greaterOrEqual");
	}
	
	private static String equal() {
		return compareOp(isEqualUsed, "beq", "equal");
	}
	
	private static String notEqual() {
		return compareOp(isNotEqualUsed, "bne", "notEqual");
	}
	
	private static String jTrue() {
		if(isDebugEnabled && !isRetTrueFalseUsed) System.out.println("Runtime: enabling 'return true'.");
		isRetTrueFalseUsed = true;
		return destGotoLabel("__jTrue") + System.lineSeparator();
	}
	
	private static String jFalse() {
		if(isDebugEnabled && !isRetTrueFalseUsed) System.out.println("Runtime: enabling 'return false'.");
		isRetTrueFalseUsed = true;
		return destGotoLabel("__jFalse") + System.lineSeparator();
	}
	
	private static String retTrueFalse() {
		if(!isRetTrueFalseUsed)
			return "";
		return sourceGotoLabel("__jTrue") + System.lineSeparator()
			 + "push 1" + System.lineSeparator()
			 + "j ra" + System.lineSeparator()
			 + sourceGotoLabel("__jFalse") + System.lineSeparator()
			 + "push 0" + System.lineSeparator()
			 + "j ra" + System.lineSeparator();
	}
	
	private static String twoOpLogic(boolean isUsed, String operation) {
		if(!isUsed)
			return "";
		return 
				"pop r13" + System.lineSeparator()
			  + "pop r12" + System.lineSeparator()
			  + "round r13 r13" + System.lineSeparator()
			  + "round r12 r12" + System.lineSeparator()
			  + operation + " r12 r12 r13" + System.lineSeparator()
			  + jRet();
	}
	
	private static String and() {
		return twoOpLogic(isAndUsed, "and");
	}
	
	private static String or() {
		return twoOpLogic(isOrUsed, "or");
	}
	
	private static String xor() {
		return twoOpLogic(isXorUsed, "xor");
	}
	
	private static String add() {
		return twoOperator(isAddUsed, "add");
	}
	
	private static String sub() {
		return twoOperator(isSubUsed, "sub");
	}
	
	private static String mul() {
		return twoOperator(isMulUsed, "mul");
	}
	
	private static String div() {
		return twoOperator(isDivUsed, "div");
	}
	
	private static String mod() {
		return twoOperator(isModUsed, "mod");
	}
	
	private static String max() {
		return twoOperator(isMaxUsed, "max");
	}
	
	private static String min() {
		return twoOperator(isMinUsed, "min");
	}

	private static String negate() {
		if(!isNegateUsed)
			return "";
		return  "pop r12" + System.lineSeparator()
			  + "sub r12 0 r12" + System.lineSeparator()
			  + jRet();
	}
	
	private static String not() {
		if(!isNotUsed)
			return "";
		return "pop r12" + System.lineSeparator()
			 + "round r12 r12" + System.lineSeparator()
			 + "or r12 r12 0" + System.lineSeparator()
			 + "sub r12 1 r12" + System.lineSeparator()
			 + jRet();
	}
	
	private static String floor() {
		return oneOperator(isFloorUsed, "floor");
	}
	
	private static String ceil() {
		return oneOperator(isCeilUsed, "ceil");
	}
	
	private static String round() {
		return oneOperator(isRoundUsed, "round");
	}
	
	private static String abs() {
		return oneOperator(isAbsUsed, "abs");
	}
	
	private static String log() {
		return oneOperator(isLogUsed, "log");
	}
	
	private static String bool() {
		if(!isBoolUsed)
			return "";
		return "pop r12" + System.lineSeparator()
			 + "round r12 r12" + System.lineSeparator()
			 + "or r12 r12 0" + System.lineSeparator()
			 + jRet();
	}
	
	private static String rand() {
		return noOperator(isRandUsed, "rand");
	}
	
	private static String trunc() {
		return oneOperator(isTruncUsed, "trunc");
	}
	
	private static String sqrt() {
		return oneOperator(isSqrtUsed, "sqrt");
	}
	
	private static String exp() {
		return oneOperator(isExpUsed, "exp");
	}
	
	private static String jRet() {
		if(isDebugEnabled && !isRetUsed) System.out.println("Runtime: enabling 'return'.");
		isRetUsed = true;
		return "j " + destGotoLabel("__ret") + System.lineSeparator();
	}
	
	private static String ret() {
		if(!isRetUsed)
			return "";
		// always add this since at least one runtime feature is used
		return sourceGotoLabel("__ret") + System.lineSeparator()
			// push result on stack before returning
			+ "push r12" + System.lineSeparator()
			+ "j ra" + System.lineSeparator();
	}
	
	private static String condition() {
		if(!isConditionEvaluated)
			return "";
		return sourceGotoLabel("__condition") + System.lineSeparator()
			+ "pop r12" + System.lineSeparator()
			+ "round r12 r12" + System.lineSeparator()
			+ jRet();
	}
	
	/**
	 * Creates a source label for a function.
	 * @param name The function name.
	 * @return a source label for the function.
	 */
	public static String sourceFunctionLabel(String name) {
		return sourceLabel("function", name);
	}
	
	/**
	 * Creates a source label for a goto label.
	 * @param name The goto label name.
	 * @return a source label for the goto label.
	 */
	public static String sourceGotoLabel(String name) {
		return sourceLabel("goto", name);
	}
	
	private static String sourceLabel(String type, String name) {
		return label("source", type, name);
	}
	
	/**
	 * Creates a destination label for a function.
	 * @param name The function name.
	 * @return a destination for the function.
	 */
	public static String destFunctionLabel(String name) {
		if(isDebugEnabled && !isFunctionCalled) System.out.println("Runtime: enabling 'function call'.");
		isFunctionCalled = true;
		return destLabel("function", name);
	}

	/**
	 * Creates a destination label for a goto label.
	 * @param name The goto label name.
	 * @return a destinatino label for the goto label.
	 */
	public static String destGotoLabel(String name) {
		if(isDebugEnabled) System.out.println("destGotoLabel: " + name);
		switch(name) {
		case "__and":
			if(isDebugEnabled && !isAndUsed) System.out.println("Runtime: enabling 'and'-operator.");
			isAndUsed = true;
			break;
		case "__or":
			if(isDebugEnabled && !isOrUsed) System.out.println("Runtime: enabling 'or'-operator.");
			isOrUsed = true;
			break;
		case "__xor":
		if(isDebugEnabled && !isXorUsed) System.out.println("Runtime: enabling 'xor'-operator.");
			isXorUsed = true;
			break;
		case "__condition":
			if(isDebugEnabled && !isConditionEvaluated) System.out.println("Runtime: enabling condition evaluation.");
			isConditionEvaluated = true;
			break;
		case "__floor":
			if(isDebugEnabled && !isFloorUsed) System.out.println("Runtime: enabling 'floor'-method.");
			isFloorUsed = true;
			break;
		case "__ceil":
			if(isDebugEnabled && !isCeilUsed) System.out.println("Runtime: enabling 'ceil'-method.");
			isCeilUsed = true;
			break;
		case "__round":
			if(isDebugEnabled && !isRoundUsed) System.out.println("Runtime: enabling 'round'-method.");
			isRoundUsed = true;
			break;
		case "__bool":
			if(isDebugEnabled && !isBoolUsed) System.out.println("Runtime: enabling 'bool'-method.");
			isBoolUsed = true;
			break;
		case "__abs":
			if(isDebugEnabled && !isAbsUsed) System.out.println("Runtime: enabling 'abs'-method.");
			isAbsUsed = true;
			break;
		case "__log":
			if(isDebugEnabled && !isLogUsed) System.out.println("Runtime: enabling 'log'-method.");
			isLogUsed = true;
			break;
		case "__max":
			if(isDebugEnabled && !isMaxUsed) System.out.println("Runtime: enabling 'max'-method.");
			isMaxUsed = true;
			break;
		case "__min":
			if(isDebugEnabled && !isMinUsed) System.out.println("Runtime: enabling 'min'-method.");
			isMinUsed = true;
			break;
		case "__rand":
			if(isDebugEnabled && !isRandUsed) System.out.println("Runtime: enabling 'rand'-method.");
			isRandUsed = true;
			break;
		case "__trunc":
			if(isDebugEnabled && !isTruncUsed) System.out.println("Runtime: enabling 'trunc'-method.");
			isTruncUsed = true;
			break;
		case "__sqrt":
			if(isDebugEnabled && !isSqrtUsed) System.out.println("Runtime: enabling 'sqrt'-method.");
			isSqrtUsed = true;
			break;
		case "__exp":
			if(isDebugEnabled && !isExpUsed) System.out.println("Runtime: enabling 'exp'-method.");
			isExpUsed = true;
			break;
		case "__add":
			if(isDebugEnabled && !isAddUsed) System.out.println("Runtime: enabling 'addition'.");			
			isAddUsed = true;
			break;
		case "__sub":
			if(isDebugEnabled && !isSubUsed) System.out.println("Runtime: enabling 'subtraction'.");
			isSubUsed = true;
			break;
		case "__mul":
			if(isDebugEnabled && !isMulUsed) System.out.println("Runtime: enabling 'multiplication'.");
			isMulUsed = true;
			break;
		case "__div":
			if(isDebugEnabled && !isDivUsed) System.out.println("Runtime: enabling 'division'.");
			isDivUsed = true;
			break;
		case "__mod":
			if(isDebugEnabled && !isModUsed) System.out.println("Runtime: enabling 'modulo'.");
			isModUsed = true;
			break;
		case "__not":
			if(isDebugEnabled && !isNotUsed) System.out.println("Runtime: enabling 'not'-operator.");
			isNotUsed = true;
			break;
		case "__negate":
			if(isDebugEnabled && !isNegateUsed) System.out.println("Runtime: enabling 'negation'.");
			isNegateUsed = true;
			break;
		case "__less":
			if(isDebugEnabled && !isLessUsed) System.out.println("Runtime: enabling 'less'-comparison.");
			isLessUsed = true;
			break;
		case "__lessOrEqual":
			if(isDebugEnabled && !isLessOrEqualUsed) System.out.println("Runtime: enabling 'isLessOrEqual'-comparison.");
			isLessOrEqualUsed = true;
			break;
		case "__greater":
			if(isDebugEnabled && !isGreaterUsed) System.out.println("Runtime: enabling 'isGreater'-comparison.");
			isGreaterUsed = true;
			break;
		case "__greaterOrEqual":
			if(isDebugEnabled && !isGreaterOrEqualUsed) System.out.println("Runtime: enabling 'isGreaterOrEqual'-comparison.");
			isGreaterOrEqualUsed = true;
			break;
		case "__equal":
			if(isDebugEnabled && !isEqualUsed) System.out.println("Runtime: enabling 'isEqual'-comparison.");
			isEqualUsed = true;
			break;
		case "__notEqual":
			if(isDebugEnabled && !isNotEqualUsed) System.out.println("Runtime: enabling 'isNotEqual'-comparison.");
			isNotEqualUsed = true;
			break;
		}
		return destLabel("goto", name);
	}
	
	private static String destLabel(String type, String name) {
		return label("dest", type, name);
	}
	
	private static String label(String target, String type, String name) {
		return "{" + target + "::" + type + "::" + name + "}";
	}
	
	/**
	 * Generates a unique label name.
	 * @return a unique label name.
	 */
	public static String generateLabelName() {
		var rand = new Random();
		var label = "";
		do {
			label = "";
			for(int i = 0; i < 32; i++)
				label = label + LETTERS.charAt(rand.nextInt(LETTERS.length()));
		}while(labels.contains(label));
		return label;
	}
}
