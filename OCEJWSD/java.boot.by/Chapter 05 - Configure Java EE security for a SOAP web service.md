# Chapter 05 - Configure Java EE security for a SOAP web service

## 5.1 Configure security requirements of service using Java EE-container based security (overlaps with steps in other tasks)

### 5.1.1 Configure security requirements through deployment descriptors (*web.xml*, *webservices.xml*) for a Servlet-based web service endpoint: container authorization, caller authentication, and message protection. JAX-WS runtime may also be configured to perform message layer authentication and protection

### 5.1.2 Configure security requirements through deployment descriptors (*ejb-jar.xml*, *webservices.xml*) for EJB-based web service endpoint

#### 5.1.2.1 Configure transactional support

#### 5.1.2.1 Configure container role based access control via method-permissions in *ejb-jar.xml* or via access control annotations on EJB

#### 5.1.2.3 Configure caller authentication and message protection; either by Servlet container via *web.xml*, and/or by JAX-WS message processing runtime

### 5.1.3 Configure security requirements through deployment descriptor (*web.xml*) for JAX-RS based web service endpoint