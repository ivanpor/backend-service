package com.testing.microservices.backendservice.service;

import com.testing.microservices.backendservice.api.Articulo;
import com.testing.microservices.backendservice.api.Mensaje;
import com.testing.microservices.backendservice.ws.ArticuloRequest;

public interface ArticuloService {

	public ArticuloRequest tranformarArticulo(Mensaje<Articulo> lista);
}
