package ejb.session.stateless;

import entity.AppointmentEntity;
import entity.CustomerEntity;
import entity.ServiceProviderEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;
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
import util.exception.AppointmentNotFoundException;
import util.exception.AppointmentNumberExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InputInvalidValuesException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;

@Stateless
@Local(ejb.session.stateless.AppointmentEntitySessionBeanLocal.class)
@Remote(ejb.session.stateless.AppointmentEntitySessionBeanRemote.class)
public class AppointmentEntitySessionBean implements AppointmentEntitySessionBeanRemote, AppointmentEntitySessionBeanLocal {

    @EJB
    private CustomerEntitySessionBeanLocal customerEntitySessionBeanLocal;
    @EJB
    private ServiceProviderEntitySessionBeanLocal serviceProviderEntitySessionBeanLocal;

    @PersistenceContext(unitName = "EasyAppointmentSystemWeb-ejbPU")
    private EntityManager em;
    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    public AppointmentEntitySessionBean() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Override
    public Long createNewAppointment(Long customerId, Long serviceProviderId, AppointmentEntity newAppointmentEntity) throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException {
        try {
            Set<ConstraintViolation<AppointmentEntity>> constraintViolations = validator.validate(newAppointmentEntity);

            if (constraintViolations.isEmpty()) {
                CustomerEntity customerEntity = customerEntitySessionBeanLocal.retrieveCustomerEntityByCustomerId(customerId);
                ServiceProviderEntity serviceProviderEntity = serviceProviderEntitySessionBeanLocal.retrieveServiceProviderEntityById(serviceProviderId);
                newAppointmentEntity.setCustomerEntity(customerEntity);
                newAppointmentEntity.setServiceProviderEntity(serviceProviderEntity);
                customerEntity.getAppointmentEntities().add(newAppointmentEntity);
                serviceProviderEntity.getAppointmentEntities().add(newAppointmentEntity);

                em.persist(newAppointmentEntity);
                em.flush();

                return newAppointmentEntity.getAppointmentId();
            } else {
                throw new InputDataValidationException(prepareInputDataValidationErrorsMessage(constraintViolations));
            }
        } catch (PersistenceException ex) {
            if (ex.getCause() != null && ex.getCause().getClass().getName().equals("org.eclipse.persistence.exceptions.DatabaseException")) {
                if (ex.getCause().getCause() != null && ex.getCause().getCause().getClass().getName().equals("java.sql.SQLIntegrityConstraintViolationException")) {
                    throw new AppointmentNumberExistsException();
                } else {
                    throw new UnknownPersistenceException(ex.getMessage());
                }
            } else {
                throw new UnknownPersistenceException(ex.getMessage());
            }
        }
    }

    @Override
    public AppointmentEntity retrieveAppointmentByCustomerID(Long customerID) throws AppointmentNotFoundException {

        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.customerID = :inCustomerID");
        query.setParameter("inCustomerID", customerID);

        try {
            AppointmentEntity appointment = (AppointmentEntity) query.getSingleResult();
            appointment.getCustomerEntity();
            appointment.getBusinessCategoryEntity();
            appointment.getServiceProviderEntity();
            return appointment;

        } catch (NoResultException | NonUniqueResultException ex) {
            throw new AppointmentNotFoundException("Appointment of customer " + customerID + " does not exist!");
        }
    }

    @Override
    public AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws AppointmentNotFoundException {

        AppointmentEntity appointmentEntity = em.find(AppointmentEntity.class, appointmentId);

        if (appointmentEntity != null) {
            appointmentEntity.getCustomerEntity();
            appointmentEntity.getBusinessCategoryEntity();
            appointmentEntity.getServiceProviderEntity();
            return appointmentEntity;
        } else {
            throw new AppointmentNotFoundException("Appointment Id: " + appointmentId + " does not exist!");
        }
    }

