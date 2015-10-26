# PLT.8 Portlet Modes
* A Portlet mode indicates the function a Portlet is performing in the *render* method
* Normally, Portlets perform different tasks and create different content depending on the function they are currently performing
* A Portlet mode advises the Portlet what task it should perform and what content it should generate
* When invoking a Portlet, the Portlet container provides the current Portlet mode to the Portlet
* Portlets can programmatically change their Portlet mode when processing an Action Request
* The Portlet Specification defines three Portlet modes, *VIEW*, *EDIT*, and *HELP*. The *PortletMode* class defines constants for these Portlets modes
* The availability of the Portlet modes, for a Portlet, may be restricted to specific user roles by the Portal. For example, anonymous users could be allowed to use the *VIEW* and *HELP* Portlet modes but only authenticated users could use the *EDIT* Portlet mode

## PLT.8.1 VIEW Portlet Mode
* The expected functionality for a Portlet in *VIEW* mode is to generate markup reflecting the current state of the Portlet
* For example, the *VIEW* mode of a Portlet may include one or more screens that the user can navigate and interact with, or it may consist of static content that does not require any user interaction
* Portlet developers should implement the *VIEW* portlet mode functionality by overriding the *doView* method of the *GenericPortlet* class
* Portlets must support the *VIEW* mode

## PLT.8.2 EDIT Portlet Mode
* Within the *EDIT* mode, a Portlet should provide content and logic that lets a user customize the behavior of the Portlet
* The *EDIT* mode may include one or more screens among which users can navigate to enter their customization data
* Typically, Portlets in *EDIT* mode will set or update Portlet preference
* Portlet developers should implement the *EDIT* mode functionality by overriding the *doEdit* method of the *GenericPortlet* class
* Portlets are not required to support the *EDIT* portlet mode

## PLT.8.3 HELP Portlet Mode
* When in *HELP* portlet mode, Portlet should provide help information about the Portlet
* This help information could be a simple help screen explaining the entire portlet in coherent text or it could be context-sensitive help
* Portlet developers should implement the *HELP* mode functionality by overriding the *doHelp* method of the *GenericPortlet* class
* Portlets are not require to support the *HELP* mode

## PLT.8.4 Custom Portlet Modes
* Portal vendors may define custom Portlet modes for vendor specific functionality for modes that need to be managed by the Portal
* Portlets may define additional modes that don't need to be managed by the Portal and correspond to the *VIEW* mode from a Portal point of view
* The Portlet must declare portlet modes that are not managed by the Portal via the *portal-managed* = false tag
* Portlet modes are considered Portal managed by default
* Portlets must define the custom portlet modes they intend to use in the deployment descriptor using the *custom-portlet-mode* element
* Portlets that list custom portlet modes that are not managed by the Portal may provide a localized decoration name as resource bundle entry with the key *javax.portlet.app.custom-portlet-mode.name.decoration-name* for this portlet mode
* If no entry in the resource bundle with such name exists the portal/portlet-container should use the portlet mode name as default decoration name
* If a custom portlet mode defined in the deployment descriptor is not mapped to a custom portlet mode provided by the Portal or otherwise supported as non-managed portlet mode, Portlets must not be invoked in that mode

## PLT.8.5 GenericPortlet Render Handling
* The *GenericPortlet* class implementation of the *render* method dispatches requests to the methods annotated with the tag *@RenderMode(name=portlet mode name)
* The method must have following signature:
    * void methodName(RenderRequest, RenderResponse) throws PortletException, IOException;
* If no matching annotated method is found, *GenericPortlet* will dispatch to the *doView*, *doEdit* or *doHelp* method depending on the Portlet mode indicated in the request using the *doDispatch* method or throws a *PortletException* if the mode is not *VIEW*, *EDIT*, or *HELP*

## PLT.8.6 Defining Portlet Modes Support
* Portlets must describe within their definition, in the deployment descriptor, the portlet modes they can handle for each markup type they support in the *render* method
* As all portlets must support the *VIEW* mode, *VIEW* does not have to be indicated
* The Portlet must not be invoked in a portlet mode that has not been declared as supported for a given markup type
* The Portlet container must ignore all references to custom portlet modes that are not supported by the portal implementation, or that have no mapping to portlet modes supported by the Portal

## PLT.8.7 Setting next possible Portlet Modes
* Via the renderResponse the Portlet can set next possible portlet modes that make sense from the portlet point of view
* If set, the Portal should honor these enumeration of portlet modes and only provide the end user with choices to the provided portlet modes or a subset of these modes based on access control considerations
* In order to ensure that the next possible portlet modes are honored by all portal implementations, the portlet should set the *javax.portlet.renderHeaders* container runtime option and either overwrite the *getNextPossiblePortletModes* method in the *GenericPortlet* or set the next possible portlet modes in the *RENDER_HEADERS* of the render phase via *setNextPossiblePortletModes*
* This allow the portal receives these suggested new modes before writing the portal window decorations and thus is able to optimize the amount of buffering needed
    
    