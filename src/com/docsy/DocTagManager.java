package com.docsy;

import java.util.HashMap;
import java.util.Map;

public class DocTagManager {
	
	private static Map<String,DocTags> tagManager= new HashMap<String,DocTags>();
	public static void	register(String name,DocTags tag) {
		tagManager.put(name, tag);
	}
	
	public static DocTags getTag(String name) {
		return tagManager.get(name);
	}

}
