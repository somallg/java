# Exam from www.developersbook.com
* http://springcert.sourceforge.net/exam-dev-book.html

# 1. What is IoC (or Dependency Injection)?
* The basic concept of the Inversion of Control pattern (also known as dependency injection) is that you do not create your objects but describe how they should be created
* You don't directly connect your components and services together in code but describe which services are needed by which components in the configuration file
* A container (in the case of the Spring, the IoC Container) is then responsible for hooking it all up
* Applying IoC, objects are given their dependencies at creation time by some external entity that coordinates each object in the system. That is, dependencies are injected into objects. So, IoC means an inversion of responsibility with regard to how an object obtains references to collaborating objects

# 2. What are the different types of IoC (dependency injection)?
* There are three types of dependency injection:
    * *Constructor Injection*: dependencies are provided as constructor parameters
    * *Setter Injection*: Dependencies are assigned through JavaBeans properties (ex: setter methods)
    * *Interface Injection*: Injection is done through an interface
* Spring supports only Constructor and Setter Injection

# 3. What are the benefits of IoC (Dependency Injection)?
* Benefits of IoC (Dependency Injection) are as follows:
    * Minimizes the amount of code in your applications. With IoC containers you do not care about how services are created and how you get preferences to the ones you need. You can also easily add additional services by adding a new constructor or a setter method with little or no extra configuration
    * Make your application more testable by not requiring any singletons or JNDI lookup mechanism in your unit test cases. IoC containers make unit testing and switching implementations very easy by manually allowing you to inject your own objects into the object under test
    * Loose coupling is promoted with minimal effort and least intrusive mechanism. The factory design pattern is more intrusive because components or services need to be requested explicitly whereas in IoC the dependency is injected into requesting piece of code. Also some containers promote the design to interfaces not to implementations design concept by encouraging objects to implement a well-defined service interface of you own
    * IoC containers support eager instantiation and lazy loading of services. Containers also provide support for instantiation of managed objects, cyclical dependencies, life cycles management, and dependency resolution between managed objects etc...
    
# 4. What is Spring?
* Spring is an open source framework created to address the complexity of enterprise application development
* One of the chief advantages of the Spring framework is its layered architecture, which allows you to be selective about which of its components you use while also providing a cohesive framework for J2EE application development

# 5. What are the advantages of Spring framework?
* The advantages of Spring are as follows:
    * Spring has layered architecture. Use what you need and leave what you don't for now
    * Spring Enables POJO Programming. There is no behind the scene magic here. POJO programming enables continuous integration and testability
    * Dependency Injection and Inversion of Control Simplifies JDBC
    * Open source and no vendor lock-in

# 6. What are features of Spring?
* Lightweight: Spring is lightweight when it comes to size and transparency. The basic version of Spring framework is around 1MB. And the processing overhead is also very negligible
* Inversion of Control (IoC): Loose coupling is achieved in Spring using the technique Inversion of Control. The objects give their dependencies instead of creating or looking for dependent objects
* Aspect Oriented (AOP): Spring supports Aspect Oriented programming and enables cohesive development by separating application business logic from system services
* Container: Spring contains and manages the life cycle and configuration of application objects
* MVC Framework: Spring comes with MVC web application framework, built on core Spring functionality. This framework is highly configurable via strategy interfaces, and accommodates multiple view technologies like JPS, Velocity, Tiles, iText, and POI. But other frameworks can be easily used instead of Spring MVC Framework
* Transaction Management: Spring framework provides a generic abstraction layer for transaction management. This allowing the developer to add the pluggable  transaction managers, and making it easy to demarcate transactions without dealing with low-level issues. Spring's transaction support is not tied to J2EE environments and it can be also used in container less environments
* JDBC Exception Handles: The JDBC abstraction layer of the Spring offers a meaningful exception hierarchy, which simplifies the error handling strategy. Integration with Hibernate, JDO, and iBATIS: Spring provides best Integration services with Hibernate, JDO and iBATIS

