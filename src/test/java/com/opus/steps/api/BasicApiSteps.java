package com.opus.steps.api;

import com.opus.api.RestAssuredSteps;
import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class BasicApiSteps extends RestAssuredSteps{
    Response response;


    /**
     * Sets the base URI and the base path to the given value for the Rest Assured.
     *
     * @param uri  is the new URI.
     * @param path is the new path.
     */
    @Given("I set the base uri to {string} and the base path to {string}")
    public void iSetTheBaseUriToAndTheBasePathTo(String uri, String path) {
        setUriAndPath(uri,path);
    }

    /**
     * Sets the redirection follow to the given state.
     *
     * @param followRedirect is the boolean value of the redirect state.
     */
    @Given("I set the automatic redirect to {string}")
    public void iTurnOffTheAutomaticRedirect(String followRedirect) {
        boolean isFollowRedirect = Boolean.parseBoolean(followRedirect);
        RedirectConfig redirectConfig = RedirectConfig.redirectConfig().followRedirects(isFollowRedirect);
        RestAssured.config = RestAssured.config().redirect(redirectConfig);
    }

    /**
     * Sends a GET request to the specified endpoint.
     *
     * @param endpoint is the endpoint.
     */
    @Given("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        response = sendGetRequest(endpoint);
    }

    /**
     * Asserts that the response code is the same as the expected.
     *
     * @param expectedResponseCode is the expected response code.
     */
    @Then("I see {int} as response code")
    public void iSeeAsResponseCode(int expectedResponseCode) {
        int actualResponseCode = response.getStatusCode();
        String message = "The expected status code is not matching with the actual.";
        assertEquals(expectedResponseCode, actualResponseCode, message);
    }

    /**
     * Only for development purposes, prints the response headers and then the bodies.
     */
    @Then("I want to see the response in the logs")
    public void iWantToSeeTheResponseInTheLogs() {
        System.out.println("----------------------------- Headers -----------------------------");
        System.out.println(response.getHeaders().asList());
        System.out.println("-------------------------- Response Body --------------------------");
        System.out.println(response.getBody().asString());
        System.out.println("-------------------------------------------------------------------");
    }
}
