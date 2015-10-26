# Start up the Velocity Template Engine
* The Velocity Template Engine lets you render data from within applications and servlets
* Primarily used to develop dynamic, servlet-based Websites, Velocity's clean separation of template and Java code, makes it ideal for MVC Web development
* Suits many other purposes: such as code generation, XML generation and transformation, and textual stream processing

## Hello World
* See code

## Why should I use it?
* Designed as an easy-to-use general templating tool, Velocity is useful in any Java application area that requires data formatting and presentation. You should use Velocity for the following reasons:
    * Adapts to many application areas
    * Offers a simple, clear syntax for template designer
    * Offers simple programming model for the developer
    * Develop and maintain templates and code independently
    * Easily integrates into any Java application environment, especially Servlets
    * Enables templates to access any public method of data objects in the context
* Strongly enforces a separation of functional responsibility within the application

## Where do I use it?
* Velocity is successfully used in:
    * Servlet-based Web applications
    * Java and SQL code generation
    * XML processing and transformation
    * Text processing, such as RTF file generation
* Most commonly used as a rendering engine for Java Servlet-based Web application development, in place of or in conjunction with JSPs and other rendering technologies
* Velocity is well suited fo J2EE

## How does it work?
* Use the same general process to create a Velocity-based application as you would any application

## Design-time considerations
* Consider three elements for your design:
    * Which data to include
    * What form the data elements should take
    * What to call those data elements

## Write the code and template design
* Once you agree on data specifics, Velocity lets you write the code and design the template in parallel
* Designer write the template
* As the programmer, you must:
    * Retrieve all the data from the data sources
    * Put the data into the context
    * Render the template with the context to produce output
* Because Velocity renders templates into a *Writer*, you can easily manage the output    

## Velocity Template Language
* VTL (Velocity Template Language) is a simple syntax providing two parts: 
    * *references* (a formalism for accessing objects in the context); 
    * *directives* (a set of statements used for control and action)

## References
* A reference is anything in a template that starts with the "$" character *and* refers to something in the context
* If no corresponding data object exists in the context, the template simply treats the reference as text and renders it as-is into the output stream
* As in the Hello World example, Velocity replaces $name in the template with the *toString()* return value of what is placed in the context under the key *name*
* Velocity reference allows access to any object's public method, and the template's syntax is the same as i would be in Java code
* Velocity incorporates a JavaBean-like introspection mechanism that lets you express method accesses in references using a property notation
* Velocity's support for data access, with references, is a powerful and flexible facility
* Your template references are only required to correspond to publicity accessible methods or be accessible through Velocity's property formalism

## Directives
* The directives in VTL are:
    * #set() (let you set a reference value within the template)
    * #if()
    * #else
    * #elseif()
    * #end
    * #foreach() (support collection types: Object[], Collection, Map, Iterator, Enumeration)
    * #include()
    * #parse()
    * #macro()

## Velocimacro example
* Velocimacros have many interesting features, such as recursion ability, support for private local contexts

## VTL miscellany

## Same data, different templates

## XML template

## Programming with Velocity and Servlets
* Velocity distribution includes a Servlet base class, *org.apache.velocity.servlet.VelocityServlet*, that handles all Velocity and Servlet API
* At the minimum, you must implement a method in which you put data into a supplied context, and return a template

## Now it's your turn
* Velocity embodies these great traits:
    * Easy to use, both for designers *and* programmers
    * Separates your presentation formatting from your code
    * Let you use existing classes as they are
    * Portable and works in any Java application
    * Open source
* One of the interesting things about using Velocity is that the simplicity of the templating model encourages you to do things the "right way"