# UDDI
* UDDI represents WS instances as *uddi:bindingTemplate* elements
* *uddi:bindingTemplate* plays a role is the rough analog of the *wsdl:port*, but provides options that are not expressible in WSDL

* WSDL' *soapbind:address* element requires the network address of the instances to be directly specified. In contrast, UDDI v2 provides two alternatives for specifying the network address of instances it represents:
    * *uddi:accessPoint* - mirrors the WSDL mechanism by directly specifying the address
    * *uddi:hostingRedirector* - provides a WS-based indirection mechanism for resolving the address, and is inconsistent with the WSDL mechanism
    
* **R3100** REGDATA of type *uddi:bindingTemplate* representing a conformant INSTANCE MUST contain the *uddi:accessPoint* element


# WSDL
* *wsdl:types* - Container element for data type definitions that are made using XML Schema (XSD) or another similar system for data types
* *wsdl:message* - Definition of the message data being communicated. The message can be made up of multiple parts and each part can be of different type
* *wsdl:portType* - Abstract set of operations supported by one or more endpoints
* *wsdl:binding* - Concrete protocol and data format specification for a particular port type
* *wsdl:service* - Collection of related endpoints

# SOAP
* The encoding recognizes two compound types:
    * A structure (struct) is a list of elements logically grouped together. The elements are identified by their names (The element accessor is its name)
    * The array is a group of values identified not by their names by by their ordinal positions (The accessor of the element is the position of the element in the array)
    
# JAXP
* Sequence of events passed by a **SAX Parser**:
    * startPrefixMapping(), startElement(), endElement(), endPrefixMapping()
