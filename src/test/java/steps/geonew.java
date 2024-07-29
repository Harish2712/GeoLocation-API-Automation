package steps;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.JsonUtils1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class geonew {
	 private Response response;
	   // private String apiKey = "AIzaSyBHAWAFxNJT2PKqE_l7LgvOU-aFSIdDj0Y";
	    private String baseUrl = "https://www.googleapis.com/geolocation/v1/geolocate/";
	    private Map<String, Object> requestBody;

	    @Given("the user provides geolocation data from {string}")
	    public void theUserProvidesGeolocationDataFrom(String jsonFilePath) throws IOException {
	        requestBody = JsonUtils1.readJsonFileToMap(jsonFilePath);
	        RestAssured.baseURI = baseUrl;
	    }

	    @When("the user sends a request to the geolocation API")
	    public void theUserSendsARequestToTheGeolocationAPI() {
	        RequestSpecification request = given().log().all().queryParam("key","AIzaSyBHAWAFxNJT2PKqE_l7LgvOU-aFSIdDj0Y").header("Content-Type", "application/json")
	                                              .body(requestBody);

	        response = request.when().post().then().log().all().extract().response();
	    }

	    @Then("the API should return a valid geolocation response")
	    public void theAPIShouldReturnAValidGeolocationResponse() {
	        response.then().statusCode(200);
	        // Example assertion, update based on actual API response
	        response.then().body("location.lat", equalTo(12.9400835F));
	        response.then().body("location.lng", equalTo(80.15708F));
	    }

	    @Then("the API should return an error response")
	    public void theAPIShouldReturnAnErrorResponse() {
	        response.then().statusCode(400);
	        // Example assertion, update based on actual API response
	        Assert.assertTrue(response.body().asString().contains("error"));
	    }
	
}
