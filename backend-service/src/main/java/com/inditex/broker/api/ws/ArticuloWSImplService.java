package com.inditex.broker.api.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.6
 * 2018-12-04T21:56:21.725+01:00
 * Generated source version: 3.2.6
 *
 */
@WebServiceClient(name = "ArticuloWSImplService",
                  wsdlLocation = "file:/tmp/tempdir3142252833767906319.tmp/articuloWS_1.wsdl",
                  targetNamespace = "http://microservices.testing.com/wsarticulo")
public class ArticuloWSImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://microservices.testing.com/wsarticulo", "ArticuloWSImplService");
    public final static QName ArticuloWSPort = new QName("http://microservices.testing.com/wsarticulo", "articuloWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/tmp/tempdir3142252833767906319.tmp/articuloWS_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ArticuloWSImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/tmp/tempdir3142252833767906319.tmp/articuloWS_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ArticuloWSImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ArticuloWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ArticuloWSImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ArticuloWSImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ArticuloWSImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ArticuloWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ArticuloWS
     */
    @WebEndpoint(name = "articuloWSPort")
    public ArticuloWS getArticuloWSPort() {
        return super.getPort(ArticuloWSPort, ArticuloWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArticuloWS
     */
    @WebEndpoint(name = "articuloWSPort")
    public ArticuloWS getArticuloWSPort(WebServiceFeature... features) {
        return super.getPort(ArticuloWSPort, ArticuloWS.class, features);
    }

}
