package com.inditex.broker.ms.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;

import org.apache.camel.model.dataformat.JsonLibrary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.inditex.broker.api.dto.Articulo;
import com.inditex.broker.api.properties.ArticuloProperties;
import com.inditex.broker.api.service.ArticuloService;

import com.inditex.broker.ms.processor.ArticuloAltaResponseProcessor;

@Configuration
public class ArticuloAltaRoute extends RouteBuilder {
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private ArticuloProperties articuloProperties;
	
	@Autowired
	private ArticuloAltaResponseProcessor articuloAltaResponseProcessor;
	
	@Qualifier("articuloWS")
	@Autowired
	private CxfEndpoint articuloWS;
	
	private Logger logger = LoggerFactory.getLogger(ArticuloAltaRoute.class);

	@Override
	public void configure() throws Exception {
		
		//Proceso y registro de artículos
		from(articuloProperties.getAltaArticuloDirect())
			.unmarshal().json(JsonLibrary.Jackson, Articulo.class)
			.bean(articuloService)
			.to(articuloWS)
			.bean(articuloAltaResponseProcessor)
			.marshal()
			.json(JsonLibrary.Jackson)
			.log(LoggingLevel.INFO, logger, "Consuming ALTA: ${body}");
	}
}
