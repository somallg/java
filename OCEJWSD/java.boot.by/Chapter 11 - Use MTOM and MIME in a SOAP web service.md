# Chapter 11 - Use MTOM and MIME in a SOAP web service

## 11.1 Use MTOM on the service

### 11.1. Use @MTOM annotation with a web service
* **javax.xml.ws.soap.MTOM*

* With Java API for XML-Based Web Services (JAX-WS), you can send binary attachments such as images or files along with web services requests
* JAX-WS adds support for optimized transmission of binary data as specifed by the SOAP Message Transmission Optimization Mechanism (MTOM) specification

* JAX-WS supports the use of SOAP Message Transmission Optmized Mechanism (MTOM) for sending binary attachment data
* By enabling MTOM, you can sed and receive binary data optimally withtou incurring the cost of data encoding needed to embed the binary data in an XML document

* JAX-WS applications can send binary data as base64 or hexBinary encoded data contained within the XML document
* However, to take adavantage of the optimizations provided by MTOM, enable MTOM to send binary base64 data as attachments contained outside the XML document
* MTOM optmization is not enabled by default
* JAX-WS applications require separate configuration of both the client ahdn the server artifacts to enable MTOM support
* For the server, you can enable MTOM on a JavaBean endpoint only and not on endpoints that implement the *javax.xml.ws.Provider* interface

* To enable MTOM on an endpoint, use the @MTOM annotation on the endpont
* The @MTOM annotation has two parmeters: *enabled* and *threshold*

* Additionally, you can use the *@BindingType* (javax.xml.ws.BindingType) annotation on a server endpoint implementation class to specify that the endpoint suports one of the MTOM binding types so that the response messages are MTOM-enabled

### 11.1.2 Use MTOM policy in WSDL
* MTOM is used to optimize the transmission of SOAP message over the wire
* MTOM uses a wire format of a SOAP message by selectively encoding portions of the message, while still presenting an XML Infoset to the SOAP application
* Optimization is available only for element content that is in a canonical lexical representation of the *xs:base64Binary* data type

* The binary attachment is packaged in a MIME multi-part message
* An *xop:Include* element is used to mark where the binary data is
* The actual binary data is kept in a diffrent MIME part

* If binary data is sent as inlined, then the runtime has to encode the data to *xs:base64Binary*, which bloats the data by 33%, MTOM is efficient, in the sense that it doesn't have the 33% size increate penalty that *xs:base64Binary* has
* It is interoperable, in the sense that it is a W3C standard
* However, MIME multipart incurs a small cost proportional to the nubmer of attachments, so it is not suitable for a large number of tiny attachments
* One can control the behavior of the runtime by using the MTOM threshold provided by the JAX-WS RI, if an attachment is smaller than the size specified in threshold, it will simply inline the binary data as BASE64 binary instead of making it an attachment

### 11.1.3 Use MTOM in the deployment descriptors
* You can enable MTOM on server by using the *enable-mtom* attribute in the *sun-jaxws.xml* configuration file

### 11.1.4 Use MTOMFeature with javax.xml.ws.Endpoint API
* **javax.xml.ws.soap.MTOMFeature**
* *MTOMFeature* is used to specify if MTOM should be used with a web service
* This feature should be used instead of the *javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_MTOM_BINDING*, *javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING*, and the *javax.xml.ws.soap.SOAPBinding.setMTOMEnabled()*
* This feature corresponds to the @MTOM annotation

* Enable this feature on either the server or client will result the JAX-WS runtime using MTOM and for binary data being sent as an attachment

### 11.1.5 Use swaRef in WSDL
* WS-I Attachment Profile 1.0 defines mechnism to reference MIME attachment parts using *swaRef*
* In this mechanism the content of XML element of type *wsi:swaRef* is sent as MIME attachment and the element inside SOAP Body holds the reference to this attachment in the CID URI scheme as defined by RFC 2111

* JAXB 2.0 defines mapping of *wsi:swaRef* schema type to *javax.activation.DataHandler
* An application will construct the *DataHandler* with the data and the appropriate MIME type and JAX-WS will coordinate with JAXB and SAAJ to send it as attachment MIME part

* An XML element of type *wsi:swaRef* is mapped to a *DataHandler* and is sent as attachment over the wire

### 11.1.6 Use MIME binding in WSDL

## 11.2 Use MTOM on the client

### 11.2.1 Use MTOMFeature with getPort() method
* If you want to use MTOM, you should encode your binary data as *xs:base64Binary* content
* Then enable MTOM on the client side by passing *javax.xml.ws.MTOMFeature* to the proxy constructor

* For each port in the service, the generated client side service class contains the following methods, two for each port defined by the WSDL service and whose binding is supported by the JAX-WS implementation:
    * *get<PortName>()*
    * *get<PortName>(WebServiceFeature... features)*

* A *WebServiceFeature* is a standard manner of enabling and disabling support for a variety of useful mechanism at runtime
* Some features come built in with JAX-WS, and vendors can provide additional features

* The class *javax.xml.ws.soap.MTOMFeature* extends *WebServiceFeature*
* The generated client interfaces make it easy to invoke your service operations using a built-in or custom feature
* To use MTOM on the client, simply retrieve the port using the factory that accepts a variable-lenght argument of *WebServiceFeature* objects, passing in an instance of *MTOMFeature*

* *MTOMFeature* constructor also accepts an optional integer argument indicating the threshold, or the number of bytes that the binary data should be before being sent as an attachment
* The default value for the threshold is 0

### 11.2.2 Use MTOM in the deployment descriptors

### 11.2.3 Sending any additional attachments using MessageContext properties
* **javax.xml.ws.handler.MessageContext**
* *MessageContext* is the supert interface for all JAX-WS messge contexts
* It extends *Map<String, Object>* with additional methods and constants to manage a set of properties that enable handlers in a handlers chain to share processing related state

* Properties are scoped as either *APPLICATION* or *HANDLER*
* All properties are available to all handlers for an insatnce of an MEP on a particular endpoint
* The default scope for a property is *HANDLER*

* Some standard message context properties:
    * *javax.xml.ws.binding.attachments.inbound*
    * *javax.xml.ws.binding.attachments.outbound*

* SOAP message with attachments specifed using the properties is genereated before invoking the first *SOAPHandler*
* Any changes to the two properties in consideration above in the *MessageContext* after invoking the first *SOAPHandler* are ignored
* The *SOAPHandler* however may change the properties in the *MessageContext*

* Use of *javax.xml.ws.binding.attachments.outbound* property in *Dispatch*:
    * When using *Dispatch* in SOAP / HTTP binding in payload mode, attachments speficied using *javax.xml.ws.binding.attachments.outbound* property will be included as mime attachments in the message
    * When using *Dispatch* in SOAP / HTTP binding in message mode, the *javax.xml.ws.binding.attachments.outbound* property will be ignore as the message type already provide a ways to specify attachments
