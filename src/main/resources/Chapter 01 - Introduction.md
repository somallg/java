# Chapter 1 - Introduction

* Designed to help you make the most effective use of the Java Programming Language and its fundamental libraries:
    * *java.lang*, *java.util*, *java.util.concurrent* and *java.io*
    * Do not recover GUI, Enterprise APIs, or mobile devices
    
* Consists of 78 items, each item conveys a rule
    * Rule capture practices generally held to be beneficial by the best and most experienced programmers
    
* Features of Java 5
    * Generics
    * Enums
    * Annotations
    * For-each loop
    * Autoboxing
    * Var-args
    * Static import
    * java.util.concurrent
    
* A software design pattern is "a repeatable solution for a commonly-occurring software problem"    

* Many items contain one or more program examples illustrating some practice to be avoided, such examples, sometimes known as *anti-patterns*

* Most of the rules derive from a few fundamental principles
    * Clarity and simplicity are of paramount importance
    * Modules should be as small as possible but no smaller
    * The term *module* refers to any reusable software component, from an individual method to a complex consisting of multiple packages
    * Code should be reused rather than copied
    * The dependencies between modules should be kept to a minimum
    * Errors should be detected as soon as possible after they are made, ideally at compile time

* The rules characterize best programming practices in the great majority of cases
    * Learning the art of programming, like most other disciplines, consists of first learning the rules and then learning when to break them
    
* This is not about *performance*. It is about writing programs that are clear, correct, usable, robust, flexible and maintainable

* The term *exported API*, or simply API, refers to the classes, interfaces, constructors, members, and serialized forms by which a programmer access a class, interface, or package
    * A programmer who writes a program that uses an APi is referred to as a *user* of the API
    * A class whose implementation uses an API is a *client* of the API

* Classes, interfaces, constructors, members, and serialized forms are collectively known as *API elements*