# Chapter 04. Composing Objects

## 4.1. Designing a Thread-safe Class
* The design process for a thread-safe class should include these three basic elements:
    * Identify the variables that form the object's state
    * Identify the invariants that constrain the state variables
    * Establish a policy for managing concurrent access to the object's state

### 4.1.1. Gathering Synchronization Requirements
* You cannot ensure thread safety without understanding an object's invariants and post-conditions
* Constraints on the valid values or state transitions for state variables can create atomicity and encapsulation requirements

### 4.1.2. State-dependent Operations
* Operations with state-based preconditions are called state-dependent
* Concurrent programs add the possibility of waiting until the precondition becomes true, and then processing with the operation

### 4.1.3. State Ownership
* Ownership and encapsulation go together - to object encapsulates the state it owns and owns the state it encapsulates

## 4.2. Instance Confinement
* Encapsulating data within an object confines access to the data to the object's methods, making it easier to ensure that data is always accessed with the appropriate lock held
* Confinement makes it easier to build thread-safe classes because a class that confines its state can be analyzed for thread safety without having to examine the whole program

### 4.2.1. The Java Monitor Pattern
* Making the lock object private encapsulates the lock so that client code cannot acquire it
* Clients that improperly acquire another object's lock could cause liveness problem, and verifying that a publicity accessible lock is properly used requires examining the entire program rather than a single class

### 4.2.2. Example: Tracking Fleet Vehicles
* Maintains thread safety in part by copying mutable data before returning it to the client

## 4.3. Delegating Thread Safety
* All but the most trivial objects are composite objects

### 4.3.1. Example: Vehicle Tracker Using Delegation

### 4.3.2. Independent State Variables
* We can also delegate thread safety to more than one underlying state variables as long as those underlying state variables are independent, meaning that the composite class does not impose any invariants involving the multiple state variables

### 4.3.3. When Delegation Fails
* If a class has compound actions, delegation alone is again not a suitable approach for thread safety
* In these cases, the class must provide its own locking to ensure that compound actions are atomic, unless the entire compound action can also be delegated to the underlying state variables
* If a class is composed of multiple independent thread-safe state variables and has no operations that have any invalid state transitions, then it can delegate thread safety to the underlying state variables
* A variable is suitable for being declared *volatile* only if it does not participate in invariants involving other state variables

### 4.3.4. Publishing Underlying State Variables
* If a state variable is thread-safe, does not participate in any invariants that constrain its value, and has no prohibited state transitions for any of its operations, then it can safety be published

### 4.3.5. Example: Vehicle Tracker that Publishes Its State

## 4.4. Adding Functionality to Existing Thread-safe Classes
* The safest way to add a new atomic operation is to modify the original class to support the desired operation
* Another approach is to extend the class

### 4.4.1 Client-side Locking
* A third strategy is to extend the functionality of the class without extending the class itself by placing extension code in a "helper" class
* Client-side locking entails guarding client code that uses some object X with lock X uses to guard its own state
* In order to use client-side locking, you must know what lock X uses
* Just as extension violates encapsulation of implementation, client-side locking violates encapsulation of synchronization policy

### 4.4.2. Composition
* There is a less fragile alternative for adding an atomic operation to an existing class: composition

## 4.5. Documenting Synchronization Policies
* Document a class's thread safety guarantees for its clients; document its synchronization policy for its maintainers
* Don't make your customers or colleagues have to make guesses about class thread-safety

### 4.5.1. Interpreting Vague Document
* Many Java technology specifications are silent, or at least unforthcoming, about thread safety guarantees and requirements of interfaces such as *ServletContext*, *HttpSession*, or *DataSource*
* You are going to have to guess, interpret the specification from the perspective of someone who will implement it, as opposed to someone who will merely use it
