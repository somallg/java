# Chapter 1 - Introduction to Couchbase

## Architecture and Structure
* Couchbase Server is cluster-based, document-based database
* Couchbase Server is a persistent database, uses an integrated RAM caching layer => support fast CRUD
* Couchbase is built on three core principles:
    * *Simple*: easy to use, easy to install and setup. Compatible with memcached. Do not have to define data structure before storing => no complicated queries
    * *Fast*: use caching, retain as much of actively used data in memory
    * *Elastic*: easy to expand

## Nodes and Clusters
* Couchbase Server or node: a single instance of Couchbase Server
* Cluster: a collection of one or more instances of Couchbase Server

## Buckets and vBuckets
* Buckets: a logical holder of information
* Buckets are:
    * *Named*
    * *Shared*
    * *Optionally password controlled*
    * *Independently managed and monitored*
* Buckets content => divided => vBuckets
* Hash document ID to a vBuckets => use vBuckets map to determine the node

## Get a Server

## Get a Client Library:
> 
<dependencies>

    <dependency>
      <groupId>com.couchbase.client</groupId>
      <artifactId>couchbase-client</artifactId>
      <version>1.4.2</version>
    </dependency>
    
</dependencies>

## Management
* Using the Couchbase Web Console: 
    * http://localhost:8091
* Couchbase CLI:
    * couchbase-cli
    * List servers in a clusters: $ couchbase-cli server-list -c localhost:8091
    * Retrieve server information: $ couchbase-cli server-info -c localhost:8091
* REST API:
    * Find out the clusters available: http://localhost:8091/pools

## Hello Couchbase
* See code

## CRUD
Operation| Example           | Sample Command
---------|-------------------|----------------
Create   | store(docId, doc) | add(), set()
Read     | get()             | get(docId)
Update   | update(docId, doc)| replace()
Delete   | delete(docId)     | delete()
  
## Hadoop Connectors
* http://www.couchbase.com/couchbase-server/connectors/hadoop
* Download zip file
* ./install.sh path_to_sqoop_home
  
## Pros and Cons
Pros | Cons
-----|------
Simple| Schema-less => No relationship
Fast| Use more memory
Elastic| Cant do CRUD over REST API
       | Can only store String => Need to encode/decode => Need more CPU









