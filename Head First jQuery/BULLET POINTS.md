# 1. jQuery
1. jQuery function
	* You use this to select elements from an HTML page to manipulate
	* The $ shortcut means you don't have to type "jQuery" over and over
	* The jQuery function can handle selectors, straight HTML, and even JavaScript objects

2. Selectors
	* jQuery selects elements the same way CSS does: with selectors
	* Just about any kind of HTML element is fair game for a jQuery selector
3. Fade effect
	* Once you've selected an element, you can fade it in a variety of ways, using FadeIn, FadeOut, FadeTo, and FadeToggle
	* You can fade in all kinds of elements, from text to images and more
	* Control the speed of your fade effect by putting a time (in milliseconds) value inside the parentheses at the end of the statement
	
# 2. Selectors and Methods
1. Selectors
	* $(this) - Selects the current element
	* $("div") - Selects all the div elements on the page
	* $("div p") - Selects all the p elements that are directly inside div elements
	* $(".my_class") - Selects all the elements my the my_class class
	* $("div.myclass") - Selects only the divs that have the my_class class
	* $("#my_id") - Selects the element that has the ID of my_id

2. $(this)
	* Selects the "current" element
	* The meaning of $(this) will change throughout your code, depending on where it is being referenced
	
3. jQuery methods
	* method - A jQuery method is reusable code defined in the jQuery library. You use methods to do stuff in jQuery and in JavaScript. Thinks of a method as a verb - it's all about web page action
	* append - Inserts the specified content into the DOM. It gets added to the end of whatever element calls it
	* remove - Takes elements out of the DOM
	
# 3. jQuery events and functions
1. Events
	* Objects that help users interact with a web page
	* There are around 30 of them, and just about anything that can happen on a browser can trigger an event
	
2. Functions
	* Reusable chunks of code that you can use everywhere in your code ... but only if they are named
	* Unnamed functions only run right where they are called in the code and can't be used anywhere else
	* You can pass variables (or arguments or parameters) to functions, and functions can return results, too
	
# 4. jQuery web page manipulation
1. DOM manipulation
	* You can add to, replace, and remove things from the DOM at will:
		* detach
		* remove
		* replaceWith
		* before
		* after
2. DOM traversal
	* This is all about climbing around the DOM tree so you can manipulate it
	* You use elements relationships with associated method like parent and child to get where you want
	* Chaining methods is an efficient way to traverse the DOM quickly
	
3. Arrays
	* jQuery arrays store all kinds of things, including elements, so you can access them later
	* Just like with variables, put a $ in front of your array to signify that it is storing special jQuery goodies
	
4. Filters
	* Filter methods help you narrow down a set of selected elements:
		* first
		* equal
		* last
		* slice
		* filter
		* not
		
# 5. jQuery effects and animation
1. Fade effects
	* Change the opacity property of CSS elements:
		* fadeIn
		* fadeOut
		* fadeTo
		
2. Slide effects
	* Change the height property of CSS elements:
		* slideUp
		* slideDown
		* slideToggle
		
3. animate
	* Lets you create custom animations when out-of-the-box jQuery effects aren't enough
	* Animates CSS properties over time
	* Only works with CSS properties that have numerical settings
	* Elements can be moved either absolutely or relatively
	* Operator combinations (=, +, -) make relative animation much easier
	
# 6. jQuery and JavaScript
1. JavaScript object
	* Creating stand-alone and creating a constructor
	* Using objects and calling the constructor
	
2. Arrays
	* Creating arrays
	* Assigning values to an array
	* Adding more elements to an array
	* Updating existing array elements
	
3. Loops
	* for loops
	* do...while loop
	* Logical operators
	* Comparison operators
	
4. jQuery
	* .empty
	* $.inArray - Utility method
	* .attr
	* .trigger
	
# 7. Custom functions for custom effects
1. window object
	* This is the topmost object in JavaScript
	* It has properties, event handlers, and methods that help you detect and response to browser events
	* onFocus tells you when a browser window is active
	* onBlur detects when a window loses focus
	
2. Timed functions
	* Methods available for the window object
	* setTimeout wait for a set period of time before telling a function to run
	* setInterval runs a function repeatedly, with a certain amount of time in between
	* clearInterval wipes clean the schedule of repeated function calls
	
3. Optimized custom functions
	* Writing your own custom functions allow you to really start making interactive web pages that people will want to use
	* But you can also get carried away, and it's important to look at how best to combine and optimize your functions so you're writing less code that is easier to maintain and debugs
	
# 8. jQuery and Ajax
1. Ajax
	* A combination of technologies that allow you to update a portion of a web page without having to reload the whole page
	* Makes calls to a back-end server that can process data before sending it back
	* jQuery implements Ajax functionality through the ajax method

2. XML
	* A strict yet flexible markup language used to describe data and data structure
	* Can be used for information storage or formatting data for transfer
	* Used in many common web technologies like RSS, SOAP/Web Services, and SVG
	
3. ajax() shortcuts
	* There are five shortcuts for ajax in jQuery, all configured to ahve different parameters by default, but ultimately calling the ajax method:
		* $.get
		* $.getJSON
		* $.getScript
		* $.post
		* $.load
		
# 9. Handling JSON data
1. MySQL
	* Let you store data in databases and tables and insert and retrieve information using the SQL language
	* SQL - a query language for interacting with database application like MySQL
	
2. JSON
	* Us the getJSON function to get JSON-encoded data from a server. This returns a JSON object
	* Data can be send from a form using the post method. Before you send the data, you need to format it using serializeArray
	
3. PHP
	* A server-side scripting language that lets you manipulate web page content on the server before a page is delivered to the client browser
	* PHP script - a text file that contains PHP code to carry out tasks on a web server
	
4. `<?php ?>`
	* These tags must surround all PHP code in your PHP scripts
	* echo - the PHP command for sending output to the browser window
	
5. $_post
	* A special variable that holds form data
	* json_encode - this command takes an array and converts it to JSON-encoded data, requested by jQuery
	
# 10. jQuery UI
1. jQuery UI
	* An official jQuery library that offers three main types of plug-ins for the jQuery core: effects, interactions, and widgets
	
2. Widget
	* A self-contained component that adds functionality to your web app
	* Saves you tons of coding time and complexity while creating usable and responsive user interface elements
	
3. Button widget
	* Provides a button method to help you make more appealing form elements like submit buttons, radio buttons, and checkboxes
	
4. Datepicker widget
	* The datepicker method instructs the JS interpreter to build the datepicker on the fly, along with a load of HTML, CSS, and built-in interactivity
	* Comes with a host of customizable options, too
	
5. Sliders
	* UI elements that users can manipulate with their mouse or keyboard, controlling the data that they enter
	* Include five event handlers that you use to connect the slider to a form input: create, start, slide, change, and stop
	
# 11. jQuery and APIs
1. APIs
	* Application Programming Interfaces are really just code provided by other people (or companies) that you can tap into for their data, objects, and other services
	* They provide a series of object constructors, allowing you to create your own instances of other objects. Once you have an instance, you use all the properties and methods associated with those objects in your code