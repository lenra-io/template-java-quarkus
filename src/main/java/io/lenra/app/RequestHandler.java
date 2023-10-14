package io.lenra.app;

import io.lenra.app.request.AppRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/{path:.*}")
public class RequestHandler {
    @Inject
    private LenraApplication app;

    @POST
    public Object post(AppRequest<?> request) {
        return request.handle(app);
    }
}
