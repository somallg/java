# Chapter 4 - Library Management System 
* This Chapter Covers:
    * A New Liferay Project 
    * Establishing Basic Page flow 
    * Anatomy of a Portlet URL 
    * Creating a Simple Form
    * HTML form to AUI form
    * Injecting 3rd Party Libraries

## 4.1 New Liferay Project

### 4.1.1 Types of portlets with Liferay IDE
* JSF Standard: Standard UI components provided by the JSF runtime
* Liferay Faces Allow: Components that utilize Liferay's Alloy UI technology based on YUI3
* ICEFaces: Components based in part on YUI and jQuery with automatic Ajax and Ajax Push support
* PrimeFaces: Lightweight, zero-configuration JSF UI framework built on jQuery
* RichFaces: Next-generation JSF component framework by JBoss
* Vaadin: A Java framework for building modern web applications which can be run as Portlets inside of Liferay portal

### 4.1.2 SVN Repository

## 4.2 Establishing Basic Page flow
* See example

## 4.3 Anatomy of a Portlet URL

### 4.3.1 Liferay and Search Engine Optimization

## 4.4 Creating a Simple Form
* See example

### 4.4.1 Avoid Hard Coding
* Avoid hard coding of literals inside your code
* Try to externalize them as much as possible
* Benefits: Increase readability and maintainability of the code

### 4.4.2 RenderRequest Vs. ActionRequest
* RenderRequest:
    * Made by invoking a "renderURL"
    * Directly takes the Portlet through its RENDER_PHASE
    * Invokes the "render" method of the Portlet class
    * Similar to HTTP GET method
* ActionRequest:
    * Make by invoking an "actionURL"
    * Takes the Portlet through its ACTION_PHASE followed by RENDER_PHASE
    * Calls the "processAction" method of the Portlet class followed by invocation of "render" method
    * Similar to HTTP POST method
* Fundamental differences between GET and POST
* Note on *ResourceRequest*:
    * Portlet 2.0 spec defines a third type of request called "ResourceRequest" (javax.portlet.ResourceRequest)
    * The Portlet container creates a *ResourceRequest* object and passes it as arguments to the Portlet's *serveResource* method
    * ResourceRequest is usually used to retrieve some resource from the server through the Portlet, e.g a PDF or an image

### 4.4.3 URL Formation
* A HTTP URL makes a request that goes and hits the Web Server 
* A Portlet URL gives rise to a *PortletRequest* that goes and hits the Portal Server/Portlet container. The Portlet container then forwards the request to the appropriate Portlet

### 4.4.4 Usage of tag, portlet:namespace
* Namespace ensures that the given name is uniquely associated with this Portlet and avoids name conflicts with other elements on the portal page or with other portlets on the same page
* It is a best practice to always name space all HTML controls used in our Portlets and also the JavaScript functions to avoid any king of potential conflicts

### 4.4.5 Methods of ParamUtil class
* This class provides very convenient wrapper classes to read different types of values from different types of objects:
    * Portlet request (javax.portlet.PortletRequest)
    * Service Context (com.liferay.portal.service.ServiceContext)
    * Servlet Request (javax.servlet.http.HttpServletRequest)
    
### 4.4.6 Implicit Objects
* The tag *portlet:defineObjects* injects some very useful objects into our JSP. This tag establishes three objects: *renderRequest*, *renderResponse*, and *portletConfig* for use in included Portlet JSP pages as per JSR-168
* JSR-286 has enhanced the inclusion of more implicit objects in the JSP:
    * *renderRequest* and *renderResponse*
    * *resourceRequest* and *resourceResponse*
    * *actionRequest* and *actionResponse*
    * *eventRequest* and *eventResponse
    * *portletSession*
    * *portletPreferences*

## 4.5 HTML form to AUI form
* Alloy is a UI meta-framework that provides a consistent and sample API for building web applications across tall three levels of the browser: structure, style and behavior
* In order to use AUI, you need to include taglib
* By using the *aui* tags, we are no longer required to explicitly use *portlet:namespace*

### 4.5.1 Setting focus on first field
* Using Liferay.Util.focusFormField 

### 4.5.2 Liferay's Custom JavaScript
* Liferay includes a lot of custom JavaScript and many of them are dependent on AlloyUI
* Some common functionality:
    * *Liferay.AutoFields*: contains functions for forms which have fields that repeat
    * *Liferay.ColorPicker*: creates an inline dialog that allows users to pick a color
    * *Liferay.Language*: allows user to get the values of language keys by using JavaScript
    * *Liferay.Notice*: controls the notification area that appears at the top of the screen
    * *Liferay.Panel*: a basic container for content
    * *Liferay.Update*: the widget used by the Document Library portlet to upload files
    * *Liferay.Util*: contains many utility methods for working with document elements and form elements

### 4.5.3 Form Validation
* Use some basic validations to avoid unwanted and irrelevant inputs coming from users   
* Use aui:validator
* The "name" attribute can take on of the following values:
    * alpha: the filed will accept only characters and not digits
    * alphanum: the field will accept both characters and numbers
    * date: the field will accept only dates in the format mentioned within the validator tag
    * digits: positive numbers including zero
    * email
    * equalTo: check if the valued in this field is equal to the value in other field (check password twice)
    * number: both positive and negative values
    * acceptFiles: accept a comma separated list of file
    * min
    * minLength
    * max
    * maxLength
    * range
    * rangeLength
    * required: input field is mandatory
    * url
    * custom: custom JavaScript validation
* A field can have more than one validator    

## 4.6 Injecting 3rd Party Libraries
* Liferay provides the following tags to inject a JavaScript library into our Portlet via *liferay-portlet.xml*:
    * *header-portal-javascript*
    * *header-portlet-javascript*
    * *footer-portal-javascript* and *footer-portlet-javascript*

### 4.6.1 Injecting jQuery library
* See code
   
### 4.6.2 Injecting jQueryUI library and its CSS
* See code

### 4.6.3 Common JavaScript libraries
* There are many JS libraries you can inject into your Portlets using the method described above
* Whenever you include these libraries, it is always better to pull them from their respective CDN (Content Delivery Network) hosts

### 4.6.4 Making a library available for all portlets
* Liferay provides two ways:
    * Including a library at the theme level
    * Injecting through a hook
