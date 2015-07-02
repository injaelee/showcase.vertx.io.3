package com.injaeleewrites.showcase.vertx.handlers;

import io.vertx.core.Handler;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

/**
 * @author eksor
 * @since 20150701
 */
public class GetFetchHandler implements Handler<RoutingContext> {
    private static Logger logger = LoggerFactory.getLogger(GetFetchHandler.class);

    @Override
    public void handle(RoutingContext ctx) {
        String lookupId = ctx.request().getParam("id");
        logger.info("[GetFetchHandler] We've obtained lookup Id [" + lookupId + "]");

        ctx.response().end("Lookup ID is [" + lookupId + "]\n");
    }
}
