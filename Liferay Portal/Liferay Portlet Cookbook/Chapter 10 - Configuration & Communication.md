# Chapter 10 - Configuration & Communication
* This Chapter Covers:
    * Static Portlet Preferences
    * Dynamic Portlet Preferences
    * Reading from properties files
    * Continuation of Firing Emails from Portlets
    * Portlet Data Handlers - Export / Import
    * Inter-Portlet Communication
    * Non-Standard ways of IPC
    * Portlet URL Invocation
    * Customizing Portlet Based on Query String

## 10.1 Static Portlet Preferences
* WORA: Write Once Run Anywhere
* Various options that are available in Liferay in order to make a Portlet highly configurable and customizable

### 10.1.1 Specifying preferences via "portlet.xml"
* The spec has defined an interface exclusively for the preferences: *javax.portlet.PortletPreferences*
* A preference is supplied with the help of *init-param* tag
* *copy-request-parameters* used to copy the request parameter from the request to the response. This is useful in cases where you do validation on a form and wish to repopulate the form with the input value in case of errors
* *add-process-action-success-action*: set to false to disable Liferay status message 
* You can set any number of preferences in **portlet.xml** using *init-param* tag
* You can receive the value using *getInitParameter(String name)*
* *getInitParameterNames()* return an Enumeration<String> of all preferences that are available 

### 10.1.2 Disabling "success" messages post an Action
* Adding *init-param* in **portlet.xml**
* Override *init()* method in the Portlet class, and set *addProcessActionSuccessMessage* to false

### 10.1.3 Accessing a preference inside JSP
* *portletConfig.getInitParameter()*

## 10.2 Dynamic Portlet Preferences
* In the static way of setting the Portlet Preferences through *portlet.xml* there are limitations:
    * We can't modify the preference during runtime

### 10.2.1 Dynamic Preferences through edit mode
* Enable Edit mode for the Portlet:
    * add *init-param*, *edit-template* with value /html/library/edit.jsp
    * Insert *portlet-mode* edit, inside *supports* tag
