package shgo.innowise.trainee.covidapi.exception;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

/**
 * Provides responses exception mapping of requests to covid api.
 */
@Slf4j
@Provider
public class CovidApiResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    /**
     * Maps responses errors.
     *
     * @param response  response with error
     * @return          exception
     */
    @Override
    public RuntimeException toThrowable(Response response) {
        log.error("Response status: " + response.getStatus());
        switch (response.getStatus()) {
            case 404 -> throw new BadRequestException("Data is invalid and couldn't be found");
            case 429 -> throw new InternalServerErrorException("Too many request to covid api");
        }
        return null;
    }
}
