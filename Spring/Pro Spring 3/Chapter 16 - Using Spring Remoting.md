# Chapter 16 - Using Spring Remoting

# 2. Using JMS in Spring
* Provides asynchronous and loosely coupled way for application integration

## 2.1 Setting Up ActiveMQ
* activemq start
* localhost:8161/admin

## 2.2 Implementing a JMS Listener in Spring
* Implement MessageListener
* Override onMessage method
* Create bean ActiveMQConnectionFactory
    * property brokerURL: tcp://locahost:61616
* Create bean messageListener
* Add jms namespace
* jms-listener-container
* jms-listener
    * destination: queue/topic name
    * ref: messageListener

## 2.3 Sending JMS Messages in Spring
* Using JmsTemplate
* Create ActiveMQSessionFactory
* Create JmsTemplate
    * connectionFactory
    * defaultDestinationName

# 3. Using RESTful-WS in Spring
* Easy to understand
* Lightweight
* Firewall friendly

## 3.1 Introducing RESTful Web Services
* REpresentational State Transfer, which is an architectural style
* Defines a set of architectural constraints that together describe a *uniform interface* for accessing resources
* Main concepts of *uniform interface*:
    * identification of resources - URI
    * manipulation of resources through representations - HTTP Method

## 3.2 Securing RESTful-WS with Spring Security
* Using filter : DelegatingFilterProxy
* Config filter-mapping
* Sping-security.xml:
    * http pattern
    * intercept url
    * authentication-manager

## 3.3 Using JSR-303 with RESTful Web Services
