# PLT.11 Portlet Requests
* The request objects encapsulate all information about the client request, parameters, request content data, portlet mode, window state, etc.
* A request object is passed to the *processAction*, *processEvent*, *serveResource* and *render* methods of the Portlet

## PLT.11.1 PortletRequest Interface
* The *PortletRequest* interface defines the common functionality for all the request interfaces

### PLT.11.1.1 Request Parameters
* If a Portlet receives a request from a client request targeted to the portlet itself, the parameters must be the string parameters encoded in the URL (added when creating the PortletURL) and the string parameters sent by the client to the portlet as part of the client request
* The parameters the request object returns must be *x-www-form-urlencoded* decoded
* The parameters are stored as a set of name-value pairs
* Multiple parameter values can exist for any given parameter name
* The following methods of the *PortletRequest* interface are available to access parameters:
    * getParameter
    * getParameterNames
    * getParameterValues
    * getParameterMap
    * getPublicParameterMap
    * getPrivateParameterMap
* Parameters set on the Portlet URL and the post body are aggregated into the request parameter set
* Portlet URL parameters ar presented before post body data
* If portlets namespace or encode URL parameters or form parameters they are also responsible for removing the namespace
* The Portlet Container will not remove any namespacing the portlet has done on these parameters

#### PLT.11.1.1.1 Form and Query Parameters
* If the Portlet is performing an HTML Form submission via HTTP method POST the post form data will be populated to the portlet request parameter set if the content type is *application/x-www-form-urlencoded*
* If the post form data are populated to the Portlet Request parameters the post form data will no longer be available for reading directly form the request object's input stream
* If the post form data is not included in the parameter set, the post data must still be available to the Portlet via the *ActionRequest/ResourceRequest* input stream
* If the portlet is performing an HTML Form submission via the HTTP method GET the form data set is appended to the Portlet URL used for the form submission and are therefore accessible as request parameters for the Portlets
* Note that some portal/portlet-container implementations may encode internal state as part of the URL query String and therefore do not support forms using HTTP GET

#### PLT.11.1.1.2 Action and Event Request Parameters
* The Portlet-Container must not propagate parameters received in an action or event request to subsequent render requests of the portlet
* The Portlet-Container must not propagate parameters received in an action to subsequent event requests of the Portlet
* If a Portlet wants to do that in either the *processAction* or *processEvent* methods, it must use the *setRenderParameter* or *setRenderParameters* methods of the *StateAwareResponse* object within the *processAction* or *processEvent* call
* The set render parameters must be provided to the *processEvent* and *render* calls of at least the current client request

#### PLT.11.1.1.3 Render Request Parameters
* If a Portlet receives a *render* request that is the result of a client request targeted to another portlet in the Portal page, the parameters should be the same parameters as of the previous render request from this client
* If a Portlet receives an *event* that is the result of a client request targeted to another portlet in the portal page, the parameters should be the same parameters as of the previous render request request from this client
* If a Portlet receives a *render* request following an *action* or *event* request as part of the same client request, the parameters received with the render request must be the render parameters set during the action or event request
* If a portlet receives a *render* that is the result of invoking a render URL targeting this portlet, the render parameters received with the render request must be the parameters set on the render URL if these were not changed by the portlet as a result of an container event received for this render URL
* Commonly, Portals provide controls to change the Portlet mode and the window state of Portlets
* Render parameters get automatically cleared if the Portlet receives a *processAction* or *processEvent* call and need to be explicitly re-set on the response of such a lifecycle call

#### PLT.11.1.1.4 Resource Request Parameters
* For *serveResource* requests the Portlet must receive any resource parameters that were explicitly set on the *ResourceULR* that triggered the request
* If the cache-ability level of that resource URL was *PORTLET* or *PAGE*, the Portlet must also receive the render parameters present in the request in which the URL was created
* If a resource parameter is set that has the same name as a render parameter, the render parameter must be the last entry in the parameter value array

