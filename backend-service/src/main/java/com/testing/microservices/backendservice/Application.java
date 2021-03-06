package com.testing.microservices.backendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.testing.microservices.backendservice.channels.ArticuloChannel;

//@EnableCircuitBreaker
//@EnableResourceServer
//@EnableEurekaClient
@RefreshScope
@SpringBootApplication
public class Application 
{
    public static void main( String[] args ){
        SpringApplication.run(Application.class, args);
    }
}