# 7. How many modules are there in Spring? What are they?
* Spring comprises of seven modules. They are...
    * The core container: The core container provides the essential functionality of the Spring framework. A primary component of the core container is the BeanFactory, an implementation of the Factory pattern. The Bean Factory applies the *Inversion of Control* (IoC) pattern to separate an application's configuration and dependency specification from the actual application code
    * Spring context: The Spring context is a configuration file that provides context information to the Spring framework. The Spring context includes enterprise services such as JNDI, EJB, e-mail, internalization, validation, and scheduling functionality
    * Spring AOP: The Spring AOP module integrates aspect-oriented programming functionality directly into the Spring framework, through its configuration management feature. As a result you can easily AOP-enable any object managed by the Spring framework. The Spring AOP module provides transaction management services for objects in any Spring-based application. With Spring AOP you can incorporate declarative transaction management into your application without relying on EJB components
    * Spring DAO: The Spring JDBC DAO abstraction layer offers a meaningful exception hierarchy for managing the exception handling and error messages thrown by different database vendors. The exception hierarchy simplifies error handling and greatly reduces the amount of exception code you need to write, such as opening and closing connections. Spring DAO's JDBC-oriented exceptions comply to its generic DAO exception hierarchy
    * Spring ORM: The Spring framework plugs into several ORM framework to provides its Object Relational tool, including JDO, Hibernate, and iBatis SQL Maps. All of these comply to Spring's generic transaction and DAO exception hierarchies
    * Spring Web Module: The Web context module builds on top of the application context module, providing contexts for Web-based applications. As a result, the Spring framework supports integration with Jakarta Struts. The Web module also eases the tasks of handling multi-part requests and binding request parameters to domain objects
    * Spring MVC Framework: The Model-View-Controller (MVC) framework is a full-featured MVC implementation for building Web applications. The MVC framework is highly configurable via strategy interfaces and accommodates numerous view technologies including JSP, Velocity, Tiles, iText, and POI
    
# 8. What are the types of Dependency Injection Spring support?
* Setter Injection: Setter-based DI is realized by calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean
* Constructor Injection: Constructor-based DI is realized by invoking a constructor with a number of arguments, each representing a collaborator

# 9. What is Bean Factory?
* A BeanFactory is like a factory class that contains a collection of beans. The BeanFactory holds Bean Definition of multiple beans within itself then instantiates the bean whenever asked for by clients
* BeanFactory is able to create associations between collaborating objects as they are instantiated. This removes the burden of configuration from bean itself and the beans client
* BeanFactory also takes part in the lifecycle of a bean, making class to custom initialization and destruction methods

# 10. What is Application Context?
* A BeanFactory is fine to simple applications, but to take advantage of the full power of the Spring framework, you may want to move up to Springs more advanced container, the application context. On the surface, an application context is same as a bean factory. Both load bean definitions, wire beans together, and dispense beans upon request. But it also provides:
    * A means for resolving text messages, including support for internationalization
    * A generic way to load file resources
    * Events to beans that are registered as listeners
    
# 11. What is the difference between Bean Factory and Application Context?
* On the surface, an application context is same as a bean factory. But application context offers much more...
* Application contexts provide a means for resolving text messages, including support for i18n of those messages
* Application contexts provide a generic way to load file resources, such as images
* Application contexts can publish events to beans that are registered as listeners
* Certain operations on the container or beans in the container, which have to be handles in a programmatic fashion with a bean factory, can be handle declaratively in an application context
* ResourceLoader support: Spring's Resource interface give us a flexible generic abstraction for handling low-level resources. An application context itself is a ResourceLoader. Hence provides an application with access to deployment-specific Resource instances
* MessageSource support: the application context implements MessageSource, an interface used to obtain localized messages, with the actual implementation being pluggable

# 12. What are the common implementations of the Application Context ?
* The three commonly used implementation of *ApplicationContext* are:
    * *ClassPathXmlApplicationContext*: it loads context definition from an XML file located in the classpath, treating context definitions as classpath resources. The application context is loaded from the application's classpath by using the code
    * *FileSystemXmlApplicationContext*: it loads context definition from an XML file in the filesystem. The application context is load from the file system by using the code
    * *XmlWebApplicationContext*: it loads context definition from an XML file contained within a web application

# 13. How is a typical Spring implementation look like?
* For a typical Spring Application we need the following files:
    * An interface that defines the function
    * An Implementation that contains properties, its setter and getter methods, function etc...
    * Spring AOP
    * A XML file called Spring configuration file
    * Client program that uses the function

# 14. What is the typical Bean life cycle in Spring BeanFactory container ?
* Bean life cycle in Spring BeanFactory Container is as follows:
    * The Spring container finds the bean's definition from the XML file and instantiates the bean
    * Using the dependency injection, Spring populates all of the properties as specified in the bean definition
    * If the bean implements the BeanNameAware interface, the factory calls *setBeanName()* passing the bean's ID
    * If the bean implements the BeanFactoryAware interface, the factory calls *setBeanFactory()*, passing an instance of itself
    * If there are any *BeanPostProcessors* associated with the Bean, their *postProcessBeforeInitialization()* method will be called
    * If an init-method is specified for the bean, it will be called
    * Finally, if there are any *BeanPostProcessors* associated with the bean, their *postProcessAfterInitialization()* method will be called

# 15. What do you mean by Bean wiring?
* The act of creating associations between application components (beans) within the Spring container is referred to as Bean wiring

