package com.opus.api;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

/**
 * A utility class for making HTTP requests using RestAssured.
 */
@Component
public class RestAssuredSteps {
    /**
     * Sends a RestAssured GET request to the specified endpoint.
     *
     * @param endpoint The URL endpoint to send the GET request to.
     * @return The response received from the server.
     */
    public Response sendGetRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a RestAssured POST request to the specified endpoint with the given request body.
     *
     * @param endpoint    The URL endpoint to send the POST request to.
     * @param requestBody The request body to include in the POST request.
     * @return The response received from the server.
     */
    public Response sendPostRequest(String endpoint, String requestBody) {
        return given()
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a RestAssured PUT request to the specified endpoint with the given request body.
     *
     * @param endpoint    The URL endpoint to send the PUT request to.
     * @param requestBody The request body to include in the PUT request.
     * @return The response received from the server.
     */
    public Response sendPutRequest(String endpoint, String requestBody) {
        return given()
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a RestAssured DELETE request to the specified endpoint.
     *
     * @param endpoint The URL endpoint to send the DELETE request to.
     * @return The response received from the server.
     */
    public Response sendDeleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    /**
     * Sends a RestAssured PATCH request to the specified endpoint with the given request body.
     *
     * @param endpoint    The URL endpoint to send the PATCH request to.
     * @param requestBody The request body to include in the PATCH request.
     * @return The response received from the server.
     */
    public Response sendPatchRequest(String endpoint, String requestBody) {
        return given()
                .body(requestBody)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }
}
