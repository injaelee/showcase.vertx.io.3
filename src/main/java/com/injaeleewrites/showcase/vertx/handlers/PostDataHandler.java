package com.injaeleewrites.showcase.vertx.handlers;

import com.injaeleewrites.showcase.vertx.helpers.EventBusNames;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

/**
 * @author eksor
 * @since 20150701
 */
public class PostDataHandler implements Handler<RoutingContext> {
    private static final Logger logger = LoggerFactory.getLogger(PostDataHandler.class);

    private final EventBus eventBus;

    public PostDataHandler(EventBus eb) {
        eventBus = eb;
    }

    @Override
    public void handle(RoutingContext routingContext) {
        routingContext.request().bodyHandler(buffer -> {
            eventBus.send(EventBusNames.POST_DATA, buffer.toString(), result -> {
                if (result.succeeded()) {
                    logger.info("[PostDataHandler] Retrieved message: [" + result.result() + "]");
                    routingContext.response().setStatusCode(200);
                    routingContext.response().end(result.result().toString());
                } else {
                    routingContext.response().setStatusCode(400);
                    routingContext.response().end();
                }
            });
        });
    }
}
