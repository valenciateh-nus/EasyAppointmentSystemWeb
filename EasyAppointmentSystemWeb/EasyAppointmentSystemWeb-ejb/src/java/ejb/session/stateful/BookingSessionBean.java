package ejb.session.stateful;

import ejb.session.stateless.AppointmentEntitySessionBeanLocal;
import entity.AppointmentEntity;
import entity.BusinessCategoryEntity;
import entity.CustomerEntity;
import entity.ServiceProviderEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import util.exception.AppointmentNumberExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;


@Stateful
@Local(BookingSessionBeanLocal.class)
@Remote(BookingSessionBeanRemote.class)
public class BookingSessionBean implements BookingSessionBeanRemote, BookingSessionBeanLocal 
{

    @EJB
    private AppointmentEntitySessionBeanLocal appointmentEntitySessionBeanLocal;
    
    private String appointmentNo;
    private String scheduledTime;
    private String scheduledDate;
    private CustomerEntity customerEntity;
    private ServiceProviderEntity serviceProviderEntity;
    private BusinessCategoryEntity businessCategoryEntity;
      
    
    public BookingSessionBean() 
    {
        initialiseState();
    }
    
    @Override
    public void addAppointment(String appointmentNo, String scheduledTime, String scheduledDate, CustomerEntity customerEntity, ServiceProviderEntity serviceProviderEntity, BusinessCategoryEntity businessCategoryEntity)
    {
        this.appointmentNo = appointmentNo;
        this.scheduledTime = scheduledTime;
        this.scheduledDate = scheduledDate;
        this.customerEntity = customerEntity;
        this.serviceProviderEntity = serviceProviderEntity;
        this.businessCategoryEntity = businessCategoryEntity;
    }
    
    @Remove
    public void remove()
    {        
    }
    
    
    
    private void initialiseState()
    {
        this.appointmentNo = "";
        this.scheduledTime = "";
        this.scheduledDate = "";
        this.customerEntity = new CustomerEntity();
        this.serviceProviderEntity = new ServiceProviderEntity();
        this.businessCategoryEntity = new BusinessCategoryEntity();
    }
    
    @Override
    public Long doBooking(Long customerId, Long serviceProviderId) throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, CustomerNotFoundException, ServiceProviderNotFoundException, ServiceProviderBlockedException
    {
        AppointmentEntity newAppointmentEntity = new AppointmentEntity();
        newAppointmentEntity.setAppointmentNo(this.appointmentNo);
        newAppointmentEntity.setScheduledTime(this.scheduledTime);
        newAppointmentEntity.setScheduledDate(this.scheduledDate);
        newAppointmentEntity.setCustomerEntity(this.customerEntity);
        newAppointmentEntity.setServiceProviderEntity(this.serviceProviderEntity);
        newAppointmentEntity.setBusinessCategoryEntity(this.businessCategoryEntity);                                  
        
        Long newAppointmentEntityId = appointmentEntitySessionBeanLocal.createNewAppointment(customerId, serviceProviderId, newAppointmentEntity);
        initialiseState();
        return newAppointmentEntityId;
    }
    
    @Override
    public void clearAppointmentCart()
    {
        initialiseState();
    }

    @Override
    public String getAppointmentNo() {
        return appointmentNo;
    }

    @Override
    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    @Override
    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) 
    {
        LocalTime time = LocalTime.parse(scheduledTime.toString(), DateTimeFormatter.ofPattern("HH:mm"));
        this.scheduledTime = time.toString();
    }

    @Override
    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(scheduledDate, formatter);
        this.scheduledDate = date.toString();
    }

    @Override
    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    @Override
    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public ServiceProviderEntity getServiceProviderEntity() {
        return serviceProviderEntity;
    }

    @Override
    public void setServiceProviderEntity(ServiceProviderEntity serviceProviderEntity) {
        this.serviceProviderEntity = serviceProviderEntity;
    }

    @Override
    public BusinessCategoryEntity getBusinessCategoryEntity() {
        return businessCategoryEntity;
    }

    @Override
    public void setBusinessCategoryEntity(BusinessCategoryEntity businessCategoryEntity) {
        this.businessCategoryEntity = businessCategoryEntity;
    }
}
