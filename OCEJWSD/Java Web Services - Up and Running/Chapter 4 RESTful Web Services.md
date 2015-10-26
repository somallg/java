# Chapter 4 - RESTful Web Services

## What Is REST?
* SOAP is a messaging protocol, whereas REST is a style of software architecture for distributed hypermedia systems
* In the Web, HTTP is both a transport protocol and a messaging system because HTTP request and responses are messages
* REST stands for *REpresentation State Transfer*, the central abstraction in REST is the *resource*
* A resource in the RESTful sense is anything that has an URI
* In practice, a resource is an informational item that has hyperlinks to it, hyperlink use URIs to do the linking
* POST: *Create a new resource from the request data*
* GET: *Read a resource*
* PUT: *Update a resource from the request data*
* DELETE: *Delete a resource*
* A ke guiding principle of the RESTful style is to respect the original meanings of the HTTP verbs
* The RESTful approach tries to simplify matters by taking what HTTP, with its MIME type system, already offers: built-int CRUD operations, URI, and typed representations that can capture a resource's state
* RESTful approach keeps the complexity out of the transport level, as a resource representation is transferred to the client as the body of an HTTP response message
* SOAP requires messages with messages, whereas REST does not

## Verbs and Opaque Nouns
* A URI is an opaque identifier, a logically proper ame that denotes exactly one resource
* In RESTful services, URIs act as identifying nouns and HTTP method act as verbs

## From @WebService to @WebServiceProvider
* @WebService annotation signals that the messages exchanged between the service and its clients will be SOAP envelopes
* @WebServiceProvider signals that the exchanged messages will be XML documents of some type

## A RESTful Version of the Teams Service

## The WebServiceProvider Annotation
* @ServiceMode(value = javax.xml.ws.Service.Mode.MESSAGE)
* @BindingType(value = HTTPBinding.HTTP_BINDING)

## Language Transparency and RESTful Services

## Summary of the RESTful Features

## Implementing the Remaining CRUD Operations

## Java API for XML Processing
* Use JAX-P (Java API for XML-Processing) to parse data

## The Provider and Dispatch Twins
* A RESTful **Provider**  implements the method: public Source invoke(Source request)
* A **Dispatch** object, sometimes described as a *dynamic service proxy*, provides an implementation of this method on the client side
* The **Dispatch** to **Provider** relationship supports a natural exchange of XML documents between client and service:
    * Then client invokes the **Dispatch** method **invoke**, with an XML document as the **Source** argument
    * The service-side runtime dispatches the client request to the **Provider** method **invoke** whose **Source** argument corresponds to the client-side **Source**
    * The service transforms the **Source** into some appropriate **Result**
    * The **Dispatch** method **invoke** returns a **Source**, send from the service, that the client then transforms into an appropriate **Result**

## A Provider/Dispatch Example
* See code

## More on the Dispatch Interface

## A Dispatch Client Against A SOAP-based Service
* The **Dispatch** client is flexible it may be used to issue request against any service, REST-style or SOAP-based

## Implementing RESTful Web Services As HttpServlets
* The class **HttpServlet** extends the class **GenericServlet**, in turn implements the **Servlet** interface
* All three are in the package **javax.servlet**
* The **Servlet** interface declares five methods, the most important is the **service** method that a web container invokes on every request to a servlet
* The **service** method has a **ServletRequest** and a **ServletResponse** parameter
* The request is a map that contains the request information from a client, and the response provides a network connection back to the client
* The service parameters in **HttpServlet** have the types **HttpServletRequest** and **HttpServletResponse**
* The **HttpServlet** also provides request filtering:the service method dispatches an incoming GET request to the method **doGet**, an incoming POST request to the method **doPost**
* In the **HttpServlet** class, the **do** methods are no-ops
* **HttpServlet** are a natural, convenient way to implements RESTful web services for two reasons:
    * First, such servlets provide method such as **doGet** and **doPost** that match up with HTTP verbs
    * **HttpServletRequest** and **HttpServletResponse** are the same two arguments to every **do** method, which encourages a uniform pattern of request processing

## The RabbitCounterServlet
* See code

## Java Clients Against Real-World RESTful Services
* There are many RESTful services available from well-know players such as Yahoo!, Amazon, and eBay

## The Yahoo! News Service

## WADLing with Java-Based RESTful Services
* In SOAP-based WS, WSDL document is a blessing to programmers because this service contact can be used to generate client-side artifacts
* WALD (Web Application Description Language)

## JAX-RS: WADLing Through Jersey
* JAX-RS (Java API for XML-RESTful Web Services)
* The **@Path** annotation right above the class declaration is used to decouple the resource from any particular base URL
* @GET, @POST, @DELETE specify the appropriate HTTP verb for a particular service operation
* @Produces specifies the MIME type of the response 
* The @ class could be put in a WAR file and deployed in a servlet container such as Tomcat
* However, there is a quick way to publish a Jersey service through GrizzlyWebContainerFactory

## The Restlet Framework
* A Restlet is a RESTful alternative to the traditional Java servlet

## What's Next?
* Security