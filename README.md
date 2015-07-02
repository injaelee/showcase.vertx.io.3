# showcase.vertx.io.3

## Running the Showcase
```
java -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory \
-jar target/vertx.io.3-1.0-SNAPSHOT-uber.jar
```

## Test with Apache AB

```
-- you need to create post.data file with the post data
-- note the negative correlation between throughput and number of connections after the tipping point of 5
ab -n 10000 -c 5 -p post.data -T application/json "http://localhost:10080/v1/fetch/1"
```
