# Chapter 05. Building Blocks

## 5.1. Synchronized Collections
* The synchronized collection classes include *Vector* and *Hashtable*, the synchronized wrapper classes created by the *Collections.synchronizedXXX* factory methods

### 5.1.1. Problems with Synchronized Collections
* The problem of unreliable iteration can again be addressed by client-side locking, at some additional cost to scalability

### 5.1.2. Iterators and ConcurrentModificationException
* Evn in the absence of starvation or deadlock risk, locking collections for significant periods of time hurts application scalability
* An alternative to locking the collection during iteration is to clone the collection and iterate the copy instead
* Cloning the collection has an obvious performance cost

### 5.1.3. Hidden Iterators
* Just as encapsulating an object's state makes it easier to preserve its invariants, encapsulating its synchronization makes it easier to enforce its synchronization policy

## 5.2. Concurrent Collections
* Replacing synchronized collections with concurrent collections can offer dramatic scalability improvements with little risk

### 5.2.1. ConcurrentHashMap
* *ConcurrentHashMap* is a hash-based *Map* like *HashMap*, but it uses an entirely different locking strategy that offers better concurrency and scalability
* Instead of synchronizing every method on a common lock, it uses finer-grained locking mechanism called lock striping

### 5.2.2. Additional Atomic Map Operations

### 5.2.3. CopyOnWriteArrayList
* Is a concurrent replacement for a synchronized *List*, that offers better concurrency in some common situations and eliminates the need to lock or copy the collection during iteration
* Copy-on-write collections are reasonable to use only when iteration is far more common than modification

### 5.3. Blocking Queues and the Producer-consumer Pattern
* One of the most common producer-consumer designs is a thread pool coupled with a work queue
* Bounded queues are a powerful resource management tool for building reliable applications: they make your program more robust to overload by throttling activities that threaten to produce more work than can be handle

### 5.3.1. Example: Desktop Search

### 5.3.2. Serial Thread Confinement
* Object pools exploit serial thread confinement, "lending" an object to a requesting thread

### 5.3.3. Deques and Work Stealing
* Deques lend themselves to a related pattern called work stealing
* Work stealing is well suited in which consumers are also producers - when performing a unit of work is likely to result in the identification of more work

## 5.4. Blocking and Interruptible Method
* Threads may block, or pause, for several reasons: waiting for I/O completion, waiting to acquire a lock, waiting to wake up from *Thread.sleep*
* Interruption is a cooperative mechanism
* One thread cannot force another to stop what it is doing and do something else

## 5.5. Synchronizers 
* A synchronizer is any object that coordinate the control flow of threads based on its state
* Blocking queues can act as synchronizers; other types include semaphores, barriers, and latches
* All synchronizers share certain structural properties: they encapsulate state that determines whether threads arriving at the synchronizer should be allowed to pass or forced to wait, provide methods to manipulate that state, and provide methods to wait efficiently for the synchronizer to enter the desired state

### 5.5.1. Latches
* A latch is a synchronizer that can delay the progress of threads until it reaches its terminal state
* Latch acts as a gate: until the latch reaches the terminal state the gate is closed and no thread can pass
* Latches can be used to ensure certain activities do not proceed until other one-time activities complete, such as:
    * Ensuring that a computation does not proceed until resources it needs have been initialized
    * Ensuring that service does not start until other services on which it depends have started
    * Waiting until all the parties involved in an activity are ready to proceed
* Latch state consist of a counter initialized to a positive number, representing the number of evens to wait for
* *countDown* method decrements the counter, indicating that an event has occurred
* *await* methods wait for the counter to reach zero, which happens when all the events have occurred
* If the counter is non-zero on entry, *await* blocks until counter reaches zero, the waiting thread is interrupted, or the wait times out

### 5.5.2. FutureTask
* *FutureTask* also acts like a latch (FutureTask implement *Future*, which describes an abstract result-bearing computation)
* *FutureTask* is used by the *Executor* framework to represent asynchronous tasks, and can also be used to represent any potentially lengthy computation that can be started before the results are needed

### 5.5.3. Semaphores
* Counting semaphores are used to control the number of activities that can access a certain resource or perform a given action at the same time
* Counting semaphores can be used to implement resource pools or to impose a bound on a collection

### 5.5.4. Barriers
* Barriers are similar to latches in that they block a group of threads until some event has occurred
* The key difference is that with a barrier, all the threads must come together at the barrier point at the same time in order to proceed
* Latches are for waiting for events, barriers are for waiting for other threads

### 5.6. Building an Efficient, Scalable Result Cache
* Use *FutureTask* to cache result

## Summary of Part I
* It's the mutable state, stupid
    * All concurrency issues boil down to coordinating access to mutable state. The less mutable state, the easier it is to ensure thread safety
* Make fields final unless they need to be mutable
* Immutable objects are automatically thread-safe
    * Immutable objects simplify concurrent programming tremendously. They are simpler and safer, and can be shared freely without locking or defensive copying
* Encapsulation makes it practical to manage the complexity
    * You could write a thread-safe program with all data stored in global variables, but why would you want to? Encapsulating data within objects makes it easier to preserve their invariants; encapsulating synchronization within objects makes it easier to comply with their synchronization policy
* Guard each mutable variable with lock
* Guard all variables in an invariant with the same lock
* Hold locks for the duration of compound actions
* A program that accesses a mutable variable from multiple threads without synchronization is a broken program
* Don't rely on clever reasoning about why you don't need to synchronize
* Include thread safety in the design processor explicitly document that your class it not thread-safe
* Document your synchronization policy
