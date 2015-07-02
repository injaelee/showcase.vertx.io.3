package com.injaeleewrites.showcase.vertx.verticles;

import com.injaeleewrites.showcase.vertx.helpers.EventBusNames;
import com.injaeleewrites.showcase.vertx.workers.DataWorker;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * @author eksor
 * @since 20150701
 */
public class DataWorkerVerticle extends AbstractVerticle {
    private static Logger logger = LoggerFactory.getLogger(DataWorkerVerticle.class);

    @Override
    public void start(Future<Void> future) throws Exception {
        setupEventBusHandler();
    }

    private void setupEventBusHandler() {
        long waitFactor = 0;
        String waitFactorStr = System.getProperty("wait.factor");
        if (waitFactorStr != null) {
            waitFactor = Long.parseLong(waitFactorStr);
        }
        logger.info("Wait factor is set to [" + waitFactor + "] given string value '" + waitFactorStr + "'");
        getVertx().eventBus().consumer(EventBusNames.POST_DATA, new DataWorker(waitFactor));
    }
}
