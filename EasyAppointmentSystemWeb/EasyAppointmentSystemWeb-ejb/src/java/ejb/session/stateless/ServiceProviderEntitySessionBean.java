package ejb.session.stateless;

import entity.BusinessCategoryEntity;
import entity.ServiceProviderEntity;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
import util.enumeration.StatusEnum;
import util.exception.BusinessCategoryNotFoundException;
import util.exception.DeleteServiceProviderException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderEmailExistException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.ServiceProviderNotUniqueException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateServiceProviderException;

@Stateless
@Local(ServiceProviderEntitySessionBeanLocal.class)
@Remote(ServiceProviderEntitySessionBeanRemote.class)
public class ServiceProviderEntitySessionBean implements ServiceProviderEntitySessionBeanRemote, ServiceProviderEntitySessionBeanLocal {

    @EJB
    private BusinessCategoryEntitySessionBeanLocal businessCategoryEntitySessionBeanLocal;

    @PersistenceContext(unitName = "EasyAppointmentSystemWeb-ejbPU")
    private EntityManager em;

    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    public ServiceProviderEntitySessionBean() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Override
    public Long createNewServiceProvider(String businessCategoryName, ServiceProviderEntity newServiceProviderEntity) throws UnknownPersistenceException, InputDataValidationException, BusinessCategoryNotFoundException, ServiceProviderNotUniqueException, PersistenceException {
        try {
            Set<ConstraintViolation<ServiceProviderEntity>> constraintViolations = validator.validate(newServiceProviderEntity);

            if (constraintViolations.isEmpty()) {
                BusinessCategoryEntity businessCategoryEntity = businessCategoryEntitySessionBeanLocal.retrieveBusinessCategoriesByName(businessCategoryName);
                newServiceProviderEntity.setBusinessCategoryEntity(businessCategoryEntity);
                businessCategoryEntity.getServiceProviderEntities().add(newServiceProviderEntity);

                em.persist(newServiceProviderEntity);
                em.flush();

                return newServiceProviderEntity.getServiceProviderId();
            } else {
                throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
            }
        } catch (PersistenceException ex) {
            if (ex.getCause() != null && ex.getCause().getClass().getName().equals("org.eclipse.persistence.exceptions.DatabaseException")) {
                if (ex.getCause().getCause() != null && ex.getCause().getCause().getClass().getName().equals("java.sql.SQLIntegrityConstraintViolationException")) {
                    throw new ServiceProviderNotUniqueException("Service Provider is not unique!");
                } else {
                    throw new UnknownPersistenceException(ex.getMessage());
                }
            } else {
                throw new UnknownPersistenceException(ex.getMessage());
            }
        }
    }

    @Override
    public ServiceProviderEntity doServiceProviderLogin(String email, String password) throws InvalidLoginCredentialException, ServiceProviderBlockedException{
        try {
            ServiceProviderEntity serviceProviderEntity = retrieveServiceProviderEntityByEmailForLogin(email);

            if (serviceProviderEntity.getPassword().equals(password)) {
                serviceProviderEntity.getAppointmentEntities().size();
                if (serviceProviderEntity.getStatusEnum().equals(StatusEnum.Blocked)) {        
                    throw new ServiceProviderBlockedException("Service Provider has been blocked.");
                } else {
                    return serviceProviderEntity;
                }
            } else {
                throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
            }
        } catch (ServiceProviderNotFoundException ex) {
            throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
        }
    }

    @Override
    public List<ServiceProviderEntity> retrieveAllServiceProviderEntity() {
        Query query = em.createQuery("SELECT s FROM ServiceProviderEntity s");

        return query.getResultList();
    }

    @Override
    public ServiceProviderEntity retrieveServiceProviderEntityByEmail(String email) throws ServiceProviderNotFoundException {
        Query query = em.createQuery("SELECT s FROM ServiceProviderEntity s WHERE s.emailAddress = :inEmail and s.statusEnum = util.enumeration.StatusEnum.Approved");
        query.setParameter("inEmail", email);

        try {
            ServiceProviderEntity serviceProviderEntity = (ServiceProviderEntity) query.getSingleResult();
            serviceProviderEntity.getAppointmentEntities().size();
            return serviceProviderEntity;
        } catch (NoResultException | NonUniqueResultException ex) {
            throw new ServiceProviderNotFoundException("Service Provider Email " + email + " does not exist!");
        }
    }
    
