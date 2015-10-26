# Chapter 6 - JAX-WS in Java Application Servers

## Overview of a Java Application Servers
* The software bundled into a JAS (Java Application Servers):
    * *Web container*: deploys servlets and web services
    * *Message-oriented middleware*: supports JMS (Java Message Service)
    * *Enterprise Java Bean (EJB) container*: holds EJB instances
    * *JNDI service provider*
    * *Security provider*
    * *Relational Database Management System*
    * *Client container*
    
## A @WebService As an EJB
* Add @Stateless

## The EJB Deployment Descriptor


## Servlet and EJB Implementations of Web Services
* In the servlet implementation, the web container handles requests against the web service
* In the EJB implementation, the EJB container handles request against the web service
* EJB container provides more services then does the servlet container (thread-safe, transaction, ...)

## Java Web Services and Java Message Service
* @Resource annotation, used for dependency injection

## WS-Security Under GlassFish

## Mutual Challenge with Digital Certificates
* MCS (Mutual Certificates Security)
* There are two ways to do an MCS application:
    * One way is to rely directly on HTTPS
    * Second way is to be transport-agnostic and rely instead on mutual challenge with Metro's WSIT support
    
## MCS Under HTTPS    

## MCS Under WSIT

## The Dramatic SOAP Envelopes
* The complexity make sense given that WSIT cannot rely on the transport level for any aspect of the overall security
* Instead, WSIT must use the SOAP messages in support of trust, secure conversation, and data confidentiality

## Benefits of JAS Deployment
* Endpoint is a lightweight publisher
* A standalone web container is a middleweight publisher
* An application server is heavyweight publisher
* *heavyweight* connotes *complicated*
* The advantages that an application server offers for deploying WS:
    * A WS can be implemented as stateless EJB: EJB container offers services (thread safety, container-managed transactions), that neither **Endpoint** nor a web container offer
    * A JAS furnishes a web interface to inspect the WSDL and to test any @WebMethod
    * An AS includes an RDBMS
    * An AS can contain an arbitrary mix of components
    * AS provide extensive administrative support

## What's Next?
* SOAP vs RESTful
