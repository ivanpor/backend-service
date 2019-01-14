package com.inditex.broker.ms.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import com.inditex.broker.api.dto.Articulo;
import com.inditex.broker.api.service.ArticuloService;

import com.inditex.broker.ms.processor.ArticuloAltaResponseProcessor;
<<<<<<< HEAD
import com.inditex.broker.ms.utils.HeaderArticulo;
=======
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service

@Configuration
public class ArticuloModificacionRoute extends ArticuloBaseRoute {
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private ArticuloAltaResponseProcessor articuloAltaResponseProcessor;

	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		//modificación de artículos
		from(articuloProperties.getModificacionArticuloDirect())
			.unmarshal().json(JsonLibrary.Jackson, Articulo.class)
			.setHeader(HeaderArticulo.OPERATION_NAME.getKey(), constant(articuloProperties.getModificacionArticulosWs()))
			.bean(articuloService)
			.to(articuloProperties.getArticuloWsRoute())
			.bean(articuloAltaResponseProcessor)
			.marshal()
			.json(JsonLibrary.Jackson)
			.log(LoggingLevel.INFO, logger, "Consuming MODIFICACION: ${body}");
	}
}
