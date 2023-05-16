package io.vertx.book.http;

import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.ext.web.Router;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/")
                .handler(rc -> rc.response().end("Hello from Vert.x!"));
        router.get("/:name")
                .handler(rc -> rc.response().end("Hello " + rc.pathParam("name") + " from Vert.x!"));
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept);
        server.rxListen(8080).subscribe();
    }
}
