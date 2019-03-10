package com.github.The127.MScript;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LabelResolver {

	private Map<String, Integer> sourceLabels = new HashMap<>();
	
	public void resolveLabels(String pseudoCompiledCode) {
		var code = new LinkedList<String>();
		var lines = pseudoCompiledCode.split(System.lineSeparator());
		int lineIndex = 0;
		for(var line : lines) {
			if(line.startsWith("{source::")) {
				// remember line of label
				sourceLabels.put(line.trim(), lineIndex);
			}else {
				code.add(line);
				lineIndex++;
			}
		}
		var result = new LinkedList<String>();
		code.forEach(line -> {
			if(line.contains("{dest::")) {
				var labelIndex = line.indexOf("{");
				var label = line.substring(labelIndex);
				var source = label.replace("{dest", "{source");
				if(sourceLabels.get(source) == null)
					throw new MScriptCompilationException("Could not find source label: " + source);
				result.add(line.replace(label, ""+sourceLabels.get(source)));
			}else {
				result.add(line);
			}
		});
		result.forEach(System.out::println);
	}
}
