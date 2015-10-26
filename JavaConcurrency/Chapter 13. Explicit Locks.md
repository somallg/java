# Chapter 13. Explicit Locks

## 13.1. Lock and ReentrantLock
* The *Lock* interface defines a number of abstract locking operations
* Unlike intrinsic locking, *Lock* offers a choice of unconditional, polled, time, and interruptible lock acquisition, and all lock and unlock operations are explicit
* Intrinsic locking works fine in most situations but has some functional limitations, it is not possible to interrupt a thread waiting to acquire a lock, or to attempt to acquire a lock without being willing to wait for it forever

### 13.1.1. Polled and Timed Lock Acquisition
* The timed and polled lock-acquisition modes provided by *TryLock* allow more sophisticated error recovery than unconditional acquisition
* With intrinsic locks, a deadlock is fatal, the only way to recover is to restart the application
* Timed and polled locking offer another option: probabalistic deadlock avoidance

### 13.1.2. Interruptible Lock Acquisition

### 13.1.1. Non-block-structured Locking
* With intrinsic locks, acquire-release pairs are block-structured a lock is always released in the same basic block in which it was acquired, regardless of how control exits the block
* Automatic lock release simplifies analysis and prevents potential coding errors, but sometimes a more flexible locking discipline is needed

## 13.2. Performance Considerations
* For synchronization primitives, contented performance is the key to scalability: if more resources are expended on lock management and scheduling, fewer are available for the application
* A better lock implementation makes fewer system calls, forces fewer context switches, and initiates less memory-synchronization traffic on the shared memory bus, operations that are time-consuming and divert computing resources from the program
* Performance is a moving target; yesterday's benchmark showing that X is faster than Y may already be out of date today

## 13.3. Fairness
* Threads acquire a fair lock in the order in which they requested it, whereas a nonfair lock permits barging: threads requesting a lock can jump ahead of the queue of waiting threads of the lock happens to be available when it is requested

## 13.4. Choosing Between Synchronized and ReentrantLock
* Save *ReentrantLock* for situations in which you need something *ReentrantLock* provides that intrinsic locking doesn't
* *ReentrantLock* is an advanced tool for situations where intrinsic locking is not practical. Use it if you need its advanced features: timed, polled, or interruptible lock acquisition, fair queueing, or non-block-structured locking. Otherwise, prefer *synchronized*
* Future performance improvements are likely to favor *synchronized* over *ReentrantLock*. Because *synchronized* is built into the JVM, it can perform optimizations such as lock elision for thread-confined lock objects and lock coarsening to eliminate synchronization with intrinsic locks

## 13.5. Read-write Locks
* *ReentrantLock* implements a standard mutual-exclusion lock: at most one thread at a time can hold a lock
* Mutual exclusion is a conservative locking strategy that prevents writer/writer and writer/reader overlap, but also prevents reader/reader overlap
* Read-write lock allow: a resource can be accessed by multiple readers or a single writer at a time, but not both

## Summary
* Explicit *Locks* offer an extended feature set compared to intrinsic locking, including greater flexibility in dealing with lock unavailability and greater control over queuing behavior
* But *ReentrantLock* is not a blanket substitute for *synchronized*, use it only when you need features that *synchronized* lacks
* Read-write locks allow multiple readers to access a guarded object concurrently, offering the potential for improved scalability when accessing read-mostly data structures