
package ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for appointmentEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="appointmentEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appointmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="appointmentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="businessCategoryEntity" type="{http://ws.session.ejb/}businessCategoryEntity" minOccurs="0"/>
 *         &lt;element name="hasRating" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="scheduledDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scheduledTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointmentEntity", propOrder = {
    "appointmentId",
    "appointmentNo",
    "businessCategoryEntity",
    "hasRating",
    "scheduledDate",
    "scheduledTime"
})
public class AppointmentEntity {

    protected Long appointmentId;
    protected String appointmentNo;
    protected BusinessCategoryEntity businessCategoryEntity;
    protected Boolean hasRating;
    protected String scheduledDate;
    protected String scheduledTime;

    /**
     * Gets the value of the appointmentId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAppointmentId() {
        return appointmentId;
    }

    /**
     * Sets the value of the appointmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAppointmentId(Long value) {
        this.appointmentId = value;
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

    /**
     * Gets the value of the hasRating property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRating() {
        return hasRating;
    }

    /**
     * Sets the value of the hasRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRating(Boolean value) {
        this.hasRating = value;
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

}
