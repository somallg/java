# Chapter 01. Introduction
* Writing correct programs is hard, writing correct concurrent programs is harder

## 1.1. A (Very) Brief History of Concurrency
* The sequential programming model is intuitive and natural, as it models the way humans work: do one thing at a time
* Finding the right balance of sequentiality and asynchrony is often a characteristic of efficient people - and the same is true of programs
* Threads are sometimes called lightweight processes, and most modern OS treat threads, not processes, as the basic units of scheduling

## 1.2. Benefits of Threads
* When used properly, threads can reduce development and maintenance costs and improve the performance of complex applications
* Threads are useful in GUI applications for improving the responsiveness of the UI, and in server applications for improving resource utilization and throughput

### 1.2.1. Exploiting Multiple Processors
* Using multiple threads can also help achieve better throughput on single-processor systems

### 1.2.2. Simplicity of Modeling
* Managing multiple priorities and deadlines and switching from task to task usually carries some overhead
* The same is true for software: a program that process on one type of task sequentially is simpler to write, less error-prone, and easier to test than one managing multiple different types of task at once

### 1.2.3. Simplified Handling of Asynchronous Events
* If each request has it own thread, then blocking does not affect the process of other requests

## 1.2.4. More Responsive User Interfaces

## 1.3. Risks of Threads
* Mainstream developers must be aware of thread-safety issues

### 1.3.1. Safety Hazards
* In the absence of sufficient synchronization, the ordering of operations in multiple threads is unpredictable and sometimes surprising
* For a multithreaded program's behavior to be predictable, access to shared variables must be properly coordinated so that threads do not interfere with one another

### 1.3.2. Liveness Hazards
* Safety cannot be compromised
* Safety means "nothing bad ever happens"
* Liveness concerns the complementary goal that "something good eventually happens" i.e "make progress"
* A liveness failure occurs when an activity gets into a state such that it is permanently unable to make forward progress
* Bugs that cause liveness failure can be elusive because they depend on the relative timing of events in different threads

### 1.3.3. Performance Hazards
* Threads carry some degree of runtime overhead
* Context switches - when the scheduler suspends the active thread temporarily so another thread can run - are more frequent in applications with many threads, and have significant costs: saving and restoring execution context, loss of locality, and CPU time spent scheduling threads instead of running them
* When threads share data, they must use synchronization mechanisms that can inhibit compiler optimizations, flush or invalidate memory caches, and create synchronization traffic on the shared memory bus

## 1.4. Threads are Everywhere
* Frameworks introduce concurrency into applications by calling application components from framework threads. Components invariably access application state, thus requiring all code paths accessing that state be thread-safe
