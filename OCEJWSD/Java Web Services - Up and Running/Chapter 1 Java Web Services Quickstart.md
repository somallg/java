# Chapter 01 - Java Web Services Quick Start

## What Are Web Services
* A web service: *webified application*, typically delivered over *HTTP*
* A webservice: distributed application whose components can be deployed and executed on distinct devices
* 4 conversational patterns:
    * request/response
    * solicit/response
    * one-way
    * notification
* Divided into 2 groups:
    * SOAP-based
    * REST-style
* SOAP (Simple Object Access Protocol), may stands for SOA (Service Oriented Architecture): XML dialect with grammar that specifies the structure that a document must have in order to count as SOAP, tends to be request/response
* REST (REpresentational State Transfer) by Roy Fielding, describe an architectural style in the design of web services, tends to be request/response
* SOAP has standards (under W3C), toolkits, and bountiful libraries
* Language independent is a key contributor to web service *interoperability*
* There must be an intermediary layer that handles the differences in data types between the service and the client languages
* XML technologies, which support structured document interchange and processing, act as one of such intermediary level
* Another intermediary level is JSON
* XML and JSON are both data-interchange formats
* 3 features distinguish web services from other distributed software system:
    * *Open infrastructure: by using industry-standard HTML, XML, JSON*
    * *Platform and language transparency*
    * *Modular design: group many web services to build big system*

## What Good Are Web Services?
* Interoperability
* Language and platform neutral

## A First Example

## The Service Endpoint Interface and Service Implementation Bean
* JAX-WS (Java API for XML-Web Services)
* JAX-WS supports SOAP-based and REST-style services
* JAX-WS commonly shorted to JWS for Java Web Services
* Current version of JAX-WS is 2.x
* Version 1.x has a different label: JAX-RPC
* JAX-WS preserves but also significantly extends JAX-RPC
* SOAP-based web service, following best practices, declare an interface with methods (web service operations)
* The interface is called SEI (Service Endpoint Interface)
* The implementation is called SIB (Service Implementation Bean)
* SIB can be either POJO or Stateless Session EJB

## Core Java 6, JAX-WS, and Metro
* Java SE 6 ships with JAX-WS
* The bleeding edge of JAX-WS is the *Metro Web Services Stack*, which includes Project Tango to promote interoperability between Java platform and WCF (Windows Communication Foundation), aka Indigo
* The core Java utility is called *wsimport*, earlier names *wsdl2java* and *java2wsdl*

## A Perl and a Ruby Requester of the Web Service
* To illustrate the language transparency of web services, we use a Perl client, then a Ruby client

## The Hidden SOAP
* The Perl client generates an HTTP request, which is a formatted message whose body is a SOAP message

## A Java Requester of the Web Service
* The Java client uses the same URL with a query string as do the Perl and Ruby client
* Java client explicitly creates an XML *qualified name*, which ahs the syntax *namespace URI:local name*
* **java.xml.namespace.QName** represents an XML-qualified name

## Wire-Level Tracking of HTTP and SOAP Messages
* Various options are available for tracking SOAP and HTTP messages:
    * *tcpmon*
    * Metro utility
    * SOAPscope
    * NetSniffer
    * Wireshark
    * *tcpdump*
    * *tcptrace*

## What's Clear So Far?
* The two operations are implemented as independent

## Key Features of the First Code Example
* **TimeServerImpl** implements a web service with a distinctive message exchange pattern (MEP) - request/response
* SOAP-base web services support various patterns
* The request/response pattern of RPC remains the dominant one
* *Message transport*: SOAP is designed to be transport-neutral. SAP delivered over HTTP should not differ from SOAP delivered over some other transport protocol such as SMTP (Simple Mail Transfer Protocol), FTP (File Transfer Protocol), or even JMS (Java Message Service)
* *Service contract*: the service client requires information about the service's operations
* *Type system*: the key to language neutrality, interoperability is a shared type system

## Java's SOAP API
* The SOAP body is always required, the body may be empty
* The SOAP header is optional

## An Example with Richer Data Types

## Multithreading the Endpoint Publisher
* The Endpoint publisher has been single-threaded
* JWS supports Endpoint multithreading
* Endpoint object has an Executor

## What's Next?
* Generate client-side artifacts with **wsimport**
* JAX-B (Java API for XML-Binding)
* *wsgen* generates JAX-B artifacts

## Web Services and Service-Oriented Architecture
* Web services and SOA are related but distinct
* SOA, like REST, is more an architectural style
* Web services are a natural, important way to provide the services at the core of any SOA system
* The very point of a service interface is to publish the invocation syntax of each operation
* In a SOA system, services are *unassociated* and *loosely coupled*
* At the implementation level, a service operation is a function call
* In SOA, promotes code reuse thorough composition
* Stateless function call: depend only on the arguments
* Provider/consumers: server/client

## A Very Short History of Web Services
* Web services evolved from RPC (Remote Procedure Call) mechanism in DCE (Distributed Computing Environment)

## From DCE/RPC to XML-RPC
* DCE/RPC has the familiar client/server architecture in which a client invokes a procedure that executes on the server
* IDL (Interface Definition Language) is a precursor of the WSDL (Web Service Description Language)
* XML-RPC is a very lightweight RPC system with support for elementary data types
* 2 key features are the use of XML marshaling/unmarshaling to archive language neutrality and reliance on HTTP (SMTP) for transport
* Marshaling: conversion of in-memory object to other format
* Unmarshaling: refer to the inverse process
* SOAP is a XML dialect derived from XML-RPC

## Distributed Object Architecture: A Java Example
* In DOA, to call a method in server, the client need a stub and all other related classes
* Java RIM uses proprietary marshaling/unmarshaling and proprietary transports
* Web services represent a move toward standardization, simplicity, and interoperability

## Web Services to the Rescue
* Web services simplify matters in distributed computing: client/server exchange XML, or equivalent document, that is *text*
* Text can be inspected, validated, transformed, persisted
* The complexities can be isolated to the endpoints - the service and the client
* Web services are available over HTTP

## What Is REST?
* SOAP is a messaging protocol in which the message are XML documents
* REST is a style of software architecture for distributed hypermedia system (WWW is the example of such system)
REST stands for REpresentation State Transfer, central abstraction in REST - the resource
* A resource is something that is accessible through HTTP - URI (Uniform Resource Identifier)
* URI has 2 subtypes: URL, URN
* URI is a standardized name for a resource, a URI acts as noun
* In REST-style web services, a client does 2 thing:
    * Names the targeted resource by giving its URI, typically as part of a URL
    * Specifies a verb (HTTP method)
* RESTful web services involve not just resources to represent but also client-invoked operations on such resources
* HTTP acts as an API
* GET request should be side-effect free (idempotent)
* REST try to isolate application complexity at the endpoints
* RESTful approach keeps the complexity out of the transport level

## Verbs and Opaque Nouns
* URIs have no intrinsic hierarchical structure, although URI syntax look like the syntax used to navigate a hierarchical file-system
* A URI is an opaque identifier, a logically proper name that should denote exactly one resource

## Review of HTTP Request and Responses
* GET has no body, often in URI include a query string with key/value pairs
* POST has body, which holds key/value pairs

## HTTP as an API
* HTTP can be viewed as an API
* GET: read a resource
* POST: create a new resource
* PUT: update a resource
* DELETE: delete a resource