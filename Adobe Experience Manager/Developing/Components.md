# Components

# What?
* modular units which realize specific functionality to present content on website
* re-usable
* self-contained units within one folder of the repository
* no hidden configuration files
* can container another components
* can run anywhere within any AEM system
* have standardized user interface
* use widgets
* have edit behaviour that can be configured

* Each AEM component
	* is a resource type
	* collection of script that completely realize a specific function
	* can function in "isolation"
	
# Defaul Components within AEM

# Components and their structure

## Component definitions
* Based on Sling
* Located under /libs/foundataion/components
* site specific components are located under /apps/sitename/components
* page component - particular type of resource
* Standard components are defined as cq:Component and have elements:
	* a list of jcr properties
	* dialog defines the interface allowing the user to configure the component
	* child node cq:editConfig
	* resources: static elements used by the component
	* scripts used to implement the behavior of the resulting instance of the component
	* thumbnal
	
* DIALOGS
* Provide interface for authors to configure and provide input to that component

* COMPONENT HIERARCHY AND INHERITANCE
* Resource Type Hierarchy
* Container Hierarchy
* Include Hierarchy