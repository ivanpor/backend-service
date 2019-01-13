package com.inditex.broker.ms.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.inditex.broker.api.properties.ArticuloProperties;

import com.inditex.broker.ms.processor.ArticuloRouteProcessor;
import com.inditex.broker.ms.utils.Accion;
import com.inditex.broker.ms.utils.Header;

@Configuration
public class ArticuloRoute extends RouteBuilder {
	
	@Autowired
	private ArticuloProperties articuloProperties;
	
	@Autowired
	private ArticuloRouteProcessor articuloRouteProcessor;
	
	@Qualifier("articuloWS")
	@Autowired
	private CxfEndpoint articuloWS;
	
	private Logger logger = LoggerFactory.getLogger(ArticuloAltaRoute.class);

	@Override
	public void configure() throws Exception {
		
		//Gestión errores para todas las acciones en artículos
		errorHandler(deadLetterChannel(articuloProperties.getProcessArticulosErrorQueue())
			.onPrepareFailure(articuloRouteProcessor)
			.useOriginalMessage()
			.redeliveryDelay(articuloProperties.getProcessArticulosDelayRedeliveries())
			.maximumRedeliveries(articuloProperties.getProcessArticulosMaximuRedeliveries())
			.log(logger)
		);
		
		//Enrrutador principal de artículos
		from(articuloProperties.getProcessArticulosQueue())
			.log(LoggingLevel.INFO, logger, "INICIO ENRRUTADO ARTICULO. [idMensaje: ${id}]")
			.transacted()
			.choice()
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.ALTA.getAccion()))
                .to(articuloProperties.getAltaArticuloDirect())
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.ELIMINACION.getAccion()))
                .to(articuloProperties.getEliminacionArticuloDirect())
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.MODIFICACION.getAccion()))
                .to(articuloProperties.getModificacionArticuloDirect())
            .otherwise()
            	.log(LoggingLevel.INFO, logger, "Accion no válida: ${body}")
            	.throwException(Exception.class, "Accion no válida: [${in.header.accion}]");
	}
}
