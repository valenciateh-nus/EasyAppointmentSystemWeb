
package ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for emailCheckoutNotificationSync complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="emailCheckoutNotificationSync">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appointmentEntity" type="{http://ws.session.ejb/}appointmentEntity" minOccurs="0"/>
 *         &lt;element name="fromEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "emailCheckoutNotificationSync", propOrder = {
    "email",
    "password",
    "appointmentEntity",
    "fromEmailAddress",
    "toEmailAddress"
})
public class EmailCheckoutNotificationSync {

    protected String email;
    protected String password;
    protected AppointmentEntity appointmentEntity;
    protected String fromEmailAddress;
    protected String toEmailAddress;

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
     * Gets the value of the appointmentEntity property.
     * 
     * @return
     *     possible object is
     *     {@link AppointmentEntity }
     *     
     */
    public AppointmentEntity getAppointmentEntity() {
        return appointmentEntity;
    }

    /**
     * Sets the value of the appointmentEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppointmentEntity }
     *     
     */
    public void setAppointmentEntity(AppointmentEntity value) {
        this.appointmentEntity = value;
    }

    /**
     * Gets the value of the fromEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromEmailAddress() {
        return fromEmailAddress;
    }

    /**
     * Sets the value of the fromEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromEmailAddress(String value) {
        this.fromEmailAddress = value;
    }

    /**
     * Gets the value of the toEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToEmailAddress() {
        return toEmailAddress;
    }

    /**
     * Sets the value of the toEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToEmailAddress(String value) {
        this.toEmailAddress = value;
    }

}
