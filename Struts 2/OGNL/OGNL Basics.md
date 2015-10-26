# OGNL Basics

# 1. XWork-specific language features
* The biggest addition that XWork provides on top of OGNL is the support for the ValueStack
* While OGNL operates under the assumption there is only one "root", XWork's ValueStack concept requires there be many "roots"

* Suppose we are using standard OGNL and there are two objects in the OGNLContext map: "foo" -> foo and "bar" -> bar and that the foo object is also configured to be the single *root* object:
	* #foo.blah // return foo.getBlah()
	* #bar.blah // return bar.getBlah()
	* blah 	    // return foo.getBlah() because foo is the root
	
* OGNL allows many objects in the context, but unless the object you are trying to access is the root, it must be prepended with a namspaces such as @bar

* In XWork, the entire ValueStack is the root object in the context. XWork has a special OGNL PropertyAccessort that will automatically look at all the entries in the stack (from the top down) until it finds an object with the property you are looking for

* For example, suppose the stack contains two objects: Animal and Person. Both objects have a *name* property, Animal has a *species* property, and Person has a *salary* property. Animal is on the top of the stack:
	* species // call to animal.getSpecies()
	* salary  // call to person.getSalary()
	* name    // call to animal.getName() because animal is on the top
	
* Sometimes you want the property of a lower-level object. To do this, XWork has added support for indexes on the ValueStack:
	* [0].name  // call to animal.getName()
	* [1].name  // call to person.getName()

* With expression like [0] ... [3] etc. Struts 2 will cut the stack and still return back a CompoundRoot object
	* [0].top // would get the top of the stack cut starting from element 0 in the stack
	
# 2. Accessing static properties

# 3. Struts 2 Named Objects
* Struts 2 places requests parameters and request, session, and application attributes on the OGNL stack. They may be accessed as shown below:
	* #action.foo		// current action getter getFoo()
	* #parameters.foo 	// request.getParameters('foo')
	* #request.foo 		// request.getAttribute('foo')
	* #session.foo		// session.getAttribute('foo')
	* #application.foo  // ServletContext attributes 'foo'
	* #attr.foo			// Access PageContext if available, otherwise search request/session/application respectively
	 