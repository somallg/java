# Chapter 11 - Serialization

## Item 74: Impalement Serializable judiciously
* **A major cost of implementing Serializable is that it decreases the flexibility to change the class's implementation once it has been released**
* **A second cost of implementing Serializable is that it increases the likelihood of bugs and security holes**
* **A third cost of implementing Serializable is the it increases the testing burden associated with releasing a new version of a class**
* **Implementing the Serializable interface is not a decision to be undertaken lightly**
* **Classes designed for inheritance should rarely implement Serializable, and interfaces should rarely extend it**
* **You should consider providing a parameterless constructor on nonserializable classes designed for inheritance**
* **Inner classes should not implement Serializable**
* **Default serialized form of an inner class is ill defined**

* To summarize
    * The ease of implementing Serializable is specious
    * Unless a class is to be thrown away after a short period of use, implementing Serializable is a serious commitment that should be made with care
    * Extra caution is warranted if a class is designed for inheritance
    * For such classes, an intermediate design point between implementing Serializable and prohibiting it in subclasses is to provide an accessible parameterless constructor
    * This design point permits, but does not require, subclasses to implement Serializable

## Item 75: Consider using a custom serialized form
* **Do not accept the default serialized from without first considering whether it is appropriate**
* **The default serialized from is likely to be appropriate if an object's physical representation is identical to its logical content**
* **Even if you decide that the default serialized form is appropriate, you often must provide a readObject method to ensure invariants and security**
* **Using the default serialized form when an object's physical representation differs substantially from its logical data content has four disadvantages:
    * **It permanently ties the exported API to the current internal representation**
    * **It can consume excessive space**
    * **It can consume excessive time**
    * **It can cause stack overflows**
* **If all instance fields are transient, it is technically permissible to dispense with invoking defaultWriteObject and defaultReadObject, but it is not recommended**
* **Before deciding to make a field non-transient, convince yourself that its value is part of the logical state of the object**
* **You must impose any synchronization on object serialization that you would impose on any other method that reads the entire state of the object**
* **Regardless of what serialized form you choose, declare an explicit serial version UID in every serializable class you write**

* To summarize
    * When you have decided that a class should be serializable, think hard about what the serializable form should be
    * Use the default serialized form only if it is a reasonable description of the logical state of the object; otherwise design a custom serialized form
    * You should allocate as much time to designing the serialized form of a class as you allocate to designing its exported methods
    * Just as you cannot eliminate exported methods from future versions, you cannot eliminate fields from the serialized form; they must be preserved forever to ensure serialization compatibility
    * Choosing the wrong serialized form can have a permanent, negative impact on the complexity and performance of a class
    
## Item 76: Write readObject methods defensively
* **When an object is deserialized, it is critical to defensively copy any field containing an object reference that a client must not process**
* **Do not use the writeUnshared and readUnshared methods**

* To summarize
    * Anytime you write a readObject method, adopt the mind-set that you are writing a public constructor that must produce a valid instance regardless of what byte stream is given
    * Do not assume that the byte stream represents an actual serialized instance
    * For classes with object reference fields that must remain private, defensively copy each object in such a field. Mutable components of immutable classes fall into this category
    * Check any invariants and throw an InvalidObjectException if a check fails. The checks should follow any defensive copying
    * If an entire object graph must be validated after it is deserialized, use the ObjectInputValidation interface
    * Do not invoke any overridable methods in the class, directly or indirectly
    
## Item 77: For instance control, prefer enum types to readResolve
* **If you depend on readResolve for instance control, all instance fields with object reference types must be declared transient**
* **The accessibility of readResolve is significant**

* To summarize
    * You should use enum types to enforce instance control invariants wherever possible
    * If this is not possible and you need a class to be both serializable and instance-controlled, you must provide a readResolve method and ensure that all of the class's instance field are either primitive or transient

## Item 78: Consider serialization proxies instead of serialized instances
* Design a private static nested class that represent the logical state of an instance of the enclosing class
* In summary
    * Consider the serialization proxy pattern whenever you find yourself having to write a readObject or writeObject method on a class that is not extendable by its clients
    * This pattern is perhaps the easiest way to robustly serialize objects with nontrivial invariants