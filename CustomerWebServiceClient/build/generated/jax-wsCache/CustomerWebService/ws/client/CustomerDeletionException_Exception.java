
package ws.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CustomerDeletionException", targetNamespace = "http://ws.session.ejb/")
public class CustomerDeletionException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CustomerDeletionException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CustomerDeletionException_Exception(String message, CustomerDeletionException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public CustomerDeletionException_Exception(String message, CustomerDeletionException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ws.client.CustomerDeletionException
     */
    public CustomerDeletionException getFaultInfo() {
        return faultInfo;
    }

}
