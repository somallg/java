# Chapter 14 - Validation with Type Conversion and Formatting
* Validation is critical in Enterprise application
* Verify data being processed

# 1. Spring Type Conversion System

## 1.1 Conversion from a String Using Property Editors

# 2. Introducing Spring 3 Type Conversion

## 2.1 Implementing a Custom Converter

## 2.2 Converting Between Arbitrary Types

# 3. Field Formatting in Spring 3
* Formatter SPI
* org.springframework.format.Formatter<T> interface

## 3.1 Implementing a Custom Formatter

# 4. Validating in Spring
* Validation rules applied to domain objects ensure that all business data is well structured and fulfills all the business definitions
* The ideal case is that all validation rules are maintained in a centralized location and the same set of rules are applied to the same type of data

## 4.1 Using Spring Validator Interface

## 4.2 Using JSR-303 Bean Validation

## 4.3 Defining Validation Constraints on Object Properties
* @NotNull
* @Size