## JSR-286 Development tutorial: An Introduction to Portlet Programming

## What exactly is a portlet?
* A Portlet is simply a content-delivery vehicle. It delivers content to a user: a web page, a handheld multimedia device, ...
* Portlets are not **Web Services**, **EJB**, **JavaBeans**
* Portlets are simply Java-based, content delivery vehicles that render themselves with the confines of a portal page

## The mighty portlet interface
* A Portlet is any Java class that implements the *javax.portlet.Portlet*

## Lifecycle methods of the Portlet interface
* *init* and *destroy* methods used to allow a developer to take action when a portlet is first *loaded*, or when a portlet is *unloaded*
* *processAction* used during action-processing phase
* *render* used during the rendering phase

## The abstract class GenericPortlet
* Defines: *doView*, *doEdit*, and *doHelp*
* *doDispatch* method, is always called before any of the other do methods

## What do portlets do?
* The essence of portlet programming is handling the request/response cycle

## The most basic portlet
* Hello World Portlet

## The PortletRequest and PortletResponse
* a Portlet**Request** object, as **Render**Request
* a Portlet**Response** object, as **Render**Response
* Everything a developer wants to *know about* the incoming request is stuffed inside the Portlet**Request**
* Anything a developer wants to *do* is done through the Portlet**Response**

## Request-response programming
* All Portlet development can be broken down to inspecting the incoming PortletRequest, implementing some logic, and the using the PortletResponse to deliver an appropriate reply back to the user

## Everyone loves a good WAR
* A Portlet WAR file contains a deployment descriptor named *web.xml*

## The portlet deployment descriptor: Portlet.xml
* Your portlet must be defined in the portlet.xml

## Conception and the Portlet API

## The remaining elements of a WAR file
* A WAR file also contain a special manifest file, *Manifest.mf*

## What exactly is a WAR file?
* A WAR file is simply a compressed file, containing all of your portlet-related artifacts

## Packaging portlet application
