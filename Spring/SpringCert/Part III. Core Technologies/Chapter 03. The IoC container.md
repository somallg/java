# 3. The IoC container

## 3.1 Introduction to the Spring IoC container and beans
* Spring implements the Inversion of Control (IoC) principle
* IoC is also known as *dependency injection* (DI)
* IoC is a process whereby objects define their dependencies, through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then *injects* those dependencies when it creates the bean
* *org.springframework.beans* and *org.springframework.context* are the basis for Spring IoC container
* *BeanFactory* provides the configuration framework and basic functionality, and the *ApplicationContext* addsmore enterprise-specific functionality
* In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC *container* are called *beans*
* Beans, and the *dependencies* among them, are reflected in the *configuration metadata* used by a container

## 3.2 Container overview
* *org.springframework.context.ApplicationContext* represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the beans
* Your Business Objects (POJOs) + Configuration metadata + Spring Container = Fully configured System

## 3.2.1 Configuration metadata
* Spring IoC container consumes a form of *configuration metadata*

### 3.2.2 Instantiating a container

### 3.2.2.1 Composing XML-based configuration metadata
* Often each individual XML configuration file represents a logical layer or module in your architecture
* Use one or more occurrences of the *<import/>* element to load bean definitions from another file or files

### 3.2.3 Using the container
* Using the method *T getBean(String name, Class<T> type)*

## 3.3 Bean overview
* Spring IoC container manages one or more *beans*
* These beans are created with the configuration metadata that you supply to the container, for example, in the form of the XML *<bean/>* definitions
* Within the container itself, these bean definitions are represented as *BeanDefinition* objects, which contain:
    * A *package-qualified class name*
    * Bean behavioral configuration elements (scope, lifecycle callbacks)
    * References to other beans i.e *collaborators* or *dependencies*
    * Other configuration settings to set in the newly created object
    
### 3.3.1 Naming beans
* Every bean has one or more identifiers. These identifiers must be unique within the container that hosts the bean

#### 3.3.1.1 Aliasing a bean outside the bean definition
* Bean naming conventions is to use the standard Java convention

### 3.3.2 Instantiating beans
* A bean definition essentially is a recipe for creating one or more objects
* The container looks at the recipe for a named bean when asked, and uses the configuration metadata encapsulated by that bean definition to create (or acquire) an actual object
* Use *class* property in one or two ways:
    * To specify the bean class to be constructed by the container directly, somewhat equivalent to Java code using *new* operator
    * To specify the actual class containing the *static* factory method, the object returned from the invocation of the *static* factory method may be the same class or another class entirely
* Inner class names
    * Use *binary* name of the inner class: com.example.Foo$Bar
    
#### 3.3.2.1 Instantiation with a constructor
* Prefer actual JavaBeans with only a default (no-argument) constructor and appropriate setters and getters

#### 3.3.2.2 Instantiation with a static factory method
* Use the *class* attribute to specify the class containing the *static* factory method and an attribute named *factory-method* to specify the name of the factory method

#### 3.3.2.3 Instantiation using an instance factory method
* Instantiation with an instance factory method invokes a non-static method of an existing bean from the container to create a new bean
* To use this mechanism, leave the *class* attribute empty, and in the *factory-bean* attribute specify the name of the bean contains the instance method that is to be invoked to create the object, and *factory-method* attribute

## 3.4 Dependencies
* Code is cleaner with the DI principle and decoupling is more effective when objects are provided with their dependencies

#### 3.4.1.1 Constructor-based dependency injection
* *Constructor-based* DI is accomplished by the container invoking a constructor with a number of arguments, each representing a dependency
* Calling a *static* factory method with specific arguments to construct the bean is nearly equivalent
* Constructor argument resolution matching occurs using the argument's type
* When another bean is referenced, the type is known, and matching can occur
* When a simple type is used, such as *<value>true<value>*, Spring cannot determine the type of the value, and so cannot match by type without help
* As of Spring 3.0 you can also use the constructor parameter name for value disambiguation (need debug flag or @ConstructorProperties annotation)

#### 3.4.1.2 Setter-based dependency injection
* *Setter-based* DI is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or no-argument *static* factory method to instantiate your bean

#### 3.4.1.3 Dependency resolution process
* The container performs bean dependency resolution as follows:
    * The *ApplicationContext* is created and initialized with configuration metadata
    * For each bean, its dependencies are expressed in the form of properties, constructor arguments, or arguments to the static-factory method. These dependencies are provided to the bean, *when the bean is actually created*
    * Each property or constructor argument is an actual definition of the value to set, or a reference to another bean in the container
    * Each property or constructor argument which is a value is converted from its specified format to the actual type
