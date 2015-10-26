# Chapter 1 - Web Services Quickstart
* A WS is a kind of webified application - an application typically delivered over HTTP
* In more technical terms, a WS is a distributed software system whose components can be deployed and executed on physically distinct devices
* At present, the distinction between SOAP-based and REST-style is not sharp, because a SOAP-based service delivered over HTTP can be seen as a special case of a REST-style service; HTTP remains the dominant transport for SOAP-based services

## 1.1 Web Service Miscellany
* Language transparency is a key contributor to web service interoperability - the ability of WS and their consumers interact seamlessly despite differences in programming languages, support libraries, operating systems, and hardware platforms
* There is no magic in language transparency. There must be an intermediary layer that handles the differences in data types between the service and the client languages: 
    * XML technologies - which support structured document interchange and processing
    * JSON (JavaScript Object Notation)
    
* Three features distinguish WS from other distributed software systems:
    * *Open infrastructure*
    * *Platform and language transparency*
    * *Modular design*
    
## 1.2 What Good Are Web Services?
* Systems integration

## 1.3 Web Services and Service-Oriented Architecture
* WS and SOAP are related but distinct
* SOA, like REST, is more an architectural style - a mindset - than a body of precisely defined rules for the design and implementation of distributed systems; WS are a natural, important way to provide the services at the core of any SOA system
* A fundamental idea in SOA is that an application results from integrating network-accessible services
* SOA vs DOA (Distributed Object Architecture)

## 1.4 A Very Short History of Web Services
* WS evolved from the RPC (Remote Procedure Call) mechanism in DCE (Distributed Computing Environment)

## 1.5 What Is REST?
* REST and SOAP are quite different:
    * SOAP is a messaging protocol in which the messages are XML documents
    * REST is a style of software architecture for distributed hypermedia systems, or systems in which text, graphics, audio, and other media are stored across a network and interconnected through hyperlinks
     
* In the Web, HTTP is both a transport protocol and a messaging system because HTTP requests and responses are messages
* The payloads of HTTP messages can be typed using the MIME (Multipurpose Internet Mail Extension) type system (such as *text/html*, "application/octet-stream*, *audio/mpeg3*)

* REST stands for Representational State Transfer - the central abstraction in REST is the resource
* A *resource* in the RESTful sense is something that is accessible through HTTP because this thing has a name - URI (Uniform Resource Identifier)
* As web-based informational items, resources are pointless unless they have at least one representation. In the Web, representations are MIME typed

* In a REST-style web service, a client does two things in an HTTP request:
    * Names the targeted resource by giving its URI, typically as part of a URL
    * Specifies a *verb* (HTTP method), which indicates what the client wishes to do
    
## 1.6 Why Use Servlets for RESTful Web Services?
* An *HttpServlet* is an natural, convenient way to implement RESTful WS for two main reasons:
    * Such servlets are close to the HTTP metal
    * Servlets execute in a servlet container - a middleware that mediates between the application code of the servlet and the web server that provide usual types of support : wire-level security, user authentication, authorization, logging and troubleshooting support, server configuration, local and remote database access, naming services, application deployment and administration

## 1.7 What's Next?
* The web service APIs include:
    * HttpServlet and its equivalents (e.g JSP scripts)
    * JAX-RS, which has various implementations
    * Restlet, which is similar in style to JAX-RS
    * JAX-WS @WebServiceProvider, which is relative low-level API
