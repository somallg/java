# Chapter 5 - Web Services Security

## Overview of Web Services Security
* *Wire-level security*: the security at this level typically provides three services:
    * The client and service need transport-level assurance
    * The data send for one side to the other needs to be encrypted
    * The received message is the same as the sent message
* *User authentication and authorization*: *users-role security*
* *WS-Security*

## Wire-Level Security
* HTTPS (HyperText Transport Protocol over Secure Socket Layer)

## HTTPS Basics
* HTTPS is the most popular among secure version of HTTP
* HTTPS provides three critical security services to counter MITM (Man In The Middle) attack:
    * Peer authentication: *mutual authentication* or *mutual challenge*
    * Confidentiality: encrypt the secret message
    * Integrity: the message should be identical
    
## Symmetric and Asymmetric Encryption/Decryption
* In the symmetric approach, the *same* key - called the *secret key* or the *single key* - is used to encrypt and decrypt
* In the asymmetric approach, the starting point is a *key pair*, which consists of a *private key* and a *public key*

## How HTTPS Provides the Three Security Services
* Integrity is most straightforward, the message sent over HTTPS includes a digest, which the receiver recomputes
* HTTPS handles peer authentication through the exchange of digital certificates
* For authentication and confidentiality, HTTPS relies on digital certificates, which are widely used in public key cryptography precisely because the exchange of secret key is so difficult amount many users

## The HttpsURLConnection Class

## Securing the RabbitCounter Service

## Adding User Authentication
* User authentication, a user presents credentials such as password in order to become an *authenticated subject*
* *Authorization*, is optional and normally occurs only if the first phase succeeds

## HTTP BASIC Authentication

## Container-Managed Security for Web Services

## Deploying a @WebService Under Tomcat

## Securing the @WebService Under Tomcat

## Application-Managed Authentication

## Container-Managed Authentication and Authorization
* Tomcat provides container-managed authentication and authorization
* A realm is a collection of resources, including web pages and web services, with a designated authentication and authorization facility
* Tomcat provides five standard plugins, with Realm in the names, to manage communications between the container and authentication/authorization store:
    * *JDBCRealm*
    * *DataSourceRealm*
    * *JNDIRealm*
    * *MemoryRealm*
    * *JAASRealm*

## Configuring Container-Managed Security Under Tomcat
* Tomcat approach to security also is *declarative* rather than *programmatic*

## Using a Digested Password Instead of a Password

## A Secured @WebServiceProvider

## WS-Security
* WS-Security is a family of specifications designed to augment wire-level security by providing a unified, transport-neutral, end-to-end framework for higher levels of security such as authentication and authorization
* The first layer: WS-Policy, WS-Trust, and WS-Privacy
* The second layer: WS-SecureConversation, WS-Federation, and WS-Authorization
* *WS-Policy*: describes general security capabilities, constraints, and policies
* *WS-Trust*: deals primarily with how security tokens are to be issued, renewed, and validated
* *WS-Privacy*: explains how services can state and enforce privacy policies
* *WS-SecureConversation*: secure web service conversations
* *WS-Federation*: addresses the challenge of managing security identities across different platforms and organizations
* *WS-Authorization*: covers the management of authorizations data such as security tokens and underlying policies

## Securing a @WebService with WS-Security Under Endpoint

## The Prompter and the Verifier
* On the service side, the security processor uses a **Verifier** object to authenticate the request
* On the client side, the security processor uses a **Prompter** object to get the username and password

## The Secured SOAP Envelope

## Summary of the WS-Security Example
* WS-Security encourages a clean separation of security concerns from web service logic

## What's Next?
* Deploy WS in an Java Application Servers
