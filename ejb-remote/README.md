# ejb-remote: Using EJB with Spring support

# What is it?
* This example demonstrates Spring support for Java EE EJB using declarative bean lookup instead of the classic programmatic JNDI lookup

# Build and Deploy
* mvn clean install jboss-as:deploy -DskipTests=true

# Run Programmatic JNDI Lookup Client
* Run `StatefulEJBClient` and `StatelessEJBClient`

# Run Test
* mvn test