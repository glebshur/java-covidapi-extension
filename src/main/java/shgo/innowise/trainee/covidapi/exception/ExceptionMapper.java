package shgo.innowise.trainee.covidapi.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

/**
 * Provides exception mapping to response.
 */
@Slf4j
public class ExceptionMapper {
    /**
     * Maps exception to response.
     *
     * @param exception server exception
     * @return response
     */
    @ServerExceptionMapper
    public Response mapException(WebApplicationException exception) {
        log.error(exception.getMessage());
        return Response.status(exception.getResponse().getStatus())
                .entity(exception.getMessage())
                .build();
    }
}
