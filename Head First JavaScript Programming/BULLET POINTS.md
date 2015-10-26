# 1.
1. JavaScript is used to add **behavior** to web pages
2. Browser engines are much faster at executing JavaScript than they were just a few years ago
3. Browsers begin executing JavaScript code as soon as they encounter the code in the page
4. Add JavaScript to your page with the `<script>`  element
5. You can put your JavaScript inline in the web page, or link to a separate file containing your JavaScript from your HTML
6. Use the **src** attribute in the `<script>` tag to link to a separate JavaScript file
7. HTML **declares** the structure and the content of your page; JavaScript **computes** values and adds behavior to your page
8. JavaScript programs are made up of a series of **statements**
9. One of the most common JavaScript statements is a variable declaration, which uses the **var** keyword to declare a new variable and the assignment operator, **=**, to assign a value to it
10. There are just a few rules and guidelines for naming JavaScript variables, and it's important that you follow them
11. Remember to avoid JavaScript keywords when naming variables
12. JavaScript expressions compute values
13. Three common types of expressions are **numeric**, **string**, and **boolean** expressions
14. **if/else** statements allow you to make decisions in your code
15. **while/for** statements allow you to execute code many times by looping
16. Use **console.log** instead of **alert** to display messages to the Console
17. Console messages should be used primarily for troubleshooting as users will most likely never see console messages
18. JavaScript is most commonly found adding behavior to web pages, but is also used to script applications like Adobe Photoshop, OpenOffice and Google Apps, and is even used as a sever-side programming language

# 2. 
1. You can use a flowchart to outline the logic of a JavaScript program, showing decision points and actions
2. Before you begin writing a program, it's a good idea to sketch out what your program needs to do with pseudocode
3. **Pseudocode** is an approximation of what your real code should do
4. There are two kinds of boolean operations: comparison operators and logical operators. When used in an expression, boolean operators result in a true or false value
5. **Comparison** operators compare two values and result in true or false. For example, we can use the boolean comparison operator < ("less than") like this: 3 < 6. This expression results in true
6. **Logical** operators combine two boolean values. For example true || false results in true; true && false results in false
7. You can generate a random number between 0 and 1 (including 0, but not including 1) using the **Math.random** function
8. The **Math.floor** function rounds down a decimal number to the nearest integer
9. Make sure you use Math with an uppercase M, and not m, when using Math.random and Math.floor
10. The JavaScript function **prompt** shows a dialog with message and a space for the use to enter a value
11. In this chapter, we used prompt to get input from the user, and alert to display the results of the battleship game in the browser

# 3. Functions
1. Declare a function using the **function** keyword, followed by the name of the function
2. Use parentheses to enclose any **parameters** a function has. Use empty parentheses if there are no parameters
3. Enclose the **body** of the function in curly braces
4. The statement in the body of a function are executed when you call a function
5. **Calling** a function and **invoking** a function are the same thing
6. You call a function by using its name and passing arguments to the function's parameters (if any)
7. A function can optionally return a value using the **return** statement
8. A function creates a local scope for parameters and any local variables the function uses
9. Variables are either in the **global scope** (visible everywhere in your program) or in the **local scope** (visible only in the function where they are declared)
10. Declare local variables at the top of the body of your function
11. If you forget to declare a local variable using **var**, that variable will be global, which could have unintended consequences in your program
12. Functions are good way to organize your code and create reusable chunks of code
13. You can customize the code in a function by passing in arguments to parameters (and using different arguments to get different results)
14. Functions are also a good way to reduce or eliminate duplicate codes
15. You can use JavaScript's many built-in functions, like alert, prompt, and Math.random, to do work in your program
16. Using built-in functions means using existing code you don't have to write yourself
17. It's a good idea to organize your code so functions are together, and your global variables are together, at the top of your JavaScript files

