package com.github.The127.MScript;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LabelResolver {

	private Map<String, Integer> sourceLabels = new HashMap<>();
	
	public String resolveLabels(String pseudoCompiledCode) {
		pseudoCompiledCode = pseudoCompiledCode.replaceAll("(?m)^[ \t]*\r?\n", "");
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
		return result.stream().reduce("", (s1, s2) -> s1+System.lineSeparator()+s2).replaceAll("(?m)^[ \t]*\r?\n", "");
	}
}
