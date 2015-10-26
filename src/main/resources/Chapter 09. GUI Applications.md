# Chapter 09. GUI Applications

## 9.1. Why are GUIs Single-threaded?
* Single-threaded GUI frameworks achieve thread safety via thread confinement
* All GUI objects, including visual components and data models, are accessed exclusively from the event thread

### 9.1.1. Sequential Event Processing
* GUI applications are oriented around processing events
* Events are a kind of task; the event handling mechanism is structurally similar to an *Executor*

### 9.1.2. Thread Confinement in Swing
* The Swing single-thread rule: Swing components and models should be created, modified, and queried only from the event-dispatching thread

## 9.2. Short-running GUI Tasks

## 9.3. Long-running GUI Tasks

### 9.3.1. Cancellation

### 9.3.2. Progress and Completion Indication

## Summary
* GUI frameworks are nearly always implemented as single-thread subsystems in which all presentation-related code runs as tasks in an event thread
* Because there is only a single event thread, long-running tasks can compromise responsiveness and so should be executed in background threads
* Helper classes like *SwingWorker* or the *BackgroundTask* class built here, which provide support for cancellation, progress indication, and completion indication, can simplify the development of long-running tasks that have both GUI and non-GUI components