package com.inditex.broker.config;

import org.apache.camel.component.cxf.CxfEndpoint;

import org.apache.camel.component.cxf.DataFormat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inditex.broker.api.properties.ArticuloProperties;
import com.inditex.broker.api.ws.ArticuloWS;


@Configuration
public class BackendConfiguration {
	
	@Autowired
	private ArticuloProperties articuloProperties;
	
	@Bean
	public CxfEndpoint articuloWS() {
        CxfEndpoint articuloWS = new CxfEndpoint();
        articuloWS.setAddress(articuloProperties.getUrlArticulosWS());
        articuloWS.setServiceClass(ArticuloWS.class);
        articuloWS.setDataFormat(DataFormat.POJO);
        articuloWS.setDefaultOperationName(articuloProperties.getAltaArticulosWs());
        
        return articuloWS;
	}
}
