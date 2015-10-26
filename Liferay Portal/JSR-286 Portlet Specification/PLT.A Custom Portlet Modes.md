# PLT.A Custom Portlet Modes
* Portal may provide support for custom Portlets modes
* Similarly, Portlets may use custom Portlets modes
* Portlets should use the *getSupportedPortletModes* method of the *PortalContext* interface to retrieve the Portlet modes the Portal supports

## PLT.A.1 About Portlet Mode
* *about* Portlet mode should be used by the Portlet to display information on the Portlets purpose, origin, version text
* Portlet developers should implement the *about* Portlet mode functionality by using the *@RenderMode(name="about")* annotation by the *GenericPortlet* class

## PLT.A.2 Config Portlet Mode