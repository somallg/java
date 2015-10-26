# Chapter 08 - Spring JDBC Support

## Spring JDBC Infrastructure

* Overview and Used Packages
* org.springframework.jdbc.core 
* org.springframework.jdbc.datasource
* org.springframework.jdbc.object
* org.springframework.jdbc.support
* org.springframework.jdbc.config

## Database Connections and DataSources
* DriverManagerDataSource - simplest implementation of a DataSource, doesn't support database connection pooling
* In real-world applications, you can use Apache Commons *BasicDataSource* or a *DataSource* implemented by a JEE application server

## Embedded Database Support
* Declare the *jdbc* namespace
* Use <jdbc:embedded-database>

## Using DataSources in DAO Classes

## Exception Handling
* Spring provides a default implementation of SQLExceptionTranslator interface, which takes care of translating the generic SQL error codes into Spring JDBC exceptions

## The JdbcTemplate Class
* Execute all types of SQL statements
* You can classify the data definition and data manipulation

## Initializing JdbcTemplate in a DAO Class
* Construct the class by passing in the data source object
* Once configure, the *JdbcTemplate* is thread safe. That means you can choose to initialize a single instance of *JdbcTemplate* in Spring's XML configuration and have it inject into all DAO beans

## Using Named Parameters with NamedParameterJdbcTemplate
* Ensure that parameter is being bound exactly as wanted

## Retrieving Domain Objects with RowMapper<T>

## Retrieving Nested Domain Objects with ResultSetExtractor
* For more complicated object structure

## Sprng Classes That Model JDBC Operations

## Setting Up JDBC DAO Using Annotations

