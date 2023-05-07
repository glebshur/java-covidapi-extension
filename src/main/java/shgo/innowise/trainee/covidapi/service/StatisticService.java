package shgo.innowise.trainee.covidapi.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import shgo.innowise.trainee.covidapi.dataProvider.CountryStatisticDataProvider;
import shgo.innowise.trainee.covidapi.entity.CountryGlobalStatistic;
import shgo.innowise.trainee.covidapi.entity.CountryStatistic;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents statistic business logic.
 */
@ApplicationScoped
public class StatisticService {

    @RestClient
    CountryStatisticDataProvider statisticDataProvider;

    /**
     * Gets global statistic for each country in specified period of time.
     *
     * @param countries countries names
     * @param from      start interval
     * @param to        end interval
     * @return          list of global statistic
     */
    public List<CountryGlobalStatistic> getCountriesGlobalStatistic(List<String> countries,
                                                                    Instant from,
                                                                    Instant to){
        Instant periodStart = from.minus(1, ChronoUnit.DAYS);

        var countriesGlobalStatistic = new ArrayList<CountryGlobalStatistic>();
        for(String country : countries){
            CountryGlobalStatistic globalStatistic = calculateGlobalStatistic(
                    statisticDataProvider.getCountryStatistics(country, periodStart.toString(), to.toString()));

            if(globalStatistic != null){
                countriesGlobalStatistic.add(globalStatistic);
            }
        }
        return countriesGlobalStatistic;
    }

    /**
     * Calculates global dayly statistic.
     *
     * @param countryStatistics list of country statistic
     * @return                  global country statistic
     */
    private CountryGlobalStatistic calculateGlobalStatistic(List<CountryStatistic> countryStatistics){

        String country = "";
        int minConfirmed = Integer.MAX_VALUE;
        int maxConfirmed = 0;

        if(countryStatistics.isEmpty()){
            return null;
        }

        for(int i = 1; i < countryStatistics.size() - 1; i++){
            int confirmedPerDay = countryStatistics.get(i).getConfirmed()
                    - countryStatistics.get(i -1).getConfirmed();

            if(confirmedPerDay > maxConfirmed){
                maxConfirmed = confirmedPerDay;
                country = countryStatistics.get(i).getCountry();
            }

            if(confirmedPerDay < minConfirmed){
                minConfirmed = confirmedPerDay;
                country = countryStatistics.get(i).getCountry();
            }
        }

        return new CountryGlobalStatistic(country, minConfirmed, maxConfirmed);
    }
}
