
package ws.client;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BookingWebService", targetNamespace = "http://ws.session.ejb/", wsdlLocation = "http://localhost:8080/BookingWebService/BookingWebService?WSDL")
public class BookingWebService_Service
    extends Service
{

    private final static URL BOOKINGWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException BOOKINGWEBSERVICE_EXCEPTION;
    private final static QName BOOKINGWEBSERVICE_QNAME = new QName("http://ws.session.ejb/", "BookingWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BookingWebService/BookingWebService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BOOKINGWEBSERVICE_WSDL_LOCATION = url;
        BOOKINGWEBSERVICE_EXCEPTION = e;
    }

    public BookingWebService_Service() {
        super(__getWsdlLocation(), BOOKINGWEBSERVICE_QNAME);
    }

    public BookingWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BOOKINGWEBSERVICE_QNAME, features);
    }

    public BookingWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, BOOKINGWEBSERVICE_QNAME);
    }

    public BookingWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BOOKINGWEBSERVICE_QNAME, features);
    }

    public BookingWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookingWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BookingWebService
     */
    @WebEndpoint(name = "BookingWebServicePort")
    public BookingWebService getBookingWebServicePort() {
        return super.getPort(new QName("http://ws.session.ejb/", "BookingWebServicePort"), BookingWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookingWebService
     */
    @WebEndpoint(name = "BookingWebServicePort")
    public BookingWebService getBookingWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.session.ejb/", "BookingWebServicePort"), BookingWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BOOKINGWEBSERVICE_EXCEPTION!= null) {
            throw BOOKINGWEBSERVICE_EXCEPTION;
        }
        return BOOKINGWEBSERVICE_WSDL_LOCATION;
    }

}
