# Chapter 01. Spring In Context - Core Concepts
* This chapter is about the **Big Picture**. We will explore the core concepts behind Spring and what it brings to Java EE Object Oriented methodologies
* What makes a framework, work?
    * Frameworks ten to be build around a design pattern and consist of frozen spots - structural components which are unmodified by the developer - and hot spots, the pieces that an application developer contributes
    * In Spring, the hot spots are developer-contributed POJOs which are configured to run within the framework

## 1.1 Spring and Inversion of Control
* IoC is much larger than dependency injection
* The main idea behind Inversion of Control as a concept is that component dependencies, lifecycle events, and configuration reside outside of the components themselves, and in the case of Spring, in the framework
* It can make your code more manageable, more testable, and more portable

* Dependency Inversion: Precursor to Dependency Injection
* Three defining factors of "bad code":
    * It is hard to change because every change affects too many other parts of the system (Rigidity)
    * When you make a change, unexpected parts of the system break (Fragility)
    * It is hard to reuse in another application because it cannot be disentangled from the current application (Immobility)
* Dependency Inversion Principle (DIP) has two basic rules:
    * High level modules should not depend upon low level modules, both should depend upon abstractions
    * Abstractions should not depend upon details, details should depend upon abstractions
    
## 1.2 Dependency Injection To The Rescue
* Dependency Injection has the concept of an *assembler* or what in Java is commonly referred to as *Factory* - that instantiates the objects required by an application and injects them into their dependent objects
* IoC container manages the instantiation, management, and class casting of the implemented objects so that the application doesn't have to

