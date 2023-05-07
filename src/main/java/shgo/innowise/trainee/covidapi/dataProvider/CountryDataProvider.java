package shgo.innowise.trainee.covidapi.dataProvider;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import shgo.innowise.trainee.covidapi.entity.Country;

import java.util.List;

/**
 * Provides data of countries that are allowed in covid API.
 */
@RegisterRestClient(configKey = "covid-api")
public interface CountryDataProvider {

    /**
     * Gets countries allowed in covid API.
     *
     * @return list of countries
     */
    @Path("/countries")
    @GET
    List<Country> getAllCountries();
}
