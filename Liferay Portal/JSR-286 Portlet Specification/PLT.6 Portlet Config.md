# PLT.6 Portlet Config
* The *PortletConfig* object provides the portlet object with information to be used during initialization. It also provides access to the Portlet context, default event namespace, public render parameter names, and the resource bundle that provides title-bar resources

## PLT.6.1 Initialization Parameters
* The *getInitParameterNames* and *getInitParameter* methods of the *PortletConfig* interface return the initialization parameter names and values found in the Portlet definition in the deployment descriptor

## PLT.6.2 Portlet Resource Bundle
* Portlets may specify, in their deployment descriptor definition, some basic information that can be used for the portlet title-bar and for the portal's categorization of the Portlet. The spec defines a few resource elements for these purposes, title, short-title and keywords
* These resource elements can be directly included in the portlet definition in the deployment descriptor, or they can be placed in the resource bundle
* If the resources are defined in a resource bundle, the Portlet must provide the name of the resource bundle 
* If the Portlet definition defines a resource bundle, the portlet-container must look up these values in the ResourceBundle. If the root resource bundle does not contain the resources for these values and the values are defined inline, the portlet container must add the inline values as resources of the root resource bundle
* If the portlet definition does not define a resource bundle and the information is defined inline in the deployment descriptor, the portlet container must create a *ResourceBundle* and populate it, with the inline values, using the key defined in *PLT.25.10 Resource Bundles* Section
* The *render* method of the *GenericPortlet* uses the *ResourceBundle* object of the *PortletConfig* to retrieve the title of the portlet from the associated ResourceBundle or the inline information in the portlet definition

## PLT.6.3 Default Event Namespace
* The *getDefaultNamespace* method of the *PortletConfig* interface returns the default namespace for events and public render parameters set in the Portlet deployment descriptor with the default-namespace element, or the XML default namespace *XMLConstants.NULL_NS_URI* if no default namespace is provided in the portlet deployment descriptor

## PLT.6.4 Public Render Parameter Names
* The *getPublicRenderParameterNames* method of the *PortletConfig* interface returns the public render parameter names found in the portlet definition in the deployment descriptor with the *supported-public-render-parameter* element or an empty enumeration if no public render parameters are defined for the current portlet definition

## PLT.6.5 Publishing Event QNames
* The *getPublishingEventQName* method of the *PortletConfig* interface return the publishing event QNames found in the portlet definition in the deployment descriptor with the *supported-publishing-event* element or an empty enumeration if no publishing events are defined for the current portlet definition
* If the event was defined using the *name* element instead of the *qname* element the defined default namespace must be added as namespace for the returned QName

## PLT.6.7 Supported Locales
* The *getSupportedLocales* method of the *PortletConfig* interfaces returns the supported locales found in the portlet definition in the deployment descriptor with the *supported-locale* element or an empty enumeration if no support locales are defined for the current portlet definition

## PLT.6.8 Supported Container Runtime
* The *getContainerRuntimeOptions* method returns an immutable Map containing Portlet application level container runtime options merged with the Portlet level container runtime options, containing the names as keys and the container runtime values a map values, or an empty Map if no portlet application level or portlet level container runtime options are set in the *portlet.xml*
* The map returned returned from *getContainerRuntimeOptions* will provide the subset the portlet container supports of the options the portlet has specified in the portlet deployment descriptor. The keys in the map are of type String. The values in the map are of type String array
* If a container runtime option is et on the Portlet application level and on the portlet level with the same name the settings on the Portlet level takes precedence and overwrites the one set on the portal application level
