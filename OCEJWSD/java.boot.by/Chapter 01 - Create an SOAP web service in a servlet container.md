# Chapter 01 - Create an SOAP web service in a servlet container

## 1.1 Create a web service starting from a WSDL file using JAX-WS

### 1.1.1 Use *wsimport* tool to generate artifacts from WSDL
* JAX-WS provides the *wsgen* and *wsimport* command-line tools to generate portable artifacts for JAX-WS web services. When creating JAX-WS web services, you can start with either a WSDL or an Implementation Bean Class

* If you start with an **Implementation Bean Class**, use the *wsgen** to generate all the web services provider artifacts, including a WSDL file

* If you start with a **WSDL file**, use *wsimport* to generate all the WS artifacts for either the service or the client
* The *wsimport* command-line tool processes the WSDL file with schema definitions to generate the portable artifacts, which include the service class, the service endpoint interface class, and the JAXB 2.1 classes for the corresponding XML Schema

* *wsimport* tool generates JAX-WS portable artifacts, such as:
	* Service Endpoint Interface (SEI)
   	* Service
   	* Exception class mapped from *wsdl:fault* (if any)
   	* Async Response Bean derived from response *wsdl:message* (if any)
   	* JAX-B generated value types (mapped Java classes from schema types)

* Syntax:
    * wsimport options wsdl
    * -d [directory] - specify where to place the generated output files
    * -b [path] - specify external JAX-WS or JAX-B binding files or additional schema files (Each file must have its own -b)
    * -B [jaxbOption] - pass this option to JAX-B schema compiler
    * -keep - keep generated source code files (enabled when -s option)
    * -p [package] specify a target package, overrides any WSDL and schema binding customization for package name and the default package name algorithm defined in the spec
    * -s [directory] specify where to place generated source code files (-keep is on with this option)
    * -wsdllocation [location] @WebServiceClient.wsdlLocation value

* Multiple JAX-WS and JAXB binding files can be specified using -b option and they can be used to customize various things like package names, bean names, etc...

* Example: wsimport -p stockquote http://java.boot.by/StockQuote?wsdl

### 1.1.2 Use external and embedded <javaxws:package>, <javaxws:enableWrapperStyle>, <jaxws:class> customizations
* **External Binding Declaration**
	* External binding files are equivalent to embedded binding declarations
	* When *wsimport* processes the WSDL document for which there is an external binding file, it internalizes the binding declarations defined in the external binding file on the nodes in the WSDL document they target using the *wsdlLocation* attribute
	* The embedded binding declarations can exist in a WSDL file and an external binding file targeting that WSDL, but *wsimport* may give an error if, upon embedding the binding declarations defined in the external binding files, the resulting WSDL document contains conflicting binding declarations

* **Embedded Binding Declaration** - follow different rules compared to the binding declarations declared in the external binding file:
	* An embedded binding declaration is specified by using *jaxws:bindings* element as a WSDL extension
	* When a *jaxws:bindings* element is used as a WSDL extension, it must not have a node attribute
	* The binding declaration must not have a child element whose qualified name is *jaxws:bindings*
	* A binding declaration embedded in a WSDL can only affect the WSDL element it extends

* **Package Customization**
    * By default *wsimport* generates WSDL artifacts in a package computed from the WSDL *targetNamespace*
    * To customize the default package mapping you would use *jaxws:package* customization on the *wsdl:definition* node or it can directly appear inside the top level binding element
    * -p option, overrides the *jaxws:package* customization

* **Wrapper Style**
* *wsimport* by default applies wrapper style rules to the abstract operation defined in the *wsdl:portType*
* *jaxws:enableWrapperStyle* can appear on the top level bindings element (with @wsdlLocation attribute), it can also appear on the following target nodes:
    * *wsdl:definitions* global scope, applies to all the wsdl:operations of all wsdl:portType
    * *wsdl:portType* applies to all the wsdl:operations in the portType
    * *wsdl:operation* applies only to this wsdl:operation

