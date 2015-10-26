# XML Schema - Abstract
* DTDs are very useful if you want to describe the structure of a document
* XML is used to markup data, not simply markup a document
* DTD is CFG (context-free grammar) for document type. It lacks Data types, Inheritance, and Default values. Also, it is Non-XML
* XML Schemas express shared vocabularies and allow machines to carry out rules made by people
* They provide a means for defining the structure, content and semantics of XML documents. XML schema is a language for defining the structure of XML documents

# 1. Introduction to XML Schema
* A XML Schema describes an XML markup language. Specially it defines which elements and attributes are used in a markup language, how they are ordered and nested, and what their data types are
* The XML specification includes the DTD (Document Type Definition), which can be used to describe XML markup languages and to validate XML documents
* While DTDs have proven very useful over the years, they are limited. The W3C created a new way to describe markup languages called *XML Schema*
* XML Schema is an XML based alternative to DTD. An XML Schema not only describes the structure of an XML document, but also address data typing

## 1.1 What is an XML Schema?
* An *XML Schema* is a predefined set of elements/attributes/values for defining *types*
* A XML Schema does the following:
    * define elements that can appear in a document
    * define attributes that can appear in a document
    * define which elements are child elements
    * defines the sequence in which the child elements can appear
    * defines the number of child elements
    * defines whether an element is empty or can include text
    * define default value for attributes
    
* XML schema is an alternative and update to DTD. The main objectives of XML Schema include:
    * XML format
    * Extensibility, i.e allow other schemas to be imported
    * Finer control over data typing
    * Support for XML namespaces

## 1.2 What is in an XML Schema file?
* Schema can contain many different kinds of statements, but the most common ones are:
    * Element declarations
    * Type definitions

## 1.3 XML Schemas are the Successors of DTDs
* A significant difference between Schemas and DTDs is that Schemas define many basic data types: string, boolean, float, double, decimal, timeDuration, recurringDuration, binary, and uri
* XML Schemas will be used as a replacement for DTDs:
    * Easier to learn
    * Extensible for future additions
    * Richer and more useful
    * Written in XML
    * Support data types
    * Support namespaces
    
## 1.4 XML Schema Instance Document
* An *XML Schema instance document* is an XML document that conforms to a particular schema

## 1.5 Schema Elements and Subelements
* Each schema has a schema element and a variety of subelements
* Subelements determine appearance of elements and their content in instance documents
* Types of subelements are element, complexType, and simpleType
* Elements begin with *xsd:* to associate them with XML Schema namespace

# 2. XML Schema Data Types
* A Schema describes the structure of an XML document in terms of *complex types* and *simple types*
* Complex types describe how element are organized and nested
* Simple types are the primitive data contained by elements and attributes
* One of the benefits of using Schema is the ability to control data types for elements and attributes

## 2.1 Simple Types
* The XML Schema specification defines many standard *simple types*, called *built-in types*
* Simple element type will not contain other element, it will contain only data

## 2.2 Complex Types
* A Scheme may declare *complex type*, which define how elements that contains other elements are organized

## 2.3 When do you use the complexType element and the simpleType element?
* Use the complexType element when you want to define child element and/or attributes of an element
* Use the simpleType element when you want to create a new type that is a refinement of a built-in type

## 2.4 Create Your Own Data Types

# 3. Declarations
