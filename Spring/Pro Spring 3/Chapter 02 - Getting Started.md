# Chapter 02 - Getting Started
* We will look at the following:
	* *Obtaining Spring*
	* *Spring packaging options*
	* *Spring dependencies*
	* *Spring samples*
	* *Test suite and documentation*
	* *Putting a spring into Hello World!*
	
# 1. Obtaining the Spring Framework

# 2. Understanding Spring Packaging

## 2.1 Spring Modules
* As of Spring version 3.1, Spring comes with 20 modules, packaged into 20 JAR files

* aop - this module contains all the classes you need to use Spring's AOP features within your application. You also need to include this JAR in your application if you plan to use other features in Spring that use AOP, such as declarative transaction management

* asm - is a Java bytecode manipulation framework. Spring depends on this library to analyze the bytecode of Spring beans, dynamically modify them, and generate new bytecode during runtime

* aspects - this module contains all the classes for advanced integration with the AspectJ AOP library

* beans - this module contains all the classes for supporting Spring's manipulation of Spring beans

* context - this module contains classes that provide many extensions to the Spring core

* context.support - this module contains further extensions to the spring-context modeule

* core - this is the core module that you will ned for every Spring application

* expression - this module contains all support classes for Spring Expression Language (SpEL)

* instrument - this module includes Spring's intrumentation agent for Java Virtual Machine (JVM) bootstrapping

* instrumnet.tomcat - this moduel includes Spring's intrumentation agent for JVM bootstrapping in the Tomcat server

* jdbc - this module includes all classes for JDBC support

* jms - this module includes all classes for JMS support

* orm - this module extends Spring's standard JDBC feature set with support for popular ORM tools including Hibernate, iBatis, JDO, and JPA

* oxm - this modules provide support for OXM (Object to XML mapping)

* web.struts - this module include all classes for integration between Spring and the Struts web framework

* test - provides a set of mock classes to aid in testing your application

* transaction - this module provides all classes for supporting Spring's transaction infrastructure

* web - this module contains the core classes for using Spring in your web application

* web.servlet - this module contains all the classes for Spring's own MVC framework

* web.portlet - this module provides support for using Spring MVC in developing portlets for deployment to a portal server environment

# 3. Analyzing Spring Dependencies
* Spring has numerous third-party library dependencies

* aopalliance - The AOP Alliance is a combined, open source collaboration between many projects to provide a standard set of interfaces for AOP in Java

* aspectj - Spring tightly integrates with AspectJ for more powerful AOP features

* caucho - Spring remoting provides support for a wide variety of different protocols, including Caucho's Burlap and Hessian

* cglib - CGLIB is a code generation library that Spring's aop module depends on. CGLIB is capable of generating proxy for both Java classes and interfaces

* dom4j - You must have dom4j when you are using Hibernate

* easymock - EasyMock is used in the Spring test suite

* freemarker - Spring provides wrapper classes around the FreeMarker templating engine and alos provides support for using FreeMarker templates as view for your web applications

* hibernate - these JAR files are required when you are using Spring's Hibernate integration and support classes

* javaassist - This is a library for bytecode manipulation

* mybatis - These files are required when you are using MyBatis

* itext - Spring uses iText to provide PDF support in the Web tier

* jee - Provide support for JEE technologies

* apache-commons - Many of the components from the Apache Commons project are used by Spring

* junit - JUnit is not required at all at runtime; it is used only for building and runing the test suite

* log4j - This is required when you want to use Spring to configure log4j logging

* poi - This adds support for Microsoft Excel ouput to Spring's MVC framework

* quartz - This is used for Spring Quartz-based scheduling support

* struts - The Struts JAR is required whenever you want to use Struts in conjunction with Spring to build a web appliation

* velocity - Spring provides wrapper classes around Velocity to DI-enable it and also to reduce the amount of code you need to write to use Velocity in your application

# 4. The Sample Applications

# 5. Spring Documentation
* One of the aspects of Spring that makes it such a useful framework for real developers who are building real applications is its wealth of well-written, accurate documentation

# 6. Putting a Spring into "Hello World!"

## 6.1 Building the Sample "Hello World!" Application

# 7. Summary
* In this chapter, we presented you with all the background information you need to get up and running with Spring
