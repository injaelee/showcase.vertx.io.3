package com.injaeleewrites.showcase.vertx.workers;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.util.Random;

/**
 * @author eksor
 * @since 20150701
 */
public class DataWorker implements Handler<Message<String>> {
    private static final Logger logger = LoggerFactory.getLogger(DataWorker.class);

    private static final Random RANDOM = new Random();

    private final long waitFactor;

    public DataWorker(long waitFactor) {
        this.waitFactor = waitFactor;
    }

    private void randomWait() {

        if (waitFactor > 0) {
            long sleepTime = Math.abs((long)(RANDOM.nextGaussian() * 100L));
            logger.info("Sleeping for [" + sleepTime + "]ms");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void handle(Message<String> msg) {
        logger.info("Message retrieved is '" + msg.body() + "' with address '" + msg.address() + "'.");
        randomWait();
        msg.reply("Got msg '" + msg + "'");
    }
}
