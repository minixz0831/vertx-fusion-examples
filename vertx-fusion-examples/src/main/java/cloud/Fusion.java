package cloud;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpRequest;
import jmc.api.fusion.FusionApi;

import java.util.UUID;

public class Fusion implements FusionApi {
    @Override
    public HttpRequest<Buffer> stet(HttpRequest<Buffer> bufferHttpRequest) {
        return bufferHttpRequest;
    }

    @Override
    public HttpRequest<Buffer> auth(JsonObject authOptions, HttpRequest<Buffer> bufferHttpRequest) {
        String authType = authOptions.getString("authType", "BASIC");
        String username = authOptions.getString("username","nobody");
        String password = authOptions.getString("password", UUID.randomUUID().toString());
        if ("BASIC".equalsIgnoreCase(authType)) {
            return bufferHttpRequest.basicAuthentication(username, password);
        }
        return bufferHttpRequest;
    }
}
