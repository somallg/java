# PLT.15 Coordination between Portlets
* In order to provide coordination between Portlets, Java Portlet Specification introduces the following mechanisms:
    * sharing data between artifacts in the same web application via the session in the application scope
    * public render parameters in order to share render state between Portlets
    * portlet events that a portlet can receive and send

## PLT.15.1 Public Render Parameters
* Public render parameters are intended for sharing view state across portlets
* Using public render parameters instead of events avoids the additional process event call and enables the end-user using the browser navigation and bookmarking if the portal stores the render parameters in the URL

## PLT.15.2 Portlet Events
* Portlet events are intended to allow Portlets to react to action or state changes not directly related to an interaction of the user with the Portlet
* Events could be either portal or portlet container generated or the result of a user interaction with other portlets
* The portlet event model is a loosely coupled, brokered model that allows creating Portlets as stand-alone Portlets that can be wired together with other Portlets at runtime
* Portlet programmer should therefore not make any specific assumptions about the environment of Portlets that they are running together with
* The means of wiring different portlets together is portal implementation specific
* Portlet event are not a replacement for reliable messaging (i.e JMS)
* Portlet events are not guaranteed to be delivered and thus the portlet should always work in a meaningful manner even if some or all events are not being delivered
* In response to an event, a Portlet may publish new events that should be delivered to other portlets and thus may trigger state changes on these other portlets
* An example where a Portlet may want to offer receiving events is for state changes triggered by simple user interactions, e.g adding an item to a shopping cart
* In contrast to using the Portlet application scope session, this will work across Portlet application boundaries

### PLT.15.2.1 EventPortlet Interface
* Portlet can access the event that triggered the current process event call by using the *EventRequest.getEvent* method
* This method returns an object of type *Event* encapsulating the current event name and value
* The event must always have a name and may optionally have a value
* Event names are represented as QNames in order to make them uniquely identifiable
* The event name can be either retrieved with *getQName* method that return the complete QName of the event, or with *getName* method that only returns the local part of the event name
* If the event has a value it must be based on the type defined in the deployment descriptor
* The default XML to Java mapping that every container should support is the JAXB mapping
* Portlet containers are free to support additional mapping mechanisms beyond the JAXB mapping
* For optimization purposes in local Java runtime environments the Portlet container can use Java Serialization or direct Java objects passing for the event payload
* The Portlet must not make any assumptions on the mechanisms the Portlet container chooses to pass the event payload

### PLT.15.2.3 Sending Events
* Portlet can publish events via *StateAwareResponse.setEvent* method, the method are exposed via the *ActionResponse* and *EventResponse* interfaces
* It is also valid to call *StateAwareResponse.setEvent* multiple times in the current *processAction* or *processEvent* method
* Events can be published either with their full QName with the *setEvent(QName, Serializable)* method or by only specifying their local part withe the *setEvent(String, Serializable)* method
* If only the local part is specified, the namespace must be the default namespace defined in the Portlet deployment descriptor with the *default-namespace* element
* If no such element is provided in the Portlet deployment descriptor, the XML default namespace *javax.xml.XMLConstnats.NULL_NS_URI must be assumed
* The Event payload must have a valid JAXB binding, or be in the list of Java primitive types / standard classes of the JAXB 2.0 spec, and implement *java.io.Serializable*
* Otherwise, the *setEvent* method must throw a *java.lang.IllegalStateException*

### PLT.15.2.4 Event declaration
* Portlet should declare all events that it would like to receive and the one it would like to initiate
* Typically Portlet only receive events that the Portlet has declared as processing events

#### PLT.15.2.4.1 Declaration in the deployment descriptor
* Portlet should declare events in the *portlet.xml* deployment descriptor
* On the application level, the Portlet should define the basic event definition with *event-definition* element
* The event definition must contain an even name
* Portlet container must use the event name entry in the Portlet deployment descriptor as event name when submitting an Event to the Portlet
* The Portlet can specify additional alias names in order to enable Portlets performing an automatic wiring between events
* When publishing an Event, the Portlet should also use the event name entry in the deployment descriptor as event name, otherwise the container may ignore this event
* Event definition should be referenced on the Portlet level where Portlet can define the processing events with *supported-processing-event* element and the events being published with the *supported-publishing-event* element
* The reference event name should either be full QName provided with the *qname* element* and referencing the QName of the event, or local part of the QName
* Event definitions are valid for all entities created based on the Portlet definition
* Portlet container or portal defined events do not need to be declared on the application level with *event-definition* element, but can be directly referenced on the Portlet level with the *supported-processing-event* element
* As an alternative, Portlet can specify a default namespace via the *default-namespace* element that will be applied to all events defined only with a local name with the *name* element in the event definition section
* Portlet is encourage to organize the local part of the event names in the *event-definition* element in a hierarchical manner using the dot '.' as separator
* A trailing '.' tells the Consumer that this is not the end of the hierarchical and the Portlet is interested in all events with names in this branch of the hierarchy
* Portlet must not specify events with the same name but different types
* Event names in the *event-definition* element should not end with a trailing '.' character, as wildcards are not supported in the event definitions
* Wildcards should only be used in the *supported-processing-event* or *supported-publishing-event* elements ans should be able to resolved by the Portlet container to an event definition without wildcards in the *event-definition* element by matching event names ending with a '.' character to any event whose local name starts with the characters before the "." character and also specifies the same namespace
* If the wildcard string should match a part of a hierarchy, two dots are required at the end of the wildcard string: one to denote the hierarchy and one for the wildcard: "foo.bar.."
* A localized display name for the Portlet event definition should be provided in the application level resource bundle with an entry of the name *javax.portlet.app.event-definition.name.display-name*

