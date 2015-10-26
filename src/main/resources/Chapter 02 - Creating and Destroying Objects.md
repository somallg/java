# Chapter 02 - Creating and Destroying Objects

* When and how to create objects, when and how to avoid creating them, how to ensure they are destroyed in a timely manner, and how to manage any cleanup actions that must precede their destruction

## Item 01: Consider static factory methods instead of constructors
* The normal way for a class to allow a client to obtain an instance of itself is to provide a public constructor
* A class can provide a *static factory method*, which is simply a static method that returns an instance of the class
* Note that a static factory method is not the same as the *Factory Method* pattern from *Design Patterns*. The static factory method has no direct equivalent in *Design Patterns*
* A class can provide its clients with static factory methods instead of, or in addition to, constructors

* **One advantage of static factory is that, unlike constructors, they have names**
    * A well-chosen name is easier to use and easier to read code
    * A class can have only a single constructor with a given signature
    * Replace the constructors with static factory methods and carefully chosen names to highlight their differences
* **A second advantage of static factory methods is that, unlike constructor, they are not required to create a new object each time they're invoked**
	* Use pre-constructed instances, or to cache instances ,and dispense them repeatedly to avoid creating unnecessary duplicate objects
	* This technique is similar to the *Flyweight* pattern
	* Allows classes to maintain strict control over what instances exist at any time
	* Classes that do this are said to be *instance-controlled*
	* Instance control allows a class to guarantee that is a Singleton, or non-instantiable
	* It allows an immutable class to make the guarantee that no two equal instances exist
* **A third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type**
	* This technique lends itself to *interface-based frameworks*, where interfaces provide natural return types for static factory methods
	* Requires the client to refer to the returned object by its interface rather than its implementation class, which is generally good practice
	* The class of the object returned by a static factory method need not even exist at the time the class containing the method is written
	* Such flexible static factory methods form the basis of *service provider frameworks*, such as the Java Database Connectivity API (JDBC)
	* A service provider frameworks is a system in which multiple service providers implement a service, and the system makes the implementations available to its clients, decoupling them from the implementations
	* There are three essential components of a service provider framework: a *service interface* (which providers implement), a *provider registration API* (which the system uses to register implementations, giving clients access to them); and a *service access API* (which clients use to obtain an instance of the service
	* The service access API is the *flexible static factory* that forms the basis of the service provider framework
* **A fourth advantage of static factory methods is that they reduce the verbosity of creating parameterized type instances**
	* Map<String, List<String>> m = new HashMap<String, List<String>>();
	* With static factories, the compiler can figure out the type parameters for you, this is known as *type inference*

* **The main disadvantage of providing only static factory methods is that classes without public or protected constructors cannot be sub-classed**
* **A second disadvantage of static factory methods is that they are not readily distinguisable from other static methods**
	* They do not stand out in API doc in the way that constructors do
	* Common names for static factory methods:
		* *valueOf*
		* *of*
		* *getInstance*
		* *newInstance*
		* *getType*
		* *newType*
		
## Item 02: Consider a builder when faced with many constructor
* Static factories and constructors share a limitation: they do not scale well to large numbers of optional parameters
* Traditionally, programmers have used the *telescoping constructor* pattern, in which you provide
	* A constructor with only the required parameters
	* Another with a single optional parameter
	* A third with two optional parameters
	* And so on...
* In short, **the telescoping constructor pattern works, but it is hard to write client cod when there are many parameters, and harder still to read it**

* A second alternative, use *JavaBeans* pattern, call a non-args constructor to create the object and the call setter methods to set each required parameter and each optional parameter
	* **A JavaBean may be in an inconsistent state partway through its construction**
	* *The JavaBeans pattern precludes the possibility of making a class immutable*

* A third alternative that combines the safety of telescoping constructor pattern with the readability of the JavaBeans patterns, its a form of the *Builder* pattern
    * Calls a constructor with all of the required parameters and gets a *builder object*
    * Calls setter-like methods on the builder object to set each optional parameter of interest
    * Calls *build* method to generate the object, which is immutable
    * The builder is a *static member class* of the class it builds
* **The Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters**

## Item 03: Enforce the singleton property with a private constructor or an enum type
* **Making a class a singleton can make it difficult to test its clients**
* Before release 1.5, there were 2 ways to implement singletons: both are based on keeping the constructor private and exporting a public static member to provide access to the sole instance
    * With public final field
    * With static factory
* As of release 1.5, there is a third approach, make an enum type with one element
    * **A single-element enum type is the best way to implement a singleton**
    
## Item 04: Enforce non-instantiability with a private constructor
* *Utility classes* are not designed to be instantiated
* **Attempting to enforce non-instantiability by making a class abstract does not work**
* **A class can be made non-instantiable by including a private constructor**
    * All constructors must invoke a superclass constructor, explicitly or implicitly

## Item 05: Avoid creating unnecessary objects
* It is often appropriate to reuse a single object instead of creating a new functionally equivalent object each time it is needed
* **Prefer primitives to boxed primitives, and watch out for unintentional autoboxing**

## Item 06: Eliminate obsolete object references
* Null out references once they become obsolete
* **Nulling out object references should be the exception rather than the norm**
* **Whenever a class manages its own memory, the programmer should be alert for memory leaks**
* **Another common source of memory leaks is caches**
* **A third common source of memory leaks is listeners and other callbacks**
* Use *heap profiler*

## Item 07: Avoid finalizers
* **Finalizers are unpredictable, often dangerous, and generally unnecessary**
* **Never do anything time-critical in a finalizer**
* **Never depend on a finalizer to update critical persistent state**
* **There is a severe performance penalty for using finalizers**
* Solution **provide a explicit termination method**
* **Explicit termination methods are typically used in combination with the try-finally construct to ensure termination**
* **The finalizer should log a warning if it finds that the resource has not been terminated**
* finalizer chaining is not performed automatically
* Don't use finalizers except as a safety net or to terminate non-critical native resources
    * Remember to invoke super.finalize
    * Remember to log the invalid usage from the finalizer
    * Consider using a finalizer guardian
