# Web Service in General

# 1. Web Services Interaction Models
* WS Interaction Models specify how the clients invoke and use the WS
* WS offers two types of Interaction Models:
    * *RPC-Style Web Services*
    * *Document-Style Web Services*
* It's just that there are two ways to structure a SOAP message
* By the time the SOAP 1.0 spec was published, it was expanded to support both RPCs and unstructured messages (document)
* When using RPC style, the contents of the SOAP Body must conform to a structure that indicates the method name and contains a set of parameters
* When using Document style, you can structure the contents of the SOAP Body any way you like

## 1.1 What is the Remote Procedure Call (RPC)?
* The *Remote Procedure Call* is a type of protocol that allows an application running in one execution thread on a system to call a procedure belongings to another application running in a different thread on the same or different system

* RPC is an easy and popular paradigm for implementing the client-server model for distributed computing
* RPC model is a well-tested, industry-wide framework for distributing application
* *RPC interfaces* (the collection of procedures used by the client side and provided by the server side) are based on a request-response model where one program calls, or requests a service of another across a tightly coupled interface

## 1.2 RPC-Style Web Services
* *Remote procedure call (RPC)-Style Web Services* are tightly coupled and interface-driven, which means that the business methods of the underlying implementation determine how the WS works
* RPC-style Web Services are tightly coupled because the sending parameters and return values are as described in WS's WSDL file

* RPC-style WS are typically characterized as synchronous, which means that the client sends the request and waits for the response till the request is processed completely before it continues with the remainder of its application
* It is typically used for the process-oriented rather than data-oriented

* The client send SOAP request to a Ws, the SOAP request contains the name of methods to be executed in the WS and parameters that the method will need when it is executed. The WS converts this request to appropriate objects and executes the operation and sends the response as SOAP message back to the client. At the client side, this response is used to form appropriate objects and return the required information to the client

* RPC-style messaging weaknesses include:
    * *Strong coupling*
    * *Synchronicity*
    * *Marshaling and serialization overhead* - marshaling and serializing XML is more expensive than marshaling and serializing a binary data stream

* For WS, SOAP defines the wiring between the calling and called procedures. At the SOAP level, the RPC interface appears as series of highly structured XML messages moving between the client and the server where the Body of each SOAP message contains an XML representation of the call or return stack

* The steps of typical RPC-Style WS message exchange process:
    * Client calling a method implemented as a remote procedure. The client actually calls a proxy stub that acts as a surrogate for the real procedure. The proxy stub presents the same external interface to the caller as would the real procedure, but instead of implementing the procedure's functionality, implements the processes necessary for preparing and transporting data across the interface
    * The Proxy stub gathers the parameters it receives through its parameter list into a standard form, in this case, into a SOAP message, through a process called marshaling
    * The Proxy stub encodes the parameters as appropriate during the marshaling process to ensure the recipient can correctly interpret their values. Encoding may be as simple as identifying the correct structure and data type as attributes on the XML tag enclosing the parameter's value or as complex as converting the content to a standard format such as Base64. The final product of the marshaling process is a SOAP message representation of the call stack
    * The Proxy stub serializes the SOAP message across the transport layer to the server. Serialization involves converting the SOAP message into a TCP/IP buffer stream and transporting that buffer between the client and the server
* The server goes through the reverse process to extract the information it needs. A listener service on the server deserializes the transport stream and calls a proxy stub on the server that unmarshal the parameters, decodes and binds them to internal variables and data structures, and invokes the called procedure

## 1.3 Document-Style Web Service
* Document-Style (Message-Style) Web Services are *loosely coupled* and document-driven
* Message-Style Ws are characterized as asynchronous with the potential for highly complex document structures
* They are frequently used for data-oriented programming rather than process-oriented programming

* The client sends the parameter to the WS as a XML document fragment, instead of discrete set of parameter values to the WS
* Message-style WS typically require transformation and routing based on content and are frequently part of longer running sequences
* The input XML document can also be described in WSDL. The WS processes the document, executes the operation on the payload and constructs & sends the response to the client as an XML document

