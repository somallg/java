# Chapter 03. Sharing Objects
* Synchronization also has another significant, and subtle, aspect: memory visibility
* We want not only to prevent one thread from modifying the state of an object when another is using it, but also to ensure that when a thread modifies the state of an object, other threads can actually see the changes that were made

## 3.1. Visibility
* In general, there is no guarantee that the reading thread will see a value written by another thread on a timely basis, or even at all
* In order to ensure visibility of memory writes across threads, you must use synchronization
* There is no guarantee that operations in one thread will be performed in the order given by the program, as long as the reordering is not detectable from within that thread
* In the absence of synchronization, the compiler, processor, and runtime can do some downright weird things to the order in which operations appear to execute
* Attempts to reason about the order in which memory actions "must" happen in insufficiently synchronized multithreaded programs will almost certainly be incorrect
* Always use the proper synchronization whenever data is shared across threads

### 3.1.1. Stale Data
* Stale values can cause serious safety or liveness failures
* Stale data can cause serious and confusing failures such as unexpected exceptions, corrupted data structures, inaccurate computations, and infinite loops
* Synchronization only the setter would not be sufficient: threads calling get would still be able to see stale values

### 3.1.2. Non-atomic 64-bit Operations
* When a thread reads a variable without synchronization, it may see a stale value, but at least it sees a value that was placed there by some thread. This safety guarantee is called out-of-thin-air safety
* Out-of-thin-air safety applies to all variables, with one exception: 64-bit numeric variables (double and long) that are not declared *volatile*

### 3.1.3. Locking and Visibility
* Intrinsic locking can be used to guarantee that one thread sees the effects of another in a predictable manner
* Locking is not just about mutual exclusion; it is also about memory visibility. To ensure that all threads see the most up-to-date values of shared mutable variables, the reading and writing threads must synchronize on a common lock

### 3.1.4. Volatile Variables
* Java also provides an alternative, weaker form of synchronization, *volatile* variables, to ensure that updates to a variable are propagated predictably to other threads
* Use *volatile* variables only when they simplify implementing and verifying your synchronization policy; avoid using *volatile* variables when verifying correctness would require subtle reasoning about visibility
* Good uses of volatile variable including ensuring the visibility of their own state, that of the object they refer to, or indicating that an important lifecyle event (such as initialization or shutdown) has occurred
* Locking can guarantee both visibility and atomicity; volatile can only guarantee visibility

## 3.2. Publication and Escape
* Publishing an object means making it available to code outside of its current scope, such as by storing a reference to it where other code can find it, returning it from non-private method, or passing it to a method in another class

### 3.2.1. Safe Construction Practices
* Do not allow the *this* reference to escape during construction

## 3.3. Thread Confinement
* If data is only accessed from a single thread, no synchronization is needed
* When an object is confined to a thread, such usage is automatically thread-safe even if the confined object itself is not
* Java provide mechanism that can help in maintaining thread confinement - local variables and the *ThreadLocal* class

### 3.3.1. Ad-hoc Thread Confinement
* Ad-hoc thread confinement describes when the responsibility for maintaining thread confinement falls entirely on the implementation

### 3.3.2 Stack Confinement
* Special case of thread confinement in which an object can only be reached through local variables
* Stack confinement (also called within-thread or thread-local) is simpler to maintain and less fragile than ad-hoc thread confinement
* Just as encapsulation can make it easier to preserve invariants, local variables can make it easier to confine objects to a thread
* Using a non-thread-safe object in a within-thread context is still thread-safe

### 3.3.3. ThreadLocal
* Allow you to associate a per-thread value with a value-holding object

## 3.4. Immutability
* An immutable object is one whose state cannot be changed after construction
* Immutable objects are always thread-safe
* An object is immutable if:
    * Its state cannot be modified after construction
    * All its fields are *final*
    * It is properly constructed (the *this* reference does not escape during construction)
    
### 3.4.1. Final Fields
* Just as it is a good practice to make al fields *private* unless they need greater visibility, it is good practice to make all fields *final* unless they need to be mutable

### 3.4.2. Example: Using Volatile to Publish Immutable Objects

## 3.5. Safe Publication
* Improper publication could allow another thread to observe a partially constructed object

### 3.5.1. Improper Publication: When Good Objects Go Bad

### 3.5.2. Immutable Objects and Initialization Safety
* Immutable objects can be used safely by any thread without additional synchronization, even when synchronization is not used to publish them

### 3.5.3. Safe Publication Idioms
* To publish an object safely, both the reference to the object and the object's state must be made visible to other threads at the same time
* A properly constructed object can be safely published by:
    * Initializing an object reference from a static initializer
    * Storing a reference to it into a *volatile* field or *AtomicReference*
    * Storing a reference to it into a *final* field of a properly constructed object
    * Storing a reference to it into a field that is properly guarded by a lock
    
### 3.5.4. Effectively Immutable Objects
* Safety published effectively immutable objects can be used safely by any thread without additional synchronization

### 3.5.5. Mutable Objects
* The publication requirements for an object depend on its mutability:
    * Immutable objects can be published through any mechanism
    * Effectively immutable objects must be safely published
    * Mutable objects must be safely published, and must be either thread-safe or guarded by a lock
    
### 3.5.6. Sharing Objects Safely
* The most useful policies for using and sharing objects in a concurrent program are:
* *Thread-confined*: a thread-confined object is owned exclusively by and confined by one thread, and can be modified by its owning thread
* *Shared read-only*: a shared read-only object can be accessed concurrently by multiple threads without additional synchronization, but cannot be modified by any thread. Shared read-only objects include immutable and effectively immutable objects
* *Shared thread-safe*: a thread-safe object perform synchronization internally, so multiple threads can freely access it through its public interface without further synchronization
* *Guarded*: a guarded object can be accessed only with a specific lock held. Guarded objects included those that are encapsulated within other thread-safe objects and published objects that re know to be guarded by a specific lock
