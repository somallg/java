# Chapter 2 - RESTful Web Services - The Server Side
* The list of APIs covered in this chapter:
    * HttpServlet and JSP APIs
    * JAX-RS (Java API for XML-RESTful Services) API
    * Third-party Restlet API, which is very similar to JAX-RS in look and feel
    * JAX-WS (Java API for XML-Web Services) API, the @WebServiceProvider interface in particular
    
## 2.1 A RESTful Service as an HttpServlet

## 2.2 A RESTful Web Service as a JAX-RS Resource
* JAX-RS relies upon Java annotations to advertise the RESTful role that a class and its encapsulated method play
* *Jersey* is the *reference implementation* (RI) of JAX-RES. *RESTEasy*, a JBoss project; *Apache Wink*; and *Apache CFX* are other implementations

## 2.3 A First JAX-RS Web Service Using Jersey
* The RESTful routing of the client's request works as follows:
    * In the URI */adages/resourcesA/plain* , the initial segment */adages* specifies the deployed WAR file *adages.war*
    * The next sub-segment */resourcesA* represents the JAX-RS **ApplicationPath**
    * The next sub-segment is */*, this URI maps to the class with @Path("/")
    * The final sug-segment is *plain*, which is the Path of the method
        * @GET annotation signals that the method/operation  is accessible through a GET request only
        * @Produces annotation promises, in effect, to response with the MIME type
        
* The JDK *schemagen* utility can generate an XML Schema instance from a Java class
* A second JDK utility, *xjc*, works in the other direction. Given a XML Schema, *xjc* can generate Java classes to represent the XML types in the schema

## 2.4 A RESTful Web Service as Restlet Resources
* The Restlet web framework supports RESTful web services, and the API is similar to JAX-RS, a Restlet application can use JAX-RS annotations such as @Produces instead of or in addition to Restlet annotation

* A Restlet web service has three main parts, each of which consists of one or more java classes:
    * A programmer-defined class extends the Restlet *Application* class. The purpose of the extended class is to set up a *routing table*, which maps request URIs to resources
    * There are arbitrarily many resource classes, any mix of named or anonymous
    * The backend POJO classes

## 2.5 A RESTful Service as a @WebServiceProvider
* JAX-WS includes APIs for RESTful and SOAP-based web services, although JAX-WS seems to be used mostly for the latter
* The reference implementation is *Metro*, which is part of the GlassFish project
* JAX-RS and Restlet are state-of-the-art, high-level APIs for developing RESTful services; by contrast, the JAX-WS API for RESTful services is low-level
* The JAX-WS API has two main annotations;
    * A POJO class annotated as a *@WebService* delivers a SOAP-based service
    * A POJO class annotated as a *@WebServiceProvider* usually delivers a RESTful one; however it can deliver a SOAP-based service as well
    
## 2.6 Summary
* Four different APIs were considered in this chapter, but these APIs fall into three general groups:
    * The *HttpServlet* API, which has been around since the late 1990s, remains an excellent way to implement RESTful services. Servlet are HTTP-aware and provide convenient filtering of requests by HTTP verb. Programmers accustomed to implementing websites with servlets, JSP, and related scripting languages such as JSF or Struts, should find servlets a natural and appealing way to deliver web services as well. The servlet API is at once uncomplicated and powerful 
    * The *JAX-RS* and *Restlet* APIs take full advantage of Java annotations to advertise the RESTful aspects of implemented services. These frameworks integrate well with JAX-B technologies to automate the conversion of Java types into XML and JSON documents. JAX-RS and Restlet services, like servlet-based servlets, can be published with production-grade web servers such as Tomcat and Jetty. These APIs also mimic the routing idioms that have become so popular because of frameworks such as Rails and Sinatra
    * The *JAX-WS* API, with the @WebServiceProvider at its center, is a lower level than the other options but well suited for programmers who need to be close to the HTTP and XML metal. This API is sufficiently rich to deliver real-world RESTful services, but the rival APIs are more appealing in that they hide many of the details that a JAX-WS service must handle explicitly
