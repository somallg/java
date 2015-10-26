# URL to Script Resolution
* Sling looks up the resource identified by the URL - using sling:resourceType, script or servlets are looked up

# Fundamental: Scripts and Servlets are equal

# Base: Resource Type Inheritance
* Each resource type may have a resource super type
* If a resource type has no explicit resource super type, the resource super type is assumed to be "sling/servlet/default"

# Script Locations

# All requests are NOT equal
* For all requests other than GET and HEAD, the servlet or script name must exactly match the request method
* e.g PUT request, the script must be PUT.esp or PUT.jsp. GET request with extension of html, the script name may be html.esp or GET.esp

# Scripts for GET requests
* {resourceTypeLabel} - last path segment of the path created from the rsource type
* {requestExtension} - request extension
* {scriptExtention}
* {selectStringPath} - selector converted to path, selectorString.replace('.', '/')

*  A script may have 2 forms:
	* Ignoring request selectors {resourceTypeLabel}.{requestExtension}.{scriptExtenstion}
	* Handling request selectors {selectorStringPath}.{requestExtension}.{scriptExtension}
	
# Priority
* The more request selectors are matched, the better
* A script including the request extension matches better than one without a request extension (html only)
* A script found earlier matches better than a script found later in the processing order