* Beans that are singleton-scoped and set to be pre-instantiated (default) are created when then container is created
* Detects configuration problems, such as reference to non-existent beans and circular dependencies, at container load-time
* Spring sets properties and resolves dependencies as late as possible, when the bean is actually created

#### 3.4.1.4 Examples of dependency injection
* Arguments to the *static* factory method are supplied via *<constructor-arg/>*, exactly the same as if a constructor had actually been used
* The type of the class being returned by the factory method does not have to be of them same type as the class that contains the *static* factory method

### 3.4.2 Dependencies and configuration in detail
* Spring's XML-based configuration metadata supports sub-element types within its *<property/>* and *<constructor-arg/>* element

#### 3.4.2.1 Straight values (primitives, String, and so on)
* The *value* attribute of the *<property/>* element specifies a property or constructor argument as human-readable string representation
* JavaBeans *PropertyEditors* are used to convert these string values from a *String* to the actual type of the property or argument
* The idref element is simply an error-proof way to pass the id (String value - not a reference) of another bean tao a *<constructor-arg/>* or *<property>* element
* *idref* atg allows the container to validate *at deployment time* that the referenced, named bean actually exists

#### 3.4.2.2 References to other beans (collaborators)
* The *ref* element inside a *<constructor-arg>* or *<property/>* definition element is used to set the value of the specified property of a bean to be a reference to another bean
* All references are ultimately a reference to another object
* Scoping and validation depend on whether you specify the id/name of the other object through the *bean*, *local*, or *parent* attribute

* Specifying the target bean through the *bean* attribute of the *<ref/>* tag is the most general from, and allows creation of a reference to any bean in the same container or parent container, regardless of whether it is in the same XML file
* The value of the *bean* attribute may be the same as the *id* attribute of the target bean, or as one of the values in the *name* attribute of the target bean

* Specifying the target bean through the *local* attribute leverages the ability of the XML parser to validate XML id references within the same file
* The value of the *local* attribute must be the same as the *id* attribute of the target bean
* The XML parser issues an error if no matching element is found in the same file
* As such, using local variant is the best choice if the target bean is in the same XML file

* Specifying the target bean through the *parent* attribute creates a reference to a bean that is in a parent container of the current container

#### 3.4.2.3 Inner beans
* A *<bean/>* element inside the *<property/>* or *<constructor-arg/>* elements defines a so-called *inner bean*
* An inner bean definition does not require a defined id or name; the container ignores these values. It also ignores the *scope* flag. Inner beans are *always* anonymous and they are *always* scoped as *prototypes*

#### 3.4.2.4 Collections
* In the *<list/>*, *<set/>*, *<map/>*, and *<props/>* elements, you set the properties and arguments of the Java *Collection* types *List*, *Set*, *Map*, and *Properties*, respectively
* *The value of a map key or value, or a set value, can also again be any of the following elements:*
    * bean | ref | idref | list | set | map | props | value | null
    
* Collection merging
* As of Spring 2.0, the container supports the *merging of collections*. An application developer can define a parent-style <list/>, <map/>, <set/> or <props/> elements, and have child-style <list/>, <map/>, <set/> or <props/>
* The child collection's values are the result of merging the elements of the parent and child collections, with the child's collection elements overriding values specified in the parent collection
*  Use the *merge=true* attribute on the override element

* Limitations of collection merging
* You cannot merge different collection types (suc as a *Map* and a *List*)
* The *merge* attribute must be specified on the lower, inherited, child definition
* The merging feature is available only in Spring 2.0 and later

* Strongly-typed collection (Java 5+ only)
* The generics information about the element type of strongly-typed field is available by reflection

### 3.4.2.5 Null and empty string values
* String treat empty arguments for properties and the like as empty *Strings*
* The *<null/>* element handles *null* values

#### 3.4.2.6 XML shortcut with the p-namespace
* The p-namespace enables you to use the *bean* element's attributes, instead of nested *<property/>* elements, to describe your property values and/or collaborating beans
* The p-namespace is not as flexible as the standard XML format

#### 3.4.2.7 Compound property names
* You can use compound or nested property names when you set bean properties, as long as all components of the path except the final property name are not *null*

