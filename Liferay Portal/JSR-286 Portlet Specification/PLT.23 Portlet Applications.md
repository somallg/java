# PLT.23 Portlet Applications
* Portlet application is a web application, containing Portlets and Portlet deployment descriptor in addition to Servlets, JSPs, HTML pages, classes and other resources normally found in a web application
* A bundle Portlet application can run in multiple Portlet containers implementations

## PLT.23.1 Relationship with Web Application
* All the Portlet application components and resources other than Portlets are managed by the Servlet Container that the Portlet container is built upon

## PLT.23.2 Relationship to PortletContext
* Portlet container must enforce a one to one correspondence between a Portlet application and a *PortletContext*
* If the application is distributed, Portlet container must create an instance per VM
* *PortletContext* provides a Portlet with its view of the application

## PLT.23.3 Elements of a Portlet Application
* Portlet application may consist of Portlets plus other element that may be included in web applications, such as Servlets, JSP pages, classes, static documents
* Besides web application meta information, Portlet application must include meta information about the Portlets it contains

## PLT.23.4 Directory Structure
* Portlet application follows the same directory hierarchy structure as web applications
* In addition it must contain a */WEB-INF/portlet.xml* deployment descriptor file
* Portlet classes, utility classes and other resources accessed through the Portlet application classloader must reside within the */WEB-INF/classes* directory or with a *JAR* file in */WEB-INF/lib* directory

## PLT.23.5 Portlet Application Classloader
* Portlet container must use the same classloader the Servlet container uses for the web application resources for loading the Portlets and related resources within the Portlet application

## PLT.23.6 Portlet Application Archive File
* Portlet application are packaged as web application archives *WAR*

## PLT.23.7 Portlet Application Deployment Descriptor
* In addition to a web application, Portlet application contains a Portlet application deployment descriptor (configuration information for the Portlets in the application)

## PLT.23.8 Replacing a Portlet Application
* Portlet container should able to replace a Portlet application with a new version without restarting the container
* Portlet container should provide a robust method for preserving session data within the Portlet application, when the replacement of Portlet application happens

## PLT.23.9 Error Handling
* It is left to the Portal/Portlet container to react when a Portlet throws an exception while processing a request
* For example, the Portal/Portlet container could:
    * render an error page instead of a Portal page
    * render an error message in the Portlet window of the Portlet that threw the exception
    * remove the Portlet from the Portal page and log an error message for the administrator

## PLT.23.10 Portlet Application Environment
* Portlet specification leverages the provisions made by *Servlet Specification SRV.9.11 Section*