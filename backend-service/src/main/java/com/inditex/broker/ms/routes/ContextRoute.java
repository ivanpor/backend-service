package com.inditex.broker.ms.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextRoute extends RouteBuilder {
	
	@Qualifier("articuloWS")
	@Autowired
	private CxfEndpoint articuloWS;

	@Override
	public void configure() throws Exception {
		
		CamelContext camelContext = getContext();
		articuloWS.setCamelContext(camelContext);
        camelContext.addEndpoint("articuloWS", articuloWS);

	}
}
