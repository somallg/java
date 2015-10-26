# PLT.24 Security
* Portlet applications are create by *Application Developers* who license the application to a *Deployer* for installation into a runtime environment
* *Application Developers* need to communicate to *Deployer* how the security is to be set up for the deployed application

## PLT.24.1 Introduction
* Portlet application contains resources that can be accessed by many users
* Those resource often traverse unprotected, open networks such as the Internet
* In such an environment, a substantial number of Portlet application will have security requirements
* Portlet container is responsible for informing Portlets of the roles user are in, when accessing them
* Portlet container does not deal with user authentication
* It should leverage the authentication mechanisms provided by the underlying Servlet Container

## PLT.24.2 Roles
* Portlet Spec shares the same definition as roles of the *Servlet Specification, SRV.12.4 Section*

## PLT.24.3 Programmatic Security
* Programmatic security consists of the following methods of the *Request* interface:
    * *getRemoteUser* (return the username the client used for authentication)
    * *isUserInRole* (determines if a remote user is in a specified security role)
    * *getUserPrincipal* (determines the principal name of the current user and returns a *java.security.Principal* object)
* Those APIs allow Portlets to make business logic decisions based on the information obtained
* The values that the Portlet API *getRemoteUser* and *getUserPrincipal* methods return the same values, returned by the equivalent methods of the *ServletResponse* object
* *isUserInRole* method expects a String parameter with the role-name
* *security-role-ref* element must be declared by the Portlet deployment descriptor with a *role-name* sub-element
* *security-role-ref* element should contain a *role-link* sub-element whose value is the name of the application security role that the user may be mapped into (this mapping is specified in the *web.xml*)
* If the *security-role-ref* element does not define a *role-link* element, the container must default to checking the *role-name* element argument against the list of *security-role* elements defined in the *web.xml*
* Developer must aware that the use of this default mechanism may limit the flexibility in changing role-names in the application

## PLT.24.4 Specifying Security Constraints
* Security constraints are a declarative way of annotating the intended protection of Portlets
* A constraint consists of the following elements:
    * Portlet collection (set of Portlet names that describe a set of resource to be protected)
    * User data constraint (describes requirement for the transport layer for the Portlets collection)
* The container must at least use SSL to respond to requests to resources marked integral or confidential

## PLT.24.5 Propagation of Security Identity in EJB Calls
* A security identity, or principal, must always be provided in a call to an enterprise bean
* The default mode in calls to EJBs from Portlet applications should be for the security identity of a user, in the Portlet container, to be propagated to the EJB container
