package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class AppointmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    
    @Column(nullable = false, length = 32)
    private String appointmentNo;
    
    @Column(nullable = false)
    private String scheduledTime;
    
    @Column(nullable = false)
    private String scheduledDate;
    
    @Column(nullable = false)
    private Boolean hasRating = Boolean.FALSE;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private CustomerEntity customerEntity;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private ServiceProviderEntity serviceProviderEntity;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private BusinessCategoryEntity businessCategoryEntity;
    
    public AppointmentEntity() 
    {
    }

    public AppointmentEntity(String appointmentNo, String scheduledTime, String scheduledDate) {
        //LocalTime time = LocalTime.parse(scheduledTime.toString(), DateTimeFormatter.ofPattern("HH:mm"));
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
        this.appointmentNo = appointmentNo;
    }

    public AppointmentEntity(String appointmentNo, String scheduledTime, String scheduledDate, CustomerEntity customerEntity, ServiceProviderEntity serviceProviderEntity, BusinessCategoryEntity businessCategoryEntity) {
        this.appointmentNo = appointmentNo;
        this.scheduledTime = scheduledTime;
        this.scheduledDate = scheduledDate;
        this.customerEntity = customerEntity;
        this.serviceProviderEntity = serviceProviderEntity;
        this.businessCategoryEntity = businessCategoryEntity;
    }
    
    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) 
    {
        LocalTime time = LocalTime.parse(scheduledTime.toString(), DateTimeFormatter.ofPattern("HH:mm"));
        this.scheduledTime = time.toString();
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(scheduledDate, formatter);
        this.scheduledDate = date.toString();
    }

    @XmlTransient
    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
         if(this.customerEntity != null)
        {
            this.customerEntity.getAppointmentEntities().remove(this);
        }
        
        this.customerEntity = customerEntity;
        
        if(this.customerEntity != null)
        {
            if(!this.customerEntity.getAppointmentEntities().contains(this))
            {
                this.customerEntity.getAppointmentEntities().add(this);
            }
        }
    }

    @XmlTransient
    public ServiceProviderEntity getServiceProviderEntity() {
        return serviceProviderEntity;
    }

    public void setServiceProviderEntity(ServiceProviderEntity serviceProviderEntity) {
        if(this.serviceProviderEntity != null)
        {
            this.serviceProviderEntity.getAppointmentEntities().remove(this);
        }
        
        this.serviceProviderEntity = serviceProviderEntity;
        
        if(this.serviceProviderEntity != null)
        {
            if(!this.serviceProviderEntity.getAppointmentEntities().contains(this))
            {
                this.serviceProviderEntity.getAppointmentEntities().add(this);
            }
        }
    }

    public BusinessCategoryEntity getBusinessCategoryEntity() {
        return businessCategoryEntity;
    }

    public void setBusinessCategoryEntity(BusinessCategoryEntity businessCategoryEntity) {
        this.businessCategoryEntity = businessCategoryEntity;
    }

    public String getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentId != null ? appointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the appointmentId fields are not set
        if (!(object instanceof AppointmentEntity)) {
            return false;
        }
        AppointmentEntity other = (AppointmentEntity) object;
        if ((this.appointmentId == null && other.appointmentId != null) || (this.appointmentId != null && !this.appointmentId.equals(other.appointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AppointmentEntity[ id=" + appointmentId + " ]";
    }

    /**
     * @return the hasRating
     */
    public Boolean getHasRating() {
        return hasRating;
    }

    /**
     * @param hasRating the hasRating to set
     */
    public void setHasRating(Boolean hasRating) {
        this.hasRating = hasRating;
    }


}
