package shgo.innowise.trainee.covidapi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.util.Map.entry;

@QuarkusTest
public class StatisticControllerTest {

    @Test
    public void getCountriesStatisticShouldReturnStatistic() {
        Map<String, Object> params = Map.ofEntries(
                entry("countries", "belarus"),
                entry("from", "2022-04-20T00:00:00.000Z"),
                entry("to", "2022-04-23T00:00:00.000Z"));

        given()
                .when().queryParams(params)
                .get("/statistics")
                .then()
                .statusCode(200);
    }

    @Test
    public void getCountriesWithInvalidCountryStatisticShouldBadRequest() {
        Map<String, Object> params = Map.ofEntries(
                entry("countries", "abc"),
                entry("from", "2022-04-20T00:00:00.000Z"),
                entry("to", "2022-04-23T00:00:00.000Z"));

        given()
                .when().queryParams(params)
                .get("/statistics")
                .then()
                .statusCode(400);
    }

    @Test
    public void getCountriesWithInvalidTimeStatisticShouldBadRequest() {
        Map<String, Object> params = Map.ofEntries(
                entry("countries", "belarus"),
                entry("from", "2022-04-26T00:00:00.000Z"),
                entry("to", "2022-04-23T00:00:00.000Z"));

        given()
                .when().queryParams(params)
                .get("/statistics")
                .then()
                .statusCode(400);
    }
}
