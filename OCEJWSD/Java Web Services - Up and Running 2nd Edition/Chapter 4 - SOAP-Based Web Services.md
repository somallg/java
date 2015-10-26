# Chapter 4 - SOAP-Based Web Services
* @WebService annotation, in effect a refinement of @WebServiceProvider; a @WebService is emphatically SOAP-based

* SOAP has a *basic profile*, which comes from the WS-I (Web Services Interoperability) consortium to encourage and support interoperability among web service languages and technologies

## 4.1 A SOAP-Based Web Service
* @WebService annotation marks the POJO class as a web service, and the @WebMethod annotation specifies which of the encapsulated methods is a service operation
* The @WebMethod annotation is optional but recommended. In a class annotated as a @WebService, a *public* instance method is thereby a service *operation* even if the method is not annotated
* Core Java 6 or greater includes the *Endpoint* class for publishing web services, SOAP-based (@WebService) and REST-style (@WebServiceProvider) alike
* The *publish* method takes two arguments: a URL that specifies the service endpoint (line 1) and an instance of the service implementation class
* Underlying SOAP libraries handle the conversions between native language types (in this case, Java types) and XML Schema types

## 4.2 The RandService in Two Files
* The SEI specifies, at a high level that befits an interface, the service operations, and the SIB provides an implementation of the operations
* A SIB can be one of the following:
	* A POJO class annotated as @WebService and encapsulating service operation, each annotated as a @WebMethod
	* A @Stateless Session EJB that is likewise annotated as a @WebService. EJB in general predate JAX-WS; this second type of SIB is an inviting way to expose legacy EJBs as web services

## 4.3 Clients Against the RandService

## 4.4 A Java Client Against the RandService
* JDK 1.6 and greater ship with a utility, *wsimport*, that uses a WSDL to generate Java classes in support of programming a client against the service described in the WSDL
* The client-side artifact correspond to SOAP types described in the XML Schema document for the *RandService*

## 4.5 The WSDL Service Contract in Detail
* The document or root element is named *definitions* 
* The first child element of *definitions*, named *typed*, is technically optional but almost always present in a modern WSDL. This element contains (or links to) an XML Schema or the equivalent - a grammar that specifies the data types for the messages involved in the service. In a modern SOAP-based web service, the arguments passed to web service operations are typed - but the SOAP messages themselves are also typed. For this reason, the receiver of a SOAP message can check, typically at the library level, whether the received message satisfies the constraints that the message's type impose
* Next come one or more *message* elements, which list the messages whose data types are given in the *types* section immediately above. Every *message* has a corresponding *complexType* entry in the schema from the *types* section, assuming that the *types* section is non-empty
* The *portType* section comes next. There is always exactly one *portType* element. The *portType* is essentially the service *interface*: a specification of the service's operations and the message patterns that the operations exemplify. The *message* items in the preceding section are the components of an operation, and the *portType* section defines an *operation* by placing *message* items in a specific order
* Next come one or more *binding* sections, which provide implementation detail such as the transport used in the service, the service *style*, and the SOAP version
* The last section, name *service*, brings all of the previous details together to define key attributes such as the *service endpoint* - the URL at which the service can be accessed. Nested in the *service* element are one or more *port* sub-elements, where a *port* is a *portType* plus a *binding*:
	* port = portType + binding

* The first three WSDL sections (*types*, *message*, and *portType*) present the service abstractly in that no implementation details are present
* The *binding* and *service* sections provide the concrete detail by specifying, for example, the type of transport used in the service as well as the service endpoint

* The *portType* is of particular interest because it characterizes the service in terms of operations, not simply messages; operations consist of one or more messages exchanged in a specified pattern
* The *portType* section informs the programmer about what calss can be made against the service
* The *service* section gives the service endpoint, the URL through which the service can be reached

### 4.5.1 The types Section
* This section contains or links to an XML Schema or equivalent
* XML Schema is *extensible* in that new complex types can be added as needed
* The *message* has an *element* attribute with *tns:nextNResponse* as the value; *tns:nextNResponse* is the name of the *element* in line 1 of the XML Schema. The WSDL, in defining a message, points back to the XML Schema section that provides the data type for the message
* The *complexType* section of the WSDL indicates that a *nextNResponse* message returns zero or more integers (XML type xs:int). The zero leaves open the possibility that the service, in this case written in Java, might return *null* instead of an actual array of equivalent

### 4.5.2 The message Section
* Each *message* element in the WSDL points to an element and, more important, to an *complexType* in the WSDL's XML Schemas
* The result is that all of the messages are typed

### 4.5.3 The portType Section
* This section contains one or more *operation* elements, each of which defines an operation in terms of messages defined in the immediately preceding section
* The *input* message precedes the *output* message, which signals that the pattern is request/response. Were the order reversed, the pattern would be solicit/response
* The term *input* is to be understood from the service's perspective: an *input* message goes into the service and an *output* message comes out from the service
* Each *input* and *output* element names the message defined in a *message* section, which in turn refers to an XML Schema *complexType*

