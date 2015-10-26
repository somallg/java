# Chapter 10 - Getting Started with JavaScript
* JavaScript is an incredibly flexible and capable language when used in ways that play to its strengths

# 1. Introduction to JavaScript
* JavaScript has a syntax similar to C, C++ and Java
* It is an object-oriented (OO) language, but not in the same way as Java

# 2. Playing with JavaScript
* The easiest way to play around with JavaScript is to use Firefox combined with the Firebug plug-in

# 3. Minor syntax and language notes

# 4. Unicode
* Modern JavaScript supports Unicode
* Prior to ECMAScript v3, Unicode was allowed only in comments or string literals

# 5. Whitespace
* Whitespace is ignored in JavaScript, except inside string literals
* However, you can use the "\" character to continue a line, including in the middle of string literals

# 6. Semicolons
* To make JavaScript easier, it was decided that semicolons at the end of statements should be optional

# 7. Null an undefined values
* JavaScript has both *null* and *undefined* values
* Variables declared, but not initialized, are *undefined*, not *null*

# 8. The equal and strict equal operators
* Both == (equal) and === (strict equal), and their negated (using a prefixed !) counterparts may be used for equality operations
* They behave differently:
	* The equal operator does type conversion, the strict equal operator doesn't
* In general, we'll usually want to use ===
* Equal (==) and strict equal (===) also behave differently when comparing null and undefined values
* With ==, *null* and *undefined* are equal, whereas with ===, they are not

# 9. The logical OR operator
* The || (logical OR) operator can be used to ensure a variable has a value
* var a = anotherVar || defaultValue;

# 10. Variables and scoping
* Scoping in JavaScript is different from that in Java
* One of the biggest differences is that *undeclared* variables are automatically assumed to be global variables
* Leaving off a *var* keyword inside a function can produce surprising results
* Global variables are evil and can lead to difficult-to-debug code
* In JavaScript only functions have their own scope. For example, blocks inside a *for* loop do not have their own scope, and variables declared within such a block will overwrite variables of the same name outside the block
* Using the *var* keyword inside functions does create a new variable

# 11. JavaScript data types
* JavaScript has only a few data types when compared to Java
* One important difference is that variables in JavaScript are not statically typed
* This implies that a variable initialized to a string in one place can be assigned a number somewhere else

# 12. Numbers
* JavaScript has only one - 64-bit floating point
* Even numbers that look like integers are actually floating point internally
* JavaScript provides a *Math* object that has more complex mathematical operations available

# 13. Decimal, hex, octal
* Numbers can be presented in decimal, hex, or octal
* Hex numbers are prefixed with a 0x, whereas octal numbers are prefixed with a 0

# 14. Conversions
* Numbers can be converted to strings with the *String(obj)* method

# 15. Strings
* JavaScripts strings can be delimited with either single or double quotes
* There is no functional difference between these two types of quotes
* Strings can be concatenated using the plus operator (+). This is similar to Java in the way memory is allocated and a new string is created
* If there are a lot of string concatenations, it can be more efficient to use the *join* method from the Array object

# 16. Length and conversions
* String objects have a *length* property used to determined the length of the string in Unicode characters

# 17. Conversions to other types
* Strings can be converted to numbers using the *Number(obj)* method
* We can also use the *parseInt(obj)* function

# 18. Arrays
* JavaScripts array are objects

# 19. Array functions
* Arrays have their own handy collection of functions:
    * *concat* - for concatenating one array to another
    * *join* - for joining array elements, which takes an optional separator argument and returns a string
    * pop and push - for using arrays like a stack
    * slice - for getting a portion of an array
    * sort - for sorting arrays
    * splice - exhibits fairly complicated behavior
    
# 20. Exception handling
* JavaScript has exception handling similar to that of Java, but sightly different
* One difference is that we can use only a single *catch* block. We still have *finally* blocks

# 21. Introduction to JavaScript objects and OOP
* Objects are at the heart of JavaScript, although functions (which are objects themselves) play a surprisingly significant role once we get more advanced
* While there are few way to create a new object in JavaScript, the canonical method, particularly for structure-like objects, is to use the {} notation, which creates an anonymous object
    * var o = {};
* JavaScript objects can be thought of as a unification of objects and hash tables
* An object is simply an unordered collection of name-value-pairs
* A name can be any string
* Similarly, a value can be any value - including numbers, strings, arrays, other objects, and even functions
* By supplying a comma-separated list of name-value pairs, we can created our own data structures, which can then be accessed in an intuitive way
* When we create a name-value pair, we do not need to quote the "name" string, unless it is a JavaScript reserved word
* The last name-value pair does not have a trailing comma

# 21. Open objects and object augmentation
* Values can be added to objects at any time
* Properties may be accessed using either dot or array notation

# 22. Object values can be functions
* Functions can be the value of a variable

# 23. Object maker functions
* Objects can be created by dedicated creation functions
* This methodology can be used to make sure objects are always created in a specific way, are assigned default values (if no specific value is specified), and so on

# 24. Functions
* When we declare a normal function in JavaScript, we're actually creating a variable that holds that function as its value - that's what the *function* keyword does

# 25. Function parameters
* Function parameters, like all JavaScript variables, are untyped
* In addition, we can call a function with fewer (or more) parameters than listed in the function definition
* Parameters that don't receive a value from the function call are *undefined*, not *nul*
* Functions receive a pseudo-parameter named *arguments* - it acts like a JavaScript array in a way that we can access its *length* property and elements using array notation's []

# 26. Some trickery
* Check for *arguments.length*

# 27. Inner functions
* As a variable can hold a function, we can define a function at any place where a value is expected, including inside other functions

# 28. Closures
* Closures are functions evaluated in a context containing other bound variables 
* Which this actually means is that an inner function has access to the variables from the outer function
* One key consideration is that the inner function will maintain its reference to the outer variable's value at the time of the outer function's invocation

# 29. Introduction to JavaScript classes
* JavaScript is an object oriented language, but not in the same way that Java is
* The bottom line is that JavaScript doesn't have classes
* JavaScript has a *new* keyword, which actually adds to the confusion

* JavaScript uses **prototypal inheritance**, where inheritance is achieved by cloning existing objects and adding new (or modifying existing) functionality

# 30. Creating classes
* We can model classical inheritance in JavaScript using functions and the *new* keyword

* Like Java, JavaScript has a *this* keyword. However, it is used differently depending upon context, and there are some restrictions regarding it can be used

# 31. Variable and function access
* In Java, our classes have both data and methods
* We can do something similar in JavaScript, although it looks fairly unfamiliar in its raw form

# 32. JavaScript's "this" keyword
* Private functions may call neither prototypal nor privileged functions, unless we play a trick on JavaScript
* Private variables are accessible by private and privileged functions, but not prototypal (public) functions

# 33. Prototypes

# 34. JavaScript modules and OOP

# 35. Creating a namespace
* The easiest way to isolate our JavaScript code is to just put it inside an anonymous object

# Summary
