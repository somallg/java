# XML Basic - Abstract
* XML stand for eXtensible Markup Language. XMl was designed to facilitate the sharing of data across different system, particularly systems connected via the Internet
* XML is a *meta* language because it is used for defining markup languages
* XML is a subset of the Standard Generalized Markup Language (SGML)
* A markup language defined using SGML or XML has a specific vocabulary (labels for elements and attributes) and a declared syntax (grammar defining the hierarchy and other features)
* XML is the basic building block of Web Services. All the Web Services technologies recommended by the WS-I Basic Profile 1.a are built on XML and the XML Schema Language

# 1. XML Introduction
* XML is a W3C recommended markup language for general purpose
* XML was originally envisioned as a language for defining new document formats for the World Wide Web
* XML was designed to facilitate the sharing of data across different systems, particularly systems connected via the Internet
* XML is a subset of the Standard Generalized Markup Language (SGML) and thus can be considered to be a meta-language: a language for defining markup languages

## 1.1 XML and SGML
* SGML is the Standard Generalized Markup Language (ISO 8879:1986); the international standard for defining description of the structure of different types of electronic document
* SGML is very large, powerful and complex. It has been in heavy industrial and commercial use for nearly two decades, and there is a significant body of expertise and software to got with it
* XML is a lightweight cut-down version of SGML which keeps enough of its functionality to make it useful but removes all the optional features which made SGML too complex to program for in a Web environment
* XML is a derivative of SGML, it is more restrictive than SGML:
    * XML provides a dramatic improvement in the ease of writing programs that can parse documents written in XML-derived markup languages
    * XMl greatly simplifies the task of creating custom markup languages that are meaningful to one's own enterprise
    * XML-derived markup languages are slightly less expressive than SGML-based languages
    * XMl-derived markup languages are somewhat wordier than SGML-based languages
    * XML-derived markup languages are less forgiving of syntactical variances than SGML-based languages
    
## 1.2 Markup Languages
* A markup language is merely a set of conventions for denoting which parts of a document should be treated differently from other parts
* Historically, that goal has been archived for written documents by using different styles for different parts of the document. For example, the title can be *printed or displayed* centered on a page, in bold face type, while the body of the document can be presented or displayed as a continuous stream of text, separated from the title by one or more blank "lines"
* This document works well when there's a human around to *look* at the document, and when that human understands that a string of text in bold letters at the top of a page should be understood to be the document title
* A machine, of course, has no such understanding. Someone must write a program to parse the document, and somehow identify which parts are the title and which parts are the texts. Every new style requires a new program, or a new fix to the old program. This scenario quickly becomes unmanageable, obviating all but the simplest operations on documents
* A markup language embeds special *tags* in text that help programs identify the various parts of a document

## 1.3 XML
* A markup language is a mechanism to identify structures in a document
* The XML specification defines a standard way to add markup to documents
* XML is a set of abstract rules for building a markup language
* XMl is not a markup language itself
* XML was designed to describe data
* XML tags are not predefined in XML
* You must define your own tags
* XML uses a DTD (Document Type Definition) or XML schema to describe the data
* XML with a DTD or XML schema is designed to be self-descriptive

## 1.4 Structure and Entities
* XML data is represented and exchanged between software applications in units called XML Document
* An XML Document is made up of declarations, elements, attributes, text data, comments and other components
* XML documents have both logical and physical structure. The logical structure is simply the elements (and attributes) in the document and their order. Logically, the document is composed of declarations, elements, comments, character references, and processing instructions, all of which are indicated in the document by explicit markup

* XML document use storage units called entities to arrange physical structures to produce a logical structure
* Entities define blocks of text for reuse in documents or in DTDs, and include data from other storage units (such as files)
* Every entity is either internal or external
* An internal entity is defined in a document's prolog (along with or within the DTD), and is not associated with any external file or data source
* An external entity is also defined in the prolog, but depends on some external file or data source
* Each XML document has a special text entity called *document entity* or *root entity*. All entities referred to directly or indirectly from the root entity are regarded as parts of the physical structure of the document
* The developers of XML introduced a distinction between *well-formed* documents (which followed the XML syntax) and *valid* documents (whose markup follow a particular language developed *from* XML)
* The concept of a merely *wel-formed* document greatly eased the burden on the document writer, and may be the single most important reason for XML's acceptance
* A well-formed XML document is one from which an XML Processor can successfully build a tree structure

# 2. XML Syntax
* XML document must be well formed in order to be considered XML
* In order to be well formed documents, XML documents must adhere to the following strict syntax rules:
* *XML documents use a self-describing and simple syntax*
    * The first line in the document - the XML declaration - defines the XML version of the document
    * XML is case-sensitive, and the XML declaration must be in lowercase
