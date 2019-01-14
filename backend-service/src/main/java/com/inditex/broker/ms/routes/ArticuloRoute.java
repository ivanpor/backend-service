package com.inditex.broker.ms.routes;

import org.apache.camel.LoggingLevel;

<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
import com.inditex.broker.ms.utils.AccionArticulo;
import com.inditex.broker.ms.utils.HeaderArticulo;
=======
import com.inditex.broker.api.properties.ArticuloProperties;

import com.inditex.broker.ms.processor.ArticuloRouteProcessor;
import com.inditex.broker.ms.utils.Accion;
import com.inditex.broker.ms.utils.Header;
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service

@Configuration
public class ArticuloRoute extends ArticuloBaseRoute {
	
<<<<<<< HEAD
=======
	@Autowired
	private ArticuloProperties articuloProperties;
	
	@Autowired
	private ArticuloRouteProcessor articuloRouteProcessor;
	
	@Qualifier("articuloWS")
	@Autowired
	private CxfEndpoint articuloWS;
	
	private Logger logger = LoggerFactory.getLogger(ArticuloAltaRoute.class);

>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service
	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		//Enrrutador principal de artículos
		from(articuloProperties.getProcessArticulosQueue())
			.log(LoggingLevel.INFO, logger, "INICIO ENRRUTADO ARTICULO. [idMensaje: ${id}]")
			.transacted()
			.choice()
<<<<<<< HEAD
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.ALTA.getAccion()))
=======
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.ALTA.getAccion()))
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service
                .to(articuloProperties.getAltaArticuloDirect())
<<<<<<< HEAD
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.ELIMINACION.getAccion()))
=======
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.ELIMINACION.getAccion()))
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service
                .to(articuloProperties.getEliminacionArticuloDirect())
<<<<<<< HEAD
            .when(header(HeaderArticulo.ACCION.getKey()).isEqualTo(AccionArticulo.MODIFICACION.getAccion()))
=======
            .when(header(Header.ACCION.getKey()).isEqualTo(Accion.MODIFICACION.getAccion()))
>>>>>>> branch 'master' of https://github.com/ivanpor/backend-service
                .to(articuloProperties.getModificacionArticuloDirect())
            .otherwise()
            	.log(LoggingLevel.INFO, logger, "Accion no válida: ${body}")
            	.throwException(Exception.class, "Accion no válida: [${in.header.accion}]");
	}
}
