package com.company.refresher;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class EventBusReceiverVerticle extends AbstractVerticle {

    private String name = null;

    public EventBusReceiverVerticle(String name) {
        this.name = name;
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        //super.start(startPromise);
        vertx.eventBus().consumer("address", message -> {
            System.out.println(this.name +" received message.body() = " + message.body());
        });
    }
}
