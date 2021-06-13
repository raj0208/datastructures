package com.company.refresher;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class EventBusSenderVerticle extends AbstractVerticle {



    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        //super.start(startPromise);
        vertx.eventBus().publish("address", "publish message 2");
        vertx.eventBus().send("address", "send message 1");
    }
}
