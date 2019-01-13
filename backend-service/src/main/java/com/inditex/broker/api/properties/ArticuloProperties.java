package com.inditex.broker.api.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ArticuloProperties {
	
	@Value("${batchservice.articulos.endpoints.queue.process.destination}")
	private String processArticulosQueue;
	
	@Value("${batchservice.articulos.endpoints.queue.process.destinationError}")
	private String processArticulosErrorQueue;
	
	@Value("${batchservice.articulos.endpoints.queue.process.maximuRedeliveries}")
	private int processArticulosMaximuRedeliveries;
	
	@Value("${batchservice.articulos.endpoints.queue.process.delayRedeliveries}")
	private long processArticulosDelayRedeliveries;
	
	@Value("${batchservice.articulos.endpoints.ws.url}")
	private String urlArticulosWS;
	
	@Value("${batchservice.articulos.endpoints.ws.alta}")
	private String altaArticulosWs;
	
	@Value("${batchservice.articulos.endpoints.ws.eliminacion}")
	private String eliminacionArticulosWs;
	
	@Value("${batchservice.articulos.endpoints.ws.modificacion}")
	private String modificacionArticulosWs;
	
	@Value("${batchservice.articulos.endpoints.direct.articuloWsRoute}")
	private String articuloWsRoute;
	
	@Value("${batchservice.articulos.endpoints.direct.altaArticulo}")
	private String altaArticuloDirect;
	
	@Value("${batchservice.articulos.endpoints.direct.eliminacionArticulo}")
	private String eliminacionArticuloDirect;
	
	@Value("${batchservice.articulos.endpoints.direct.modificacionArticulo}")
	private String modificacionArticuloDirect;
	
	
}
