# Jackson JSON Processor Wiki
* Jackson is a multi-purpose Java library for processing JSON data format

## JSON Three Ways
* Jackson offers three alternative methods for processing JSON:
    * Streaming API
    * Data Binding
    * Tree Model
    
## JacksonMixInAnnotations
* Before version 1.2 configuring serialization could only be done using one of 2 ways:
    * Modify bean classes by adding *annotations*
    * Writing custom serializers/deserializers
    
* Mix-in annotation: a way to associate annotations with classes, without modify (target) classes themselves:
    * Define that annotations of a *mix-in class* (or interface)
    * Will be used with a *target class* (or interface)
    * As if the *target class* had all annotations that the *mix-in* class has

## Jackson Core (Data-Binding) Annotations
* *Annotation class: meta annotations*
    * @JacksonAnnotation: marker annotation added to all annotation types Jackson provides
    * @JacksonAnnotationsInside: mark that can be used to defined Annotation Bundles, annotations used only as annotation containers
    
* *Annotation class: general*
    * @JsonAutoDetect (class): which kinds of methods (setters, getters, creators) can be auto-detected
    * @JsonIgnore (method/field): used to completely disregard annotated method, regardless of auto-detection or other annotations
    * @JsonProperty (method, field): can be used to denote:
        * Property to serialize (when applied to a *getter* method)
        * Property to deserialize (when applied to a *setter* method)
        * Field-backed property to serialize and deserialize (when applied to a non-static member field)
        * Takes optional property name parameter, omitting the parameter results in property name defaulting to method/field name
    * @JsonIgnoreProperties (class): used to indicate that certain properties are to be ignored for serialization and/or deserialization
    * @JsonUnwrapped (property): properties that are marked with this annotation will be *unwrapped*
    * @JsonIdentityInfo: used to define that a type (when added to Class) or property (when added to property) should be serialized/deserialized with additional Object Identifier
    * @JsonNaming: allows overriding the default PropertyNamingStrategy on per-class basis
    
* *Annotation class: Polymorphic type handling*    
    * @JsonTypeInfo (class): used to enable polymorphic type handling for a type and its subtypes
    
* *Annotation class: Instance dependencies*
    * @JsonManagedReference and @JsonBackReference
    
* *Annotation class: serialization*
    * @JsonValue (method): used to mark a method that return value is to be used as serialization for the object
    * @JsonSerialize (method, field): can be used to denote:
        * Explicit serializer to use
        * Explicit type to use
        * Which bean properties to include
    * @JsonPropertyOrder (class): can be used to indicate explicit ordering for properties on serialization
    * @JsonView (method, field): can be used to indicate whether associated property is part of specific JSON View
    * @JsonFilter (class): indicates which BeanPropertyFilter to use for dynamic filtering of properties of annotated class
    * @JsonIgnoreType (class): indicate that properties with annotated type are never to be serialized
    
* *Annotation class: deserialization*
    * @JsonArraySetter (method): used to mark 2-argument method to call when an unknown property is encountered
    * @JsonCreator (method): used to mark static methods to use for instantiating instances of type that contains method
    * @JsonDeserialize (method, field): used to denote:
        * Explicit deserializer
        * Explicit types to use with property
    * @JacksonInject (method, property, constructor): used to mark properties for which value can be *injected*
    * @JsonPOJOBuilder (class): used to customize details of Builder objects

## Using JAXB annotations with Jackson