* **Class Customization**
* The generated class for *wsdl:portType*, *wsdl:fault*, *soap:headerfault*, and *wsdl:server* can be customized using the *jaxws:class* binding declaration

### 1.1.3 Use JAX-B customizations to configure mapping
* *Inline Customizations*:
    * Customizations to JAX-B bindings made by means of inline binding declarations in an XML schema take the form of <xsd:appinfo> elements embedded in schema <xsd:annotation> elements (xsd: XML schema namespace prefix)
    * Customizations are applied at the location at which they declared in the schema
    * XML Schema namespace prefix must be used with the *annotation* and *appinfo* declaration tags
    
* *External Binding Customization Files*:
    * Customizations to JAX-B bindings made by means of an external file containing binding declarations
    * schemaLocation is a URI reference to the remote schema
    * node is an XPath 1.0 expression that identifies the schema node within schemaLocation to which the given binding deceleration is associated

### 1.1.4 Build the web service implementation using the above artifacts

### 1.1.5 Access MessageContext.SERVLET_CONTEXT from the injected @WebServiceContext
* *javax.xml.ws.WebServiceContext* - interface make it possible for an endpoint implementation object and potentially any other objects that share its execution context to access information pertaining to the request being served
* The resource injection denoted by the *WebServiceContext* annotation is REQUIRED to take place only when the annotated class is an Endpoint Implementation Class
* The @javax.annotation.Resource defined by JSR-250 is used to request injection of the WebServiceContext

### 1.1.6 Configure deployment descriptors (web.xml, webservices.xml) for URL patterns, HTTP security, container authorization, caller authentication, and message protection. JAX-WS runtime may also be configured to perform message layer authentication and protection

* **URL patterns**
* The *web.xml* file contains information about the structure and external dependencies of web components in the module and describes how the components are used at run time. For JAX-WS (Java API for XML-Based Web Services) applications, you can customize the URL pattern in the web.xml file
* When you package a JAX-WS application as a web service, the web service is contained with a Web ARchive (WAR) file or a WAR module within an Enterprise Archive (EAR) file. A JAX-WS enabled WAR file contains the following items:
    * WEB-INF/web.xml configuration and deployment information for the web components that comprise a web application
    * Annotated classes that implement the WS contained in the application module including the service endpoint implementation class
    * JAX-B classes
    * (Optional) WSDL document that describe the web services contained in the application module
    * (Optional) XML schema files
    * (Optional) Utility classes
    * (Optional) WS client
* The default URL pattern is defined by the @WebService.serviceName attribute that is contained in the Service Implementation class
* When the WSDL file that is associated with the Service Implementation Class contains a single port definitions, you can choose to use the default URL pattern or you can customize the URL pattern with web.xml file
* If the WSDL file is associated with the Service Implementation Class contains multiple port definitions within the same service definition, customized URL patterns is required. Each port maps to a web service implementation class and to its own custom URL pattern. By customizing the URL pattern in the web.xml, you correct conflicting URL pattern definitions:
    * Determine if custom URL patterns are required or desired. Custom URL patterns are only required when the WSDL file for you JAX-WS WS contains multiple port definitions with a single service
    * Edit web.xml file and provide a *servlet* and corresponding *servlet-mapping* entry for each JAX-WS WS Implementation class. You must define *url-pattern* value within the *servlet-mapping* entry

* **Basic Authentication with JAX-WS**
* When a service that is constrained by HTTP basic authentication is requested, the server requests a username and password from the client and verifies that the username and password are valid by comparing them again a database of authorized users
    * **Annotating the Service**: *@RolesAllowed** annotation specifies that only users in the role will be allow to access the annotated method. @RolesAllowed implicitly declares a role that will be referenced in the application
    * **Adding Security Elements to the Deployment Descriptor**: to enable basic authentication for the service, add security elements to the web.xml, *security-constraint* and *login-config*
    * **Linking Roles to Groups**: add *security-role-mapping* to web.xml
    * **Client**: Cast the port to a BindingProvider, then add username and password to getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "abc")
    * JAX-WS expects at runtime the lookup keys for the username and password to be the string:
        * javax.xml.ws.security.auth.username
        * javax.xml.ws.security.auth.password
    * These are the value of the BindingProvider.USERNAME_PROPERTY and PASSWORD_PROPERTY, repoectively

