package com.inditex.broker.ms.routes;

import org.apache.camel.component.cxf.CxfEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticuloHelperRoute extends ArticuloBaseRoute {
	
	@Qualifier("articuloWS")
	@Autowired
	private CxfEndpoint articuloWS;

	@Override
	public void configure() throws Exception {
		
		super.configure();
		
		//Creación ruta cliente servicio artículos
		from(articuloProperties.getArticuloWsRoute())
			.to(articuloWS);
     
	}
}
