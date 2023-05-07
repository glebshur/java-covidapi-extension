package shgo.innowise.trainee.covidapi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CountryControllerTest {

    @Test
    public void getCountriesShouldReturnCountries() {
        given()
                .when().get("/countries/all")
                .then()
                .statusCode(200);
    }

}