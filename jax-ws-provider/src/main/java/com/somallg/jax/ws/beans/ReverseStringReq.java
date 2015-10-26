package com.somallg.jax.ws.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reverseStringReq complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="reverseStringReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reverseStringReq", namespace = "http://www.somallg.com/stringprocessor", propOrder = {
        "inString"
})
public class ReverseStringReq {

    @XmlElement(required = true)
    protected String inString;

    /**
     * Gets the value of the inString property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInString() {
        return inString;
    }

    /**
     * Sets the value of the inString property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInString(String value) {
        this.inString = value;
    }

}
