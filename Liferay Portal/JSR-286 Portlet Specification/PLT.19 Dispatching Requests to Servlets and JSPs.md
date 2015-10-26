# PLT.19 Dispatching Requests to Servlets and JSPs
* Portlets can delegate the execution of logic or creation of content to Servlet and JSPs
* This is useful for implementing the Model-View-Controller pattern where the Portlet may act as controller and dispatch to different JSPs for rendering the views
* *PortletRequestDispatcher* interface provides a mechanism to accomplish this dispatching
* Servlets and JSPs invoked from within a Portlet in the render phase should generate markup fragments following the recommendations of the *PLT.B Markup Fragment Appendix*

## PLT.19.1 Obtaining a PortletRequestDispatcher
* *PortletRequestDispatcher* objects may be obtained using one of the following methods of the *PortletContext*:
    * getRequestDispatcher (takes a String argument describing a path within the scope of the *PortletContext*. This path must begin with a '/', and it is relative to the *PortletContext* root)
    * getNamedDispatcher (takes a String argument indicating the name of a Servlet known to the *PortletContext* of the Portlet application)
* If no resource can be resolved based on the given path or name the methods must return *null*

### PLT.19.1.1 Query Strings in Request Dispatcher Paths
* *getRequestDispatcher* method of the *PortletContext* that creates *PortletRequestDispatcher* objects using path information allows the optional attachment of query string information to the path
* Parameters specified in the query string used to create the *PortletRequestDispatcher* must be aggregated with the Portlet render parameters and take precedence over other Portlet render parameters of the same name passed to the included servlet or JSP
* The parameters associated with a *PortletRequestDispatcher* are scoped to apply only for the duration of the include call

## PLT.19.2 Using a Request Dispatcher
* To include a Servlet or JSP, a Portlet calls the *include* method of the *PortletRequestDispatcher* interface
* To forward the request processing to a Servlet or JSP the Portlet calls the *forward* method of the *PortletRequestDispatcher* interface
* The parameters to these methods must be the request and response arguments that were passed in via the corresponding lifecycle method (e.g *processAction*, *processEvent*, *serveResource*, *render*), or the request and response arguments must be instances of the corresponding subclasses of the request and response wrapper classes that were introduced for version 2.0 of the spec
* In the latter case. the wrapper instances must wrap the request or response objects that the container passed into the lifecycle method
* Portlet container must ensure that the Servlet or JSP called through a *PortletRequestDispatcher* is called in the same thread as the *PortletRequestDispatcher* include invocation

## PLT.19.3 The Include Method
* The *include* method of the *PortletRequestDispatcher* interface may be called at any time and multiple times within the current Portlet lifecycle method
* The Servlet or JSP being included can make a limited use of the received *HttpServletRequest* and *HttpServletResponse* objects
* Servlets and JSPs included from Portlets should not use the Servlet *RequestDispatcher* *forward* method as its behavior may be non-deterministic
* Servlets and JSPs included from Portlets in the *render* method must be handled as HTTP GET requests
* The lookup of the Servlet given a path is done according to the Servlet path matching rule defined in the SRV.11 section of the Servlet Specification

### PLT.19.3.1 Included Request Parameters
* Except for Servlets obtained by using the *getNamedDispatcher*, a Servlet or JSP being used from within an *include* call has access to the path used to obtain the *PortletRequestDispatcher*
* The following request attributes must be set:
    * javax.servlet.include.request_uri
    * javax.servlet.include.context_path
    * javax.servlet.include.servlet_path
    * javax.servlet.include.path_info
    * javax.servlet.include.query_string
* These attributes are accessible from the included Servlet via the *getAttribute* method on the request object
* If the included Servlet was obtained by using the *getNamedDispatcher* method, these attributes are not set

### PLT.19.3.2 Included Request Attributes
* In addition to the request attributes specified in the *Servlet Specification, SRV.8.3.1* Section, the included Servlet or JSPs must have to following request attributes set:
    * javax.portlet.config | javax.portlet.PortletConfig
* For includes from the *processAction* method the following additional attributes must be set:
    * javax.portlet.request  | javax.portlet.ActionRequest
    * javax.portlet.response | javax.portlet.ActionResponse
* For includes from the *processEvent* method, the following additional attributes must be set:
    * javax.portlet.request  | javax.portlet.EventRequest
    * javax.portlet.response | javax.portlet.EventResponse
