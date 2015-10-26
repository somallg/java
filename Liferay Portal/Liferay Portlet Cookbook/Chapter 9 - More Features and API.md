# Chapter 9 - More Features and API's
* This Chapter Covers:
    * Portlet Filters
    * Implementing Friendly URL
    * Encrypting & Decrypting Portlet Data
    * Enabling Logger at Portlet Level
    * Portlet Internationalization (I18N)
    * Portlet and WCM Marriage
    * Making Portlet appear in Control Panel
    * Running Backend Jobs through Quartz
    * Firing Emails from Portlet
    * Getting Direct Access to Database

## 9.1 Portlet Filters
* Portlet Filter intercepts and processes a *PortletRequest* and *PortletResponse*
* A Portlet has four types of request handling methods
* *javax.portlet.filter.ActionFilter*: for processAction method
* *javax.portlet.filter.EventFilter*: processEvent method
* *javax.portlet.filter.RenderFilter*: render method
* *javax.portlet.filter.ResourceFilter*: serveResource method
* Each filter interface extends *javax.portlet.filter.PortletFilter*
* One filter can be mapped to any number of portlet with the help of *filter-mapping*

## 9.2 Implementing Friendly URL
* Create a new file **routes.xml** inside **WEB-INF/src/META-INF**. This file will contain the definition for various friendly URLs
* Each route will have details of one particular friendly URL that maps a pattern with the actual URL
* While specifying a route you can mention different types of parameters depending on how we want to customize URL:
    * Ignored: a parameter that should be ignored and not included in generated URLs
    * Implicit: a parameter that is not present in the route pattern
    * Overridden: a parameter that should be set to a certain value when a URL is recognized
    * Generated: the pattern of a parameter that will be generated from other parameters when a URL is recognized

### 9.2.1 "portlet.xml" verses "liferay.portlet.xml"
* Any feature that is part of the original JSR-286 (Portlet 2.0) spec goes into "**portlet.xml**"
* Any additional feature that Liferay introduced go to "**liferay-portlet.xml**"

## 9.3 Encrypting & Decrypting Portlet Data
* Liferay provides encrypt and decrypt API

### 9.3.1 Encrypting the Data
* Using Encryptor.encrypt
* Encrypting is based on two settings that are inside **portal.properties** and the same can be over-ridden via **portal-ext.properties**:
    * company.encryption.algorithm
    * company.encryption.key.size
* Getting the company from companyId
* Get keyObject from company
* Encrypt data using Encryptor.encrypt(keyObject, data);

### Decrypting the Data
* Encryptor.decrypt

### 9.3.3 Modifying at the Model Level - Audited Model

### 9.3.4 toString() and toXMLString() methods
* Any generated model has two interesting methods for quick debugging purposes: *toString()* and *toXMLString()*

## 9.4 Enabling Logger at Portlet Level
* SOP has got some serious problems:
    * SOP calls are synchronous and consumes CPU cycles for writing the output to Standard out
* Log4j has many advantages over SOP:
    * Flexibility: it provides different levels for logging
    * Configurability: we can switch on/off all the logging statements
    * Maintainability
    * Granularity: every single class can have a different logger and controlled accordingly
    * Utility

### 9.4.1 Integrating with Log4j Logger
* Create a Logger using: LogFactoryUtil.getLog()    
* log.debug
* log.info
* log.warn
* log.error
* log.fatal

### 9.4.2 Controlling Logging Levels
* Liferay has a very powerful interface for controlling the log levels of the various components that are deployed into the AS
* Control Panel => Server => Server Administration => Log Levels
* Config Log4j to save to persistence data

## 9.5 Portlet Internationalization (I18N)
* Liferay has many tools built-in that help to internationalize an portal and publish the contents in any language

### 9.5.1 Illustration of Internationalization

### 9.5.2 Internationalizing our Library Portlet

## 9.6 Portlet and WCM Marriage
* WCM: Web Content Management, that will help the portal users to create and publish the portal contents with the help of various tools 

### 9.6.1 Embedding Web Content in a Portlet

### 9.6.2 Embedding Portlet inside Web Content

### 9.6.3 Accessing Service Layer API from Web Content

### 9.6.4 Accessing Theme Resources From Our Portlet

## 9.7 Making Our Portlet appear in Control Panel

### 9.7.1 More about Control Panel

### 9.7.2 Making our Library unique for every Department

### 9.7.2 Introducing "groupId" for LMSBook

### 9.7.4 Liferay and Multitenancy
* Multitenancy refers to a principle in software architecture where a single instance of the software runs on a servers, serving multiple client organizations (tenants)

### 9.7.5 Check wit Existing Applications

## 9.8 Running Backend Jobs through Quartz
* Quartz scheduler
* The scheduler can be triggered based on either specific intervals or on CRON expressions

### 9.8.1 Implementing the actual Job
* Create a new class, make it implement to *com.liferay.portal.kernel.messaging.MessageListener*
* In *liferay-portal.xml*, add scheduler-entry tag after *icon* tag
* the trigger tag can be of two types: *cron* or *simple*
* There are many entries in **portal.properties** that you can override to change the default behavior of the Quartz scheduler

### 9.8.2 Contents of "message" object
* Iterate through message.getValues()
 
### 9.8.3 Winning of the Portlet Contest
* An Offline Job can either implement the interface as we did above or extend another abstract class *BaseMessageListener* inside the same package as the interface, *com.liferay.portal.kernel.messaging*

## 9.9 Firing Emails from Portlet
* Using MailServiceUtil.sendEmail

## 9.10 Getting Direct Access to Database
* Liferay use C3P0 for connecting pooling

### 9.10.1 Obtaining a Connection from Pool
* DataAccess.getConnection() 

### 9.10.2 Max Database Connections
* Set jdbc.default.maxPoolSize in **portal.properties**
