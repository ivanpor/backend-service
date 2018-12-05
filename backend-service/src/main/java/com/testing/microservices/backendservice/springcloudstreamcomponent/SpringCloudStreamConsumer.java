/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.testing.microservices.backendservice.springcloudstreamcomponent;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultConsumer;
import org.springframework.messaging.SubscribableChannel;


/**
 * The HelloWorld consumer.
 */
public class SpringCloudStreamConsumer extends DefaultConsumer {
    private final SpringCloudStreamEndpoint endpoint;

    public SpringCloudStreamConsumer(SpringCloudStreamEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
        this.endpoint = endpoint;
    }
    
	@Override
	protected void doStart() throws Exception {
		
		SubscribableChannel channel;
		
		// reuse the existing binding target
		if (endpoint.getBeanFactory().containsBean(endpoint.getDestination())) {
			channel = endpoint.getBeanFactory().getBean(endpoint.getDestination(),
					SubscribableChannel.class);
		} else {
			channel = createInputBindingTarget();
		}

		channel.subscribe(message -> {
			Exchange exchange = endpoint.createExchange();
			exchange.getIn().setHeaders(message.getHeaders());
			exchange.getIn().setBody(message.getPayload());
			try {
				getProcessor().process(exchange);
			}
			catch (Exception e) {
				log.error(String.format(
						"Could not process exchange for Spring Cloud Stream binding target '%s'",
						endpoint.getDestination()), e);
			}
		});

		endpoint.getBindingService().bindConsumer(channel, endpoint.getDestination());

		super.doStart();
	}

	/**
	 * Create a {@link SubscribableChannel} and register in the
	 * {@link org.springframework.context.ApplicationContext}
	 */
	private SubscribableChannel createInputBindingTarget() {
		SubscribableChannel channel = (SubscribableChannel) endpoint.getBindingTargetFactory().createInput(endpoint.getDestination());
		endpoint.getBeanFactory().registerSingleton(endpoint.getDestination(), channel);
		channel = (SubscribableChannel) endpoint.getBeanFactory().initializeBean(channel, endpoint.getDestination());
		return channel;
	}
}