* These attributes must be the same Portlet API objects accessible to the Portlet doing the include call
* They are accessible from the included Servlet or JSP via the *getAttribute* method on the *HttpServletRequest* object

### PLT.19.3.3 Request and Response Objects fro Included Servlet/JSPs from within the Action and Event processing Methods
* The target Servlet or JSP of the Portlet request dispatcher has access to a limited set of methods of the request and the response objects when the include is done from within the *processAction* or *processEvent* method in order to keep the action semantic intact
* The following methods of the *HttpServletRequest* must return *null*: *getRemoteAddr*, *getRemoteHost*, *getRealPath*, *getLocalName*, and *getRequestURL*
* The following methods of the *HttpServletRequest* must return '0': *getRemovePort* and *getLocalPort*
* The response of *HttpUtils.getRequestURL* is undefined and should not be used
* The following methods of the *HttpServletRequest* must return the path and query string information used to obtain the *PortletRequestDispatcher* object: *getPathInfo*, *getPathTranslated*, *getQueryString*, *getRequestUIR* and *getServletPath*
* The following methods of the *HttpServletRequest* must be equivalent to the methods of the *PortletRequest* of similar name: *getScheme*, *getServerName*, *getServerPort*, *getAttribute*, *getAttributeNames*, *setAttribute*, *removeAttribute*, *geLocale*, *getLocales*, *isSecure*, *getAuthType*, *getContextPath*, *getRemoteUser*, *getUserPrincipal*, *getRequestedSessionId*, *isRequestedSessionIdValid*, *getCookies*
* The following methods of the *HttpServletRequest* must be equivalent to the methods of the *PortletRequest* of similar name with the provision defined in *PLT.19.1.1 Query Strings in Request Dispatcher Paths* Section: *getParameter*, *getParameterNames*, *getParameterValues* and *getParameterMap*
* In case of an include from *processAction*, the following methods of the *HttpServletRequest* must be based on the corresponding methods of the *ActionRequest*: *getCharacterEncoding*, *setCharacterEncoding*, *getContentType*, *getInputStream*, *getContentLength*, *getMethod* and *getReader*
* In case of an include from *processEvent*, the following methods of the *HttpServletRequest* must do no operations and/or return null: *getCharacterEncoding*, *setCharacterEncoding*, *getContentType*, *getInputStream* and *getReader*
* The *getContentLength* method of the *HttpServletRequest* must return *0*
* The *getMethod* method of the *HttpServletRequest* must be based on the corresponding method of the *EventRequest*, which must provide the name of the HTTP method with which the original action request was made
* *getProtocol* method if the *HttpServletRequest* must always return 'HTTP/1.1'
* The following method of the *HttpServletResponse* must return an outputStream/writer that ignores any output written to to: *getOutputStream* and *getWriter*
* *containsHeader* method of the *HttpServletResponse* must return *false*

### PLT.19.3.4 Request and Response Objects for Included Servlet/JSPs from within the Render Method
* The target Servlet or JSP of Portlet request dispatcher has access to a limited set of methods of the request and the response objects when the include is done from within the *render* method
* *getMethod* of the *HttpServletRequest* must always return 'GET'

### PLT.19.3.5 Request and Response Objects for Included Servlets/JSPs from within the ServeResource Method
* The target Servlet or JSP of Portlet request dispatcher has access to a limited set of methods of the request and response objects when the include is done from within the *serveResource* method

### PLT.19.3.6 Comparison of the different Request Dispatcher Includes

### PLT.19.3.7 Error Handling
* If the Servlet or JSP that is target of a request dispatcher throws a runtime exception or a checked exception of type *IOException*, it must be propagated to the the calling Portlet
* All other exceptions, including a *ServletException*, must be wrapped with a *PortletException*
* The root cause of the exception must be set to the original exception before being propagated

