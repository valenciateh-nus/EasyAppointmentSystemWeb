
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

    private final static QName _IfAppointmentCanCancelResponse_QNAME = new QName("http://ws.session.ejb/", "ifAppointmentCanCancelResponse");
    private final static QName _GetLocalTimeInString_QNAME = new QName("http://ws.session.ejb/", "getLocalTimeInString");
    private final static QName _ConvertDate_QNAME = new QName("http://ws.session.ejb/", "convertDate");
    private final static QName _UpdateAppointmentEntityRatingResponse_QNAME = new QName("http://ws.session.ejb/", "updateAppointmentEntityRatingResponse");
    private final static QName _RetrieveAppointmentsByDateResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDateResponse");
    private final static QName _RetrieveAppointmentByCustomer_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByCustomer");
    private final static QName _AppointmentNumberExistsException_QNAME = new QName("http://ws.session.ejb/", "AppointmentNumberExistsException");
    private final static QName _AppointmentNotFoundException_QNAME = new QName("http://ws.session.ejb/", "AppointmentNotFoundException");
    private final static QName _IfDateHasNotPassedResponse_QNAME = new QName("http://ws.session.ejb/", "ifDateHasNotPassedResponse");
    private final static QName _UpdateAppointmentEntityResponse_QNAME = new QName("http://ws.session.ejb/", "updateAppointmentEntityResponse");
    private final static QName _ConvertTime_QNAME = new QName("http://ws.session.ejb/", "convertTime");
    private final static QName _ServiceProviderNotFoundException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderNotFoundException");
    private final static QName _RetrieveAppointmentsByServiceProviderIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByServiceProviderIdResponse");
    private final static QName _InputDataValidationException_QNAME = new QName("http://ws.session.ejb/", "InputDataValidationException");
    private final static QName _RetrieveAppointmentByAppointmentId_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentId");
    private final static QName _DeleteAppointmentResponse_QNAME = new QName("http://ws.session.ejb/", "deleteAppointmentResponse");
    private final static QName _GetLocalTimeInStringResponse_QNAME = new QName("http://ws.session.ejb/", "getLocalTimeInStringResponse");
    private final static QName _FindAvailableTimeSlotResponse_QNAME = new QName("http://ws.session.ejb/", "findAvailableTimeSlotResponse");
    private final static QName _RetrieveAppointmentByCustomerResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByCustomerResponse");
    private final static QName _RetrieveAppointmentByAppointmentNumber_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentNumber");
    private final static QName _UpdateAppointmentEntityRating_QNAME = new QName("http://ws.session.ejb/", "updateAppointmentEntityRating");
    private final static QName _InvalidLoginCredentialException_QNAME = new QName("http://ws.session.ejb/", "InvalidLoginCredentialException");
    private final static QName _RetrieveSortedAppointmentsByDate_QNAME = new QName("http://ws.session.ejb/", "retrieveSortedAppointmentsByDate");
    private final static QName _DeleteAppointment_QNAME = new QName("http://ws.session.ejb/", "deleteAppointment");
    private final static QName _CreateNewAppointment_QNAME = new QName("http://ws.session.ejb/", "createNewAppointment");
    private final static QName _IfAppointmentCanAdd_QNAME = new QName("http://ws.session.ejb/", "ifAppointmentCanAdd");
    private final static QName _CalculateDayOfTheWeek_QNAME = new QName("http://ws.session.ejb/", "calculateDayOfTheWeek");
    private final static QName _InputInvalidValuesException_QNAME = new QName("http://ws.session.ejb/", "InputInvalidValuesException");
    private final static QName _RetrieveAppointmentByAppointmentNumberResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentNumberResponse");
    private final static QName _ServiceProviderBlockedException_QNAME = new QName("http://ws.session.ejb/", "ServiceProviderBlockedException");
    private final static QName _FindFirstAvailableTime_QNAME = new QName("http://ws.session.ejb/", "findFirstAvailableTime");
    private final static QName _UnknownPersistenceException_QNAME = new QName("http://ws.session.ejb/", "UnknownPersistenceException");
    private final static QName _ConvertTimeResponse_QNAME = new QName("http://ws.session.ejb/", "convertTimeResponse");
    private final static QName _RetrieveAppointmentsByDate_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByDate");
    private final static QName _RetrieveAppointmentsByServiceProviderId_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentsByServiceProviderId");
    private final static QName _RetrieveSortedAppointmentsByDateResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveSortedAppointmentsByDateResponse");
    private final static QName _FindAvailableTimeSlot_QNAME = new QName("http://ws.session.ejb/", "findAvailableTimeSlot");
    private final static QName _CalculateDayOfTheWeekResponse_QNAME = new QName("http://ws.session.ejb/", "calculateDayOfTheWeekResponse");
    private final static QName _IfAppointmentCanCancel_QNAME = new QName("http://ws.session.ejb/", "ifAppointmentCanCancel");
    private final static QName _CreateNewAppointmentResponse_QNAME = new QName("http://ws.session.ejb/", "createNewAppointmentResponse");
    private final static QName _RetrieveAppointmentByAppointmentIdResponse_QNAME = new QName("http://ws.session.ejb/", "retrieveAppointmentByAppointmentIdResponse");
    private final static QName _UpdateAppointmentEntity_QNAME = new QName("http://ws.session.ejb/", "updateAppointmentEntity");
    private final static QName _IfCanRate_QNAME = new QName("http://ws.session.ejb/", "ifCanRate");
    private final static QName _IfAppointmentCanAddResponse_QNAME = new QName("http://ws.session.ejb/", "ifAppointmentCanAddResponse");
    private final static QName _CustomerNotFoundException_QNAME = new QName("http://ws.session.ejb/", "CustomerNotFoundException");
    private final static QName _FindFirstAvailableTimeResponse_QNAME = new QName("http://ws.session.ejb/", "findFirstAvailableTimeResponse");
    private final static QName _ConvertDateResponse_QNAME = new QName("http://ws.session.ejb/", "convertDateResponse");
    private final static QName _IfCanRateResponse_QNAME = new QName("http://ws.session.ejb/", "ifCanRateResponse");
    private final static QName _IfDateHasNotPassed_QNAME = new QName("http://ws.session.ejb/", "ifDateHasNotPassed");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertTimeResponse }
     * 
     */
    public ConvertTimeResponse createConvertTimeResponse() {
        return new ConvertTimeResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDate }
     * 
     */
    public RetrieveAppointmentsByDate createRetrieveAppointmentsByDate() {
        return new RetrieveAppointmentsByDate();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByServiceProviderId }
     * 
     */
    public RetrieveAppointmentsByServiceProviderId createRetrieveAppointmentsByServiceProviderId() {
        return new RetrieveAppointmentsByServiceProviderId();
    }

    /**
     * Create an instance of {@link RetrieveSortedAppointmentsByDateResponse }
     * 
     */
    public RetrieveSortedAppointmentsByDateResponse createRetrieveSortedAppointmentsByDateResponse() {
        return new RetrieveSortedAppointmentsByDateResponse();
    }

    /**
     * Create an instance of {@link ServiceProviderBlockedException }
     * 
     */
    public ServiceProviderBlockedException createServiceProviderBlockedException() {
        return new ServiceProviderBlockedException();
    }

    /**
     * Create an instance of {@link FindFirstAvailableTime }
     * 
     */
    public FindFirstAvailableTime createFindFirstAvailableTime() {
        return new FindFirstAvailableTime();
    }

    /**
     * Create an instance of {@link UnknownPersistenceException }
     * 
     */
    public UnknownPersistenceException createUnknownPersistenceException() {
        return new UnknownPersistenceException();
    }

    /**
     * Create an instance of {@link InputInvalidValuesException }
     * 
     */
    public InputInvalidValuesException createInputInvalidValuesException() {
        return new InputInvalidValuesException();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentNumberResponse }
     * 
     */
    public RetrieveAppointmentByAppointmentNumberResponse createRetrieveAppointmentByAppointmentNumberResponse() {
        return new RetrieveAppointmentByAppointmentNumberResponse();
    }

    /**
     * Create an instance of {@link DeleteAppointment }
     * 
     */
    public DeleteAppointment createDeleteAppointment() {
        return new DeleteAppointment();
    }

    /**
     * Create an instance of {@link CreateNewAppointment }
     * 
     */
    public CreateNewAppointment createCreateNewAppointment() {
        return new CreateNewAppointment();
    }

    /**
     * Create an instance of {@link IfAppointmentCanAdd }
     * 
     */
    public IfAppointmentCanAdd createIfAppointmentCanAdd() {
        return new IfAppointmentCanAdd();
    }

    /**
     * Create an instance of {@link CalculateDayOfTheWeek }
     * 
     */
    public CalculateDayOfTheWeek createCalculateDayOfTheWeek() {
        return new CalculateDayOfTheWeek();
    }

    /**
     * Create an instance of {@link ConvertDateResponse }
     * 
     */
    public ConvertDateResponse createConvertDateResponse() {
        return new ConvertDateResponse();
    }

    /**
     * Create an instance of {@link IfCanRateResponse }
     * 
     */
    public IfCanRateResponse createIfCanRateResponse() {
        return new IfCanRateResponse();
    }

    /**
     * Create an instance of {@link IfDateHasNotPassed }
     * 
     */
    public IfDateHasNotPassed createIfDateHasNotPassed() {
        return new IfDateHasNotPassed();
    }

    /**
     * Create an instance of {@link CustomerNotFoundException }
     * 
     */
    public CustomerNotFoundException createCustomerNotFoundException() {
        return new CustomerNotFoundException();
    }

    /**
     * Create an instance of {@link FindFirstAvailableTimeResponse }
     * 
     */
    public FindFirstAvailableTimeResponse createFindFirstAvailableTimeResponse() {
        return new FindFirstAvailableTimeResponse();
    }

    /**
     * Create an instance of {@link UpdateAppointmentEntity }
     * 
     */
    public UpdateAppointmentEntity createUpdateAppointmentEntity() {
        return new UpdateAppointmentEntity();
    }

    /**
     * Create an instance of {@link IfCanRate }
     * 
     */
    public IfCanRate createIfCanRate() {
        return new IfCanRate();
    }

    /**
     * Create an instance of {@link IfAppointmentCanAddResponse }
     * 
     */
    public IfAppointmentCanAddResponse createIfAppointmentCanAddResponse() {
        return new IfAppointmentCanAddResponse();
    }

    /**
     * Create an instance of {@link FindAvailableTimeSlot }
     * 
     */
    public FindAvailableTimeSlot createFindAvailableTimeSlot() {
        return new FindAvailableTimeSlot();
    }

    /**
     * Create an instance of {@link CalculateDayOfTheWeekResponse }
     * 
     */
    public CalculateDayOfTheWeekResponse createCalculateDayOfTheWeekResponse() {
        return new CalculateDayOfTheWeekResponse();
    }

    /**
     * Create an instance of {@link IfAppointmentCanCancel }
     * 
     */
    public IfAppointmentCanCancel createIfAppointmentCanCancel() {
        return new IfAppointmentCanCancel();
    }

    /**
     * Create an instance of {@link CreateNewAppointmentResponse }
     * 
     */
    public CreateNewAppointmentResponse createCreateNewAppointmentResponse() {
        return new CreateNewAppointmentResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentIdResponse }
     * 
     */
    public RetrieveAppointmentByAppointmentIdResponse createRetrieveAppointmentByAppointmentIdResponse() {
        return new RetrieveAppointmentByAppointmentIdResponse();
    }

    /**
     * Create an instance of {@link IfDateHasNotPassedResponse }
     * 
     */
    public IfDateHasNotPassedResponse createIfDateHasNotPassedResponse() {
        return new IfDateHasNotPassedResponse();
    }

    /**
     * Create an instance of {@link UpdateAppointmentEntityResponse }
     * 
     */
    public UpdateAppointmentEntityResponse createUpdateAppointmentEntityResponse() {
        return new UpdateAppointmentEntityResponse();
    }

    /**
     * Create an instance of {@link ConvertTime }
     * 
     */
    public ConvertTime createConvertTime() {
        return new ConvertTime();
    }

    /**
     * Create an instance of {@link AppointmentNotFoundException }
     * 
     */
    public AppointmentNotFoundException createAppointmentNotFoundException() {
        return new AppointmentNotFoundException();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByCustomer }
     * 
     */
    public RetrieveAppointmentByCustomer createRetrieveAppointmentByCustomer() {
        return new RetrieveAppointmentByCustomer();
    }

    /**
     * Create an instance of {@link AppointmentNumberExistsException }
     * 
     */
    public AppointmentNumberExistsException createAppointmentNumberExistsException() {
        return new AppointmentNumberExistsException();
    }

    /**
     * Create an instance of {@link IfAppointmentCanCancelResponse }
     * 
     */
    public IfAppointmentCanCancelResponse createIfAppointmentCanCancelResponse() {
        return new IfAppointmentCanCancelResponse();
    }

    /**
     * Create an instance of {@link GetLocalTimeInString }
     * 
     */
    public GetLocalTimeInString createGetLocalTimeInString() {
        return new GetLocalTimeInString();
    }

    /**
     * Create an instance of {@link ConvertDate }
     * 
     */
    public ConvertDate createConvertDate() {
        return new ConvertDate();
    }

    /**
     * Create an instance of {@link UpdateAppointmentEntityRatingResponse }
     * 
     */
    public UpdateAppointmentEntityRatingResponse createUpdateAppointmentEntityRatingResponse() {
        return new UpdateAppointmentEntityRatingResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByDateResponse }
     * 
     */
    public RetrieveAppointmentsByDateResponse createRetrieveAppointmentsByDateResponse() {
        return new RetrieveAppointmentsByDateResponse();
    }

    /**
     * Create an instance of {@link InvalidLoginCredentialException }
     * 
     */
    public InvalidLoginCredentialException createInvalidLoginCredentialException() {
        return new InvalidLoginCredentialException();
    }

    /**
     * Create an instance of {@link RetrieveSortedAppointmentsByDate }
     * 
     */
    public RetrieveSortedAppointmentsByDate createRetrieveSortedAppointmentsByDate() {
        return new RetrieveSortedAppointmentsByDate();
    }

    /**
     * Create an instance of {@link DeleteAppointmentResponse }
     * 
     */
    public DeleteAppointmentResponse createDeleteAppointmentResponse() {
        return new DeleteAppointmentResponse();
    }

    /**
     * Create an instance of {@link GetLocalTimeInStringResponse }
     * 
     */
    public GetLocalTimeInStringResponse createGetLocalTimeInStringResponse() {
        return new GetLocalTimeInStringResponse();
    }

    /**
     * Create an instance of {@link FindAvailableTimeSlotResponse }
     * 
     */
    public FindAvailableTimeSlotResponse createFindAvailableTimeSlotResponse() {
        return new FindAvailableTimeSlotResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByCustomerResponse }
     * 
     */
    public RetrieveAppointmentByCustomerResponse createRetrieveAppointmentByCustomerResponse() {
        return new RetrieveAppointmentByCustomerResponse();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentNumber }
     * 
     */
    public RetrieveAppointmentByAppointmentNumber createRetrieveAppointmentByAppointmentNumber() {
        return new RetrieveAppointmentByAppointmentNumber();
    }

    /**
     * Create an instance of {@link UpdateAppointmentEntityRating }
     * 
     */
    public UpdateAppointmentEntityRating createUpdateAppointmentEntityRating() {
        return new UpdateAppointmentEntityRating();
    }

    /**
     * Create an instance of {@link ServiceProviderNotFoundException }
     * 
     */
    public ServiceProviderNotFoundException createServiceProviderNotFoundException() {
        return new ServiceProviderNotFoundException();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentsByServiceProviderIdResponse }
     * 
     */
    public RetrieveAppointmentsByServiceProviderIdResponse createRetrieveAppointmentsByServiceProviderIdResponse() {
        return new RetrieveAppointmentsByServiceProviderIdResponse();
    }

    /**
     * Create an instance of {@link InputDataValidationException }
     * 
     */
    public InputDataValidationException createInputDataValidationException() {
        return new InputDataValidationException();
    }

    /**
     * Create an instance of {@link RetrieveAppointmentByAppointmentId }
     * 
     */
    public RetrieveAppointmentByAppointmentId createRetrieveAppointmentByAppointmentId() {
        return new RetrieveAppointmentByAppointmentId();
    }

    /**
     * Create an instance of {@link AppointmentEntity }
     * 
     */
    public AppointmentEntity createAppointmentEntity() {
        return new AppointmentEntity();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link BusinessCategoryEntity }
     * 
     */
    public BusinessCategoryEntity createBusinessCategoryEntity() {
        return new BusinessCategoryEntity();
    }

    /**
     * Create an instance of {@link LocalTime }
     * 
     */
    public LocalTime createLocalTime() {
        return new LocalTime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfAppointmentCanCancelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifAppointmentCanCancelResponse")
    public JAXBElement<IfAppointmentCanCancelResponse> createIfAppointmentCanCancelResponse(IfAppointmentCanCancelResponse value) {
        return new JAXBElement<IfAppointmentCanCancelResponse>(_IfAppointmentCanCancelResponse_QNAME, IfAppointmentCanCancelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalTimeInString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getLocalTimeInString")
    public JAXBElement<GetLocalTimeInString> createGetLocalTimeInString(GetLocalTimeInString value) {
        return new JAXBElement<GetLocalTimeInString>(_GetLocalTimeInString_QNAME, GetLocalTimeInString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "convertDate")
    public JAXBElement<ConvertDate> createConvertDate(ConvertDate value) {
        return new JAXBElement<ConvertDate>(_ConvertDate_QNAME, ConvertDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAppointmentEntityRatingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateAppointmentEntityRatingResponse")
    public JAXBElement<UpdateAppointmentEntityRatingResponse> createUpdateAppointmentEntityRatingResponse(UpdateAppointmentEntityRatingResponse value) {
        return new JAXBElement<UpdateAppointmentEntityRatingResponse>(_UpdateAppointmentEntityRatingResponse_QNAME, UpdateAppointmentEntityRatingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDateResponse")
    public JAXBElement<RetrieveAppointmentsByDateResponse> createRetrieveAppointmentsByDateResponse(RetrieveAppointmentsByDateResponse value) {
        return new JAXBElement<RetrieveAppointmentsByDateResponse>(_RetrieveAppointmentsByDateResponse_QNAME, RetrieveAppointmentsByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByCustomer")
    public JAXBElement<RetrieveAppointmentByCustomer> createRetrieveAppointmentByCustomer(RetrieveAppointmentByCustomer value) {
        return new JAXBElement<RetrieveAppointmentByCustomer>(_RetrieveAppointmentByCustomer_QNAME, RetrieveAppointmentByCustomer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AppointmentNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "AppointmentNotFoundException")
    public JAXBElement<AppointmentNotFoundException> createAppointmentNotFoundException(AppointmentNotFoundException value) {
        return new JAXBElement<AppointmentNotFoundException>(_AppointmentNotFoundException_QNAME, AppointmentNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfDateHasNotPassedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifDateHasNotPassedResponse")
    public JAXBElement<IfDateHasNotPassedResponse> createIfDateHasNotPassedResponse(IfDateHasNotPassedResponse value) {
        return new JAXBElement<IfDateHasNotPassedResponse>(_IfDateHasNotPassedResponse_QNAME, IfDateHasNotPassedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAppointmentEntityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateAppointmentEntityResponse")
    public JAXBElement<UpdateAppointmentEntityResponse> createUpdateAppointmentEntityResponse(UpdateAppointmentEntityResponse value) {
        return new JAXBElement<UpdateAppointmentEntityResponse>(_UpdateAppointmentEntityResponse_QNAME, UpdateAppointmentEntityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "convertTime")
    public JAXBElement<ConvertTime> createConvertTime(ConvertTime value) {
        return new JAXBElement<ConvertTime>(_ConvertTime_QNAME, ConvertTime.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByServiceProviderIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByServiceProviderIdResponse")
    public JAXBElement<RetrieveAppointmentsByServiceProviderIdResponse> createRetrieveAppointmentsByServiceProviderIdResponse(RetrieveAppointmentsByServiceProviderIdResponse value) {
        return new JAXBElement<RetrieveAppointmentsByServiceProviderIdResponse>(_RetrieveAppointmentsByServiceProviderIdResponse_QNAME, RetrieveAppointmentsByServiceProviderIdResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentId")
    public JAXBElement<RetrieveAppointmentByAppointmentId> createRetrieveAppointmentByAppointmentId(RetrieveAppointmentByAppointmentId value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentId>(_RetrieveAppointmentByAppointmentId_QNAME, RetrieveAppointmentByAppointmentId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAppointmentResponse")
    public JAXBElement<DeleteAppointmentResponse> createDeleteAppointmentResponse(DeleteAppointmentResponse value) {
        return new JAXBElement<DeleteAppointmentResponse>(_DeleteAppointmentResponse_QNAME, DeleteAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocalTimeInStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "getLocalTimeInStringResponse")
    public JAXBElement<GetLocalTimeInStringResponse> createGetLocalTimeInStringResponse(GetLocalTimeInStringResponse value) {
        return new JAXBElement<GetLocalTimeInStringResponse>(_GetLocalTimeInStringResponse_QNAME, GetLocalTimeInStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAvailableTimeSlotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "findAvailableTimeSlotResponse")
    public JAXBElement<FindAvailableTimeSlotResponse> createFindAvailableTimeSlotResponse(FindAvailableTimeSlotResponse value) {
        return new JAXBElement<FindAvailableTimeSlotResponse>(_FindAvailableTimeSlotResponse_QNAME, FindAvailableTimeSlotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByCustomerResponse")
    public JAXBElement<RetrieveAppointmentByCustomerResponse> createRetrieveAppointmentByCustomerResponse(RetrieveAppointmentByCustomerResponse value) {
        return new JAXBElement<RetrieveAppointmentByCustomerResponse>(_RetrieveAppointmentByCustomerResponse_QNAME, RetrieveAppointmentByCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentNumber")
    public JAXBElement<RetrieveAppointmentByAppointmentNumber> createRetrieveAppointmentByAppointmentNumber(RetrieveAppointmentByAppointmentNumber value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentNumber>(_RetrieveAppointmentByAppointmentNumber_QNAME, RetrieveAppointmentByAppointmentNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAppointmentEntityRating }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateAppointmentEntityRating")
    public JAXBElement<UpdateAppointmentEntityRating> createUpdateAppointmentEntityRating(UpdateAppointmentEntityRating value) {
        return new JAXBElement<UpdateAppointmentEntityRating>(_UpdateAppointmentEntityRating_QNAME, UpdateAppointmentEntityRating.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSortedAppointmentsByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveSortedAppointmentsByDate")
    public JAXBElement<RetrieveSortedAppointmentsByDate> createRetrieveSortedAppointmentsByDate(RetrieveSortedAppointmentsByDate value) {
        return new JAXBElement<RetrieveSortedAppointmentsByDate>(_RetrieveSortedAppointmentsByDate_QNAME, RetrieveSortedAppointmentsByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "deleteAppointment")
    public JAXBElement<DeleteAppointment> createDeleteAppointment(DeleteAppointment value) {
        return new JAXBElement<DeleteAppointment>(_DeleteAppointment_QNAME, DeleteAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewAppointment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewAppointment")
    public JAXBElement<CreateNewAppointment> createCreateNewAppointment(CreateNewAppointment value) {
        return new JAXBElement<CreateNewAppointment>(_CreateNewAppointment_QNAME, CreateNewAppointment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfAppointmentCanAdd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifAppointmentCanAdd")
    public JAXBElement<IfAppointmentCanAdd> createIfAppointmentCanAdd(IfAppointmentCanAdd value) {
        return new JAXBElement<IfAppointmentCanAdd>(_IfAppointmentCanAdd_QNAME, IfAppointmentCanAdd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDayOfTheWeek }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "calculateDayOfTheWeek")
    public JAXBElement<CalculateDayOfTheWeek> createCalculateDayOfTheWeek(CalculateDayOfTheWeek value) {
        return new JAXBElement<CalculateDayOfTheWeek>(_CalculateDayOfTheWeek_QNAME, CalculateDayOfTheWeek.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputInvalidValuesException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "InputInvalidValuesException")
    public JAXBElement<InputInvalidValuesException> createInputInvalidValuesException(InputInvalidValuesException value) {
        return new JAXBElement<InputInvalidValuesException>(_InputInvalidValuesException_QNAME, InputInvalidValuesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentNumberResponse")
    public JAXBElement<RetrieveAppointmentByAppointmentNumberResponse> createRetrieveAppointmentByAppointmentNumberResponse(RetrieveAppointmentByAppointmentNumberResponse value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentNumberResponse>(_RetrieveAppointmentByAppointmentNumberResponse_QNAME, RetrieveAppointmentByAppointmentNumberResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFirstAvailableTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "findFirstAvailableTime")
    public JAXBElement<FindFirstAvailableTime> createFindFirstAvailableTime(FindFirstAvailableTime value) {
        return new JAXBElement<FindFirstAvailableTime>(_FindFirstAvailableTime_QNAME, FindFirstAvailableTime.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "convertTimeResponse")
    public JAXBElement<ConvertTimeResponse> createConvertTimeResponse(ConvertTimeResponse value) {
        return new JAXBElement<ConvertTimeResponse>(_ConvertTimeResponse_QNAME, ConvertTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByDate")
    public JAXBElement<RetrieveAppointmentsByDate> createRetrieveAppointmentsByDate(RetrieveAppointmentsByDate value) {
        return new JAXBElement<RetrieveAppointmentsByDate>(_RetrieveAppointmentsByDate_QNAME, RetrieveAppointmentsByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentsByServiceProviderId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentsByServiceProviderId")
    public JAXBElement<RetrieveAppointmentsByServiceProviderId> createRetrieveAppointmentsByServiceProviderId(RetrieveAppointmentsByServiceProviderId value) {
        return new JAXBElement<RetrieveAppointmentsByServiceProviderId>(_RetrieveAppointmentsByServiceProviderId_QNAME, RetrieveAppointmentsByServiceProviderId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveSortedAppointmentsByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveSortedAppointmentsByDateResponse")
    public JAXBElement<RetrieveSortedAppointmentsByDateResponse> createRetrieveSortedAppointmentsByDateResponse(RetrieveSortedAppointmentsByDateResponse value) {
        return new JAXBElement<RetrieveSortedAppointmentsByDateResponse>(_RetrieveSortedAppointmentsByDateResponse_QNAME, RetrieveSortedAppointmentsByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAvailableTimeSlot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "findAvailableTimeSlot")
    public JAXBElement<FindAvailableTimeSlot> createFindAvailableTimeSlot(FindAvailableTimeSlot value) {
        return new JAXBElement<FindAvailableTimeSlot>(_FindAvailableTimeSlot_QNAME, FindAvailableTimeSlot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDayOfTheWeekResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "calculateDayOfTheWeekResponse")
    public JAXBElement<CalculateDayOfTheWeekResponse> createCalculateDayOfTheWeekResponse(CalculateDayOfTheWeekResponse value) {
        return new JAXBElement<CalculateDayOfTheWeekResponse>(_CalculateDayOfTheWeekResponse_QNAME, CalculateDayOfTheWeekResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfAppointmentCanCancel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifAppointmentCanCancel")
    public JAXBElement<IfAppointmentCanCancel> createIfAppointmentCanCancel(IfAppointmentCanCancel value) {
        return new JAXBElement<IfAppointmentCanCancel>(_IfAppointmentCanCancel_QNAME, IfAppointmentCanCancel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNewAppointmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "createNewAppointmentResponse")
    public JAXBElement<CreateNewAppointmentResponse> createCreateNewAppointmentResponse(CreateNewAppointmentResponse value) {
        return new JAXBElement<CreateNewAppointmentResponse>(_CreateNewAppointmentResponse_QNAME, CreateNewAppointmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAppointmentByAppointmentIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "retrieveAppointmentByAppointmentIdResponse")
    public JAXBElement<RetrieveAppointmentByAppointmentIdResponse> createRetrieveAppointmentByAppointmentIdResponse(RetrieveAppointmentByAppointmentIdResponse value) {
        return new JAXBElement<RetrieveAppointmentByAppointmentIdResponse>(_RetrieveAppointmentByAppointmentIdResponse_QNAME, RetrieveAppointmentByAppointmentIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAppointmentEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "updateAppointmentEntity")
    public JAXBElement<UpdateAppointmentEntity> createUpdateAppointmentEntity(UpdateAppointmentEntity value) {
        return new JAXBElement<UpdateAppointmentEntity>(_UpdateAppointmentEntity_QNAME, UpdateAppointmentEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfCanRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifCanRate")
    public JAXBElement<IfCanRate> createIfCanRate(IfCanRate value) {
        return new JAXBElement<IfCanRate>(_IfCanRate_QNAME, IfCanRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfAppointmentCanAddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifAppointmentCanAddResponse")
    public JAXBElement<IfAppointmentCanAddResponse> createIfAppointmentCanAddResponse(IfAppointmentCanAddResponse value) {
        return new JAXBElement<IfAppointmentCanAddResponse>(_IfAppointmentCanAddResponse_QNAME, IfAppointmentCanAddResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFirstAvailableTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "findFirstAvailableTimeResponse")
    public JAXBElement<FindFirstAvailableTimeResponse> createFindFirstAvailableTimeResponse(FindFirstAvailableTimeResponse value) {
        return new JAXBElement<FindFirstAvailableTimeResponse>(_FindFirstAvailableTimeResponse_QNAME, FindFirstAvailableTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "convertDateResponse")
    public JAXBElement<ConvertDateResponse> createConvertDateResponse(ConvertDateResponse value) {
        return new JAXBElement<ConvertDateResponse>(_ConvertDateResponse_QNAME, ConvertDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfCanRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifCanRateResponse")
    public JAXBElement<IfCanRateResponse> createIfCanRateResponse(IfCanRateResponse value) {
        return new JAXBElement<IfCanRateResponse>(_IfCanRateResponse_QNAME, IfCanRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IfDateHasNotPassed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.session.ejb/", name = "ifDateHasNotPassed")
    public JAXBElement<IfDateHasNotPassed> createIfDateHasNotPassed(IfDateHasNotPassed value) {
        return new JAXBElement<IfDateHasNotPassed>(_IfDateHasNotPassed_QNAME, IfDateHasNotPassed.class, null, value);
    }

}
