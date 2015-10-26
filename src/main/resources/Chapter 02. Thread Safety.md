# Chapter 02. Thread Safety
* Writing thread-safe code, at its core, about managing access to state, and in particular to shared, mutable state
* The primary mechanism for synchronization in Java is the *synchronized* keyword, which provides exclusive locking, but the term "synchronization" also includes the use of *volatile* variables, explicit locks, and atomic variables
* If multiple threads access the same mutable state variable without synchronization, your program is broken. There are three way to fix it:
    * Don't share the state variable across threads;
    * Make the state variable immutable
    * Use synchronization whenever accessing the state variable
* It is far easier to design a class to be thread-safe than to retrofit it for thread safety later
* The better encapsulated your program state, the easier it is to make your program thread-safe and to help maintainers keep it that way
* When designing thread-safe classes, good object-oriented techniques - encapsulation, immutability, and clear specification of invariants - are your best friends

## 2.1. What is Thread Safety ?
* Correctness means that a class conforms to its specification
* A class is thread-safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling or interleaving of the execution of those threads by the runtime environment, and with no addition synchronization or other coordination on the part of the calling code

### 2.1.1. Example: A Stateless Servlet
* Stateless object are always thread-safe

## 2.2. Atomicity

### 2.2.1. Race Conditions
* A race conditions occurs when the correctness of a computation depends on the relative timing or interleaving of multiple threads by the runtime

### 2.2.2. Example: Race Conditions in Lazy Initialization
* Like most concurrency errors, race conditions don't always result in failure: some unlucky timing is also required
* But race conditions can cause serious problems

### 2.2.3. Compound Actions
* Operations A and B are atomic with respect of each other if, from the perspective of a thread executing A, when another thread executes B, either all of B has executed or none of it has
* An atomic operation is one that is atomic with respect to all operations, including itself, that operate on the same state
* To ensure thread safety, check-then-act operation (like lazy init) and read-modify-write (like increment) must always be atomic
* Where practical, use existing thread-safe objects, like *AtomicLong*, to manage your class's state
* It is simpler to reason about the possible states and state transitions for existing thread-safe objects than it is for arbitrary state variables, and this makes it easier to maintain and verify thread safety

## 2.3. Locking
* To preserve state consistency, update related state variables in a single atomic operation

### 2.3.1. Intrinsic Locks
* Java provides a built-in locking mechanism for enforcing atomicity: the *synchronized* block
* A *synchronized* block has two parts: a reference to an object that will serve as the lock, and a block of code to be guarded by that lock
* Intrinsic locks in Java act as mutexes (or mutual exclusion locks), which means that at most one thread may own the lock
* When thread A attempts to acquire the lock held by thread B, A must wait, or block, until B releases it. If B never releases the lock, A waits forever
* In the context of concurrency, atomicity means the same thing as it does in transactional applications - that a group of statements appear to execute as a single, indivisible unit

### 2.3.2. Reentrancy
* Reentrancy means that locks are acquired on a per-thread rather than per-invocation basis
* Reentrancy is implemented by associating with each lock an acquisition count and an owning thread

## 2.4. Guarding State with Locks
* For each mutable state variable that may be accessed by more than one thread, all accesses to that variable must be performed with the same lock held. In this case, we say that the variable is guarded by that lock
* Every shared, mutable variable should be guarded by exactly one lock. Make it clear to maintainers which lock that is
* For every invariant that involves more than one variable, all the variables involved in that invariant must by guarded by the same lock

## 2.5.1 Liveness and Performance
* There is frequently a tension between simplicity and performance. When implementing a synchronization policy, resist the temptation to prematurely sacrifice simplicity (potentially compromising safety) for the sake of performance
* Avoid holding locks during lengthy computations or operations at risk of not completing quickly such as network or console I/O