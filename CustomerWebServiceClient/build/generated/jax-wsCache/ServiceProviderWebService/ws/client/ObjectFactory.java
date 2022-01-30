
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

    private final static QName _RetrieveAllServiceProviderEntity_QNAME = new QName("http://ws.session.ejb/", "retrieveAllServiceProviderEntity");
    private final static QName _RetrieveServiceProviderEntityBySearchResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityBySearchResponse");
    private final static QName _ServiceProviderNotFoundException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderNotFoundException");
    private final static QName _RetrieveServiceProviderEntityByEmail_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityByEmail");
    private final static QName _UpdateRating_QNAME = new QName("http://ws.session.ejb/", "updateRating");
    private final static QName _RetrieveServiceProviderEntityByNameResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityByNameResponse");
    private final static QName _ServiceProviderBlockedException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderBlockedException");
    private final static QName _RetrieveServiceProviderEntityById_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityById");
    private final static QName _RetrieveServiceProviderEntityByName_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityByName");
    private final static QName _UpdateRatingResponse_QNAME = new QName("http://ws.session.ejb/", "updateRatingResponse");
    private final static QName _RetrieveServiceProviderEntityByEmailResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityByEmailResponse");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");
    private final static QName _RetrieveServiceProviderEntityByIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityByIdResponse");
    private final static QName _RetrieveServiceProviderEntityBySearch_QNAME = new QName("http://ws.session.ejb/", "retrieveServiceProviderEntityBySearch");
    private final static QName _RetrieveAllServiceProviderEntityResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllServiceProviderEntityResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvalidLoginCredentialException }
     * 
     */
    public InvalidLoginCredentialException createInvalidLoginCredentialException() {
        return new InvalidLoginCredentialException();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityByIdResponse }
     * 
     */
    public RetrieveServiceProviderEntityByIdResponse createRetrieveServiceProviderEntityByIdResponse() {
        return new RetrieveServiceProviderEntityByIdResponse();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityBySearch }
     * 
     */
    public RetrieveServiceProviderEntityBySearch createRetrieveServiceProviderEntityBySearch() {
        return new RetrieveServiceProviderEntityBySearch();
    }

    /**
     * Create an instance of {@link RetrieveAllServiceProviderEntityResponse }
     * 
     */
    public RetrieveAllServiceProviderEntityResponse createRetrieveAllServiceProviderEntityResponse() {
        return new RetrieveAllServiceProviderEntityResponse();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityByNameResponse }
     * 
     */
    public RetrieveServiceProviderEntityByNameResponse createRetrieveServiceProviderEntityByNameResponse() {
        return new RetrieveServiceProviderEntityByNameResponse();
    }

    /**
     * Create an instance of {@link ServiceProviderBlockedException }
     * 
     */
    public ServiceProviderBlockedException createServiceProviderBlockedException() {
        return new ServiceProviderBlockedException();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityById }
     * 
     */
    public RetrieveServiceProviderEntityById createRetrieveServiceProviderEntityById() {
        return new RetrieveServiceProviderEntityById();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityByName }
     * 
     */
    public RetrieveServiceProviderEntityByName createRetrieveServiceProviderEntityByName() {
        return new RetrieveServiceProviderEntityByName();
    }

    /**
     * Create an instance of {@link UpdateRatingResponse }
     * 
     */
    public UpdateRatingResponse createUpdateRatingResponse() {
        return new UpdateRatingResponse();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityByEmailResponse }
     * 
     */
    public RetrieveServiceProviderEntityByEmailResponse createRetrieveServiceProviderEntityByEmailResponse() {
        return new RetrieveServiceProviderEntityByEmailResponse();
    }

    /**
     * Create an instance of {@link UpdateRating }
     * 
     */
    public UpdateRating createUpdateRating() {
        return new UpdateRating();
    }

    /**
     * Create an instance of {@link RetrieveAllServiceProviderEntity }
     * 
     */
    public RetrieveAllServiceProviderEntity createRetrieveAllServiceProviderEntity() {
        return new RetrieveAllServiceProviderEntity();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityBySearchResponse }
     * 
     */
    public RetrieveServiceProviderEntityBySearchResponse createRetrieveServiceProviderEntityBySearchResponse() {
        return new RetrieveServiceProviderEntityBySearchResponse();
    }

    /**
     * Create an instance of {@link ServiceProviderNotFoundException }
     * 
     */
    public ServiceProviderNotFoundException createServiceProviderNotFoundException() {
        return new ServiceProviderNotFoundException();
    }

    /**
     * Create an instance of {@link RetrieveServiceProviderEntityByEmail }
     * 
     */
    public RetrieveServiceProviderEntityByEmail createRetrieveServiceProviderEntityByEmail() {
        return new RetrieveServiceProviderEntityByEmail();
    }

    /**
     * Create an instance of {@link AppointmentEntity }
     * 
     */
    public AppointmentEntity createAppointmentEntity() {
        return new AppointmentEntity();
    }

    /**
     * Create an instance of {@link ServiceProviderEntity }
     * 
     */
    public ServiceProviderEntity createServiceProviderEntity() {
        return new ServiceProviderEntity();
    }

    /**
     * Create an instance of {@link BusinessCategoryEntity }
     * 
     */
    public BusinessCategoryEntity createBusinessCategoryEntity() {
        return new BusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllServiceProviderEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllServiceProviderEntity")
    public JAXBElement<RetrieveAllServiceProviderEntity> createRetrieveAllServiceProviderEntity(RetrieveAllServiceProviderEntity value) {
        return new JAXBElement<RetrieveAllServiceProviderEntity>(_RetrieveAllServiceProviderEntity_QNAME, RetrieveAllServiceProviderEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityBySearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityBySearchResponse")
    public JAXBElement<RetrieveServiceProviderEntityBySearchResponse> createRetrieveServiceProviderEntityBySearchResponse(RetrieveServiceProviderEntityBySearchResponse value) {
        return new JAXBElement<RetrieveServiceProviderEntityBySearchResponse>(_RetrieveServiceProviderEntityBySearchResponse_QNAME, RetrieveServiceProviderEntityBySearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceProviderNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ServiceProviderNotFoundException")
    public JAXBElement<ServiceProviderNotFoundException> createServiceProviderNotFoundException(ServiceProviderNotFoundException value) {
        return new JAXBElement<ServiceProviderNotFoundException>(_ServiceProviderNotFoundException_QNAME, ServiceProviderNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityByEmail")
    public JAXBElement<RetrieveServiceProviderEntityByEmail> createRetrieveServiceProviderEntityByEmail(RetrieveServiceProviderEntityByEmail value) {
        return new JAXBElement<RetrieveServiceProviderEntityByEmail>(_RetrieveServiceProviderEntityByEmail_QNAME, RetrieveServiceProviderEntityByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRating }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateRating")
    public JAXBElement<UpdateRating> createUpdateRating(UpdateRating value) {
        return new JAXBElement<UpdateRating>(_UpdateRating_QNAME, UpdateRating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityByNameResponse")
    public JAXBElement<RetrieveServiceProviderEntityByNameResponse> createRetrieveServiceProviderEntityByNameResponse(RetrieveServiceProviderEntityByNameResponse value) {
        return new JAXBElement<RetrieveServiceProviderEntityByNameResponse>(_RetrieveServiceProviderEntityByNameResponse_QNAME, RetrieveServiceProviderEntityByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceProviderBlockedException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ServiceProviderBlockedException")
    public JAXBElement<ServiceProviderBlockedException> createServiceProviderBlockedException(ServiceProviderBlockedException value) {
        return new JAXBElement<ServiceProviderBlockedException>(_ServiceProviderBlockedException_QNAME, ServiceProviderBlockedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityById")
    public JAXBElement<RetrieveServiceProviderEntityById> createRetrieveServiceProviderEntityById(RetrieveServiceProviderEntityById value) {
        return new JAXBElement<RetrieveServiceProviderEntityById>(_RetrieveServiceProviderEntityById_QNAME, RetrieveServiceProviderEntityById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityByName")
    public JAXBElement<RetrieveServiceProviderEntityByName> createRetrieveServiceProviderEntityByName(RetrieveServiceProviderEntityByName value) {
        return new JAXBElement<RetrieveServiceProviderEntityByName>(_RetrieveServiceProviderEntityByName_QNAME, RetrieveServiceProviderEntityByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRatingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateRatingResponse")
    public JAXBElement<UpdateRatingResponse> createUpdateRatingResponse(UpdateRatingResponse value) {
        return new JAXBElement<UpdateRatingResponse>(_UpdateRatingResponse_QNAME, UpdateRatingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityByEmailResponse")
    public JAXBElement<RetrieveServiceProviderEntityByEmailResponse> createRetrieveServiceProviderEntityByEmailResponse(RetrieveServiceProviderEntityByEmailResponse value) {
        return new JAXBElement<RetrieveServiceProviderEntityByEmailResponse>(_RetrieveServiceProviderEntityByEmailResponse_QNAME, RetrieveServiceProviderEntityByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidLoginCredentialException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InvalidLoginCredentialException")
    public JAXBElement<InvalidLoginCredentialException> createInvalidLoginCredentialException(InvalidLoginCredentialException value) {
        return new JAXBElement<InvalidLoginCredentialException>(_InvalidLoginCredentialException_QNAME, InvalidLoginCredentialException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityByIdResponse")
    public JAXBElement<RetrieveServiceProviderEntityByIdResponse> createRetrieveServiceProviderEntityByIdResponse(RetrieveServiceProviderEntityByIdResponse value) {
        return new JAXBElement<RetrieveServiceProviderEntityByIdResponse>(_RetrieveServiceProviderEntityByIdResponse_QNAME, RetrieveServiceProviderEntityByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveServiceProviderEntityBySearch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveServiceProviderEntityBySearch")
    public JAXBElement<RetrieveServiceProviderEntityBySearch> createRetrieveServiceProviderEntityBySearch(RetrieveServiceProviderEntityBySearch value) {
        return new JAXBElement<RetrieveServiceProviderEntityBySearch>(_RetrieveServiceProviderEntityBySearch_QNAME, RetrieveServiceProviderEntityBySearch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllServiceProviderEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllServiceProviderEntityResponse")
    public JAXBElement<RetrieveAllServiceProviderEntityResponse> createRetrieveAllServiceProviderEntityResponse(RetrieveAllServiceProviderEntityResponse value) {
        return new JAXBElement<RetrieveAllServiceProviderEntityResponse>(_RetrieveAllServiceProviderEntityResponse_QNAME, RetrieveAllServiceProviderEntityResponse.class, null, value);
    }

}