    @Override
    public AppointmentEntity retrieveAppointmentByAppointmentNumber(String appointmentNo) throws AppointmentNotFoundException {

        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.appointmentNo = :inAppointmentNo");
        query.setParameter("inAppointmentNo", appointmentNo);

        try {
            AppointmentEntity appointmentEntity = (AppointmentEntity) query.getSingleResult();
            appointmentEntity.getCustomerEntity();
            appointmentEntity.getBusinessCategoryEntity();
            appointmentEntity.getServiceProviderEntity();
            return appointmentEntity;
        } catch (NoResultException | NonUniqueResultException ex) {
            throw new AppointmentNotFoundException("Appointment number: " + appointmentNo + " does not exist!");
        }
    }

    @Override
    public List<AppointmentEntity> retrieveAppointmentsByDate(String date, String serviceProviderName) throws AppointmentNotFoundException {
        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.scheduledDate = :inDate and a.serviceProviderEntity.name = :inServiceProviderName");
        query.setParameter("inDate", date);
        query.setParameter("inServiceProviderName", serviceProviderName);

        List<AppointmentEntity> apptList = query.getResultList();
        for (AppointmentEntity a : apptList) {
            a.getCustomerEntity();
            a.getBusinessCategoryEntity();
            a.getServiceProviderEntity();
        }
        return apptList;
    }

    @Override
    public List<AppointmentEntity> retrieveAppointmentsByCustomerEntityId(Long customerId) throws AppointmentNotFoundException {
        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.customerEntity.customerId = :inCustomerId");
        query.setParameter("inCustomerId", customerId);

        List<AppointmentEntity> apptList = query.getResultList();
        for (AppointmentEntity a : apptList) {
            a.getCustomerEntity();
            a.getBusinessCategoryEntity();
            a.getServiceProviderEntity();
        }
        return apptList;
    }

    @Override
    public List<AppointmentEntity> retrieveSortedAppointmentsByDate(String date, Long serviceProviderId) throws AppointmentNotFoundException {

        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.scheduledDate = :inCurrDate and a.serviceProviderEntity.serviceProviderId = :inServiceProviderId ORDER BY a.scheduledTime");
        query.setParameter("inCurrDate", date);
        query.setParameter("inServiceProviderId", serviceProviderId);

        List<AppointmentEntity> apptList = query.getResultList();
        for (AppointmentEntity a : apptList) {
            a.getCustomerEntity();
            a.getBusinessCategoryEntity();
            a.getServiceProviderEntity();
        }
        return apptList;
    }

    @Override
    public List<AppointmentEntity> retrieveAppointmentsByServiceProviderId(Long serviceProviderId) throws AppointmentNotFoundException {
        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.serviceProviderEntity.serviceProviderId = :inServiceProviderId ORDER BY a.scheduledDate");
        query.setParameter("inServiceProviderId", serviceProviderId);

        List<AppointmentEntity> apptList = query.getResultList();
        for (AppointmentEntity a : apptList) {
            a.getCustomerEntity();
            a.getBusinessCategoryEntity();
            a.getServiceProviderEntity();
        }
        return apptList;
    }

    @Override
    public List<AppointmentEntity> retrieveAppointmentByCustomer(Long customerId, Long serviceProviderId) throws AppointmentNotFoundException {
        Query query = em.createQuery("SELECT a FROM AppointmentEntity a WHERE a.customerEntity.customerId = :inCustomerId and a.serviceProviderEntity.serviceProviderId = :inServiceProviderId ORDER BY a.scheduledDate");
        query.setParameter("inCustomerId", customerId);
        query.setParameter("inServiceProviderId", serviceProviderId);

        List<AppointmentEntity> apptList = query.getResultList();
        for (AppointmentEntity a : apptList) {
            a.getCustomerEntity();
            a.getBusinessCategoryEntity();
            a.getServiceProviderEntity();
        }
        return apptList;
    }

