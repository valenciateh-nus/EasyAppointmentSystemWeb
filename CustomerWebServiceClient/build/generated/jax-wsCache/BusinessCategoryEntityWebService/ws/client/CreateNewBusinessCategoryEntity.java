
package ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createNewBusinessCategoryEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createNewBusinessCategoryEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "createNewBusinessCategoryEntity", propOrder = {
    "email",
    "password",
    "businessCategoryEntity"
})
public class CreateNewBusinessCategoryEntity {

    protected String email;
    protected String password;
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
