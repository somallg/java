# Chapter 11. Performance and Scalability
* One of the primary reasons to use threads is to improve performance
* While better performance is often desirable and improving performance can be very satisfying, safety always comes first
* First make your program right, then make it fast

## 11.1. Thinking about Performance
* Improve performance means doing more work with fewer resources
* The meaning of *resource* can vary: CPU cycles, memory, network bandwidth, I/O bandwidth, database requests, disk space, or any number of other resources
* A poorly designed concurrent application can perform even worse than a comparable sequential one

### 11.1.1. Performance Versus Scalability
* Measures *how fast* and *how much*
* Scalability describes the ability to improve throughput or capacity when additional computing resources (such as additional CPUs, memory, storage, or I/O bandwidth) are added

### 11.1.2. Evaluating Performance Tradeoffs
* Avoid premature optimization. First make it right, then make it fast if it is not already fast enough
* Measure, don't guess

## 11.2. Amdahl's Law
* All concurrent applications have some sources of serialization; if you think yours does not, look again

### 11.2.1. Example: Serialization Hidden in Frameworks

### 11.2.2. Applying Amdahl's Law Qualitatively
* When evaluating an algorithm, thinking "in the limit" about what would happen with hundreds or thousands of processors can offer

## 11.3. Costs Introduced by Threads
* Scheduling and interthread coordination have performance costs;
the performance benefits of parallelization must outweight the costs introduced by concurrency

### 11.3.1. Context Switching
* Context switch, which requires saving the execution context of the currently running thread and restoring the execution context of the newly scheduled thread
* High kernel usage often indicates heavy scheduling activity

### 11.3.2. Memory Synchronization
* Don't worry excessively about the cost of uncontended synchronization. The basic mechanism is already quite fast, and JVMs can perform additional optimizations that further reduce or eliminate the cost. Instead, focus optimization efforts on areas where lock contention actually occurs

### 11.3.3. Blocking
* Uncontended synchronization can be handled entirely within JVM

## 11.4. Reducing Lock Contention
* Serialization hurts scalability and context switches hurt performance. Contended locking causes both
* The principal threat to scalability in concurrent applications is the exclusive resource lock
* Three ways to reduce lock contention
    * Reduce the duration for which locks are held
    * Reduce the frequency with which locks are requested
    * Replace exclusive locks with coordination mechanism that permit greater concurrency
    
### 11.4.1. Narrowing Lock Scope ("Get in, Get Out")
* Hold locks as briefly as possible
* If the JVM performs lock coarsening, it may undo the splitting of *synchronization* blocks

### 11.4.2. Reducing Lock Granularity
* Have thread asks for it less often
* This can be accomplished by lock splitting and lock striping, which involve using separate locks to guard multiple independent state variables
* If a lock guards more than one independent state variable, you may be able to improve scalability by splitting it into multiple locks 

### 11.4.3. Lock Striping
* Lock splitting can sometimes be extended to partition locking on a variable sized set of independent objects, *ConcurrentHashMap*
* Downsides of lock striping is that locking collection for exclusive access is more difficult and costly

### 11.4.4. Avoiding Hot Fields
* Lock splitting and lock striping can improve scalability because they enable different threads to operate on different data (or different portions of the same data structure) without interfering with each other
* Caching frequently computed values can introduce *hot fields* that limit scalability

### 11.4.5. Alternatives to Exclusive Locks
* Using concurrent collections, read-write locks, immutable objects and atomic variables

### 11.4.6. Monitoring CPU Utilization
* When testing for scalability, the goal is usually to keep the processors fully utilized
* If the CPU utilization is high and there are always runnable threads waiting for a CPU, your application would probably benefit from more processors

### 11.4.7. Just Say No to Object Pooling
* Allocating objects is usually cheaper than synchronization

## 11.5. Example: Comparing Map Performance
* Once contention becomes significant, time per operation is dominated by context switch and scheduling delays, and adding more threads has little effect on throughput

## 11.6. Reducing Context Switch Overhead
* Just as interruptions are disruptive and productivity-reducing to humans, blocking and context switching are disruptive to threads

## Summary
* Because one of the most common reason to use threads is to exploit multiple processors, in discussing the performance of concurrent applications, we are usually more concerned with throughput or scalability than we are with raw service time
* Amdahl's law tells us that the scalability of an application is driven by the proportion of code that must be executed serially
* Since the primary source of serialization in Java program is the exclusive resource lock, scalability can often be improved by spending less time holding locks, either by reducing lock granularity, reducing the duration for which locks are held, or replacing exclusive locks with nonexclusive lock or nonblocking alternatives