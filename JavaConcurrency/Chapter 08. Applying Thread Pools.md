# Chapter 08. Applying Thread Pools
* This chapter looks at advanced options for configuring and tuning thread pools, describes hazards to watch for when using the task execution framework

## 8.1. Implicit Couplings Between Tasks and Execution Policies
* *Executor* framework offers substantial flexibility in specifying and modifying execution policies, not all tasks are compatible with all execution policies
* Types of tasks that require specific policies include:
    * Dependent tasks. When you submit tasks that depend on other tasks, you implicitly create constrains on the execution policy that must be carefully managed
    * Tasks that exploit thread confinement
    * Response-time sensitive tasks
    * Tasks that use *ThreadLocal*. *ThreadLocal* allows each thread to have it own private "version" of a variable
    * Thread pools work best when tasks are homogeneous and independent
* Some tasks have characteristics that require or preclude a specific execution policy. Tasks that depend on other tasks require that the thread pool be large enough that tasks are never queued or rejected; tasks that exploit thread confinement require sequential execution. Document these requirements so that future maintainers do not undermine safety or liveness by substituting an incompatible execution policy

### 8.1.1. Thread Starvation Deadlock
* In a single-threaded executor, a task that submits another task to the same executor and waits for its result will always deadlock
* The same thing can happen in a larger thread pools if all thread are executing tasks that are blocked waiting for other tasks still on the work queue
* This is called thread starvation deadlock, and can occur whenever a pool task initiates an unbounded blocking wait for some resource or condition that can succeed only through the action of another pool task
* Whenever you submit to an *Executor* tasks that are not independent, be aware of the possibility of thread starvation deadlock, and document any pool sizing or configuration constraints in the code or configuration file where the *Executor* is configured

### 8.1.2. Long-running Tasks
* A thread pool can become clogged with long-running tasks, increasing the service time even for short tasks
* Use timed resource waits instead of unbounded waits
* If the wait times out, you can mark the task as failed and abort it or requeue it for execution later
* If a thread pool is frequently full of blocked task, this may also be a sign that the pool is too small

## 8.2. Sizing Thread Pools
* The ideal size of a thread pool depends on the types of tasks that will be submitted and the characteristics of the deployment system
* Thread pool sizes should rarely be hard-coded; instead pool sizes should be provided by a configuration mechanism or computed dynamically by consulting *Runtime.availableProcessors*
* The optimal pool size for keeping the processors at the desired utilization is:
    * Nthreads = Ncpu * Ucpu * (1 + W/C)
    
## 8.3. Configuring ThreadPoolExecutor
* ThreadPoolExecutor is a flexible, robust pool implementation that allows a variety of customizations

### 8.3.1. Thread Creation and Teardown
* The core pool size, maximum pool size, and keep-alive time govern thread creation and teardown
* The core size is the target size; the implementation attempts to maintain the pool at this size even when there are no tasks to execute, and will not create more threads than this unless the work queue is full
* The maximum pool size is the upper bound on how many pool threads can be active at once
* *newFixedThreadPool* factory sets both the core pool size and the maximum pool size to the requested pool size, infinite timeout

### 8.3.2. Managing Queued Tasks
* Bounded thread pools limit the number of tasks that can be executed concurrently
* With a thread pool, they wait in a queue of *Runnable* managed by the *Executor* instead of queueing up as threads contending for the CPU
* The *newCachedThreadPool* factory is a good default choice for an *Executor*, providing better queuing performance than a fixed thread pool
* A fixed size thread pool is a good choice when you need to limit the number of concurrent tasks for resource-management purposes, as in a server application that accepts requests from network clients and would otherwise be vulnerable to overload

### 8.3.3. Saturation Policies
* When a bounded work queue fills up, the saturation policy comes into play

### 8.3.4. Thread Factories
* Specifying a thread factory allows you to customize the configuration of pool threads

### 8.3.5. Customizing ThreadPoolExecutor After Construction
* Most of the options passed to the *ThreadPoolExecutor* constructors can also be modified after construction via setters (such as the core thread pool size, maximum thread pool size, keep-alive time, thread factory, and rejected execution thread)

## 8.4. Extending ThreadPoolExecutor
* *ThreadPoolExecutor* was designed for extension, providing several "hooks" for subclasses to override

### 8.4.1. Example: Adding Statistics to a Thread Pool

## 8.5. Parallelizing Recursive Algorithms
* Sequential loop iterations are suitable for parallelization when each iteration is independent of the others and the work done in each iteration of the loop body is significant enough to offset the cost of managing a new task

### 8.5.1. Example: A Puzzle Framework
* The *Executor* framework is a powerful and flexible for concurrently executing tasks
* If offers a number of tuning options, such as policies for creating and tearing down threads, handling queued tasks, and what to do with excess tasks, and provides several hooks for extending its behavior
* As in most powerful frameworks, however, there are combinations of settings that do not work well together; some types of tasks require specific execution policies, and some combinations of tuning parameters may produce strange results
