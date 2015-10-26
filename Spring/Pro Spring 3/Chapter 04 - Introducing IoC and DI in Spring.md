# Chapter 04 - Introducing IoC and DI in Spring
* Pratically, DI is a specialized form of IoC, although you will often find that the two terms are used interchangeably

# 1 Inversion of Control and Dependency Injection
* At its core, IoC, and therefore DI, aims to offer a simpler mechanism for provisioning component dependencies (*collaborators*) and managin these dependencies throughout their life cycles
* A component that requries certain dependencies is often referred to as the *dependent object* or, the target
* In general, IoC can be decomposed into two subtypes:
    * Dependency Injection
    * Dedendency Lookup

# 2 Types of Inversion of Control
* Dependency Lookup is a much more traditional approach
* Ddendency Injection is a newer, less well-established approach, much more flexible and usable than Dependency Lookup

* With Dependency Lookup, a component must acquire a reference to a dependency
* Whereas with Dependency Injection, the dependencies are injected into the component by the IoC container
* Dependency Lookup comes in two types:
    * Dependency Pull
    * Contextualized Dependency Lookup (CDL)
* Dependency Injection also has two common flavors:
    * Constructor Dependency Injection
    * Setter Dependency Injection

# 3 Dependency Pull
* In Dependency Pull, dependencies are pulled from a registry as required

# 4 Contextualized Dependency Lookup
* In CDL, lookup is performed against the container that is managing the resource, not from some central registry

# 5 Constructor Dependency Injection
* Compenent's dependencies are provided to it in its constructor(s)
* The component declares a constructor or a set of constructors taking as arguments its dependencies, and the IoC contaienr passes the dependencies to the component when it instantiates it

# 6 Setter Dependency Injection
* IoC container inject a component's dependencies into the component via JavaBean-style setter methods
* A component's setters expose the set of dependencies the IoC container can manage

# 7 Injection vs Lookup
* Using Injection has zero impact on your components code
* Dependency Pull code, on the other hand, must actively obtain a reference to the registry and interact with it to obtain the dependencies, and using CDL requires your classes to implement a specific interface and lookup all dependencies manually

* Using injection, you are free to use your classes completely decoupled from the IoC container that is supplying dependent objects with their collaborators manually
* Whereas with lookup, your classes are always dependent on the classes and interfaces defined by the container

# 8 Setter Injection vs Constructor Injection
* Constructor Injection is particularly useful when you absolutely must have an instance of the dependency class before your component is used

* Setter injection also allows you to swap dependencies for a different implementation on the fly without creating a new instance of the parenet component

* In general, setter-based injection is the best choice, because it has the least effect on your code's usabilty in non-IoC settings

# 9 Inversion of Control in Spring

# 10 Dependency Injection with Spring

## 10.1 Beans and BeanFactories
* The core of Spring's Dependency Injection container is the *BeanFactory* container
* A *BeanFactory* is responsible for managing components, including their dependencies as well as their life cycles
* In Spring, the term *bean* is used to refer to any component managed by the container

* Internally, bean configuration is represented by instances of classes that implement the *BeanDefinition* interface

* You can identify your beans withtin the *BeanFactory*, each bean can be assigned either an ID or an name, or both
* A bean can also be instantiated without any ID or name (knows as *anonymous* bean) or as inner bean within a specific bean
* You can use bean IDs or names to retrieve a bean from the *BeanFactory* and also to establish dependency relationships

## 10.2 BeanFactory Implementations
* *DefaultListableBeanFactory*

## 10.3 ApplicationContext
* Is an extension to *BeanFactory*
* In addition to DI services, *ApplicationContext* also provides other services, such as transaction and AOP service, message source for internationalization (i18n), and application event handling
* Spring supports the bootstrapping of *ApplicationContext* by manual coding or in a web container via *ContextLoaderListener*

# 11 Configuring ApplicationContext

