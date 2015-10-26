# PLT.10 Portlet Context
* The *PortletContext* interface defines a portlet's view of the portlet application within which the portlet is running
* Using the *PortletContext* object, a Portlet can log events, obtain portlet application resources, application and portlet runtime options and set and stored attributes that other portlets and servlets in the portlet application can access

## PLT.10.1 Scope of the Portlet Context
* There is one instance of *PortletContext* interface associated with each portlet application deployed into a portlet container
* In cases where the container is distributed over many virtual machines, a portlet application will have an instance of the *PortletContext* interface for each VM

## PLT.10.2 Portlet Context functionality
* Through *PortletContext* interface, it is possible to access context initialization parameters, retrieve and store context attributes, obtain static resources from the Portlet application and obtain a request dispatcher to include Servlets and JSPs

## PLT.10.3 Relationship with the Servlet Context
* A Portlet application is an extended web application
* As a web application, a portlet application also has a Servlet Context
* The Portlet Context leverages most of its functionality from the Servlet Context of the Portlet Application
* However, the context objects themselves may be different objects
* The context-wide initialization parameters are the same as initialization parameters of the Servlet Context and the context attributes are shared with the Servlet Context
* Therefore, they must be defined in the web application deployment descriptor (the *web.xml* file)
* The initialization parameters accessible through the *PortletContext* must be the same that are accessible through the *ServletContext* of the Portlet application
* Context attributes set using the *PortletContext* must be stored in the *ServletContext* of the Portlet application
* A direct consequence of this is that data stored in the *ServletContext* by Servlets or JSPs is accessible to Portlets through the *PortletContext* and vice versa
* The *PortletContext* must handle the same temporary working directory the ServletContext handles
* It must be accessible as a context attribute using the same constant defined in the *Servlet Spec* *javax.servlet.context.tempdir*
* Portlet Context must follow the same behavior and functionality that the Servlet Context has for Virtual hosting and reloading considerations

### PLT.10.3.1 Correspondence between ServletContext and PortletContext methods
* The following methods of the *PortletContext* should provide same functionality as the methods of the *ServletContext* of similar name:
    * getAttribute
    * getAttributeNames
    * getInitParameter
    * getInitParameterNames
    * getMimeType
    * getRealPath
    * getResource
    * getResourcePaths
    * getResourceAsStream
    * log
    * removeAttribute
    * setAttribute

## PLT.10.4 Portlet Container Runtime Options
* The Portlet can define additional runtime behavior in the *portlet.xml* on either the Portlet application level or the portlet level with the container-runtime-option element
* Container Runtime options that are defined on the application level should be applied to all portlets in the portlet application
* Runtime options that are defined on the portlet level should be applied for this portlet only and override any runtime options defined on the application level with the same name
* Container runtime options besides the *javax.portlet.actionScopedRequestAttributes* option are optional to support by the Portlet Container and the Portlet can find out which Container Runtime Options are supported by the Portlet Container running the Portlet via the method *getContainerRuntimeOptions* on the *PortletContext*
* The *getContainerRuntimeOptions* method returns an enumeration of type String containing the keys of all the container runtime options that the current Portlet Container supports

### PLT.10.4.1 Runtime Option javax.portlet.escapeXml
* In the Java Portlet Spec v1.0 the behavior in regards to XML escaping URLs written by the tag library was *undefined* and thus portlets may have been coded with the assumption that the URLs were not XML escaped
* In order to be able to run these Portlets on a Java Portlet Spec v2.0 container, the spec provides the *javax.portlet.escapeXml* container runtime option
* The value of this setting can either be *true* for XML escaping URLs per default, or *false* for not XML escaping URLs per default
* Portlets that require the default behavior for URLs written to the output stream via the Portlet tag library should therefore defined the *javax.portlet.escapeXml* to *false* in the *container-runtime-option* tag
* If the Portlet has defined the *javax.portlet.escapeXml* container runtime option, the Portlet Container should honor this setting as otherwise the Portlet may not work correctly

### PLT.10.4.2 Runtime Option javax.portlet.renderHeaders
* Portlets that need to write any headers in the render phase can set the additional container-runtime-option with name *javax.portlet.renderHeaders* and value *true* (default is *false*)
* When set to *true* streaming portal implementations should call the *render* method of the portlet twice with *RENDER_PART* attribute set in the render request

### PLT.10.4.3 Runtime Option javax.portlet.servletDefaultSessionScope
* The default for session variable of included/forwarded servlets or JSPs is that is maps to the Portlet session with application scope
* Some portlets may require that the session variable of included/forwarded Servlets or JSPs map instead to the Portlet session scope in order to work correctly
* These portlets can indicate this via setting the *container-runtime-option* *javax.portlet.servletDefaultSessionScope* to *PORTLET_SCOPE* (default is *APPLICATION_SCOPE*)

