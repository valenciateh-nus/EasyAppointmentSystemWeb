package ejb.session.stateless;

import entity.AppointmentEntity;
import entity.ServiceProviderEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.ejb.Local;
import util.exception.AppointmentNotFoundException;
import util.exception.AppointmentNumberExistsException;
import util.exception.BusinessCategoryNotFoundException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InputInvalidValuesException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderEmailExistException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;


public interface AppointmentEntitySessionBeanLocal {

    public Long createNewAppointment(Long customerId, Long serviceProviderId, AppointmentEntity newAppointmentEntity) throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException;
    
    public AppointmentEntity retrieveAppointmentByCustomerID(Long customerID) throws AppointmentNotFoundException;

    public AppointmentEntity retrieveAppointmentByAppointmentId(Long appointmentId) throws AppointmentNotFoundException;

    public AppointmentEntity retrieveAppointmentByAppointmentNumber(String appointmentNo) throws AppointmentNotFoundException;

    public List<AppointmentEntity> retrieveAppointmentsByDate(String date, String serviceProviderName) throws AppointmentNotFoundException ;

    public List<AppointmentEntity> retrieveSortedAppointmentsByDate(String date, Long serviceProviderId) throws AppointmentNotFoundException ;

    public void deleteAppointment(String appointmentNo) throws AppointmentNotFoundException;

    public void updateAppointmentEntity(AppointmentEntity appointmentEntity);

    public List<AppointmentEntity> retrieveAppointmentByCustomer(Long customerId, Long serviceProviderId) throws AppointmentNotFoundException ;

    public List<AppointmentEntity> retrieveAppointmentsByServiceProviderId(Long serviceProviderId) throws AppointmentNotFoundException ;

    public List<AppointmentEntity> retrieveAppointmentsByCustomerEntityId(Long customerId) throws AppointmentNotFoundException ;

    public void updateAppointmentEntityRating(Long appointmentId) throws AppointmentNotFoundException;

    public LocalDate convertDate(String date);

    public boolean ifAppointmentCanCancel(String appointmentNo) throws AppointmentNotFoundException, InputInvalidValuesException;

    public String calculateDayOfTheWeek(String givenDate) throws InputInvalidValuesException;

    public LocalTime convertTime(String time) throws InputInvalidValuesException;

    public boolean ifAppointmentCanAdd(String givenTime, String givenDate) throws InputInvalidValuesException;

    public Long ifCanRate(List<AppointmentEntity> apptList, Long serviceProviderId);

    public String getLocalTimeInString(LocalTime time);

    public String findFirstAvailableTime(List<AppointmentEntity> apptList, List<String> timeSlots);

    public List<String> findAvailableTimeSlot(List<AppointmentEntity> appointmentEntities, List<String> timeslots2);

    public boolean ifDateHasNotPassed(String date) throws InputInvalidValuesException;
    
}