# 4. Arrays
1. Arrays are a **data structure** for ordered data
2. An array holds a set of items, each with its own **index**
3. Array use a zero-based index, where the first item is at index zero
4. All arrays have a **length** property, which holds a number representing the number of items in the array
5. You can access any item using its index. For example, use myArray[1] to access item one (the second item in the array)
6. If an items doesn't exist, trying to access it will result in a value of undefined
7. Assigning a value to an existing item will change its value
8. Assigning a value to an item that that doesn't exist in the array will create a new item in the array
9. You can use value of any type for an array item
10. Not all the values in the array need to be the same type
11. Use the **array literal notation** to create a new array
12. You can create an empty array with var myArray = []
13. The **for loop** is commonly used to iterate through arrays
14. A for loop packages up variable initialization, a conditional test, and variable increment into one statement
15. The while loop is most often used when you don't know how many times you need to loop, and you're looping until a condition is met. The for loop is most often used when you known the number of times the loop needs to execute
16. Sparse arrays occur when there are undefined items in the middle of an array
17. You can increment a variable by one with the **post-increment** operator ++
18. You can decrement a variable by one with the **post-decrement** operator --
19. You can add a new value to an array using **push**

# 5. Objects
1. An object is a **collection of properties**
2. To access a property, use **dot notation**: the name of the variable containing the object, then a period, then the name of the property
3. You can add new properties to an object at any time, by assigning a value to a new property name
4. You can also delete properties from objects, using the **delete** operator
5. Unlike variables that contain primitive values, like strings, numbers, and booleans, a variable can't actually contain an object. Instead, it contains a **reference** to an object. We say that objects are "reference variables"
6. When you pass an object to a function, the function gets a copy of the reference to the object, not a copy of the object itself. So, if you change the value of one of the object's properties, it changes the value in the original object
7. Object properties can contain functions. When a function is in object, we call it a method
8. You call a method by using the **dot notation**: the object name, a period, and the property name of the method, followed by parentheses
9. A method is just like a function except that it is in an object
10. You can pass arguments to methods, just like you can to regular functions
11. When you call an object's method, the keyword **this** refers to the object whose method you are calling
12. To access an object's properties in an object's method, you must use dot notation, with **this** in place of the object's name
13. In object-oriented programming, we think in terms of objects rather than procedures
14. An object has both **state** and **behavior**. State can affect behavior, and behavior can affect state
15. Objects **encapsulate**, or hide, the complexity of the sate and behavior in that object
16. A well-designed object has methods that abstract the details of how to get work done with the object, so you don't have to worry about it
17. Along with the objects you create, JavaScript has many built-in objects that you can use

# 6. DOM
1. The **Document Object Model**, or DOM, is the browser's internal representation of your web page
2. The browser creates the DOM for your page as it loads and parses the HTML
3. You get access to the DOM in your JavaScript code with the document object
4. The document object has properties and methods you can use to access and modify the DOM
5. The **document.getElementById** method grabs an element from the DOM using its id
6. The document.getElementById method returns an **element object** that represents an element in your page
7.  An element object has properties and methods you can use to read an element's content, and change it
8. The **innerHTML** property holds the text content, as well as all nested HTMl content, of an element
9. You can modify the content of an element by changing the value of its innerHTML property
10. When you modify an element by changing its innerHTML property, you see the change in your web page immediately
11. You can get the value of an element's attributes using the **getAttribute** method
12. You can set the value of an element's attributes using the **setAttribute** method
13. If you put your code in a `<script>` element in the `<head>` of your page, you need to make sure you don't try to modify the DOM until the page is fully loaded
14. You can use the window object's **onload** property to set an **event handler**, or callback, function for the load event
15. The event handler for the window's onload property will be called as soon as the page is fully loaded
16. There are many different kinds of events we can handle in JavaScript with event handler functions

