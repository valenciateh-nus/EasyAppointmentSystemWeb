
package ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addAppointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addAppointment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appointmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduledTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduledDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerEntity" type="{http://ws.session.ejb/}customerEntity" minOccurs="0"/>
 *         &lt;element name="serviceProviderEntity" type="{http://ws.session.ejb/}serviceProviderEntity" minOccurs="0"/>
 *         &lt;element name="businessCategoryEntity" type="{http://ws.session.ejb/}businessCategoryEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAppointment", propOrder = {
    "email",
    "password",
    "appointmentNo",
    "scheduledTime",
    "scheduledDate",
    "customerEntity",
    "serviceProviderEntity",
    "businessCategoryEntity"
})
public class AddAppointment {

    protected String email;
    protected String password;
    protected String appointmentNo;
    protected String scheduledTime;
    protected String scheduledDate;
    protected CustomerEntity customerEntity;
    protected ServiceProviderEntity serviceProviderEntity;
    protected BusinessCategoryEntity businessCategoryEntity;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the appointmentNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppointmentNo() {
        return appointmentNo;
    }

    /**
     * Sets the value of the appointmentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppointmentNo(String value) {
        this.appointmentNo = value;
    }

    /**
     * Gets the value of the scheduledTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledTime() {
        return scheduledTime;
    }

    /**
     * Sets the value of the scheduledTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledTime(String value) {
        this.scheduledTime = value;
    }

    /**
     * Gets the value of the scheduledDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledDate() {
        return scheduledDate;
    }

    /**
     * Sets the value of the scheduledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledDate(String value) {
        this.scheduledDate = value;
    }

    /**
     * Gets the value of the customerEntity property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerEntity }
     *     
     */
    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    /**
     * Sets the value of the customerEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerEntity }
     *     
     */
    public void setCustomerEntity(CustomerEntity value) {
        this.customerEntity = value;
    }

    /**
     * Gets the value of the serviceProviderEntity property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceProviderEntity }
     *     
     */
    public ServiceProviderEntity getServiceProviderEntity() {
        return serviceProviderEntity;
    }

    /**
     * Sets the value of the serviceProviderEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceProviderEntity }
     *     
     */
    public void setServiceProviderEntity(ServiceProviderEntity value) {
        this.serviceProviderEntity = value;
    }

    /**
     * Gets the value of the businessCategoryEntity property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessCategoryEntity }
     *     
     */
    public BusinessCategoryEntity getBusinessCategoryEntity() {
        return businessCategoryEntity;
    }

    /**
     * Sets the value of the businessCategoryEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessCategoryEntity }
     *     
     */
    public void setBusinessCategoryEntity(BusinessCategoryEntity value) {
        this.businessCategoryEntity = value;
    }

}