* Unlike RPC-style WS, Document-style WS does not follow request/response semantics. The WS receives entire document, processes it and may or may not return a response message
* The SOAP Body of a message style carries one or more XML documents, within its body
* The protocol places no constraints on how that document needs to be structured, which is totally handled at the application level
* Document-style WS follows asynchronous processing

* There is no direct mapping between the server objects (parameters, method calls etc) and the values in XML documents. The application has to take care of mapping the XML data types
* Document-style WS can use both one-way (non-blocking) calls and two-way (request-response) calls, but preferable choice will be one-way calls

* The bigger difference in WS is how you encode the message. In most circumstances, you use:
    * Literal encoding in Document-style - the Body contents conform to a specific XML Schema
    * SOAP encoding with RPC styles - SOAP encoding uses a set of rules based on the XML Schema data-types to encode the data
    
* Document-style messaging's strengths are in situations where an XML document is part of the data being passed across the interface, where you want to leverage the full power fo XML and XSL, and in instances where you want to minimize coupling between services forming an interface, such as application-to-application and system-to-system interfaces

* Document-style messaging weaknesses include:
    * *No standard service identification mechanism* - with Document-style messaging, the client and server must agree on a service identification mechanism: a way for a document's recipient to determine which service(s) need to process that document
    * *Marshaling and serialization overhead* - Document-style messaging suffers from the same drawbacks as RPC-style messaging
    
* There are two compelling reasons to use document-style messaging:
    * Gain the independence it provides
    * Puts the full power fo XML for structuring and encoding information at your disposal. The SOAP document simply becomes a wrapper containing whatever content you decide
    
* The steps of typical Document-style message exchange process:
    * SOAP client create an XML document fragment based on the request parameters. The XML document may contain the namespace references that other applications can use for validating the encapsulated document's format and content
    * SOAP client inserts the XML document fragment into the Body of a SOAP message
    * SOAP client sends the SOAP message to the SOAP web service server across HTTP/HTTPS
    * SOAP service extracts the XML document from the Body of the request SOAP message
    * SOAP service create an XML document fragment based on the response value
    * SOAP service inserts the response XML document into the Body of a SOAP message
    * SOAP service sends the SOAP message to the SOAP client in HTTP/HTTPS
    * SOAP client extract the response value from the XML document that is in the Body of the response SOAP message
    
* RPC-style messaging maps to the object-oriented, component-technology space
* Document-style messaging is clearly an option in any situation where an XML document is one of the interface parameters

## 1.4 References

# 2. Web Service Invocation Modes
* To invoke a service, you need the following information:
    * Service address - where to contact the service. For example, the endpoint of a WS
    * Service contact - what you are supposed to send to the server and what, if anything, supposed to return to you. For message-style system, we normally specify contacts in terms of documents. For RPC-style system, contracts are generally synonymous with object interfaces
    * Service semantics - what the service actually does
    
* In other words, what you need to know to invoke a service is: what to send to it, where to send what you are sending, and what the service will do for you

* WS invocation modes specify how the clients consume WS. Typically the clients consume WS in the following ways:
    * *Static invocation* - uses pre-generated stub. This stub corresponds to a WSDL specification agreed in advance
    * *Dynamic invocation* - generates the stub at the time of the method invocation. This stub is generated by parsing the WSDL document that describes the WS

## 2.1 Static Invocation
* In static invocation, the clients generate proxy stubs during development time, using the WSDL of the WS
* The clients invoke the methods in the proxy stub, which in turn invokes the methods in the WS
* The main advantage in static invocation is, the client need not parse the WSDL file when the method is invoked
* On the flip side, if the WSDL file changes, these proxy stubs have to be re-generated
* If the client uses *n* WS, all the *n* proxy stubs need to be maintained at the client side

## 2.2 Dynamic Invocation
* Unlike static invocation applications, which have all necessary invocation information built into them, applications that use dynamic invocation discover all the invocation information they need at runtime
* The are various ways to do this, but all revolve around some form of meta-data management. For example, systems such as Java and C# support *reflection*, which lets you dynamically load new classes, create instances of them, and invoke their methods, all on the fly and without any compile-time knowledge of those classes in your application

