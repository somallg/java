# Chapter 3 - SOAP Handling

## SOAP: Hidden or Not?
* SOAP security 

## SOAP 1.1 and SOAP 1.2
* The structure of the SOAP header differs between the versions
* SOAP messages can be manipulated through *handlers*, which are programmer-written classes that contain *callbacks*
* At the application level, the SOAP remains hidden
* At the handler level, the SOAP is exposed so that the programmer can manipulate the incoming and outgoing messages
* SOAP Message:
    * SOAP envelope:
        * Optional SOAP header
        * Required SOAP body
    * Optional SOAP attachments

## SOAP Messaging Architecture
* Sender, intermediaries, and receiver
* An intermediary should inspect and process only the elements in the SOAP header rather than anything in the SOAP body, which carries whatever cargo the sender intends for the ultimate receiver alone
* XML elements within the optional header are *header blocks* in SOAP speak
The header block tagged with **uddi** contains a UUID (Universally Unique IDentifier) value, which is a 128-bit number formatted as string with hexadecimal numerals
* The header block with the **uddi** tag has an attribute, SOAP-ENV:actor, whose value ends with next
* The next actor, is the next recipient on the path from the sender to the ultimate receiver
* The **next** actor is expected to inspect header block in some way
* If a node cannot process the header block, then the node should throw a fault
* In SOAP 1.2, this expectation can be made explicit by setting the **mustUnderstand** of header block to **true**, ie the node **must** throw a fault if the node cannot process the header block

## Programming in the JWS Handler Framework
* JWS provides a *handler framework* that allows application code to inspect and manipulate outgoing and incoming SOAP messages
* A handler can be injected into the framework in two steps:
    * Create a handler class, which implements the **Handler** interface in the **javax.xml.ws.handler** package. JWS provides two **Handler** sub-interfaces, **LogicalHandler** and **SOAPHandler**
    * Place a handler within a handler chain (typically done through a configuration file, or through code)
* Once injected, a programmer-written handler acts as a message interceptor that has access to every incoming and outgoing message
* JWS handler framework thus encourages the *chain of responsibility* pattern
* The underlying idea is to distribute responsibility among various handlers so that the overall application is highly modular and maintainable

## The RabbitCounter Example
* The **RabbitCounter** service has one operation, **countRabbits** that expects a single integer argument and return an integer
* The service, its clients, and any intermediaries along the route from client to service are expected to process SOAP headers
* JWS has two different ways to throw SOAP faults

## Injecting a Header Block into a SOAP Header
* Whenever the **TestClient** generates a request against the **TestService**, the client side JWS libraries create a SOAP message
* Once the SOAP message has been created but before the message is sent, the UUIDHandler callbacks are invoked
* Handler methods of one type execute in order, from top to bottom
* The methods **handleMessage** and **handleFault** return **boolean** value
* A returned **true** means *continue message processing by executing the next handler in the chain*
* A returned **false** means *stop message processing*
* If a handler stops processing on a outgoing message, then the message is not sent
* The top-to-bottom sequence of the handlers in the configuration file determines the order in which handler methods of one type execute
* The runtime ordering may differ from the order given in the configuration file:
    * For an outbound message, the **handleMessage** method or **handleFault** method in a **LogicalHandler** code execute *before* **SOAPHandler**
    * For inbound message, the **handleMessage** method or **handleFault** method in a **SOAPHandler** code execute *before* **LogicalHandler**
* This runtime ordering makes senses because the **LogicalHandler** has access only to the body of the SOAP message, whereas the **SOAPHandler** has access the the entire SOAP message
* The **UUIDHandler** also is used to provide a wire-level dump of the outgoing SOAP message

## Configuring the Client-Side SOAP Handler
* Add to the sub:
* @HandlerChain(file = "handler-chain.xml")

## Adding a Handler Programmatically on the Client Side
* setHandlerResolver

## Generating a Fault from a @WebMethod
* A **fault** message rather than a output message becomes the service's response to the client
* When the service is published, the generated WSDL likewise reflects that the service can throw a SOAP fault
* WSDL includes a message to implement the exception and the **portType** section includes a **fault** message

## Adding a Logical Handler for Client Robustness
* The **ArgHandler** uses a **JAXBContext** to extract the payload from the **LogicalHandler** , the body of the outgoing SOAP message

## Adding a Service-Side SOAP Handler
* The ultimate header is also as a **next* actor and is likewise expected to precess the header block and throw a fault, if needed
* The specific processing logic is less important than the processing itself

## Summary of the Handler Methods
* The **Handler** interface declares three methods: **handleMessage**, **handleFault**, and **close**
* The **SOAPHandler** extension of this interface adds one more declaration: **getHeaders**, which returns a set of **QNames** for SOAP header blocks. This method can be used to insert security information into a SOAP header
* The other three methods have a **MessageContext** parameter that provides access to the underlying SOAP message
* The JWS handler framework gives the programmer hooks into the message-processing pipeline so that incoming and outgoing messages can be intercepted and processed in an application-suitable way
* The call back **handleMessage** is especially convenient, providing access to either the entire SOAP message or the payload of a SOAP message

## The RabbitCounter As a SOAP 1.2 Service
* Add **@BindingType**
* wsimport -extension
* Given the relatively minor differences between SOAP 1.1 and SOAP 1.2 and the status of SOAP 1.1 as the *de facto* standard, it makes sense to stick with SOAP 1.1 unless there is a compelling reason to use SOAP 1.2

## The MessageContext and Transport Headers
* A *context* is what gives an object access to its underlying container. Container, in turn, provide the under-the-hood support for the object
* SOAP messages are delivered predominantly over HTTP

## An Example to Illustrate Transport-Level Access

## Web Services and Binary Data
* There are two general approaches to handling arbitrary binary data in SOAP-based web services:
    * The binary data can be encode using a scheme such as base64 and then transmitted as the payload of the SOAP body. Base64 or similar encoding schemes result in payloads that are at least a third larger in size than the original, unencoded binary data
    * The binary data can be transmitted as one or more attachments to a SOAP message
    * The downside is that the receiver must deal with raw bytes
    
## Three Options for SOAP Attachments
* There are three options for SOAP attachments:
    * *SwA* (SOAP with Attachments), the original SOAP specification for attachments
    * *DIME* (Direct Internet Message Encapsulation), a lightweight but by now old-fashioned encoding scheme for attachments
    * *MTOM* (Message Transmission Optimization Mechanism), based on *XOP* (XML-Binary Optimized Packaging)

## Using Base64 Encoding for Binary Data
* The XSD indicates that the sylte is indeed wrapped **document**, the XSD type is the expected base64Binary

## Using MTOM for Binary Data
* In the XSD, change **xmime:expectedContentTypes="application/octet-stream"
* The MIME subtype name **application/octet-stream"** captures the optimization that recommends MTOM, the image bytes will be streamed unencoded to the service client
* **BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)**
* **binding.setMTOMEnabled(true)**
* The MTOM optimization occurs *after* the handler executes
* The client could enable MTOM

## What's Next?
* SOAP as a language-agnostic messaging system and XML Schema as a language-neutral type system promote service interoperability and API standardization