### 1.1.7 Compile and package the web service into a WAR file

### 1.1.8 Deploy the WS into a JEE Servlet Container

## 1.2 Create a web service starting from a WSDL file using JAX-WS

### 1.2.1 Use @WebService to indicate a service
* Use *@WebService* and *@WebMethod* annotations on a SEI to specify Java methods that you want to expose as Java API for XML-Based Web Services (JAX-WS) web services
* JAX-WS technology enables the implementation of WS based on both the standard SEI and a *Provider* Interface. When developing a JAX-WS WS starting from existing Java classes (ie bottom-up approach) you must annotate the class with either *@WebService* or *@WebServiceProvider* to define the class as a WS
* Using the *Provider* interface is the dynamic approach to defining your JAX-WS services. To use the *Provider* interface, your class must implement the *javax.xml.ws.Provider* interface, and contain the *@WebServiceProvider* annotation. The *Provider* interface, has one method, *invoke*, which uses generics to control both the input and output types
* To describe your WS using the SEI approach, initially define a WS, annotate the Java class with *@WebService*. You can then select the individual methods with *@WebMethod* to control how these methods are exposed as WS operations
* *@javax.jws.WebService* marks a Java class as implementing a WS, or a Java interface as defining a WS interface:
    * *name*: the name of the WS. Used as the name of *wsdl:portType* when mapped to WSDL 1.1. Default: the simple name of the Java class or interface
    * *targetNamespace*: the XML namespace used for the WSDL and XML elements generated from this WS. Default: implementation-defined, as described in JAX-RPC 1.1. Typically derived from the package containing the WS
    * *serviceName*: The service name of the WS. Used as the name of *wsdl:service*. Not allowed on interfaces. Default: The simple name of the Java class + "Service"
    * *wsdlLocation*: the location of a pre-defined WSDL describing the service. The presence of a wsdlLocation value indicates that the SIB is implementing a predefined WSDL contract. The JSR-181 tool MUST instead provide feedback if the service implementation bean is inconsistent with the *portType* and bindings declared in this WSDL
    * *endpointInterface*: the complete name of the SEI defining the service's abstract WS contract. This annotation allows the developer to separate the interface contract from the implementation. If this annotation is present, the service endpoint interface is used to determine the abstract WSDL contract (*portType* and *bindings*). Default: None. The WS contract is generated from annotations on the service implementation bean
    * *portName*: the port name of the WS, used as the name of *wsdl:port*. Default: @WebService.name + "Port"
    
* Best practices for defining WS:
    * To define a basic WS, annotate the Java class with *@WebService* annotation
    * To define your WS using an explicit SEI, add the *@WebService* to a Java implementation class and explicitly reference a Java interface using *@WebService.endpointInterface* attribute
    * To define your WS using an implicit SEI, add *@WebService* to a Java implementation class and do not define the *@WebService.endpointInterface*
    * Provide a reference to a WSDL file in the *@WebService.wsdlLocation* attribute. By specifying a pre-defined WSDL, the performance is improved. Additionally, any discrepancies between the WSDL file and the annotations are reported to you by the runtime environment
    * When you use an explicit SEI, all public methods in the SEI and inherited classes are always exposed. You only need to add *@WebMethod* annotations if you want to further customize the methods that are already exposed
    * If you define an implicit SEI, follow these rules to ensure that your methods are exposed consistency:
        * Add an *@WebService* annotation to your implementation class and all its superclasses that contain methods that you want to expose. Adding an *@WebService* to a class exposes all public methods in that class
        * If you want more granular control and expose only certain methods from a class that is annotated with *@WebService*, you can use the *@WebMethod* on selected individual. *@WebMethod(exclude=true)* attribute is one of the criteria that is used to determine whether a method is exposed as an operation

