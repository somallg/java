# XML Namespace - Abstract

# 1. Introduction 

## 1.1 What is a Namespace?
* A namespace is a set of names in which all names are unique
* More than one namespace may appear in a single XML document, to allow a name to be used more than once

## 1.2 Why use namespace in XML?
* XML schema provides a *namespace* mechanism, which uses additional names to distinguish elements with the same name but different meaning in different contexts

# 2. XML Namespace

## 2.1 Definition
* An *XML namespace* is a collection of names, identified by a URI reference, which are used in XML documents as element types and attribute names
* URI references which identify namespace are considered *identical* when they are exactly the same character-for-character
* Names from XML namespaces may appear as qualified name, which contain a single colon, separating the name into namespace prefix and a local part
* The prefix which is mapped to a URI reference, selects a namespace
* URI reference can contain characters not allowed in names, so cannot be used directly as namespace prefixes. Therefore,the namespace prefix serves as a proxy for a URI reference

## 2.2 Namespaces in XML
* Any element or attribute in an XML namespace is uniquely identified by two parts: a namespace name (typically a URI) and a local name. Such a two-part name is known as *qualified name* or *QName*
* In an XML document we use a namespace prefix to qualify the local names of both elements and attributes
* A prefix is really just an abbreviation for the namespace identifier (URI) which is typically quite long and is a painful job to add it to element and attribute names in order to make them unique
* The prefix is first mapped to a namespace identifier through a namespace declaration
* The syntax for a namespace declaration is:
    * *xmlns:<prefix>='<namespace identifier>'*
* The namespace is intended to serve as a virtual *container* for vocabulary and undisplayed content that can be shared in the Internet space
* In the Internet space URLs are unique hence you would usually choose to use URLs to identify namespaces
* A namespace prefix is considered in-scope on the declaration element as well as on any of its descendant elements

# 3. Naming Namespaces
* XML namespace identifier must follow the generic syntax for Uniform Resource Identifier (URI) defined by RFC 2396
* URI is defined as a compact string of characters for identifying an abstract or physical resource
* The most important attribute of a namespace identifier is that it is *unique*

# 4. Declaring Namespaces

## 4.1 Definition
* A namespace is *declared* using a family of reserved attributes
* Such an attribute's name must either be *xmlns* or *xmlns:* as a prefix

## 4.2 Default Namespaces
* A default namespace declaration uses the following syntax:
    * *xmlns='<namespace identifier>'*
* Defining a default namespace for an element saves us from using prefixes in all the child elements
* All unqualified child element names of the element which defines the default namespace are automatically associated with the specific namespace identifier
* The default namespace declaration, however, have absolutely no effect on attributes

## 4.3 NONAMESPACE (undeclaring namespace) declaration
* The following namespace declaration is known as the NONAMESPACE declaration:
    * *xmlns=""*
* An element that is in the NONAMESPACE has its namespace prefix and URI set to empty strings
* *No namespace* exists when there is no default namespace in scope
* A {default namespace} is one that is declared explicitly using xmlns

# 5. Namespace Scope
* The scope of an XML namespace declaration declaring a prefix extends from the beginning of the start-tag to the the end of the corresponding end-tag, excluding the scope of any inner namespace declaration

## 5.1 Re-declaring Namespaces
* Namespace prefixes can be overridden by redeclaring the prefix at a nested scope, but it is not possible to undeclare a namespace prefix

# 6. Uniqueness of Attributes
* No tag can contain two attributes with identical names, or with qualified names that have the same local name and have prefixes that are bound to identical namespace names

# Summary
* A namespace is used to qualify XML element and attribute. In other words, both elements and attributes may be namespace-qualified
* A prefix is not used to qualify an element. What effectively qualifies the element is the namespace to which the prefix is mapped
* The scope of a declared namespace begins at the element where it is declared and applies to all the elements within the content of that element, unless overridden by another namespace declaration with the same prefix name
* A tag with the from: <prefix:tagname> is called a *Qualified Name* or *QName*
* A {default namespace} exists only when you have declared it explicitly. It is incorrect to use the term {default namespace} when you have not declared it
* Both prefixed an {default namespace} can be undeclared in XML 1.1, but prefixed can not be undeclared in XML 1.0
* Both prefixed and {default namespace} can be overridden
* {default namespace} does not apply to attributes directly
* No namespaces exists when there is no default namespace in scope