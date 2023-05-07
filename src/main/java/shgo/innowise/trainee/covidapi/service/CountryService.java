package shgo.innowise.trainee.covidapi.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import shgo.innowise.trainee.covidapi.dataProvider.CountryDataProvider;
import shgo.innowise.trainee.covidapi.entity.Country;

import java.util.List;

/**
 * Provides country business logic.
 */
@ApplicationScoped
public class CountryService {

    @RestClient
    CountryDataProvider countryDataProvider;

    /**
     * Gets all allowed countries in API.
     *
     * @return list of countries
     */
    public List<Country> getAll() {
        return countryDataProvider.getAllCountries();
    }
}
