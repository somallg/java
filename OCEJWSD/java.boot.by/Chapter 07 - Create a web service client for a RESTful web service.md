# Chapter 07 - Create a web service client for a RESTful web service

## 7.1 Use a browser to access a JAX-RS resource

## 7.2 Use the java.net APIs to access a JAX-RS resource
* **Reading from a URLConnection**

* **Writing to a URLConnection**
* Writing to a URL is often called posting to a URL. The server recognizes the POST request and reads the data sent from the client

## 7.3 Use java.net.Authenticator to access a secure JAX-RS resource
* *java.net.Authenticator*
* The class *Authenticator* represents an object that knows how to obtain authentication for a network connection. Usually, it will do this by prompting the user for information

* Application use this class by overriding *getPasswordAuthentication()* in a sub-class
* An instance of this concrete sub-class is then registered with the system by calling *setDefault(Authenticator)*

## 7.4 Use Ajax to access a JAX-RS resource
* Because RESTful web services deployed are exposed using the standard HTTP protocol and methods, they can be easily accessed from browsers
* In addition to using simple GET and POST requests, developers can leverage the capabilities of the JavaScript technology *XMLHttpRequest* object that most modern browser support

## 7.5 Use the Jersey client API to access a JAX-RS resource
* The Jersey client API is a high-level Java based API for interoperating with RESTful Web services
* It makes it very easy to interoperate with RESTful Web services and enables a developer to concisely and efficiently implement a reusable client-side solution that leverages existing and well established client-side HTTP implementations

* The Jersey client API can be utilized to interoperate with any RESTful Web service, implemented using one of many frameworks, and is not restricted to services implemented using JAX-RS
* However, developers familiar with JAX-RS shoudl find the Jersy client API complementary to their services, especially if the client API is utilized by those services themselves, or to test those services

* The goals of the Jersey client API are threefold:
    * Encapsulate the key constraint of the REST architectural style, namely the Uniform Interface Constraint and associated data elements, as client-side Java artifacts
    * Make it as easy to interoperate with RESTfull Web services as JAX-RS makes it eaasy to build RESTful Web services
    * Leverage artifacts of the JAX-RS API for the client side. Note that JAX-RS is currently a server-side only API

* The Jersey Client API supports a pluggable architecture to enable the use of different underlying HTTP client implementations
* Two such implementations are supported and leveraged:
    * The Http(s) *URLConnection* classes supplied with the JDK
    * The Apache HTTP client

* *Uniform Interface Constraint*
* The uniform interface constraint bounds the architecture of RESTful web services so that a client, such as a browser, can utilize the same interface to communicate with any service
* This is a very powerful concept in software engineering that makes Web-based search engines and service mash-ups possible
* It induces properties such as:
    * Simplicity, the architecture is easier to understand and maintain
    * Modifiability or loose coupling, clients and services can evolve over time perhaps in new and unexpected ways, while reatining backwards compatibility
* Further constraints are required:
    * Every resource is identified by a URI
    * A client interacts with the resource via HTTP requests and responses using a fixed set of HTTP methods
    * One or more representations can be returned and are indentified by media types
    * The contents of which can link to further resources

* The above process repeated over and again should be familiar to anyone who has used a browser to fill in HTML forms and follow links
* The same process is applicable to non-browser based clients

* Many existing Java-bsed clients APIs, such as the Apache HTTP client API or *java.net.HttpURLConnection* supplied with the JDK place too much focus on the Client-Server constraint for the exchanges of request and responses rather than a resource, identified by a URI, and the use of a fixed set of HTTP methods

* A resource in the Jersey client API is an instance of the Java class *WebResource*, and encapsulates a URI
* The fixed set of HTTP methods are methods on *WebResource* or if using the builder pattern are the last methods to be called when invoking an HTTP method on a resource
* The representations are Java types, instances of which, may contain links that new instances of *WebResource* may be created from

* *Ease of use and reusing JAX-RS artifacts*
* Since a resource is represented as a Java type it makes it easy to configure, pass around and inject in ways that is not so intuitive or possible with other client-side APIs
* The Jersey Client API reuses many aspects of the JAX-RS and the Jersey Implementation such as:
    * URI building using *UriBuilder* and *UriTemplate* to safely build URIs;
    * Supports for Java types of representations sich as *byte[]*, *String*, *InputStream*, *File*, *DataSource* and JAXB beans in addition to Jersey specific features such as JSON support and MIME Multipart support
    * Using the builder pattern to make it easier to construct requests

* Some APIs, like the Apache HTTP client or *java.net.HttpURLConnection*, can be rather hard to use and/or require too much code to do something relatively simple

* This is why the Jersey Client API provides support for wrapping *HttpURLConnection* and the Apache HTTP client. Thus it is possible to get the benefits of the established implementations and features while getting the ease of use benefit

* It is not intuitive to send POST request with form parameters and receive a response as a JAXB object with such an API

* *Overview of the API*
* To utilize the client API it is first necessary to create an instance of a *Client*
* The client instance can then be configured by setting properties on the map returned from the *getProperties* methods or by calling the specific setter methods
* Once a client instance is created and configured it is then possible to obtain a *WebResource* instance, which will inherit the configuration declared on the client instance
* *Client* instances are expensive resources. It is recommended a configured instance is reused for the creation of Web resouces
* The creation of Web resources, the building of requests and receiving of responses are guaranteed to be thread safe
* Thus a *Client* insatnce and *WebResource* instances may be shared between multiple thread

* If response meta-data is required then the Java type *ClientResponse* can be declared from which the response status, headers and entity may be obtained

* *Adding support for new representations*
* The support for new application-defined representations as Java types requires the implementation of the same provider-based interfaces as for the server side JAX-RS API, namely *MessageBodyReader* and *MessageBodyWriter*, respectively, for request and response entities

* Classes or implementations of the provider-based interfaces need to be registered with a *ClientConfig* and passed to the *Client* for creation

## 7.6 Use the JAX-WS HTTP binding to access a JAX-RS resource
* JAX-WS enables a client to consume RESTful web services programmatically
* The main API is the *javax.xml.ws.Dispatch* interface

* Once you specify the address of the service, you pass it into the *Service.addPort* along with the *HTTPBidnging* constant instead of the SOAP binding you use with SOAP messages
* Then use the request context you get from the *Dispatch* to indicate that you are using the HTTP method
* The runtim will use the properties in this map to help it create proper request and send it off

* The typed *Dispatch<T>* interface and the *invoke* method can accept and return four major datatypes:
    * *Dispatch<java.xml.transform.Source>* - *Source* object are low level objects that hold XML document. Each *Source* implementation provides methods that access the stored XML documents and manipulate its contents
    * *Dispatch<javax.xml.soap.SOAPMessage>* - when using SOAP binding
    * *Dispatch<javax.activation.DataSource>* - when using HTTP binding
    * *Dispatch<Object>* - intented to be low-level API that allow you to work with raw messages, they also allow you to work with JAXB objects. To work with JAXB object a *Dispatch* must be passed a *JAXBContext* that knows how to marshal and unmarshal the JAXB objects in use
