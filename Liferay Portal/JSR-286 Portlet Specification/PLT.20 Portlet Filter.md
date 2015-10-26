# PLT.20 Portlet Filter
* Filters are Java components that allow on the fly transformations of information in both the request to and the response from, a Portlet

## PLT.20.1 What is a Portlet filter?
* Portlet filter is a reusable piece of code that can transform the content of Portlet requests and Portlet responses
* Filters do not generally create a response or respond to a request as Portlets do, rather they modify or adapt the requests, and the response
* Among the types of functionality available to the developer needing to use filters are the following:
    * The modification of request data by wrapping the request in customized versions of the request object
    * The modification of response data by providing customized versions of the response object
    * The interception of an invocation of a Portlet after its call
* Portlet filters are modeled after the Servlet filters in order to make them easy to understand for people already familiar with the Servlet model and to have one consistent filter concept in JavaEE

## PLT.20.2 Main Concepts
* Creates a filter by implementing one of the *javax.portlet.filter.XYXFilter* interfaces and providing a public constructor taking no arguments
* The class is packaged in the Portlet application WAR along with the static content and Portlets that make up the Portlet application
* A filter is declared using the *filter* element in the portlet deployment descriptor
* A filter or collection of filter can be configured for invocation by defining *filter-mapping* elements in the Portlet deployment descriptor
* This is done by mapping filters to a particular Portlet by the Portlet's logical name, or mapping to group of Portlets using the '*' as a wildcard

### PLT.20.2.1 Filter Lifecycle
* After deployment of the Portlet application, and before a request causes the Portlet container to access a Portlet, the Portlet container must locate the list of Portlet filters that must be applied to the Portlet as described below
* Portlet container must ensure that it has instantiated a filter of the appropriate class for each filter in the list, and called its *init(FilterConfig)* method
* The filter may throw an exception to indicate that it cannot function properly
* Only one instance per *filter* declaration in the deployment descriptor is instantiated per Java Virtual Machine of the Portlet container
* When the container receives an incoming request, it takes the first filter instance in the list and call its *doFilter* method, passing in the *PortletRequest* and *PortletResponse*, and a reference to the *FilterChain* object it will use
* Depending on the target method of *doFilter* call the *PortletRequest* and *PortletResponse* must be instances of the following interfaces:
    * *ActionRequest* and *ActionResponse* for *processAction*
    * *EventRequest* and *EventResponse* for *processEvent*
    * *RenderRequest* and *RenderResponse* for *render*
    * *ResourceRequest* and *ResourceResponse8 for *serveResource*
* *doFilter* method of a filter will typically be implemented following this or some subset of the following pattern:
    * The method examines the request information
    * The method may wrap the request object passed in to its *doFilter* method in order to modify request data
    * The method may wrap the response object passed in to its *doFilter* method to modify response data
    * The filter may invoke the next component in the filter chain or the target method (if it's the last filter in the deployment descriptor). The invocation of the next component is effect by calling the *doFilter* method on the *FilterChain* object
    * After invocation of the next filter in the chain, the filter may examine the response data
    * The filter may throw an exception to indicate an error in processing (retry the whole chain at later time of the exception is not marked permanent)
    * When the last filter has been invoked, the next component accessed is the target method on the Portlet at the end of the chain
    * Before a filter instance can be removed from service by the Portlet Container, the Portlet container must first call the *destroy* method on the filter

### PLT.20.2.2 Wrapping Requests and Responses
* Central to the notion of filtering is the concept of wrapping a request or response in order that it can override behavior to perform a filtering task
* In this model, the developer has the ability to override existing methods on the request and response objects
* The Portlet should not add additional methods to the wrapped as further downstream wrappers may not honor these
* The container must ensure that the request and response object that it passes to the next component in the filter chain or to the target Portlet, it the same object that was passed into the *doFilter* method of the calling filter or one of the above wrappers

### PLT.20.2.3 Filter Environment
* A set of initialization parameters can be associated with a Filter using the *init-params* element in the Portlet deployment descriptor
* The name and values of those parameters are available to the filter at runtime via the *getInitParameter*, *getInitParameterNames* methods on the filter's *FilterConfig* object
* *FilterConfig* afford access to the *PortletContext* of the Portlet application of the loading of resources, for logging functionality, and for storage of state in the *PortletContext*

### PLT.20.2.4 Configuration of Filters in a Portlet Application
* Filter is defined in the deployment descriptor using the *filter* element
* In this element, the programmer declares the following:
    * *filter-name*: used to map the Filter to a Portlet
    * *filter-class*: identify the filter type
    * *lifecycle*: determine which lifecycle phase the filter should applied
    * *init-params*: initialization parameters for a filter
* Only one instance per filter definition
* Once a filter has been declared in the Portlet deployment descriptor, the *filter-mapping* element is used to defined which Portlet the Filter is to be applied
* Filters can be associated with a Portlet using the *portlet-name* element
* Filters can be associated with groups of Portlets using the '*' character as a wildcard at the end of the String to indicate that the filter must be applied to any Portlet whose name starts with the characters before the '*' character
* The order the container uses in building the chain of Filters to be applied for a particular request is as follows:
    * the *portlet-name* matching filter mappings in the same order that these elements appear in the deployment descriptor
    * The Portlet container is free to add additional Filters at any place in this filter chain, but must not remove Filters matching a specific Portlet
* It is expected that high performance Portlet containers will cache filter chains so that they do not need to compute them on a per-request basis

### PLT.20.2.5 Defining the Target Lifecycle Method for a Portlet Filter
* Portlet Filter can be applied to different lifecycle method calls: *processAction*, *processEvent*, *render*, *serveResource*
* Filter must define lifecycle method in the *lifecycle* element of the *filter* definition element
* Filter can be applied to one or more lifecycle methods
* Valid values for *lifecycle* element:
    * ACTION_PHASE (process this filter for *processAction* method. The filter must implement *ActionFilter* interface)
    * EVENT_PHASE (process this filter for *processEvent* method. The filter must implement *EventFilter* interface)
    * RENDER_PHASE (process this filter for *render* method. The filter must implement *EventFilter* interface)
    * RESOURCE_PHASE (process this filter for *serveResource* method. The filter must implement *ResourceFilter* interface)
* If the lifecycle declaration and Portlet filer type do not match, the Portlet container is free to either reject the Portlet at deployment or ignore this filter