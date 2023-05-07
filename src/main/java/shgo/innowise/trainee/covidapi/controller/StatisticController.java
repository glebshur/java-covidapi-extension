package shgo.innowise.trainee.covidapi.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
import shgo.innowise.trainee.covidapi.entity.CountryGlobalStatistic;
import shgo.innowise.trainee.covidapi.service.StatisticService;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

/**
 * Represents countries statistic controller.
 */
@Path("/statistics")
public class StatisticController {

    @Inject
    StatisticService statisticService;

    /**
     * Gets global statistic to specified countries by specified period of time.
     *
     * @param countries countries names, separated with comma
     * @param from      start of period
     * @param to        end of period
     * @return          response with list of countries global statistic
     */
    @GET
    public Response getCountriesStatistic(@RestQuery String countries,
                                          @RestQuery Instant from,
                                          @RestQuery Instant to) {
        List<String> countriesList = Arrays.asList(countries.split(","));
        if(from.isAfter(to)){
            throw new BadRequestException("'From' cannot be after 'to'");
        }

        List<CountryGlobalStatistic> statistics = statisticService.getCountriesGlobalStatistic(countriesList, from, to);
        return Response.ok(statistics).build();
    }
}
