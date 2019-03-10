/**
 * MIT License
 * Copyright (c) 2019 Julian Baehr and David Brandt
 */
package com.github.The127.MScript.models.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.github.The127.MScript.FileContext;
import com.github.The127.MScript.models.ICompilableModel;
import com.github.The127.MScript.models.IScriptContext;
import com.github.The127.MScript.rt.MScriptRuntime;

public class Precedence5Model extends AbstractModel {

	public static enum Operation {
		mul {
			@Override
			public String toString() {
				return "__mul";
			}
		},
		div {
			@Override
			public String toString() {
				return "__div";
			}
		},
		mod {
			@Override
			public String toString() {
				return "__mod";
			}
		};
	}
	
	private class Item implements ICompilableModel {
		
		private final Operation operation;
		private final AtomModel model;
		
		private Item(Operation operation, AtomModel model) {
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
	
	private AtomModel first;
	private List<Item> items = new LinkedList<>();

	public Precedence5Model(FileContext ctx) {
		super(ctx);
	}
	
	public void setFirst(AtomModel model) {
		this.first = model;
	}
	
	public void add(Operation operation, AtomModel model) {
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
