
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

    private final static QName _UpdateCustomer_QNAME = new QName("http://ws.session.ejb/", "updateCustomer");
    private final static QName _UpdateCustomerResponse_QNAME = new QName("http://ws.session.ejb/", "updateCustomerResponse");
    private final static QName _RetrieveCustomerByEmail_QNAME = new QName("http://ws.session.ejb/", "retrieveCustomerByEmail");
    private final static QName _RetrieveCustomerEntityByCustomerId_QNAME = new QName("http://ws.session.ejb/", "retrieveCustomerEntityByCustomerId");
    private final static QName _RetrieveAllCustomers_QNAME = new QName("http://ws.session.ejb/", "retrieveAllCustomers");
    private final static QName _InputDataValidationException_QNAME = new QName("http://ws.session.ejb/", "InputDataValidationException");
    private final static QName _DeleteCustomerResponse_QNAME = new QName("http://ws.session.ejb/", "deleteCustomerResponse");
    private final static QName _RetrieveCustomerEntityByCustomerIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveCustomerEntityByCustomerIdResponse");
    private final static QName _CustomerNotUniqueException_QNAME = new QName("http://ws.session.ejb/", "CustomerNotUniqueException");
    private final static QName _RetrieveCustomerByEmailResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveCustomerByEmailResponse");
    private final static QName _RetrieveAllCustomersResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllCustomersResponse");
    private final static QName _CustomerDeletionException_QNAME = new QName("http://ws.session.ejb/", "CustomerDeletionException");
    private final static QName _CreateNewCustomerResponse_QNAME = new QName("http://ws.session.ejb/", "createNewCustomerResponse");
    private final static QName _UpdateCustomerException_QNAME = new QName("http://ws.session.ejb/", "UpdateCustomerException");
    private final static QName _CreateNewCustomer_QNAME = new QName("http://ws.session.ejb/", "createNewCustomer");
    private final static QName _DeleteCustomer_QNAME = new QName("http://ws.session.ejb/", "deleteCustomer");
    private final static QName _CustomerNotFoundException_QNAME = new QName("http://ws.session.ejb/", "CustomerNotFoundException");
    private final static QName _UnknownPersistenceException_QNAME = new QName("http://ws.session.ejb/", "UnknownPersistenceException");
    private final static QName _CustomerLoginResponse_QNAME = new QName("http://ws.session.ejb/", "customerLoginResponse");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");
    private final static QName _CustomerLogin_QNAME = new QName("http://ws.session.ejb/", "customerLogin");

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
     * Create an instance of {@link CustomerLogin }
     * 
     */
    public CustomerLogin createCustomerLogin() {
        return new CustomerLogin();
    }

    /**
     * Create an instance of {@link UpdateCustomerException }
     * 
     */
    public UpdateCustomerException createUpdateCustomerException() {
        return new UpdateCustomerException();
    }

    /**
     * Create an instance of {@link CreateNewCustomer }
     * 
     */
    public CreateNewCustomer createCreateNewCustomer() {
        return new CreateNewCustomer();
    }

    /**
     * Create an instance of {@link DeleteCustomer }
     * 
     */
    public DeleteCustomer createDeleteCustomer() {
        return new DeleteCustomer();
    }

    /**
     * Create an instance of {@link CustomerNotFoundException }
     * 
     */
    public CustomerNotFoundException createCustomerNotFoundException() {
        return new CustomerNotFoundException();
    }

    /**
     * Create an instance of {@link UnknownPersistenceException }
     * 
     */
    public UnknownPersistenceException createUnknownPersistenceException() {
        return new UnknownPersistenceException();
    }

    /**
     * Create an instance of {@link CustomerLoginResponse }
     * 
     */
    public CustomerLoginResponse createCustomerLoginResponse() {
        return new CustomerLoginResponse();
    }

    /**
     * Create an instance of {@link CustomerNotUniqueException }
     * 
     */
    public CustomerNotUniqueException createCustomerNotUniqueException() {
        return new CustomerNotUniqueException();
    }

    /**
     * Create an instance of {@link RetrieveCustomerByEmailResponse }
     * 
     */
    public RetrieveCustomerByEmailResponse createRetrieveCustomerByEmailResponse() {
        return new RetrieveCustomerByEmailResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllCustomersResponse }
     * 
     */
    public RetrieveAllCustomersResponse createRetrieveAllCustomersResponse() {
        return new RetrieveAllCustomersResponse();
    }

    /**
     * Create an instance of {@link CustomerDeletionException }
     * 
     */
    public CustomerDeletionException createCustomerDeletionException() {
        return new CustomerDeletionException();
    }

    /**
     * Create an instance of {@link CreateNewCustomerResponse }
     * 
     */
    public CreateNewCustomerResponse createCreateNewCustomerResponse() {
        return new CreateNewCustomerResponse();
    }

    /**
     * Create an instance of {@link UpdateCustomer }
     * 
     */
    public UpdateCustomer createUpdateCustomer() {
        return new UpdateCustomer();
    }

    /**
     * Create an instance of {@link UpdateCustomerResponse }
     * 
     */
    public UpdateCustomerResponse createUpdateCustomerResponse() {
        return new UpdateCustomerResponse();
    }

    /**
     * Create an instance of {@link RetrieveCustomerByEmail }
     * 
     */
    public RetrieveCustomerByEmail createRetrieveCustomerByEmail() {
        return new RetrieveCustomerByEmail();
    }

    /**
     * Create an instance of {@link RetrieveCustomerEntityByCustomerId }
     * 
     */
    public RetrieveCustomerEntityByCustomerId createRetrieveCustomerEntityByCustomerId() {
        return new RetrieveCustomerEntityByCustomerId();
    }

    /**
     * Create an instance of {@link RetrieveAllCustomers }
     * 
     */
    public RetrieveAllCustomers createRetrieveAllCustomers() {
        return new RetrieveAllCustomers();
    }

    /**
     * Create an instance of {@link InputDataValidationException }
     * 
     */
    public InputDataValidationException createInputDataValidationException() {
        return new InputDataValidationException();
    }

    /**
     * Create an instance of {@link DeleteCustomerResponse }
     * 
     */
    public DeleteCustomerResponse createDeleteCustomerResponse() {
        return new DeleteCustomerResponse();
    }

    /**
     * Create an instance of {@link RetrieveCustomerEntityByCustomerIdResponse }
     * 
     */
    public RetrieveCustomerEntityByCustomerIdResponse createRetrieveCustomerEntityByCustomerIdResponse() {
        return new RetrieveCustomerEntityByCustomerIdResponse();
    }

    /**
     * Create an instance of {@link AppointmentEntity }
     * 
     */
    public AppointmentEntity createAppointmentEntity() {
        return new AppointmentEntity();
    }

    /**
     * Create an instance of {@link CustomerEntity }
     * 
     */
    public CustomerEntity createCustomerEntity() {
        return new CustomerEntity();
    }

    /**
     * Create an instance of {@link BusinessCategoryEntity }
     * 
     */
    public BusinessCategoryEntity createBusinessCategoryEntity() {
        return new BusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateCustomer")
    public JAXBElement<UpdateCustomer> createUpdateCustomer(UpdateCustomer value) {
        return new JAXBElement<UpdateCustomer>(_UpdateCustomer_QNAME, UpdateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateCustomerResponse")
    public JAXBElement<UpdateCustomerResponse> createUpdateCustomerResponse(UpdateCustomerResponse value) {
        return new JAXBElement<UpdateCustomerResponse>(_UpdateCustomerResponse_QNAME, UpdateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveCustomerByEmail")
    public JAXBElement<RetrieveCustomerByEmail> createRetrieveCustomerByEmail(RetrieveCustomerByEmail value) {
        return new JAXBElement<RetrieveCustomerByEmail>(_RetrieveCustomerByEmail_QNAME, RetrieveCustomerByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerEntityByCustomerId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveCustomerEntityByCustomerId")
    public JAXBElement<RetrieveCustomerEntityByCustomerId> createRetrieveCustomerEntityByCustomerId(RetrieveCustomerEntityByCustomerId value) {
        return new JAXBElement<RetrieveCustomerEntityByCustomerId>(_RetrieveCustomerEntityByCustomerId_QNAME, RetrieveCustomerEntityByCustomerId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllCustomers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllCustomers")
    public JAXBElement<RetrieveAllCustomers> createRetrieveAllCustomers(RetrieveAllCustomers value) {
        return new JAXBElement<RetrieveAllCustomers>(_RetrieveAllCustomers_QNAME, RetrieveAllCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputDataValidationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InputDataValidationException")
    public JAXBElement<InputDataValidationException> createInputDataValidationException(InputDataValidationException value) {
        return new JAXBElement<InputDataValidationException>(_InputDataValidationException_QNAME, InputDataValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteCustomerResponse")
    public JAXBElement<DeleteCustomerResponse> createDeleteCustomerResponse(DeleteCustomerResponse value) {
        return new JAXBElement<DeleteCustomerResponse>(_DeleteCustomerResponse_QNAME, DeleteCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerEntityByCustomerIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveCustomerEntityByCustomerIdResponse")
    public JAXBElement<RetrieveCustomerEntityByCustomerIdResponse> createRetrieveCustomerEntityByCustomerIdResponse(RetrieveCustomerEntityByCustomerIdResponse value) {
        return new JAXBElement<RetrieveCustomerEntityByCustomerIdResponse>(_RetrieveCustomerEntityByCustomerIdResponse_QNAME, RetrieveCustomerEntityByCustomerIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerNotUniqueException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "CustomerNotUniqueException")
    public JAXBElement<CustomerNotUniqueException> createCustomerNotUniqueException(CustomerNotUniqueException value) {
        return new JAXBElement<CustomerNotUniqueException>(_CustomerNotUniqueException_QNAME, CustomerNotUniqueException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveCustomerByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveCustomerByEmailResponse")
    public JAXBElement<RetrieveCustomerByEmailResponse> createRetrieveCustomerByEmailResponse(RetrieveCustomerByEmailResponse value) {
        return new JAXBElement<RetrieveCustomerByEmailResponse>(_RetrieveCustomerByEmailResponse_QNAME, RetrieveCustomerByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllCustomersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllCustomersResponse")
    public JAXBElement<RetrieveAllCustomersResponse> createRetrieveAllCustomersResponse(RetrieveAllCustomersResponse value) {
        return new JAXBElement<RetrieveAllCustomersResponse>(_RetrieveAllCustomersResponse_QNAME, RetrieveAllCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerDeletionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "CustomerDeletionException")
    public JAXBElement<CustomerDeletionException> createCustomerDeletionException(CustomerDeletionException value) {
        return new JAXBElement<CustomerDeletionException>(_CustomerDeletionException_QNAME, CustomerDeletionException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewCustomerResponse")
    public JAXBElement<CreateNewCustomerResponse> createCreateNewCustomerResponse(CreateNewCustomerResponse value) {
        return new JAXBElement<CreateNewCustomerResponse>(_CreateNewCustomerResponse_QNAME, CreateNewCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "UpdateCustomerException")
    public JAXBElement<UpdateCustomerException> createUpdateCustomerException(UpdateCustomerException value) {
        return new JAXBElement<UpdateCustomerException>(_UpdateCustomerException_QNAME, UpdateCustomerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewCustomer")
    public JAXBElement<CreateNewCustomer> createCreateNewCustomer(CreateNewCustomer value) {
        return new JAXBElement<CreateNewCustomer>(_CreateNewCustomer_QNAME, CreateNewCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteCustomer")
    public JAXBElement<DeleteCustomer> createDeleteCustomer(DeleteCustomer value) {
        return new JAXBElement<DeleteCustomer>(_DeleteCustomer_QNAME, DeleteCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "CustomerNotFoundException")
    public JAXBElement<CustomerNotFoundException> createCustomerNotFoundException(CustomerNotFoundException value) {
        return new JAXBElement<CustomerNotFoundException>(_CustomerNotFoundException_QNAME, CustomerNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnknownPersistenceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "UnknownPersistenceException")
    public JAXBElement<UnknownPersistenceException> createUnknownPersistenceException(UnknownPersistenceException value) {
        return new JAXBElement<UnknownPersistenceException>(_UnknownPersistenceException_QNAME, UnknownPersistenceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "customerLoginResponse")
    public JAXBElement<CustomerLoginResponse> createCustomerLoginResponse(CustomerLoginResponse value) {
        return new JAXBElement<CustomerLoginResponse>(_CustomerLoginResponse_QNAME, CustomerLoginResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "customerLogin")
    public JAXBElement<CustomerLogin> createCustomerLogin(CustomerLogin value) {
        return new JAXBElement<CustomerLogin>(_CustomerLogin_QNAME, CustomerLogin.class, null, value);
    }

}
