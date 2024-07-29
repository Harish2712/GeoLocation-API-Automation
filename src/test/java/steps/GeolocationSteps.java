package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

public class GeolocationSteps {

    /*public Response response;
    public String baseUrl = "https://www.googleapis.com/geolocation/v1/geolocate?key=API_KEY";

    @Given("the user provides geolocation data for positive scenarios")
    public void theUserProvidesGeolocationDataForPositiveScenarios() {
        RestAssured.baseURI = baseUrl;
    }

    @When("the user sends a request to the geolocation API with positive data {int}")
    public void theUserSendsARequestToTheGeolocationAPIWithPositiveData(int index) {
        Map<String, Object> requestBody = Hooks.positiveTestData.get(index);

        RequestSpecification request = given().header("Content-Type", "application/json")
                                              .body(requestBody);
        System.out.println(request);

        response = request.when().post();
    }

    @Then("the API should return a valid geolocation response")
    public void theAPIShouldReturnAValidGeolocationResponse() {
        //response.then().statusCode(200);
        // Example assertion, update based on actual API response
        response.then().body("location.lat", equalTo(12.9716f));
        response.then().body("location.lng", equalTo(77.5946f));
    }

    @Given("the user provides geolocation data for negative scenarios")
    public void theUserProvidesGeolocationDataForNegativeScenarios() {
        RestAssured.baseURI = baseUrl;
    }

    @When("the user sends a request to the geolocation API with negative data {int}")
    public void theUserSendsARequestToTheGeolocationAPIWithNegativeData(int index) {
        Map<String, Object> requestBody = Hooks.negativeTestData.get(index);

        RequestSpecification request = given().header("Content-Type", "application/json")
                                              .body(requestBody);

        response = request.when().post();
    }

   /* @Then("the API should return an error response")
    public void theAPIShouldReturnAnErrorResponse() {
        response.then().statusCode(400);
        // Example assertion, update based on actual API response
        Assert.assertTrue(response.body().asString().contains("error"));
    }*/
}