### PLT.11.1.2 Public Render Parameters
* In order to allow coordination of render parameters with other portlets, within the same portlet application or across portlet applications, the Portlet can declare a public render parameters in its deployment descriptor using the *public-render-parameter* element in the portlet application section
* Public render parameters are available in all lifecycle methods of the portlet: *processAction*, *processEvent*, *render*, and *serveResource*
* Public render parameters can be viewed and changed by other portlets or components
* In the Portlet section each portlet can specify the public render parameters it would like to share via the *supported-public-render-parameter* element
* The *supported-public-render-parameter* element must reference the identifier of a public render parameter defined in the Portlet application section in a *public-render-parameter* element
* The Portlet container must only send those public render parameters to a Portlet which hash defined support for using *supported-public-render-parameter* element in the *portlet.xml*
* The Portlet container must only share those render parameter of a portlet which the portlet has declared as supported public render parameters
* The Portlet container is free to only provide a subset of the defined public render parameters to Portlets that are not target of a render URL as storing of render parameters is only encourage, but not mandated for portal/portlet-container implementations
* A public render parameter that is not supplied for this request should be viewed by the Portlet as having the value *null
* If the Portlet was the target of a render URL and this render URL has set a specific public render parameter, the Portlet must receive at least this render parameter
* A Portlet can access the public render parameter in any lifecycle method via the *getPublicRenderParameterMap* method of the PortletRequest (in addition Portlet can access public render parameter via the *getParameter* and *getParameterMap* methods)
* In case of *processAction* or *serveResource* call, the public render parameters are merged with the action/resource parameters set on the action/resource URL
* If a action or resource parameter has the same name as a public render parameter the public render parameter values must be the last entries in the parameter value array
* If a Portlet want to delete a public render parameter it needs to use the *removePublicRenderParameter* method on the *StateAwareResponse* or the *PortletURL*
* Be default, all public render parameters declared by the portlet will be provided in the current request
* In order to minimize updates, a Portlet should only set public render parameter explicitly on a RenderURL, if the values in the target request should be different from the parameter values of the current request
* Portlets can access a merged set of public and private parameters via the *getParameter* methods on the *PortletRequest* or separated as maps of private parameters via the *getPrivateParameterMap* method and public render parameter via the *getPublicParameterMap* method
* The *qname* element should uniquely identify the public render parameter and use the QNames as defined in the XML specs
* As an alternative, the Portlet can specify a default namespace via the *default-namespace* element that will be applied to all public render parameters defined only with a local name with the *name* element in public render parameter definition section
* Its up to the Portal implementation to decide which Portlets may share the same public render parameters
* To enable localization support of public parameters for administration and configuration tools, developers should provide a display name in the portlet application ResourceBundle. The entry for the display name should be constructed as *javax.portlet.app.public-render-parameter.identifier.display-name*

### PLT.11.1.3 Extra Request Parameters
* The Portal/Portlet-Container implementation may add extra parameters to Portlet URLs to help the Portal/Portlet-Container route and process client requests
* Extra parameters used by the Portal/Portlet-Container must be invisible to the Portlet receiving the request
* The Portal/Portlet-Container have to properly add namespace to these extra parameters to avoid collisions
* *javax.portlet.* prefix are reserved for this spec

### PLT.11.1.4 Request Attributes
* Request attributes are objects associated with a portlet during a single portlet request
* Portlets cannot assume that attributes are public between action, resource, event and render request
* Portlet attributes may be set by the Portlet or Portlet Container to express information that otherwise could not be expressed via the API
* Request attributes can be used to share information with Servlet of JSP via *PortletRequestDispatcher*
* API (*PortletRequest* interface):
    * getAttribute
    * getAttributeNames
    * setAttribute
    * removeAttribute
* Only one attribute value may be associated with an attribute name
* Attribute name beginning with *javax.portlet.* prefix are reserved for definition by this spec

#### PLT.11.1.4.1 The User Information Request Attribute
* Portlet can access a map with user information attributes via the request attribute *PortletRequest.USER_INFO*

#### PLT.11.1.4.2 The CC/PP Request Attribute
* Portlet can access a Composite Capability/Preference Profile

