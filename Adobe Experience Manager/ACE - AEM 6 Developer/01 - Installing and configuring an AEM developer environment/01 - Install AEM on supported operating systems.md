# Getting The Software
* Customers with a valid maintenance and support contract: http://licensing.adobe.com/
* Business partners: spphelp@adobe.com

* AEM software package available in 2 forms:
	* cq-quickstart-6.0.0.jar - standalone executable jar file that includes everything needed to get up and running
	* cq-quickstart-6.0.0.war - a war file for deployment in a third-party application server
* In addition, you will also need a license code or **license.properties** file

# Default Local Install
1. Create an install directory
	* On unix machine: /opt/aem
	* On Windows: C:\Program Files\aem
2. Place the **jar** and **license** files in this directory
```
<aem-install>/
	cq-quickstart-6.0.0.jar
	license.properties
```
3. Star up the instance in a GUI environment, double click the **cq-quickstart-6.0.0.jar** file
4. Alternative, launch AEM from command line
	* For 32-bit Java VM
	``` 
	java -Xmx1024M -jar cq-quickstart-6.0.0.jar
	```
	* For 64-bit Java VM
	```
	java -XX:MaxPermSize=256m -Xmx1024m -jar cq-quickstart-6.0.0.jar
	```
5. The above steps results in
	* an **AEM author** instance
	* running on **localhost**
	* at port 4502
	* author instance will be automatically configured to connect to a **publish instance** on **localhost:4503**
