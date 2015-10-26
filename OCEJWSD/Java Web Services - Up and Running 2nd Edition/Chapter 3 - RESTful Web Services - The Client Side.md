# Chapter 3 - RESTful Web Services - The Client Side
* Consider a familiar scenario in which a client access a RESTful web service:
    * The client issues a GET request against a RESTful service. In general, a request to a RESTful service targets a named resource, with a URI as the name
    * If successful, this GET request results in a response document, a representation of the resource targeted in the request. The document is usually in XML or JSON, although other formats might be available. In any case, the response should be MIME-typed
    * The client extracts from the document whatever information is required for the client's application logic
    
## 3.1 A Perl Client Against a Java RESTful Web Service

## 3.2 A Client Against the Amazon E-Commerce Service

## 3.3 A Standalone JAX-B Example

## 3.4 The XStream Option

## 3.5 RESTful Clients and WADL Documents
* At the core of a SOAP-based service is the *service contract*, a WSDL document

* JAX-RS implementations such as Metro do provide a WSDL counterpart, the WADL document that describes a JAX-RS service and can be used to generate client-side code

## 3.6 The JAX-RS Client API

## 3.7 JSON for JavaScript Clients

## 3.8 What's Next?
* SOAP-based services delivered over HTTP(s), which can be viewed as special case of RESTful services
* The normal request and response payloads in a SOAP-based service are SOAP *envelopes*, XML documents whose root element has tag with Envelope as the local name
* In a typical SOAP-based exchange, a client sends an Envelope to a service and gets an Envelope in return
* SOAP, like XML in general, is programming-language neutral, and any language with the appropriate libraries can support SOAP-based services and clients