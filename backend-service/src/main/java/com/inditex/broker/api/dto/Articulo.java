package com.inditex.broker.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Articulo implements Serializable {

	private static final long serialVersionUID = -6678713103696107457L;
	
	private String codigo;
	private String descripcion;
	private Short accion;

}
