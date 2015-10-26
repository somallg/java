# PLT.21 User Information
* Portlets provide content personalized to the user making the request
* To do this effectively, they may require access to user attributes such as name, mail, phone or address of the user
* Portlet container provide a mechanisms to expose available user information to Portlets

## PLT.21.1 Defining User Attributes
* The deployment descriptor of a Portlet application must define the user attribute names the Portlet use using the *user-attribute* element
* A deployer must map the Portlet application's logical user attributes to the corresponding user attributes offered by the runtime environment
* At runtime, the Portlet container uses this mapping to expose user attributes to the Portlets of the Portlet application

## PLT.21.2 Accessing User Attributes
* Portlet can obtain an unmodifiable *Map* object containing the user attributes of user associated with current request from the request attributes
* *Map* object can be retrieved using the *USER_INFO* constant defined in the *PortletRequest* interface on *getAttribute* method of the request
* If the request is done in the context of an un-authenticated user, calls to the *getAttribute* method of the request must return *null*
* If the user is authenticated and there are no user attributes, the *Map* must be an empty map
* Map object contain a String name / value pair for each available user attribute
* Map object should only contain user attributes that have been mapped during deployment

## PLT.21.3 Important Note on User Information
* User information is outside of the scope of this specification
* As there is no Java standard to access user information, and until such Java standard is defined, the Portlet Spec will provide a mechanism that is considered to be the least intrusive from the Portlet API perspective
