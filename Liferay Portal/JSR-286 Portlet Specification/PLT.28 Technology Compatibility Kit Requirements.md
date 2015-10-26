# PLT.28 Technology Compatibility Kit Requirements
* This chapter defines a set of requirements a Portlet container implementation must meet in order to run the Portlet Technology Compatibility Kit (TCK)
* These requirement are only needed for the purpose of determining whether a Portlet container implementation complies with the Portlet Spec or not

## PLT.28.1 TCK Test Components
* Based on the Portlet Specification and Portlet API, a set of testable assertions have been extracted and identified
* Each Portlet TCK test case has two components:
    * Test Portlet application
    * Test client
* Portlet TCK assumes that the test Portlet applications are deployed in the Portlet container before the test run is executed
* The test clients looks for expected and unexpected sub string in the HTTP response to decide whether a test has failed or passed
* The test client reports the result of the test client to the Java Test Harness

## PLT.28.2 TCK Requirements
* In TCK, every test is written as a set of one or more Portlets
* A test client is written for each test, the test client must interact with a Portal page containing the Portlets that are part of the test
* To accomplish this, TCK needs to obtain the initial URL for the Portal page of each test case

### PLT.28.2.1 Declarative configuration of Portal page for a TCK test
* TCK publishes an XML file containing the Portlets for each test case