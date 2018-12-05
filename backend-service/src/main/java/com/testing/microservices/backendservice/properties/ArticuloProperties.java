package com.testing.microservices.backendservice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ArticuloProperties {

	@Value("${backend.endpoints.maestroarticulos}")
	private String maestroArticulosEndpoint;
}