## 11.1 Spring Configuration Options (XML and Java Annotations)
* Using XML file can externalize all configuration from Java code, while annotations allow the developer to define and view the DI setup from within the code
* One common approach nowadays is to define the application infrastructure (e.g data source, transaction manager, JMS connection factory, JMX, etc) in XML file, while defining the DI configuration (injectable beans and beans dependencies) in annotations

## 11.2 Basic Configuration Overview
* For XML configuration, you need to declare the required namespace base provided by Spring that your application requires

## 11.3 Declare Spring Components

## 11.4 Using Setter Injection
* To configure Setter Injection using XML configuration, you need to specify <property> tags under the <bean> tag for each <property> into which you want to inject a dependency

* <context:annotation-config> tag discover @Autowired, depencency
* <context:component-scan> - scan for injectable components to inject the dependency

## 11.5 Using Constructor Injection
* Use <constructor-arg>

## 11.6 Avoid Constructor Confusion
* Two constructors with the same numberof arguments and the types used in the arguments are represented in exactly the same way

* You can apply the @Autowired annotation to only one of the constructor methods. If you apply the annotation to more than one constructor method, Spring will complain during bootstrapping the ApplicationContext

## 11.7 Injection Parameters
* Use <value> or @Value annotation

## 11.8 Injection Values Using SpEL
* Use #{spEL} 

## 11.9 Injecting Beans in the Same XML Unit
* The type being injected does not have to be the exact type defined on the target; the types just need to be compatible

## 11.10 Injection and ApplicationContext Nesting

## 11.11 Using Collections for Injection
* Using the collection is simple: you choose either <list>, <map>, <set> or <props> to represent a List, Map, Set, or Properties

## 11.12 Using Method Injection
* Spring's Method Injection capabilities com in two loosely related forms:
    * Lookup Method Injection - provides another mechanism by which a bean can obtain one of its dependencies
    * Method Replacement - allows you to replace the implementation of any method on a bean arbitrarily, without having to change the original source code

## 11.13 Lookup Method Injection
* To overcome the problems encountered when a bean depends on another bean with different lifce cycle - specifically, when a singleton depends on a non-singleton
* Lookup Method Injection works by having your singleton declare a method, the lookup method, which returns an instance of the non-singleton bean

* Method Lookup Injection is intended for use when you want to work with two beans of different life cycles
* Avoid the temptation to use Method Lookup Injection when the beans share the same life cycle, especially if they are singletons

## 11.14 Method Replacement
* Using method replacement, you can replace the implementation of any method on any bean arbitrarily without having to change the source of the bean you are modifying

## 11.15 When to Use Method Replacement
* Recommend to use one *MethodReplacer* per method or group of overloaded methods

## 11.16 Understanding Bean Naming
* Every bean must have at least one name that is unique within the containing *ApplicationContext*
* Spring will look for:
    * *id* attribute
    * *name* attribute, uses the first name defined in the *name* attribute
    * Use the bean's class name as the name

* Avoid using the automatic name by class behavior
* Always use *id* to specifiy the bean's default name
* As a general practice, you should give your bean a name using *id* and then associate the bean with other names using name aliasing

## Bean Name Aliasing

## Bean Instantiaion Mode

## Choosing an Instantiation Mode

## Different Modes of Autowring
* Four modes for autowriring:
    * byName
    * byType
    * constructor
    * default
    * no (default)
* In default mode, Spring will choose between *constructor* and *byType* modes automatically. If you bean has a default (no-arguments) constructor, then Spring uses *byType*; otherwise, it uses *constructor*

## When to Use Autowiring
* Autowring can save you time in small applications, but in many cases, it leads to bad practices and is inflexible in large applications
* Using *byName* seems like a good idea, but it may lead you to give your classes artificial property names so that you can take advantage of the autowiring functionality
* The whole idea behind Spring is that you can create your classes how you like and have Spring work for you, not the other way around
* For any non-trivial application, stter clear of autowiring at all costs

## Bean Inheritance

## Summary
