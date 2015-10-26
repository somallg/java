# Chapter 2 All About WSDLs

## What Good Is a WSDL?
* WSDLs is the service contracts for SOAP-based web service

## Generating Client-Support Code from a WSDL
* *wsimport* generates client-support code or *artifacts* from the service contract, the WSDL document
* $ wsimport -keep -p client http://localhost:9876/ts?wsdl
* -p: specifies the Java package where the generated files are placed
* -keep: the source files should be kept
* If a package is not specified, the default package is the package of the service implementation
* Using -p option to prevents the compiled SEI file from being overwritten by the file generated with the *wsimport*
* If a local copy of WSDL is available, then the command would be:
    * $ wsimport -keep -p client ts.wsdl
* The interface **client.TimeServer** declares the very same methods as the original SEI, **TimeServer**
* The class **client.TimeServerImplService** has a no-argument constructor that constructs the very same **Service** object as the Java client **TimeClient**
* **TimeServerImplServer** encapsulates the **getTimeServerImplPort** method
* Summary to create client:
    * Create a **Service** using one of two constructors in the *wsimport*-generated class
    * Invoke the **get..Port** on the constructed **Service**

## The @WebResult Annotation
* The @WebResult annotates the 2 web service operations, to change the default **return** tag
* There is usually no need for programmer-generated code to use @WebResult

## WSDL Structure
* A WSDL document is a contract between a service and its consumers
* The contract provides critical information as the service endpoint, the service operations, and the data types required for theses operations
* The outermost element (*document* or *root* element) in WSDL is named **definitions**, because WSDL provides definitions grouped into:
    * The **types** sections, provides data type definitions
    * The **message** section, defines the messages that implement the service. The order of the messages indicates the service pattern. An **in** message is to the service, an **out** message is from the service. **in/out** indicates request/response. **out/in** indicates solicit/response
    * The **portType** section presents the service as named operations, **portType** is akin to a Java interface
    * The **binding** section is where the WSDL definitions go from the abstract to the concrete. A WSDL binding is akin to a Java implementation of an interface
        * The transport protocol
        * The **style** of the service, takes either **rpc** or **document** (default)
        * The data format, **literal** or **encoded**
    * The **service** section, specifies one or more endpoints. The **service** section lists one or more **port** elements, a **port** consists of a **portType** (interface) with a corresponding **binding** (implementation)

## A Closer Look at WSDL Bindings
* **document/literal** and **rpc/literal** occur regularly in contemporary SOAP-bases web services
* The **encoded**, though valid in a WSDL, does not comply with WS-I (Web Services-Interoperability) guidelines
* Change to **document**-style, by comment out @SOAPBinding
* $ wsgen -keep -cp . ch02.ts.TimeServerImpl

## Key Features of Document-Style Services
* The **document** style indicates that a SOAP-based web service's underlying messages contain full XML documents 
* The **rpc** style indicates that the underlying SOAP messages contain parameters in the request messages and return values in the response messages
* The **document** style support services with rich, explicitly defined data types, because the service's WSDL can define the required types in an XSD document
* The **use** attribute determines how the service's data types are to be encoded and decoded

## Validating a SOAP Message Against a WSDL's XML Schema
* On the receiving end, a **document**-style SOAP can be validated against the associated XML Schema

## The Wrapped and Unwrapped Document Styles
* The **document** style, provides through the XSD in the WSDL's **types** section, an explicit and precise definition of the data types in the service's underlying SOAP messages
* The **document** style promotes web service interoperability, because the client can determine precisely which data types
* The **rpc** style: web service's operations have names linked directly to the underlying implementations, **@WebMethods**
* The **rpc** style is programmer-friendly
* The wrapped convention, is to give a **document**-style service the look and feel of an **rpc**-style
* Summary of the guidelines for wrapped **document**:
    * The SOAP envelope's body should have only one part, it should contain a single XML element with however many XML sub-elements
    * The relationship between the WSDL's XSD and the single XML element in the SOAP body is well defined
    * The XML elements in the XSD serve as the *wrappers* for the SOAP message body
    * The request wrapper has the same name as the service operation
    * The WSDL **portType** section now has named operations whose messages are *typed*
* By default, a Java SOAP-based web service is wrapped *doc/lit*, ie wrapped **document** style with **literal** encoding

## Amazon's E-Commerce Web Service

## An E-Commerce Client in Wrapped Style

## An E-Commerce Client in Unwrapped Style

## Tradeoffs Between the RPC and Document Styles
* Upsides of **rpc**:
    * WSDL is relatively short and simple (no **types** section)
    * Messages in the WSDL carry the names of the web service operations (@WebMethods)
    * Message throughput may improve because the message do not carry any type-encoding
* Downsides of **rpc**:
    * With no **types** section, does not provide an XSD against which the body of a SOAP message can be validated
    * Cannot use arbitrarily rich data types (no XSD), restricted to simple types
    * Encourages *tight coupling* between the service and the client. **rpc** style has an inherently *synchronous*
    * Java services written in this style may not be consumable in other frameworks
