# UDDI: Universal Description, Discovery, and Integration -- Abstract
* UDDI provides a standardized method for publishing and discovering information about web services
* The UDDI Project is an industry initiative that attempts to create a platform-independent, open framework for describing services, discovering businesses, and integrating business services
* UDDI focuses on the process of discovery in the service-oriented architecture

# 1. Introduction
* *A UDDI directory entry* is an XML file that describes a business and the services it offers

* There are three parts to an entry in the UDDI directory:
    * *White pages*: allows customers and partners to discover business services based upon business identification
    * *Yellow pages*: allows others to discover business services based upon its categorization
    * *Green pages*: provide technical information on the behaviours and supported functions of a business service hosted by a business

# 1.1 What are the benefits of UDDI?
* Making it possible to discover the right business from the millions currently online
* Defining how to enable commerce once the preferred business is discovered
* Reaching new customers and increasing access to current customers
* Expanding offering and extending market reach
* Solving customer-driven need to remove barriers to allow for rapid participation in the global Internet economy
* Describing services and business processes programmatically in a single, open, and secure environment

# 2. The UDDI Data Structures
* Data in a UDDI registry can be conceptually divided into four categories:
    * tModel
    * businessEntity
    * businessService
    * bindingTemplate
    
## 2.1 The businessEntity structure
* Represents all known information about a business or entity that publishes descriptive information about the entity as well as the services that it offers

## 2.2 The businessService structure
* Represents a logical service classification

## 2.3 The bindingTemplate structure
* Technical descriptions of Web services are accommodated via individual contained instances of bindingTemplate structures
* These structures provide support for determining a technical entry point or optionally support remotely hosted services, as well as a lightweight facility for describing unique technical characteristics of a given implementation

## 2.4 The tModel structure
*  Provide description with information that designates how a WS behaves, what conventions it follows, or what specifications or standards the service is compliant with
* *Defining the technical fingerprint*
* *Defining an abstract namespace reference*

## 2.5 The publisherAssertion structure

## 2.6 WS-I Basic Profile 1.0 Requirements - Service Publication and Discovery
* REGDATA of type uddi:bindingTemplate representing a conformant INSTANCE MUST contain the uddi:accessPoint element

* REGDATA of type uddi:tModel representing a conformant Web Service type MUST use WSDL as the description language

* REGDATA of type uddi:tModel representing a conformant Web Service type MUST be categorized using uddi:types taxonomy and a categorization of *wsdlSpec*

* The wsdl:binding that is reference by REGDATA of type uddi:tModel MUST itself conform to the Profile


# 3. UDDI Publish API
* *The message defined in this section all behave synchronously and are callable via HTTP-POST only. HTTPS is used exclusively for all the calls defined in this publishers' API*

## 3.1 Authentication/Authorization Operations
* *get_authToke*: used to request an authentication token
* *discard_authToken*: used to inform a node that passed authentication token is to be terminate and effectively end the session when you are finished accessing the UDDI Publishing endpoint

## 3.2 Save Operations
* Allow you to add or update information in the UDDI registry
* To update any part of a data structure, you HAVE TO submit the whole thing; you cannot update a single field

## 3.3 Delete Operations
* Allows you to remove information from the UDDI registry
* The response from UDDI server is a dispositionReport type of response message unless it's reporting a fault

## 3.4 Get Operations

# 4. UDDI Inquery API
* Use the Inquery API for querying the UDDI registry and fetching specific UDDI data structures

# 5. Using WSDL Definitions with UDDI
* WSDL is used to describe the interface of a Web Service
* *tModel* UDDI documents provide metadata descriptions of a Web Service and pointers to specifications that describe their implementation

## 5.1 An Abstraction API
