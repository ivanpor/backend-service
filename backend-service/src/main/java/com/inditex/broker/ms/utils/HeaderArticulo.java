package com.inditex.broker.ms.utils;

public enum HeaderArticulo {
	
	ACCION("accion"),
	OPERATION_NAME("operationName");
	
	private String key;
	
	private HeaderArticulo(String key) {
		this.key=key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
