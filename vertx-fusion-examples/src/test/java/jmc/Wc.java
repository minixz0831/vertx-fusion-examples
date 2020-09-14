package jmc;

import cloud.Fusion;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import org.junit.Test;

public class Wc extends Noop {
    @Test
    public void wc(TestContext ctx) {
        WebClientOptions wcopts = new WebClientOptions(new JsonObject());

        WebClient wc = WebClient.create(vertx, wcopts);
        new Fusion().auth(new JsonObject(),
                wc.getAbs("http://www.kernel.org"))
                .send(ctx.asyncAssertSuccess(ok -> log.info(ok.bodyAsString())));
    }

}
