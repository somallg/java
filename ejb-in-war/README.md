# ejb-in-war: EJB beans packaged in a war container

# What is it?
* This example demonstrates the use of EJB (Stateful and Stateless) in a war container so client can access the EJB beans using Servlet instead of using standard JNDI lookup

# Build and Deploy
* mvn clean install jboss-as:deploy -DskipTests=true

# Run Client
* Run `StatefulClient` and `StatelessClient` in `com.somallg.ejbinwar.client` package
