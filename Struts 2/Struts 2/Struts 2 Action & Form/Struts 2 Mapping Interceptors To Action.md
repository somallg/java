# Struts 2 Mapping Interceptors To Action
* Struts 2 developers are used to declare the actions belong to a package that extend the **struts-default**, which contains the default set of interceptors
* The default set of interceptors are grouped as **defaultStack** in **struts-default.xml** file, which is located in the **struts2-core.jar** file. The **defaultStack** provides all the core Struts 2 functionality, which suits the need of most application

## 1. Mapping interceptor to action
* To map other interceptors to action, use the **interceptor-ref** element
* The interceptors will fire in the order they're declared
* If the Action class declared it's own interceptors, **it's immediate loses all the inherit default set of interceptors**, you must explicitly declare the **defaultStack** in order to use it