#### PLT.15.2.4.2 Events not declared in the Deployment Descriptor
* Portlet can send events which are not declared in the Portlet deployment descriptor at runtime using the *setEvent* method on either *ActionResponse* or *EventResponse*
* Portlet should note that by not declaring those events in the deployment descriptor, the abilities of the Portal for distributing the event to other Portlets may be limited or even non-existent

### PLT.15.2.5 Event processing
* Events are valid only in the current request and the Portlet container must therefore deliver all events within the current client request
* Event delivery is not guaranteed and the container may restrict event delivery in a meaningful manner, e.g in order to prevent endless loops
* Events are not ordered and the container may re-order the received events before distributing them
* However, Portal applications should distribute evens returned by a single Portlet in the order the event called the *setEvent* method while executing the *processAction* or *processEvent* method, but ordering of distribution is not guaranteed
* Thus Portlet developers should rely on other mechanisms, like adding the ordering in the event payload, of ordering of the events is required
* Event distribution is non-blocking and can happen in parallel for different portlet windows
* Event distribution must be serialized for a specific Portlet window per client request so that at any given time a Portlet window is only processing one event in the *processEvent* method for the current client request
* Portlet container should therefore queue the events for one Portlet window for one user
* When processing the queue the container should take any previously returned event response data, like render parameters, portlet mode, window state, into account and supply these updated values with the event request
* Note that event processing for different Portlets within the current client request may happen in parallel and that therefore for state changes on shared data, like public render parameters or the application session, the last state change wins
* Portlet event processing may occur after the processing of the action, if the Portlet was target of an action URL, and must be finished before the render phase
* Container raised events are issued by the Portlet container and not a Portlet
* Portlet should not publish container events, only process them
* Container events published by the Portlet should be ignored by the Portlet container
* If a Portlet would like to receive a container raised event it should declare the event in the Portlet deployment descriptor with the *supported-processing-event* element

### PLT.15.2.6 Exceptions during event processing
* Portlet may throw a *PortletException*, *PortletSecurityException* or *UnavailableException* during the *processEvent*
* *PortletException* signals that an error has occurred during the processing of the event and that the Portlet container should take appropriate measures to clean up the even processing
* If a Portlet throws an exception in the *processEvent*, all operations on the *EventResponse* must be ignored
* Portal/Portlet container should continue processing other events targeted to the Portlet and the other Portlets participating in the current client request
* Otherwise, it is up to the Portlet container implementation if the error is faced to the end user, the Portlet is removed from the current request cycle or if the render method of the Portlet is called
* *UnavailableException* signals that Portlet is unable to handle requests either temporarily or permanently
* *RuntimeException* thrown during the event handling must be handle as a *PortletException*
* When Portlet throws an exception, or when Portlet becomes unavailable, the Portal/Portlet-container may include a proper error message in the Portal page returned to the user

### PLT.15.2.7 GenericPortlet support
* *GenericPortlet* implements *EventPortlet* interface, and provides a default event handling
* For a received event the *GenericPortlet* tries to dispatch to methods annotated with the tag *@ProcessEvent*
* Event name can be either specified as QName or local part only
* For using *QNames* as event name, the syntax is the following: *@ProcessEvent(qname=event name)*, where the event name must be in the format "{" + Namespace URL + "}" + local part (like used by *javax.xml.namespace.QName.toString()
* If Namespace URI is equal to *javax.xml.XMLConstants.NULL_NS_URI* only the local part is used
* If the local part of the event name has a wildcard at the end "." the *GenericPortlet* will try to match the received event either to the same wildcard event name or to the longest matching event name for this wildcard
* If an event with the local part of the event name of "a.b.c.d" is being received and there are methods annotated for handling "a.b." and "a.b.c" events in this portlet, the *GenericPortlet* will dispatch the event to the method annotated with "a.b.c."
* The method annotated with the *@ProcessEvent* annotation must have the following signature:
    * *public void methodName(EventRequest, EventResponse) throws PortletException, java.io.IOException*
* If no such method can be found the *GenericPortlet* just sets the received render parameters as new render parameters
* If multiple annotations match the current event, it is indeterministic which method will be called for handling this event

## PLT.15.3 Predefined Container Events
* The Web Service for Remote Portlets (WSRP) specification predefines some common events that should be leverage when requiring an event for one of the following scenarios:
    * Event handling failed *wsrp:eventHandlingFailed* - this is portal application generated event which signals to the Portlet that the Portal application detected that errors occurred while distributing events. As a simple notification, this event carries no predefines payload, but does use an open content definition
    * Navigation context changed *wsrp:newNavigationalContextScope* - allowing the Portlet to manage its own navigational context in a consistent manner with the navigational context managed by the Portal application
    * New portlet mode *wsrp:newMode* - indicating to the Portlet that is has been put into a new Portlet mode and allowing the Portlet to pre-set some state before getting rendered in this new mode
    * New Window State *wsrp:newWindowState* - indicating to the Portlet that it has been put into new window state and allowing the Portlet to pre-set some state before getting render in this window state
* See section 5.11 of *Web Services for Remote Portlets 
Specification* v2.0 for more details and the QNames for these events
* Portal/Portlet containers supporting one of the above predefined events should deliver these events to all portlets having declared receiving event support for these event in the portlet deployment descriptor