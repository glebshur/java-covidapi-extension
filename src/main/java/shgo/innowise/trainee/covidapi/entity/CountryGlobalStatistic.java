package shgo.innowise.trainee.covidapi.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Country covid statistic for specified period of time.
 */
@RegisterForReflection
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryGlobalStatistic {

    public String country;
    public int minConfirmed;
    public int maxConfirmed;

}
