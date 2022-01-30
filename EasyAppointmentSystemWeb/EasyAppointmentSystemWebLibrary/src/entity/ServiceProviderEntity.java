package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlTransient;
import util.enumeration.StatusEnum;


@Entity
public class ServiceProviderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceProviderId;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String name;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String businessCategory;
    
    @NotEmpty
    @Column(nullable = false, unique = true, length = 32)
    private String businessRegistrationNumber;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String city;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String businessAddress;
    
    @NotEmpty
    @Column(nullable = false, unique = true, length = 32)
    private String emailAddress;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String phoneNumber;
    
    @NotEmpty
    @Column(nullable = false, length = 32)
    private String password;
    
    @Column(nullable = false)
    private Double rating = 0.0;
    

    @Column(nullable = false)
    private int numberOfRatings;
    

    @Column(nullable = false)
    private StatusEnum statusEnum;
    
    @OneToMany(mappedBy = "serviceProviderEntity")
    private List<AppointmentEntity> appointmentEntities;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private BusinessCategoryEntity businessCategoryEntity;

    public ServiceProviderEntity() 
    {
        appointmentEntities = new ArrayList<>();
    }

    public ServiceProviderEntity(String name, String businessCategory, String businessRegistrationNumber, String city, String businessAddress, String emailAddress, String phoneNumber, String password, StatusEnum statusEnum) 
    {
        this();
        this.name = name;
        this.businessCategory = businessCategory;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.city = city;
        this.businessAddress = businessAddress;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rating = 0.0;
        this.numberOfRatings = 0;
        this.statusEnum = statusEnum;
        appointmentEntities = new ArrayList<>();
    }

    public Long getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Long serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public BusinessCategoryEntity getBusinessCategoryEntity() {
        return businessCategoryEntity;
    }

    public void setBusinessCategoryEntity(BusinessCategoryEntity businessCategoryEntity) {
        if(this.businessCategoryEntity != null)
        {
            this.businessCategoryEntity.getServiceProviderEntities().remove(this);
        }
        
        this.businessCategoryEntity = businessCategoryEntity;
        
        if(this.businessCategoryEntity != null)
        {
            if(this.businessCategoryEntity.getServiceProviderEntities() != null && !this.businessCategoryEntity.getServiceProviderEntities().contains(this))
            {
                this.businessCategoryEntity.getServiceProviderEntities().add(this);
            }
        }
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the businessCategory
     */
    @XmlTransient
    public String getBusinessCategory() {
        return businessCategory;
    }

    /**
     * @param businessCategory the businessCategory to set
     */
    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    /**
     * @return the businessRegistrationNumber
     */
    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    /**
     * @param businessRegistrationNumber the businessRegistrationNumber to set
     */
    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * @param businessAddress the businessAddress to set
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<AppointmentEntity> getAppointmentEntities() {
        return appointmentEntities;
    }

    public void setAppointmentEntities(List<AppointmentEntity> appointmentEntities) {
        this.appointmentEntities = appointmentEntities;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
    
    

    
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the serviceProviderId fields are not set
        if (!(object instanceof ServiceProviderEntity)) {
            return false;
        }
        ServiceProviderEntity other = (ServiceProviderEntity) object;
        if ((this.serviceProviderId == null && other.serviceProviderId != null) || (this.serviceProviderId != null && !this.serviceProviderId.equals(other.serviceProviderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ServiceProviderEntity[ id=" + serviceProviderId + " ]";
    }

    /**
     * @return the numberOfRatings
     */
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    /**
     * @param numberOfRatings the numberOfRatings to set
     */
    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }
    
}