#### PLT.11.1.4.3 The Render Part Request Attribute for Setting Headers in the Render Phase
* There are cases in which the Portlet may want to return header information, or other information that is required before getting the markup, like the Portlet title or the next possible Portlet modes, in the render phases
* Java Portlet Spec provides *javax.portlet.renderHeaders* container runtime setting and the *RENDER_PART* request attribute
* Use this for:
    * Setting cookies
    * Setting headers
    * Setting the title
    * Returning new possible portlet modes
* Set *javax.portlet.renderHeaders* to *true*
* When set to *true* streaming Portal implementations should call the *render* method of the Portlet twice with *RENDER_PART* attribute set in the render request
* If *RENDER_PART* Portlet request attribute is set, it indicates that the render request needs to be split into two parts:
    * The *RENDER_PART* is set to *RENDER_HEADERS*. In this part, the Portlet should only set the header related data, cookies, the next possible Portlet modes and the Portlet title
    * *RENDER_PART* is set to *RENDER_MARKUP*, Portlet should produce only its markup
* Non-streaming Portals will not set this attribute and thus Portlet should set headers, Portlet title and produce its markup in a single render request
* Portlet should either extend *GenericPortlet*, which provides handling of the *RENDER_PART* request attribute in the render method, or check for the *RENDER_PART* request attribute themselves

#### PLT.11.1.4.4 The Lifecycle Phase Request Attribute
* *LIFECYCLE_PHASE* request attribute of the *PortletRequest* interface allow a Portlet to determine the current lifecycle phase of the current request
* This attribute value must be:
    * *ACTION_PHASE* for ActionRequest
    * *EVENT_PHASE* for EventRequest
    * *RENDER_PHASE* for RenderRequest
    * *RESOURCE_SERVING_PHASE* for ResourceRequest
* This main intent of this attribute is to allow frameworks implemented on top of the Java Portlet Spec to perform the correct type cast from the *PortletRequest/PortletResponse* to a specific pair request/response, like *ActionRequest/ActionResponse*

#### PLT.11.1.4.5 Action-Scoped Request Attributes
* Java Portlet Spec follows a model of separating concerns in different lifecycle method, like *processAction*, *processEvent*, *render*
* This provides clean separation of action semantics but may create issues with Servlet-based application
* Suck applications in some cases assume that attributes they set in the action phase will be accessible again in the rendering
* Java Portlet Spec provides the render parameters for such use cases, but some applications need to transport complex objects instead of String
* Action-scoped request attribute intents to provide Portlets with these request attributes until a new action occurs
* See PLT.10.1.4.4

### PLT.11.1.5 Request Properties
* A Portlet can access Portal/Portlet-Container specific properties and, if available, the headers of the HTTP client request through the methods of the *PortletRequest* interface:
    * *getProperty*
    * *getProperties*
    * *getPropertyNames*
* Depending on the underlying Web-Server/Servlet-Container and Portal/Portlet-Container implementation, client request HTTP headers may not be always available

#### PLT.11.1.5.1 Cookies
* Portlet can access cookies provided by the current request with the *getCookies* method, return a cookie array with all cookie properties

### PLT.11.1.6 Request Context Path
* Context path is the path prefix associated with the deployed Portlet application
* Context path of a request is exposed via the request object

### PLT.11.1.7 Security Attributes
* *PortletRequest* interface offers a set of methods that provide security information about the user and the connection between the user and the portal:
    * *getAuthType*  return the authentication scheme being used between the user and the portal
    * *getREmoteUser* return the login name of the user making this request
    * *getUserPrincipal* return a *java.security.Principal* object containing the name of the authenticated user
    * *isUserInRole* indicates if an authenticated user is included in the specified logical role
    * *isSecure* indicates if the request has been transmitted over a secure protocol such as HTTPS

### PLT.11.1.8 Response Content Types
* Portlet developers may code Portlet to support multiple content types
* *getResponseContentType* method of the request object, return a String representing the default content type the Portlet Container assumes for the output
* The returned values are the sames for *processAction*, *processEvent* and *render* calls occurring within the same client request
* If the *getResponseContentType* and *getResponseContentTypes* are exposed via the *ActionRequest*, *EventRequest*, or *RenderRequest*, the following additional restriction apply:
    * The content type must be only included the MIME type
    * The character set can be retrieve via *RenderResponse.getCharacterEncoding*
    * *getResponseContentTypes* must return only the content types supported by the current Portlet mode of the Portlet
