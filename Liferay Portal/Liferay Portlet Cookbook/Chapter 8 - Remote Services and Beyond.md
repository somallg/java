# Chapter 8 - Remote Services and Beyond
* This Chapter Covers:
    * SOAP / RPC based WS
    * JSON Web Service
    * RESTful Web Service
    * The Beyond Part
    * Calling Portal's JSON WS
    * Service Context and its significance

## 8.1 SOAP / RPC based Web Services
* When Service Builder generates the database entries, WS can be generated as well based on Apache Axis

### 8.1.1 Web Services Exposed by Liferay
* http://localhost:8080/api/axis

### 8.1.2 Invoking (Consuming) Existing Web Service

### 8.1.3 Few Important notes around Web Services
* Liferay has jar file support client
* Securing the WS: in **portal-ext.properties** 

### 8.1.4 Exposing WS for a Custom Plugin
* Identify what you want to expose. Enable **remote-service** for an Entity and run the Service Builder
* Inside the newly generated class **LMSBookServiceImpl**, define a new method (API) what we are going to expose
* Invoking **Build Service** and **Build WSDD**, a new file **server-config.wsdd** got generated inside **WEB-INF**

### 8.1.5 Consuming (Invoking) custom Web Service
* Generate the subs and interface required for the remote call with the help os WSDL URL
* Create ServiceSoapServiceLocator
* Create ServiceSoap using ServiceSoapServiceLocator
* Add book using ServiceSoap

### 8.1.6 Generating "library-service-client.jar"
* Liferay has a feature to automatically generate the stubs
* Run "Ant" target "build-client"

## 8.2 JSON Web Service
* SOAP is an extremely powerful way of making WS to work, but there are some limitations:
    * It is a bit heavy as lot of marshaling and un-marshaling happens both in the client and server side
    * The client should always aware of the interfaces and they have to be made available to them
    * SOAP is more "old school", and tends to be the favored approach by Java developers
* The idea behind JSON Web Services is to provide portal service methods as JSON API    
* This makes services methods easily accessible using HTTP request not only from portals javascript, but also from any JSON-speaking client out there

### 8.2.1 JSON Services Exposed by Liferay
* Liferay by default exposes all the methods that are defined inside the various "ServiceImpl" classes as JSON based WS that can accept a JSON request and return back a JSON response
* List of JSON WS that are exposed by Liferay by default: http://localhost:8080/api/jsonws

### 8.2.2 JSON Services Exposed by Our Plugin
* Go to: http://localhost:8080/porlet/api/jsonws

### 8.2.3 Consuming the JSON Service - Legacy Way
* Using JavaScript

### 8.2.4 Consuming the JSON Service - Modern Way

## 8.3 RESTful Web Services

### 8.3.1 What's available by default?
* The moment you make some API's remote with the help of Liferay's Service Builder and expose them as WS, REST API's are also exposed

### 8.3.2 Programmatically invoking a RESTful Service

### 8.3.4 Passing credentials to a RESTful API

### 8.3.5 Processing the Response of RESTful API

## 8.4 The "Beyond" Part

### 8.4.1 Saving the Address information

### 8.4.3 ListType and drop-downs

## 8.5 Calling Portal's JSON Web Service

## 8.6 Service Context and its significance
* The *ServiceContext* class is a parameter class to be used in passing contextual information for a service

### 8.6.1 Service Context Fields

### 8.6.2 Creating and Populating a Service Context
* The main purpose of Service Context is to share data between our front-end class and the back-end API
* There are two different ways a ServiceContext object can be made available inside a Portlet cass or controller class:
    * Pure Instantiation 
    * Getting from Factory

### 8.6.3 Accessing Service Context data

### 8.6.4 A Simple usage of Service Context - UUID
* UUID: Universal Unique Identifier
* If the uuid value is true, the the service will generate a UUID column for the service. This column will automatically be populated with a UUID. Developers will also be able to find and remove based on that UUID. The default value is false

## Summary
* Remove service API, JSON Web Service API, RESTful Web Service API