# Chapter 01 - Struts and Agile Development

# 1. Struts 2 in a nutshell
* Struts 2 reduces (and in most cases eliminates) ties to the servlet specification, making the testing process substantially easier
* Struts 2 also allows Dependency Injection (DI) at many levels, meaning that both testability and re-usability are enhanced

* The request cycle process can be summarized as: "Requests are filtered through interceptors and are implemented by actions. The actions return results, which are executed and returned to the browser"

# 2. The filter dispatcher
* Under standard configuration, Struts 2 gets a chance to process every incoming request
* It is implemented as a filter and mapped to all the requests
* The filter is the first step in processing a Struts 2 request
* Validation, page setup, access to session and request parameters, and so on, are all provided by interceptors


# 3. Interceptors
* Interceptors are similar to Servlet Filters, but specific to Struts 2
* Interceptors are configurable for an entire application, groups of Struts 2 actions, a single action, or any combination thereof
* Many application will need only the interceptors provided by Struts 2, although we might need to configure them differently

# 4. Actions
* About Struts 2's actions:
	* Struts 2's actions are not (generally) tied to the servlet spec
	* They are not required to use any Struts 2-specific constructs
	* The actions handle form data more elegantly than Struts 1's *ActionForm* and return simple strings instead of the *ActionForward* used in Struts 1
	
# 5. Results
* Results determine what will be sent back to the browser, typically a JSP that produces HTML
* Struts 2 has several other result types defined in addition to the standard dispatch to a JSP:
	* redirection
	* redirection to actions
	* action chaining
	* FreeMarker templates
	* file streaming
	* JasperReports

# 6. Plug-ins
* Struts 2 is extensible using its plug-ins mechanism
* Plug-ins can be used to provide addition functionality such as the JasperReports result

# 7. Agile in a nutshell

# 8. Summary
* Struts 2 is a flexible web application framework that can be used to create high-functional applications very quickly
