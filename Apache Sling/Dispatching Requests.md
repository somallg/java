# Dispatching Requests

# Main process
1. Client sends the request
2. Only if Servlet container is installed and Sling is embedded: Servlet Container gets requests and forwards to OSGi HttpService
3. OSGi HttpService looks for responsive registered Servlet or resource
4. OSGi HttpService calls *handleSecurity* of the HttpContext associated with the servlet/resource. In case of Sling this call into SlingMainServlet.handleSecurity and then into SlingAuthenticator.authenticate
	1. SlingAuthenticator selects an authentication handler for the request and forwards the authenticate call
	2. If authentication fails either an anonymous session is acquired or login method is called
	3. If login method selects an AuthenticationHandler and forwards the login call to the AuthenticationHandler.requestAuthentication method to cause the client to authenticate
5. HttpService terminates the request (authentication failed) or continues by either spooling the resource or in case of Sling calling *SlingMainServlet.service* method
6. *SlingMainServlet.service* set ups the request:
	* Wraps *HttpServletRequest* and *HttpServletResponse* into the *SlingHttpServletRequest* and *SlingHttpServletResponse*
	* Checks if Slign is ready for processing the request
	* Create the ResourceResolver based on the Session
	* Locate the *Resource* on the basis of the request by calling *ResourceResolver.resolve*
	* Locate the servlet or script by calling *ResourceResolver.resolveServlet*
7. Request level filters are called
8. After called all request level filters, the component level filters are called
9. Request servlet or script is finally called to process the request

# Include/Forward
1. Code in the processing servlet or script calls *RequestDispatcher.include* or *RequestDispatcher.forward*
2. The resource is resolved though ResourceResolver.getResource
3. The servlet or script to handle the resource is resolved by calling ServletResolver.resolveServlet
4. Component level filters are called again
5. Servlet or script is called to process the request

# Included Request Attributes