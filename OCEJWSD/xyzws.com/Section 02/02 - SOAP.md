# SOAP: Simple Object Access Protocol -- Abstract
* The Simple Object Access Protocol (SOAP) is a lightweight protocol for exchanging structured and typed information in a decentralized, distributed environment
* SOAP is an XML based protocol that consists of three parts:
    * An envelope that defines a framework for describing what is in a message and how to process it
    * A set of encoding rules for expressing instances of application-defined datatypes
    * A convention for representing remote procedure calls and response
    
* SOAP is about interoperability between application running on different platforms

* A SOAP message is a kind of XML document
* SOAP message is usually carried as the payload of some other network protocol: SMTP, FPT, and HTTP
* However, the WS-I Basic Profile 1.0 sanctions the use of SOAP over HTTP

# 1. The Basic Structure of SOAP
* SOAP messages are transmitted between applications and may pass though a number of intermediaries as they travel from the initial sender to the ultimate recipient
* A SOAP message, represented by the *Envelope* element, contains an *optional* Header and a *mandatory* Body element

* The *Envelope* element identifies the XML as being a SOAP message and *must be the root element* of the SOAP message
* The *Body* element contains the message *payload* which is the actual application data being exchanged between applications
* If a *Header* element is presented, it *must be the immediate child* of the *Envelope* element and *precede* the *Body* element

* A MESSAGE MUST NOT have any element children of *soap:Envelope* following by *soap:Body*

* A MESSAGE containing a *soap:mustUnderstand* attribute MUST only use the lexical forms "0" and "1"

# 2. SOAP Envelope
* The *Envelope* element is the *root* element for all SOAP messages, identifying the XML as a SOAP message
* The *Envelope* element *must be present* in a SOAP message

* A MESSAGE MUST NOT contain *soap:encodingStyle* attributes on any of the elements whose namespace name is *http://schemas.xmlsoap.org/soap/envelope/*
* A MESSAGE MUST NOT contain *soap:encodingStyle* attributes on any element that is a child of *soap:Body*
* A MESSAGE described in an *rpc-literal* binding MUST NOT contain *soap:encodingStyle* attribute on any elements are grandchildren of *soap:Body*

* A RECEIVER MUST generate a fault if they encounter a message whose  document element has a local name of *Envelope* but a namespace that is not *http://schemas.xmlsoap/soap/envelope/*

# 3. SOAP Header
* SOAP provides a flexible mechanism for extending a message in a decentralized and modular way without prior knowledge between the communicating parties
* The *Header* element serves as a container for extensions to SOAP
* User can defines extension services such as transaction support, locale information, authentication, digital signatures, etc ... by placing some information inside *Header* element

* *The SOAP Header element is the first immediate child element of the SOAP Envelope XML element, if it is presented*

* The *Header* element can have any number of *namespace-qualified immediate child elements* that are NOT in the *http://schemas.xmlsoap.org/soap/envelope/* namespace
* *All immediate child elements of the SOAP Header element MUST be namespace-qualified*

* The *header block* may be annotated with the SOAP *mustUnderstand* attribute and/or SOAP *actor* attribute which indicate how to process the entry and by whom

## 3.1 SOAP actor Attribute
* A SOAP message travels from the originator to the ultimate destination, potentially by passing through a set of SOAP intermediaries along the message path
* A SOAP intermediary is an application that is capable of both receiving and forwarding SOAP messages
* Both intermediaries as well as the ultimate destination are identified by a URI

* *The absence of the SOAP actor attributes, in the header block, indicates that the recipient is the ultimate destination of the SOAP message*

## 3.2 SOAP mustUnderstand Attribute
* The SOAP *mustUnderstand* global attribute can be used to indicate whether a header block is mandatory or optional for the recipient to process
* The recipient of a header entry is defined by the SOAP actor attribute
* *The absence of the SOAP mustUnderstand attribute is semantically equivalent to its presence with the value 0*

