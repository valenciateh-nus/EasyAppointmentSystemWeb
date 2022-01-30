/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateful.BookingSessionBeanLocal;
import ejb.session.stateless.CustomerEntitySessionBeanLocal;
import entity.BusinessCategoryEntity;
import entity.CustomerEntity;
import entity.ServiceProviderEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import util.exception.AppointmentNumberExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;


@WebService(serviceName = "BookingWebService")
@Stateless
public class BookingWebService 
{

    @EJB
    private CustomerEntitySessionBeanLocal customerEntitySessionBeanLocal;

    @EJB
    private BookingSessionBeanLocal bookingSessionBeanLocal;
    
    @WebMethod(operationName = "addAppointment")
    public void addAppointment(@WebParam(name = "email") String emailAddr,
                               @WebParam(name = "password") String password,
                               @WebParam(name = "appointmentNo")String appointmentNo,
                               @WebParam(name = "scheduledTime") String scheduledTime,
                               @WebParam(name = "scheduledDate") String scheduledDate,
                               @WebParam(name = "customerEntity") CustomerEntity currentCustomerEntity,
                               @WebParam(name = "serviceProviderEntity") ServiceProviderEntity serviceProviderEntity,
                               @WebParam(name = "businessCategoryEntity")BusinessCategoryEntity businessCategoryEntity)
                        throws InvalidLoginCredentialException, ServiceProviderNotFoundException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.addAppointment(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.addAppointment(appointmentNo, scheduledTime, scheduledDate, customerEntity, serviceProviderEntity, businessCategoryEntity);
    }
    
    @WebMethod(operationName = "doBooking")
    public Long doBooking(@WebParam(name = "email") String emailAddr,
                        @WebParam(name = "password") String password,
                        @WebParam(name = "customerId")Long customerId,
                        @WebParam(name = "serviceProviderId") Long serviceProviderId)
            throws InvalidLoginCredentialException, UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.doBooking(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.doBooking(customerId, serviceProviderId);
    }
    
    @WebMethod(operationName = "clearAppointmentCart")
    public void clearAppointmentCart(@WebParam(name = "email") String emailAddr,
                                     @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.clearAppointmentCart(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.clearAppointmentCart();
    }
    
    @WebMethod(operationName = "getAppointmentNo")
    public String getAppointmentNo(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getAppointmentNo(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getAppointmentNo();
    }
    
    @WebMethod(operationName = "setAppointmentNo")
    public void setAppointmentNo(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password,
                                 @WebParam(name = "appointmentNo") String appointmentNo)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setAppointmentNo(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setAppointmentNo(appointmentNo);
    }
    
    @WebMethod(operationName = "getScheduledTime")
    public String getScheduledTime(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getScheduledTime(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getScheduledTime();
    }
    
    @WebMethod(operationName = "setScheduledTime")
    public void setScheduledTime(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password,
                                 @WebParam(name = "scheduledTime") String scheduledTime)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setScheduledTime(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setScheduledTime(scheduledTime);
    }
    
    
    @WebMethod(operationName = "getScheduledDate")
    public String getScheduledDate(@WebParam(name = "email") String emailAddr,
                                      @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getScheduledDate(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getScheduledDate();
    }
    
    
    
    @WebMethod(operationName = "setScheduledDate")
    public void setScheduledDate(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password,
                                 @WebParam(name = "setScheduledDate") String setScheduledDate)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setAppointmentNo(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setScheduledDate(setScheduledDate);
    }
    
    @WebMethod(operationName = "getCustomerEntity")
    public CustomerEntity getCustomerEntity(@WebParam(name = "email") String emailAddr,
                                      @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getCustomerEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getCustomerEntity();
    }
    
    
    @WebMethod(operationName = "setCustomerEntity")
    public void setCustomerEntity(@WebParam(name = "email") String emailAddr,
                                 @WebParam(name = "password") String password,
                                 @WebParam(name = "newCustomerEntity") CustomerEntity newCustomerEntity)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setCustomerEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setCustomerEntity(newCustomerEntity);
    }
    
    @WebMethod(operationName = "getServiceProviderEntity")
    public ServiceProviderEntity getServiceProviderEntity(@WebParam(name = "email") String emailAddr,
                                      @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getServiceProviderEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getServiceProviderEntity();
    }
    
    
    @WebMethod(operationName = "setServiceProviderEntity")
    public void setServiceProviderEntity(@WebParam(name = "email") String emailAddr,
                                         @WebParam(name = "password") String password,
                                         @WebParam(name = "serviceProviderEntity") ServiceProviderEntity serviceProviderEntity)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setServiceProviderEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setServiceProviderEntity(serviceProviderEntity);
    }
    
    
    @WebMethod(operationName = "getBusinessCategoryEntity")
    public BusinessCategoryEntity getBusinessCategoryEntity(@WebParam(name = "email") String emailAddr,
                                      @WebParam(name = "password") String password)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.getBusinessCategoryEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        return bookingSessionBeanLocal.getBusinessCategoryEntity();
    }
    
    
    @WebMethod(operationName = "setBusinessCategoryEntity")
    public void setBusinessCategoryEntity(@WebParam(name = "email") String emailAddr,
                                         @WebParam(name = "password") String password,
                                         @WebParam(name = "businessCategoryEntity") BusinessCategoryEntity businessCategoryEntity)
                           throws InvalidLoginCredentialException
    {
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.setBusinessCategoryEntity(): Customer " 
                            + customerEntity.getEmailAddress() 
                            + " login remotely via web service");
        
        bookingSessionBeanLocal.setBusinessCategoryEntity(businessCategoryEntity);
    }
   
}
