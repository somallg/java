# Servlets and Scripts

# Servlet Registration
* sling.servlet.methods - the request methods supported by the servlet
* sling.servlet.prefix - prefix or numeric index to make relative paths absolute

* For a Servlet registered as an OSGi service to be used by the Sling Servlet Resolver, either or both of the *sling.servlet.paths* or the *sling.servlet.resourceType* must be set. If neither is set, the Servlet service is ignored
* Each path to be used for registration must be absolute. Any relative path is made absolute by prefixing it with a root path

## Registering a Servlet using Java annotations
1. @SlingServlet
2. @Component, @Service, @Properties

## Servlet Lifecycle Issues
* The provider of the Servlet service take cares of creating the servlet instance
* The Sling Servlet Resolver picks up the Servlet services and initializes and destroys them as needed

# Scripts are Servlets
* From the perspective of the Servlet Resolver, scrips and servlets are handled exactly the same
* Internally, Sling only handles with Servlets, whereas scripts are packed inside a Servlet wrapping and representing the script

# Default Servlet(s)
* A default Servlet is selected if no servlet (or script) for the current resource type can be found
* The actual Servlet or Script called as the default Servlet is resolved exactly the same way as for any resource type