### 3.4.3 Using depends-on
* If a bean is a dependency of another that usually means that one bean is set as a property of another
* Typically you accomplish this with the *<ref/>* element in XML-based configuration metadata
* However, sometimes dependencies between beans are less direct; for example; a static initializer in a class needs to be triggered, such as database driver registration
* The *depends-on* attribute can explicitly force one or more beans to be initialized before the bean using this element is initialized
* The *depends-on* attribute and property is used not only to specify an initialization time dependency, but also to specify the corresponding destroy time dependency

### 3.4.4 Lazy-initialized beans
* By default, *ApplicationContext* implementations eagerly create and configure all *Singleton* beans as part of the initialization process
* The behavior is controlled by the *lazy-init* attribute on the *<bean/>* element
* You can also control lazy-initialization at the container level by using the *default-lazy-init* attribute on the *<beans/>* element

### 3.4.5 Autowiring collaborators
* The Spring container can *autowire* relationships between collaborating beans
* You can allow Spring to resolve collaborators automatically for your bean
* Autowiring has the following advantages:
    * Autowiring can significantly reduce the need to specify properties or constructor arguments
    * Autowiring can update a configuration as your objects evolve
* When using XML-based configuration, you specify autowire mode for a bean definition with the *autowire* attribute of the *<bean/>* element
* The autowiring functionality has five modes
    * no - default no autowiring
    * byName - autowiring by property name
    * byType - allows a property to be autowired if exactly one bean of the property type exists in the container
    * constructor - analogous to *byType*, but applies to constructor arguments

### 3.4.5.1 Limitations and disadvantages of autowiring
* Autowiring works best when it is used consistently across a project. If autowiring is not used in general, it might be confusing to developers to use it to wire only one or two bean definitions
* Limitations and disadvantages of autowiring:
    * Explicit dependencies in *property* and *constructor-arg* settings always override autowiring. You cannot autowire so-called *simple* properties such as primitives, *String*, and *Classes*
    * Autowiring is less exact than explicit wiring
    * Wiring information may not be available to tools that may generate documentation from a Spring container
    * Multiple bean definitions within the container may match the type specified by the setter method or constructor argument
* In the latter scenario, you have several options:
    * Abandon autowiring in favor of explicit wiring
    * Avoid autowiring for a bean definition by setting its *autowire-candidate* to *false*
    * Designate a sing bean definition as the *primary* candidate by setting the *primary* attribute of its *<bean/>* element to *true*
    * Implement the more fine-grained control available with annotation-based configuration
    
#### 3.4.5.2 Excluding a bean from autowiring
* Set the *autowire-candidate* attribute of the *<bean/>* element to *false*; the container makes that specific bean definition unavailable to the autowiring infrastructure
* These techniques are useful for beans that you never want to be injected into other beans by autowiring. The bean itself is not a candidate for autowiring other beans

### 3.4.6 Method injection

#### 3.4.6.1 Lookup method injection
* Lookup method injection is the ability of the container to override methods on *container managed beans*, to return the lookup result for another named bean in the container
* *<lookup-method name="methodName" bean="beanName"/>*

#### 3.4.6.2 Arbitrary method replacement
* A less useful form of method injection than lookup method injection is the ability to replace arbitrary methods in a managed bean with another method implementation
* *<replaced-method name="methodName" replacer="beanName">*

## 3.5 Bean scopes
* When you create a bean definition, you create a *recipe* for creating actual instances of the class defined by that bean definition
* Bean scopes
    * singleton - default , single object instance per Spring IoC container
    * prototype - create new instances
    * request - scopes a single bean definition to the lifecycle of a single HTTP *Request*
    * session - scopes a single bean definition to the lifecycle of an HTTP *Session*
    * global session - only valid when used in a portlet context

### 3.5.1 The singleton scope
* Spring IoC container creates *exactly one* instance of the object defined by that bean definition
* The single instance is stored in a cache of such singleton beans, and *all subsequent requests and references* for that named bean return the cached object
* The GoF Singleton - *one and only one* instance of a particular class is created *per ClassLoader*
* Spring - *per container and per bean*

### 3.5.2 The prototype scope
* The non-singleton, prototype scope of bean deployment result in the *creation of a new bean instance* every time a request for that specific bean is made 
* As a rule, use the prototype scope for all stateful beans and the single scope for stateless beans from Spring perspective
* In some respects, the Spring container's role in regard to a prototype-scoped bean is a replacement for the Java *new* operator. All lifecycle management pas that point must be handles by the client

### 3.5.3 Singleton beans with prototype-bean dependencies
* Be aware that *dependencies are resolved at instantiation time*
* If you need a new instance of a prototype bean at runtime more than once, use *method injection*