# 7. Types
1. There are two groups of types in JavaScript: **primitives** and objects. Any value that isn't a primitive type is an **object**
2. The primitives are: numbers, strings, booleans, null and undefined. Everything else is an object
3. **undefined** means that a variable (or property or array item) hasn't yet been initialized to a value
4. **null** means "no object"
5. "NaN" stands for "Not a Number", although a better way to think of **NaN** is as a number that can't be represented in JavaScript. The type of NaN is number
6. NaN never equals any other value, including itself, so to test for NaN use the function **isNaN**
7. Test two values for equality using == or ===
8. If two operands have different types, the equality operator (==) will try to convert on of the operands into another type before testing for equality
9. If two operands have different types, the strict equality operator (====) returns false
10. You can use === if you want to be sure no type conversion happens, however, sometimes the type conversion of == can come in handy
11. Type conversion is also used with other operators, like the arithmetic operators and string concatenation
12. JavaScript has five **falsey** values: undefined, null, 0, "" (the empty string) and false. All other values are **truthy**
13. Strings sometimes behave like objects. If you use property or method on a primitive string, JavaScript will convert the string to an object temporarily, use the property, and then convert in back to a primitive string. This happens behind the scenes so you don't have to think about it
14. The string has many methods that are useful for string manipulation
15. Two objects are equal only if the variables containing the object references point to the same object

# 8.
1. We use HTML to build the structures of the Battleship game, CSS to style it, and JavaScript to create the behavior
2. The id of each `<td>` element in the table is used to update the image of the elements to indicate a HIT or a MISS
3. The form uses an input with type "button". We attach an **event handler** to the button so we can know in the code when a player has entered a guess
4. To get a value from a from input text element, use the element's **value** property
5. CSS positioning can be used to position elements precisely in a web page
6. We organized the code using three objects: a **model**, a **view**, and a **controller**
7. Each object in the game has one **primary responsibility**
8. The responsibility of the model is to store the state of the game and implement logic that modifies that state
9. The responsibility of the view is to update the display when the state in the model changes
10. The responsibility of the controller is to glue the game together, to make sure the player's guess is sent to the model to update the state, and to check to see when the game is complete
11. By designing the game with objects that each have a **separate responsibility**, we can build and test each part of the game independently
12. To make it easier to create and test the model, we initially hardcoded the locations of the ships. After ensuring the model was working, we replaced these hardcoded locations with random locations generated by code
13. We used properties in the model, like numShips and shipLength, so we don't hard-code values in the methods that we might want to change later
14. Arrays have an **indexOf** method that is similar to the string indexOf method. The array indexOf method takes a value, and returns the index of that value if it exists in the array, or -1 if it does not
15. With **chaining**, you can string together object references (using the dot operator), thus combining statements and eliminating temporary variables
16. The **do while** loop is similar to the while loop, except that the condition is checked after the statements in the body of the loop have executed once
17. **Quality assurance** (QA) is an important part of developing your code. QA requires testing not just valid input, but invalid input as well

# 9. Events
1. Most JavaScript code is written to react to **events**
2. There are many different kinds of events your code can react to
3. To react to an event, you write an **event handler** function, and register it. For instance, to register a handler for the click event, you assign the handler function to the onclick property of an element
4. You're not required to handle any specific event. You choose to handle the events you're interested in
5. **Functions** are used for handlers because functions allow us to package up code to be executed later (when the event occurs)
6. Code written to handle events is different from code that executes top to bottom and then completes. Event handlers can run at any time and in any order: they are **asynchronous**
7. Events that occur on elements in the DOM (DOM events) cause an event object to be passed to the event handler
8. The **event object** contains properties with extra information about the event, including the type (like "click" or "load") and target (the object on which the event occurred)
9. Older versions of IE (IE 8 or older) have a different event model from other browsers
10. Many events can happen very close together. When too many events happen for the browser to handle them as they occur, the events are stored in an **event queue** (in the order in which they occurred) so the browser can execute the event handlers for each event in turn
11. If an event handler is computationally complex, it will slow down the handling of the events in the queue because only one event handler can execute at a time
12. The functions **setTimeout** and **setInterval** are used to generate time-based events after a certain time has passed
13. The method **getElementsByTagName** returns zero, one or more element objects in a NodeList (which is array-like, so you can iterate over it)

