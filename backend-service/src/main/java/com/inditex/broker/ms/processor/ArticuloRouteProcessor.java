package com.inditex.broker.ms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ArticuloRouteProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
    	Throwable cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
        exchange.getIn().setHeader("CausaError", cause.getMessage());
    }
}
