package ejb.session.stateful;

import entity.AppointmentEntity;
import entity.BusinessCategoryEntity;
import entity.CustomerEntity;
import entity.ServiceProviderEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import util.exception.AppointmentNumberExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;


public interface BookingSessionBeanLocal {
    
    public Long doBooking(Long customerId, Long serviceProviderId) throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException;

    public void clearAppointmentCart();

    public String getAppointmentNo();

    public void setAppointmentNo(String appointmentNo);

    public String getScheduledTime();

    public void setScheduledTime(String scheduledTime);

    public String getScheduledDate();

    public void setScheduledDate(String scheduledDate);

    public CustomerEntity getCustomerEntity();

    public void setCustomerEntity(CustomerEntity customerEntity);

    public ServiceProviderEntity getServiceProviderEntity();

    public void setServiceProviderEntity(ServiceProviderEntity serviceProviderEntity);

    public BusinessCategoryEntity getBusinessCategoryEntity();

    public void setBusinessCategoryEntity(BusinessCategoryEntity businessCategoryEntity);

    public void addAppointment(String appointmentNo, String scheduledTime, String scheduledDate, CustomerEntity customerEntity, ServiceProviderEntity serviceProviderEntity, BusinessCategoryEntity businessCategoryEntity);
    
    
}