* If the *getResponseContentType* or *getResponseContentTypes* are exposed via an *ResourceRequest*, the returned value should be based on the HTTP Accept header provided by the client

* ### PLT.11.1.9 Internationalization
* Portal/Portlet-Container decides what local will be used for creating the response for a user
* Portal/Portlet-Container may use information that the client sends with the request (i.e *Accept-Language* header)
* *PortletRequest.getLocale* method inform the Portlet about the locale of user the Portal/Portlet-Container has chosen

### PLT.11.1.10 Portlet Mode
* *PortletRequest.getPortletMode* allow Portlet to find out is current Portlet mode
* Portlet may be restricted to work with a subset of supported Portlet modes
* *PortletRequest.isPortletModeAllowed* find out if the Portlet is allowed to use a Portlet Mode
* A Portlet mode is not allowed if the Portlet mode is not in the Portlet definition or the Portlet or the user has been constrained further by the Portal
* *VIEW* is always allowed, event if not explicitly listed in the Portlet definition

### PLT.11.1.11 Window State
* *PortletRequest.getWindowState* return the current window state
* Portlet may be restricted to work with a subset of supported Portlet modes
* *PortletRequest.isWindowStateAllowed* method return if Portlet is allowed to use a window state

### PLT.11.1.12 Access to the Portlet Window ID
* *PortletRequest.getWindowID* return the current Portlet Window ID
* Portlet Window ID must be unique for this Portlet Window and constant for the lifetime of the Portlet Window
* Must be the same as the one is used by the Portal/Portlet Container for scoping the Portlet-Scope session attributes

## PLT.11.2 ClientDataRequest Interface
* *ClientDataRequest* interface extends *PortletRequest* and its used as base class for the *ActionRequest* and *ResourceRequest*
* Provides access to the request information of the HTTP request issued from the client to the consuming application/portal, such as input stream

### PLT.11.2.1 Retrieving Uploaded Data
* The input stream is useful when the client request contains HTTP POST data of type other than *application/x-www-form-urlencoded* (i.e a file is uploaded)
* *ClientDataRequest* provides *getReader* method that retrieves the HTTP Post data as character data according to the character encoding defined in the request
* Only one of the two method, *getPortletInputStream* or *getReader*, can be used during an action request
* *ClientDataRequest* also provides:
    * *getContentType*
    * *getCharacterEncoding*
    * *setCharacterEncoding*
    * *getContentLength*
* If the user request HTTP POST data is of type *application/x-www-form-urlencoded*, this data has been processed by the Portal/Portal container and is available as request parameters
* *getPortletInputStream* and *getReader* must throw *IllegalStateException* if called

## PLT.11.3 ActionRequest Interface
* *ActionRequest* interface extends *ClientDataRequest*, used in the *processAction* method of the *Portlet* interface
* No addition methods but only the *ACTION_NAME* constant that can be used together with the *@ProcessAction*

## PLT.11.4 ResourceRequest Interface
* *ResourceRequest* interface extends the *ClientDataRequest*, and used in *serveResource* method of *ResourceServingPortlet*
* *ResourceRequest* interface defines the *ETAG* constants and *getEtag* method for validation based caching
* *getResourceID* method for getting the resource ID set on the resource URL

## PLT.11.5 EventRequest Interface
* *EventRequest* extends *PortletRequest*, used in the *processEvent* method of the *EventPortlet* interface
* *EventRequest.getEvent* return the event that triggered the *processEvent* call
* *Event* object provides the event QName via *getQName* method

## PLT.11.6 RenderRequest Interface
* *RenderRequest* interface extends *PortletRequest* interface, used in the *render* method of the *Portlet* interface
* *RenderRequest* does not define any additional methods

## PLT.11.7 Lifetime of the Request Objects
* Each request object is valid only within the scope of a particular *processAction*, *processEvent*, *serveResource* or *render* method call
* Containers commonly recycle request objects in order to avoid performance overhead of request object creation
* Developer must be aware that maintaining references to request objects outside the scope described may lead to non-deterministic behavior