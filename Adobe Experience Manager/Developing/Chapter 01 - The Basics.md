# The Basics

# 1. Prerequisites for Developing on AEM
* Basic knowledge of web application techniques:
	* request-response
	* HTML
	* CSS
	* JavaScript
* Working knowledge of the Experience Server (CRX)
* Basic knowledge of JSP

# 2. Java Content Repository

# 3. Experience Server (CRX) and Jackrabbit

# 4. Sling Request Processing
* INTRODUCTION TO SLING
* Sling? web application framework based on REST principles, provides easy development of content-oriented applications
* How? Sling uses JCR repository, such as Apache Jackrabbit, or in the case of AEM, CRX Content Repository, as its data store
* Use Sling, URL resolves to a content object for which a script can then be found to perform the rendering

* SLING IS CONTENT CENTRIC
* Processing is focused on the content as each (HTTP) request is mapped onto content in the form of a JCR resource

* First target JCR node holding the content
* The representation, or script is located from the resource properties in combination with certain parts of the request

* RESTFUL SLING
* URL = resource = JCR structure

* URL DECOMPOSITION

# 5. From URL to Content and Scripts
* Mapping uses the content path extracted from the request to locate the resource
* When appropriate resource is located, sling resource type is extracted, and used to locate the script to be used for rendering the content

# 6. Mapping requests to resources
* Check whether a node exists at the location specified in the request
* If no node found, the extension is dropped and the search repeated
* If no node found => 404 (Not Found)

* LOCATING THE SCRIPT 
* When appropriate resource is located, the *sling resource type* is extracted

* When the Method (GET, POST) is required, it will be specified in uppercase as according to the HTTP specification

# 7. Development Objects in the AEM Environment
* **Item**
	* Either node or a property
	
* **Node (and their properties)**
	* Store content, object definitions, rendering scripts and other data
	
* **Widget**
	* All user input is managed by widgets
	
* **Dialog**
	* Special type of widget
	* Combine a series of widgets to present the user with fields and actions necessary to edit the related content
	* Also use for editing metadata
	
* **Component**
	* System element offering a predefined service or event, and able to communicate with other components
	* Use to render the content of a resource
	* Includes:
		* Code used to render the content
		* Dialog for user input and configuration of the resulting content
		
* **Template**
	* Base for a specific type of page
	* A template is a hierarchy of nodes that has the same structure as the page to be created but without any content

* **Page Component (Top-Level Component)**
	* Use to render page
	
* **Page**
	* Instance of a template

* **Page Manager**
	* Interface that provides methods for page level operations
	
# 8. Structure within the Repository
* /apps
	* application related; includes component definitions specific to your website

* /content
	* content created for your website
	
* /etc
	* Tools section for detailed information
	
* /home
	* User and group information
	
* /libs
	* libraries and definitions that belong to the core of AEM
	
* /tmp
	* Temporary working area
	
* /var
	* Files that change and are updated by the system; such as audit log, statistics, event-handling. The sub-folder /var/classes contains the java servlets in source and complied forms that have been generated from the components scripts

# 9. Environemnts
* Author and Publish instances

# 10. The Dispatcher
* Tool for caching and/or load balacing

# 11. FileVault (source revision system)
* Provides file system mapping and version control

# 12. Workflows

# 13. Multi-Site Management
	
	 
