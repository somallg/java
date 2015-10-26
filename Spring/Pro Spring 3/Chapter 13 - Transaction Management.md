# Chapter 13 - Transaction Management
* Transaction management is a cross-cutting concern and should not be coded within the business logic

# 1 Exploring the Spring Transaction Abstraction Layer
* Local transaction - specific to a single transactional resource
* Global transaction - managed by the container and can span multiple transactional resources

## 1.1 Transaction Types

## 1.2 Implementations of the PlatformTransactionManager
* In Spring, the *PlatformTransactionManager* interface uses the *TransactionDefinition* and *TransactionStatus* interfaces to created and manage transactions

# 2 Analyzing Transaction Properties
* Transactions have four notoriousy known ACID properties:
    * Atomicity - all or nothing, one part of the transaction fails, the entire transaction fails
    * Consistency - any data written to the database must be valid
    * Isolation - concurrent execution of transactions result in a system state that would be obtained if transactions were executed serially
    * Durability - once a transaction has been committed, il will remain so
* It is up to the transactional resources to maintain these aspects of a transaction

* Spring encapsulates all these settigns in a *TransactionDefinition* interface
* *TransactionStatus* interface is used to control the transaction execution, more specially to set the transaction result and to check whether the transaction is completed or whether it is a new transaction

## 2.1 The TransactionDefinition Interface
* Control the properties of a transaction
* Methods:
    * *getTimeout* - the time (in seconds) in which the transaction must complete
    * *isReadOnly*

* *getIsolationLevel()* - which controls what changes to the data other transactions see
    * ISOLATION_DEFAULT
    * ISOLATION_READ_UNCOMMITTED - allow to see data modified by other uncomitted tranactions
    * ISOLATION_READ_COMMITTED - default level in most databases; other transactions are not able to read data that has not been committed by other transactions
    * ISOLATION_REPEATABLE_READ - stricter than ISOLATION_READ_COMMITTED
    * ISLATION_SERIALIZABLE - all transactions are treated as if they were executed one after another

* *getPropagationBehavior()* - specifies what happens to transactional call depending on whether there is an active transaction    
    * PROPAGATION_REQUIRED - support a transaction if one already exists. If there is no transaction, starts a new one
    * PROPAGATION_SUPPORTS - support a transaction if one already exists. If there is no transaction, it executes non-transactional
    * PROPAGATION_MANDATORY - support a transaction if one already exists. Throws an exception if there is no active transaction
    * PROPAGATION_REQUIRED_NEW - always starts a new transaction. If an active transaction already exists, it is suspended
    * PROPAGATION_NOT_SUPPORTED - does not support execution with an active transaction. Always executes non-transactional and suspends any existing transaction
    * PROPAGATION_NEVER - always executes non-transactional even if an active transaction exists. Throws an exception if an active transaction exists
    * PROPAGATION_NESTED - runs in a nested transaction if an active transaction exists

## 2.2 The TransactionStatus Interface
* Allows the transaction manager to control the transaction execution
* Check whether the transaction is a new one or it is a read-only transaction and it can initiate a rollback

# 3 Declarative and Programmatic Transactions with Spring

## 3.1 Using Annotations for Transaction Management
* tx namespace
* tx:annotation-driven
* Create TransactionManager i.e HibernateTransactionManager
* @Transactional
    * propagation
    * isolation
    * timeout
    * readOnly

## 3.2 Using XML Configuration for Transaction Management
* aop namespace
* tx namespace
* Removed tx:annotation-driven
* Create aop:config
* Create <tx:advice>

## 3.3 Using Programmatic Transactions
* TransactionTemplate
* new TransactionCallback
* Override doInTransaction method

## 3.4 Considerations on Transaction Management
* Declarative approach is recommended in all cases, avoid implementing transaction management within your code as far as possible

# 4 Global Transactions with Spring
* Transactions that span multiple backed resources are referred to as *global* (or distributed) transactions
* The main characteristic of a global transactions is the guarantee of atomicity - which means that involved resources are all updated or none is updated

## 4.1 Infrastructure for Implementing the JTA Sample

## 4.2 Implementing Global Transactions with JTA

## 4.2 Considerations on Using JTA Transaction Manager

# 5 Summary
* Local and Global transactions
* Declarative ways of using XML configuration and annotation, as well as programmatic approach
* Local transactions are supported inside/outside of JEE application server
* Global transactions greatly depends on JTA provider
