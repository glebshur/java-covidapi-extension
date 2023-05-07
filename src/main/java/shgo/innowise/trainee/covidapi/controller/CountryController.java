package shgo.innowise.trainee.covidapi.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import shgo.innowise.trainee.covidapi.service.CountryService;

/**
 * Represents country controller.
 */
@Path("/countries")
public class CountryController {

    @Inject
    CountryService countryService;

    /**
     * Gets countries that are allowed in API.
     *
     * @return response with countries
     */
    @GET
    @Path("/all")
    public Response getCountries() {
        var countries = countryService.getAll();
        return Response.ok(countries).build();
    }
}
