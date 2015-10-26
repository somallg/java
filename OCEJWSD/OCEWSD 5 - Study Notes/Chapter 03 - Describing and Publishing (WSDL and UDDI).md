# Chapter 3. Describing and Publishing (WSDL and UDDI)

## 3.1 WSDL in Web Services
* Objective: Explain the use of WSDL in Web Services, including a description of WSDL's basic elements, binding mechanisms and the basic WSDL operation types as limited by the WS-I Basic Profile 1.1

* WSDL 1.1

* **Use of WSDL in Web Services**
* What? Web Service Description Language is an XML-based language for describing web services
* A WSDL document is an XML document that adheres to the WSDL XML Schema
* Such a document can contain definitions of the following things related to a web service:
    * Types - allows for custom data type definitions
    * Message - defining the data being sent to, and received from, the web service
    * Operation - defines one abstract operation supplied by the web service
    * Port Type - defines the interface, consisting of one or more operations, of a web service
    * Binding - specifies the protocol and data format to be used by a particular port type
    * Port - defines a web service endpoint by assigning a network address
    * Service - group of one ore more web service endpoint(s)

* **WSDL's Basic Elements**
* A WSDL document contains these important elements:
    * definitions - root element of the WSDL document
    * import - import WSDL definitions from other WSDL documents
    * types - using XML schema languages, custom type are defined and are used to describe the messages exchanged
    * message - describes the contents of messages: XML schema built-in types, complex types, types defined in the <types> elements, type defined external
    * operation - describes the abstract interface of a single operation of a web service: function name
    * portType - describes the abstract interface of the web service: method names, input, output
    * binding - assigns protocols and encoding styles to methods and payloads of methods
    * service - assign an internet address to a web service

* **The <definitions> Elements**
* Root element of the WSDL document
* Optional *name* attribute specifies the name of WSDL document
* WSDL 1.1 XML schema namespace is http://schema.xmlsoap.org/wsdl/

* **The <import> Element**
* Import the definitions from a specified namespace in another WSDL into the current WSDL document
* Can be used to separate abstract definitions, such as <types>, <messages> and <portType>, from concrete definitions, such as those in the <binding>, <service>
* Can be used to assemble multiple WSDL documents, describing different web services, into one document describing all of the web services

* Must declare *namespace* attribute, which value must match the namespace declared in the imported WSDL
* Must also declare a *location* attribute, which cannot be empty or null, that must point to an actual WSDL

* **Basic Profile on WSDL and Schema Import**
* A WSDL description must only use the WSDL <import> to import other descriptions
* The XML <import> element must be used to import XML Schema definitions
* The *namespace* attribute in a WSDL <import> must not be a relative URI
* The root element of documents imported using the XML <import> must be the <schema> element

* **The <types> Element
* Declares additional types that are used by message definitions when declaring the parts (payload) of the messages

* **The <message> Element**
* Payload of message sent/returned to/from web service
* Contents of SOAP header blocks
* Contents of <detail> element of SOAP faults

* **The <portType> and <operation> Elements
* Abstract interface of the web service is defined in the <portType> element
* WSDL document can have one or more <portType> elements, each defining an interface of a different web service
* Each <operation> in a <portType> corresponds to a method in the interface of the web service
* Each <operation> defines an RPC or Document style
* Each <operation> may have at most one <input> and at most one <output> element and any number of <fault> elements
* If an <operation> is declared with one single <input> and one single <output>, then it uses the request-response message exchange pattern. Such an <operation> may additionally declare zero ore more <fault> elements
* If an <operation> is declared with one single <input> and no <output> element, then it uses the one-way message exchange pattern. Such an operation may not declare any <fault> elements
* The *name* attribute of <input> and <output> elements within an <operation> are to be unique among all <input> and <output> elements within the <portType>

* **Basic Profile on the <portType> and <operation> Elements
* Neither the Notification nor the Solicit/Response message exchange patterns may be used in a WSDL <portType> definition in a WSDL document
* All WSDL <operation> elements in a WSDL <portType> element must have names that are unique within that <portType>

* **The <binding> Element**
* Specifies the following for an abstract interface of a web service (<portType> and <operation>):
    * Concrete protocols to use, such as HTTP and SOAP
    * The message style (RPC or Document)
    * The encoding style (Literal or SOAP Encoding)

* The <binding> element has two attributes:
    * The *name* attribute defines the name of the binding
    * The *type* attribute specifies which abstract web service interface, defined in a <portType> element, the binding applies to

* **The <soapbind:fault> Element**
* In order to specify the encoding for fault, <soapbind:fault> elements are to be declared in the corresponding <operation> element in the <binding> element

* **The <soapbind:header> Element**
* Specify header blocks is accomplished by using the <soapbind:header> element

* **the <service> and <port> Elements**
* A <port> element assigns an URL to a <binding>
* Two, or more, <port> elements may assign different URLs to the same binding, which may be useful for load balancing or fail over

* **WSDL Binding Mechanisms**

## 3.2 WSDL Abstract vs Concrete
* A WSDL document can be split in three different parts:
    * Data type definitions
    * Message definitions and the abstract interfaces
    * Specific service binding

## 3.3 WSDL Component Model