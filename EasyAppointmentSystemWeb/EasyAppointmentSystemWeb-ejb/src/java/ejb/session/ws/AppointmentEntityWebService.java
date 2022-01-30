/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateless.AppointmentEntitySessionBeanLocal;
import ejb.session.stateless.CustomerEntitySessionBeanLocal;
import entity.AppointmentEntity;
import entity.CustomerEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import util.exception.AppointmentNotFoundException;
import util.exception.AppointmentNumberExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InputInvalidValuesException;
import util.exception.InvalidLoginCredentialException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;

/**
 *
 * @author valenciateh
 */
@WebService(serviceName = "AppointmentEntityWebService")
@Stateless
public class AppointmentEntityWebService {

    @EJB(name = "CustomerEntitySessionBeanLocal")
    private CustomerEntitySessionBeanLocal customerEntitySessionBeanLocal;

    @EJB(name = "AppointmentEntitySessionBeanLocal")
    private AppointmentEntitySessionBeanLocal appointmentEntitySessionBeanLocal;

    @WebMethod(operationName = "createNewAppointment")
    public Long createNewAppointment(@WebParam(name = "email") String emailAddr,
                                                                     @WebParam(name = "password") String password,
                                                                     @WebParam(name = "customerId") Long customerId, 
                                                                     @WebParam(name = "serviceProviderId") Long serviceProviderId, 
                                                                     @WebParam(name = "newAppointmentEntity") AppointmentEntity newAppointmentEntity) 
            throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException, InvalidLoginCredentialException
    {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveServiceProviderEntityByName(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.createNewAppointment(customerId, serviceProviderId, newAppointmentEntity);
    }
    

   @WebMethod(operationName = "retrieveAppointmentByCustomer")
    public List<AppointmentEntity> retrieveAppointmentByCustomer(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "customerId") Long customerId,
            @WebParam(name = "serviceProviderId") Long serviceProviderId) throws InvalidLoginCredentialException, AppointmentNotFoundException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveAppointmentsByCustomer(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");

        return appointmentEntitySessionBeanLocal.retrieveAppointmentByCustomer(customerId, serviceProviderId);
    }

