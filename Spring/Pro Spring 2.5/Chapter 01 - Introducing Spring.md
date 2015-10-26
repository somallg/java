# Chapter 01 - Introducing Spring

# 1. What Is Spring?
* The core of Spring Framework is based on the principle of Inversion of Control (IoC).
* The *inversion* means that the application does not control its structure, it is up to the IoC framework to do that

* Spring's DI implementation puts focus on loose coupling: the components of your application should assume as little as possible about other components
* The easiest way to achieve loose coupling in Java is to code to interfaces

* Interfaces and ID are mutually beneficial. Designing and coding an application to interfaces makes for a flexible application that is much more amenable to unit testing
* By using DI, you reduce the amount of extra code you need for an interface-based design to almost zero
* By using interfaces, you can get the most out of DI because your beans can utilize any interface implementation to satisfy their dependency

* In the context of DI, Spring acts more like an container than a framework - providing instances of you application classes with all the dependencies they need

* Benefits of using DI rather than a more traditional approach:
	* *Reduce glue code*
	* *Externalize dependencies*
	* *Manage dependencies in a single place*
	* *Improve testability*

# 2. Beyond Dependency Injection
* Spring provides tools to help build every layer of an application, from helper application programming interfaces (APIs) for data access right through to advanced model-view-controller (MVC) capabilities
* You can easily integrate them with other tools, making them all first-class members of the Spring family

# 3. Aspect-Oriented Programming with Spring
* Aspect-oriented programming (AOP) is one of the technologies of the moment in the programming space
* AOP lets you implement crosscutting logic - that is, logic that applies to many parts of you application - in a single place, and then have that logic automatically applied right across the application

# 4. Accessing Data in Spring
* Spring provides exellent integration with a choice selection of these data access tools

# 5. Simplifying and Integrating with Java EE

# 6. Job Scheduling Support

# 7. Mail Support

# 8. Dynamic Languages
* Allow you to implement components of you application in language other than Java (BeanShell, JRuby, Groovy)

# 9. Remoting Support
* Spring supports a variety of remote access mechanisms, including Java RMI, JAX-RPC, Caucho Hessian, and Caucho Burlap

# 10. Managing Transactions
* Spring provides an exellent abstraction layer for transaction management, allowing for programmatic and declarative transaction control