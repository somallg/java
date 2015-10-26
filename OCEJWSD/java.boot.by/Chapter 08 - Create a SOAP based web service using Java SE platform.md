# Chapter 08 - Create a SOAP based web service using Java SE platform

## 8.1 Create a web service starting from a WSDL file using JAX-WS

### 8.1.1 Use wsimport tool to generate artifacts and use customization files for wsimports if needed
* The *wsimport* command-line tool processes an existing Web Services Description Language (WSDL) file and generates the required portable artifacts for developing Java API for XML-Based Web Services (JAX-WS) web service applications

* The *wsimport* command-line tool supports the top-down approach to developing JAX-WS web services. When you start with an existing WSDL file, use the *wsimport* command-line tool to generate the required JAX-WS portable artifacts

* The *wsimport* tool reads an existing WSDL file and generates the following portable artifacts:
    * Service Endpoint Interface (SEI) - The SEI is the annotated Java representation of the WSDL file for the web service. This interface is used for implementating JavaBeans endpoints or creating dynamic proxy client instances
    * *javax.xml.ws.Service* extension class - This is a generated class that extends the *javax.xml.ws.Service*. This class is used to configure and create both dynamic proxy and dispatch instances
    * Java Architecture for XML Binding (JAXB) beans that are required to model the web service data
    * Exception class mappeed from *wsdl:fault* (if any)
    * Async Response Bean derived from response *wsdl:message* (if any)

* Syntax:
* wsimport options wsdl
* -d *directory*
* -b *path*
* -keep
* -p
* -s *directory
* -wsdllocation *location*

### 8.1.2 Build the web service implementation using the above artifacts
* For SOAP-based services, the WSDL represents the contract. This model has a single overarching paradigm: the WSDL defines the primary features of the contract for the service, and implementation-independent contracts are one of the cornerstone necessities of SOA
* The contract is not an afterthought, but rather a central concern
* With this model, you write the WSDL yourself by hand, generate a Java code shell for the service implementation, and then fill in the business logic for the service implementation. This method is alo sometimes referred to as "Contract First"

* You start by taking a pre-existing abstract WSDL and pointing it to a tool such as *wsimport* that produces a service endpoint interface in addition to Java classes that represent the schema difinitions and message parts specified in the WSDL
* Once the endpoint interface has been generated, write a Java class that implements that interface
* The basic steps are as follows:
    * Write a WSDL representing the service you want to deploy
    * Generate client-side code using *wsimport*. Among other things, this will generate a service interface for each *portType*
    * Implement each interface by writing your web service impelementation class
    * Deploy the service endpoint implementation to a JAX-WS compatible container

* On a practical level, your organization might benefit from having a published WSDL released early in the project, so that client and server-side development teams can work independently
* Another key benefit to starting from WSDL is that XML Schema affords a far richer set of data types than many programming languages. Starting from WSDL, you can offer a set of type options, maximizing interoperability

### 8.1.3 Use Endpoint API to configure and deploy it in Java SE 6 Platform
* The *Endpoint* class can be used to create and publish web service endpoints

* An endpoint consists of an object that acts as the web service implementation (called here implementor) plus some configuration information, e.g a *Binding*
* Implementor and binding are set when the endpoint is created and cannot be modified later
* Their values can be retrieved using the *getImplementor* and *getBinding* methods
* Other configuration information maybe set at any time after the creating of an *Endpoint* but before its publication

* Endpoints can be created using the following static methods en *Endpoint*
    * *create(Object implementor)* - creates and returns an *Endpoint* for the specified implementor
    * *create(Object implementor, WebServiceFeature... features)* - same as the above *create()* method. The created *Endpoint* is configured with the web service features
    * *create(String bindingID, Object implementor, WebServiceFeature... features)*
    * *publish(String address, Object implementor)* - creates and publishes an *Endpoint* for the given implementor. The binding is chosen by default based on the URL scheme of the provided address (which must be a URL)
    * *publish(String address, Object implementor, WebServiceFeature... features)* - same as the above *publish()* method

* An *Endpoint* is in one of the three states: not published (default), published or stopped
* Published endpoints are active and capable of receiving incoming requests and dispatching them to their implementor
* Non published endpoints are inactive
* Stopped endpoint were in the published until some time ago, then got stopped
* Stopped endpoint cannot be published again

* Publication of an *Endpoint* can be archieved by invoking one of the following methods:
    * *publish(String address)*
    * *publish(Object serverContext)*

## 8.2 Create a web service starting from a Java source using JAX-WS

### 8.2.1 Use wsgen tool to generate artifacts in Java EE 5 (optional in Java EE 6 - as artifacts are generated at runtime)
* The *wsgen* command line tool generates the neccessary portable artifacts required for Java API for XML Web Services (JAX-WS) applications when starting from Java code
* This tool will generate the WSDL file only when requested

* When using a bottom-up approach to develop JAX-WS web services and you are starting from a service endpoint implementation, use the *wsgen* tool to generate the required JAX-WS portable artifacts

* The *wsgen* tool accepts a properly annotated service endoint implementation using the *@WebService* annotation as input and generates the following portable artifacts:
    * Any additional Java Architecture for XML Binding (JAXB) classes that are required to marshal and unmarshal the message contents
    * A WSDL file if the option -wsdl argument is specified. The *wsgen* does not automatically generate the WSDL file

* The command line syntax is:
* wsgen options service_implementation_class

* The *service_implementation_class* name is the only paramter that is required
* The following parameters are optional:
    * -classpath *path*
    * -cp *path*
    * -d *directory* - specifies where to place the genereated output files
    * -extension - specifies whether to allow custom extensions for functionality not specified by the JAX-WS spec
    * -keep - specifies whether to keep the generated source files
    * -r *directory* - specifies where to place the generated WSDL file
    * -s *directory* - specifies the directory to place the generated source files
    * -wsdl *:protocol*
    * -servicename *name* - specifies a *wsdl:service* name to be generated in the WSDL file
    * -portname - specifies *wsdl:port* name to be generated in the WSDL file

* Note that you must run *wsgen* against Java class that has already been compiled (not against the source), and if you specify a directory in which the tool should place genereated files such as WSDL, that directory must exist before you run the command
* You must run the tool against an implementation class, not an interface

### 8.2.2 Use Endpoint API to configure and deploy it in Java SE 6 Platform
