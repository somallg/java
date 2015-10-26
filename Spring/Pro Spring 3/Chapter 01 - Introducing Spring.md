# Chapter 01 - Introducing Spring

# 1. What Is Spring?
* Typically, Spring is described as a lightweight framework for building Java applications:
	* You can use Spring to build any application in Java (e.g, stand-alone, Web, JEE applications, etc...)
	* The lightweight part doesn't really refer to the number of classes or the size of the distribution, but rather, it defines the principle of the Spring philosophy as a whole - minimal impact

## 1.1 Inverting Control or Injecting Dependencies?
* The core of the Spring Framework is based on the principle of Inversion of Control (IoC)
* IoC is a technique that externalizes the creation and management of component dependencies

* Spring's DI implementation is based around two core Java concepts:
	* JavaBeans
	* Interfaces
	
* Interfaces and DI are technologies that are mutually beneficial:
	* Designing and coding an application to interfaces makes for a flexible application
	* By using DI, you reduce the amount of code you need to utilize an interface-based design in your application to almost zero
	* Likewise, by using interfaces, you can get the most out of DI because your beans can utilize any interface implementation to satisfy their dependency

* In the context of DI, Spring acts more like a container than a framework - providing instances of your application classes with all the dependencies they need

## 1.2 Evolution of Dependency Injection
* The benefits of using DI rather than a more traditional approach:
	* *Reduce glue code* - reduce dramatically the amount of code you have to write to glue the different components of you application together (e.g JNDI lookup)
	* *Simplified application configuration* - you can use annotations or XML to configure. DI make it much simpler to swap one implementation of a dependency for another
	* *The ability to manage common dependencies in a single repository* - all the information about the common dependencies is contained in a single repository
	* *Improved testability* - when you design your classes for DI, you make it possible to replace dependencies easily
	* *Fostering good application design* - designing for DI means, in general, designing against interface
	
* DI can make it difficult for someone not intimately familiar with the code to see just what implementation of a particular dependency is being hooked into which objects

## 1.3 Beyond Dependency Injection
* Spring provides features for all layers of an application, from helper application programming interfaces (APIs) for data access right through to advanced Model View Controller (MVC) capabilities

# 2. Aspect-Oriented Programming with Spring
* Aspect-oriented programming (AOP) is one of the *programming models of the moment* in the Java space
* AOP provides the ability to implement crosscutting logic - logic that applies to many parts of your application - in a single place and to have that logic applied across your application automatically

* Spring's approach to AOP is creating *dynamic proxies* to the target objects and *weaving* the objects with the configured advice to execute the crosscutting logic

# 3. Spring Expression Language (SpEL)
* Expression Language (EL) is a technology to allow an application to manipulate Java objects at runtime
* Starting in version 3.0, Spring introduced the Spring Expression Language (SpEL)
* SpEL provides powerful features for evaluating expressions and for accessing Java objects and Spring beans at runtime. The result can be used in the application or injected into other JavaBeans

# 4. Validation in Spring
* Validation rules of the attributes within JavaBeans containing business data can be applied in a consistent way, regardless of whether the data manipulation request is initiated from the frontend, a batch job, or remotely
* JCP developed the Bean Validation API specification (JSR-303)
* Starting in verions 3.0, Spring provides out-of-the-box support for JSR-303

# 5. Accessing Data in Spring
* As of version 3.x, Spring's data access module provides out-of-the-box support for JDBC, Hibernate, MyBatis, Java Data Object (JDO), and the Java Persistence API (JPA)

* One of the nicest features in Spring is the ability to mix and match data access technologies easily within an application

# 6. Object/XML Mapping (OXM) in Spring
* Spring supports many common Java-to-XML mapping framework and, as usual, eliminates the needs for directly coupling to any specific implementation

# 7. Managing Transactions
* Spring provides an excellent abstraction layer for transaction management, allowing for programmatic and declarative transaction control

# 8. Simplifying and Integrating with JEE

# 9. MVC in the Web Tier

# 10. Remoting Support

# 11. Mail Support

# 12. Job Scheduling Support

# 13. Dynamic Scripting Support

# 14. Simplified Exception Handling

# 15. The Spring Project

## 15.1 Origins of Spring
* The origins of Spring can be traced back to the book *Expert One-to-One J2EE Design and Development* by Rod Johnson

## 15.2 The Spring Community

## 15.3 Spring for Microsoft .NET

## 15.4 The SpringSource Tool Suite/Spring IDE

## 15.5 The Spring Security Project
* Spring Security provides comprehensive support for both web application and method-level security
* It tightly integrates with the Spring Framework and other commonly used authentication mechanisms, such as HTTP basic authentication, form-based login, X.509 certificate, SSO product

## 15.6 Spring Batch and Integration
* Spring Batch provides a common framework and various policies for batch job implementation, reducing a lot of boilerplate code

## 15.7 Many Other Projects

# 16. Alternatives to Spring
* Spring is not the only framework offering Dependency Injection features or full end-to-end solution for building applications

## 16.1 JBoss Seam Framework

## 16.2 Google Guice

## 16.3 PicoContainer

## 16.4 JEE 6 Container

# 17. Summary