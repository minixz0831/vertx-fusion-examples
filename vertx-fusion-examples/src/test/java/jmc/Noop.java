package jmc;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.ext.web.client.WebClientOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;
import java.util.logging.Logger;

@RunWith(VertxUnitRunner.class)
public class Noop {
    Logger log = Logger.getLogger(Noop.class.getName());
    Vertx vertx = Vertx.vertx();

    @Test
    public void noop(TestContext ctx) {
        String address = UUID.randomUUID().toString();
        vertx.eventBus().localConsumer(address, message -> {
            message.reply("ok");
        });
        vertx.eventBus().request(address, "", new DeliveryOptions(),ctx.asyncAssertSuccess(ok -> {
            log.info("ok");
        }));
    }


}
