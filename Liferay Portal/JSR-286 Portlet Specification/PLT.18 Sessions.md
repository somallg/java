# PLT.18 Sessions
* To build effective Portlet application, it is imperative that request from a particular client be associated with each other
* There are many session tracking approaches such as HTTP Cookies, SSL Sessions or URL rewriting
* To free the programmer from having to deal with session tracking directly, this specification defines a *PortletSession* interface that allow a Portal/Portlet-Container to use any of the approaches to track a user's session without involving the developers in the nuances of any one approach

## PLT.18.1 Creating a Session
* A session is considered *new* when it is only a prospective session and has not been established
* Because the Portlet Specification is designed around a request-response based protocol (like HTTP), a session is considered to be new until a client *joins* it
* A client joins a session when session tracking information has been returned to the server indicating that a session has been established
* Until the client *joins* a session, it cannot be assumed that the next request from the client will be recognized as part of a session
* The session is considered to be *new* if either of the following is true:
    * The client does not yet know about the session
    * The client chooses not to join a session
* For Portlets within the same Portlet application, a Portlet container must ensure that every Portlet request generated as result of a group of requests originated from the Portal to complete a single client request receive or acquire the same session
* In addition, if within these Portlet request more than one Portlet creates a session, the session object must be the same for all the Portlets in the same Portlet application

## PLT.18.2 Session Scope
* *PortletSession* objects must be scoped at the Portlet application context level
* Each Portlet application has it own distinct *PortletSession* object per user session
* *PortletSession* object is only valid within the current client request and thus should be retrieved via *getPortletSession* for each client request and not stored by the Portlet across client requests
* Portlet container must not share the *PortletSession* object or the attributes stored in it among different Portlet applications or among different user sessions

## PLT.18.3 Binding Attributes into a Session
* Portlet can bind an object attribute into a *PortletSession* by name
* *PortletSession* interface defines two scopes for storing objects, *APPLICATION_SCOPE* and *PORTLET_SCOPE*
* Any object stored in the session using the *APPLICATION_SCOPE* is available to any other Portlet that belongs to the same Portlet application and that handles a request indentified as being a part of the same session
* Objects that are stored in the application scope can be accessed by other Portlets in parallel and thus should synchronize write access to these objects
* Objects stored in the session using the *PORTLET_MODE* must be available to the Portlet during requests for the sasme Portlet window that the objects stored from
* *setAttribute* method of the *PortletSession* interface binds an object to the session into the specified scope
* *getAttribute* method from the *PortletSession* interface is used to retrieve attributes stored in the session
* *removeAttribute* method from the *PortletSession* is used to remove objects from the session
* Objects that need to know when they are placed into a session or removed from a session must implement *HttpSessionBindingListener* of the Servlet API
* *PortletSessionUtil* class provides utility methods to help determine the scope of the object in the *PortletSession*
* If the object was stored in the *PORTLET_MODE*, the *decodeAttributeName* method of the *PortletSessionUtil* class allows retrieving the attribute name without any portlet container fabricated prefix
* Portlet developers should always use *PortletSessionUtil* to deal with attributes in the *PORTLET_SCOPE* when accessing them through the servlet API

## PLT.18.4 Relationship with the Web Application HttpSession
* Portlet application is also web application
* Portlet application may contain Servlets and JSPs in addition to Portlets
* Portlets, Servlets and JSPs may share information through their session
* Note that the session objects may be different, but access to objects stored in the application session scope is available to any Portlet, Servlet or JSPs within the same Portlet application
* Container must ensure that all attributes placed in the *PortletSession* are also available in the *HttpSession* of the Portlet application
* A direct consequence of this is that data stored in the *HttpSession* by Servlets or JSPs of the Portlet application is also accessible to Portlets through the *PortletSession* in the Portlet application scope
* If the *HttpSession* is invalidated, the *PortletSession* object must also be invalidated by the Portlet container, and vice-versa

### PLT.18.4.1 HttpSession Method Mapping
* *getCreationTime*, *getId*, *getLastAccessedTime*, *getMaxInactiveInterval*, *invalidate*, *isNew* and *setMaxInactiveInternal* methods of the *PortletSession* interface must provide the same functionality as the methods of the *HttpSession* interface with identical names
* *getAttribute*, *setAttribute*, *removeAttribute* and *getAttributeNames* methods of the *PortletSession* interface must provide the same functionality as the methods of the *HttpSession* interface with identical names adhering to the following rules:
	* The attribute names must be the same if *APPLICATION_SCOPE* is used
	* The attribute name has to conform with the specified prefixing if *PORTLET_SCOPE* is used
	* The variant of these methods that does not receive a scope must be treated as *PORTLET_SCOPE*
	
## PLT.18.5 Writing to the Portlet Session
* When writing to the Portlet session, the distinct lifecycle phases action and render should be taken into account, as writing in the render phase may create issues as explained below

### PLT.18.5.1 Process action and process event phase
* Setting attributes in the action or event phase to the *PortletSession* in the *PORTLET_SCOPE* will likely not create any concurrency issues
* Concurrency issues may occur if the end user interacts at the same time with multiple browser windows with this Portlet window or triggers request to the Portlet window with a faster rate than the requests get processed
* Setting attributes in the *APPLICATION_SCOPE* are more likely to create concurrency issues as these scopes are shared with other portlets tha may run in parallel and also change the same attribute
* A set or remove attribute call must be conducted as an atomic operation
* Portlet container implementation is responsible for handling concurrent writes to avoid inconsistency in *PortletSession* attributes

### PLT.18.5.2 Rendering phase
* Portlet API does not prevent Portlets writing to the Portlet session even in the rendering phase in either *render* or *serveResource*
* The ability to write to the session in the rendering phase is merely introduced in order to allow easier migration of existing, servlet-based, web applications and the implementation of bridges frameworks that bridge from the Portlet environment to web application frameworks
* In general, the usage of the set methods on the *PortletSession* in render is strongly discouraged as it breaks the concept of rendering being idempotent and re-playable
* This is especially true for *APPLICATION_SCOPE* attributes as different Portlets share these attributes

## PLT.18.6 Reserved HttpSession Attribute Names
* Session attribute name starting with *javax.portlet* are reserved for usage by the Portlet Specification and for Portlet Container vendors
* Portlet Container vendors may use this reserved namespace to store implementation specific components
* Application Developers must not use attribute names starting with this prefix

## PLT.18.7 Session Timeouts
* Portlet session follows the timeout behavior of the Servlet session as defined in the *Servlet Specification*

## PLT.18.8 Last Accessed Times
* Portlet session follows the last accessed times behavior of the Servlet session as defined in the *Servlet Specification*

## PLT.18.9 Important Session Semantics
* Portlet session follows the same semantic considerations as Servlet session as defined in the *Servlet Specification* 
* Those considerations include *Threading Issues*, *Distributed Environment* and *Client Semantics*