# 16. What do you mean by Auto wiring?
* The Spring container is able to autowire relationships between collaborating beans. This means that it is possible to automatically let Spring resolve collaborators (other beans) for you bean by inspecting the contents of the BeanFactory. The autowiring functionality has *five modes*:
    * no
    * byName
    * byType
    * constructor
    * auto-direct
    
# 17. What is DelegatingVariableResolver?
* Spring provides a custom JavaServer Faces VariableResolver implementation that extends the standard Java Server Faces managed beans mechanism which lets you use JSF and Spring together. This variable resolver is called as *DelegatingVariableResolver*

# 18. How to integrate Java Server Faces (JSF) with Spring?
* JSF and Spring do same some of the same features, most noticeably in the area of IoC services
* By declaring JSF managed-beans in the faces-config.xml configuration file, you allow the FacesServlet to instantiate that bean at startup. Your JSF pages have access to these beans and all of their properties. We can integrate JSF and Spring in two ways:
    * *DelegatingVariableResolver*: Spring comes with a JSF variable resolver that lets you use JSF and Spring together. The DelegatingVariableResolver will first delegate value lookups to the default resolver of the underlying JSF implementation, and then to Spring's 'business context' WebApplicationContext. This allows one to easily inject dependencies into one's JSF-managed beans
    * *FacesContextUtils*: custom VariableResolver works well when mapping one's properties to beans in faces-config.xml, but at times one may need to grab a bean explicitly. The *FacesContextUtils* class makes this easy. It is similar to *WebApplicationContextUtils*, except that it takes a FacesContext parameter rather than a ServletContext parameter
    
# 19. What is Java Server Faces - Spring integration mechanism
* Spring provides a custom JavaServer Faces VariableResolver implementation that extends the standard javaServer Faces managed beans mechanism. When asked to resolve a variable name, the following algorithm is performed:
    * Does a bean with the specified named already exist in some scope (request, session, application)? If so, return it
    * Is there a standard JavaServer Faces managed bean definition for this variable name? If so, invoke it in the usual way, and return the bean that was created
    * Is there configuration information for this variable name in the Spring WebApplicationContext for this application? If so, use it to create and configure an instance, and return that instance to the caller
    * If there is no managed bean or Spring definition for this variable name, return null instead
    * BeanFactory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods
* As a result of this algorithm, you can transparently use either JavaServer Faces or Spring facilities to created beans on demand

# 20. What is significance of JSF - Spring integration?
* Spring - JSF integration is useful when an event handler wishes to explicitly invoke the bean factory to create beans on demand, such as a bean that encapsulates the business logic to be performed when a submit button is pressed

# 21. How to integrate your Struts application with Spring?
* To integrate your Struts application with Spring, we have two options:
    * Configure Spring to manage your Actions beans, using the ContextLoaderPlugin, and set their dependencies in a Spring context file
    * Subclass Spring's ActionSupport classes and grab your Spring-managed beans explicitly using a getWebApplicationContext() method
    
# 22. What are ORM's Spring support?
* Spring supports the following ORM's:
    * Hibernate
    * iBatis
    * JPA
    * TopLink
    * JDO
    * OJB

# 23. What are the ways to access Hibernate using Spring?
* There are two approaches to Spring' Hibernate integrating:
    * Inversion of Control with a HibernateTemplate and Callback
    * Extending HibernateDaoSupport and Applying an AOP Interceptor
    
# 24. How to integrate Spring and Hibernate using HibernateDaoSupport?
* Spring and Hibernate can integrate using Spring's SessionFactory called LocalSessionFactory. The integration process is 3 steps
    * Configure the Hibernate SessionFactory
    * Extend your DAO Implementation from HibernateDaoSupport
    * Wire in Transaction Support with AOP
    
# 25. What are Bean scopes in Spring framework
* Spring framework supports exactly five scopes (of which three are available only if you are using a web-aware ApplicationContext)
* The scopes supported are listed below:
    * singleton: scopes a single bean definition to a single object instance per Spring IoC container
    * prototype: scopes a single bean definition to any number of object instances
    * request: scopes a single bean definition to the lifecycle of a single HTTP request
    * session: scopes a single bean definition to the lifecycle of a HTTP Session
    * global session: scopes a single bean definition to the lifecycle of a global HTTP Session
    
# 26. What is AOP?
* Aspect-oriented programming, or AOP, is a programming technique that allows programmers to modularize crosscutting concerts, or behavior that cuts across the typical divisions of responsibility, such as logging and transaction management. The core construct of AOP is the aspect, which encapsulates behaviors affecting multiple classes into reusable modules

# 27. How the AOP used in Spring?
* *AOP is used in the Spring Framework:* To provide declarative enterprise services, especially as a replacement for EJB declarative services. The most important such service is declarative transaction management, which builds on the Spring Frameworks' transaction abstraction. To allow users to implement custom aspects, complementing their use of OOP with AOP

# 28. What do you mean by Aspect?
* 