    @Override
    public ServiceProviderEntity retrieveServiceProviderEntityByEmailForLogin(String email) throws ServiceProviderNotFoundException {
        Query query = em.createQuery("SELECT s FROM ServiceProviderEntity s WHERE s.emailAddress = :inEmail");
        query.setParameter("inEmail", email);

        try {
            ServiceProviderEntity serviceProviderEntity = (ServiceProviderEntity) query.getSingleResult();
            serviceProviderEntity.getAppointmentEntities().size();
            return serviceProviderEntity;
        } catch (NoResultException | NonUniqueResultException ex) {
            throw new ServiceProviderNotFoundException("Service Provider Email " + email + " does not exist!");
        }
    }

    @Override
    public ServiceProviderEntity retrieveServiceProviderEntityByName(String name) throws ServiceProviderNotFoundException {
        Query query = em.createQuery("SELECT s FROM ServiceProviderEntity s WHERE s.name = :inName and s.statusEnum = util.enumeration.StatusEnum.Approved");
        query.setParameter("inName", name);

        try {
            ServiceProviderEntity serviceProviderEntity = (ServiceProviderEntity) query.getSingleResult();
            serviceProviderEntity.getAppointmentEntities().size();
            return serviceProviderEntity;
        } catch (NoResultException | NonUniqueResultException ex) {
            throw new ServiceProviderNotFoundException("Service Provider Name " + name + " does not exist!");
        }
    }

    @Override
    public List<ServiceProviderEntity> retrieveServiceProviderEntityBySearch(String businessCategory, String city) throws ServiceProviderNotFoundException {
        Query query = em.createQuery("SELECT s FROM ServiceProviderEntity s WHERE s.city = :inCity and s.businessCategory = :inBusinessCategory and s.statusEnum = util.enumeration.StatusEnum.Approved");
        query.setParameter("inCity", city);
        query.setParameter("inBusinessCategory", businessCategory);
        
        return query.getResultList();
    }

    @Override
    public ServiceProviderEntity retrieveServiceProviderEntityById(Long serviceProviderId) throws ServiceProviderNotFoundException, ServiceProviderBlockedException {
        
        ServiceProviderEntity serviceProviderEntity = em.find(ServiceProviderEntity.class, serviceProviderId);

        if (serviceProviderEntity != null) {
            serviceProviderEntity.getAppointmentEntities().size();
            if (serviceProviderEntity.getStatusEnum().equals(StatusEnum.Blocked)) {
                throw new ServiceProviderBlockedException("Serivce Provider ID: " + serviceProviderId + " is blocked!");

            } else {
                serviceProviderEntity.getAppointmentEntities().size();
                return serviceProviderEntity;
            }

        } else {
            throw new ServiceProviderNotFoundException("Serivce Provider ID: " + serviceProviderId + " does not exists!");
        }
    }

    @Override
    public void updateServiceProvider(ServiceProviderEntity serviceProviderEntity) throws ServiceProviderBlockedException, UpdateServiceProviderException, ServiceProviderNotFoundException, InputDataValidationException, ServiceProviderNotUniqueException, UnknownPersistenceException {
        String serviceProviderEmail = serviceProviderEntity.getEmailAddress();
        Long serviceProviderId = serviceProviderEntity.getServiceProviderId();
        serviceProviderEntity.getAppointmentEntities().size();
        
        try {

            if (serviceProviderEntity != null && serviceProviderEmail != null) {

                Set<ConstraintViolation<ServiceProviderEntity>> constraintViolations = validator.validate(serviceProviderEntity);

                if (constraintViolations.isEmpty()) {
                    ServiceProviderEntity serviceProviderToUpdate = retrieveServiceProviderEntityById(serviceProviderId);

                    if (serviceProviderToUpdate.getServiceProviderId().equals(serviceProviderEntity.getServiceProviderId())) {
                        serviceProviderToUpdate.setBusinessAddress(serviceProviderEntity.getBusinessAddress());
                        serviceProviderToUpdate.setCity(serviceProviderEntity.getCity());
                        if (!serviceProviderEntity.getEmailAddress().equals(serviceProviderToUpdate.getEmailAddress()))
                        {
                            serviceProviderToUpdate.setEmailAddress(serviceProviderEntity.getEmailAddress());
                        }
                        serviceProviderToUpdate.setPassword(serviceProviderEntity.getPassword());
                        serviceProviderToUpdate.setPhoneNumber(serviceProviderEntity.getPhoneNumber());   
                        em.merge(serviceProviderToUpdate);
                        em.flush();
                    } else {
                        throw new UpdateServiceProviderException("Service Provider ID does not match records!\n");
                    }
                } else {
                    throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
                }
            } else {
                throw new ServiceProviderNotFoundException("Service Provider ID not found!\n");
            }

        } catch (PersistenceException ex) {
            if (ex.getCause() != null && ex.getCause().getClass().getName().equals("org.eclipse.persistence.exceptions.DatabaseException")) {
                if (ex.getCause().getCause() != null && ex.getCause().getCause().getClass().getName().equals("java.sql.SQLIntegrityConstraintViolationException")) {
                    throw new ServiceProviderNotUniqueException("Service Provider is not unique!\n");
                } else {
                    throw new UnknownPersistenceException(ex.getMessage());
                }
            } else {
                throw new UnknownPersistenceException(ex.getMessage());
            }
        }

    }

