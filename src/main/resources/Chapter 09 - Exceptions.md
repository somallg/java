# Chapter 09 - Exceptions

## Item 57: Use Exceptions only for exceptional conditions
* **Exceptions are, as their name implies, to be used only for exceptional conditions; they should never be used for ordinary control flow**
* **A well-designed API must not force its clients to use Exceptions for ordinary control flow**

* In summary
    * Exceptions are designed for use in exceptional conditions
    * Don't use them for ordinary control flow, and don't write APIs that force others to do so

## Item 58: Use checked exceptions for recoverable conditions and runtime exceptions for programming errors
* **Use checked exceptions for conditions from which the caller can reasonably be expected to recover**
* **Use runtime exceptions to indicate programming errors**
* **All of the unchecked throwables you implement should subclass RuntimeException**

* To summarize
    * Use checked exception for recoverable conditions
    * Runtime exceptions for programming errors
    
## Item 59: Avoid unnecessary use of checked exceptions

## Item 60: Favor the use of standard exceptions
* Most commonly reused exceptions:
    * IllegalArgumentException
    * IllegalStateException
    * NullPointerException
    * IndexOutOfBoundsException
    * ConcurrentModificationException
    * UnsupportedOperationException
    
## Item 61: Throw Exceptions appropriate to the abstraction
* **Higher layers should catch lower-level exceptions and, in their place, throw exceptions that can be explained in terms of the higher-level abstraction**
* **While exception translation is superior to mindless propagation of exceptions from lower layers, it should not be overused**

* In summary
    * If it isn't feasible to prevent or to handle exceptions from lower layers, use exception translation, unless the lower-level method happens to guarantee that all of its exceptions are appropriate to the higher level
    * Chaining provides the best of both worlds: it allows you to throw an appropriate higher-level exception, while capturing the underlying cause for failure analysis
    
## Item 62: Document all exceptions thrown by each method
* **Always declare checked exceptions individually, and document precisely the conditions under which each one is thrown using the Javadoc @throws tag**
* **Use the Javadoc @throws tag to document each unchecked exception that a method can throw, but do not use the throws keyword to include unchecked exceptions in the method declaration**
* **If an exception is thrown by many methods in a class for the same reason, it is acceptable to document the exception in the class's documentation comment**

* In summary
    * Document every exception that can be thrown by each method that you write
    * This is true for unchecked as well as checked exceptions, and for abstract as well as concrete methods
    * Provide individual *throws* clauses for each checked exception and do not provide *throws* clauses for unchecked exceptions
    * If you fail to document the exceptions that your methods can throw, it will be difficult or impossible for other to make effective use of your classes and interfaces

## Item 63: Include failure-capture information in detail messages
* **To capture the failure, the detail message of an exception should contain the values of all parameters and fields that contributed to the exception**
* It may be appropriate for an exception to provide accessor methods for its failure-capture information

## Item 64: Strive for failure atomicity
* **Generally speaking, a failed method invocation should leave the object in the state that is was in prior to the invocation**

* As a rule
    * Any generated exception that is part of a method's specification should leave the object in the same state it was in prior to the method invocation
    * When this rule is violated, the API documentation should clearly indicate what state the object will be left in
    
## Item 65: Don't ignore exceptions
* **An empty catch block defeats the purpose of exceptions**
* **At the very least, the catch block should contain a comment explaining why it is appropriate to ignore the exception**

* In summary
    * The advice in this item applies equally to checked and unchecked exceptions
    * Whether an exception represents a predictable exceptional condition or a programming error, ignoring it with an empty catch block will result in a program that continues silently in the face of error
    * The program might fail at an arbitrary time in the future, at a point in the code that bears no apparent relation to the source of the problem
    * Properly handling an exception can avert failure entirely