### 4.5.4 The binding Section
* This section and the next, *service*, provide implementation details about the service
* In theory, but rarely in practice, there are several operations or *degrees of freedom* with respect to the service that the WSDL defines, and a *binding* section selects among these options
* The *transport* value is a URI that ends with *soap/http*, which can be summed up as *SOAP over HTTP*. Another option would be SMTP (Simple Mail Transport Protocol) or even TCP (Transmission Control Protocol, which underlies HTTP), but in practice, HTTP is the dominant transport
* The *style* specifies the binding type : *document* or *rpc*. A web service in *document* style always ahs an XML Schema or equivalent that types the service's constituent messages. In the context of a WSDL, *rpc style* really means that messages themselves are not typed, only their arguments and return values are typed. The WSDL for an *rpc* style service may have no *types* section at all or only an abbreviated one. IN modern SOAP-based services, *document* style dominates and represents best practice
* The *encoding* determines how the service's data types are to be encoded and decoded. The WSDL has to specify how the data types used in an implementation languages such as Java are to be serialized into and deserialized out of WSDL-compliant types - the types laid out in the WSDL's XML Schema or equivalent:
	* *literal* - means the service's type definitions in the WSDL *literally* follow the WSDL's schema
	* *encoded* - means that the service's type definitions come from implicit encoding rules, typically the rules in the SOAP 1.1 specification. However, the use of *encoded* does not comply with WS-I
	
### 4.5.5 The service Section
* This section brings the pieces together. Recall that a WSDL has but one *portType* section but may have multiple *binding* sections
* The *service* element has *port* sub-elements, where a *port* is a *portType* linked to a *binding*; hence, the number of *port* sub-elements equals the number of *binding* sections in the WSDL
* The *address* sub-element specifies a *location*, whose value is commonly called the service endpoint
* A web service with two significantly different bindings (for instance, one for HTTP and another for SMTP) would have different *location* values to reflect the different bindings

## 4.6 Java and XML Schema Data Type Bindings
* The vast majority of the data types used in everyday Java programming convert automatically to and from XML Schema types

### 4.6.1 Code First or Contract First?
* Code-first approach: the service publisher automatically generates the WSDL for the service
* A service contract, one published, should be treated as immutable so that client-side code written against a published service never has to be rewritten
* Code-first approach goes against the *language neutrality* at the core of web services. If a service contract is done first, the implementation language remains open
* A code-first-generated WSDL and its accompanying schema can be refined as needed to ensure that this contract document reflects service requirements

## 4.7 Wrapped and Unwrapped Document Style
* Under the original SOAP 1.1 specification, a request message for *document* style - what is now called *unwrapped* or *bare* document style
* It is peculiar that the SOAP envelope should contain the named arguments but not the named operation
* Under *rpc* style, however, the operation would be the one and only child of the *Body* element; the operation then would have, as its own child elements, the arguments
* SOAP message in *rpc* style, called *wrapped document style*
* The wrapped convention, unofficial but dominant in SOAP frameworks, give a *document-style* service the look and feel of an *rpc-style* service - at the message level
* In Java, the default style for any SOAP-based service is *wrapped document*. This style is often shortened to *wrapped doc/lit* : wrapped document style with literal encoding

## 4.8 wsimport Artifacts for the Service Side
* The *wsimport* utility produces, from a WSDL document, code that directly supports client call against a web service

## 4.9 SOAP-Based Clients Against Amazon's E-Commerce Service
* The WSDL and *wsimport*

## 4.10 Asynchronous Clients Against SOAP-Based Services
* All of the SOAP-based clients so far make *synchronous* or *blocking* calls agains a web service
* Java takes the more conservative approach of generating the asynchronous artifacts only if asked to do so with a  customized binding
* The key point is that Java API fully supports synchronous and asynchronous calls against SOAP-based services

## 4.10.1 How Are WSDL and UDDI Related?
* WSDL documents, as service contracts, should be publishable and discoverable, as are the services that they describe
* A UDDI (Universal Description Discovery and Integration) registry is one way to publish a WSDL so that potential clients can discover the document and ultimately consume the web service that the WSDL describes
* UDDI has a type system that accommodates WSDL documents as well as other kinds of format service contacts
* From a UDDI perspective, a WSDL appears as a two-part document:
	* One part, which comprises the *types* through the *binding* sections, is the UDDI *service interface*
	* Other part, which comprises any *import* directives and the service section, is the UDDI *service implementation*
* In WSDL, the service interface (portType section) and the service implementation (binding section) are two parts of the same document
* In UDDI, they are two separate documents, and these UDDI term do not match up exactly with their WSDL counterparts
* A WSDL does not explain service semantics, i.e what the service is about
* The WSDL does explain, in a clear and precise way, the service's invocation syntax: the names of the service operations, the operation pattern, the number, order, and type of arguments that each operation expects; faults, if any associated with a service operation, and the number, order and types of response values from an operation

## 4.11 What Next?
* JAX-WS has two distinct but related APIs for SOAP-based WS. One API, with annotations such as @WebService and @WebMethod, focuses on what might be called the application level
* A central feature of the application level is the WSDL contract, which captures in XML the service and its operations, including essential details such as the invocation syntax for the service operations, the encoding/decoding scheme for data types, the transport used for messages, and the service endpoint

* The handler API allows the programmer to inspect and if needed, to manipulate the SOAP that the underlying libraries generate
* The distinction between the JAX-WS application and handler APIs in web service corresponds roughly to the distinction between *servlet* and *filer* API in Java-based websites

* On either the client side or the service side, JAX-WS code can inspect and if appropriate, modify the HTTP messages that carry SOAP messages as their payloads
* JAX-WS thus cover three distinct levels of SOAP-based web services: the application level, the handler level, and the transport level