
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

    private final static QName _SetAppointmentNoResponse_QNAME = new QName("http://ws.session.ejb/", "setAppointmentNoResponse");
    private final static QName _SetBusinessCategoryEntityResponse_QNAME = new QName("http://ws.session.ejb/", "setBusinessCategoryEntityResponse");
    private final static QName _SetAppointmentNo_QNAME = new QName("http://ws.session.ejb/", "setAppointmentNo");
    private final static QName _SetCustomerEntity_QNAME = new QName("http://ws.session.ejb/", "setCustomerEntity");
    private final static QName _GetAppointmentNoResponse_QNAME = new QName("http://ws.session.ejb/", "getAppointmentNoResponse");
    private final static QName _GetCustomerEntity_QNAME = new QName("http://ws.session.ejb/", "getCustomerEntity");
    private final static QName _SetScheduledDateResponse_QNAME = new QName("http://ws.session.ejb/", "setScheduledDateResponse");
    private final static QName _GetBusinessCategoryEntity_QNAME = new QName("http://ws.session.ejb/", "getBusinessCategoryEntity");
    private final static QName _SetScheduledDate_QNAME = new QName("http://ws.session.ejb/", "setScheduledDate");
    private final static QName _GetScheduledDate_QNAME = new QName("http://ws.session.ejb/", "getScheduledDate");
    private final static QName _GetScheduledDateResponse_QNAME = new QName("http://ws.session.ejb/", "getScheduledDateResponse");
    private final static QName _AppointmentNumberExistsException_QNAME = new QName("http://ws.session.ejb/", "AppointmentNumberExistsException");
    private final static QName _ServiceProviderBlockedException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderBlockedException");
    private final static QName _GetServiceProviderEntityResponse_QNAME = new QName("http://ws.session.ejb/", "getServiceProviderEntityResponse");
    private final static QName _UnknownPersistenceException_QNAME = new QName("http://ws.session.ejb/", "UnknownPersistenceException");
    private final static QName _GetServiceProviderEntity_QNAME = new QName("http://ws.session.ejb/", "getServiceProviderEntity");
    private final static QName _GetCustomerEntityResponse_QNAME = new QName("http://ws.session.ejb/", "getCustomerEntityResponse");
    private final static QName _SetCustomerEntityResponse_QNAME = new QName("http://ws.session.ejb/", "setCustomerEntityResponse");
    private final static QName _GetAppointmentNo_QNAME = new QName("http://ws.session.ejb/", "getAppointmentNo");
    private final static QName _GetBusinessCategoryEntityResponse_QNAME = new QName("http://ws.session.ejb/", "getBusinessCategoryEntityResponse");
    private final static QName _ServiceProviderNotFoundException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderNotFoundException");
    private final static QName _SetScheduledTimeResponse_QNAME = new QName("http://ws.session.ejb/", "setScheduledTimeResponse");
    private final static QName _GetScheduledTime_QNAME = new QName("http://ws.session.ejb/", "getScheduledTime");
    private final static QName _InputDataValidationException_QNAME = new QName("http://ws.session.ejb/", "InputDataValidationException");
    private final static QName _DoBooking_QNAME = new QName("http://ws.session.ejb/", "doBooking");
    private final static QName _DoBookingResponse_QNAME = new QName("http://ws.session.ejb/", "doBookingResponse");
    private final static QName _ClearAppointmentCartResponse_QNAME = new QName("http://ws.session.ejb/", "clearAppointmentCartResponse");
    private final static QName _GetScheduledTimeResponse_QNAME = new QName("http://ws.session.ejb/", "getScheduledTimeResponse");
    private final static QName _SetScheduledTime_QNAME = new QName("http://ws.session.ejb/", "setScheduledTime");
    private final static QName _ClearAppointmentCart_QNAME = new QName("http://ws.session.ejb/", "clearAppointmentCart");
    private final static QName _SetBusinessCategoryEntity_QNAME = new QName("http://ws.session.ejb/", "setBusinessCategoryEntity");
    private final static QName _SetServiceProviderEntityResponse_QNAME = new QName("http://ws.session.ejb/", "setServiceProviderEntityResponse");
    private final static QName _CustomerNotFoundException_QNAME = new QName("http://ws.session.ejb/", "CustomerNotFoundException");
    private final static QName _AddAppointmentResponse_QNAME = new QName("http://ws.session.ejb/", "addAppointmentResponse");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");
    private final static QName _SetServiceProviderEntity_QNAME = new QName("http://ws.session.ejb/", "setServiceProviderEntity");
    private final static QName _AddAppointment_QNAME = new QName("http://ws.session.ejb/", "addAppointment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceProviderEntity }
     * 
     */
    public GetServiceProviderEntity createGetServiceProviderEntity() {
        return new GetServiceProviderEntity();
    }

    /**
     * Create an instance of {@link GetCustomerEntityResponse }
     * 
     */
    public GetCustomerEntityResponse createGetCustomerEntityResponse() {
        return new GetCustomerEntityResponse();
    }

    /**
     * Create an instance of {@link SetCustomerEntityResponse }
     * 
     */
    public SetCustomerEntityResponse createSetCustomerEntityResponse() {
        return new SetCustomerEntityResponse();
    }

    /**
     * Create an instance of {@link GetAppointmentNo }
     * 
     */
    public GetAppointmentNo createGetAppointmentNo() {
        return new GetAppointmentNo();
    }

    /**
     * Create an instance of {@link ServiceProviderBlockedException }
     * 
     */
    public ServiceProviderBlockedException createServiceProviderBlockedException() {
        return new ServiceProviderBlockedException();
    }

    /**
     * Create an instance of {@link GetServiceProviderEntityResponse }
     * 
     */
    public GetServiceProviderEntityResponse createGetServiceProviderEntityResponse() {
        return new GetServiceProviderEntityResponse();
    }

    /**
     * Create an instance of {@link UnknownPersistenceException }
     * 
     */
    public UnknownPersistenceException createUnknownPersistenceException() {
        return new UnknownPersistenceException();
    }

    /**
     * Create an instance of {@link GetBusinessCategoryEntity }
     * 
     */
    public GetBusinessCategoryEntity createGetBusinessCategoryEntity() {
        return new GetBusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link SetScheduledDate }
     * 
     */
    public SetScheduledDate createSetScheduledDate() {
        return new SetScheduledDate();
    }

    /**
     * Create an instance of {@link GetScheduledDate }
     * 
     */
    public GetScheduledDate createGetScheduledDate() {
        return new GetScheduledDate();
    }

    /**
     * Create an instance of {@link GetScheduledDateResponse }
     * 
     */
    public GetScheduledDateResponse createGetScheduledDateResponse() {
        return new GetScheduledDateResponse();
    }

    /**
     * Create an instance of {@link AppointmentNumberExistsException }
     * 
     */
    public AppointmentNumberExistsException createAppointmentNumberExistsException() {
        return new AppointmentNumberExistsException();
    }

    /**
     * Create an instance of {@link SetAppointmentNoResponse }
     * 
     */
    public SetAppointmentNoResponse createSetAppointmentNoResponse() {
        return new SetAppointmentNoResponse();
    }

    /**
     * Create an instance of {@link SetBusinessCategoryEntityResponse }
     * 
     */
    public SetBusinessCategoryEntityResponse createSetBusinessCategoryEntityResponse() {
        return new SetBusinessCategoryEntityResponse();
    }

    /**
     * Create an instance of {@link SetAppointmentNo }
     * 
     */
    public SetAppointmentNo createSetAppointmentNo() {
        return new SetAppointmentNo();
    }

    /**
     * Create an instance of {@link SetCustomerEntity }
     * 
     */
    public SetCustomerEntity createSetCustomerEntity() {
        return new SetCustomerEntity();
    }

    /**
     * Create an instance of {@link GetAppointmentNoResponse }
     * 
     */
    public GetAppointmentNoResponse createGetAppointmentNoResponse() {
        return new GetAppointmentNoResponse();
    }

    /**
     * Create an instance of {@link GetCustomerEntity }
     * 
     */
    public GetCustomerEntity createGetCustomerEntity() {
        return new GetCustomerEntity();
    }

    /**
     * Create an instance of {@link SetScheduledDateResponse }
     * 
     */
    public SetScheduledDateResponse createSetScheduledDateResponse() {
        return new SetScheduledDateResponse();
    }

    /**
     * Create an instance of {@link InvalidLoginCredentialException }
     * 
     */
    public InvalidLoginCredentialException createInvalidLoginCredentialException() {
        return new InvalidLoginCredentialException();
    }

    /**
     * Create an instance of {@link SetServiceProviderEntity }
     * 
     */
    public SetServiceProviderEntity createSetServiceProviderEntity() {
        return new SetServiceProviderEntity();
    }

    /**
     * Create an instance of {@link AddAppointment }
     * 
     */
    public AddAppointment createAddAppointment() {
        return new AddAppointment();
    }

    /**
     * Create an instance of {@link ClearAppointmentCart }
     * 
     */
    public ClearAppointmentCart createClearAppointmentCart() {
        return new ClearAppointmentCart();
    }

    /**
     * Create an instance of {@link SetBusinessCategoryEntity }
     * 
     */
    public SetBusinessCategoryEntity createSetBusinessCategoryEntity() {
        return new SetBusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link SetServiceProviderEntityResponse }
     * 
     */
    public SetServiceProviderEntityResponse createSetServiceProviderEntityResponse() {
        return new SetServiceProviderEntityResponse();
    }

    /**
     * Create an instance of {@link CustomerNotFoundException }
     * 
     */
    public CustomerNotFoundException createCustomerNotFoundException() {
        return new CustomerNotFoundException();
    }

    /**
     * Create an instance of {@link AddAppointmentResponse }
     * 
     */
    public AddAppointmentResponse createAddAppointmentResponse() {
        return new AddAppointmentResponse();
    }

    /**
     * Create an instance of {@link DoBookingResponse }
     * 
     */
    public DoBookingResponse createDoBookingResponse() {
        return new DoBookingResponse();
    }

    /**
     * Create an instance of {@link ClearAppointmentCartResponse }
     * 
     */
    public ClearAppointmentCartResponse createClearAppointmentCartResponse() {
        return new ClearAppointmentCartResponse();
    }

    /**
     * Create an instance of {@link GetScheduledTimeResponse }
     * 
     */
    public GetScheduledTimeResponse createGetScheduledTimeResponse() {
        return new GetScheduledTimeResponse();
    }

    /**
     * Create an instance of {@link SetScheduledTime }
     * 
     */
    public SetScheduledTime createSetScheduledTime() {
        return new SetScheduledTime();
    }

    /**
     * Create an instance of {@link GetBusinessCategoryEntityResponse }
     * 
     */
    public GetBusinessCategoryEntityResponse createGetBusinessCategoryEntityResponse() {
        return new GetBusinessCategoryEntityResponse();
    }

    /**
     * Create an instance of {@link ServiceProviderNotFoundException }
     * 
     */
    public ServiceProviderNotFoundException createServiceProviderNotFoundException() {
        return new ServiceProviderNotFoundException();
    }

    /**
     * Create an instance of {@link SetScheduledTimeResponse }
     * 
     */
    public SetScheduledTimeResponse createSetScheduledTimeResponse() {
        return new SetScheduledTimeResponse();
    }

    /**
     * Create an instance of {@link GetScheduledTime }
     * 
     */
    public GetScheduledTime createGetScheduledTime() {
        return new GetScheduledTime();
    }

    /**
     * Create an instance of {@link InputDataValidationException }
     * 
     */
    public InputDataValidationException createInputDataValidationException() {
        return new InputDataValidationException();
    }

    /**
     * Create an instance of {@link DoBooking }
     * 
     */
    public DoBooking createDoBooking() {
        return new DoBooking();
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
     * Create an instance of {@link ServiceProviderEntity }
     * 
     */
    public ServiceProviderEntity createServiceProviderEntity() {
        return new ServiceProviderEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAppointmentNoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setAppointmentNoResponse")
    public JAXBElement<SetAppointmentNoResponse> createSetAppointmentNoResponse(SetAppointmentNoResponse value) {
        return new JAXBElement<SetAppointmentNoResponse>(_SetAppointmentNoResponse_QNAME, SetAppointmentNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBusinessCategoryEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setBusinessCategoryEntityResponse")
    public JAXBElement<SetBusinessCategoryEntityResponse> createSetBusinessCategoryEntityResponse(SetBusinessCategoryEntityResponse value) {
        return new JAXBElement<SetBusinessCategoryEntityResponse>(_SetBusinessCategoryEntityResponse_QNAME, SetBusinessCategoryEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAppointmentNo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setAppointmentNo")
    public JAXBElement<SetAppointmentNo> createSetAppointmentNo(SetAppointmentNo value) {
        return new JAXBElement<SetAppointmentNo>(_SetAppointmentNo_QNAME, SetAppointmentNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCustomerEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setCustomerEntity")
    public JAXBElement<SetCustomerEntity> createSetCustomerEntity(SetCustomerEntity value) {
        return new JAXBElement<SetCustomerEntity>(_SetCustomerEntity_QNAME, SetCustomerEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointmentNoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getAppointmentNoResponse")
    public JAXBElement<GetAppointmentNoResponse> createGetAppointmentNoResponse(GetAppointmentNoResponse value) {
        return new JAXBElement<GetAppointmentNoResponse>(_GetAppointmentNoResponse_QNAME, GetAppointmentNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getCustomerEntity")
    public JAXBElement<GetCustomerEntity> createGetCustomerEntity(GetCustomerEntity value) {
        return new JAXBElement<GetCustomerEntity>(_GetCustomerEntity_QNAME, GetCustomerEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetScheduledDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setScheduledDateResponse")
    public JAXBElement<SetScheduledDateResponse> createSetScheduledDateResponse(SetScheduledDateResponse value) {
        return new JAXBElement<SetScheduledDateResponse>(_SetScheduledDateResponse_QNAME, SetScheduledDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBusinessCategoryEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getBusinessCategoryEntity")
    public JAXBElement<GetBusinessCategoryEntity> createGetBusinessCategoryEntity(GetBusinessCategoryEntity value) {
        return new JAXBElement<GetBusinessCategoryEntity>(_GetBusinessCategoryEntity_QNAME, GetBusinessCategoryEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetScheduledDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setScheduledDate")
    public JAXBElement<SetScheduledDate> createSetScheduledDate(SetScheduledDate value) {
        return new JAXBElement<SetScheduledDate>(_SetScheduledDate_QNAME, SetScheduledDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getScheduledDate")
    public JAXBElement<GetScheduledDate> createGetScheduledDate(GetScheduledDate value) {
        return new JAXBElement<GetScheduledDate>(_GetScheduledDate_QNAME, GetScheduledDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getScheduledDateResponse")
    public JAXBElement<GetScheduledDateResponse> createGetScheduledDateResponse(GetScheduledDateResponse value) {
        return new JAXBElement<GetScheduledDateResponse>(_GetScheduledDateResponse_QNAME, GetScheduledDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppointmentNumberExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "AppointmentNumberExistsException")
    public JAXBElement<AppointmentNumberExistsException> createAppointmentNumberExistsException(AppointmentNumberExistsException value) {
        return new JAXBElement<AppointmentNumberExistsException>(_AppointmentNumberExistsException_QNAME, AppointmentNumberExistsException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceProviderEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getServiceProviderEntityResponse")
    public JAXBElement<GetServiceProviderEntityResponse> createGetServiceProviderEntityResponse(GetServiceProviderEntityResponse value) {
        return new JAXBElement<GetServiceProviderEntityResponse>(_GetServiceProviderEntityResponse_QNAME, GetServiceProviderEntityResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceProviderEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getServiceProviderEntity")
    public JAXBElement<GetServiceProviderEntity> createGetServiceProviderEntity(GetServiceProviderEntity value) {
        return new JAXBElement<GetServiceProviderEntity>(_GetServiceProviderEntity_QNAME, GetServiceProviderEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getCustomerEntityResponse")
    public JAXBElement<GetCustomerEntityResponse> createGetCustomerEntityResponse(GetCustomerEntityResponse value) {
        return new JAXBElement<GetCustomerEntityResponse>(_GetCustomerEntityResponse_QNAME, GetCustomerEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCustomerEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setCustomerEntityResponse")
    public JAXBElement<SetCustomerEntityResponse> createSetCustomerEntityResponse(SetCustomerEntityResponse value) {
        return new JAXBElement<SetCustomerEntityResponse>(_SetCustomerEntityResponse_QNAME, SetCustomerEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointmentNo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getAppointmentNo")
    public JAXBElement<GetAppointmentNo> createGetAppointmentNo(GetAppointmentNo value) {
        return new JAXBElement<GetAppointmentNo>(_GetAppointmentNo_QNAME, GetAppointmentNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBusinessCategoryEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getBusinessCategoryEntityResponse")
    public JAXBElement<GetBusinessCategoryEntityResponse> createGetBusinessCategoryEntityResponse(GetBusinessCategoryEntityResponse value) {
        return new JAXBElement<GetBusinessCategoryEntityResponse>(_GetBusinessCategoryEntityResponse_QNAME, GetBusinessCategoryEntityResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetScheduledTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setScheduledTimeResponse")
    public JAXBElement<SetScheduledTimeResponse> createSetScheduledTimeResponse(SetScheduledTimeResponse value) {
        return new JAXBElement<SetScheduledTimeResponse>(_SetScheduledTimeResponse_QNAME, SetScheduledTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getScheduledTime")
    public JAXBElement<GetScheduledTime> createGetScheduledTime(GetScheduledTime value) {
        return new JAXBElement<GetScheduledTime>(_GetScheduledTime_QNAME, GetScheduledTime.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DoBooking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "doBooking")
    public JAXBElement<DoBooking> createDoBooking(DoBooking value) {
        return new JAXBElement<DoBooking>(_DoBooking_QNAME, DoBooking.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoBookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "doBookingResponse")
    public JAXBElement<DoBookingResponse> createDoBookingResponse(DoBookingResponse value) {
        return new JAXBElement<DoBookingResponse>(_DoBookingResponse_QNAME, DoBookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearAppointmentCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "clearAppointmentCartResponse")
    public JAXBElement<ClearAppointmentCartResponse> createClearAppointmentCartResponse(ClearAppointmentCartResponse value) {
        return new JAXBElement<ClearAppointmentCartResponse>(_ClearAppointmentCartResponse_QNAME, ClearAppointmentCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScheduledTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getScheduledTimeResponse")
    public JAXBElement<GetScheduledTimeResponse> createGetScheduledTimeResponse(GetScheduledTimeResponse value) {
        return new JAXBElement<GetScheduledTimeResponse>(_GetScheduledTimeResponse_QNAME, GetScheduledTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetScheduledTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setScheduledTime")
    public JAXBElement<SetScheduledTime> createSetScheduledTime(SetScheduledTime value) {
        return new JAXBElement<SetScheduledTime>(_SetScheduledTime_QNAME, SetScheduledTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearAppointmentCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "clearAppointmentCart")
    public JAXBElement<ClearAppointmentCart> createClearAppointmentCart(ClearAppointmentCart value) {
        return new JAXBElement<ClearAppointmentCart>(_ClearAppointmentCart_QNAME, ClearAppointmentCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBusinessCategoryEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setBusinessCategoryEntity")
    public JAXBElement<SetBusinessCategoryEntity> createSetBusinessCategoryEntity(SetBusinessCategoryEntity value) {
        return new JAXBElement<SetBusinessCategoryEntity>(_SetBusinessCategoryEntity_QNAME, SetBusinessCategoryEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServiceProviderEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setServiceProviderEntityResponse")
    public JAXBElement<SetServiceProviderEntityResponse> createSetServiceProviderEntityResponse(SetServiceProviderEntityResponse value) {
        return new JAXBElement<SetServiceProviderEntityResponse>(_SetServiceProviderEntityResponse_QNAME, SetServiceProviderEntityResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "addAppointmentResponse")
    public JAXBElement<AddAppointmentResponse> createAddAppointmentResponse(AddAppointmentResponse value) {
        return new JAXBElement<AddAppointmentResponse>(_AddAppointmentResponse_QNAME, AddAppointmentResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServiceProviderEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "setServiceProviderEntity")
    public JAXBElement<SetServiceProviderEntity> createSetServiceProviderEntity(SetServiceProviderEntity value) {
        return new JAXBElement<SetServiceProviderEntity>(_SetServiceProviderEntity_QNAME, SetServiceProviderEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "addAppointment")
    public JAXBElement<AddAppointment> createAddAppointment(AddAppointment value) {
        return new JAXBElement<AddAppointment>(_AddAppointment_QNAME, AddAppointment.class, null, value);
    }

}
