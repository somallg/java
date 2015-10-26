# Chapter 12. Testing Concurrent Programs
* Concurrent programs employ similar design principles and patterns to sequential programs
* The difference is that concurrent programs have a degree of non-determinism that sequential programs do not
* Tests of safety, which verify that a class's behavior conforms to its specification, usually take the form of testing invariants
* Test code can introduce timing or synchronization artifacts that can mask bugs that might otherwise manifest themselves
* Liveness tests include tests of progress and non-progress, which are hard to quantify 
* Performance can be measured in a number of ways:
    * Throughput: the rate at which a set of concurrent tasks is completed
    * Responsiveness: the delay between a request for and completion of some action
    * Scalability: the improvement in throughput as more resources are made available
    
## 12.1. Testing for Correctness
* Developing unit tests for a concurrent class starts with the same analysis as for a sequential class identifying invariants and post conditions 

### 12.1.1. Basic Unit Tests

### 12.1.2. Testing Blocking Operations

### 12.1.3. Testing Safety
* The challenge to constructing effective safety tests for concurrent classes is identifying easily checked properties that will, with high probability, fail if something goes wrong, while at the same time not letting the failure auditing code limit concurrency artificially. It is best if checking the test properly does not require any synchronization
* Tests should be run on multiprocessor systems to increase the diversity of potential interleavings. However, having more than a few CPUs does not necessarily make tests more effective. To maximize the chance of detecting timing-sensitive data races, there should be more active threads than CPUs, so that at any given time some threads are running and some are switched out, thus reducing the predictability of interactions between threads

### 12.1.4. Testing Resource Management

### 12.1.5. Using Callbacks

### 12.1.6. Generating More Interleavings

## 12.2. Testing for Performance

### 12.2.1. Extending PutTakeTest to Add Timing

### 12.2.2. Comparing Multiple Algorithms

### 12.2.3. Measuring Responsiveness

### 12.4.2. Static Analysis Tools

## Summary
* Testing concurrent programs for correctness can be extremely challenging because many of the possible failure modes of concurrent are low-probability events that are sensitive to timing, load, and other hard-to-reproduce conditions
* Further, the testing infrastructure can introduce additional synchronization or timing constraints that can mask concurrency problems in the code being tested
* Testing concurrent programs for performance can be equally challenging; Java programs are more difficult to test than programs written in statically compile languages like C, because timing measurements can be affected by dynamic compilation, garbage collection, and adaptive optimization
* To have the best chance of finding latent bugs before they occur in production, combine traditional testing techniques with code reviews and automated analysis tools. Each of these techniques finds problems that the others are likely to miss