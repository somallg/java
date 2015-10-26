# Chapter 15. Atomic Variables and Nonblocking Synchronization
* Atomic variables offer the same memory semantics as volatile variables, but with additional support for atomic updates making them ideal for counters, sequence generators, and statistics gathering while offering better scalability than lock-based alternatives

## 15.1. Disadvantages of Locking
* For lock-based classes with fine-grained operations, the ratio of scheduling overhead to useful work can be quite high when the lock is frequently contented
* Volatile variables are a lighter-weight synchronization mechanism than locking because they do not involve context switches or thread scheduling
* Any threads waiting for the lock can never make progress

## 15.2. Hardware Support for Concurrency

### 15.2.1. Compare and Swap

### 15.2.2. A Nonblocking Counter

### 15.2.3. CAS Support in the JVM

## 15.3. Atomic Variable Classes
* Atomic variables are finer-grained and lighter-weight than locks, and are critical for implementing high-performance concurrent code on multiprocessor systems
* The atomic variable classes provide a generalization of volatile to support atomic conditional read-modify-write operations

### 15.3.1. Atomics as "Better Volatiles"

### 15.3.2. Performance Comparison: Locks Versus Atomic Variables

## 15.4. Nonblocking Algorithms
* An algorithm is called nonblocking if failure or suspension of any thread cannot cause failure or suspension of another thread

### 15.4.1. A Nonblocking Stack
* The key to creating nonblocking algorithms is figuring out how to limit the scope of atomic changes to a single variable while maintaining data consistency

### 15.4.2. A Nonblocking Linked List

## Summary
* Nonblocking algorithms maintain thread safety by using low-level concurrency primitives such as compare-and-swap instead of locks
* These low-level primitives are exposed through the atomic variable classes, which can also be used as "better volatile variables" providing atomic update operations for integers and object references
* Nonblocking algorithms are difficult to design and implement, but can offer better scalability under typical conditions and greater resistance to liveness failures
* Many of the advances in concurrent performance from one JVM version to the next come from the use of nonblocking algorithms, both within the JVM and in the platform libraries