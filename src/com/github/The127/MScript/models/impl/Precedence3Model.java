/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.Objects;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.ICompilableModel;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

/**
 * This class represents a precedence 3 operator expression in the MScript language.
 * @author Julian Baehr
 */
public class Precedence3Model extends AbstractModel {

	public static enum Operation {
		unaryMinus{
			@Override
			public String toString() {
				return "__negate";
			}
		},
		not{
			@Override
			public String toString() {
				return  "__not";
			}
		};
		
		public static Operation fromString(String op, FileContext ctx) {
			switch(op) {
			case "-":
				return unaryMinus;
			case "!":
				return not;
			default:
				throw new MScriptCompilationException("Unknown precedence 3 operator: " + op + ".", ctx);
			}
		}
	}
	
	private class Item implements ICompilableModel {
		
		private final Operation operation;
		private final Precedence4Model model;
		
		private Item(Operation operation, Precedence4Model model) {
			Objects.requireNonNull(model);
			this.operation = operation;
			this.model = model;
		}

		@Override
		public String compile(IScriptContext ctx) {
			var sb = new StringBuilder();
			
			sb.append(model.compile(ctx));
			if(operation != null)
				sb.append("jal ").append(MScriptRuntime.destGotoLabel(operation.toString())).append(System.lineSeparator());
			
			return sb.toString();
		}
	}
	
	private Item first;
	
	public Precedence3Model(FileContext ctx) {
		super(ctx);
	}
	
	public void setFirst(Operation operation, Precedence4Model model) {
		first = new Item(operation, model);
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append(first.compile(ctx));
		
		return sb.toString();
	}

}