* If a header element is tagged with a SOAP *mustUnderstand* attribute with a value of "1", the recipient of that header entry either MUST obey the semantics and process correctly to those semantics, or MUST fail processing the message

* A RECEIVER MUST handle messages in such a way that it appears that all checking of mandatory header block is performed before any actual processing

* A RECEIVER MUST generate a *soap:MustUnderstand* fault when a message contains a mandatory header block targeted at the receiver (via *soap:actor*) that the receiver does not understand

## 3.3 Conformance Claim Header Block
* *A Claim element may be declared only as an immediate child of the Header element*, it cannot appear in any other part of a SOAP message
* The Claim header block is always considered optional, so *its mustUnderstand attribute must not be 1*

# 4. SOAP Body
* The *Body* element contains the payload of the message, that is, the part intended for the final recipient of the SOAP message
* The *Body* element is encoded as an immediate child element of the SOAP Envelope XML element

* The *Body* element can have one or more *namespace-qualified immediate child elements* that are not in the *http://schemas.xmlsoap.org/soap/envelope/* namespace or, if a fault occurred, a *Fault* element in the *http://schemas.xmlsoap.org/soap/envelope/* namespace

* *WS-I BP 1.0 requires all immediate children of Body element be namespace qualified*

# 5. SOAP Fault
* The *Fault* element indicates that an error occurred while processing a SOAP request
* This element is used to carry error and/or status information within a SOAP message and only appears in response messages
* The SOAP *Fault* element must appear as *a body entry* under the *Body* element and *must not appear more than once* within a *Body* element

## 5.1 Sub elements of SOAP Fault element
* *faultcode* : indicates what fault occurred
    * *VersionMismatch* : indicates that the recipient did not recognize the namespace name of the Envelope element
    * *MustUnderstand* : indicates that the element was not understood by the recipient
* *faultstring* : provides human-readable description of whatever fault occurred
* *faultactor* : indicates the source of the fault
* *detail* : intended for carrying application specific error information related to the *Body* element. It MUST be present if the contents of the Body element could not be successfully processed. It MUST NOT be used to carry information about error information belonging to header entries. Detailed error information belonging to header entries MUST be carried within header entries

## 5.2 SOAP Fault Codes
* The set of *faultcode* values defined in SOAP 1.1 is:
    * *VersionMismatch*: the processing party found an invalid namespace for the SOAP *Envelope* element
    * *MustUnderstand*: an immediate child element of the SOAP Header element that was either not understood or not obeyed by the processing party contained a SOAP *mustUnderstand* attribute with a value of 1
    * *Client*: indicates that the message was incorrectly formed or did not contain appropriate information in order to succeed
    * *Server*: indicates that the message could not be processed for reasons not directly attributable to the contents of the message itself but rather to the processing of the message
    
* When a MESSAGE contains a *soap:Fault* element, that element MUST NOT have element children other than faultcode, faultstring, faultactor and detail

* When a MESSAGE contains a *soap:Fault* element its element children MUST be unqualified

## 5.3 SOAP Fault Processing
* When a *Fault* is generated by a *RECEIVER*, further processing *SHOULD NOT* be performed on the SOAP message aside from that which is necessary to rollback, or compensate for, any effects of processing the message prior to the generation of the *Fault*
* Where the normal outcome of processing a SOAP message would have resulted in transmission of a SOAP response, but rather a SOAP *Fault* is generated instead, a RECEIVER MUST transmit a SOAP *Fault* message in place of the response
* A RECEIVER that generates a SOAP *Fault* SHOULD notify then end user that a SOAP *Fault* has been generated when practical, by whatever means is deemed appropirate to the circumstance

# 6. SOAP Encoding
* Simple Types:
    * String
    * Enumerations
    * Array of Bytes
* Compound Types:
    * Arrays
    * Structures

## 6.1 Serialization of simple structured data
* Serializing data structured, each field is serialized as an embedded element, a descendant element of the Body element