    @Override
    public void deleteAppointment(String appointmentNo) throws AppointmentNotFoundException {

        AppointmentEntity appointmentEntity = retrieveAppointmentByAppointmentNumber(appointmentNo);

        em.remove(appointmentEntity);
        CustomerEntity customerEntity = appointmentEntity.getCustomerEntity();
        ServiceProviderEntity serviceProviderEntity = appointmentEntity.getServiceProviderEntity();
        serviceProviderEntity.getAppointmentEntities().remove(appointmentEntity);
        customerEntity.getAppointmentEntities().remove(appointmentEntity);
        em.flush();
        // are there any exception cases?
    }

    @Override
    public void updateAppointmentEntityRating(Long appointmentId) throws AppointmentNotFoundException {
        AppointmentEntity appt = retrieveAppointmentByAppointmentId(appointmentId);
        appt.setHasRating(Boolean.TRUE);
    }

//    @Override
//    public void cancelAppointment(String appointmentNo) throws AppointmentNotFoundException
//    {
//
//        AppointmentEntity appointmentEntity = retrieveAppointmentByAppointmentNumber(appointmentNo);
//        appointmentEntity.setIsCancelled(Boolean.TRUE);
//        appointmentEntity.getCustomerEntity().getAppointmentEntities().size();
//        appointmentEntity.getServiceProviderEntity().getAppointmentEntities().size();
//        em.merge(appointmentEntity);
//        em.flush();
//    }
    private String prepareInputDataValidationErrorsMessage(Set<ConstraintViolation<AppointmentEntity>> constraintViolations) {
        String msg = "Input data validation error!:";

        for (ConstraintViolation constraintViolation : constraintViolations) {
            msg += "\n\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage();
        }

        return msg;
    }

    @Override
    public void updateAppointmentEntity(AppointmentEntity appointmentEntity) {
        em.merge(appointmentEntity);
    }

    @Override
    public LocalDate convertDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currDate = LocalDate.parse(date, formatter);

