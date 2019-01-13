package com.inditex.broker.ms.routes;

import org.apache.camel.LoggingLevel;

import org.springframework.context.annotation.Configuration;

import com.inditex.broker.ms.utils.AccionArticulo;
import com.inditex.broker.ms.utils.HeaderArticulo;

@Configuration
public class ArticuloRoute extends ArticuloBaseRoute {
	
	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		//Enrrutador principal de artículos
		from(articuloProperties.getProcessArticulosQueue())
			.log(LoggingLevel.INFO, logger, "INICIO ENRRUTADO ARTICULO. [idMensaje: ${id}]")
			.transacted()
			.choice()
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.ALTA.getAccion()))
                .to(articuloProperties.getAltaArticuloDirect())
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.ELIMINACION.getAccion()))
                .to(articuloProperties.getEliminacionArticuloDirect())
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.MODIFICACION.getAccion()))
                .to(articuloProperties.getModificacionArticuloDirect())
            .otherwise()
            	.log(LoggingLevel.INFO, logger, "Accion no válida: ${body}")
            	.throwException(Exception.class, "Accion no válida: [${in.header.accion}]");
	}
}
