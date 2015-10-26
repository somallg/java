# Chapter 12 - Endpoint Design and Architecture

## 12.1 Procedure or Document Style
* Objective - Given a scenario, design Web Service applications using information models that are either procedure-style or document-style

* Procedure-style WS when:
    * Service is to be used within one and same enterprise
    * Avoid the complexity of creating and manipulating XML documents
    * Exchanged data is less complex
    * Payload of a SOAP request need not to be validated
    * A synchronous transport protocol, like HTTP, is used
    * Service is able to produce a results in a shorter time
    * Memory and/or CPU resources are scarce

* Document-style WS when?
    * Service is offered to other, external, enterprises
    * A high level of stability in the service interface is desired
    * External factors require the exchange of documents that can be verified
    * Exchanged data is more complex
    * Service need to be able to handle many different types of documents
    * An asynchronous transport protocol is used
    * Require longer time before being able to produce a result
    * Entire payload of a (SOAP) request must be validated

## 12.2 Service Interaction and Processing Layers
* Objective - Describe the function of the service interaction and processing layers in a Web service

* Separate web service into two layers, a service interaction layer and a processing layer
* Why?
    * Separating responsibilities
    * Concentrate request pre- and post-processing in one single location
    * Avoid exposing (internal) data structure used by the business layer

* **Service Interaction Layer**
* Responsibilities?
    * Present an interface to clients
    * Receive requests from clients
    * Error handling and reporting
    * Pre-process data received in the request
    * Delegating requests to appropriate logic in the processing layer
    * Post-process request result
    * Generate and send responses to clients
    * Isolating the processing layer from technology used to receive requests
    * Logging and auditing of requests to the service
    * If desired, implement caching of responses received from the processing layer

* **Processing Layer**
* Responsibilities?
    * Act as a WS Broker orchestrating access to one or more underlying services
    * Integrate with enterprise information systems and other ws
    * Process client requests
    * Generate data to be sent with the response to the client

## 12.3 Synchronous vs Asynchronous
* Objective - Design a Web service for an asynchronous, document-style process and describe how to refactor a Web service from a synchronous to an asynchronous model

* **Design an Asynchronous Document-Style Web Service**

![Asynchronous Model](images/async-model.png)

* **Obtaining a Result Using Polling**
* What? client periodically invokes a special operation in the web service, supplying the identifier received as a result of the operation
* If the WS has finished processing, it will return a response to the client, otherwise some reply say that no result is available

* **Obtaining a Result Using Callback**
* What? when a result is available, the ws can invoke the client's ws

* **Handling Errors**
* Two categories:
    * Errors occurring in the interaction layer
    * Errors occurring in the processing layer

* **Errors in the Processing Layer**
    * **Temporary Errors**
    * Caused by temporary network problems occurring when trying to contact a database or another service that the processing layer depends on
    * Action?
        * Implement a retry mechanism
        * Implement a failover mechanism
        * Notify the client that a temporary error has occurred

    * **Permanent Errors**
    * Caused by lack of proper credentials to use some resource, invalid data in the request
    * Action?
        * Failure of underlying resources
        * Invalid data in the request

    * **Notifying the Client
    * Informing the client about errors may be done in the same manners as when delivering the result of the request

* **Refactor Synchronous to Asynchronous Web Service**
* *Motivation*
* Main motivation - scalability
* An asynchronous ws retain its reponsiveness when under higher load
* Requests con be queued in service, while the client is able to proceed with other matters, and processed by the service when being able to, thus avoid overload

* *Before and After*

![Before Asynchronous](images/before-async.png)

![After Asynchronous](images/after-async.png)

* *Refactoring Step by Step*
* Change the return type of the WS operation to be factored
    * Callback => void can be used
    * Polling => return type is to be the identifier type
* If use callback, add parameter to the WS operation to be factored that specifies the endpoint to deliver the response to
* Move the code in the ws operation to be factored that delegates the request to the processing layer to the worker
* Implement code in the operation to be factored to put the request in a work queue and associate an identifier with the request
* Implement code in the worker that either calls back to the client and delivers the response or makes the response available for polling

* The clients can also be factored:
    * Change the invocation of the refactored WS so that it accepts a void return value or a request identifier
    * If use callback => add parameter to the invocation of the refactored WS operation specifying where to deliver the response to
    * If callback mechanism is to be used, implement it
    * If polling mechanism is to be used, implement it

* Few choices to implement the work queue and the worker:
    * Using JavaSE *Queue*, *ThreadPoolExecutor* and *Callable* or *Runnable*
    * Using JMS with a message-driven EJB

## 12.4 Web Service Client Impact
* Objective - Describe how the characteristics, such as resource utilization, conversational capabilities, and operational modes, of the various types of WS clients impact the design of a Web service or determine the type of client that might interact with a particular service

* **Resource Utilization**
* Different kinds of WS clients require different amounts of resources and different kind of platforms on which WS clients can run
 * Limitations in the clients will impact the design of the service, example: more fine-grained services to clients with less processing capabilities

* **Conversational Capabilities**
* What? ability of a WS and its clients to maintain a conversation-like interaction requires storing information related to the conversation
* Issues?
    * Does the conversational state need to be persisted?
    * Scalability of a server maintaining state
    * Token passed between client and server to identify a certain conversational state
    * Client developers need to know what the conversational state contains
    * When does a conversational state expire?
    * How to manage state shared between multiple clients?

* **Operational Modes**
* Continuous access
* Intermittent access - occasionally
* Batch access
* Why? some clients operate under poor, or very restricted, network conditions or some client only require to issue occasional requests

* **Web Service Client Types**
* 4 different types of WS clients:
    * JavaEE Clients
    * JavaSE Clients
    * JavaME Clients
    * Non-Java Clients

* **JavaEE Clients**
* What? run inside a JavaEE container, provides a number of services
* Characteristics?
    * Declarative security
    * Transactions
    * Lifecycle management (EJB)
    * Thread management (EJB)
    * Creation and injection of WS proxies
    * Client-side WS deployment information can be configured using deployment descriptors
    * Additional services, such as asynchronous messaging (message driven EJBs)
* Limitations?
    * Multiple WS clients run in the same container, this may affect the size of the conversational state each client is able to maintain. WS must be designed as to be scalable, despite a larger number of clients
    * With multiple clients in the same container => limitations to the amount of data each client is able to retrieve from the WS
    * JavaEE clients are more likely to require continuous access to WS
    * If WS client is an EJB, then all processing of data must be done in one and same thread

* **Java SE Clients**
* What? run as standalone applications in a rather limited environment

* Characteristics?
    * Have to create and maintain proxies that access the WS
    * Have to implements things like transaction management, thread management, lifecycle management
    * Typically have more resources, such as processing power and memory
    * Can provide a rich user interface for viewing and processing of larger sets of data
    * Requires only intermittent access to WS

* Limitations?
    * Clients may maintain a larger amount of state date that may be enclosed with every request to the WS
    * Care must be taken as to ensure data consistency
    * Avoid issues related to maintenance of state and/or service synchronization

* **Java ME Clients**
* What? run in handheld or embedded devices, which puts further limitations on the environment

* Why choose JavaME ?
    * Mobility
    * Remote access
    * Access everywhere

* Characteristics?
    * Less resources
    * Connectivity may be sporadic
    * Network latency may be high

* Limitations?
    * Bandwidth usage must be limited
    * Clients may send requests in batches
    * Clients have very limited processing capabilities

* **Non-Java Clients**
* Maintain interoperability between the clients and the WS

