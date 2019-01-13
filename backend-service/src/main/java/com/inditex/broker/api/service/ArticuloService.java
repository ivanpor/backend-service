package com.inditex.broker.api.service;

import com.inditex.broker.api.dto.Articulo;
import com.inditex.broker.api.ws.ArticuloRequest;

public interface ArticuloService {

	public ArticuloRequest procesarArticulo(Articulo lista);
}
