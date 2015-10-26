# Tiles Basic Usage

# Tiles concepts
* Is an implementation of the *Composite View pattern*
* The implementation of Tiles consists
    * Template
    * Attribute
    * Definition

## Template
* Is the layout of a page

![Template](template.jpg)

## Attribute
* Is a gap in a template that needs to be filled in your application
* An attribute can be of three types:
    * *string*
    * *template*
    * *definition*

## Definition
* Is a composition to be rendered to the end user
* Composed of a *template* and completely or partially *filled attributes**
* If *all* of its attributes are filled, it can be rendered to the end user
* If *not all* of its attributes are filled, it is called an *abstract definition*, it can be used as a based definition for extended definitions, or their missing attributes can be fileed at runtime

## View Preparer
* Befores a definition is rendered, needs to be "prepared"

# Creating and using Tiles pages

## Create a template
* Create a jsp file with <html>, <head>, <body>
* Add tiles:insertAttribute name

## Create the composing pages
* Create header, menu, body and footer

## Create a definition
* By default, the definition file is /WEB-INF/tiles.xml
* define definiton name, and template
* put-attribute name, value

## Render the definition
* Render definition:
    * By using the <tiles:insertDefinition/> tag
    * Render directly in the response, by using the Tiles container
    * Using Rendering Utilities
