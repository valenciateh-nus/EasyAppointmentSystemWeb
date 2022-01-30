package ejb.session.stateless;

import entity.BusinessCategoryEntity;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBContext;
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
import util.exception.BusinessCategoryExistException;
import util.exception.BusinessCategoryNotFoundException;
import util.exception.DeleteBusinessCategoryException;
import util.exception.InputDataValidationException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;

@Stateless
@Local(BusinessCategoryEntitySessionBeanLocal.class)
@Remote(BusinessCategoryEntitySessionBeanRemote.class)
public class BusinessCategoryEntitySessionBean implements BusinessCategoryEntitySessionBeanRemote, BusinessCategoryEntitySessionBeanLocal {

    @PersistenceContext(unitName = "EasyAppointmentSystemWeb-ejbPU")
    private EntityManager em;

    private final ValidatorFactory validatorFactory;
    private final Validator validator;
    
    public BusinessCategoryEntitySessionBean() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    
    @Override
    public String createNewBusinessCategoryEntity(BusinessCategoryEntity newBusinessCategoryEntity) throws BusinessCategoryExistException, UnknownPersistenceException, InputDataValidationException
    {
        try
        {
            Set<ConstraintViolation<BusinessCategoryEntity>>constraintViolations = validator.validate(newBusinessCategoryEntity);
        
            if(constraintViolations.isEmpty())
            {
                em.persist(newBusinessCategoryEntity);
                em.flush();

                return newBusinessCategoryEntity.getCategory();
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
                    throw new BusinessCategoryExistException();
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
    public List<BusinessCategoryEntity> retrieveAllBusinessCategories() {
        Query query = em.createQuery("SELECT b FROM BusinessCategoryEntity b");
        
        List<BusinessCategoryEntity> businessCategoryList = query.getResultList();
        
        for (BusinessCategoryEntity b : businessCategoryList)
        {
            b.getServiceProviderEntities().size();
        }
        return businessCategoryList;
    }
    
    @Override
    public BusinessCategoryEntity retrieveBusinessCategoriesByName(String name) throws BusinessCategoryNotFoundException {
        
        Query query = em.createQuery("SELECT b FROM BusinessCategoryEntity b WHERE b.category = :inName");
        query.setParameter("inName", name);
        
        try
        {
            BusinessCategoryEntity businessCategory = (BusinessCategoryEntity)query.getSingleResult();
            businessCategory.getServiceProviderEntities().size();
            return businessCategory;
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new BusinessCategoryNotFoundException("Business Category " + name + " does not exist!");
        }
    }
    
    @Override
    public BusinessCategoryEntity retrieveBusinessCategoriesById(Long businessCategoryId) throws BusinessCategoryNotFoundException {
        
        Query query = em.createQuery("SELECT b FROM BusinessCategoryEntity b WHERE b.businessCategoryId = :inBusinessCategoryId");
        query.setParameter("inBusinessCategoryId", businessCategoryId);
        
        try
        {
            BusinessCategoryEntity businessCategory = (BusinessCategoryEntity)query.getSingleResult();
            businessCategory.getServiceProviderEntities().size();
            return businessCategory;
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new BusinessCategoryNotFoundException("Business Category ID " + businessCategoryId + " does not exist!");
        }
    }
    
    

    @Override
    public void deleteBusinessCategory(Long businessCategoryId) throws DeleteBusinessCategoryException, BusinessCategoryNotFoundException {

        BusinessCategoryEntity currentBusinessCategory = retrieveBusinessCategoriesById(businessCategoryId);
        if (currentBusinessCategory.getServiceProviderEntities().isEmpty())
        {
            em.remove(currentBusinessCategory);
            em.flush();
        }
        else
        {
            throw new DeleteBusinessCategoryException("Business Category Id " + businessCategoryId + " is associated with existing Service Providers record(s) and cannot be deleted!");
        }
        
    }
    
         private String prepareInputDataValidationErrorsMessage(Set<ConstraintViolation<BusinessCategoryEntity>>constraintViolations)
    {
        String msg = "Input data validation error!:";
            
        for(ConstraintViolation constraintViolation:constraintViolations)
        {
            msg += "\n\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage();
        }
        
        return msg;
    }
}
