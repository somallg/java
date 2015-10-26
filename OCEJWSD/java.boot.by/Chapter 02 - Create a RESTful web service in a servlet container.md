# Chapter 02 - Create a RESTful WS in a servlet container

## 2.1 Create a WS using JAX-RS, refer to Jersey implementation for examples

### 2.1.1 Annotate a class with a @Path annotation to respond to URI templates

### 2.1.2 Annotate the class's method to respond to HTTP request using the corresponding JAX-RS annotation (@GET, @POST, etc.).

### 2.1.3 Use the JAX-RES @Consumes and @Produces annotations to specify the input and output formats for the RESTful WB

### 2.1.4 Use @PathParam, @QueryParam, @MatrixParam and @HeaderParam to extract request data
* *@javax.ws.rs.PathParam*
    * Allows you to inject the value of named URI path parameters that were defined in *@Path* expressions
    * JAX-RS runtime automatically converts the value to an *int* before it invokes the method. If the URI path parameter cannot be converted to an integer, the request is consider a client error and the client will receive an HTTP 404, "Not Found" status code from the server
* *@javax.ws.rs.QueryParam*
    * Allows you to inject individual URL query parameters into your Java parameters
    * As with other annotation injection, JAX-RS runtime automatically converts the query parameter's string into an integer
* *@javax.ws.rs.MatrixParam*
    * Extracts information from URL path segments
* *@javax.ws.rs.HeaderParam*
    * Used to inject HTTP request header values

### 2.1.5 Use the *UriInfo* and *UriBuilder* to create URIs that refer to resources in the service
* A very important aspects of REST is hyperlinks, URIs, in representations that clients can use to transition the web service to new application states (this is otherwise know as *hypermedia as the engine of application state*). HTML forms present a good example of this in practice

* Using Java API for RESTful Web Services (JAX-RS), you can use the *UriInfo* object to access request headers. The *UriInfo* object provides methods to enable you to find or build URI information of a request

* Using an injected *UriInfo* object by the JAX-RS runtime environment, the relative and absolute uniform resource identifier (URI) information is known and available for modification
* The *@javax.ws.rs.core.Context* annotation indicates that a context object is injected
* The *@javax.ws.rs.core.UriInfo* interface is the interface of the object that you want to inject. You can use the *UriInfo* object to build absolute and relative URLs using the *UriBuilder* class

### 2.1.6 Use *ResponseBuilder* to create response with customized status and additional metadata
* The HTTP specification defines what HTTP response codes should be on a successful request
* Sometimes, you need to specify your own response codes, or simply to add specific headers or cookies to your HTTP response. JAX-RES provides a *Response* class for that
 
### 2.1.7 Implement a *MessageBodyReader* and *MessageBodyWriter* to add support for custom request and response data types
* JAX-RS enables developers to add a custom entity provider to the application. Use custom entity providers when you want to use Java types to represent incoming request message bodies as well as represent outgoing response message bodies. By adding a custom entity provider, you can deserialize custom Java types from message bodies and serialize any media type as message bodies
 
* A custom entity provider is created by annotating a class with a *javax.ws.rs.ext.Provider* annotation. The class must implement the *javax.ws.rs.ext.MessageBodyReader* interface or the *javax.ws.rs.ext.MessageBodyWriter* interface. You must add the provider class to the list of classes returned in the *javax.ws.rs.core.Application* subclass *getClasses()* method

* The *MessageBodyReader* interface represents a contract for a provider that supports the conversion of a stream to a Java type
* To add a *MessageBodyReady* implementation, annotate the implementation class with *@Provider*
* A *MessageBodyWriter* implementation may be annotated with *Produces* to restrict the media types for which it will be considered suitable:
    * Create a new Java class that is your custom entity provider
    * Add the *@javax.rs.ws.ext.Provider* annotation. Adding this annotation indicates to the JAX-RS runtime environment that this class is a JAX-RS provider. If this *Provider* annotation is not specified, the runtime environment does not detect that the class is a custom provider
    * Optional: Add a *@javax.ws.rs.Consumes* and/or *@javax.ws.rs.Produces* annotation to limit the media types that entity provider supports
    * Implement *javax.ws.rs.ext.MessageBodyReader<T>* if the entity provider needs to deserialize a message body. You can use the generic type <T> to limit the types supported by the entity provider
    * Implement *javax.ws.rs.ext.MessageBodyWriter<T>* if the entity provider needs to serialize a message body
    * Add the custom entity provider to the *javax.ws.rs.core.Application* subclass and add the provider to the set of classes returned from the *getClasses()* method
    
### 2.1.8 Implement *ExceptionMapper* to map a custom *Exception* to a response
* JAX-RS has a *RuntimeException* class, *WebApplicationException*, that allows you to abort your JAX-RS service method
* It can take an HTTP status code or even a *Response* object as one of its constructor parameters

* The *@Provider* annotation declares that the class is of interest to the JAX-RS runtime
* Such a class should be added to the set of classes of the *Application* instance that is configured

### 2.1.9 Use *Request* to add support for HTTP preconditions

### 2.1.10 Implement the functionality of the JAX-RS resource's methods

### 2.1.11 Use *@Path* on a method to defined sub-resource
* Methods of a resource class that are annotated with *@Path* are either *sub-resource methods* or *sub-resource locators*
* Sub-resource methods handle an HTTP request directly while sub-resource locators return an object that will handle an HTTP request
* The present or absence of a request method designator (e.g *@GET*) differentiates between the two:
    * Request method designator (*@GET*, *@POST*) presents: such methods, known as sub-resource methods, are treated like a normal resource method except the method is only invoked for request URIs that match a URI template created by concatenating the URI template of the resource class with the URI template of the method
    * Request method designator absent: such methods, known as sub-resource locators, are used to dynamically resolve the object that will handle the request. Any returned object is treated as a resource class instance and used to either handle the request or to further resolve the object that will handle the request

### 2.1.12 Configure deployment descriptor (web.xml) for base URL pattern, HTTP security (via security-constraints for web.xml)

### 2.1.13 Compile and package

### 2.1.14 Deploy the web service in a Java EE servlet container
