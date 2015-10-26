# 12 - Support for Media Type in Jersey

# 1. Which modules does Jersey integrate with to provide JSON support?
* MOXy - default and preferred way of supporting JSON binding. When JSON MOXy is on the class-path, Jersey will automatically discover the module and seamlessly enable JSON binding support
* Java API for JSON Processing (JSON-P)
* Jackson
* Jettison

# 2. Basic approaches when working with JSON representations
* POJO based JSON binding support
* JAXB based JSON binding support
* Low-level JSON parsing & processing support

# 3. Which Media modules does POJO approach support?
* MOXy and Jackson

# 4. Example of JAXB bean used to generate JSON representation
* @GET
* @Produces("application/json")

# 5. Which media modules support JAXB approach?
* MOXy, Jackson, Jettison

# 6.Media modules that support the low-level JSON parsing and generating approach?
* JSON-P and Jettison

# 7. Which media module is more preferrable to use for low-level JSON parsing?
* JSON-P

# 8. Advatages of using low-level APIs
* Full control over the JSON format produced and consumed
* Produce/Consume very large JSON structures using streaming JSON parser/generator AIP

# 9. Disadvantages of using low-level APIs
* More complex compared with POJO or JAXB based bindings

# 10. Example of constructing a JsonObject using JSON-Processing?
* JsonObject jsonObject = Json.createObjectBuilder()
    .add("name", "A")
    .add("age", 20).build;

# 11. Example of constructing a JSONObject using Jettison
* JSONObject object = new JSONObject();
  object.put("name", "A");
  object.put("age", 20);

# 12. Should Features be registered in client,server Configurable with MOXy media module?
* No, this feature is automatically discovered and registered when you add jersey-media-moxy module to your class path

# 13. Properties of the auto-discoverable jersey-media-moxy module that can be used to control the automatic registration of MoxyJsonFeature
* CommonProperties.MOXY_JSON_FEATURE_DISABLE
* ServerProperties.MOXY_JSON_FEATURE_DISABLE
* ClientProperties.MOXY_JSON_FEATURE_DISABLE

# 14. Does manual registration of any other Jersey JSON provider feature disable the automated enabling and configuration of MoxyJsonFeature?
* Yes, except for JSONP

# 15. How configure MessageBodyReader<T>/MessageBodyWriter<T> provided by MOXy?
* Create an instance of MoxyJsonConfig and set values of needed properties

# 16. Example of setting properties to MoxyJsonConfig

# 17. How to make MoxyJsonConfig visible for MOXy?
* Create and register ContextResolver<T> in your client/server code

# 18. Example of creating ContextResolver<MoxyJsonConfig>

# 19. Ways of setting configuration properties to the underlying MOXyJsonProvider
* set them to MoxyJsonConfig
* set them directly into the Configurable instance

# 20. Example of setting properties for MOXy providers into Configurable
* new ResourceConfig().property()

# 21. Default property values for MOXy MessageBodyReader<T>/MessageBodyWriter<T>

# 22. Example of building client with MOXy JSON feature enabled
* Client client = ClientBuilder.newBuilder()
    .register(MoxyJsonFeature.class)
    .register(JsonMoxyConfigurationContextResolver.class)
    .build();

# 23. Example of creating JAX-RS application with MOXy JSON feature enabled
* Application app = new ResourceConfig().
    packages("org.glassfish.jersey.examples.jsonmoxy")

# 24. Should Feature(JsonProcessingFeature) of JSON-Processing media module be explicitly registered in client/server Configurable?
 * No, as this feature is automatically discovered and registered when you add jersey-media-json-processing module to your classpath

# 25. Special properties of jersey-media-json-processing that can affect the registration of JsonProcessingFeature



