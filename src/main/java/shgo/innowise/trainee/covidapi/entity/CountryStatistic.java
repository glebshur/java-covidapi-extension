package shgo.innowise.trainee.covidapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * County covid confirmed statistic for specified date.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryStatistic {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("Cases")
    private int confirmed;
    @JsonProperty("Date")
    private Instant date;

}
