# Chapter 7 - Beyond the Flame Wars

## A Very Short History of Web Services
* WS evolved from the RPC (Remote Procedure Call) mechanism in DCU (Distributed Computing Environment)

## The Service Contract in DCE/RPC

## XML-RPC

## Standardized SOAP

## SOAP-Based Web Services Versus Distributed Objects

## SOAP and REST in Harmony
* Two different ways to do SOAP-based WS:
    * Use HTTP/HTTPS transport, and let the transport carry as much of the load as possible
    * Use WS-* initiatives, requires the programmer to deal with many APIs that address transport-neutral services
* From the programmers' viewpoint, the SOAP-based approach also has the enormous appeal of a service contract, a WSDL
* The major drawback of RESTful services in general is the lack of a uniform service contract that facilitates coding the client
* An XML Schema is a grammar, not a service contract
* Every RESTful service has its own idiosyncratic response document
* The next big step for the RESTful community is to agree on a format, such as the WADL document, to act as a service contract
