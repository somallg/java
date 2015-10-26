# Chapter 16. The Java Memory Model

## 16.1. What is a Memory Model, and Why would I Want One?
* In a multiple thread environment, the illusion of sequentiality cannot be maintained without significant performance cost
* It is only when multiple threads share data that it is necessary to coordinate their activities, and the JVM relies on the program to identify when this is happening by using synchronization 
* The JMM (Java Memory Model) specifies the minimal guarantees the JVM must make about when writes to variables become visible to other threads

### 16.1.1. Platform Memory Models
* An architecture's memory model tells programs what guarantees they can expect from the memory system, and specifies the special instructions required to get the additional memory coordination guarantees required when sharing data
* In order to shield the Java developer from the differences between memory models across architectures, Java provides its own memory model, and the JVM deals with the differences between the JMM and the underlying platform's memory model by inserting memory barriers at the appropriate places
* Java programs need not specify the placement of memory barriers; they need only identify when shared state is being accessed, through the proper use of synchronization

### 16.1.2. Reordering
* Reordering at the memory level can make programs behave unexpectedly
* It is difficult to reason about ordering in the absence of synchronization, it is much easier to ensure that your program uses synchronization appropriately
* Synchronization inhibits the compiler, runtime, and hardware from reordering memory operations in ways that would violate the visibility guaranteed provided by the JMM

### 16.1.3. The Java Memory Model in 500 Words or Less
* The JMM defines a partial ordering called happens-before on all actions within the program
* To guarantee that the thread executing action B can see the results of action A, there must be a happens-before relationship between A and B
* IN the absence of a happens-before ordering between two operations, the JVM is free to reorder them as it pleases
* The rules for happens-before are:
    * Program order rule: each action in a thread happens-before every action in that thread that comes later in the program order
    * Monitor lock rule: an unlock on a monitor lock happens-before every subsequent lock on the same monitor lock
    * Volatile variable rule: a write to a volatile field happens-before every subsequent read of that same field
    * Thread start rule: a call to *Thread.start* on a thread happens-before every action in the started thread 
    * Thread termination rule: any action in a thread happens-before any other thread detects that thread has terminated, either by successfully return from *Thread.join* or by *Thread.isAlive* returning false
    * Interruption rule: a thread calling *interrupt* on another thread happens-before the interrupted thread detects the interrupt
    * Finalizer rule: the end of a constructor for an object happens-before the start of the finalizer for that object
    * Transitivity: if A happens-before B, and B happens-before C, then A happens-before C
    
### 16.1.4. Piggybacking on Synchronization
* Placing an item in a thread-safe collection happens-before another thread retrieves that item from the collection
* Counting down on a *CountDownLatch* happens-before a thread returns from *await* on that latch
* Releasing a permit to a *Semaphore* happens-before acquiring a permit from that same *Semaphore*
* Action taken by the task represented by a *Future* happens-before another thread successfully returns from *Future.get*
* Submitting a *Runnable* or *Callable* to an *Executor* happens-before the task begin execution
* A thread arriving at a *CyclicBarrier* or *Exchanger* happens-before the other threads are released from the same barrier or exchange point. If *CyclicBarrier* uses a barrier action, arriving at the barrier happens-before the barrier action, which in turn happens-before threads are release from the barrier

## 16.2. Publication
* The risks of improper publication are consequences of the absence of a happen-before ordering between publishing a shared objects and accessing it from another thread

### 16.2.1. Unsafe Publication
* Initializing a new object involves writing to variables the new object's fields
* Similarly, publishing a reference involves writing to another variable the reference to the new object
* With the exception of immutable objects, it is not safe to use an object that has been initialized by another thread unless the publication happens-before the consuming thread uses it

### 16.2.2. Safe Publication
* The safe-publication idioms ensure that the published object is visible to other threads because they ensure the publication happens-before the consuming thread loads reference to the published object

### 16.2.4. Safe Initialization Idioms
* Static initializers are run by the JVM at class initialization time, after class loading but before the class is used by any thread
* Because JVM acquires a lock during initialization and this lock is acquired by each thread at least once to ensure that the class has been loaded, memory writes made during static initialization are automatically visible to all threads
* Combined to JVM's lazy class loading to create a lazy initialization technique that does not require synchronization on the common code path

### 16.2.4. Double-checked Locking

## 16.3. Initialization Safety
* Initialization safety guarantees that for properly constructed objects, all threads will see the correct values of final fields that were set by the constructor, regardless of how the object is published
* Further, any variables that can be reached through a final field of a properly constructed object are also guaranteed to be visible to other thread
* Initialization safety makes visibility guarantees only for the values that are reachable through final fields as of the time the constructor finishes
* For values reachable through nonfinal fields, or values that may change after construction, you must use synchronization to ensure visibility

## Summary
* The Java Memory Model specifies when the actions of one thread on memory are guaranteed to be visible to another
* The specifics involve ensuring that operations are ordered by a partial ordering called happens-before, which is specified at the level of individual memory and synchronization operations
* In the absence of sufficient synchronization, some very strange things can happen when threads access shared data
