package com.inditex.broker.ms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Component;

@Component
public class ArticuloAltaResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody(exchange.getIn().getBody(MessageContentsList.class).get(0));
    }
}
