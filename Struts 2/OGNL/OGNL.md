# OGNL
* OGNL is the Object Graph Navigation Language
* The framework uses a standard naming context to evaluate OGNL expressions. The top level object dealing with OGNL is a Map (usually referred as a context map or context)
* OGNL has a notion of there being a root (or default) object within the context
* In expression, the properties of the root object can be referenced without any special *maker* notion
* References to other objects are marked with a pound sign (#)

* The framework sets the OGNL context to be our ActionContext, and the values stack to be the OGNL root object. The value stack is a set of several objects, but to OGNL it appears to be a single object
* Along with the value stack, the framework places other objects in the ActionConext, including Maps representing the application, session, and request contexts. Those objects coexist in the ActionConext, alongside the value stack (our OGNL root)
* context map:
	* application
	* session
	* value stack (root)
	* action (the current action)
	* request
	* parameters
	* attr (searches page, request, session, the application scopes)

* The Action instance is always pushed onto the value stack. Because the Action is on the stack, and the stack is the OGNL root, references to Action properties can omit the # marker. But, to access other objects in the ActionContext, we must use the # notation so OGNL knows not to look in the root object, but for some other object in the ActionContext

# 1. Collections (Maps, Lists, Sets)
* Syntax for list : {e1, e2, e3}
* Syntax for map: #{key1: value1, key2: value2}
* To select a subset of a collection (called projection), use a wildcard within the collection:
	* ? - All elements matching the selection logic
	* ^ - Only the first element matching the selection logic
	* $ - Only the last element matching the selection logic

# 2. Lambda Expressions
* OGNL supports basic lamda expression syntax enabling you to write simple functions