### 3.5.4 Request, session, and global session scopes
* The *request*, *session*, and *global session* scopes are *only* available if you use a web-aware Spring *ApplicationContext* implementation (such as *XmlWebApplicationContext*)

#### 3.5.4.1 Initial web configuration
* Setup your particular Servlet environment
* Spring Web MVC, *DispatcherServlet*, or *DispatcherPortlet*
* Servlet 2.4+, add *javax.servlet.ServletRequestListener*

#### 3.5.2 Request scope
* Spring container creates a new instance of the bean for each and every HTTP request

#### 3.5.4.3 Session scope
* Spring container creates a new instance of the bean for the lifetime of a single HTTP *Session*

#### 3.5.4.4 Global session scope
* The *global session* scope is similar to the standard HTTP *Session* scope, and applies only in the context of portlet-based web applications

#### 3.5.4.5 Scoped beans as dependencies
* If you want to inject an HTTP request scoped bean into another bean, you must inject an AOP proxy in place of the scoped bean
* Use *<aop:scoped-proxy/>*

* Choosing the type of proxy to create
* By default, when the Spring container creates a proxy for a bean that is marked up with the *<aop:scoped-proxy/>* element, *a CGLIB-based class proxy is created*
* You can configure the Spring container to create standard JDK interface-based proxies for such scoped beans, by specifying *false* for the value of the *proxy-target-class* attribute of the *<aop:scoped-proxy/>* element

### 3.5.5 Custom scopes
* You can define your own scopes, or even redefine existing scopes, you *cannot* override the built-in *singleton* and *prototype* scopes

#### 3.5.5.1 Creating a custom scope
* Implement the *Scope* interface

#### 3.5.5.2 Using a custom scope
* void registerScope(String, Scope)
* You can also do the *Scope* registration declaratively, using the *CustomScopeConfigurer*

## 3.6 Customizing the nature of a bean

### 3.6.1 Lifecycle callbacks
* To interact with the container's management of the bean lifecycle, you can implement the Spring *InitializingBean* and *DisposableBean* interfaces
* You can also achieve the same integration with the container without coupling your classes to Spring interfaces through the use of init-method and destroy method

#### 3.6.1.1 Initialization callbacks
* The *org.springframework.beans.factory.InitializingBean* interface allows a bean to perform initialization work after all necessary properties on the bean have been set by the container
* *void afterPropertiesSet() throws Exception;*

* It is recommended that you do not use the *InitializingBean* interface because it unnecessarily couples the code to Spring
* Alternatively, specify a POJO initialization method
* In the case of XML-based configuration, use the *init-method* attribute

#### 3.6.1.2 Destruction callbacks
* Implementing the *org.springframework.beans.factory.DisposableBean* interface allows a bean to get a callback when the container containing it is destroyed
* *void destroy() throws Exception;*
* Use the *destroy* attribute on the *<bean/>*

#### 3.6.1.3 Default initialization and destroy methods
* The presence of the *default-init-method* attribute on the top-level *<beans/>* element attribute causes the Spring IoC container to recognize a method as the initialization method callback
* The Spring container guarantees that a configured initialization callback is called immediately after a bean is supplied with all dependencies

#### 3.6.1.4 Combining lifecycle mechanism
* As of Spring 2.5, you have three options for controlling bean lifecyle behavior: the *InitializingBean* and *DisposableBean* callback interface; custom *init()* and *destroy()* methods; and the *@PostConstruct* and *@PreDestroy* annotations

* Initialization methods are called as follows:
    * Methods annotated with *@PostConstruct*
    * *afterPropertiesSet()* as defined by *InitializingBean*
    * A custom configured *init()* method

* Destroy methods are called in the same order
    * Methods annotated with *@PreDestroy*
    * *destroy()* as defined by *DisposableBean*
    * A custom configured *destroy()* method
    
#### 3.6.1.5 Startup and shutdown callbacks
* The *Lifecycle* interface defines the essential methods for any object that has it own lifecycle requirements

#### 3.6.1.6 Shutting down the Spring IoC container gracefully in non-web applications
* To register a shutdown hook, you call the *registerShutdownHook()* method that is declared on the *AbstractApplicationContext* class

### 3.6.2 ApplicationContextAware and BeanNameAware
* When an *ApplicationContext* creates a class that implements the *org.framework.context.ApplicationContextAware* interface, the class is provided with a reference to that *ApplicationContext*

* When an *ApplicationContext* creates a class that implements the *org.springframework.beans.factory.BeanNameAware* interface, the class is provided with a reference to the name defined in its associated object definition

