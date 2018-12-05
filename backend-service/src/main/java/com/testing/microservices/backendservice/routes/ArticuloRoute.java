package com.testing.microservices.backendservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.testing.microservices.backendservice.channels.ArticuloChannel;
import com.testing.microservices.backendservice.service.ArticuloService;

@EnableBinding(ArticuloChannel.class)
public class ArticuloRoute extends RouteBuilder {
	
	@Autowired
	private ArticuloService articuloService;

	@Override
	public void configure() throws Exception {
		
//    	errorHandler(transactionErrorHandler()º
//		.maximumRedeliveries(3)
//		.redeliveryDelay(1000)
//		.log("Error artículos"));
	
//		errorHandler(deadLetterChannel("springcloudstream://sincronizeerror")
//			.redeliveryDelay(1000)
//			.maximumRedeliveries(3)
//			.log("Error artículos")
//		);
		
		from("springcloudstream://sincronize")
			.unmarshal().json(JsonLibrary.Jackson)
			.bean(articuloService,"tranformarArticulo(${body})")
			.to("cxfbean:articuloWS?defaultOperationName=saveArticulo")
			.log("Consuming: ${body}");
	}
}
