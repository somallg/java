# Appendix A. Annotations for Concurrency

## A.1. Class Annotations
* *@Immutable*: the class is immutable, and implies *@ThreadSafe*
* *@NotThreadSafe* is optional, if a class is not annotated thread-safe, it should be presumed not to be thread-safe

## A.2. Field and Method Annotations
* *@GuardedBy(lock)* documents that a field or method should be accessed only with a specific lock held
* The *lock* argument identifies the lock that should be held when accessing the annotated field or method
* Using *@GuardedBy* to identify each stat variable that needs locking and which lock guards it can assists in maintenance and code reviews, and can help automated analysis tool spot potential thread-safety errors