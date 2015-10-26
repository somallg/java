# Chapter 10 - Concurrency

## Item 66: Synchronize access to share mutable data
* **Synchronization is required for reliable communication between threads as well as for mutual exclusion**
* **Do not use Thread.stop**
* **Synchronization has no effect unless both read and write operations are synchronized**
* **Confine mutable data to a single thread**

* In summary
    * **When multiple threads share mutable data, each thread that reads or writes the dat must perform synchronization**
    * Without synchronization, there is no guarantee that one thread's changes will be visible to another
    * The penalties for failing to synchronize shared mutable data are liveness and safety failures. These failures are among the most difficult to debug
    * They can be intermittent and timing-dependent, and program behavior can very radically from one VM to another
    * If you need only inter-thread communication, and not mutual exclusion, the volatile modifier is acceptable form of synchronization, but it can be tricky to use correctly
    
## Item 67: Avoid excessive synchronization
* **To avoid liveness and safety failures, never cede control to the client within a synchronized method or block** (i.e inside a synchronized region, do not invoke a method that is designed to be overridden, or one provided by a client in the form of a function object)
* **As a rule, you should do as little work as possible inside synchronized regions**

* In summary
    * To avoid deadlock and data corruption, never call an alien method from within a synchronized region
    * More generally, try to limit the amount of work that you do from within synchronized regions
    * When you are designing a mutable class, think about whether it should do its own synchronization
    * In modern multicore era, it is more important than ever not to synchronize excessively
    * Synchronize your class internally only if there is a good reason to do so, and document your decision clearly
    
## Item 68: Prefer excecutors and tasks to threads
* Java Concurrency in Practice

## Item 69: Prefer concurrency utilities to wait and notify
* **Given the difficulty of using wait and notify correctly, you should use the higher-level concurrency utilities instead**
* **It is impossible to exclude concurrent activity from a concurrent collection; locking it will have no effect** but to slow the program
* **Use ConcurrentHashMap in preference to Collections.synchronizedMap or HashTable**
* **For interval timing, always use System.nanoTime in preference to System.currentTimeMillis**
* **Always use the wait loop idiom to invoke the wait method; never invoke it outside of a loop**

* In summary
    * Using wait and notify directly is like programming in "concurrency assembly language"
    * **There is seldom, if ever, a reason to use wait and notify in new code**
    * Make sure that code always invokes wait from within a while loop using the standard idiom
    * The notifyAll method should generally be used in preference to notify
    
## Item 70: Document thread safety
* **The presence of the synchronized modifier in a method declaration is an implementation detail, not a part of its exported API**
* **To enable safe concurrent use, a class must clearly document what level of thread safety it supports**
    * **immutable**
    * **unconditionally thread-safe**
    * **conditionally thread-safe**
    * **not thread-safe**
    * **thread-hostile**
    
* To summarize
    * Every class should clearly document its thread safety properties with a carefully worded prose description or a thread safety annotation
    * The synchronized modifier plays no part in this documentation
    * Conditionally thread-safe classes must document which method invocation sequences require external synchronization, and which lock to acquire when executing these sequences
    * If you write an unconditionally thread-safe class, consider using a private lock object in place of synchronized methods
    * This protect you against synchronization interference by clients and subclasses and gives you the flexibility to adopt a more sophisticated approach to concurrency control in a later release
    
## Item 71: Use lazy initialization judiciously
* **Under most circumstances, normal initialization is preferable to laze initialization**
* **If you use lazy initialization to break an initialization circularity, use a synchronized accessor**
* **If you need to use lazy initialization for performance on a static field, use the lazy initialization holder class idiom**
* **If you need to use lazy initialization for performance on an instance field, use the double-check idiom**

* In summary
    * You should initialize most fields normally, not lazily
    * If you must initialize a field lazily in order to archive your performance goals, or to break a harmful initialization circularity, then use the appropriate lazy initialization technique
    * For instance fields, it is the double-check idiom; for static fields, the lazy initialization holder class idiom
    * For instance fields that can tolerate repeated initialization, you may consider the single-check idiom
   
## Item 72: Don't depend on the thread scheduler
* **Any program that relies on the thread scheduler for correctness or performance is likely to be non-portable**
* **Threads should not run if they aren't doing useful work**
* **Resist the temptation to "fix" the program by putting in calls to Thread.yield**
* **Thread.yield has no testable semantics**
* **Thread priorities are among the least portable feature of Java Platform**

* In summary
    * Do not depend on the thread scheduler for the correctness of your program
    * The resulting program will neither be robust nor portable
    * Do not rely on Thread.yield or thread priorities
    * Thread priorities may be used sparingly to improve the quality of service of an already work program, but they should never be used to "fix" a program that barely works

## Item 73: Avoid Thread groups
* **Thread groups are obsolete

* To summarize
    * Thread groups don't provide much in the way of functionality, and much of their functionality they do provide is flawed
    * Thread groups are best viewed as  an unsuccessful experiment, and you should simply ignore their existence
    * If you design a class that deal with logical groups of thread, you should probably use thread pool executors