### PLT.10.4.4 Runtime Option javax.portlet.actionScopedRequestAttributes
* The Java Portlet Spec follows a model of separating concerns in different lifecycle method, like *processAction*, *processEvent*, *render*
* This provides a clean separation of the action semantics from the rendering of the content, however, it may create some issues with Servlet-based applications that don't follow this strict Model-View-Controller pattern
* Such applications in some cases assume that attributes that they set in the action phase will be accessible again when starting the rendering
* The Java Portlet Spec provides the render parameters for such use cases, but some applications need to transport complex objects instead of Strings
* One example for such an use case is a Java Server Faces (JSF) bridge portlet that expects to be executed in a single lifecycle phase for processing actions, events and rendering from the JSF point of view and thus needs to transport attributes from action to subsequent event and render calls until the next action occurs
* For such use cases the Java Portlet Spec provides the action-scoped request attributes as container-runtime-option with the intent to provide Portlets with these request attributes until a new action occurs. This container-runtime-option must be supported by portlet container
* Portlets should note that using this container-runtime-option will result in increased memory usage and thus may have a decreased performance as the Portlet container needs to maintain and store these attributes across requests
* Portlets that want to leverage the action-scoped request attributes need to set the container-runtime-option *javax.portlet.actionScopedRequestAttributes* to *true* (default is *false*)
* In addition the Portlet may provide a value called *numberOfCachedScoped* where the following value element must be a positive number indicating the number of scopes the Portlets want to have cached by the Portlet Container
* This value is a hint to the Portlet Container that the Portlet Container may not be able to honor because of resource constraints

#### PLT.10.4.4.1 Action Scope ID Render Parameter
* The Portlet Container must store the action scope ID as render parameter with the name *javax.portlet.as* defined as *PortletRequest.ACTION_SCOPE_ID*
* When using the action-scoped request attribute extension the Portlet must not use this render parameter name for its private render parameters
* The Portlet container must provide the action scope ID render parameter and its value when calling one of the Portlet lifecycle methods and its responsible for setting this action scope ID at the end of a *processAction* or *processEvent* method call
* The Portlet should not set a value for the render parameter named *PortletRequest.ACTION_SCOPE_ID* (*javax.portlet.as*)
* If the Portlet removes the *PortletRequest.ACTION_SCOPE_ID* render parameter in a PortletURL listener the Portlet Container should honor this and create a Portlet URL without this render parameter
* This allows the Portlet to create resource URLs that are cache-able across action scopes

#### PLT.10.4.4.2 Lifetime of Action-Scoped Request Attributes
* The Portlet can view attributes set on action, event, or resource requests in any of its lifecycle request lasting until the next action occurs, or until some timeout or invalidation mechanism of the Portlet Container frees up the occupied memory (e.g the user session has timed out)
* A new action scope is started when:
    * receiving an action - starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored
    * receiving a render without an existing scope ID - starts a new scope without any scope ID, all previous attributes are no longer accessible, no new attributes can stored
    * receiving an event without an existing scope ID - starts a new action scope with a new scope ID, all previous attributes are no longer accessible, new attributes can be stored
    * receiving an event with an existing scope ID after the first render for this scope had occurred, as this event will likely have an action semantic. All previous attributes are no longer accessible, new attributes can be stored
* The existing scope is preserved with the current scope ID and action-scoped attributes when:
    * receiving a *render* call with an existing scope ID
    * receiving a *processEvent* call with an existing scope ID before the first render for this coped had occurred
    * receiving a *serveResource* call with an existing scope ID
* The following attributes are not stored in the action scope by the Portlet Container:
    * all attributes starting with *javax.portlet*
    * all Java Portlet Spec defined objects, like request, response, session, as they are only valid for the current request
    * all other attributes the portal/portlet-container provides itself for handling the lifecycle call
* The Portlet may also filter out attributes that should be stored in the action-scope at the end of the request either via *removeAttribute* or via a response filter    
* If Portlets use non-serializable objects as attribute values they may not be provided across different requests, e.g. if the Portlet Container leverages mechanisms such as a session and session replication
* However, Portlet Containers should either provide the complete set of attributes to the Portlet or discard the entire set of attributes in order to allow the Portlet to always run in a consistent state

#### PLT.10.4.4.3 ServeResource Calls
* If a *serveResource* call is triggered by a resource URL with a cache level of *FULL* the action scope ID may not be included and thus the portlet may not have access to the action-scope attributes

#### PLT.10.4.4.4 Examples

#### PLT.10.4.4.5 Semantics for Portlet Containers
* In order to provide a consistent user experience for end users the portlet container should keep previous action-scoped attributes cached in order to allow the end user to navigate between different views with the browser forward and backward buttons
* The Portlet container should use the specified *numberOfCachedScopes* provided by the portlet or a meaningful default if the portlet has not provided this value
* In order to determine if a render has already occurred for the current action-scope it is assumed that the portlet container stores a bit invisible to the portlet in the action-scoped attributes that indicates if a render has already occurred