# PLT.25 Packaging and Deployment Descriptor
* The deployment descriptor conveys the elements and configuration information of Portlet application between Applications Developers, Application Assemblers, and Deployers
* Portlet application are self-contained applications that are intended to work without further resources, managed by the Portlet container
* In case of Portlet application, there are two deployment descriptors:
    * one to specify web application resources *web.xml*
    * one to specify portlets resources *portlet.xml*
    
## PLT.25.1 Portlet and Web Application Deployment Descriptor
* In the Portlet Specification, there is a clear distinction between web resources like Servlets, JSPs, static markup pages, etc.., and Portlets
* This is due to the fact that, in *Servlet Specification*, the web application deployment descriptor is not extensible
* All web resources that are not Portlets, must be specified in the *web.xml*
* All Portlets and Portlet related setting must be specified in additional file *portlet.xml*
* The following portlet web application properties can be set in the *web.xml*:
    * portlet application description: *description* element
    * portlet application name: *display-name* element
    * portlet application security role mapping: *security-role*
    * portlet application locale-character set: *locale-encoding-mapping-list*

## PLT.25.2 Packaging
* All resources, Portlets and the deployment descriptor are packaged together in one web application archive *WAR*
* In addition to the resources described in the *Servlet Specification, SRV.9 Web Application*, a Portlet application *WEB-INF* directory consists of:
    * Deployment descriptor */WEB-INF/portlet.xml*
    * Portlet classes */WEB-INF/classes*
    * Portlet Java ARchive */WEB-INF/lib/*.jar*
    
### PLT.25.2.1 Example Directory Structure
* Portlet applications that need additional resources that cannot be packaged in the *WAR* file, like EJBs, may be packaged together with these resources in an *EAR* file

### PLT.25.2.2 Version Information
* If Portlet application provides want to provide version information about the Portlet application, it is recommended to provide a *META-INF/MANIFEST.MF* entry in the *WAR* file
* The *Implementation-** attributes should be used to define the version information

### PLT.25.3 Portlet Deployment Descriptor Elements
* The following types of configuration and deployment information are required to be supported in the Portlet deployment descriptor for all Portlet containers:
    * Portlet Application Definition
    * Portlet Definition
* Security information, which may also appear in the deployment descriptor is not required to be supported unless the Portlet container is part of an implementation of J2EE spec

## PLT.25.4 Rules for processing the Portlet Deployment Descriptor
* Portlet containers should ignore all leading whitespace characters before the first non-whitespace character, and all trailing whitespace characters after the last non-whitespace character for *PCDATA* within text nodes of a deployment descriptor
* Portlet containers and tools that manipulate Portlet applications have a wide range of options for checking the validity of *WAR*

## PLT.25.5 Portlet Deployment Descriptor

## PLT.25.7 Uniqueness of Deployment Descriptor Values
* The following deployment descriptor values must be unique in the scope of Portlet application definition:
    * portlet *portlet-name*
    * custom-portlet-mode *portlet-mode*
    * custom-window-state *window-state*
    * user-attribute *name*
    * event definition *name* and *qname*
    * public-render-parameter *name* and *qname*
    * filter *filter-name*
* The following deployment descriptor values must be unique in the scope of the Portlet definition:
    * init-param *name*
    * supports *mime-type*
    * preference *name*
    * security-role-ref *role-name*
    * *supported-processing-event*
    * *supported-publishing-event*
    * *supported-public-render-parameter*
    
## PLT.25.8 Localization
* Portlet deployment descriptor allows for localization on two levels:
    * Localize values needed at deployment time
    * Advertise supported locales at run-time

### PLT.25.8.1 Localization of Deployment Descriptor Values
* Allows the deployment tool to provide localized deployment messages to the deployer
* The following deployment descriptor elements may exist multiple times with different locale information in the *xml:lang* attribute:
    * all *description* elements
    * portlet *display-name*
* The default value for the *xml:lang* attribute is English (*en*)    
* The preferred method for localization of values in the deployment descriptor is providing a resource bundle via the *resource-bundle* element on the Portlet application level

### PLT.25.8.2 Locales Supported by the Portlet
* Portlet should always declare the locales it is going the support at run-time using *supported-locale* element in the deployment descriptor

## PLT.25.9 Deployment Descriptor Example
  
## PLT.25.10 Resource Bundles
* As an alternative to embedding all localized values in the deployment descriptor the Portlet can provide a separate resource bundle containing the localized values
* Providing localized values via resource bundles is the preferred way, as it allows the separation of deployment descriptor values from localized values
* For language specific Portlet application, the class name of the resource bundle can be set in the deployment descriptor using *resource-bundle* element on the Portlet application level
