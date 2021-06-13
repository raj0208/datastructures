package com.company.refresher;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class MyVerticle extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
//        super.start(startPromise);
        System.out.println("MyVerticle started!");
    }


    @Override
    public void stop(Promise<Void> stopPromise) throws Exception {
//        super.stop(stopPromise);
        System.out.println("MyVerticle stopped!");
    }

}