* *XML building blocks*
    * Elements are the basic building blocks of XML markup
    * Tags consist of element type names
    * The content between the start tag and the end tag of an element is the value of that element
    * If there is no content between the start and end tag, the element is an empty tag
    * Element may have zero to z attributes, even empty elements can have associated attributes
* *All XML elements MUST have a closing tag*
* *All XML documents must have a root tag*
    * The first tag in an XML document is the root tag
    * All XML document must contain a single and unique tag pair to define the root element
    * All other elements must be nested within the root element
    * All elements can hve sub (child) elements
    * Sub elements must be in pairs and correctly nested within their parent element
* *XML tags are case sensitive*
    * With XML, the tag <Message> is different from the tag <message>
* *All XML elements MUST be properly nested*
    * Overlapping elements are not allowed
     * An element must have a closing tag before the next element's starting tag
* *Attribute values MUST always be quoted and are case sensitive. It is illegal to omit quotation marks around attribute values. Each attribute of an element can be specified ONLY once, but in any order*
* *Legal XML names*
    * The first character of a legal XML name must be either a unicode character, an underscore or a colon
* *White space in XML is preserved*
* *With XML, a new line is always stored as LF*
* *The use of ampersand & symbol is RESERVED. XML uses this to define an entity reference*

# 3. XML Declaration
* XML provides the *XML declaration* for us to identify the documents as being XML, along with giving the parsers a few other pieces of information
* The declaration has the following format: <?xml version="version_number" encoding="encoding_declaration" standalone="standalone_status"?>
    
# 4. XML Elements
* The segment of an XML document between an opening tag and a corresponding closing tag is called an *element*
* XML is designed to hold any kind of information in *element*
* An element may contain a mixture of sub-element and PCDATA (text) between the opening and closing tags
* Elements have relationships with other elements in a documents. Same are parents and some are children

* The following terms are used to describe the hierarchical relationships:
    * *Nesting*: process of elements containing other elements
    * *Child*: element that is contained within another element
    * *Parent*: element that contains another element
    * *Sibling*: elements with the same parent
* An XML document must have one *root element*. The *root element* is the ultimate *parent* element

* Tags are very important part of XML
* They are what you use to mark the beginning and ending of elements in your XML documents
* An *XML element* is everything from the element's *start tag* to the element's *end tag*
* An element can have *element content, *mixed* content, *simple* content, *empty* content, or/and *attributes*

## 4.1 Parsed Character Data
* XML documents are read and processed by a specific piece of software called an XML parser
* Any text that gets read by the parser is *Parsed Character Data*, or PCDATA
* Because PCDATA is parsed, it cannot container <, > and / characters

## 4.2 Element Naming

## 4.3 Empty Element
* If an element contains no sub-elements or character data, that element is said to be *empty*
* Use empty elements when:
    * Element has no data other than attributes
    * Used as placeholder for attributes
    * Mark point phenomena
    
# 5. XML Attributes
* XML elements can have attributes which provide a mechanism to further define or classify XML elements; the attributes must be defined in the start tag and never the end tag of XML elements

## 5.1 Rules applied to XML attributes
* Attribute names are case sensitive, can't start with *xml*
* The same attribute name CANNOT appear more than once on an element
* Attribute MUST be declared in the start tag and never the end tag
* Attribute MUST have values even if that value is just an empty string ""
* Attribute value MUST be in quotes

## 5.2 Problems using attributes
* Attributes cannot contain multiple values
* Attributes are not easily expandable
* Attributes cannot describe structures
* Attributes are more difficult to manipulate
* Attributes values are not easy to test against a DTD

## 5.3 Use of elements vs. Attributes
* A common use for attribute is to express dimension or type

## 5.4 Recommendation
* Use elements for data that will be produced or consumed by a business application, and attributes for metadata

# 6. XML Comments
* Comments provide a way to insert into an XML document text that isn't really part of the document, but rather is intended for people who are reading the XML source itself

* *Comments in XML documents must follow these rules*:
    * Can't have a comment inside a tag
    * Can't use "-" or "--" inside a comment
    * Can't place a comment inside of an entity declaration
    * Can't put a comment inside another comment
    * Can't place a comment before the XML declaration
    * Comments can be used to comment out tag sets

# 7. XML CDATA
* CDATA sections are used to escape blocks of text containing special characters, such as "<", ">", "&" and so on 
* CDATA marks the text as literal so that it will not be parsed, instead be considered just a string of characters
* *CDATA sections cannot be nested*

# 8. XML Validation
* An XMl document needs to be valid to be of practical use
* An XML valid document obeys the following rules:
    * The XML document must be well formed
    * The XML document must apply to the rules as defined in a XML Schema or *Document Type Definition* (DTD)

# 9. XML Processing Instructions
* PIs are pretty rare, and are often frowned upon in the XML community