* In dynamic invocation, the clients do not need proxy stub. These are generated at runtime, using dynamic invocation API's. The advantage here is that any changes to the WSDL file will not affect the WS invocation. Also, the client does not have to maintain any proxy stub

* Applications that employ dynamic invocation do not have service-contract compile-time knowledge, so they avoid versioning issues that can plague static applications
* Dynamic invocation applications tend to be slower and larger than their static counterparts because they use general facilities to manipulate all types and thus cannot rely on the programming language or compiler for help

* Static invocation suffers from tight coupling and versioning problems, while dynamic invocation applications can be too big, slow and complex

## 2.3 A Typical WS Invocation
* Service discovery is to *find* a WS that meets the requirements. Do this by contacting a discovery WS such as UDDI registry
* The *discovery service* (i.e UDDI registry) will reply telling what servers can provide the required service
* To actually invoke the WS, we have to ask the WS to *describe itself* (i.e tell us how exactly we should invoke it)
* The WS replies a service description in a language called WSDL
* The invocation is done in a language called SOAP. Therefore, we will first send a *SOAP request*
* The WS will kindly reply with a *SOAP response*

* A WS client don't usually do all those step in a single invocation. A more correct sequence of events would be:
    * Locate the WS through *discovery service* such as UDDI
    * Obtain the WS's WSDL description from the located WS
    * Generate the stub *once*, and include them in our application
    * Use the stubs each time when the application needs to invoke the WS
    
* Form the typical WS invocation, we can see the WS architecture:
    * **Service Discovery** - allows us to find WS which meet certain requirements. This party is usually handled by UDDI
    * **Service Description** - One of the most interesting features of WS is that they are *self-describing*. This mean that, once you have located a Ws, you can ask it to *describe itself* and tell you what operations it supports and how to invoke it. This is handled by the *Web Services Description Language* (WSDL)
    * **Service Invocation** - Invoking a WS involves passing messages between the client and the server. SOAP (Simple Object Access Protocol) specifies how we should format requests to the server, and how the server should format its responses. In theory, we could use other service invocation languages (such as XML-RPC, or even some *ad hoc* XML language). However, SOAP is by far the most popular choice for WS
    * **Transport** - Finally, all these messages must be transmitted somehow between the server and the client. The protocol of choice for this part of the architecture is *HTTP* (Hyper Text Transfer Protocol), the same protocol used to access conventional web pages on the Internet. Again, in theory we could be able to use others protocols, but HTTP is currently the most used one
    
## 2.4 References

# 3. Web Service Interaction Modes
* The following are the application interaction modes supported by JAX-RPC, the JAX-RPC providers may use any kind of low-level interaction modes to support the Application interaction modes:
    * *Synchronous Request-Response Mode* - In this mode, the service client makes a request and waits (the current thread executing the request) for the response from the server; the service receives a request message, processes it, and send a correlated response message. JAX-RPC and service client programming model supports this mode through both the stub (or dynamic proxy) based model and DII Call interface
    * *One-way RPC Mode* - In this mode, client invokes a remote method and continues without waiting for the response from the service endpoint; the service receives a request message, consumes it, but does not produce any response message. The client does not get any response (either return values or remote exceptions) from the Service endpoint. JAX-RPC supports this one-way mode through DII Call interface
    * *Non-blocking RPC Invocation* - Client invokes a remote method and continues processing without waiting for response; the service receives a request message, produce a response message. It later process the response by performing blocking receive. JAX-RPC runtime does not need to support this mode
    
# 4. Web Services Security at Transport Level and Message Level
* WS currently revolves around three important protocols: SOAP, WSDL and UDDI

* There are two ways with which we can ensure security with WS:
    * *Transport level security* - such as HTTP Basic/Digest and SSL, is the usual *first line of defence*, as securing the transport mechanism itself makes WS inherently secure. The trade-off is transport dependency (WS are more tightly coupled to the network transport layer)
    * *Message level security* - such as WS-Security, SAML, XML Digital Signatures, and XML Encryption, can be more effective and has the added flexibility that the message can be sent over any transport

