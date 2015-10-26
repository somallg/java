# Chapter 06 - Introducing Spring AOP
* AOP complements OOP, rather than competes with it
* OOP lacking

## AOP Concepts
* *Joinpoints* - a well-defined point during the execution of your application. Define the points in your application at which you can insert additional logic using AOP
* *Advice* - action, the code that is executed at a particular joinpoint. There many different types of advice, such as *before*, *after*
* *Pointcuts* - collection of joinpoints that you use to define when advice should be executed
* *Aspects* - combination of advice and pointcuts. This combination results in a definition of the logic that should be included in the application and where it shoiuld execute
* *Weaving* - process of actually inserting aspects into the application code at the appropriate point
* *Target* - an object whose execution flow is modified by some AOP process
often referred as the advised object
* *Introduction* - process by which you can modify the structure of an object by introducing additional methods or fields to it

## Types of AOP

## Static AOP
* Modifying the actual bytecode of your application, changing and extending the application code as necessary
* Need to recompile the entire application after modify aspects

## Dynamic AOP
* Create proxies for all advised objects, allowing for advice to be invoked as required
* Performance vs Static AOP
* Does not need to recompile

## Choosing an AOP Type

## AOP in Spring

## The AOP Alliance
* Join effort between representatives of many open source AOP projects 
* Standard, resuse certain advice across multiple AOP implementations

## Hello World in AOP

## Spring AOP Architecture
* The core architecture of Spring AOP is based around proxies

## Joinpoints in Spring
* One of the more noticeable simplications in Spring AOP is that it supports only one joinpoint type: Method Invocation
* Method Invocation is by far the most useful joinpoint available

## Aspects in Spring
* An aspects is represented by an instance of a class that implements the *Advisor* interface 
* There are two subinterfaces of *Advisor*:
    * IntroductionAdvisor
    * PointcutAdvidor

## About the ProxyFactory Class
* *ProxyFactory* class controls the weaving and proxy creation process in Spring AOP

## Creating Advice in Spring
* Before - MethodBeforeAdvice
* After returning - AfterReturningAdvice
* After finally - AfterAdvice
* Around - MethodInterceptor
* Throws - ThrowsAdvice
* Introduction - IntroductionInterceptor

## Interfaces for Advice

## Create Before Advice

## Adviors and Pointcuts in Spring

## The Pointcut Interface

## Available Pointcut Implementations

## Using DefaultPontcuAdvisor

## Configuring AOP Declaratively
* Using ProxyFactoryBean
* Using Spring aop namespace
* Using @AspectJ-style annotation

## Using ProxyFactoryBean

## Using Spring aop namespace
* args() instructs Spring to also pass the argument into the advice
* bean(foo*) instructs Spring to advice only the beans with an ID that has foo as prefix

## Using @AspjectJ-Style Annotations
* @Aspect
* @Before
* @Around
* @Poincut

## Considerations for Declarative Spring AOP Configuration
* The poincut expression syntax has some minor differences
* The aop namespace approach supports only the *singleton* aspect instantiation
* In aop namespace, you can't *combine* multiple pointcut expression

## AspectJ Integration
* Spring AOP only supports pointcuts matching on the execution of public nonstatic methods

## About AspectJ
