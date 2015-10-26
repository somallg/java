# Chapter 19 - Spring Testing
* Testing is important way to ensure that the completed application performs as expected and fulfills all kinds of requirement (architectural, security, user requirements, and so on)
* *Enterprise testing framework*
* *Logic unit test*
* *Integration unit test*
* *Frontend unit test*

# 1. Introduction an Enterprise Testing Framework
* Testing activities in the entire application's life cycle
* Logic unit test - takes a single object and tests it by itself, without worrying about the role it plays in the surrounding system. JUnit, Mockito, EasyMock
* Integration unit test - testing the interaction between components in a *near real* environment. H2Databse, DBUnit, Jetty
* Frontend unit test - focus on testing user interface. Ensure each user interface reacts to users' action and produces the output to the users as expected. Selenium
* Continuous build and code quality test - build on regular basis to ensure that the code quality complies with the standard. Test coverage should be as high as possible to ensure that all developed lines of codes are tested. PMD, Checkstyle, Code Coverage, Gradle, Maven, Sonar, Jenkins
* System integration test - verifies the accuracy of the communication among all programs in the new system and between the new system and all of the external interfaces
* Functional test - use cases and business rules are tested by functional test. Verify the input and outputs
* System quality test - ensure that the developed application meets those non-functional requirements
* User acceptance test - simulates the actual working conditions of the new system

## 1.1 Implementing Logic Unit Test
* Dependencies:
    * junit
    * mockito

## 1.2 Implement the Infrastructure Classes
* For a group of common tests (test cases for controller classes, service layer testing, it's always a best practice to develop a common abstract parent class that has the mandatory testing infrastructure set up correctly

* @Configuration - indicate to Spring that it's an *ApplicationContext* configuration class
* @Profile - indicate the profile that the beans configured in this class belong to

* Create a abstract base class for class test cases
    * @RunWith(SpringJUnit4ClassRunner.class) - Spring's JUnit support class for running test cases with Spring's ApplicationContext
    * @ContextConfiguration - indicates to Spring JUnit runner on the configuration file to be loaded
    * @ActiveProfiles

# 2. Implementing an Integration Unit Test

# 3. Implementing a Frontend Unit Test
* Dependencies:
    * selenium