## 4.1 Transport Level Security
* Transport level security is based on *Secure Sockets Layer* (SSL) or *Transport Layer Security* (TLS) that runs beneath HTTP
* SSL and TLS provide security features including authentication, data protection, and cryptographic token support for secure HTTP connections
* To run with HTTPS, the Service endpoint address must be in the form *https://*
* The integrity and confidentiality of transport data, including SOAP messages and HTTP basic authentication, is confirmed when you use SSL and TLS

* *Secure Sockets Layer* (SSL) is a protocol developed by Netscape for transmitting private documents via the Internet. The SSL is the Industry accepted standard protocol for secured encrypted communications over TCP/IP
* SSL protocol provides transport layer security: *authenticity*, *integrity*, and *confidentiality*, for a secure communication across the wire
* SSL operates between communication endpoints, not between applications

* *Transport Layer Security* (TLS) is a security protocol from the IETF that is based on the *Secure Sockets Layer* (SSL) 3.0 protocol developed by Netscape
* TLS uses digital certificates to authenticate the user as well as authenticate the network

* Implementing security at the transport level means, securing the network protocol, a WS uses for communication. SSL provides endpoint authentication and communication privacy over the internet using cryptography. In this model, a WS client will se SSL to open a secure socket to a WS. The client then sends and receives SOAP messages over this secured socket using HTTPS

* HTTPS provides encryption, which ensures privacy and message integrity

## 4.2 Message Level Security
* Message level security is an application layer service and facilitates the protection of message data between applications. Message level security is typically most useful for:
    * Solutions that are designed to use predominantly asynchronous queues
    * Solutions for which application level security is important; that is solutions whose normal message paths include flows over multiple nodes perhaps connected with different protocols. Message-level security manages trust at the application level, which means security in other layers becomes unnecessary
    
* SOAP based communications introduces the notion of *Message Level Security*
* In message level security, security information is contained within the SOAP message, which allows security information to travel along with the message
* Message-level security is also sometimes referred to as end-to-end security

* There are some standard available for securing WS at XML Level. They are:
    * XML Encryption
    * XML Digital Signature API
    * XKMS (XML Key Management Specification)
    * SAML (Security Assertion Markup Language)
    
## 4.3 SSL Limitations
* SSL is widely used as the security schema in web applications. However, despite its popularity, it has some limitations
    * SSL is designed to provide point-to-point security, which falls short for WS because we need end-to-end security, where multiple intermediary nodes could exist between the two endpoints. In a typical WS environment where XML-based business documents route through multiple intermediary nodes, it proves difficult for those intermediary nodes to participate in security operations in an integrated fashion
    * SSL secures communications at transport level rather than at message level. As result, messages are protected only while it transit on the wire
    * HTTPS in its current form does not support non-repudiation well. Non-repudiation means that a communication partner can prove that the other party has performed a particular transaction
    * SSL does not provide element-wise signing and encryption. For example, if you have a large purchase order XML document, yet you want to only sign or encrypt a credit card element, signing or encrypting only that element with SSL proves rather difficult. Again, that is due to the fact that SSL is a transport-level security scheme as opposed to a message-level scheme
    
# 5. Federation Management
* Federation allows for the interchange of security-related information between different entities
* Security-related information meaning: *authentication*, *authorization*, and *auditing data*
* Although federation is generally used in the context of an inter-enterprise security mechanism, it can also be used within an enterprise, to provide tighter integration between several loosely-coupled ecosystems
* A Federation agreement always deals with two entities:
    * An asserting party that generates security assertions
    * A relying party that trusts the security assertion made by the asserting party
    
## 5.1 What Is Identity?
* *Identity* is a set of attributes that describes a profile of an individual, business organization, or software entity
* *Identity verification* is a dialog of presentation and interpretation

* A *local identity* refers to the set of attributes or information that identify a user to a particular *service provider*
* These attributes uniquely identify the individual with that provider

* Because the Internet is fast becoming the prime vehicle for business, community and personal interactions, it has become necessary to fashion a system for online users to link their local identities, enabling them to have one *network identity*. This system is *identity federation*

