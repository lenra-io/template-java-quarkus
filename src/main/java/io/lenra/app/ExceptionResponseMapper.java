package io.lenra.app;

import io.lenra.app.exception.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionResponseMapper implements ExceptionMapper<Exception> {
  @Override
  public Response toResponse(Exception exception) {
    // Use response from WebApplicationException as they are
    if (exception instanceof NotFoundException) {
      return Response.status(404).entity(exception.getMessage()).build();
    }
    // Use 500 (Internal Server Error) for all other
    else {
      return Response.serverError().entity(exception).build();
    }
  }
}
