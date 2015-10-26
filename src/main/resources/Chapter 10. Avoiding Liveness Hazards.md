# Chapter 10. Avoiding Liveness Hazards
* There is often a tension between safety and liveness
* We use locking to ensure thread safety, but indiscriminate use of locking can cause lock-ordering deadlocks
* Thread pools and semaphores to bound resource consumption, but failure to understand the activities being bounded can cause resource deadlocks

## 10.1. Deadlock
* When a thread holds a lock forever, other threads attempting to acquire that lock will block forever waiting

### 10.1.1. Lock-ordering Deadlocks
* A program will be free of lock-ordering deadlocks if all threads acquire the locks they need in a fixed global order

### 10.1.2. Dynamic Lock Order Deadlocks

### 10.1.3. Deadlocks Between Cooperating Objects
* Invoking an alien method with a lock held is asking for liveness trouble
* The alien method might acquire other locks (risking deadlock) or block for an unexpectedly long time, stalling other threads that need the lock you hold

### 10.1.4. Open Calls
* Calling a method with no locks held is called an open call, and classes that rely on open calls are more well-behaved and composable than classes that make calls with locks held
* Using open calls to avoid deadlock is analogous to using encapsulation to provide thread safety
* Strive to use open calls throughout your program. Programs that rely on open calls are far easier to analyze for deadlock-freedom than those that allow calls to alien methods with locks held

### 10.1.5. Resource Deadlocks
* Thread can also deadlock when waiting for resources

## 10.2. Avoiding and Diagnosing Deadlocks
* A program that never acquires more than one lock at a time cannot experience lock-ordering deadlock
* If you must acquire multiple locks, lock ordering must be a part of your design: try to minimze the number of potential lockings interactions, and follow and document a lock-ordering protocol for locks that may be acquired together

### 10.2.1. Timed Lock Attempts
* Using timed lock acquisition to acquire multiple locks can be effective against deadlock even when timed locking is not used consistently

### 10.2.2. Deadlock Analysis with Thread Dumps
* Thread dump includes a stack trace for each running thread, similar to the stack trace that accompanies an exception

## 10.3. Other Liveness Hazards

### 10.3.1. Starvation
* Starvation occurs when a thread is perpetually denied access to resources it needs in order to make progress
* Avoid the temptation to use thread priorities, since they increase platform dependence and can cause liveness problems. Most concurrent applications can use the default priority for all threads

### 10.3.2. Poor Responsiveness
* Poor responsiveness can also be caused by poor lock management

### 10.3.3. Livelock
* Livelock is a form of liveness failure in which a thread, while not blocked, still cannot make progress because it keeps retrying an operation that will always fail
* Retrying with random waits and backoffs can be equally effective for avoiding livelock in concurrent applications

## Summary
* Liveness failure are a serious problem because there is no way to recover from them short of aborting the application
* The most common form of liveness failure is lock-ordering deadlock
* Avoid lock ordering deadlock starts at design time: ensure that when thread acquire multiple locks, they do so in a consistent order
* The best way to do this is by using open calls throughout your program
* This greatly reduces the number of places where multiple locks are held ac once, and makes it more obvious where those places are