    @WebMethod(operationName = "retrieveAppointmentsByServiceProviderId")
    public List<AppointmentEntity> retrieveAppointmentsByServiceProviderId(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "serviceProviderId") Long serviceProviderId) throws InvalidLoginCredentialException, AppointmentNotFoundException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveAppointmentByServiceProviderId(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");

        return appointmentEntitySessionBeanLocal.retrieveAppointmentsByServiceProviderId(serviceProviderId);
    }

    @WebMethod(operationName = "retrieveAppointmentsByDate")
    public List<AppointmentEntity> retrieveAppointmentsByDate(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "date") String date,
            @WebParam(name = "serviceProviderName") String serviceProviderName) throws InvalidLoginCredentialException, AppointmentNotFoundException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveAppointmentByDate(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");

        return appointmentEntitySessionBeanLocal.retrieveAppointmentsByDate(date, serviceProviderName);
    }
    
    @WebMethod(operationName = "retrieveSortedAppointmentsByDate")
    public List<AppointmentEntity> retrieveSortedAppointmentsByDate(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "date") String date,
            @WebParam(name = "serviceProviderId") Long serviceProviderId) throws InvalidLoginCredentialException, AppointmentNotFoundException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveSortedAppointmentsByDate(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");

        return appointmentEntitySessionBeanLocal.retrieveSortedAppointmentsByDate(date, serviceProviderId);
    }

    @WebMethod(operationName = "retrieveAppointmentByAppointmentId")
    public AppointmentEntity retrieveAppointmentByAppointmentId(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "appointmentId") Long appointmentId) throws AppointmentNotFoundException, InvalidLoginCredentialException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveAppointmentByAppointmentId(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");

        return appointmentEntitySessionBeanLocal.retrieveAppointmentByAppointmentId(appointmentId);

    }

    @WebMethod(operationName = "updateAppointmentEntity")
    public void updateAppointmentEntity(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "appointmentEntity") AppointmentEntity appointmentEntity) throws InvalidLoginCredentialException
    {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.updateAppointmentEntity(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        appointmentEntitySessionBeanLocal.updateAppointmentEntity(appointmentEntity);
    }
    
    @WebMethod(operationName = "deleteAppointment")
    public void deleteAppointment(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "appointmentNumber") String appointmentNo) throws AppointmentNotFoundException, InvalidLoginCredentialException {

        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.deleteAppointment(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        appointmentEntitySessionBeanLocal.deleteAppointment(appointmentNo);
        
    }

    @WebMethod(operationName = "retrieveAppointmentByAppointmentNumber")
    public AppointmentEntity retrieveAppointmentByAppointmentNumber(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "appointmentNumber") String appointmentNo) throws AppointmentNotFoundException, InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.retrieveAppointmentByAppointmentNumber(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.retrieveAppointmentByAppointmentNumber(appointmentNo);
        
    }
    
    @WebMethod(operationName = "convertDate")
    public LocalDate convertDate(@WebParam(name = "email") String emailAddr,
            @WebParam(name = "password") String password,
            @WebParam(name = "date") String date) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.convertDate(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.convertDate(date);
        
    }
    
    @WebMethod(operationName = "ifAppointmentCanCancel")
    public boolean ifAppointmentCanCancel(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "appointmentNo") String appointmentNo) throws InputInvalidValuesException, InvalidLoginCredentialException, AppointmentNotFoundException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.ifAppointmentCanCancel(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.ifAppointmentCanCancel(appointmentNo);
        
    }
    
    @WebMethod(operationName = "convertTime")
    public LocalTime convertTime(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password,
                                 @WebParam(name = "appointmentTime") String appointmentTime) throws InputInvalidValuesException, InvalidLoginCredentialException, AppointmentNotFoundException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.convertTime(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.convertTime(appointmentTime);
    }
    
    @WebMethod(operationName = "calculateDayOfTheWeek")
    public String calculateDayOfTheWeek(@WebParam(name = "email") String emailAddr,
                                        @WebParam(name = "password") String password,
                                        @WebParam(name = "date") String date) throws InvalidLoginCredentialException, AppointmentNotFoundException, InputInvalidValuesException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.calculateDayOfTheWeek(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.calculateDayOfTheWeek(date);
    }
    
    @WebMethod(operationName = "ifAppointmentCanAdd")
    public boolean ifAppointmentCanAdd(@WebParam(name = "email") String emailAddr,
                                       @WebParam(name = "password") String password,
                                       @WebParam(name = "date") String date,
                                       @WebParam(name = "time") String time) throws InvalidLoginCredentialException, AppointmentNotFoundException, InputInvalidValuesException{
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.ifAppointmentCanAdd(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.ifAppointmentCanAdd(date, time);
    }
    
    @WebMethod(operationName = "ifCanRate") 
    public Long ifCanRate(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "apptList") List<AppointmentEntity> apptList,
                                                @WebParam(name = "serviceProviderId") Long serviceProviderId)
            throws InvalidLoginCredentialException, AppointmentNotFoundException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.ifCanRate(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.ifCanRate(apptList, serviceProviderId);
    }
    
    @WebMethod(operationName = "updateAppointmentEntityRating")
    public void updateAppointmentEntityRating(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "appointmentId") Long appointmentId) throws InvalidLoginCredentialException, AppointmentNotFoundException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.updateAppointmentEntityRating(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        appointmentEntitySessionBeanLocal.updateAppointmentEntityRating(appointmentId);
    }
    
    @WebMethod(operationName = "getLocalTimeInString")
    public String getLocalTimeInString(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "time") LocalTime time) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getLocalTimeInString(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.getLocalTimeInString(time);
    }
    
    @WebMethod(operationName = "findFirstAvailableTime")
    public String findFirstAvailableTime(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "appointmentList") List<AppointmentEntity> appointmentList,
                                                @WebParam(name = "timeSlots") List<String> timeSlots) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.findFirstAvailableTime(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.findFirstAvailableTime(appointmentList, timeSlots);
    }
    
    @WebMethod(operationName = "findAvailableTimeSlot")
    public List<String> findAvailableTimeSlot(@WebParam(name = "email") String emailAddr,
                                                @WebParam(name = "password") String password,
                                                @WebParam(name = "appointmentList") List<AppointmentEntity> appointmentList,
                                                @WebParam(name = "timeSlots") List<String> timeSlots) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.findAvailableTimeSlot(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.findAvailableTimeSlot(appointmentList, timeSlots);
    }
    
    @WebMethod(operationName = "ifDateHasNotPassed")
    public boolean ifDateHasNotPassed(@WebParam(name = "email") String emailAddr,
                                      @WebParam(name = "password") String password,
                                      @WebParam(name = "date") String date)
                                      throws InvalidLoginCredentialException, InputInvalidValuesException
    {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.ifDateHasNotPassed(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return appointmentEntitySessionBeanLocal.ifDateHasNotPassed(date);

    }

    
}