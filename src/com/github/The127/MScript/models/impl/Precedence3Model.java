/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.Objects;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.ICompilableModel;
import com.github.The127.MScript.models.IScriptContext;

public class Precedence3Model extends AbstractModel {

	public static enum Operation {
		unaryMinus{
			@Override
			public String toString() {
				return "__unaryMinus";
			}
		},
		not{
			@Override
			public String toString() {
				return  "__not";
			}
		};
	}
	
	private class Item implements ICompilableModel {
		
		private final Operation operation;
		private final Precedence4Model model;
		
		private Item(Operation operation, Precedence4Model model) {
			Objects.requireNonNull(operation);
			Objects.requireNonNull(model);
			this.operation = operation;
			this.model = model;
		}

		@Override
		public String compile(IScriptContext ctx) {
			var sb = new StringBuilder();
			
			sb.append(model.compile(ctx));
			sb.append("jal ").append(operation.toString()).append(System.lineSeparator());
			
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