### 1.2.2 Use @WebMethod, @WebMethod(exclude) to indicate service methods
* *@javax.jws.WebMethod* customizes a method that is exposed as a WS operation
* *@WebMethod* includes the following member-value pairs:
    * *operationName*: name of the *wsdl:operation* matching this method. The name of the Java method
    * *action*: the action for this operation. For SOAP bindings, this determines the value of the *SOAPAction* header
    * *exclude*: marks a method to NOT be exposed. Used to stop an inherited method from being exposed as part of this WS. If this element is specified, other elements MUST NOT be specified for the @WebMethod. This is NOT allowed on SEI. Default value is *false*
    
* Using *NEW* interpretation, a method in an implicit SEI and its superclasses are only exposed under the following conditions:
    * The method has an @WebMethod or @WebMethod(exclude=false)
    * The method has no @WebMethod, but the containing class has an @WebService
* Using *LEGACY* interpretation, a method in an implicit SEI and its superclasses are only exposed under the following conditions:
    * The method has an @WebMethod or @WebMethod(exclude=false) and the containing class has an @WebService
    * The method has no @WebMethod, but the containing class has @WebService and no other methods have @WebMethod or @WebMethod(exclude=false)

### 1.2.3 Use @SOAPBinding to select doc/lit, doc/bare, rpc/lit style of web service
* *@javax.jws.soap.SOAPBinding* specifies the mapping of the WS onto the SOAP message protocol. The *SOAPBinding* has a target of *TYPE* and *METHOD*. This annotation may be placed on a method if and only if SOAPBinding.style is *DOCUMENT*. Implementations MUST report an error if the *SOAPBinding* annotation is placed on a method with a *SOAPBinding.style* of RPC
* *@SOAPBinding* includes the following member-value pairs:
    * *style*: defines the encoding style for messages send to and from the WS, *DOCUMENT* or *RPC*. Default *DOCUMENT*
    * *use*: defines the formatting style for message send to and form the WS, *LITERAL* or *ENCODED*. Default *LITERAL*
    * *parameterStyle*: determines whether method parameters represent the entire message body, or are wrapped inside a top-level named after the operation. *WRAPPED* default

### 1.2.4 Use @Oneway where the service doesn't have any response
* *@javax.jws.Oneway* indicates that the given web method has only an input message and no output
* Typically, a oneway method returns the thread of control to the calling application prior to executing the actual business method
* A JSR-181 processor is REQUIRED to report an error if an application marked *@Oneway* has a return value, declares any checked exceptions or has any INOUT or OUT parameters

### 1.2.5 Use @WebParam, and @WebResult to customize parameter and operation names
* **WebParam**
* *@javax.jws.WebParam* annotation customizes the mapping of an individual parameter to a WS message part and XML element
    * *name*: name of the parameter
    * *partName*: the name of the *wsdl:part* representing this parameter
    * *targetNamespace*: the XML namespace for the parameter
    * *mode*: the direction in which the parameter is flowing. One of IN, OUT, or INOUT
    * *header*: if true, the parameter is pulled from a message header rather then the message body

* **WebResult**
* Use *@javax.jws.WebResult* to map to an existing *wsdl:output* or to customize how it's generated:
    * *name*: name of return value
    * *partName*: the name of the wsdl:part representing this return value
    * *targetNamespace*: the XML namespace for the return value
    * *header*: if true, the parameter is in the message header rather than the message body
    
### 1.2.6 Use checked exceptions to indicate service specific faults
    
### 1.2.7 Use wsgen tool to generate artifacts in Java EE6

### 1.2.8 Configure deployment descriptors (web.xml, webservices.xml) for URL patterns, HTTP security, container authorization, caller authentication, and message protection. JAX-WS runtime may also be configured to perform message layer authentication and protection

### 1.2.9 Compile and package the web service into a WAR file

### 1.2.10 Deploy the WS into a JEE servlet container