### 3.6.3 Other Aware interfaces
* Those interfaces ties your code to the Spring API and does not follow the Inversion of Control style

## 3.7 Bean definition inheritance
* A child bean definition inherits configuration data from a parent definition
* The child definition can override some values, and add others, as needed

## 3.8 Container extension points

### 3.8.1 Customizing beans using the BeanPostProcessor Interface
* The *BeanPostProcessor* interface defines *callback methods* that you can implement to provide your own instantiation logic, dependency-resolution login, and so forth

#### 3.8.1.1 Example: Hello World, BeanPostProcessor-style

### 3.8.2 Customizing configuration metadata with BeanFactoryPostProcessor interface
* *BeanFactoryPostProcessor* operate on the *bean configuration metadata*
* The Spring IoC container allows *BeanFactoryPostProcessor* to read the configuration metadata and potentially change it *before* the container instantiates any beans other than *BeanFactoryPostProcessor*

#### 3.8.2.1 Example: the PropertyPlaceholderConfigurer

### 3.8.3 Customizing instantiation logic with the FactoryBean Interface
* You implement the *org.springframework.beans.factory.FactoryBean* interface for objects that *are themselves factories*

## 3.9 Annotation-based container configuration
* An alternative to XML setups is provided by annotation-based configuration which rely on the bytecode metadata for wiring up components instead of angle-bracket declarations
* Annotation injection is performed *before* XML injection, thus the latter configuration will override the former for properties wired through both approaches

* Are annotations better than XML for configuring Spring?
    * *It depends*
    * Annotation provide a lot of context in their declaration, leading to shorter and more concise configuration
    * XML excels at wiring up components without touching their source code or recompiling them

### 3.9.1 @Required
* @Required annotation applies to bean property setter methods
* This annotation simply indicates that the affected bean property must be populated at configuration time, through an explicit properly value in a bean definition or through autowiring
* The container throws an exception if the affected bean property has not been populated; this allows for eager and explicit failure; avoiding *NullPointerException*

### 3.9.2 @Autowired and @Inject
* You can apply *@Autowired* annotation to "traditional" setter methods, to methods with arbitrary names, to constructors and fields
* JSR 330's *@Inject* annotation can be used in place of String's *@Autowired*. *@Inject* does not have a required property to indicate if the value being injected is optional
* By default, the autowiring fails whenever *zero* candidate beans are available; the default behavior is to treat annotated methods, constructors, and fields as indicating *required* dependencies
* Only *one annotated constructor per-class* can be marked as *required*, but multiple non-required constructors can be annotated
* *@Autowired*'s *required* attribute is recommended over the *@Required* annotation
* The *required* attribute indicates that the property is not required for autowiring purposes, the property is ignored if it cannot be autowired
* *@Required*, on the other hand, is stronger in that is enforces the property that was set by any means supported by the container. If no value is injected, a corresponding exception is raised
* You can also use *@Autowired* for interfaces that are well-known resolvable dependencies: *BeanFactory*, *ApplicationContext*, *ResourceLoader*, *ApplicationEventPublisher*, and *MessageSource*

### 3.9.3 Fine-tuning annotation-based autowiring with qualifiers
* Because autowiring by type may lead to multiple candidates, it is often necessary to have more control over the selection process
* One way to accomplish this is with Spring's *@Qualifier* annotation
* *@Autowired* is fundamentally about type-driven injection with optional semantic qualifiers

### 3.9.4 CustomAutowireConfigurer
* The *CustomAutowireConfigurer* is a *BeanFactoryPostProcessor* that enables you to register your own custom qualifier annotation types even if they are not annotated with Spring's *@Qualifier* annotation

### 3.9.5 @Resource
* *@Resource* takes a name attribute, and by default Spring interprets that value as the bean name to be injected
* In other words, it follows *by-name* semantics
* If no name is specified explicitly, the default name is derived from the field name or setter method
* In the exclusive case of *@Resource* usage with no explicit name specified, and similar to *@Autowired*, *@Resource* finds a primary type match instead of a specific named bean and resolves well-know resolvable dependencies

### 3.9.6 @PostConstruct and @PreDestroy
* A method carrying one of these annotation is invoked at the same point in the lifecyle as the corresponding Spring lifecycle interface method or explicitly declared callback method

## 3.10 Classpath scanning and managed components
* Implicitly detecting the *candidate components* by scanning the classpath
* Candidate components are classes that match against a filter criteria and have a corresponding bean definition registered with the container

