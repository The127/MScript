/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.rt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.impl.FunctionModel;

/**
 * This class provides a modular and dynamically generated runtime environment for MScript. 
 * @author Julian Baehr
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
		isXorUsed = false;
	
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
		isConditionEvaluated = false;
	
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
	public static String createRuntime(int registersUsed) {
		var sb = new StringBuilder();
		
		sb.append(createPushPopRegisters(registersUsed));
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
		return sb.toString()
				.replace(jRet() + ret(), ret());
	}

	private static String createPushPopRegisters(int registersUsed) {
		// dont add this to the runtime if it is not needed
		if(!isFunctionCalled)
			return "";
		
		var sb = new StringBuilder();
		
		int params = registersUsed - FunctionModel.MAX_LOCALS;
		for(int i = params-1; i > 0; i--) {
			sb.append(sourceGotoLabel("__pop_params_" + i)).append(System.lineSeparator());
			sb.append("pop r" + i).append(System.lineSeparator());
		}
		sb.append("j ra").append(System.lineSeparator());
		
		sb.append(sourceGotoLabel("__push_registers")).append(System.lineSeparator());
		for(int i = 0; i < registersUsed; i++)
			sb.append("push r" + i).append(System.lineSeparator());
		// return
		sb.append("j ra").append(System.lineSeparator());

		sb.append(sourceGotoLabel("__push_registers")).append(System.lineSeparator());
		// save return value
		sb.append("push r12").append(System.lineSeparator());
		for(int i = registersUsed-1; i > 0; i--)
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
		return twoOpLogic(isAndUsed, "or");
	}
	
	private static String xor() {
		return twoOpLogic(isAndUsed, "xor");
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
		return  "pop r12" + System.lineSeparator()
			  + "sub r12 0 r12" + System.lineSeparator()
			  + jRet();
	}
	
	private static String not() {
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
		return "j " + destGotoLabel("__ret") + System.lineSeparator();
	}
	
	private static String ret() {
		// always add this since at least one runtime feature is used
		return sourceGotoLabel("__ret") + System.lineSeparator()
			// push result on stack before returning
			+ "push r12" + System.lineSeparator()
			+ "j ra" + System.lineSeparator();
	}
	
	private static String condition() {
		if(!isConditionEvaluated)
			return "";
		return "pop r12" + System.lineSeparator()
			+ "round r12 r12" + System.lineSeparator();
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
		isFunctionCalled = true;
		return destLabel("function", name);
	}
	
	/**
	 * Creates a destination label for a goto label.
	 * @param name The goto label name.
	 * @return a destinatino label for the goto label.
	 */
	public static String destGotoLabel(String name) {
		switch(name) {
		case "__and":
			isAndUsed = true;
			break;
		case "__or":
			isOrUsed = true;
			break;
		case "__xor":
			isXorUsed = true;
			break;
		case "__condition":
			isConditionEvaluated = true;
			break;
		case "__floor":
			isFloorUsed = true;
			break;
		case "__ceil":
			isCeilUsed = true;
			break;
		case "__round":
			isRoundUsed = true;
			break;
		case "__bool":
			isBoolUsed = true;
			break;
		case "__abs":
			isAbsUsed = true;
			break;
		case "__log":
			isLogUsed = true;
			break;
		case "__max":
			isMaxUsed = true;
			break;
		case "__min":
			isMinUsed = true;
			break;
		case "__rand":
			isRandUsed = true;
			break;
		case "__trunc":
			isTruncUsed = true;
			break;
		case "__sqrt":
			isSqrtUsed = true;
			break;
		case "__exp":
			isExpUsed = true;
			break;
		case "__add":
			isAddUsed = true;
			break;
		case "__sub":
			isSubUsed = true;
			break;
		case "__mul":
			isMulUsed = true;
			break;
		case "__div":
			isDivUsed = true;
			break;
		case "__mod":
			isModUsed = true;
			break;
		case "__not":
			isNotUsed = true;
			break;
		case "__negate":
			isNegateUsed = true;
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
