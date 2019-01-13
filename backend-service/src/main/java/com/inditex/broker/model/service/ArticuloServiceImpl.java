package com.inditex.broker.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.broker.api.dto.Articulo;
import com.inditex.broker.api.service.ArticuloService;
import com.inditex.broker.api.ws.ArticuloRequest;

@Service
@Validated
public class ArticuloServiceImpl implements ArticuloService {
	
//	@Autowired
//	private Logger logger;
	
	private Logger logger = LoggerFactory.getLogger(ArticuloService.class);

	@Override
	public ArticuloRequest procesarArticulo(Articulo articulo){
		
		logger.info("Inicio procesamiento articulo en {tranformarArticulo}");
		
		if("Articulo4".equals(articulo.getCodigo())) {
			logger.info("Error procesamiento articulo en {tranformarArticulo}");
			throw new RuntimeException();
		}
		
		logger.info("Inicio procesamiento articulo en {tranformarArticulo}");
		ArticuloRequest request = new ArticuloRequest();
		request.setCodigo(articulo.getCodigo());
		request.setDescripcion(articulo.getDescripcion());
		logger.info("Fin procesamiento articulo en {tranformarArticulo}");
		return request;
	}
}
