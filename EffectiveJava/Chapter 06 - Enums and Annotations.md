# Chapter 06 - Enums and Annotations

## Item 30: Use enums instead of int constants
* **To associate data with enum constants, declare instance fields and write a constructor that takes the data and stores it in the field**
* **Switches on enums are good for augmenting external enum types with constant-specific behavior**

** In summary:
    * The advantages of enum types over int constants are compelling
    * Enums are far more readable, safer, and more powerful
    * Consider the strategy enum pattern if multiple enum constants share common behaviors
    
## Item 31: Use instance fields instead of ordinals
* **Never derive a value associated with an enum from its ordinal; store it in an instance field instead**

* In summary:
    * *ordinal*: Most programmers will have no use for this method. It is designed for use by general-purpose enum-based data structures such as *EnumSet* and *EnumMap*
    
## Item 32: Use EnumSet instead of bit fields
* In summary:
    * **Just because an enumerated type will be used in sets, there is no reason to represent it with bit fields**
    * You can wrap an EnumSet with Collections.unmodifiableSet, but conciseness and performance will suffer
    
## Item 33: Use EnumMap instead of ordinal indexing
* In summary
    * **It is rarely appropriate to use ordinals to index arrays: use EnumMap instead**
    * If the relationship that you are representing is multidimensional, use EnumMap<..., EnumMap<...>>
    
## Item 34: Emulate extensible enums with interfaces
* In summary:
    * **While you cannot write an extensible enum type, you can emulate it by writing an interface to go with a basic enum type that implements the interface**
    * This allows clients to write their own enums that implement the interface
    * These enums can then be used wherever the basic enum type can be used, assuming APIs are written in terms of the interface
    
## Item 35: Prefer annotations to naming patterns
* **There is simply no reason to use naming patterns now that we have annotations**
* **All programmers should, however, use the predefined annotation types provided by the Java platform**

## Item 36: Consistently use the Override annotation
* **Use the Override annotation on every method declaration that you believe to override a superclass declaration**

* In summary:
    * The compiler can protect you from a great many errors if you use the Override annotation on every method declaration that you believe to override a supertype declaration
    * In concrete classes, you need not annotate methods that you believe to override abstract method declarations (though it is not harmful to do so)
    
## Item 37: Use marker interfaces to define types
* **Marker interfaces define a type that is implemented by instances of the marked class; marker annotations do not**

* In summary:
    * Marker interfaces and marker annotations both have their uses
    * If you want to define a type that does not have any new method associated with it, a marker interface is the way to go
    * If you want to mark program element other than classes and interfaces, to allow for the possibility fo adding more information to the marker in the future, or to fit the marker into a framework that already makes heavy use of annotation types, then a marker annotation is the correct choice
    * **If you find yourself writing a marker annotation type whose target is ElementType.TYPE, take the time to figure out whether it really should be an annotation type, or whether a marker interface would be more appropriate**
