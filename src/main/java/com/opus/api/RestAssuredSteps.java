package com.opus.api;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class RestAssuredSteps{
    public Response sendGetRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
