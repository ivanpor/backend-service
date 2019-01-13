package com.inditex.broker.ms.utils;

public enum Accion {
	
	ALTA(Short.valueOf("1")),
	ELIMINACION(Short.valueOf("2")),
	MODIFICACION(Short.valueOf("3"));
	
	private Short accion;
	
	private Accion(Short accion) {
		this.accion=accion;
	}

	public Short getAccion() {
		return accion;
	}

	public void setAccion(Short accion) {
		this.accion = accion;
	}
}
