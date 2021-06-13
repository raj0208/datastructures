package com.company.refresher;

import io.vertx.core.AbstractVerticle;

public class BasicVerticles extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        //super.start();
        System.out.println("Basic Verticle started!");
//        System.out.println("deploying another verticle");
//        vertx.deployVerticle(new MyVerticle(), stringAsyncResult -> {
//            System.out.println("MyVerticle deployed");
//        });
    }

    @Override
    public void stop() throws Exception {
        //super.stop();
        System.out.println("Basic Verticle stopped!");

    }
}
