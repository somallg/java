# Configure AEM for Debug mode
* Start CQ and adding those options
```
java -Xdebug -Xrunjdwp:transport=dt_socket,address=30303,suspend=n,server=y -Xmx1024m -XX:MaxPermSize=256M -jar cq-quickstart-6.0.0.jar
```

* You can also add these options to your start script in crx-quickstart/bin/start
``` 
if [ -z "$CQ_JVM_OPTS" ]; then
    CQ_JVM_OPTS='-server -Xmx1024m -XX:MaxPermSize=256M -Djava.awt.headless=true'
fi
 
CQ_JVM_OPTS="$CQ_JVM_OPTS -Xdebug -Xrunjdwp:transport=dt_socket,address=30303,suspend=n,server=y"
```