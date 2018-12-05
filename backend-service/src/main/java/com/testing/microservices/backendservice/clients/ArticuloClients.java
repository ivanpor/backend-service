package com.testing.microservices.backendservice.clients;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.testing.microservices.backendservice.properties.ArticuloProperties;
import com.testing.microservices.backendservice.ws.ArticuloWS;
import com.testing.microservices.backendservice.ws.ArticuloWSImplService;

@Component
public class ArticuloClients {

	@Autowired
	private ArticuloProperties articuloProperties;
	
	@Bean
	public ArticuloWS articuloWS() {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ArticuloWS.class);
		factory.setAddress(articuloProperties.getMaestroArticulosEndpoint());

		return (ArticuloWS) factory.create();
	}
}
