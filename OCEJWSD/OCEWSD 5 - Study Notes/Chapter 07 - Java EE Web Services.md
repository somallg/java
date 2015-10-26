# Chapter 07 - Java EE Web Services

## 7.1 APIs Characteristics and Services
* Objective - Identify the characteristics of, and the services and APIs included in, the Java EE platform

* **Characteristics of the Java EE Platform**
* Industry standard for developing Java server-side applications
* In addition to Java SE, the Java EE platform provides:
    * Web services
    * A component model
    * Management and communication APIs
* Provides a framework for developing and deploying web services
* Uses containers that provide enterprise infrastructure - simplifies development and gives faster time to market
* Standardized APIs - ensures portability between implementations from different vendors
* Simplifies connectivity - provides JMS, CORBA, RMI and J2EE Connectors support
* Uses annotations to avoid separation between code and metadata - also helps avoiding XML configuration files

* **Services and APIs of the Java EE Platform
* Resource management
* Lifecycle management (EJB and Servlets)
* Distributed communication (EJB)
* Threading (EJB)
* Scaling (EJB)
* Transaction management (EJB)
* Infrastructure for components (Servlets)
* Infrastructure for communication (Servlets)
* Infrastructure for session management (Servlets)

* The Java EE platform provides the following APIs related to web services:
    * JAX-WS
    * JAX-RPC
    * JAXB
    * SAAJ
    * JAXP
    * JAXR

## 7.2 Benefits
* Objective - Explain the benefits of using Java EE platform for creating and deploying web service applications
* Less code needs to be written
* Easy to learn and use
* Support the latest standard and programming styles
* Provides complete support for developing and deploying web service applications
* Allows for interoperability between Java web services and/or clients and web services and/or clients developed on other platform

## 7.3 Functions and Capabilities
* JAXP - parse and transform XML documents
* DOM - read and write XML data
* SAX - read XML data
* StAX - read and write XML data
* JAXR - provides an uniform, standard, Java API for accessing XML registries
* JAXB - marshalling and unmarshalling of XML data to/from Java objects
* JAX-WS - develop SOAP and RESTful web services and web service clients
* SAAJ - produce and consume SOAP 1.1 and 1.2 messages and SOAP messages with attachments

## 7.4 Role of the WS-I Basic Profile
* Objective - Describe the role of the WS-I Basic Profile when designing Java EE Web services

* Provide interoperability guidance for core web service specifications, such as SOAP, WSDL, and UDDI
* Does not guarantee interoperability, but merely increases the chances that interoperability is achieved