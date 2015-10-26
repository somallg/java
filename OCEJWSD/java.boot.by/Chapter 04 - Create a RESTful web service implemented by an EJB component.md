# Chapter 04 - Create a RESTful web service implemented by an EJB component

## 4.1 Create a web service using JAX-RS from EJB classes
* A root resource class is anchored in URI space using the *@Path* annotation
* The value of the annotation is a relative URI path template whose base URI is provided by the deployment context

### 4.1.1 Annotate an enterprise bean class with a *@Path* annotation to respond to URL patterns
* Identifies the URI path that a resource class or class method will serve requests for

* Paths are relative. For an annotated class the base URI is the application path. For an annotated method the base URI is the effective URI of the containing class. For the purpose of absolutizing a path against the base URI, a leading '/' in a path is ignored and based URIs a treated as if they ended in '/'

* Session beans (Stateless or Singleton) can be implemented as JAX-RS resource or provider classes
* EJB 3.1 and JAX-RS work very well together thanks to JAX-RS flexibility in handling many kinds for resource classes, the EJB 3.1 no-interface view, and the ability to package enterprise beans directly in a .war

* The *@Path* annotation's value is a relative URI path

* URI path templates are URIs with variables embedded within the URI syntax
* These variables are substituted at runtime runtime in order for a resource to response to a request based on the substituted URI. Variables are denoted by curly braces
* It is possible to declare a particular regular expression, which overrides the default regular expression

* A *@Path* value may or may not begin with a '/', it makes no difference. Likewise, a *@Path* value may or may not end in a '/', it makes not difference, and thus request URLs that end or do not end in an '/' will both be matched

### 4.1.2 Annotate the class's methods to respond to HTTP requests using the corresponding JAX-RS annotations (*@GET*, *@POST*, etc.)
* JAX-RS defines common HTTP method using annotations: *@GET*, *@POST*, *@PUT*, *@DELETE*, *@HEAD*, and *@OPTIONS*
* Only *public* methods may be exposed as resource methods

### 4.1.3 Use the JAX-RS *@Produces* and *@Consumes* annotations to specify the input and output resources for the RESTful web service
* **@Produces**
* The *@Produces* annotation is used to specify the MIME media types of representations of resource can produce and send back to the client

* *@Produces* can be applied at both the class and method levels

* If a resource class is capable of producing more than one MIME media type then the resource method chosen will correspond to the most acceptable media type as declared by the client. More specially the *Accept* header of the HTTP request declared what is most acceptable

* More than one media type may be declared in the same *@Produces* declaration
* If multi media types are equally acceptable than the former will be chosen because it occurs first

* **@Consumes**
* The *@Consumes* annotation is used to specify the MIME media types of representations a resource can consume that were sent by the client

* *@Consumes* can be applied at both the class and method levels and more than one media type may be declared in the same *@Consumes* declaration

* **JAX-RS standard entity parameter types**
* JAX-RS requires certain parameters to be supported for virtually any content type

### 4.1.4 Implement the functionality of the JAX-WS resource's method
* **Extracting Request Parameters**
* Parameters of a resource method may be annotated with parameter-based annotations to extract information from a request

* The *@QueryParam* annotation extracts the value of a URI query parameter

* With all parameters annotations, you can dd a *@DefaultValue* annotation to define the default value for a parameter you are expecting. The default value is used if the corresponding is not present in the request

* If the *@DefaultValue* is not used on conjunction with *@QueryParam* and the query parameter is not present in the request then value will be an empty collection for *List*, *Set* or *SortedSet*, *null* for other object types, and the Java-defined default for primitive types

* The *@PathParam* and the other parameter-based annotations, *@MatrixParam*, *@HeaderParam*, *@CookieParam* and *@FormParam* obey the same rules as *@QueryParam*

* *@MatrixParam* extracts information from URL path segments (; is used as a delimiter instead of ?)

* *@HeaderParam* extracts information from the HTTP headers
* *@CookieParam* extracts information from the cookies declared in cookie related HTTP headers

* *@FormParam* is slightly special because it extracts information from a request representation that is of the MIME media type "application/x-www-form-urlencoded" and conforms to the encoding specified by HTML forms. This parameter is very useful for extracting information that is POSTed by HTML forms

* In general *@Context* can be used to obtain contextual Java types related to the request or response

### 4.1.5 Configure container role based access control via method-permissions in *ejb-jar.xml* or via access control annotations on EJB

### 4.1.6 Configure caller authentication (for access control protected methods) and message protection by Servlet Container via *web.xml*

### 4.1.7 Compile and package
* A JAX-RS application is packaged as a Servlet in a .war file
* The *Application* subclass, resource classes, and providers are packaged in *WEB-INF/classes*, required libraries are packaged in *WEB-INF/lib*. Included libraries may also contain resource classes and providers are desired

### 4.1.8 Deploy the web service in a Java EE servlet container
* The resources and providers that make up a JAX-RS application are configured via an application-supplied subclass of *Application*
* An implementation may provide alternate mechanisms for locating resource classes and providers but use of *javax.ws.rs.core.Application* is the only portable means of configuration

* The *getClasses()* method returns a list of classes you want to deploy into the JAX-RS environment
* They can be *@Path* annotated classes, in which case, you are specifying that you want to use the default per-request component model
* The *getSingletons()* method returns actual instances that you create within the implementation of your *Application* class
* You use this method when you want to have control over instance creation of your resource classes and providers

* JAX-RS provides the deployment agnostic abstract class *Application* for declaring root resource and provider classes, and root resource and provider single instances
* A web service may extend this class to declare root resource and provider classes

* Alternatively it is possible to reuse one of Jersey's implementations that scans for root resource and provider classes given a classpath or a set of package names
* Such classes are automatically added to the set of classes that are returned by *getClasses*

* For servlet deployment JAX-RS specifies that a class that implements *Application* may be declared instead of a servlet class in *<servlet-class>* element of a *web.xml*

* If using *Servlet 2.x* then instead it is necessary to declare the Jersey specific servlet (or any other JAX-RS implementation-supplied *Servlet* class) and the application-supplied subclass of *Application* is identified using an *init-param* with a *param-name* of *javax.ws.rs.Application*

* Alternatively a simpler approach is to let Jersey chose the *PackagesResourceConfig* implementation automatically by declaring the package