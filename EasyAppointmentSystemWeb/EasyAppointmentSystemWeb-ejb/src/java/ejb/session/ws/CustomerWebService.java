/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.ws;

import ejb.session.stateless.CustomerEntitySessionBeanLocal;
import entity.CustomerEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import util.exception.CustomerDeletionException;
import util.exception.CustomerNotUniqueException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateCustomerException;

/**
 *
 * @author valenciateh
 */
@WebService(serviceName = "CustomerWebService")
@Stateless
public class CustomerWebService {

    @EJB(name = "CustomerEntitySessionBeanLocal")
    private CustomerEntitySessionBeanLocal customerEntitySessionBeanLocal;

    @WebMethod(operationName = "createNewCustomer")
    public Long createNewCustomer(@WebParam(name = "customerEntity") CustomerEntity newCustomerEntity) throws CustomerNotUniqueException, UnknownPersistenceException, InputDataValidationException {

        System.out.println("********** EasyAppointmentSystem.CustomerEntitySessionBeanLocal(): Customer "
                
                + " doing registering remotely via web service");

        return customerEntitySessionBeanLocal.createNewCustomer(newCustomerEntity);
    }
    
    
    @WebMethod(operationName = "retrieveCustomerEntityByCustomerId")
    public CustomerEntity retrieveCustomerEntityByCustomerId(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password, 
                                  @WebParam(name = "customerId") Long customerId) throws CustomerNotFoundException, InvalidLoginCredentialException
    {  
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return customerEntitySessionBeanLocal.retrieveCustomerEntityByCustomerId(customerId);
    }
    
    @WebMethod(operationName = "retrieveCustomerByEmail")   
    public CustomerEntity retrieveCustomerByEmail(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password, 
                                  @WebParam(name = "emailAddress") String email) throws CustomerNotFoundException, InvalidLoginCredentialException
    {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
    
        return customerEntitySessionBeanLocal.retrieveCustomerByEmail(email);
    }
    
    @WebMethod(operationName = "retrieveAllCustomers")
    public List<CustomerEntity> retrieveAllCustomers(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return customerEntitySessionBeanLocal.retrieveAllCustomers();
    }
    
    @WebMethod(operationName = "updateCustomer")
    public void updateCustomer(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password, 
                                  @WebParam(name = "customerEntity") CustomerEntity updatedCustomerEntity) throws CustomerNotFoundException, InputDataValidationException, UpdateCustomerException, InvalidLoginCredentialException
    {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        customerEntitySessionBeanLocal.updateCustomer(customerEntity);
    }
    
    @WebMethod(operationName = "deleteCustomer")
    public void deleteCustomer(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password, 
                                  @WebParam(name = "customerId") Long customerId) throws CustomerDeletionException, CustomerNotFoundException, InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        customerEntitySessionBeanLocal.deleteCustomer(customerId);
    }
    
    @WebMethod(operationName = "customerLogin")
    public CustomerEntity customerLogin(@WebParam(name = "email") String emailAddr,
                                  @WebParam(name = "password") String password, 
                                  @WebParam(name = "loginEmail") String email, 
                                  @WebParam(name = "loginPassword") String enteredPassword) throws InvalidLoginCredentialException {
        
        CustomerEntity customerEntity = customerEntitySessionBeanLocal.customerLogin(emailAddr, password);
        System.out.println("********** EasyAppointmentSystem.emailCheckoutNotificationSync(): Customer "
                + customerEntity.getEmailAddress()
                + " login remotely via web service");
        
        return customerEntitySessionBeanLocal.customerLogin(email, password);
    }
}
