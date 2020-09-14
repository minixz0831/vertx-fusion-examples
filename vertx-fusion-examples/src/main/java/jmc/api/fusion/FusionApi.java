package jmc.api.fusion;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpRequest;

public interface FusionApi {
    public HttpRequest<Buffer> stet(HttpRequest<Buffer> bufferHttpRequest);
    public HttpRequest<Buffer> auth(JsonObject authOptions, HttpRequest<Buffer> bufferHttpRequest);
}