### PLT.19.3.8 Path and Query Information in Included / Forwarded Servlets
* As mentioned in the previous sections, the methods of the *HttpServletRequest* of an included servlet that deal with path and query information (*getPathInfo*, *getPathTranslated*, *getQueryString*, *getRequestURI* and *getServletPath*) must return the path and query string information used to obtain the *PortletRequestDispatcher* object
* This is different than in the Servlet API, where these values are based on the path and query string of the client request
* This makes sense from the Servlet Programming model point of view where you want to run the included / forwarded code as if it really where running in the Servlet issuing the request dispatcher include or forward call
* On the other hand, Portlet does not have direct access to the path and query information of the client request as it is one component rendered on the page
* Thus the Portlet acts as starting point of the include chain and the included / forwarded Servlet must get the path and query information used to obtain the *PortletRequestDispatcher* object
* Note that when doing additional includes or forwards from the included or forwarded Servlet it will have the same semantics as in the plain Servlet case: all further included / forwarded Servlets or JSPs will get the Path and query string information used to obtain *PortletRequestDispatcher* object as this is viewed as the initial path and query information

## PLT.19.4 The forward method
* The *forward* method of the *RequestDispatcher* interface maybe called by the calling Portlet only when no output has been committed to the response
* The request dispatcher *forward* allows setting the response content type by the Servlet or JSP, the forward call is made to
* If output data exists in the response buffer that has not been committed, the content must be cleared before the target Servlet's service is called
* If the response has been committed, an *IllegalStateException* must be thrown
* Information like cookies, properties, portlet mode, window state, render parameters, or portlet title that the portlet may have set before calling the request dispatcher forward method should still be valid
* The path elements of the Request object exposed to the target Servlet must reflect the path used to obtain the *RequestDispatcher* 
* Before the forward method of the *RequestDispatcher* interface returns, the response content must be sent and committed, and closed by the Portlet Container
* When using a *RequestDispatcher* in a Servlet that was target of a forward from a Portlet, the Servlet must request the *RequestDispatcher* via the *ServletRequest* and not the *ServletContext*
* Using a *RequestDispatcher* that was triggered via the *ServletContext* may behave in a way that does not comply with this specification

### PLT.19.4.1 Query String
* The request dispatching mechanism is responsible for aggregating query string parameters when forwarding or including requests

### PLT.19.4.2 Forwarded Request Parameters
* Except for Servlets obtained by using the *getNamedDispatcher* method, a Servlet that has been invoked by a Portlet using the *forward* method of *RequestDispatcher* has access to the path used to obtain the *PortletRequestDispatcher*
* The following request attributes must be set:
    * javax.servlet.forward.request_uri
    * javax.servlet.forward.context_path
    * javax.servlet.forward.servlet_path
    * javax.servlet.forward.path_info
    * javax.servlet.forward.query_string
* The values of these attributes must be equal to the return values of the *HttpServletRequest* methods *getRequestURI*, *getContextPath*, *getServletPath*, *getPathInfo*, *getQueryString* respectively, invoked on the request object passed to the first Servlet object in the forward call chain
* If the forwarded Servlet was obtained by using the *getNamedDispatcher*, these attributes must not be set

### PLT.19.4.3 Request ans Response Objects for Forwarded Servlet/JSPs from within the Action and Event processing Methods
* The target Servlet of the Portlet request dispatcher has access to a limited set of methods of the request and the response objects when the forward is done from within the *processAction* or *processEvent* method in order to keep the action semantic intact

### PLT.19.4.4 Request and Response Objects for Forwarded Servlets/JSPs from within the Render Method
* The target Servlet of JSP of Portlet request dispatcher has access to a limited set of methods of the request and the response objects when the forward is done from within the *render* method

### PLT.19.4.6 Comparison of the different Request Dispatcher Forwards

## PLT.19.5 Servlet filters and Request Dispatching
* Since the *Java Servlet Specification v2.4*, you can specify Servlet filters for request dispatcher include calls
* Portlet Containers must support this capability for included Servlets via the *PortletRequestDispatcher*

## PLT.19.6 Changing the Default Behavior for Included / Forwarded Session Scope
* The default for the session variable named *session* of included / forwarded Servlets or JSPs is that is maps to the Portlet session with application scope
* Some Portlets may require that the session variable for included / forwarded Servlets or JSPs maps instead to the Portlet Session Scope in order to work correctly
* These Portlets can indicate this via setting the *container-runtime-option* *javax.portlet.servletDefaultSessionScope* to *PORTLET_SCOPE* (default value is *APPLICATION_SCOPE*)
* Note that not all Portlet container may be able to provide this feature as a portable JavaEE solution does not currently exist. Therefore, relying on this feature may restrict the numbers of Portlet containers the Portlet can be executed on
