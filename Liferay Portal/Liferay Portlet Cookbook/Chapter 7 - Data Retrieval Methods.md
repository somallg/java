# Chapter 7 - Data Retrieval Methods
* This Chapter Covers:
    * Order By Clause
    * Finder Tags
    * Dynamic Query
    * Custom SQL Statements
    * Some Real world use-cases
    * Which mechanism is Best?

## 7.1 Order By Clause
* If you want the data returned by the service layer API to be of some pre-defined order, then you just have to define it in "service.xml"

### 7.1.1 API Level support for Sorting
* Liferay service layer API including the finder methods: lmsBookPersistence.findAll(start, end, orderByComparator)

## 7.2 Finder Tags
* A finder tag automatically generates the finder methods in the persistence class that we can make use of in our service implementation classes
* Two **fetchBy** methods
* Three **findAll** methods
* Two **findBy** methods
* Three **findWith** methods - used while creating a dynamic query
* There is only one **findBy** method that returns a single object
* All **fetchBy** methods always return one single object
* It is always recommended to use **fetchBy** when you want to retrieve a single object through your persistence layer

### 7.2.1 Adding New Method to Search
* actionResponse.setRenderParameter is sufficient for redirecting the request to a new JSP page after the action is performed
* Liferay has made all objects of type *java.util.List* as un-modifiable
* Use ListUtil.copy to make a copy of List

### 7.2.2 Pros and Cons of Finder tags
* Pros:
    * For every finder tag this is defined in service.xml Liferay automatically generates the corresponding index and it get executed against the database at the time of deployment
    * For every finder tag, all the corresponding API's are auto-created and are well defined
* Cons:
   * We have to know them in advance at the time of developing
   * Every time a finder is defined, the service layer has to be re-generated and redeploy the Portlet
   * Finder methods do not take wild card characters
   * We cannot perform complex queries on our tables

## 7.3 Dynamic Query   
* The level of complexity allowed by the service generation is not sufficient
* Queries that implement aggregate SQL operations such as max, min, avg, etc
* Return composite objects or tuples rather than the mapped object types
* Access data in a way not originally conceived for whatever reason
* Query optimization, complex data access
* Liferay build wrappers around Hibernate API

### 7.3.1 Scenarios while using DynamicQuery
* Dynamic Query API uses the current thread's class loader
* While using projections in your query you have to use the Liferay's version of the *Projection* class

### 7.3.2 Example of Dynamic Query API usage

## 7.4 Custom SQL Statements
* Open an ORM session (Hibernate)
* Get an SQL statement from XML file with its name
* Transform the normal query to HQL query
* Add the actual entity to be searched
* Replace positional parameters in the query
* Execute query and return results

### 7.4.1 Liferay's use of custom SQL

## 7.5 Some Real world use-cases

### 7.5.1 Expressing Entity relationship through "service.xml"
* ALl the three types of relationships can be seamlessly expressed - *one-to-one*, *one-to-many* and *many-to-many*
* Overriding model class, a Liferay example

### 7.5.2 Modeling Database View into service layer
* How to combine three tables ?
* Use Custom SQL
* Create an API in **LocalServiceImpl** class
* Create an entity
* Using view

### 7.5.3 Service Layer Dummy Entity
* Create an entity in **service.xml** without any columns and re-generate the service layer

### 7.5.4 Connecting to different Data Sources
* By default Liferay connects to the default data source defined in the **portal-ext.properties**
* Make the entries for the new database inside **portal-ext.properties**
* Define a new entity in **service.xml**, mapped to another data-source, the additional three attributes *data-source*, *tx-manager* and *session-factory* are mandatory

### 7.5.5 Splitting a large *service.xml* file
* By making use of *service-builder-import* inside parent *service.xml* we can break a big file into multiple smaller ones
* There can be at most one author element among all the files
* There can also only be one and only one namespace element among all the files

### 7.5.6 Invoking a Stored Procedure via Service Layer
* Using stored procedures or triggers in an Enterprise Application is not a good idea, as they break the fundamental principle of making an application try agnostic of the underlying database
* Create a stored procedure in your database
* Create a new method in ServiceImpl class and calls our stored procedure, session.createSQLQuery("Call GetBooks(:bookTitle)")

### 7.5.7 Generating Exception classes
* With the help of Service Builder, we can auto-generate as many exception classes that we want instead of writing them manually
* By default for every entity defined in the **service.xml** file there is **NoSuchEntityException.java** generated
* If we need more custom exception classes, all we have to do is to define them inside *exceptions* tag of **service.xml**

## 7.6 Which mechanism is Best?
* The performance of the methods, especially custom SQL and Stored Procedures is heavily dependent on the nature of the queries

## Summary
* Expressing Entity relationship through **service.xml**
* Modeling Database View into service layer
* Service Layer Dummy Entity
* Connecting to different Data Sources
* Splitting a large **service.xml** file
* Invoking a Stored Procedure through Service Layer
* Generating exception classes
