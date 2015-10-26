# Chapter 08 - General Programming

## Item 45: Minimize the scope of local variables
* **The most powerful technique for minimizing the scope of a local variable is to declare it where it is first used**
* **Nearly every local variable declaration should contain an initializer**
* **Prefer for loops to while loops**
* **Keep methods small and focused**

## Item 46: Prefer for-each loops to traditional for loops
* In summary
    * The for-each loop provides compelling advantages over the traditional for loop in clarity and bug prevention, with no performance penalty
    * You should use it wherever ou can
    * There are three common situations where you can't use a for-each loop:
        * Filtering - traverse and removed selected elements
        * Transforming - traverse and replace some or all of the values of its elements
        * Parallel iteration - traverse multiple collections in parallel
        
## Item 47: Know and use the libraries
* **By using a standard library, you take advantage of the knowledge of the experts who wrote it and the experience of those who used it before you**
* **Numerous features are added to the libraries in every major release, and it pays to keep abreast of these additions**
* **Every programmer should be familiar with the contents of java.lang, java.util, and, to a lesser extent, java.io**

* To summarize
    * Don't reinvent the wheel
    
## Item 48: Avoid float and double if exact answers are required
* **The float and double types are particularly ill-suited for monetary calculations**

* In summary
    * Don't use float or double for any calculations that require an exact answer
    * Use BigDecimal if you want the system to keep track of the decimal point and you don't mind the inconvenience and cost of no using a primitive type
    * Using BigDecimal has the added advantage that it gives you full control over rounding, letting you select from eight rounding modes whenever an operation that entails rounding is performed
    * If performance is of the essence, you don't mid keeping track of the decimal point yourself, and the quantities aren't too big, use int or long
    * If the quantities don't exceed nine decimal digits, you can use it; if they don't exceed eighteen digits, you can use long
    * If the quantities might exceed eighteen digits, you must use BigDecimal
    
## Item 49: Prefer primitive types to boxed primitives
* **Applying the == operator to boxed primitives is almost always wrong** 
* **When you mix primitives and boxed primitives in a single operation, the boxed primitive is auto-unboxed**

* In summary
    * Use primitives in preference to boxed primitives whenever you have the choice
    * Primitives are simpler and faster. If you must use boxed primitives, be careful
    * **Autoboxing reduce the verbosity, but not the danger, of using boxed primitives**
    * When your program compares two boxed primitives with the == operator, it does an identity comparison, which is almost certainly not what you want
    * **When your program does unboxing it can throw a NullPointerException**
    * When your program boxes primitives value, it can result in costly and unnecessary object creations
    
## Item 50: Avoid Strings where other types are more appropriate
* **String are poor substitutes for other value types**
* **String are poor substitutes for enum types**
* **String are poor substitutes for aggregate types**
* **String are poor substitutes for capabilities**

* To summarize
    * Avoid the natural tendency to represent objects as strings when better data types exist or can be written
    * Used inappropriately, strings are more cumbersome, less flexible, slower, and more error-prone than other types
    * Types for which strings are commonly misused include primitive types, enums, and aggregate types
    
## Item 51: Beware the performance of String concatenation
* **Using the String concatenation operator repeatedly to concatenate n strings requires time quadratic in n**
* **To archive acceptable performance, use a StringBuilder in place of a String**

* Summary
    * Don't use String concatenation operator to combine more than a few Strings unless performance is irrelevant
    * Use StringBuilder's append method instead
    * Alternatively, use a character array, or process the Strings one at a time instead of combining them
    
## Item 52: Refer to objects by their interfaces
* **If appropriate interface types exist, then parameters, return values, variables, and fields should all be declared using interface types**
* **If you get into the habit of using interfaces as types, your program will be much more flexible**
* **It is entirely appropriate to refer to an object by a class rather than an interface if no appropriate interface exists**

* In practice
    * It should be apparent whether a given object has an appropriate interface
    * If it does, your program will be more flexible if you use interface to refer to the object
    * If not, just use the least specific class in the class hierarchy that provides the required functionality
    
## Item 53: Prefer interfaces to reflection
* **You lose all the benefits of compile-time type checking**
* **The code required to perform reflective access is clumsy and verbose**
* **Performance suffers**
* **As a rule, objects should not be accessed reflectively in normal applications at runtime**
* **You can obtain many of the benefits of reflection while incurring few of its costs by using it only in a very limited form**
* **Create instances reflectively and access them normally via their interfaces or superclass**

* In summary
    * Reflection is a powerful facility that is required for certain sophisticated system programming tasks, but it has many disadvantages
    * If you are writing a program that has to work with classes unknown at compile time, you should, if at all possible, use reflection only to instantiate objects, and access the objects using some interface or superclass that is known at compile time
    
## Item 54: Use native methods judiciously
* **It is rarely advisable to use native methods for improved performance**

* In summary
    * Think twice before using native methods
    * Rarely, if ever, use them for improved performance
    * If you must use native methods to access low-level resources or legacy libraries, use as little native code as possible and test it thoroughly
    * A single bug in the native code can corrupt your entire application
    
## Item 55: Optimize judiciously
* **Strive to write good programs rather than fast ones**
* **Strive to avoid design decisions that limit performance**
* **Consider the performance consequences of your API design decisions**
* **It is a very bad idea to warp an API to achieve good performance**
* **Measure performance before and after each attempted optimization**

* To summarize
    * Do not strive to write fast programs - strive to write good ones; speed will follow
    * Do think about performance issues while you're designing systems and especially while you're designing API, wire-level protocols, and persistent data formats
    * Examine your choice of algorithms
    
## Item 56: Adhere to generally accepted naming conventions
* To summarize
    * Internalize the standard naming conventions and learn to use them as second nature
    * The typographical conventions are straightforward and largely unambiguous; the grammatical conventions are more complex and looser
    * Use common sense
