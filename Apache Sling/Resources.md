# Resources

# What is a Resource
* Sling assumes *Everthing is a Resource*

## Resource Properties
* Path ~ the concatenating the names of all Resources along the root to the Resource separated by a slash
* Name ~ last element in the path
* Resource Type ~ used by Servlet and Script resolver to find the appropriate Servlet or Script to handle the request for the Resource
* Resource Super Type
* Adapters ~ Resources can be adapted to different view
* Metadata ~ 

# How to get a Resource
* Need *ResourceResolver*, 4 kinds of methods to access resources:
	* Absoluate Path Mapping Resource Resolution
		1. Call *HttpServletRequest.getScheme(), .getServerName(), getServerPort()* to get an absolute path out of the requets URL
		2. Check whether any virtual path matches the absolute path
		3. Apply a list of mappings in order to create a mapped path. The first mapped path resolving to a Resource is assumed success and the Resource found is returned
		4. If no mapping created a mapped path addressing an existing Resource, the method fails and return a *NonExistingResource*
		
	* Absolute or Relative Path Resolution
	* Resource Enumeration
	* Resource Querying