* Create edit.jsp
* Define a new processAction method *setPreferences*
* Get PortletPreferences using request.getPreferences();
* Save preferences using: preferences.setValue, preferences.store
* To retrieve this value back in our JSP file. Using *portletPreferences* (an object injected by *portlet:defineObjects*

### 10.2.2 Setting preferences the Liferay Way
* Inside *liferay-portlet.xml* add the tag after *icon*: *configuration-action-class* com.liferay.portal.kernel.portlet.DefaultConfigurationAction

### 10.2.3 Archival and Restoration of Preferences

### 10.2.4 Preferences Entries in Liferay Deployment Descriptor
* preferences-company-wide
* preferences-owned-by-group

## 10.3 Reading from properties file

## 10.5 Portlet Data Handlers - Export / Import

## 10.6 Inter-Portlet Communication
* Portlets have partners with whom they can communicate, talk, and exchange messages either directly through the environment (browser) or through the on who is controlling them from behind (portal server)
* JSR-286 or Portlet 2.0 Spec defines two different means of coordination/communication between the Portlet that want to have partnership:
    * Events
    * Public Render Parameters
* IPC helps in increasing user experience by decoupling a bigger application into smaller parts (portlets)
* Portlet 2.0 specifications calls the parties involved in a communication as a *publisher* and a *listener*    
* A publisher is the on who triggers or fires an event
* A listener listens to that event and act accordingly based on the message
* A trigger could be a simple *message* or an instruction or a *payload* attached, ie *data*

### 10.6.1 Server-Side Eventing
* Portlet 2.0 spec allow portlets to send and receive events 
* Create a new TriggerPortlet
* Define action in TriggerPortlet view.jsp
* In TriggerPortlet, Create QName and response.setEvent()
* In *portlet.xml*, define new event *event-definition* with *qname* and *value-type*. Add Publisher: *supported-publishing-event*. Add Listener: *supported-processing-event*
* In the Listener class, you can either:
    * Define new method and annotate with @ProcessEvent(qname)
    * Override *public void processEvent(EventRequest request, EventResponse response)*
    * Get Event = request.getEvent()

### 10.6.2 Public Render Parameters (PRP)
* What is a *render* parameter ? Just like Servlets a Portlet does not maintain state within the Portlet object
* Many request, from many different users, may use an instance of a portlet at the same time
* Render parameters are used to maintain the state of a Portlet that is otherwise stateless
* Public render parameters allow JSR 286 portlets to share navigational state information
* They are especially useful for coordinating the multiple navigation or viewer portlets that display different information items that are all related to the same parameter name
* First and foremost we have to register a public render parameter, declare a PRP inside *portlet.xml*
* The main purpose of PRP is to pass parameters from one Portlet to the other Portlet, mostly in the same page
* The Portlet container as before moderates this parameter passing but the limitation is only String literals ca be set as parameters (payloads) and not object as in the case of Event
* The other limitation is the sharing scope always applies to all parameters of all portlets on a page

## 10.7 Non-Standard ways of IPC

### 10.7.1 Portlet Session Sharing
* The PortletSession interface provides a way to identify a user across more than one request and to store transient information about that user
* The PortletSession interface defines two scopes for storing objects:
    * APPLICATION_SCOPE
    * PORTLET_SCOPE
* Inside any JSP, the *portletSession* is available as an implicit object and is injected by the tag *portlet:defineObjects*    
* Inside the Portlet class the object is retrieved from the portletRequest object
* Once this object is available, you can bind objects (*attributes*) to it

### 10.7.2 Sharing session variable across WARs
* Portlet 2.0 IPC mechanism (PRP, Events) are restricted to ACTION-to-VIEW
* ACTION-to-VIEW is on "action phase" of one portlet information is shared and made available to specific/all portlet's "view phase"
* Liferay provides a mechanism by which Portlets can share session attributes across WARs
* Set entry in *liferay-portlet.xml*: *private-session-attributes* to false
* Use Namespace prefix to Set/Get shared session attributes
* By default *LIFERAY_SHARED_* prefix is used for sharing session attribute to other WARs (it can be customized through the *session.shared.attributes* entry in *portal.properties*)

### 10.7.3 Obtaining a handle to HttpSession
* The theme is not aware of PortletSession
* To get a handle to the HttpSession inside the Portlet class and bind any object to that handle:
httpServletRequest = PortletUtil.getHttpServletRequest(request)
* httpServletRequest.getSession();

### 10.7.4 Client-side Eventing
* This non-standard mechanism of IPC works purely based on manipulating the browser's DOM object with the help of JavaScript
* Liferay provides two JavaScript functions to achieve this kind of IPC - *Liferay.fire()* and *Liferay.on()*

## 10.8 Portlet URL Invocation
* Liferay provides two ways of creating a Portlet URL: one is using a special kind of tag and the other uses a special API that Liferay provides

### 10.8.1 Using the tag
* *liferay-portlet:* tag

### 10.8.2 Using the Util class
* PortletURLFactoryUtil.create

### 10.8.3 Namespace problem during ActionURL call
* set *useNamespace* of *aui:form* to false
* Whenever we use *var* to create a Portlet URL either using Portlet 2.0 or *liferay-portlet* tag, we need not have to use the *toString()* function on it, as the variable that is created is ready of String format

### 10.8.4 Calling Portlet In Another Page
* Using the above two methods, you can even invoke a Portlet that is siting in another page
* All we need is the *plid* of the other page

### 10.8.5 Dynamic URL Formation though JavaScript
* Liferay lets you build PortletURLs using JavaScript on the fly in the browser itself
* Liferay.PortletURL.createActionURL();

## 10.9 Customizing Portlet Based on Query String

### 10.9.1 Another Classical Usecase

## Summary
