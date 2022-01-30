
package ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmailCheckoutNotificationSync_QNAME = new QName("http://ws.session.ejb/", "emailCheckoutNotificationSync");
    private final static QName _EmailCheckoutNotificationSyncResponse_QNAME = new QName("http://ws.session.ejb/", "emailCheckoutNotificationSyncResponse");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmailCheckoutNotificationSyncResponse }
     * 
     */
    public EmailCheckoutNotificationSyncResponse createEmailCheckoutNotificationSyncResponse() {
        return new EmailCheckoutNotificationSyncResponse();
    }

    /**
     * Create an instance of {@link InvalidLoginCredentialException }
     * 
     */
    public InvalidLoginCredentialException createInvalidLoginCredentialException() {
        return new InvalidLoginCredentialException();
    }

    /**
     * Create an instance of {@link EmailCheckoutNotificationSync }
     * 
     */
    public EmailCheckoutNotificationSync createEmailCheckoutNotificationSync() {
        return new EmailCheckoutNotificationSync();
    }

    /**
     * Create an instance of {@link AppointmentEntity }
     * 
     */
    public AppointmentEntity createAppointmentEntity() {
        return new AppointmentEntity();
    }

    /**
     * Create an instance of {@link BusinessCategoryEntity }
     * 
     */
    public BusinessCategoryEntity createBusinessCategoryEntity() {
        return new BusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailCheckoutNotificationSync }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "emailCheckoutNotificationSync")
    public JAXBElement<EmailCheckoutNotificationSync> createEmailCheckoutNotificationSync(EmailCheckoutNotificationSync value) {
        return new JAXBElement<EmailCheckoutNotificationSync>(_EmailCheckoutNotificationSync_QNAME, EmailCheckoutNotificationSync.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailCheckoutNotificationSyncResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "emailCheckoutNotificationSyncResponse")
    public JAXBElement<EmailCheckoutNotificationSyncResponse> createEmailCheckoutNotificationSyncResponse(EmailCheckoutNotificationSyncResponse value) {
        return new JAXBElement<EmailCheckoutNotificationSyncResponse>(_EmailCheckoutNotificationSyncResponse_QNAME, EmailCheckoutNotificationSyncResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidLoginCredentialException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InvalidLoginCredentialException")
    public JAXBElement<InvalidLoginCredentialException> createInvalidLoginCredentialException(InvalidLoginCredentialException value) {
        return new JAXBElement<InvalidLoginCredentialException>(_InvalidLoginCredentialException_QNAME, InvalidLoginCredentialException.class, null, value);
    }

}
