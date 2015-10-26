# Chapter 3 - Setting the stage with Liferay IDE 
* This Chapter Covers:
    * New Liferay Server
    * Basic Configuration
    * Pointing Liferay to MySQL Database
    * New Liferay SDK
    * New Liferay Project

## 3.1 New Liferay Server

## 3.2 Basic Configuration

## 3.3 Pointing Liferay to MySQL Database
* **Omni User**: super user
* Liferay will create 180+ tables:
    * **System (Portal) tables**: the tables that are used by the portal, usually end with an underscore ("_")
    * **Portlet tables**: the tables that are used by the various portlets that come bundled with Liferay
    
### 3.3.1 Initial Cleanup    

## 3.4 New Liferay SDK

## 3.5 New Liferay Project

### 3.5.2 Anatomy of "my-first" Portlet
* Configuration Files: all configuration files are under **docroot/WEB-INF**:
    * *portlet.xml*: this is the central Portlet deployment descriptor that conveys the information about the Portlet to the Portlet container where it is getting executed. *Required* of JSR-286
    * *liferay-portlet.xml*: this file contains the information about additional Portlet features that Liferay has built on top of JSR-286 Portlet specification
    * *liferay-display.xml*: this file contains the information about placing of the Portlet in a particular hierarchy when it is displayed in the **Add** -> **More**
    * *liferay-plugin-package.properties*: this file contains some information that helps during the packaging of the portlet as a deployable WAR file
    * *web.xml*: since all the portlets are deployed as a web application, we need this deployment descriptor for this portlet as well
* Other Files:
    * *icon.png*: is the icon displayed for this portlet that appears on the portlet title bar
    * *view.jsp*: the default view of the portlet that appears when the portlets gets rendered on the portal page
    * *css* folder: contains all the style sheet files used by this portlet
    * *js* folder: contains all the javascript files used by this portlet
    * *src* folder: will house all the source code (.java files)
    * *lib* folder: will house all the jar files that will be used by the java files present in this portlet under *src*
* Plugin Packaging: a plugin is a highly re-usable, inter-operable component. It is good practice to package all the hooks in your application as one single plugin project, all themes and layouts as one single plugin plugin project, all portlets or logically related portlets as one single plugin project    

### 3.5.3 Visual Elements of a Portlet
* At the bare minimum, a Portlet is made up of these building blocks:
    * Configuration files: portlet.xml, liferay-portlet.xml
    * Source files: portlet class and other class files that have the functionality
    * Views: JSP files and xhtml files that define the view of the Portlet
    * JavaScript and CSS
* A Portlet has *header*, *body* and *footer* sections, Portlet's actual content appears in its body section 
* *Edit Controls*:
    * *Look and Feel*: we can override the default appearance of the Portlet set at the theme level
    * *Configuration*: we can set the preferences for the Portlet
    * *Export/Import*: we can export the Portlet data or its settings in the form of a LAR file
* **Portlet Modes**: 
    * A Portlet mode indicates the function a Portlet is performing.Portlets can programmatically change their Portlet mode when processing an action request. According to JSR-286 spec a Portlet can have three modes: *View* (default), *Edit* and *Help*. Liferay has added six more modes: *About*, *Config*, *Edit*, *Defaults*, *Edit Guest*, *Preview* and *Print*
* **Windows States**: The WindowsState class of a Portlet represents the possible window states that a portlet window can assume:
    * *MAXIMIZED*: indicates that a Portlet may be the only Portlet being rendered in the portal page
    * *MINIMIZED*: the Portlet should only render minimal output or no output at all
    * *NORMAL*: Portlet may be sharing the page with other Portlets
    * Liferay has extended couple of more window states: EXCLUSIVE and POP_UP
* **Portlet Lifecycle**: 
* The Portlet 1.0 standard defines two lifecycle phases for the execution of a Portlet:
    * *javax.portlet.PortletRequest.RENDER_PHASE*, in which the Portlet container ask each Portlet to render itself as a fragment of HTML
    * *javax.portlet.PortletRequest.ACTION_PHASE*, in which the Portlet container invokes actions related to HTML form submission
* The Portlet 2.0 standard add two more lifecycle phases that define the execution of a Portlet:
    * *javax.portlet.PortletRequest.EVENT_PHASE*, in which the Portlet container broadcasts events that are the results of an HTML form submission
    * *javax.portlet.PortletRequest.RESOURCE_PHASE*, in which the Portlet container asks a specific Portlet to perform resource-related processing

### 3.5.4 Liferay Marketplace
    

    
