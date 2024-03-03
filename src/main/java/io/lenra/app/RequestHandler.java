package io.lenra.app;

import io.lenra.api.AppRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/{path:.*}")
public class RequestHandler {
    @Inject
    private LenraApplication app;

    @POST
    public Object post(AppRequest request) {
        System.out.println(request);
        return app.handle(request);
    }
}
