package com.inditex.broker.ms.routes;

import org.apache.camel.builder.RouteBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import com.inditex.broker.api.properties.ArticuloProperties;
import com.inditex.broker.ms.processor.ArticuloRouteProcessor;

@Configuration
public class ArticuloBaseRoute extends RouteBuilder {
	
	@Autowired
	private ArticuloRouteProcessor articuloRouteProcessor;
	
	@Autowired
	protected ArticuloProperties articuloProperties;
	
	protected Logger logger = LoggerFactory.getLogger(ArticuloBaseRoute.class);

	@Override
	public void configure() throws Exception {
     
		//Gestión global de errores en artículos
		errorHandler(deadLetterChannel(articuloProperties.getProcessArticulosErrorQueue())
			.onPrepareFailure(articuloRouteProcessor)
			.useOriginalMessage()
			.redeliveryDelay(articuloProperties.getProcessArticulosDelayRedeliveries())
			.maximumRedeliveries(articuloProperties.getProcessArticulosMaximuRedeliveries())
			.logStackTrace(true)
		);
	}
}