        return currDate;

    }

    @Override
    public LocalTime convertTime(String time) throws InputInvalidValuesException{
        
        try 
        {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime currTime = LocalTime.parse(time, fmt);
            return currTime;
        } catch (DateTimeParseException ex) {
            throw new InputInvalidValuesException("Please input a correct date in the format yyyy-mm-dd");
        }
    }

    @Override
    public boolean ifAppointmentCanCancel(String appointmentNo) throws InputInvalidValuesException, AppointmentNotFoundException {

        try {
            String date = retrieveAppointmentByAppointmentNumber(appointmentNo).getScheduledDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate appointmentDate = LocalDate.parse(date, formatter);
            LocalDate todayDate = LocalDate.now();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            String currentTime = LocalTime.now().format(fmt);
            LocalTime todayTime = LocalTime.parse(currentTime, fmt);

            String time = retrieveAppointmentByAppointmentNumber(appointmentNo).getScheduledTime();
            LocalTime appointmentTime = LocalTime.parse(time, fmt);

            int comparison = appointmentDate.compareTo(todayDate);
            int compare = appointmentTime.compareTo(todayTime);

            if (comparison >= 1) {
                int apptYear = appointmentDate.getYear();
                int currYear = todayDate.getYear();
                int apptMonth = appointmentDate.getMonthValue();
                int currMonth = todayDate.getMonthValue();
                int apptDay = appointmentDate.getDayOfMonth();
                int currDay = todayDate.getDayOfMonth();

                if (apptYear > currYear || apptMonth > currMonth || apptDay - currDay > 1) {
                    AppointmentEntity toCancelAppointmentEntity = retrieveAppointmentByAppointmentNumber(appointmentNo);
                    deleteAppointment(appointmentNo);
                    return true;
                } else if (apptDay - currDay == 1) {
                    if (compare >= 0) {
                        AppointmentEntity toCancelAppointmentEntity = retrieveAppointmentByAppointmentNumber(appointmentNo);
                        deleteAppointment(appointmentNo);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {

                return false;

            }
        } catch (DateTimeParseException ex) {
            throw new InputInvalidValuesException("Please input a correct date in the format yyyy-mm-dd");
        } 

    }

    @Override
    public String calculateDayOfTheWeek(String givenDate) throws InputInvalidValuesException {
        try
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate currDate = LocalDate.parse(givenDate, formatter);

            String day = currDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
            return day;
        } catch (DateTimeParseException ex) {
            throw new InputInvalidValuesException("Please input a correct date in the format yyyy-mm-dd");
        }
    }

    @Override
    public boolean ifAppointmentCanAdd(String givenTime, String givenDate) throws InputInvalidValuesException {

        try
        {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(givenTime, fmt);

            // check whether at least 2 hours before appointment first
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String currDate = LocalDate.now().toString();
            LocalDate todayDate = LocalDate.parse(currDate, formatter);
            LocalDate appointmentDate = LocalDate.parse(givenDate, formatter);  //date of appointment to be scheduled

            String currentTime = LocalTime.now().format(fmt);
            LocalTime todayTime = LocalTime.parse(currentTime, fmt);
            LocalTime appointmentTime = time; //what they have inputted

            int comparison = appointmentDate.compareTo(todayDate);
            int compare = appointmentTime.compareTo(todayTime);

            if (comparison == 0) {
                if (compare < 2) {
                    return false;
                }
            }

            if (comparison < 0) {
                System.out.println("Appointment cannot be made!\n");
                return false;
            }

            return true;
        } catch (DateTimeParseException ex) {
            throw new InputInvalidValuesException("Please input a correct date and/or time in the format yyyy-mm-dd and HH:mm!");
        }
    }

    @Override
    public Long ifCanRate(List<AppointmentEntity> apptList, Long serviceProviderId) {
        Long ratedApptId = 0l;
        
        for (AppointmentEntity a : apptList)
                {
                    String date = a.getScheduledDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate appointmentDate = LocalDate.parse(date, formatter);
            
                    String time = a.getScheduledTime();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime appointmentTime = LocalTime.parse(time, fmt);
                    
                    if (appointmentDate.compareTo(LocalDate.now()) <= 0) 
                    {
                        if (appointmentTime.compareTo(LocalTime.now()) <= 0)
                        {
                            if (a.getHasRating() == false && a.getServiceProviderEntity().getServiceProviderId().equals(serviceProviderId))
                            {
                                ratedApptId = a.getAppointmentId();
                                break;
                            }
                        }
                    }
                }
        return ratedApptId;

    }

    @Override
    public String getLocalTimeInString(LocalTime time) {
        return time.toString();
    }

    @Override
    public String findFirstAvailableTime(List<AppointmentEntity> apptList, List<String> timeSlots) {
        for (AppointmentEntity appointment : apptList) {
            if (timeSlots.contains(appointment.getScheduledTime().toString())) {
                timeSlots.remove(appointment.getScheduledTime().toString());
            }
        }

        String firstAvailableTime = timeSlots.get(0);

        return firstAvailableTime;
    }

    @Override
    public List<String> findAvailableTimeSlot(List<AppointmentEntity> appointmentEntities, List<String> timeslots2) 
    {  
        int index = 0;
        
        for (AppointmentEntity a : appointmentEntities) {
            String scheduledTime = a.getScheduledTime().toString();
            if (timeslots2.contains(scheduledTime) && !timeslots2.isEmpty()) {
                index = timeslots2.indexOf(scheduledTime);
                timeslots2.remove(index);
            }
        }
        
        return timeslots2;
    }
    
    @Override
    public boolean ifDateHasNotPassed(String date) throws InputInvalidValuesException
    {
        try 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate appointmentDate = LocalDate.parse(date, formatter);
            return LocalDate.now().isBefore(appointmentDate);
        } catch (DateTimeParseException ex) {
            throw new InputInvalidValuesException("Please input a correct date in the format yyyy-mm-dd");
        }
    }

}