## 5.2 What Is Identity Federation?
* Identity Federation allows a user to associate, connect or bind the local identities configured with multiple service providers
* A federated identity allows users to login at one service provider's site and move to an affiliated service provider site without having to re-authenticate or re-establish their identity

* It combines data on a single user from multiple sources, for purposes such as authorization
* Since different organizations probably want to use different products to manage the identity data they have, standards are needed to move that data around the network - from where it is being held to where it will be used. The Liberty Alliance Project addresses these challenges

## 5.3 Identity Management Architecture
* An identity management system mediates between identities and resources: it controls identity resource access and facilitates identity resource access management
* There are two possible identity management architectures, one based on a centralized model and the other, on a federated model
* Advantages of the Centralized Model:
    * A single operator owns and controls everything, constructing and managing the identity network could be easier than with the federated model
* Disadvantage of the Centralized Model:
    * The dangerous potential for the single operator becoming a tollgate for all transactions over the Internet
    * A single operator could represent a single point of security failure or hacker attack
    * A single operator can take away the most important business asset - customer identity and profile information - from an organization
    * In the federated model, both authentication and authorization tasks are distributed among federated communities
    
* The federated model, driven by the Liberty Alliance Project, is designed to correct the centralized model's problem
* The goal of the Liberty Alliance Project is to create an open standard for identity, authentication, and authorization, which will lower e-commerce cost and accelerate organization's commercial opportunities

* In the federated identity management architecture scheme, three roles could exist:
    * *Consumer* - can have multiple identity profiles, and you can ask different identity providers to maintain these profiles. Consumers have a final say in terms of who can access what information. Consumers can be a person, a business, or a software entity 
    * *Identity Provider* - are service providers that specialize in providing authentication services. Identity providers maintain user profile information and can interoperate among themselves as long as they have permission to do so from the profile's owner, the consumer
    * *Service Provider* - are commercial or not-for-profit organizations that offer web-based services. Service providers can customize their services to each consumer by retrieving relevant identity profiles from the identity providers
    
* A *federated identity* refers to the amalgamation of the account information in all service providers accessed by one user (personal data, authentication information, buying habits and history, shopping preferences, etc...)

## 5.4 The Liberty Alliance Project
* The goal of the Liberty Alliance Project is to enable individuals and organizations to easily conduct network transactions while protecting the individual's identity. To accomplish this, the Alliance has established specifications for identity federation that enables:
    * Opt-in account linking where users can choose to federate different service provider accounts
    * Single sign-on where a user can login, authenticate to one service provider and gain access to other service providers with which they have federated without having to log in again
    * Authentication context where service providers with federated accounts communicate the type and level of authentications that should be used when the user logs in
    * Global log-out when a user logs out of an identity or service provider site and is automatically logged out of all sites that maintain a live session
    * Account linking termination where users can choose to stop their account federation
    
* These capabilities can be achieved when commercial or non-commercial organizations join together into a circle of trust based on Liberty-enable technology and operational agreements
* This circle of trust includes service providers (who offer web-based services to users), identity providers (service providers that also maintain and managed identity information), and the users themselves

* The summary the goal of Liberty Alliance Project is to: 
    * Enable individual consumers and businesses to maintain personal information securely
    * Provide a universal open standard for single sig-on with decentralized authentication and open authorization from multiple providers
    * Provide an open standard for network identity spanning all network devices
    
## 5.5 Circle of Trust
* The goal of the Liberty Alliance Project is to enable individuals and organizations to easily conduct network transactions while protecting the individual's identity. This goal can be achieved only when commercial and non-commercial organizations join together into a circle of trust

* A Circle of Trust is enabled through federated identity and is defined by the alliance as *a group of service providers that share linked identities and have pertinent business agreement in place regarding how to do business and interact with identities. Once a user has been authenticated by a Circle of Trust identity provider, that individual can be easily recognized and take part in targeted services from other service providers within that Circle of Trust. Note that this concept of trust-based relationships between organizations and their individual or join customers has existed in the offline business world for years; two common examples would include travel alliance and affiliated business partnerships*

* A *trusted provider* is a generic term for one of a group of service and identity providers in a Circle of Trust. Users can transact and communicate with Trusted Providers in a secure environment

## 5.6 Reference