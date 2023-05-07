package shgo.innowise.trainee.covidapi.dataProvider;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import shgo.innowise.trainee.covidapi.entity.CountryStatistic;

import java.util.List;

/**
 * Provides countries statistic from covid API.
 */
@RegisterRestClient(configKey = "covid-api")
public interface CountryStatisticDataProvider {

    /** Gets country statistic for specified period of time.
     *
     * @param countryCode   country code
     * @param from          start interval
     * @param to            end interval
     * @return              list of country statistics
     */
    @GET
    @Path("/country/{country}/status/confirmed")
    List<CountryStatistic> getCountryStatistics(@PathParam("country") String countryCode,
                                                @QueryParam("from") String from,
                                                @QueryParam("to") String to);
}