* Upsides of **document**:
    * The body of SOAP message can be validated against the XSD in the **types** section
    * Can use arbitrarily rich data types
    * Great flexibility in how the body of a SOAP message is structured so long as the structured is defined in an XSD
    * The *wrapped* convention
* Downsides of **document**:
    * In the unwrapped variant, the SOAP messages does not carry the name of the service
    * The wrapped variant adds a level of complexity (at API level)
    * The wrapped variant does not support overloaded service operations
    
## An Asynchronous E-Commerce Client

## The wsgen Utility and JAX-B Artifacts
* $ wsgen -keep -cp . ch01.ts.TimeServerImpl
* Produces the artifacts and, if necessary, the package ch01.ts.jaxws
* The **document** style extends typing to the service messages; and typed messages requires the explicit binding of Java and XML Schema Types
* Any **document**-style service, wrapped or unwrapped, has a WSDL with an XSD in its **types** section

## A JAX-B Example
* **@XmlType** and **@XmlRootElement** direct the marshaling of Skier objects
* **@XmlType** indicates that JAX-B should generate an XML Schema type from the Java type
* **@XmlRootElement** indicates that JAX-B should generate an XML *document* (outermost or root) element from the Java class
* Marshaling preserves an object's state in the encoding
* JAX-B marshaling follow standard Java and JavaBean naming conventions
* It is possible to override, with annotations, JavaBean naming conventions
* **@XmlAccessorType(XmlAccessType.FIELD)** indicates that the field will be marshaled and unmarshaled rather than **get/set**
* **XmlRootElement(name = "ABC")** override the default naming conventions
* JAX-B unmarshaling requires that each class have a **public** no-argument constructor, which is used in the construction

## Marshaling and wsgen Artifacts
* **@XMLType** means that SOAP response messages are *typed*

## An Overview of Java Types and XML Schema Types
* Java's primitive types such as **int** and **byte** bind to similarly named XML Schema types, **xsd:int**, **xsd:byte**
* **java.lang.String** binds to **xsd:string**, **java.util.Calendar** binds to each of **xsd:date**, **xsd:time**, **xsd:dateTime**
* A Java web service in **document** rather than **rpc** style has a nonempty **types** section in its WSDL
* This section defines, in the XML Schema language, the types required for the WS
* The JAX-B libraries provide the under-the-hood support to convert between Java and XSD types

## Generating a WSDL with the wsgen Utility
* The *wsgen* utility also can be used to generate a WSDL document for a WS:
* $ wsgen -cp "." -wsdl ch01.ts.TimeServerImpl
* The *wsgen*-generated WSDL does not include the service endpoint, as this URL depends on the actual publication of the service

## WSDL Wrap-UP
* Issues: whether the web service code - SEI and SID - should come before or after the WSDL ? *code first* vs *contract first*
* Limited information that a WSDL provides

## Code First Versus Contract First
* *Code First*:
    * If the service changes, the WSDL automatically changes => WSDL loses some of its appeal for creating client artifacts. One of the first principles of software development is that an interface, once published, should be regarded as immutable
    * *code-first* approach usually results in a service contract that provides few provision for handling tricky by common problems in distributed systems such as partial failure of the service
    * If the service implementation is complicated or even messy, these features carry over into a WSDL that may be difficult to understand and to use in the generation of client artifacts. In short, the *code-first* approach is clearly not consumer-oriented
    * The *code-first* approach seems to go against the *language-neutral* theme of SOAP-based web service. If the contract is done first, the the implementation language remains open
    * The core difficulty for the *contract-first* is real-world programming practice
    
## A Contact-First Example with wsimport
* The *wsimport* utility can be used in support of contract-first approach

## A Code-First, Contract-Aware Approach
* @WebService annotation:
* serviceName = Foo, causes the service artifact to the class named Foo
* name = Bar, causes the **portType** artifact to be the class named Bar
 
## Limitations of the WSDL
* WSDL documents, as web service descriptions, should be publishable and discoverable
* A UDDI (Universal Description Discovery and Integration) is one way to publish WSDLs
* UDDI does not directly support any particular type of service description, including WSDL, instead provides its own type system that accommodates WSDL documents
* In UDDI terms, a WSDL is essentially a two-part document:
    * The first part, comprises the **type** through the **binding**, is the UDDI *service interface*
    * The second part, comprises any **import** directives and the **service** section, is the UDDI *service implementation*
* In WSDL, the service interface and service implementation are two parts of the same document
* In UDDI, the two parts are separate documents
* WSDL does no explain service *semantics*, i.e what the service is about
* WSDL precisely describes what might be called: the name of the service operations, the expected pattern of a service operation
* WSDL typically is useful only if the client programmer already understands

## What's Next?
* SOAP-based web services in Java have two levels:
    * The application level, which consists of the service itself and any Java-based client
    * The handler level, which consists of SOAP message interceptors on either the service or the client side