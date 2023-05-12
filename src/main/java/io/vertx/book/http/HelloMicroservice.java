package io.vertx.book.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        vertx.createHttpServer()
            .requestHandler(r -> {
                String name = r.getParam("name");
                r.response().end("Hello " + name);
            })
            .listen(8080);
    }
}