# 10. Functions Advance
1. There are two ways to define a function: with a **function declaration** and with a **function expression**
2. A **function reference** is a value that refers to a function
3. Function declarations handled before your code is evaluated
4. Function expressions are evaluated at runtime with the rest of your code
5. When the browser evaluates a function declaration, it creates a function as well as a variable with the same name as the function, and stores the function reference in the variable
6. When the browser evaluates a function expression, it creates a function, and it's up to you what to do with the function reference
7. **First class** values can be assigned to variables, included in data structures, passed to functions, or returned from functions
8. A function reference is a first class value
9. The array **sort** method takes a function that knows how to compare two values in an array
10. The function you pass to the sort method should return on of those values: a number greater than 0, 0, or a number less than 0

# 11. Anonymous functions, scope and closures
1. An **anonymous function** is a function expression that has no name
2. Anonymous functions can make your code more concise
3. A **function declaration** is defined before the rest of your code is evaluated
4. A **function expression** is evaluated at runtime with the rest of your code, and so is not defined until the statement in which it appears is evaluated
5. You can pass a function expression to another function, or return a function expression from a function
6. A function expression evaluates to a **function reference**, so you can use a function expression anywhere you can use a function reference
7. **Nested functions** are functions defined inside another function
8. A nested function has local scope, just like other local variables
9. **Lexical scope** means that we can determine the scope of a variable by reading our code
10. To bind the value of a variable in nested function, use the value that's defined in the closest enclosing function. If no value is found, then look in the global scope
11. **Closures** are a function along with a referencing environment
12. A closure captures the value of variables in scope at the time the closure is created
13. **Free variables** in the body of a function are variables that are not bound in the body of that function
14. If you execute a function closure in a different context in which it was created, the values of free variables are determined by the referencing environment
15. Closures are often used to capture state for event handlers

# 12. Advanced Object Construction
1. An **object literal** works well when you need to create a small number of objects
2. A **constructor** works well when you need to create many similar objects
3. Constructors are functions that are meant to be used with the **new** operator. We capitalize the names of constructors by convention
4. Using a constructor we can create objects that are consistent, having the same property names and methods
5. Use the **new** operator with a constructor function call to create an object
6. When you use **new** with a constructor function call, it creates a new, empty object, which is assigned to **this** within the body of the constructor
7. Use **this** in a constructor function to access the object being constructed and add properties to the object
8. A new object is returned automatically by the constructor function
9. If you forget to use **new** with a constructor, no object is created. This will cause errors in your code that can be difficult to debug
10. To customize objects, we pass arguments to a constructor, and use those values to initialize the properties of the object being created
11. If a constructor has a lot of parameters, consider consolidating them into one object parameter
12. To know if an object was created by a specific constructor, use the **instanceof** operator
13. You can modify an object that was created by a constructor just like you can modify an object literal
14. JavaScript comes with a number of constructors you can use to create useful objects like date objects, regular expressions and arrays

# 13. Prototypes
1. JavaScript's object system uses **prototypal inheritance**
2. When you create an instance of an object from a constructor, the instance has its own customized properties and a copy of the methods in the constructor
3. If you add properties to a constructor's prototype, all instances created from that constructor **inherit** those properties
4. Putting properties in a prototype can reduce runtime code duplication in objects
5. To **override** properties in the prototype, simply add the property to an instance
6. A constructor function comes with a default **prototype** that you can access with the function's prototype property
7. You can assign your own object to the prototype property of a constructor function
8. If you use your own prototype object, make sure you set the constructor function correctly to the constructor property for consistency
9. If you add properties to a prototype after you've created instances that inherit from it, all the instances will immediately inherit the new properties
10. Use the **hasOwnProperty** method on an instance to find out if a property is defined in the instance
11. The method **call** can be used to invoke a function and specify the object to be used as **this** in the body of the function
12. **Object** is the object that all prototypes and instances ultimately inherit from
13. Object has properties and methods that all object inherit, like toString and hasOwnProperty
14. You can override and add properties to built-in objects like Object and String, but take care when doing so as your changes can have far-ranging effects
15. In JavaScript, almost everything is an object, including functions, arrays, many built-in objects, and all the custom objects you make yourself