### 3.10.1 @Component and further stereotype annotations
* *@Component* is a generic stereotype for any Spring-managed component
* *@Repository*, *@Service* and *@Controller* are specializations of *@Component* for more specific use cases, for example, in the persistence, service, and presentation layers

### 3.10.2 Automatically detecting classes and registering bean definitions
* To autodetect classes and register the beans, use *<context:component-scan base-package="foo.bar"/>*

### 3.10.3 Using filters to customize scanning
* Add *include-filter* or *exclude-filter* sub-elements of the *component-scan* element

### 3.10.4 Defining bean metadata within components
* Spring components can also contribute bean definition metadata to the container

### 3.10.5 Naming autodetected components
* As a general rule, consider specifying the name with the annotation whenever other components may be making explicit references to it

### 3.10.6 Providing a scope for autodetected components
* *@Scope* annotation, simply provide the name of the scope

### 3.10.7 Providing qualifier metadata with annotations
* When relying upon classpath scanning for auto-detection of components, you provide the qualifier metadata with type-level annotations on the candidate class 

## 3.11 Java-based container configuration

### 3.11.1 Basic concepts: @Configuration and @Bean
* Annotating a class with the *@Configuration* indicates that the class can be used by the Spring IoC container as a source of bean definitions
* *@Bean* annotation plays the same role as the *<bean/>* element

### 3.11.2 Instantiating the Spring container using AnnotationConfigApplicationContext
* When *@Configuration* classes are provided as input, the *@Configuration* class itself is registered as a bean definition, and all declared *@Bean* methods within the class are also registered as bean definitions

#### 3.11.2.1 Simple construction
* *@Configuration* classes may be used as input when instantiating an *AnnotationConfigApplicationContext*

#### 3.11.2.2 Building the container programmatically using register(Class<?>...)
* An *AnnotationConfigApplicationContext* may be instantiated using a no-arg constructor and then configured using the *register()* method

#### 3.11.2.3 Enabling component scanning with scan(String...)
* Remember that *@Configuration* classes are meta-annotated with *@Component*, so they are candidates for component-scanning

#### 3.11.2.4 Support for web applications with *AnnotationConfigWebApplicationContext*

### 3.11.3 Composing Java-based configurations

#### 3.11.3.1 Using the @Import annotation
* The *@Import* annotation allows for loading *@Bean* definitions from another configuration class

* Injecting dependencies on imported @Bean definitions

#### 3.11.3.2 Combining Java and XMl configuration
* Spring's *@Configuration* class support does not aim to be a 100% complete replacement for Spring XML
* XML-centric use of *@Configuration* classes
* Declaring *@Configuration* classes as plain Spring <bean/> elements
* Using <context:component-scan/> to pick up @Configuration classes
* @Configuration class-centric use of XML with @ImportResource

### 3.11.4 Using the @Bean annotation
* @Bean is a method-level annotation and a direct analog of the XML *<bean/>* element
* You can use @Bean in a @Configuration or in a @Component-annotated class

#### 3.11.4.1 Declaring a bean

#### 3.11.4.2 Injecting dependencies
* When @Bean have dependencies on one another, expressing that dependency is a simple as having one bean method call another

#### 3.11.4.3 Receiving lifecycle callbacks

#### 3.11.4.4 Specifying bean scope
* Using the @Scope annotation
* @Scope and scoped-proxy
* Lookup method injection

#### 3.11.4.5 Customizing bean naming
* Use *name* attribute

#### 3.11.4.6 Bean aliasing

### 3.11.5 Further information about how Java-based configuration works internally

## 3.12 Registering a LoadTimeWeaver

## 3.13 Additional Capabilities of the ApplicationContext
* *Access to messages in i18n-style*, through the *MessageSource* interface
* *Access to resources*, such as URLs and files, through the *ResourceLoader* interface
* *Event publication*, through *ApplicationEventPublisher*
* *Loading of multiple contexts*

### 3.13.1 Internationalization using MessageSource

### 3.13.2 Standard and Custom Events

### 3.13.3 Convenient access to low-level resources

### 3.13.4 Convenient ApplicationContext instantiation for web applications
* Prefer *ContextLoaderListener*

### 3.13.5 Deploying a Spring ApplicationContext as a J2EE RAR file

## 3.14 The BeanFactory

## 3.14.1 BeanFactory or ApplicationContext?
* Use an *ApplicationContext* unless you have a good reason for not doing so

### 3.14.2 Glue code and the evil singleton
