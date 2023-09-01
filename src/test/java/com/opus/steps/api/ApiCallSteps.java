package com.opus.steps.api;

import com.opus.api.RestAssuredSteps;
import io.restassured.RestAssured;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
public class ApiCallSteps {
    @Autowired
    private RestAssuredSteps restAssuredSteps;
    Response response;
    String baseUri, basePath;

    @Given("I set the base uri to {string} and the base path to {string}")
    public void iSetTheBaseUriToAndTheBasePathTo(String uri, String path) {
        baseUri = uri;
        basePath = path;
    }

    @Given("I set the automatic redirect to {string}")
    public void iTurnOffTheAutomaticRedirect(String followRedirect) {
        boolean isFollowRedirect = Boolean.parseBoolean(followRedirect);
        RedirectConfig redirectConfig = RedirectConfig.redirectConfig().followRedirects(isFollowRedirect);
        RestAssured.config = RestAssured.config().redirect(redirectConfig);
    }

    @Given("I send a GET request to the {string} endpoint")
    public void iSendAGETRequestToTheEndpoint(String endpoint) {
        response = restAssuredSteps.sendGetRequest(baseUri + basePath + endpoint);
    }

    @Then("I see {int} as response code")
    public void iSeeAsResponseCode(int expectedResponseCode) {
        int actualResponseCode = response.getStatusCode();
        String message = "The expected status code is not matching with the actual.";
        assertEquals(expectedResponseCode, actualResponseCode, message);
    }

    @Then("I want to see the response in the logs")
    public void iWantToSeeTheResponseInTheLogs() {
        System.out.println("----------------------------- Headers -----------------------------");
        System.out.println(response.getHeaders().asList());
        System.out.println("-------------------------- Response Body --------------------------");
        System.out.println(response.getBody().asString());
        System.out.println("-------------------------------------------------------------------");
    }

    @And("I want to see the thread id in the log")
    public void iWantToSeeTheThreadIdInTheLog() {
        System.out.println("------------" + Thread.currentThread().getId() + "-----------------");

    }
}
