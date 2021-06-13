package com.company.refresher;

import io.vertx.core.Vertx;

public class VertxRefresher {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();
        deployingVerticles(vertx);
//        eventBus(vertx);
        //deployHttpServer(vertx);
    }

    private static void deployHttpServer(Vertx vertx) {
        //vertx.deployVerticle(new VertxHttpServerVerticle());
    }

    private static void deployingVerticles(Vertx vertx) {
        vertx.deployVerticle(new MyVerticle());
        vertx.deployVerticle("com.company.refresher.MyVerticle");
        vertx.deployVerticle(new BasicVerticles(), stringAsyncResult -> {
            System.out.println("Basic verticle deployment completed");
        });
    }

    private static void eventBus(Vertx vertx) throws InterruptedException {
        vertx.deployVerticle(new EventBusReceiverVerticle("R1"));
        vertx.deployVerticle(new EventBusReceiverVerticle("R2"));

        Thread.sleep(3000);
        vertx.deployVerticle(new EventBusSenderVerticle());
    }
}
