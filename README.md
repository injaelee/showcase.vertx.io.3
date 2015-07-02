# showcase.vertx.io.3

## Running the Showcase
```
java -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory \
-jar target/vertx.io.3-1.0-SNAPSHOT-uber.jar
```

## Test with Apache AB
```
ab -n 10000 -c 10 -p post.data -T application/json "http://localhost:10080/v1/fetch/1"
```
