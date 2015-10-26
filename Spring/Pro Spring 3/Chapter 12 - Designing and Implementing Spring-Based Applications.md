# Chapter 12 - Designing and Implementing Spring-Based Applications

## Designing to Interfaces

## Why Design to Interfaces
* Reduce coupling
* Extends one, implements many -> not constrain an implementing class to a particular base class unnecessarily
* Increase in testability

## The Factory Pattern
* Defines a class whose responsibility is to provide application components with implementation of other application components

## Drawbacks of the Basic Factory Pattern
* No way to change an implementation class without recompile
* No way to make multiple implementations available transparently to different components
* No way simply to switch instantiation models

## Externally Configurable Factories

## Impact of Spring on Interface-Based Design
* Reduce glue code 

## Building a Domain Object Model

## Spring and the Domain Object Model

## The DOM Is Not the Same As a Value Object
* Value Object (DTO) - driven by the need to transfer data remotely
* Domain Object - modeled to represent a real-world concept and is not driven by some need of the application infrastructure

## Why Create a Domain Object Model
* A good DOM makes it easier for developers to transform application requirements into application features

## Modeling Domain Objects
* DOM that is as close to the ideal model as possible without affecting the performance of the data store too much and without having too great an impact on code that has to use the domain objects

## Database Modeling and Domain Object Modeling
* Database Modeling - looking for structure that allows you to store and retrieve data in most efficient and consistent manner

## Modeling Domain Object Relationships
* Relationships in a DOM should be modeled in a  much more OOP-style way, with domain objects maintaining references to other domain objects or lists of domain objects

## Tom Encapsulate Behavior or Not?
* Factor out much of the business logic into a set of service objects that work with domain objects rather than encapsulate this logic inside the domain objects

## Domain Object Model Summary

## Designing and Building the Data Access Layer
* Performing the interaction between the database and transforming the retrieved data to the DOM for processing by the service layer

## Practical Design Considerations

## Domain Objects or Data Transfer Objects?

## DAO Interfaces

## DAO Granularity

