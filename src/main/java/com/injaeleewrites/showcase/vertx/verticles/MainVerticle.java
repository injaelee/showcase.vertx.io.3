package com.injaeleewrites.showcase.vertx.verticles;

import io.vertx.core.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * @author eksor
 * @since 20150701
 */
public class MainVerticle extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start(Future<Void> future) throws Exception {
        vertx.deployVerticle(HttpServerVerticle.class.getCanonicalName());
        vertx.deployVerticle(
                DataWorkerVerticle.class.getCanonicalName(),
                new DeploymentOptions().setInstances(10));
    }
}
