package com.injaeleewrites.showcase.vertx.verticles;

import com.injaeleewrites.showcase.vertx.helpers.EventBusNames;
import com.injaeleewrites.showcase.vertx.workers.DataWorker;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * @author eksor
 * @since 20150701
 */
public class DataWorkerVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {
        setupEventBusHandler();
    }

    private void setupEventBusHandler() {
        getVertx().eventBus().consumer(EventBusNames.POST_DATA, new DataWorker());
    }
}
