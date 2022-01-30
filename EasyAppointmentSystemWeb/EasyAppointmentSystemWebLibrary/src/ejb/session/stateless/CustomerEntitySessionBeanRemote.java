package ejb.session.stateless;

import entity.CustomerEntity;
import java.util.List;
import util.exception.CustomerDeletionException;
import util.exception.CustomerNotFoundException;
import util.exception.CustomerEmailExistsException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateCustomerException;
import util.exception.CustomerNotUniqueException;


public interface CustomerEntitySessionBeanRemote {

    public CustomerEntity retrieveCustomerEntityByCustomerId(Long customerId) throws CustomerNotFoundException;

    public Long createNewCustomer(CustomerEntity newCustomerEntity) throws CustomerNotUniqueException, UnknownPersistenceException, InputDataValidationException;

    public CustomerEntity retrieveCustomerByEmail(String email) throws CustomerNotFoundException;

    public List<CustomerEntity> retrieveAllCustomers();

    public CustomerEntity customerLogin(String email, String password) throws InvalidLoginCredentialException;
    
    public void updateCustomer(CustomerEntity customerEntity) throws CustomerNotFoundException, InputDataValidationException, UpdateCustomerException;

    public void deleteCustomer(Long customerId) throws CustomerDeletionException, CustomerNotFoundException;

}
