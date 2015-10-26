# Struts 2 Tutorial
* Apache *Struts 2*, another popular Java Model-View-Controller (MVC) framework, combine of both successful **WebWork** and **Struts 1.x** web frameworks
* Apache Struts 2, is totally different with Struts 1, it's core features are all implemented with interceptors, "value stack" concept, OGNL expression and Struts 2 tags to work around the application data, and many annotations and conventions to make this frame work more simpler to use

* In Struts2, the Action class is not required to implement any interface or extend any class, but it's required to create an *execute()* method to put all the business logic inside and return a String value to tell user where to redirect
* Strut1's Action class is required to extends the *org.apache.struts.action.Action*. But Struts 2 Action class is optional, but you are still allow to implement the *com.opensymphony.xwork2.Action* for some handy constant values or extends the *com.opensymphony.xwork2.ActionSupport* for some common default Action implementation functions

* A Strut configuration file to link all stuff together. **The xml file name must be struts.xml**
* Declare a package and warp the action classes inside, the action classes are self-explanatory, but you may interest at:
	* **package name="user"** - just a package name
	* **namespace="/User"** - used to match the URL pattern
	* **extends="struts-default"** - means the package extends the struts-default package components and interceptors, which is declared in the **struts-default.xml** file, located at the root of the **struts2-core.jar** file