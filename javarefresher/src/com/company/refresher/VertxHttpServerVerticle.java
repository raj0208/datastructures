package com.company.refresher;

//import io.vertx.core.Promise;
//import io.vertx.core.http.HttpServer;
//import io.vertx.core.AbstractVerticle;
//import io.vertx.core.http.HttpServerResponse;

public class VertxHttpServerVerticle {
//        extends AbstractVerticle {
//    private HttpServer httpServer = null;
//
//    @Override
//    public void start(Promise<Void> startPromise) throws Exception {
//        //super.start(startPromise);
//        httpServer = vertx.createHttpServer();
//        requestHandler();
//        httpServer.listen(9999);
//    }
//
//    @Override
//    public void stop(Promise<Void> stopPromise) throws Exception {
//        //super.stop(stopPromise);
//        httpServer.close();
//    }
//
//    private void requestHandler() {
//        httpServer.requestHandler(httpServerRequest -> {
//            System.out.println("incoming request");
//            System.out.println("httpServerRequest.uri = " + httpServerRequest.uri());
//            System.out.println("httpServerRequest.path() = " + httpServerRequest.path());
//
//            HttpServerResponse response = httpServerRequest.response();
//
//            response.setStatusCode(200);
//            response.headers()
//                    .add("Content-Type", "text/html");
//            response.write("Vertx is alive");
//            response.end("Vert.x daa ended");
//        });
//    }
}
