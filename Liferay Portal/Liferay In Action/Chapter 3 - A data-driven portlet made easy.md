# Chapter 3 - A data-driven portlet make easy
* Designing a portlet for database interaction
* Liferay's Service Builder code generator
* Architecting applications using DAOs and DTOs
* Defining relationships using Service Builder

## 3.1 Introducing Inkwell: a case study

### 3.1.1 Company profile: Inkwell

### 3.1.2 What Inkwell needs in a web site

### 3.1.3 Inkwell's high-level portal

### 3.1.4 Inkwell portal phase 1 requirements
* Internet-facing web site
* Intranet site
* Extranet for partners

### Inkwell Internet

### Inkwell Intranet

### Inkwell Extranet

## 3.2 Designing the Product Registration portlet

### 3.2.1 A blueprint of the portlet

### 3.2.2 Designing the database tables

### 3.2.3 Defining portlet modes and generating the project
* ./create.sh product-registration "Product Registration"

## 3.3 Generating DB code with Service Builder

### 3.3.1 Filling a definite need

### 3.3.2 Creating the service.xml file

### Global Information
* Define the Java package into which Service Builder generates the code
* Prefix name with a namespace

### Defining an entity
* Using **entity** tag

### Defining columns
* Using *column* tag
* column name, type

### Defining finder methods
* Methods that retrieve objects from the database using the parameters you specify in the finder

### 3.3.3 Running Service Builder
* $ ant build-service

### 3.4 Creating a buffer to the persistence layer
* It's a good practice to separate the various layers of the application: UI, model, persistence => *separation of concerns*

### 3.4.1 Why layering is important
* Loose coupling
* More maintainable code

## 3.4.2 Using two layers for persistence
* DAO (Data Access Objects)
* DTO (Data Transfer Objects)

### 3.4.2 Implementing the DTO layer
* Implements PRProductLocalServiceImpl

### Adding a product
* Create a new object using Persistence layer
* Update new object with attribute of the passing object
* Because Liferay is database-agnostic, by default it doesn't use any database-specific means of generating primary keys for databases it manages. Some databases don't support auto-incrementing primary keys. To account for this, Liferay provides its own utility for generating primary keys when you need to generate database-agnostic code

### Deleting products

### Querying the Database

## 3.5 Service Builder in action

### 3.5.1 Defining table relationships
* Service Builder classes can be shared

### 3.5.2 Sharing services
* Problem: several plugins need access to the same services ?
* Put all the plugins in the same .war file
* Service Builder makes your services available in a convenient .jar file that is generated and placed in the WEB-INF/lib folder of your project
 
### 3.5.3 Adding registered users and their products

## 3.6 Summary
* Service Builder makes it easy to generate an entire persistence layer of an application
* Using well-known design patterns such as **DAO** and **DTO**
* Service Builder has no problem with table relationships or with sharing services
