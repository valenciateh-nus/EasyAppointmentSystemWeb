
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

    private final static QName _CreateNewBusinessCategoryEntityResponse_QNAME = new QName("http://ws.session.ejb/", "createNewBusinessCategoryEntityResponse");
    private final static QName _RetrieveAllBusinessCategories_QNAME = new QName("http://ws.session.ejb/", "retrieveAllBusinessCategories");
    private final static QName _InputDataValidationException_QNAME = new QName("http://ws.session.ejb/", "InputDataValidationException");
    private final static QName _BusinessCategoryNotFoundException_QNAME = new QName("http://ws.session.ejb/", "BusinessCategoryNotFoundException");
    private final static QName _RetrieveBusinessCategoriesByName_QNAME = new QName("http://ws.session.ejb/", "retrieveBusinessCategoriesByName");
    private final static QName _DeleteBusinessCategory_QNAME = new QName("http://ws.session.ejb/", "deleteBusinessCategory");
    private final static QName _RetrieveBusinessCategoriesById_QNAME = new QName("http://ws.session.ejb/", "retrieveBusinessCategoriesById");
    private final static QName _RetrieveAllBusinessCategoriesResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAllBusinessCategoriesResponse");
    private final static QName _UnknownPersistenceException_QNAME = new QName("http://ws.session.ejb/", "UnknownPersistenceException");
    private final static QName _RetrieveBusinessCategoriesByNameResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveBusinessCategoriesByNameResponse");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");
    private final static QName _DeleteBusinessCategoryResponse_QNAME = new QName("http://ws.session.ejb/", "deleteBusinessCategoryResponse");
    private final static QName _BusinessCategoryExistException_QNAME = new QName("http://ws.session.ejb/", "BusinessCategoryExistException");
    private final static QName _CreateNewBusinessCategoryEntity_QNAME = new QName("http://ws.session.ejb/", "createNewBusinessCategoryEntity");
    private final static QName _DeleteBusinessCategoryException_QNAME = new QName("http://ws.session.ejb/", "DeleteBusinessCategoryException");
    private final static QName _RetrieveBusinessCategoriesByIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveBusinessCategoriesByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveBusinessCategoriesByNameResponse }
     * 
     */
    public RetrieveBusinessCategoriesByNameResponse createRetrieveBusinessCategoriesByNameResponse() {
        return new RetrieveBusinessCategoriesByNameResponse();
    }

    /**
     * Create an instance of {@link InvalidLoginCredentialException }
     * 
     */
    public InvalidLoginCredentialException createInvalidLoginCredentialException() {
        return new InvalidLoginCredentialException();
    }

    /**
     * Create an instance of {@link DeleteBusinessCategoryResponse }
     * 
     */
    public DeleteBusinessCategoryResponse createDeleteBusinessCategoryResponse() {
        return new DeleteBusinessCategoryResponse();
    }

    /**
     * Create an instance of {@link BusinessCategoryExistException }
     * 
     */
    public BusinessCategoryExistException createBusinessCategoryExistException() {
        return new BusinessCategoryExistException();
    }

    /**
     * Create an instance of {@link CreateNewBusinessCategoryEntity }
     * 
     */
    public CreateNewBusinessCategoryEntity createCreateNewBusinessCategoryEntity() {
        return new CreateNewBusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link DeleteBusinessCategoryException }
     * 
     */
    public DeleteBusinessCategoryException createDeleteBusinessCategoryException() {
        return new DeleteBusinessCategoryException();
    }

    /**
     * Create an instance of {@link RetrieveBusinessCategoriesByIdResponse }
     * 
     */
    public RetrieveBusinessCategoriesByIdResponse createRetrieveBusinessCategoriesByIdResponse() {
        return new RetrieveBusinessCategoriesByIdResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllBusinessCategoriesResponse }
     * 
     */
    public RetrieveAllBusinessCategoriesResponse createRetrieveAllBusinessCategoriesResponse() {
        return new RetrieveAllBusinessCategoriesResponse();
    }

    /**
     * Create an instance of {@link UnknownPersistenceException }
     * 
     */
    public UnknownPersistenceException createUnknownPersistenceException() {
        return new UnknownPersistenceException();
    }

    /**
     * Create an instance of {@link BusinessCategoryNotFoundException }
     * 
     */
    public BusinessCategoryNotFoundException createBusinessCategoryNotFoundException() {
        return new BusinessCategoryNotFoundException();
    }

    /**
     * Create an instance of {@link RetrieveBusinessCategoriesByName }
     * 
     */
    public RetrieveBusinessCategoriesByName createRetrieveBusinessCategoriesByName() {
        return new RetrieveBusinessCategoriesByName();
    }

    /**
     * Create an instance of {@link DeleteBusinessCategory }
     * 
     */
    public DeleteBusinessCategory createDeleteBusinessCategory() {
        return new DeleteBusinessCategory();
    }

    /**
     * Create an instance of {@link RetrieveBusinessCategoriesById }
     * 
     */
    public RetrieveBusinessCategoriesById createRetrieveBusinessCategoriesById() {
        return new RetrieveBusinessCategoriesById();
    }

    /**
     * Create an instance of {@link CreateNewBusinessCategoryEntityResponse }
     * 
     */
    public CreateNewBusinessCategoryEntityResponse createCreateNewBusinessCategoryEntityResponse() {
        return new CreateNewBusinessCategoryEntityResponse();
    }

    /**
     * Create an instance of {@link RetrieveAllBusinessCategories }
     * 
     */
    public RetrieveAllBusinessCategories createRetrieveAllBusinessCategories() {
        return new RetrieveAllBusinessCategories();
    }

    /**
     * Create an instance of {@link InputDataValidationException }
     * 
     */
    public InputDataValidationException createInputDataValidationException() {
        return new InputDataValidationException();
    }

    /**
     * Create an instance of {@link BusinessCategoryEntity }
     * 
     */
    public BusinessCategoryEntity createBusinessCategoryEntity() {
        return new BusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewBusinessCategoryEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewBusinessCategoryEntityResponse")
    public JAXBElement<CreateNewBusinessCategoryEntityResponse> createCreateNewBusinessCategoryEntityResponse(CreateNewBusinessCategoryEntityResponse value) {
        return new JAXBElement<CreateNewBusinessCategoryEntityResponse>(_CreateNewBusinessCategoryEntityResponse_QNAME, CreateNewBusinessCategoryEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllBusinessCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllBusinessCategories")
    public JAXBElement<RetrieveAllBusinessCategories> createRetrieveAllBusinessCategories(RetrieveAllBusinessCategories value) {
        return new JAXBElement<RetrieveAllBusinessCategories>(_RetrieveAllBusinessCategories_QNAME, RetrieveAllBusinessCategories.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessCategoryNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "BusinessCategoryNotFoundException")
    public JAXBElement<BusinessCategoryNotFoundException> createBusinessCategoryNotFoundException(BusinessCategoryNotFoundException value) {
        return new JAXBElement<BusinessCategoryNotFoundException>(_BusinessCategoryNotFoundException_QNAME, BusinessCategoryNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveBusinessCategoriesByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveBusinessCategoriesByName")
    public JAXBElement<RetrieveBusinessCategoriesByName> createRetrieveBusinessCategoriesByName(RetrieveBusinessCategoriesByName value) {
        return new JAXBElement<RetrieveBusinessCategoriesByName>(_RetrieveBusinessCategoriesByName_QNAME, RetrieveBusinessCategoriesByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusinessCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteBusinessCategory")
    public JAXBElement<DeleteBusinessCategory> createDeleteBusinessCategory(DeleteBusinessCategory value) {
        return new JAXBElement<DeleteBusinessCategory>(_DeleteBusinessCategory_QNAME, DeleteBusinessCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveBusinessCategoriesById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveBusinessCategoriesById")
    public JAXBElement<RetrieveBusinessCategoriesById> createRetrieveBusinessCategoriesById(RetrieveBusinessCategoriesById value) {
        return new JAXBElement<RetrieveBusinessCategoriesById>(_RetrieveBusinessCategoriesById_QNAME, RetrieveBusinessCategoriesById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAllBusinessCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAllBusinessCategoriesResponse")
    public JAXBElement<RetrieveAllBusinessCategoriesResponse> createRetrieveAllBusinessCategoriesResponse(RetrieveAllBusinessCategoriesResponse value) {
        return new JAXBElement<RetrieveAllBusinessCategoriesResponse>(_RetrieveAllBusinessCategoriesResponse_QNAME, RetrieveAllBusinessCategoriesResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveBusinessCategoriesByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveBusinessCategoriesByNameResponse")
    public JAXBElement<RetrieveBusinessCategoriesByNameResponse> createRetrieveBusinessCategoriesByNameResponse(RetrieveBusinessCategoriesByNameResponse value) {
        return new JAXBElement<RetrieveBusinessCategoriesByNameResponse>(_RetrieveBusinessCategoriesByNameResponse_QNAME, RetrieveBusinessCategoriesByNameResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusinessCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteBusinessCategoryResponse")
    public JAXBElement<DeleteBusinessCategoryResponse> createDeleteBusinessCategoryResponse(DeleteBusinessCategoryResponse value) {
        return new JAXBElement<DeleteBusinessCategoryResponse>(_DeleteBusinessCategoryResponse_QNAME, DeleteBusinessCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessCategoryExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "BusinessCategoryExistException")
    public JAXBElement<BusinessCategoryExistException> createBusinessCategoryExistException(BusinessCategoryExistException value) {
        return new JAXBElement<BusinessCategoryExistException>(_BusinessCategoryExistException_QNAME, BusinessCategoryExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewBusinessCategoryEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewBusinessCategoryEntity")
    public JAXBElement<CreateNewBusinessCategoryEntity> createCreateNewBusinessCategoryEntity(CreateNewBusinessCategoryEntity value) {
        return new JAXBElement<CreateNewBusinessCategoryEntity>(_CreateNewBusinessCategoryEntity_QNAME, CreateNewBusinessCategoryEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBusinessCategoryException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "DeleteBusinessCategoryException")
    public JAXBElement<DeleteBusinessCategoryException> createDeleteBusinessCategoryException(DeleteBusinessCategoryException value) {
        return new JAXBElement<DeleteBusinessCategoryException>(_DeleteBusinessCategoryException_QNAME, DeleteBusinessCategoryException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveBusinessCategoriesByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveBusinessCategoriesByIdResponse")
    public JAXBElement<RetrieveBusinessCategoriesByIdResponse> createRetrieveBusinessCategoriesByIdResponse(RetrieveBusinessCategoriesByIdResponse value) {
        return new JAXBElement<RetrieveBusinessCategoriesByIdResponse>(_RetrieveBusinessCategoriesByIdResponse_QNAME, RetrieveBusinessCategoriesByIdResponse.class, null, value);
    }

}
