package com.tourist.attribute;

import java.util.HashMap;
import java.util.Map;

public class Session {
	
	private static Session session = new Session();
	private Session() {}
	public static Session getSession() {
		return session;
	}
//정보를 넣고 뺄수있는공간
	private Map<String, Object> attributMap = new HashMap<String, Object>();

	public void setAttribute(String key, Object value) {
		attributMap.put(key, value);

	}

	public Object getAttribute(String key) {
		return attributMap.get(key);
	}
}


