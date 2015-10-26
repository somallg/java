# Chapter 05 - Spring Configuration in Detail

## Spring's Impact on Application Portability
* By coupling to Spring, you can increase your application's portability by replacing many features that either are vendor-specific or reply on vendor-specific configuration with equivalent features in Spring

## Bean Life-Cycle Management
* Spring provides three mechanisms a bean can use to hook into each of these events and perfrom some additional processing: 
    * Interface-based - your bean implements an interface specific to the type of notification it want to receive, Spring notifies the bean via a callback method defined in the interface 
    * Method-based - Spring allows you to specify the name of a method to call when the ben is initialized and the name of a method to call when the bean is destroyed
    * Annotation-based mechanisms - use JSR-250 annotations to specify the method that Spring should call after construction or before destruction

// TODO add image

## Hooking into Bean Creation
* Initialization callback is the place to trigger any actions that your bean must take automatically in reponse to its configuration

## Execute a Method When a Bean Is Created
* Specify a callback method is simply a case of specifying the name in the *init-method* attribute of a bean's <bean> tag

## Using a Shutdown Hook
* Register shutdown callback
* Destruction callbacks in Spring does not fire automatically
* *AbstractApplicationContext.registerShutdownHook()*

## Making Your Beans Spring Aware
* Mechanism of Spring to provide Spring specific components: ApplicationContext, SpringBeanName,...
* Bean need access to Spring components ApplicationContext to register shutdown hook, get bean manually
* Implements Spring Aware Interface

## Using the BeanNameAware Interface
* Implement *BeanNameAware* and overide the method *setBeanName(String)*

# Using the ApplicationContextAware Interface
* Implement *ApplicationContextAware* Interface and override the method *setApplicationContext(ApplicationContext)*

## Use FactoryBeans
* Acts as a factory to create beans that you cannot use the *new* operator to create such as those you access through static factory methods
* Some dependencies cannot be created simply using the *new* operator, create transactional proxies, automatic retrieval of resources from JNDI context

## Custom FactoryBean Example
* FactoryBean interface declares three methods:
    * *getObject()*
    * *getObjectType()*
    * *isSingleTon()*

## Accessign a FactoryBean Directly
* Using & + beanId
* Avoid do this

## Using the factory-bean and factory-method Attributes
* Create 3rd-party instance of a class using factory method

## JavaBeans PropertyEditors
* Interface that convert a property's value to and from its native type representation into a String
* Manage the conversion of String-based property values into the correct types

## The Built-in PropertyEditors
* Spring default editor

## Creating a Custom PropertyEditor
* Customize mapping from String to custom type or class
* Extends *PropertyEditorSupport* and implement : *setAsText()*
* Converted value is returned by calling the *setValue()* method with the result
* Register custom editor in Spring's ApplicationContext: *CustomEditorConfigurer*

## More Spring ApplicationContext Configuration
* ApplicationContex provide a much richer framework on which to build your application

## Internationalization with MessageSource

## Using ApplicationContext and MessageSource

## Application Events
* Publish and receive events using the *ApplicationContext*

## Using Application Events
* An event is class-derived from *ApplicationEvent*, which itselft derives from *java.util.EventObject*
* Any bean can listen for events by implementing the *ApplicationListener<T>* interface
* Any bean implement that interface will be registered as listener
* Event are published using the *ApplicationEventPublisher.publishEvent()* method, so publishing class must have knowledge of the *ApplicationContext*

## Considerations for Event Usage
* Typically, we use events for reactionary logic that executes quickly and is not part of the main application logic
* For processes that are long running and form part of the main business logic, it is recommended to use JMS or similar messaging systems such as RabbitMQ

## Accessing Resources
* Need to access some configuration data stored in a file in the file system, some data store in a JAR file on the classpath, or maybe some data on a server elsewhere

## Configuration Using Java Classes
* Configure Spring using Java classes

## ApplicationContext Configuration in Java
* When using a Java class instead of XML, need to implement a normal JavaBean, with the appropriate annotation for Spring's Java configuration
* @Configuration - inform Spring that this is a Java-based configuration file
* @Bean - declare a Spring bean and the DI requirements

## Java or XML Configuration?
* Each approach has its own pros and cons
* Use what your team decide

## Profiles


