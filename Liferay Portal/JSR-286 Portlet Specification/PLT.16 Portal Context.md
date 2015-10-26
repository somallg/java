# PLT.16 Portal Context
* *PortalContext* interface provides information about the portal that is invoking the Portlet
* *getPortalInfo* method returns information such as the Portal vendor and Portlet version
* *getProperty* and *getPropertyNames* methods return portal properties
* *getSupportedPortletModes* return the modes supported by the portal
* Portlet obtains a *PortalContext* object from the request object using *getPortalContext* method

PLT.16.1 Support for Markup Head Elements
* Portals should indicate if they support the *MimeResponse* property *MimeResponse.MARKUP_HEAD_ELEMENT* (value *javax.portlet.markup.head.element*) by providing the *PortalContext.HTML_HEAD_ELEMENT_SUPPORT* (value *javax.portlet.markup.element.support*) property on the *PortalContext*
* A non-null value of *MARKUP_HEAD_ELEMENT_SUPPORT* indicates that the Portal application support the MARKUP_HEAD_ELEMENT* property
