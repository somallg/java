# Chapter 03 - Create a SOAP based web service implemented by an EJB component

## 3.1 Create a web service starting from a WSDL file using JAX-WS

### 3.1.1 Use *wsimport* tool to generate artifacts and use customization files for wsimports if needed

### 3.1.2 Create an EJB web service implementations using annotations (*@Stateless* or *@Singleton*)

### 3.1.3 Configure deployment descriptors (*ejb-jar.xml*, *webservices.xml*) for transactions, etc.

### 3.1.4 Configure container role based access control via method-permissions in *ejb-jar.xml* or via access control annotations on EJB

### 3.1.5 Configure caller authentication and message protection; either by Servlet Container via *web.xml*, and/or by JAX-WS message processing runtime

### 3.1.6 Configure caller authentication and message protection; either by Servlet Container via web.xml, and/or by JAX-WS message processing runtime

### 3.1.7 Deploy the web service into a Java EE container

## 3.2 Create a web service starting from a Java source using JAX-WS

### 3.2.1 Use *wsgen* tool to generate artifacts in Java EE5 from EJB classes (optional in Java EE 6 - as artifacts are generated at runtime)

### 3.2.2 Configure deployment descriptor (*ejb-jar.xml*, *webservice.xml*) for transactions, etc.

### 3.2.3 Configure container role based access control via method-permissions in *ejb-jar* or via access control annotations on EJB

### 3.2.4 Configure caller authentication and message protection; either by Servlet Container via *web.xml*, and/or by JAX-WS message processing runtime

### 3.2.5 Compile and package the web service into a WAR/EAR file

### 3.2.6 Deploy the web service into a Java EE container