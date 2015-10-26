# Chapter 01 - Introduction
* Developing applications for Liferay
* Extending and customizing Liferay
* Choosing your development tools

## Developing applications for Liferay
* A portal application is a web application that can coexist with other application
* Liferay supports: **Portlets** and **OpenSocial gadgets**

## Portlets
* Portlets are small web applications written in Java that run in a portion of a web page
* The heart of any portal implementation is its portlet, because they contain the actual functionality

## OpenSocial Gadgets
* It's designed specially to implement social applications
* Liferay lets you expose portlets to the outside world as OpenSocial gadgets

## Reusing existing web applications
* Rewrite the application as a portlet
* Create simple portlet that interact with the application (using Web Services)
* Create an OpenSocial gadget as a wrapper for the application
* Create a portlet that integrates the remote application either using an IFrame or an HTTP proxy
* If the application using Struts 1.x, it can be converted to a portlet with few changes
* If the application using JSF, it can be converted to a portlet with few changes

## Supported technology frameworks
* *Use what you know*
* *Adapt to your real needs*
* *When in doubt, pick the simpler solution*
* *AlloyUI* based on YUI3 for modern user interfaces
* Service Builder automates creating interfaces and classes for database persistence and service layers

## Extending and customizing Liferay
* Liferay provides many out-of-the-box features: CMS (Content Management System), a social collaboration suite,...

## Customizing the look and feel: Themes
* Apply styling UI elements such as fonts, links, navigation elements, page headers, and page footers
* Themes let you focus on designing your site's UI, while leaving its functionality to the portlets

## Adding new predefined page layouts: Layout Templates
* Similar to Themes, except they specify the *arrangement* of the portlets on the page rather then their look and feel

## Customizing or extending the out-of-box functionality: Hook plugins
* Hook plugins are how you customize the core functionality for Liferay
* Hook plugins are used to modify portal or to perform custom action on startup, shutdown, login, logout, session creation, and session destruction

## Advanced customization: Ext plugins
* Provide the largest degree of flexibility in modifying the Liferay core, allow you to replace essentially any class with a custom implementation
* Server must be restarted for Ext plugins to take effect

## Choosing your development tools
* To develop plugins:
    * A command-line environment that integrates with a wide variety of tools: **Apache Ant and the Plugins SDK*
    * An easy-to-use IDE that minimizes your learning curve while giving you powerful development features **Eclipse and the Liferay IDE**
