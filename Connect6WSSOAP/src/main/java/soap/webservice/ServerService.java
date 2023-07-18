
package soap.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServerService", targetNamespace = "http://soap/", wsdlLocation = "http://localhost:2280/Connect6?wsdl")
public class ServerService
    extends Service
{

    private final static URL SERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVERSERVICE_EXCEPTION;
    private final static QName SERVERSERVICE_QNAME = new QName("http://soap/", "ServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:2280/Connect6?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVERSERVICE_WSDL_LOCATION = url;
        SERVERSERVICE_EXCEPTION = e;
    }

    public ServerService() {
        super(__getWsdlLocation(), SERVERSERVICE_QNAME);
    }

    public ServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVERSERVICE_QNAME, features);
    }

    public ServerService(URL wsdlLocation) {
        super(wsdlLocation, SERVERSERVICE_QNAME);
    }

    public ServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVERSERVICE_QNAME, features);
    }

    public ServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Server
     */
    @WebEndpoint(name = "ServerPort")
    public Server getServerPort() {
        return super.getPort(new QName("http://soap/", "ServerPort"), Server.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Server
     */
    @WebEndpoint(name = "ServerPort")
    public Server getServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap/", "ServerPort"), Server.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVERSERVICE_EXCEPTION!= null) {
            throw SERVERSERVICE_EXCEPTION;
        }
        return SERVERSERVICE_WSDL_LOCATION;
    }

}
