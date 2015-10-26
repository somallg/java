# Hello, OSGi, Part 1: Bundles for beginners
* Creating, executing, and managing bundles in an OSGi container
* The Open Services Gateway Initiative (OSGi) defines an *architecture* for developing and deploying modular applications and libraries
* OSGi, also know as the *Dynamic Module System for Java*, defines an architecture for modular application development
* OSGi container implementations such as *Knopflerfish*, *Equinox*, and *Apache Felix* allow you to break you application into multiple modules and thus more easily manage cross-dependencies between them
* Similar to the Java Servlet and EJB specifications, the OSGi specification defines two things:
    * A set of services that an OSGi container must implement
    * A contract between the container and your application
* Developing on the *OSGi* platform means first building your application using OSGi APIs, then deploying it in an OSGi container
* From the developer's perspective, OSGi offers the following advantages:
    * Install, uninstall, start and stop different modules of your application dynamically without restarting the container
    * More than one version of a particular module running at the same time
    * Provides very good infrastructure for developing service-oriented applications, as sell as embedded, mobile, and rich internet apps
* OSGi containers are intended specifically for developing complex Java applications that you want to break up into modules

## OSGi in enterprise applications
* OSGi spec was started by the *OSGi Alliance* in March 1999
* Its main goal was to create an open specification for delivering managed services to local networks and devices
* The basic idea is that once you add an OSGi Service Platform to a networked device (embedded as well as servers), you should be able to manage the lifecycle of software components in that device from anywhere in the network
* Software components can be installed, updated, or removed on the fly without ever having to disrupt the operation of the device

## Growing support for OSGi
* Almost all enterprise application servers *support or plan to support OSGi*
* The Spring framework also supports OSGi, via the *Spring Dynamic Modules for OSGi Service Platforms* project, which provides an infrastructure layer to make it easier to use OSGi in Spring-based Java enterprise application development

## Open source OGSi containers
* Using an embedding OSGi container to manage the cross-dependencies to these modules would enable you to update your DAO layer without restarting your application
* As long as your application is compliant with the OSGi specification, it should be able to run in any OSGi-compliant container
* Currently, there are three popular open source OSGi containers:
    * Equinox
    * Knopflerfish
    * Apache Felix

## Developing a Hello World bundle
* In OSGi, software is distributed in the form of a *bundle*
* A bundle consists of Java classes and other resources that deliver functions to device owners, as well as providing services and packages to other bundles

## Creating the bundle
* Follow the step below to create a Hello World bundle using OSGi and Eclipse:
    * File --> New --> Project
    * Select Plug-in Project --> Target Platform: OSGi --> Standard

## Activator
* Activator class implementing the *BundleActivator*
* *BundleActivator* class must have a public constructor that takes no parameters
* The container will call the *start()* method of your *Activator* class to start the bundle
* The container will call the *stop()* method of your *Activator* class to report that it is shutting down a bundle

## MANIFEST.MF
* *MANIFEST.MF* file acts as deployment descriptor for you bundle
