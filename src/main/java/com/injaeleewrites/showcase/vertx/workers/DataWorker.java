package com.injaeleewrites.showcase.vertx.workers;

import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import javax.xml.crypto.Data;

/**
 * @author eksor
 * @since 20150701
 */
public class DataWorker implements Handler<Message<String>> {
    private static final Logger logger = LoggerFactory.getLogger(DataWorker.class);

    @Override
    public void handle(Message<String> msg) {

        logger.info("Message retrieved is '" + msg.body() + "' with address '" + msg.address() + "'.");
        msg.reply("Got msg '" + msg + "'");
    }
}
