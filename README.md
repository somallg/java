# logger-injector: Inject Logger using Annotation 
===================

# What is it?
* This example demonstrates the use of Spring `BeanPostProcessor`, `ReflectionUtils` and Java Annotations to create and inject a new Logger instance at runtime
* So instead of declare your Logger like this every time:
```
    private Logger logger = LoggerFactory.getLogger(getClass())
```
* You can simply now use annotation to do the same thing
```
    @InjectLogger
    private Logger logger;
```

# Build
* mvn clean package -DskipTests=true

# Run Test
* mvn test
