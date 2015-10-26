# Chapter 06. Task Execution
* Most concurrent applications are organized around the execution of task: abstract, discrete units of work
* Dividing the work of an application into task simplifies program organization, facilitates error recovery by providing natural transaction boundaries, and promotes concurrency by providing a natural structure for parallelizing work

## 6.1. Executing Tasks in Threads
* First step in organizing a program around task execution is identifying sensible task boundaries
* Tasks are independent activities: work that doesn't depend on the state, result, or side effects of other tasks
* Independence facilitates concurrency, as independent tasks can be executed in parallel

### 6.1.1. Executing Tasks Sequentially
* In server applications, sequential processing rarely provides either good throughput or good responsiveness

### 6.1.2. Explicitly Creating Threads for Tasks
* Task processing is offloaded from the main Thread
* Tasks can be processed in parallel
* Task-handling code must be thread-safe

### 6.1.3. Disadvantages of Unbounded Thread Creation
* Thread lifecycle overhead. Thread creation and teardown are not free
* Resource consumption
* Stability
* Up to a certain point, more threads can improve throughput, but beyond that point creating more threads just slows down your application, and creating one thread too many can cause your entire application to crash 
* Unbounded thread creating may appear to work just fine during prototyping and development, with problems surfacing only when the application is deployed and under heavy load

## 6.2. The Executor Framework
* Tasks are logical units of work, and threads are a mechanism by which tasks can run asynchronously
* Executor may be a simple interface, but it forms the basis for a flexible and powerful framework for asynchronous task execution that supports a wide variety of task execution policies

### 6.2.1. Example: Web Server Using Executor

### 6.2.2. Execution Policies
* The value of decoupling submission from execution is that it lets you easily specify, and subsequently change without great difficulty, the execution policy for a given class of tasks
* An execution policy specifies the "what, where, when, and how" of task execution:
    * In what thread will tasks be executed?
    * In what order should tasks be executed?
    * How many tasks may executed concurrently?
    * How many tasks may be queued pending execution?
    * If a task has to be rejected because the system is overloaded, which task should be selected as the victim, and how should the application be notified?
    * What actions should be taken before or after executing a task?
* Execution policies are a resource management tool, and the optimal policy depends on the available computing resources
* Separating the specification of execution policy from task submission makes it practical to select an execution policy at deployment time that is matched to the available hardware

### 6.2.3. Thread Pools
* A thread pool manages a homogeneous pool of worker threads
* A thread pool is tightly bound to a work queue holding tasks waiting to be executed
* Executing tasks in pool threads has a number of advantages over thread-per-task approach
    * Low overhead
    * Reduce latency, improve responsiveness
* Create a thread pool by calling one of the static factory methods in *Executors*
    * *newFixedThreadPool*
    * *newCachedThreadPool*
    * *newSingleThreadExecutor*
    * *newScheduledThreadPool*

### 6.2.4. Executor Lifecycle
* *ExecutorService* interface extends *Executor*, adding a number of methods for lifecycle management
* The lifecycle by *ExecutorService* has three states: running, shutting down, and terminated

### 6.2.5. Delayed and Periodic Tasks
* *Timer*  facility manages the execution of deferred or periodic
* However, *Timer* has some drawbacks, and *ScheduledThreadPoolExecutor* should be though of as its replacement

## 6.3. Finding Exploitable Parallelism

### 6.3.1. Example: Sequential Page Renderer

### 6.3.2. Result-bearing Tasks: Callable and Future
* *Runnable* is fairly limiting abstraction; run cannot return a value or throw checked exceptions
* *Callable* is a better abstraction: it expects that the main entry point, *call*, will return a value and anticipates that it might throw an exception
* *Runnable* and *Callable* describe abstract computational tasks
* The lifecycle of a task executed by an *Executor* has four phases: *created*, *submitted*, *started*, and *completed*

### 6.3.3. Example: Page Renderer with Future

### 6.3.4. Limitations of Parallelizing Heterogeneous Tasks
* The real performance payoff of dividing a program's workload into tasks comes when there are a large number of independent, homogeneous tasks that can be processed concurrently


### 6.3.5. CompletionService: Executor Meets BlockingQueue
* Combines the functionality  of an *Executor* and *BlockingQueue*

### 6.3.6. Example: Page Renderer with CompletionService
* Multiple *ExecutorCompletionServices* can share a single *Executor*

### 6.3.7. Placing Time Limits on Tasks
* The timed version of *Future.get* returns as soon as the result is ready, but throws *TimeoutException* if the result is not ready within the timeout period

### 6.3.8. Example: A Travel Reservations Portal

## Summary
* Structuring applications around the execution of tasks can simplify development and facilitate concurrency
* The *Executor* framework permits you to decouple task submission from execution policy and supports a rich variety of execution policies
* Whenever you find yourself creating threads to perform tasks, consider using an *Executor* instead
* To maximize the benefit of decomposing an application into tasks, you must identify sensible task boundaries
* In some applications, the obvious task boundaries work well, whereas in others some analysis may be required to uncover finer-grained exploitable parallelism