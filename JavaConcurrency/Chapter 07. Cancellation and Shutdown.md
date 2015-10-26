# Chapter 07. Cancellation and Shutdown
* Getting tasks and threads to stop safely, quickly, and reliably is not always easy
* Java does not provide any mechanism for safely forcing a thread to stop what it is doing
* Instead, it provides interruption, a cooperative mechanism that lets one thread ask another to stop what it is doing
* Dealing well with failure, shutdown, and cancellation is one of the characteristics that distinguish a well-behaved application from one that merely works

## 7.1. Task Cancellation
* An activity is cancellable if external code can move it to completion before its normal completion
* One such cooperative mechanism is setting a "cancellation requested" flag that the task checks periodically; if it finds the flag set, the task terminates early
* A task that wants to be cancellable must have a cancellation policy that specifies the "how", "when", and "what" of cancellation

### 7.1.1. Interruption
* There is nothing in the API or language specification that ties interruption to any specific cancellation semantics, but in practice, using interruption fro anything but cancellation is fragile and difficult to sustain in larger applications
* Calling *interrupt* does not necessarily stop the target thread from doing what it is doing; it merely delivers the message that interruption has been requested
* Interruption is usually the most sensible way to implement cancellation

## 7.1.2. Interruption Policies
* Just ask tasks should have a cancellation policy, threads should have an interruption policy
* An interruption policy determines how a thread interprets an interruption request - what it does when one is detected, what units of work are considered atomic with respect to interruption, and how quickly it reacts to interruption
* Task should not assume anything about the interruption policy of its executing thread unless it is explicitly designed to run within a service that has a specific interruption policy
* Because each thread has it own interruption policy, you should not interrupt a thread unless you know what interruption means to that thread

## 7.1.3. Responding to Interruption
* Only code that implements a thread's interruption policy may swallow an interruption requests. General-purpose task and library code should never swallow interruption requests

### 7.1.4. Example: Timed Run

### 7.1.5. Cancellation Via Future
* Cancelling tasks whose result is no longer needed
* When *Future.get* throws *InterruptedException* or *TimeoutException* and you know that the result is no longer needed by the program, cancel the tasks with *Future.cancel*

### 7.1.6. Dealing with Non-interruptible Blocking 
* Many blocking library methods respond to interruption by returning early and throwing *InterruptionException*
* However, not all blocking methods or blocking mechanisms are responsive to interruption

### 7.1.7. Encapsulating Nonstandard Cancellation with newTaskFor
* When a *Callable* is submitted to an *ExecutorService*, submit returns a *Future* that can be used to cancel the task
* The *newTaskFor* hook is a factory method that creates the *Future* representing the task

## 7.2. Stopping a Thread-based Service
* It makes sense to think of a thread as having an owner, and this is usually the class that created the thread
* So a thread pool owns its worker threads, and if those threads need to be interrupted, the thread pool should take care of it
* *ExecutorService* provides the *shutdown* and *shutdownNow* methods; other thread-owning services should provide a similar shutdown mechanism
* Provide lifecycle methods whenever a thread-owning service has a lifetime longer than that of the method that create it

### 7.2.1. Example: A Logging Service

### 7.2.2. ExecutorService Shutdown
* *ExecutorService* offers two way to shut down: graceful shutdown with *shutdown*, and abrupt shutdown with *shutdownNow*

### 7.2.3. Poison Pills
* Another way to convince a producer-consumer service to shut down is with a poison pill: a recognizable object placed on the queue that means "when you get this, stop"

### 7.2.4. Example: A One-shot Execution Service

### 7.2.5. Limitations of shutdownNow
* There is no way to find out which tasks started but did not complete
* No way of knowing the state of the tasks in progress at shutdown time unless the tasks themselves perform some sort of checkpointing

## 7.3. Handling Abnormal Thread Termination
* The leading cause of premature thread death is *RuntimeException*
* You might want to consider catching *RuntimeException* when you are calling unknown, untrusted code through the abstraction such as *Runnable*

### 7.3.1. Uncaught Exception Handlers
* The Thread API also provides the *UncaughtExceptionHandler* facility, which lets you detect when a thread dies due to an uncaught exception
* Two approaches are complementary: taken together, they provide defensive-indepth against thread leakage
* Somewhat confusingly, exceptions thrown from tasks make it to the uncaught exception handler only for tasks submitted with *execute*; for tasks submitted with *submit*, any thrown exception, checked or not, is considered to be part of the task's return status

## 7.4. JVM Shutdown
* The JVM can shutdown in either an orderly or abrupt manner

### 7.4.1. Shutdown Hooks
* Shutdown hooks are unstarted threads that are registered with *Runtime.addShutdownHook*
* Shutdown hooks should be thread-safe: they must use synchronization when accessing shared data and should be careful to avoid deadlock
* Shutdown hooks can be used for service or application clean up, such as deleting temporary files or cleaning up resources that are not automatically clean up by the OS
* Shutdown hooks should not rely on services that can be shutdown by the application or other shutdown hooks
* One way to accomplish this is to use a single shutdown hook for all services, rather than one for each service, and have it call a series of shutdown actions

### 7.4.2. Daemon Threads
* Sometimes you want to create a thread that performs some helper functions but you don't want the existence of this thread to prevent the JVM from shutting down. This is what daemon threads are for
* Threads are divided into two types: normal threads and daemon threads
* Normal threads and daemon thread differ only in what happens when they exit
* Daemon threads are not a good substitute for properly managing the lifecycle of services within an application

### 7.4.3. Finalizers
* After objects are reclaimed by the collector, *finalize* is called so that persistent resources can be released
* Finalizers offer no guarantees on when or even if they run
* They impose a significant performance cost on objects with non-trivial finalizers
* In most cases, the combination of *finally* blocks and explicit *close* methods does a better job of resource management than finalizers
* Avoid finalizers

## Summary
* End-of-lifecycle issues for tasks, threads, services, and application can add complexity to their design and implementation
* Java does not provide a preemptive mechanism for cancelling activities or terminating threads
* Instead, it provides a cooperative interruption mechanism that can be used to facilitate cancellation, but it is up to you to construct protocols for cancellation and use them consistently
* Using *FutureTask* and the *Executor* framework simplifies building cancellable tasks and services