    @Override
    public void deleteServiceProvider(Long serivceProviderId) throws ServiceProviderNotFoundException, DeleteServiceProviderException, ServiceProviderBlockedException {
        try {
            ServiceProviderEntity serviceProvider = retrieveServiceProviderEntityById(serivceProviderId);
            if (serviceProvider.getAppointmentEntities().isEmpty())
            {
                BusinessCategoryEntity businessCategoryEntity = serviceProvider.getBusinessCategoryEntity();
                businessCategoryEntity.getServiceProviderEntities().remove(serviceProvider);
                em.remove(serviceProvider);
                em.flush();
            } else {
                throw new DeleteServiceProviderException("Service Provider ID " + serivceProviderId + " is associated with existing Appointment record(s) and cannot be deleted!");
            }
        } catch (ServiceProviderNotFoundException ex) {
            System.out.println("Service Provider Record cannot be found!");
        }
    }

    @Override
    public void approveServiceProvider(Long serviceProviderId) throws ServiceProviderNotFoundException, ServiceProviderBlockedException {
        ServiceProviderEntity serviceProvider = retrieveServiceProviderEntityById(serviceProviderId);
        serviceProvider.setStatusEnum(StatusEnum.Approved);

    }

    @Override
    public void blockServiceProvider(Long serviceProviderId) throws ServiceProviderNotFoundException, ServiceProviderBlockedException {
        ServiceProviderEntity serviceProvider = retrieveServiceProviderEntityById(serviceProviderId);
        serviceProvider.setStatusEnum(StatusEnum.Blocked);

    }

    public void registerServiceProvider(String name, int category, String businessRegNumber, String city, String phone, String addr, String email, String password) throws ServiceProviderEmailExistException, UnknownPersistenceException, InputDataValidationException {
        String businessCategory = "";

        if (category == 1) {
            businessCategory = "Health";
        } else if (category == 2) {
            businessCategory = "Fashion";
        } else {
            businessCategory = "Education";
        }

        ServiceProviderEntity newServiceProvider = new ServiceProviderEntity();
        newServiceProvider.setName(name);
        newServiceProvider.setBusinessAddress(addr);
        newServiceProvider.setBusinessCategory(businessCategory);
        newServiceProvider.setBusinessRegistrationNumber(businessRegNumber);
        newServiceProvider.setCity(city);
        newServiceProvider.setPhoneNumber(phone);
        newServiceProvider.setEmailAddress(email);
        newServiceProvider.setPassword(password);

        try {
            createNewServiceProvider(businessCategory, newServiceProvider);
        } catch (BusinessCategoryNotFoundException ex) {
            System.out.println("Business Category is not found!\n");
        } catch (ServiceProviderNotUniqueException ex) {
            System.out.println("Service Provider is not unique!\n");
        }
    }

    @Override
    public void updateRating(double newRating, Long serviceProviderId) throws ServiceProviderNotFoundException, ServiceProviderBlockedException {
        ServiceProviderEntity serviceProvider = retrieveServiceProviderEntityById(serviceProviderId);
        double currentRating = serviceProvider.getRating();
        int numberOfRatings = serviceProvider.getNumberOfRatings();
        double rating = (double) (currentRating * numberOfRatings + newRating) / (numberOfRatings + 1);
        serviceProvider.setNumberOfRatings(numberOfRatings + 1);
        serviceProvider.setRating(rating);
    }

    private String prepareInputDataValidationErrorsMessage(Set<ConstraintViolation<ServiceProviderEntity>> constraintViolations) {
        String msg = "Input data validation error!:";

        for (ConstraintViolation constraintViolation : constraintViolations) {
            msg += "\n\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage();
        }

        return msg;
    }

}
