package com.somallg.jax.ws.beans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.somallg.jax.ws.beans package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReverseStringReq_QNAME = new QName("http://www.somallg.com/stringprocessor", "reverseStringReq");
    private final static QName _ReverseStringResp_QNAME = new QName("http://www.somallg.com/stringprocessor", "reverseStringResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.somallg.jax.ws.beans
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReverseStringReq }
     */
    public ReverseStringReq createReverseStringReq() {
        return new ReverseStringReq();
    }

    /**
     * Create an instance of {@link ReverseStringResp }
     */
    public ReverseStringResp createReverseStringResp() {
        return new ReverseStringResp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseStringReq }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.somallg.com/stringprocessor", name = "reverseStringReq")
    public JAXBElement<ReverseStringReq> createReverseStringReq(ReverseStringReq value) {
        return new JAXBElement<ReverseStringReq>(_ReverseStringReq_QNAME, ReverseStringReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReverseStringResp }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.somallg.com/stringprocessor", name = "reverseStringResp")
    public JAXBElement<ReverseStringResp> createReverseStringResp(ReverseStringResp value) {
        return new JAXBElement<ReverseStringResp>(_ReverseStringResp_QNAME, ReverseStringResp.class, null, value);
    }

}
