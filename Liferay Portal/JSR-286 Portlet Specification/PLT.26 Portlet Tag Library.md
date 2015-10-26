# PLT.26 Portlet Tag Library
* Portlet tag library enables JSPs, that are included from Portlets, to have direct access to Portlet specific element such as the request, like *RenderRequest* or *ResourceRequest*, and response, like *ActionResponse* or *RenderResponse*
* It also provide JSPs with access to Portlet functionality such as creation of Portlet URLs
* JSP pages using the tag library must declare this in a taglib like this:
    * *%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%*

## PLT.26.1 defineObjects Tag
* *defineObjects* tag must define the following variables in the JSP page:
    * *RenderRequest* when included from within the *render* method
    * *ResourceRequest* when included from within the *serveResource* method
    * *ActionRequest* when included from within the *processAction* method
    * *EventRequest* when included from within the *processEvent* method
    * *RenderResponse*
    * *ResourceResponse*
    * *ActionResponse*
    * *PortletConfig*
    * *PortletSession*, providing access to the *PortletSession*, does not create a new session, only return an existing session
    * *Map<String, Object> portletSessionScope*, providing access to the *PortletSession* attributes as Map, equivalent to *PortletSession.getAttributeMap()*
    * *PortletPreferences*
    * *Map<String, String[]> portletPreferencesValue*
* A JSP using the *defineObjects* tag may use these variables from scriptlet throughout the page
* *defineObjects* tag must not define any attribute and it must not contain any body content

## PLT.26.2 actionURL tag
* *actionURL* tag creates a URL that must point to the current Portlet and must trigger an action request with the supplied parameters
* Parameters may be added to the URL by including the *param* tag between *actionURL* start and end tags
* The following *non-required attributes* are defined of this tag:
    * *windowState* - indicates the window state that the Portlet should have when this link is executed
    * *portletMode* - indicates the portlet mode that the Portlet must have when this link is executed
    * *var* - name of the exported scoped variable for the action URL
    * *secure* - indicates if the resulting URL should be secure connection or not
    * *copyCurrentRenderParameters* - if set to *true*, the private render parameters of the Portlet of the current request must be attached to this URL. It is equivalent to setting each of the current private render parameters via the *portlet:param* tag
    * *escapeXML* - determine whether characters <, >, &, ', " in the resulting output should be converted to their corresponding character entity codes
    * *name* - specifies the name of the action that can be used by *GenericPortlet* to dispatch to methods annotated with *ProcessAction*
* Example of JSP using *actionURL*:
    * *portlet:actionURL copyCurrentRenderParameters="true" windowState="maximized" portletMode="edit" name="editStocks"

## PLT.26.3 renderURL Tag
* *renderURL* tag creates a URL that must point to the current Portlet and must trigger a render request with the supplied parameters
* Parameters may be added by including the *param* tag between the *renderURL* start and end tags
* The following *non-required attributes* are defined for this tag:
    * *windowState*
    * *portletMode*
    * *var* 
    * *secure*
    * *copyCurrentRenderParameters*
    * *escapeXML*

## PLT.26.4 resourceURL Tag
* *resourceURL* tag creates a URL that must point to the current portlet and must trigger a *serveResource* request with the supplied parameters
* *resourceURL* must preserve the current portlet mode, window state and render parameters
* Parameters may be added by including the *param* tag between the *resourceURL* start and end tags
* If such a parameter has the same name as a render parameter in this URL, the render parameter vale must be the last value in the attribute value array
* The following *non-required attributes* are defined for this tag:
    * *var*
    * *secure*
    * *escapeXML*
    * *id* - sets ID for this resource. The ID can be retrieve in the *serveResource* call from the request via the *getResourceID* method
    * *cacheability* - define the cacheability of the markup returned by this resource URL. Valid values are: "FULL", "PORTLET", and "PAGE" (default)
 
## PLT.26.5 namespace Tag
* This tag produces a unique value for the current Portlet and must match the value of the *PortletResponse.getNamespace* method
* This tag should be used for named elements in the Portlet output (such as JavaScript functions and variables)
* The namespacing ensures that the given name is uniquely associated with this portlet and avoids name conflicts with other elements on the portal page or with other Portlets on the page
* *namespace* tag must not allow any body content
* Example of a JSP using the *namespace* tag:
    * a href="javascript:<portlet:namespace/>doFoo()"
* The example prefixes a JavaScript function with the name *doFoo*, ensuring uniqueness on the portal page

## PLT.26.6 param Tag
* This tag defines a parameter that may be added to an *actionURL*, *renderURL*, or *resourceURL*
* *param* tag must not contain any body content
* If the *param* tag has an empty value, the specified parameter name must be removed from the URL
* The following *required attributes* are defined for this tag:
    * *name* - the name of the parameter to add to the URL. If *name* is null or empty, no action is performed
    * *value* - the value of the parameter to add to the URL. If *value* is null, it is processed as an empty value
* Example of a JSP using *param* tag:
    * *portlet:param name="myParam" value="someValue"

## PLT.26.7 property Tag
* This tag defines a property that may be added to an *actionURL, *renderURL*, or *resourceURL* and is equivalent to the API call *addProperty*
* *property* tag should not contain any body content
* The following *required attributes* are defined for this tag:
    * *name* - the name of the property to add to the URL
    * *value* - the value of the property to add to the URL
* Example of a JSP using the *param* tag:
    * *portlet:property name="myProperty" value="someValue"

## PLT.26.8 Changing the Default Behavior of escapeXML
