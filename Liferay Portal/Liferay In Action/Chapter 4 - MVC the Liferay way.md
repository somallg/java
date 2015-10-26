# Chapter 4 - MVC the Liferay way
* The MVC design pattern
* Liferay's implementation of MVC: MVCPortlet
* Control panel portlets
* Liferay JSP patterns and objects, including **ThemeDisplay**
* Tag libraries such as the search container and AlloyUI Taglibs
* Internationalization in Liferay
* Liferay permissions

## 4.1 Using Model-View-Controller
* By using this pattern, you separate your concerns into various layers of the application
* *Model*: holds the data of the application, and contains any business rules for manipulation that data. Any logic that would change the values based on certain rules would also be part of the model layer
* *View*: contains all the logic for displaying the data to the user
* *Controller*: acts as a traffic director. The Model and View speak only to the controller
* How to implement this design pattern in a portlet ?
* Model layer is generated for you by the Service Builder
* The Portlet acts as a controller
* Liferay has subclassed *GenericPortlet* to provide functionality that make it easy to create MVC applications using portlets: this subclass is *MVCPortlet*
* All of Liferay's portlet plugins are based on *MVCPortlet* instead of *GenericPortlet*
* No need to worry about page management: if you want to determine what JSP to display, all you need to do is point a render parameter called *jspPage* to the location of the JSP
* You don't have to worry about *doView()*, *doEdit()*, or any other *do* method
* Your portlet class doesn't need to implement any portlet-specific APIs
* Your portlet class is simple: all it contains is action methods
* If you wish, you can use any piece of the standard portlet API that you want: MVCPortlet is subclassed from GenericPortlet

### 4.1.1 Edit mode? What Edit mode?
* The inventors of the portlet envisioned a single use for portlets: a web desktop environment for large enterprises
* Liferay has the unique position of being used for internet-based web sites as often as it's used internally for large enterprises: Control Panel

### 4.1.2 MVC according to Liferay
* The portlet class is defined as *com.liferay.util.bridges.mvc.MVCPortlet*, this class is based on *GenericPortlet*
* *MVCPortlet* can do all page management for you, it does so by providing a default view, which is defined as an *init* parameter for each portlet mode
* An alternative pattern: some developers like to use the default implementation of *MVCPortlet* and implement their applications completely wih JSPs. Although this goes again the MVC design pattern, it's a way of doing development is like scripting languages like PHP, Perl, Python

## 4.2 Configuring the portlet project

### 4.2.1 Defining portlets in your deployment descriptors
* Edit portlet.xml, liferay-portlet.xml, liferay-display.xml
* To put you portlet in the Control Panel, you need only tell Liferay you want to do that via its deployment descriptor 

### 4.2.2 Having one location for JSP dependencies
* Liferay follow the pattern of artificial separation between site designers and site programmers
* JSP should be free code as much as possible as not to confuse the side designers
* A design that Liferay uses to make easier is to throw all imports, tag library declarations, and variable initializations in one file called init.jsp
* Every other JSP that is created imports init.jsp so it can take advantage of those declarations
* Liferay objects in JSPs:
    * account: user's Account object
    * colorScheme: an object representing the current color scheme
    * company: current user Company object
    * contact: users' Contact object
    * layout: the page to which the user has currently navigated
    * layoutTypePortlet: this object can be used to programmatically add or remove portlets from a page
    * local: current user's locale
    * permissionChecker: an object that can determine-given a particular resource-whether the current user has a particular permission for that resource
    * plid: portal layout ID
    * portletDisplay: an object that gives the programmer access to many attributes of the current portlet
    * realUser
    * scopeGroupId: contains the groupId for the community or organization in which the portlet resides
    * theme: an object representing the current theme that is being rendered by the portal
    * themDisplay: a runtime object that contains many useful items
    * timeZone: current user's time zone
    * user: the User object representing the current user

## 4.3 Creating a form with AlloyUI taglibs
* MVCPortlet uses an initialization parameter to forward processing to a JSP for the user to view

### 4.3.1 Getting started with AlloyUI tag libraries
* AlloyUI is an *interface metaframework*
* Web site front ends are created using a combination of three technologies: HTML, CSS, and JavaScript 
* HTML provides the overall structure of the document served up by the site, including its content
* CSS provides visual layer
* JavaScript provides interactive elements of any web page
* You can use AlloyUI to solve common problems across the spectrum of HTML, CSS, and JavaScript
* One important way AlloyUI does this is by generating the proper markup for you, it has two types of components: a tag library and a JavaScript API
* If you have a tag that specifies a field in the format *fieldName*, the tag will search the resource bundle for a matching

### 4.3.3 Translating message to multiple languages
* You can provide alternate translation for your message keys
* Int Ant *build.xml*, add *build-lang* and run $ ant build-lang

### 4.3.4 Validating user-submitted forms
* Liferay includes a utility that can perform field validation: *com.liferay.portalkernel.util.Validator*
* Validator has many useful methods, such as *isPhoneNumber()*, *isEmailAddress()* 

### 4.3.5 Displaying data with the search container
* Search Container is a class that works in conjunction with Liferay's UI tag libraries to provide a user interface wrapper around lists of objects
* It wraps the list of objects, and provides features such as pagination and table formatting

### 4.3.6 Using the search container to present your data
* *delta* for pagination
* Set attributes in the *pageContext* so the search container can iterate over them
* After you get the the row to be displayed, all you need to tell Liferay container is the name of the bean it's displaying, *keyProperty* is the primary key, and *modelVar* is the name of the variable that represent your model 
* The last column contains another JSP that defines the action for each row

### 4.3.7 Editing and deleting data
* 



