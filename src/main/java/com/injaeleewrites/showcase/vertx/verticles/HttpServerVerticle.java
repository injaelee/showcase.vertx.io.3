package com.injaeleewrites.showcase.vertx.verticles;

import com.injaeleewrites.showcase.vertx.handlers.GetFetchHandler;
import com.injaeleewrites.showcase.vertx.handlers.PostDataHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * @author eksor
 * @since 20150701
 */
public class HttpServerVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {
        Router router = setupRouter();

        HttpServer server = getVertx().createHttpServer();
        server.requestHandler(router::accept).listen(10080);
    }

    private Router setupRouter() {
        Router router = Router.router(vertx);

        router.route(HttpMethod.GET, "/v1/fetch/:id")
                .handler(new GetFetchHandler());

        router.route(HttpMethod.POST, "/v1/fetch/:id")
                .handler(new PostDataHandler(getVertx().eventBus()));

        return router;
    }
}
