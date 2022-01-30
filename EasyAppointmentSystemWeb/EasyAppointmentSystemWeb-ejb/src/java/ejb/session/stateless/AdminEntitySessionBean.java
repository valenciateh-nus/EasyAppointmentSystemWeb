package ejb.session.stateless;

import entity.AdminEntity;
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
import util.exception.AdminNotFoundException;
import util.exception.AdminUsernameExistException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateAdminException;


@Stateless
@Local(AdminEntitySessionBeanLocal.class)
@Remote(AdminEntitySessionBeanRemote.class)
public class AdminEntitySessionBean implements AdminEntitySessionBeanRemote, AdminEntitySessionBeanLocal 
{
    
    @PersistenceContext(unitName = "EasyAppointmentSystemWeb-ejbPU")
    private EntityManager em;
    
    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    public AdminEntitySessionBean() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    
    @Override
    public AdminEntity adminLogin(String email, String password) throws InvalidLoginCredentialException
    {
        try
        {
            AdminEntity adminEntity = retrieveAdminByEmail(email);
            
            if(adminEntity.getPassword().equals(password))
            {   
                adminEntity.getPassword();
                return adminEntity;
            }
            else
            {
                throw new InvalidLoginCredentialException("Email Address does not exist or invalid password!");
            }
        }
        catch(AdminNotFoundException ex)
        {
            throw new InvalidLoginCredentialException("Email Address does not exist or invalid password!");
        }
    }
    
    @Override
    public Long createNewAdmin(AdminEntity newAdminEntity) throws AdminUsernameExistException, UnknownPersistenceException, InputDataValidationException
    {
        try
        {
            Set<ConstraintViolation<AdminEntity>>constraintViolations = validator.validate(newAdminEntity);
        
            if(constraintViolations.isEmpty())
            {
                em.persist(newAdminEntity);
                em.flush();

                return newAdminEntity.getAdminId();
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
                    throw new AdminUsernameExistException();
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
    public List<AdminEntity> retrieveAllAdmins()
    {
        Query query = em.createQuery("SELECT a FROM AdminEntity a");
        
        return query.getResultList();
    }
    
    @Override
    public AdminEntity retrieveAdminEntityById(Long adminId) throws AdminNotFoundException
    {
        AdminEntity adminEntity = em.find(AdminEntity.class, adminId);
        
        if (adminEntity != null)
        {
            return adminEntity;
        }
        else 
        {
            throw new AdminNotFoundException("Admin ID " + adminId + " does not exist!");
        }
    }
    
    @Override
    public AdminEntity retrieveAdminEntityByName(String name) throws AdminNotFoundException
    {
        AdminEntity adminEntity = em.find(AdminEntity.class, name);
        
        if (adminEntity != null)
        {
            return adminEntity;
        }
        else 
        {
            throw new AdminNotFoundException("Admin ID " + name + " does not exist!");
        }
    }
    
    @Override
    public AdminEntity retrieveAdminByEmail(String email) throws AdminNotFoundException {
   
        Query query = em.createQuery("SELECT a FROM AdminEntity a WHERE a.email = :inEmail");
        query.setParameter("inEmail", email);
        
        try
        {
            AdminEntity adminEntity = (AdminEntity)query.getSingleResult();
            return adminEntity;
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new AdminNotFoundException("Admin Email " + email + " does not exist!");
        }

    }
    
    @Override
    public void updateAdminEntity(AdminEntity adminEntity) throws InputDataValidationException, UpdateAdminException, AdminNotFoundException 
    {
        if(adminEntity != null && adminEntity.getAdminId() != null)
        {
            Set<ConstraintViolation<AdminEntity>>constraintViolations = validator.validate(adminEntity);
        
            if(constraintViolations.isEmpty())
            {
                AdminEntity adminEntityToUpdate = retrieveAdminEntityById(adminEntity.getAdminId());

                if(adminEntityToUpdate.getEmail().equals(adminEntityToUpdate.getEmail()))
                {
                    adminEntityToUpdate.setPassword(adminEntity.getPassword());
                    adminEntityToUpdate.setName(adminEntity.getName());
                }
                
                else
                {                    
                    throw new UpdateAdminException("Email of customer record to be updated does not match the existing record");
                }
            }
            else
            {
                throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
            }
        }
        else
        {
            throw new AdminNotFoundException("Customer ID not found!");
        }
    }
    
    @Override
    public void deleteAdmin(Long adminId) throws AdminNotFoundException
    {
        AdminEntity adminEntity = retrieveAdminEntityById(adminId);
        
        em.remove(adminEntity);
    }
    
     private String prepareInputDataValidationErrorsMessage(Set<ConstraintViolation<AdminEntity>>constraintViolations)
    {
        String msg = "Input data validation error!:";
            
        for(ConstraintViolation constraintViolation:constraintViolations)
        {
            msg += "\n\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage();
        }
        
        return msg;
    }
    
    
   
}
