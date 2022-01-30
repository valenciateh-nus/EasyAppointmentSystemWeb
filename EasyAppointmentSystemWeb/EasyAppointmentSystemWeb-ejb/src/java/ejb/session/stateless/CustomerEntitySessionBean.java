package ejb.session.stateless;

import entity.CustomerEntity;
import java.util.List;
import java.util.Set;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import util.exception.CustomerDeletionException;
import util.exception.CustomerNotFoundException;
import util.exception.CustomerEmailExistsException;
import util.exception.CustomerNotUniqueException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateCustomerException;

@Stateless
@Local(CustomerEntitySessionBeanLocal.class)
@Remote(CustomerEntitySessionBeanRemote.class)
public class CustomerEntitySessionBean implements CustomerEntitySessionBeanRemote, CustomerEntitySessionBeanLocal 
{

    @PersistenceContext(unitName = "EasyAppointmentSystemWeb-ejbPU")
    private EntityManager em;
    
    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    public CustomerEntitySessionBean() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    
    @Override
    public Long createNewCustomer(CustomerEntity newCustomerEntity) throws CustomerNotUniqueException, UnknownPersistenceException, InputDataValidationException
    {
        try
        {
            Set<ConstraintViolation<CustomerEntity>>constraintViolations = validator.validate(newCustomerEntity);
        
            if(constraintViolations.isEmpty())
            {
                em.persist(newCustomerEntity);
                em.flush();

                return newCustomerEntity.getCustomerId();
            }
            else
            {
                throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
            }            
        }
        catch(PersistenceException ex)
        {
            if(ex.getCause() != null && ex.getCause().getClass().getName().equals("org.eclipse.persistence.exceptions.DatabaseException"))
            {
                if(ex.getCause().getCause() != null && ex.getCause().getCause().getClass().getName().equals("java.sql.SQLIntegrityConstraintViolationException"))
                {
                    throw new CustomerNotUniqueException("Customer not unique : Email Address or Identification Number already exists!\n");
                }
                else
                {
                    throw new UnknownPersistenceException(ex.getMessage());
                }
            }
            else
            {
                throw new UnknownPersistenceException(ex.getMessage());
            }
        }
    }
    
    @Override
    public CustomerEntity retrieveCustomerEntityByCustomerId(Long customerId) throws CustomerNotFoundException
    {   
        CustomerEntity customerEntity = em.find(CustomerEntity.class, customerId);

        if (customerEntity != null)
        {
            customerEntity.getAppointmentEntities().size();
            return customerEntity;
        }
        else
        {
            throw new CustomerNotFoundException("Customer ID: " + customerId + " does not exist!");
        }
    }
    
    @Override
    public CustomerEntity retrieveCustomerByEmail(String email) throws CustomerNotFoundException
    {
        Query query = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.emailAddress = :inEmail");
        query.setParameter("inEmail", email);
        
        try
        {
            CustomerEntity customerEntity = (CustomerEntity)query.getSingleResult();
            customerEntity.getAppointmentEntities().size();
            return customerEntity;
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new CustomerNotFoundException("Customer Email " + email + " does not exist!");
        }
    }
    
    @Override
    public List<CustomerEntity> retrieveAllCustomers()
    {
        Query query = em.createQuery("SELECT c FROM CustomerEntity c");
        
        return query.getResultList();
    }
    
    @Override
    public CustomerEntity customerLogin(String email, String password) throws InvalidLoginCredentialException
    {
        try
        {
            CustomerEntity customerEntity = retrieveCustomerByEmail(email);
            
            if(customerEntity.getPassword().equals(password))
            {
                customerEntity.getAppointmentEntities().size();                
                return customerEntity;
            }
            else
            {
                throw new InvalidLoginCredentialException("Email does not exist or invalid password!");
            }
        }
        catch(CustomerNotFoundException ex)
        {
            throw new InvalidLoginCredentialException("Email does not exist or invalid password!");
        }
    }
    
    @Override
    public void updateCustomer(CustomerEntity customerEntity) throws CustomerNotFoundException, InputDataValidationException, UpdateCustomerException
    {
        if(customerEntity != null && customerEntity.getCustomerId() != null)
        {
            Set<ConstraintViolation<CustomerEntity>>constraintViolations = validator.validate(customerEntity);
        
            if(constraintViolations.isEmpty())
            {
                CustomerEntity customerEntityToUpdate = retrieveCustomerEntityByCustomerId(customerEntity.getCustomerId());

                if(customerEntityToUpdate.getEmailAddress().equals(customerEntity.getEmailAddress()))
                {
                    customerEntityToUpdate.setIdentityNumber(customerEntity.getIdentityNumber());
                    customerEntityToUpdate.setFirstName(customerEntity.getFirstName());
                    customerEntityToUpdate.setLastName(customerEntity.getLastName());
                    customerEntityToUpdate.setGender(customerEntity.getGender());
                    customerEntityToUpdate.setAddress(customerEntity.getAddress());
                    customerEntityToUpdate.setAge(customerEntity.getAge());
                    customerEntityToUpdate.setCity(customerEntity.getCity());
                    customerEntityToUpdate.setPhoneNumber(customerEntity.getPhoneNumber());
                    customerEntityToUpdate.setPassword(customerEntity.getPassword());
                }
                
                else
                {                    
                    throw new UpdateCustomerException("Email of customer record to be updated does not match the existing record");
                }
            }
            else
            {
                throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
            }
        }
        else
        {
            throw new CustomerNotFoundException("Customer ID not found!");
        }
    }
    
    @Override
    public void deleteCustomer(Long customerId) throws CustomerDeletionException, CustomerNotFoundException
    {
        CustomerEntity customerEntity = retrieveCustomerEntityByCustomerId(customerId);
        
        if(customerEntity.getAppointmentEntities().isEmpty())
        {
            em.remove(customerEntity);
        }
        else
        {
            throw new CustomerDeletionException("Customer ID " + customerId + " is associated with existing appointment(s) and cannot be deleted!");
        }
    }

    private String prepareInputDataValidationErrorsMessage(Set<ConstraintViolation<CustomerEntity>>constraintViolations)
    {
        String msg = "Input data validation error!:";
            
        for(ConstraintViolation constraintViolation:constraintViolations)
        {
            msg += "\n\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage();
        }
        
        return msg;
    }
    
    
}
