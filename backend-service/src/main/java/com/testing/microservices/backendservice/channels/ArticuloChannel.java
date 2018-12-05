package com.testing.microservices.backendservice.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ArticuloChannel {
	
	@Input("sincronize")
	public SubscribableChannel sincronize();

}
