# Chapter 03 - Methods Common to All Objects
* Object is a concrete class, it is designed primarily for extension
* All of its non-final methods (equals, hashCode, toString, clone, and finalize) have explicit *general contracts*, because they are designed to be overridden

## Item 08: Obey the general contract when overriding equals
* Not override the equals method, when:
    * **Each instance of the class is inherently unique**
    * **You don't care whether the class provides a logical equality test**
    * **A superclass has already overridden equals, and the superclass behavior is appropriate for this class** 
    * **The class is private or package-private, and you are certain that its equals method will never be invoked**
    
* equals contract:
    * *Reflexive*
    * *Symmetric*
    * *Transitive*
    * *Consistent*
    * *Non-nullity*
* **Once you've violated the equals contract, you simply don't know how other objects will behave when confronted with your object**
* **There is no way to extend an instantiable class and add a value component while preserving the equals contract**
* Whether or not a class is immutable, **do not write an equals method that depends on unreliable resources**

* Recipe for a high-quality equals method:
    * **Use the == operator to check if the argument is a reference to this object**
    * **Use the instanceof operator to check if the argument has the correct type**
    * **Cast the argument to the correct type**
    * **For each "significant" field in the class, check if that field of the argument matches the corresponding field of this object**

* **Always override hashCode when you override equals**
* **Don't try to be too clever**
* **Don't substitute another type for Object in the equals declaration**

## Item 09: Always override hashCode when you override equals
* **The key provision that is violated when you fail to override hashCode is the second one: equal objects must have equal hash codes**
* **Do not be tempted to exclude significant parts of an object from the hash code computation to improve performance**

## Item 10: Always override toString
* **Providing a good toString implementation makes your class much more pleasant to use**
* **When practical, the toString method should return all of the interesting information contained in the object**
* **Whether or not you decide to specify the format, you should clearly document your intentions**
* Whether or not you specify the format, **provide programmatic access to all of the information contained in the value returned by toString**

## Item 11: Override clone judiciously
* Cloneable determines the behavior of Object's protected clone implementation
    * If a class implements Cloneable, Object's clone method must returns a field-by-field copy of the object; otherwise it throws CloneNotSupportedException
* **If you override the clone method in a non-final class, you should return an object obtained by invoking super.clone**
* In practice, a class that implements Cloneable is expected to provide a properly functioning public clone method
* **In effect, the clone method functions as another constructor; you must ensure that is does no harm to the original object and that is properly establishes invariants on the clone**
* **The clone architecture is incompatible with normal use of final fields referring to mutable objects**

* All classes that implement Cloneable should override clone with a public method whose return type is the class itself
* This method should first call super.clone and then fix any fields that need to be fixed
* **You are better of providing an alternative means of object copying, or simply not providing the capability**
* **A fine approach to object copying is to provide a copy constructor or copy factory**

## Item 12: Consider implementation Comparable
* By implementing Comparable, a class indicates that its instances have a *natural ordering*
* The general contract of *compareTo* method is similar to that of *equals*:
    * sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
    * x.compareTo(y) > 0 && y.compareTo(z) > 0 => x.compareTo(z) > 0
    * x.compareTo(y) == 0 => sgn(x.compareTo(z)) == sgn(y.compareTo(z))
    * Strongly recommended, but not strictly required, (x.compareTo(y) == 0) == (x.equals(y))

* Compare integral primitive fields using the relational operators < and >
* For floating-point fields, use *Double.compare* or *Float.compare*
* If a class has multiple significant fields, the order in which you compare them is critical. You must start with the most significant field and work your way down
