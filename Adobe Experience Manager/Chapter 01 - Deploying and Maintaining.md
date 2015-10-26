# Deploying and Maintaining

# 1. Basic Concepts
* WHAT IS AEM?
	* Adobe Experience Manager - web based client-server system for building, managing and deploying commercial websites and related services 
* Provides?
	* Web Application Server
	* Web Application Framework - Sling Web Application Framework
	* Content Repository - Java Content Repository (JCR)

* TYPICAL DEPLOYMENT SCENARIOS
* Instance is a copy of AEM running on a server
* *Author* - An AEM instance used to create, update and edit content and to administer the website. Once content is ready to go live, it is replicated to the publish instance
* *Publish* - An AEM instance that serves content to the public
* *Dispatcher* - static web server augmented with AEM dispatcher module

* GETTING THE SOFTWARE
* cq-quickstart-6.0.0.jar - standalone executable *jar* file
* cq-quickstart-6.0.0.war - A *war* file for deployment in a third-party application server

* DEFAULT LOCAL INSTALL
* For 32-bit
	* java -Xmx1024M -jar cq-quickstart-6.0.0.jar
* For 64-bit
	* java -XX:MaxPermSize-256m -Xmx1024M -jar cq-quickstart-6.0.0.jar
	
* Results
	* An *AEM author* instance
	* running on *localhost*
	* at port 4502
* Author instance will be automitically configured to connect to *publish instance* on *localhost:4503*

* AUTHOR AND PUBLISH INSTALLS
* Renaming the *jar* file before lauching:
	* cq-<instance-type>-p<port-number>.jar
	
* UNPACKED INSTALL DIRECTORY
* Unpack itself into the same directory under the new sub-directory called *crx-quickstart*

* START AND STOPPING
* crx-quickstart/bin
	* start
	* stop
	* status
	* quickstart