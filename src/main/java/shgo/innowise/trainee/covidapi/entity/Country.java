package shgo.innowise.trainee.covidapi.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents covid API country.
 */
@RegisterForReflection
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("Slug")
    private String code;
}
