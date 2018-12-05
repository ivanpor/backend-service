package com.testing.microservices.backendservice.service.impl;

import org.springframework.stereotype.Service;

import com.testing.microservices.backendservice.api.Articulo;
import com.testing.microservices.backendservice.api.Mensaje;
import com.testing.microservices.backendservice.service.ArticuloService;
import com.testing.microservices.backendservice.ws.ArticuloRequest;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Override
	public ArticuloRequest tranformarArticulo(Mensaje<Articulo> articulo){
		ArticuloRequest request = new ArticuloRequest();
		request.setCodigo(articulo.getMensaje().getCodigo());
		request.setDescripcion(articulo.getMensaje().getDescripcion());
		
		return request;
	}
}
