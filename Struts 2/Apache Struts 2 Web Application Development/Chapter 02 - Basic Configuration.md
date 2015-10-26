# Chapter 02 - Basic Configuration

# 1. Setting up our environment

# 2. A sanity-checking application

# 3. Configuring web.xml for Struts 2
* Struts 2 dispatches requests with a filter (Struts 1 used a servlet)

# 4. Writing our first action
* The *execute()* method is the method Struts 2 will call by default

# 5. Configuring our first action with XML
* Struts 2 configuration files are expected to be on the classpath
* By default, Struts 2 will look for a file named *struts.xml* in the root of the classpath
* The *<package>* element defines a unit of configuration that our actions will live in

# 6. Configuring our result
* Results determine what gets returned to the browser after an action is executed
* Results have optional *name* and *type* attributes
* The default *name* value is success
* Default result type is *dispatcher*

# 7. Choosing an action method

# 8. Getting started with our application
* The traditional model of application development generally starts with the gathering of requirements, followed by separate design, implementation, verification, and maintenance phases
* This is called the **waterfall method**

# 9. Gathering user stories - defining our application

# 10. Building skeletal applications using wildcards
* Wildcard action definitions are a quick way to create the skeleton of an application
* {1} refers to the first wildcard in the action's *name* attribute
* Visiting /foo.action would return /WEB-INF/page/foo.jsp

# 11. Matching multiple wildcards
* Multiple wildcards allow us to map individual portions of the URL to action names, JSPs, directories, and so on

# 12. More wildcard tricks
* We can also use wildcards to define action methods and/or action classes
* Class names must still be legal Java class names

# 13. Packages and namespaces
* Packages and namespaces help group and classify various configuration elements, delineate areas of responsibility, provide package-specific resources, and so on
* Packages can declare a *namespace*, which is effectively a portion of the URL

# 14. Creating site navigation

# 15. Including external configuration files
* Struts 2 configuration files can include additional configuration files with the *<include>* element

# 16. Our application so far

# 17. Examining our configuration

# 18. Configuration via convention and annotations
* The **Convention Plug-in** allows us to operate completely configuration-free, and to use annotations when the defaults aren't quite what we need

# 19. The Convention Plug-in and action-less actions
