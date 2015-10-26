# Manipulating Content

# Multiple Ways to Modify Content
* WebDav
* Sling default POST Servlet called *SlingPostServlet*

# Quickstart: Creating Content
* To crate content you simply send an HTTP POST request using the path of the node to store the content in and include the actual content as request parameters

# SlingPostServlet Operations
* Supports the following operations
	* property not set or empty - create new content or modify existing content
	* delete
	* move
	* copy
	* import
	* nop
	* checking
	* checkout
	
# Content Creation or Modification
* Request URL indicates the actual repository node to be handled
	* If the URL addresses an existing node, modify the node
	* If the resource of the request is a synthetic resource, e.g NonExistingResource or StarResouce, new item is created
	
## Algorithm for Node Name Creation
* If request is POSTes with an URL ending with slash / or slash-start /*, SlingPostRequest derives a name for the node to be created upon the request applying the following algorithm:
	1. If a *name* parameter is supplied, the (first) value of this parameters is used unmodified as the name of the new node. If the name is illegally formed with respect to JCR name requirements, an exception will be thrown when trying to create the node
	2. Otherwise if a *nameHint* parameter is supplied, the (first) value of this parameter is used
	3. Otherwise a series of request parameters supplied to set content is inspected for possible name, e.g default [ title, jcr:title, name, description, jcr:description, abstract ]
	4. Otherwise an ever increasing auto generated number is used
	
* The Filtering algorithm to create a valid name:
	* Convert the proposed name to all lower case
	* Replace all characters not in range [0..9a-z] by underscore _
	* If the name starts with a digit preprend an underscore
	* Finally the name is cut to a congifurable maximum lenght (default 20 characters)
	
## Response Status
* 200/OK
* 201/CREATED
* 500/INTERNAL SERVER ERROR


