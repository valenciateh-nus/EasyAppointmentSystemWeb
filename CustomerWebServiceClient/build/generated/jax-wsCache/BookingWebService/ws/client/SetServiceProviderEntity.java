
package ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setServiceProviderEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setServiceProviderEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceProviderEntity" type="{http://ws.session.ejb/}serviceProviderEntity" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setServiceProviderEntity", propOrder = {
    "email",
    "password",
    "serviceProviderEntity"
})
public class SetServiceProviderEntity {

    protected String email;
    protected String password;
    protected ServiceProviderEntity serviceProviderEntity;

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

}
