/**
 * MIT License
 * Copyright (c) 2019 Karolin Kostial and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.MScriptCompilationException;
import com.github.The127.MScript.models.ICompilableModel;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

/**
 * This class represents a precedence 2 operator expression in the MScript language.
 * @author Karolin Kostial
 */
public class Precedence2Model extends AbstractModel {
	
	public static enum Operation {
		less{
			@Override
			public String toString() {
				return "__less";
			}
		},
		greater{
			@Override
			public String toString() {
				return "__greater";
			}
		},
		lessOrEqual{
			@Override
			public String toString() {
				return "__lessOrEqual";
			}
		},
		greaterOrEqual{
			@Override
			public String toString() {
				return "__greaterOrEqual";
			}
		},
		equal{
			@Override
			public String toString() {
				return "__equal";
			}
		},
		notEqual{
			@Override
			public String toString() {
				return "__notEqual";
			}
		};
		
		public static Operation fromString(String op, FileContext ctx) {
			switch(op) {
			case "<":
				return less;
			case "<=":
				return lessOrEqual;
			case ">":
				return greater;
			case ">=":
				return greaterOrEqual;
			case "==":
				return equal;
			case "!=":
				return notEqual;
			default:
				throw new MScriptCompilationException("Unknown precedence 2 operator: " + op + ".", ctx);
			}
		}
	}
	
	private class Item implements ICompilableModel {
		
		private final Operation operation;
		private final Precedence3Model model;
		
		private Item(Operation operation, Precedence3Model model) {
			Objects.requireNonNull(operation);
			Objects.requireNonNull(model);
			this.operation = operation;
			this.model = model;
		}
		
		@Override
		public String compile(IScriptContext ctx) {
			var sb = new StringBuilder();
			
			sb.append(model.compile(ctx));
			sb.append("jal ").append(MScriptRuntime.destGotoLabel(operation.toString())).append(System.lineSeparator());
			
			return sb.toString();
		}
	}
	
	private Precedence3Model first;
	private List<Item> items = new LinkedList<>();
	
	public Precedence2Model(FileContext ctx) {
		super(ctx);
	}
	
	public void setFirst(Precedence3Model model) {
		this.first = model;
	}
	
	public void add(Operation operation, Precedence3Model model) {
		items.add(new Item(operation, model));
	}

	@Override
	public String compile(IScriptContext ctx) {
		var sb = new StringBuilder();
		
		sb.append(first.compile(ctx));
		for(var item : items)
			sb.append(item.compile(ctx));
		
		return sb.toString();
	}

}
