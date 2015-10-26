# OSGi Best Practices
* To prevent common mistakes and build robust, reliable, modular, and extendable systems using OSGi technology

## Introduction to OSGi Technology
* What? - module system for the Java platform
	* Includes visibility rules, dependency management and versioning of bundles 
* Advantages?
	* Dynamic - installing, starting, stopping, updating, uninstalling bundles, all dynamically at runtime
	* Service oriented - services can be registered and consumed inside a VM
	
## OSGi Technology Key Benefits
* Avoids Java Archive (JAR) file hell
* Reuse code
* Simplifies multi-team project
* Enables smaller systems
* Manages deployments local or remotely
* Extensive tool support
* No look in
* Very high adoption rate

## Module Layer Best Practices

### Portable code
* Compile your code against the minimun suitable class libraries
* OSGi specification defines Execution Environments
* Java platform are backward compatible so you should always compile against the lowest version you are comfortable with

### Proper Imports
* Do not assume that everything in the JRE will be available to your bundle
* You bundle must import all packages that it needs

### Minimize Dependencies
* Use **Import-Package** instead of **Require-Bundles**

### Hide Implementation Details
* Put implementation details in separate packages from the public API
* Do not export the implementation packages

### Avoid Class Loader Hierarchy Dependencies
* Use safe OSGi model like services or Extender Model
* Use **DynamicImport-Package: ***

## Lifecycle Layer Best Practices

### Avoid Start Ordering Dependencies
* Do not assume that you can always obtain a service during initialization
* Use a declarative service model like OSGi Declarative Services or Spring OSGi


## Service Layer Best Practices

### Handle Service Dynamism
* Declarative models like Declarative Services, iPOJO and Spring OSGi

### Whiteboard Pattern
* Design API to have the listener registered as a service
* Event source tracks the listener services and calls them when there is an event to deliver

### Extender Model
* The bundle being **extended ** specified a data schema
* Contributing bundles define this data in their bundle

## General Best Practices
* Write you code as POJOs
* Program against interfaces
* Isolate the use of OSGi API to a minimal number of classes
* Let these coupled classes inject dependencies into the POJOs
* Make sure none of your domain classes depend on these OSGi coupled classes
* Use an OSGi ready IoC container like Declarative Services or Spring OSGi to express these dependencies in a declarative form

### Return Quickly from Framework Callbacks
* 1 sec per bundle
* Lazy is good
* Framework callbacks need to return quickly
* If you need to do something that takes some time then either
	* Use eventing
	* Sping off a background thread to perform the long running work
	
### Thread Safety
* Do not hold any loks when you call a method and you do not know the implementation
* In multi-core CPUS, Memory access to shared mutable state must always be synchronized
 
