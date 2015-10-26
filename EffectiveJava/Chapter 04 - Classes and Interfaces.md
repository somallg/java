# Chapter 04 - Classes and Interfaces

## Item 13: Minimize the accessibility of classes and members
* This concept, known as *information hiding* or *encapsulation*
* *access control* mechanism specifies the *accessibility* of classes, interfaces, and members
* **Make each class or member ass inaccessible as possible**
* **Instance fields should never be public**
* **Classes with public mutable fields are not thread-safe**
* **It is wrong for a class to have a public static final array field, or an accessor that returns such a field**

* To summarize:
    * You should always reduce accessibility as much as possible
    * After carefully designing a minimal public API, you should prevent any stray classes, interfaces, or members from being a part of the API
    * With exception of public static final fields, public classes should have no public fields
    * Ensure that objects referenced by public static final fields are immutable
    
## Item 14: In public classes, use accessor methods, not public fields
* **If a class is accessible outside its package, provide accessor methods**, to preserve the flexibility to change the class's internal representation
* *If a class is package-private or is a private nested class, there is nothing inherently wrong with exposing its data fields**

* In summary:
    * Public class should never expose mutable fields
    * It is less harmful, though still questionable, for public classes to expose immutable fields
    * However, sometimes it is desirable for package-private or private nested classes to expose fields, whether mutable or immutable
    
## Item 15: Minimize mutability
* **Don't provide any methods that modify the object's state**
* **Ensure that the class can't be extended**
* **Make all fields final**
* **Make all fields private**
* **Ensure exclusive access to any mutable components**

* **Immutable objects are simple**
* **Immutable objects are inherently thread-safe; they require no synchronization**
* **Immutable objects can be shared freely**
* **Not only can you share immutable objects, but you can share their internals**
* **Immutable objects make great building blocks for other objects**
* **The only real disadvantage of immutable classes is that they require a separate object for each distinct value**

* To summarize:
    * **Classes should be immutable unless there's a very good reason to make them mutable**
    * **If a class cannot be made immutable, limit its mutability as much as possible**
    * **Make every field final unless there is a compelling reason to make it non-final**
    
## Item 16: Favor composition over inheritance
* **Unlike method invocation, inheritance violates encapsulation**

* To summarize:
    * Inheritance is powerful, but its problematic because it violates encapsulation
    * Use composition and forwarding instead of inheritance
    
## Item 17: Design and document for inheritance or else prohibit it
* **The class must document it self-use of overridable methods**
* **A class may have to provide hooks into its internal working in the form of judiciously chosen protected methods**
* **The only way to test a class designed for inheritance is to write subclasses**
* **You must test your class by writing subclasses before you release it**
* **Constructors must not invoke overridable methods**
* **Neither clone nor readObject may invoke an overridable method, directly or indirectly**
* **Designing a class for inheritance places substantial limitations on the class**
* **The best solution to this problem is to prohibit sub-classing in classes that are not designed and document to be safely sub-classed

## Item 18: Prefer interfaces to abstract classes
* **Existing classes can be easily retrofitted to implement a new interface**
* **Interfaces are ideal for defining mixins**
* **Interfaces allow the construction of non-hierarchical type frameworks**
* **Interfaces enable safe, powerful functionality enhancements**
* **You can combine the virtues of interfaces and abstract classes by providing an abstract skeletal implementation class to go with each nontrivial interface that you export**

* **It is far easier to evolve an abstract class than an interface**
* **Once an interface is released and widely implemented, it is almost impossible to change**

* To summarize:
    * An interface is generally the best way to define a type that permits multiple implementation
    * An exception is the case where ease of evolution is deemed more important than flexibility and power
    * Design all of your public interfaces with utmost care and test them thoroughly by writing multiple implementations
    
## Item 19: Use interfaces only to define types
* **The constant interface pattern is a poor use of interfaces** 

* In summary:
    * Interfaces should be used only to define types
    * They should not be used to export constants use *utility-class* or *enum*
    
## Item 20: Prefer class hierarchies to tagged classes
* **Tagged classes are verbose, error-phone, and inefficient**
* **A tagged class is just a pallid imitation of a class hierarchy**

* In summary:
    * Tagged classed are seldom appropriate
    * When you encounter an existing class with a tag field, consider refactoring it into a hierarchy
    
## Item 21: Use function objects to represent strategies
* To summarize:
    * A Primary use of function pointers is to implement the Strategy pattern
    * To implement this pattern in Java, declare an interface to represent the strategy, and a class that implements this interface of reach concrete strategy
    
## Item 22: Favor static member classes over nonstatic
* **If you declare a member class that does not require access to an enclosing instance, always put the static modifier in its declaration**

* To recap:
    * There are four different kinds of nested classes, and each has its place
    * If a nested class needs to be visible outside of a single method or is too long to fit comfortably inside a method, use a member class
    * If each instance of the member class needs a reference to its enclosing instance, make it non-static; otherwise, make it static
    * Assuming the class belongs inside a method, if you need to create instances from only one location and there is a preexisting type that characterizes the class, make it an anonymous class; otherwise, make it a local class
