package com.inditex.broker.api.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-12-04T21:56:21.697+01:00
 * Generated source version: 3.2.6
 *
 */
@WebService(targetNamespace = "http://microservices.testing.com/wsarticulo", name = "articuloWS")
public interface ArticuloWS {

    @WebMethod
    @WebResult(name = "articulo", targetNamespace = "")
    public Articulo saveArticulo(
        @WebParam(name = "arg0", targetNamespace = "")
        ArticuloRequest arg0
    );
}