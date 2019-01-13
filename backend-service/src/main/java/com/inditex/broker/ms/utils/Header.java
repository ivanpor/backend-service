package com.inditex.broker.ms.utils;

public enum Header {
	
	ACCION("accion");
	
	private String key;
	
	private Header(String key) {
		this.key=key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