## 6.2 Serialization of Structured Data with Multiple References
* The field is serialized as an independent element, an immediate child element of Body, and must have an id attribute of type ID

## 6.3 Dealing with null References in Complex Data Structures
* Using the nil attribute in the *http://www.w3.org/2001/XMLSchema-instance* namespace
* Set xsi:nil="1"

## 6.4 Serializing Dynamically Typed Data
* SOAP provides for serialization of dynamically typed data; data typed at run-time, through a polymorphic accessor

## 6.5 Arrays
* Arrays in SOAP are always of type Array in the *http://schemas.xmlsoap.org/soap/encoding/* namespace, or a type derived by restriction from that type

## 6.6 Multidimensional Arrays
* Multidimensional arrays can be encoded by specifying multiple dimensions separated by commas inside the square brackets in the *arrayType* attribute
* Any number of dimensions may be specified

# 7. Using SOAP in HTTP
* Binding SOAP to HTTP provides the advantage of being able to use the formalism and decentralized flexibility of SOAP with the rich feature set of HTTP
* *SOAPAction*: indicates to the HTTP server that the request is a SOAP request
* *Content-Type*: text/xml
* *Content-Length*: number of bytes in the body of the request or response

* A MESSAGE SHOULD be sent using HTTP/1.1
* A MESSAGE MUST be sent using either HTTP/1.1 or HTTP/1.0

* A RECEIVER MUST interpret SOAP messages containing only a *soap:Fault* element as a Fault

* A HTTP request MESSAGE MUST use the HTTP POST method
* A MESSAGE MUST NOT use the HTTP Extension Framework

* *SOAPAction* is purely a hint to processors. All vital information regarding the intent of a message is carried in *soap:Envelope*

* An INSTANCE MAY accept connections on TCP port 80 (HTTP)
 
* An INSTANCE MUST use a 2xx HTTP status code for responses that indicate a successful outcome of a request

* An INSTANCE MUST use a *500 Internal Server Error* HTTP status code if the response message is a SOAP Fault
  
# 8. The Advantages and Disadvantages of Using SOAP Messages
* HTTP is a transport-level protocols and SOAP is a messaging-layer (communication) protocol
* SOAP can be used in combination with a variety of transport protocols - including SMTP, JMS, and other protocols in addition to HTTP - and does not depend on any particular network protocol
* SOAP messages may travel across several different transport-layer protocols before they reach their ultimate destination

## 8.1 SOAP Advantages:
* Platform independent
* SOAP decouples the encoding and communications protocol from the runtime environment. Web service can receive a SOAP payload from a remote service, and the platform details of the source are entirely irrelevant
* Language independent
* Anyone and anything can participate in a SOAP conversation, with a relatively low barrier to entry
* Uses XML to send and receive messages
* SOAP is also a simple way to accomplish remote object/component/service communications. It formalizes the vocabulary definition in a form that's now familiar, popular, and accessible (XML). If you know XML, you can figure out the basics of SOAP encoding pretty quickly
* Uses standard Internet HTTP Protocol
* SOAP runs over HTTP, which eliminates firewall problems. When using HTTP as the protocol binding, an RPC call maps naturally to an HTTP request and an RPC response maps to an HTTP response
* SOAP is very simple compared to RMI, CORBA, and DCOM because it does not deal with certain ancillary but important aspects of remote object systems
* A protocol for exchanging information in a decentralized and distributed environment
* SOAP is,transport protocol-independent and can therefore potentially be used in combination with a variety of protocols
* Vendor neutral

## 8.2 SOAP Disadvantages:
* The SOAP specification contains no mention of security facilities
* SOAP 1.1 specification does not specify a default encoding for the message body
* SOAP deals with objects serialized to plain text and not stringified remote object references, distributed garbage collection has no meaning
* SOAP clients do not hold any stateful references to remote objects