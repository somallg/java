# Concepts of the AEM Touch-Optimized UI
* AEM 5.6, Adobe has introduced *touch-optimized* with *responsive design*

# AEM Technology Stack
* AEM uses the Granite as a base

# Granite
* What? Adobe's Open Web Stack
* Provides?
	* Application launcher
	* OSGi framework
	* Number of OSGi compendium services
	* Logging Framework
	* CRX Repository
	* Apache Sling
	* Addition parts of the CRX
	
# Granite UI
* Uses RESTful architecture of Sling
* Implements component libraries for building content-centric web app
* Provides granular UI widgets
* Provides default, standardized UI
* Extensible
* Designed for both mobile and desktop
* Can be used in any Granite-based platform

* CLIENT SIDE VS SERVER SIDE

* GRANITE UI FOUNDATION COMPONENTS
* Include?
	* Button
	* Hyperlink
	* User Avatar
* Found under:
	*  /libs/granite/ui/components/foundation
* Purpose:
	* component model for HTML Elements
	* component composition
	* automatic unit and functionality testing
* Implementation:
	* repository based composition and configuration
	* leveragin testing facilities provided by the Granite platform
	* JSP templating
	
# Coral UI
* What? Adobe's visual style for touch-optimized UI, designed to provide consistency in the user experience across multiple products
* Purpose? provide unified and clean HTML5 markup, independent of the actual method used to emit the markup

* HTML ELEMENTS - THE MARKUP LAYER
* Purpose?
	* Provide basic UI elements with common look-and-feel
	* Provide the default grid system
* Impelementation
	* HTML tags with styles
	* Classes are defined in LESS files
	* Icons are defined as font sprites
	
* ELEMENT PLUGINS
* What?
	* Designged to operate on a specific DOM element
	* Generic in nature
* Purpose?
	* Provide dynamic behavior for HTML Elements
	* Provide custom layouts not possible with pure CSS
	* Provide form validation
	* Provide advanced DOM manipulation
* Implementation
	* jQuery plugin
	* Using data- attributes to customize behavior
	
* HTML ELEMENTS WIDGETS
* What? combine one or more basic elements with a javascript plugin to from *higher level* UI elements
* Purpose?
	* Implement higher level UI elements
	* Trigger and handling events
* Implementation
	* jQuery plugin + HTML markup
	* Can utilize client/server side templates

* UTILITY LIBRARY
* What? collection of javascript helper plugins that are
	* UI independent
	* Crucial for building full featured web app
* Purpose?
	* Provide common functionality
	* Event bus implementation
	* Client-side templated
	* XSS
* Implementation
	* jQuery plugin or AMD-compilant JavaScript modules

