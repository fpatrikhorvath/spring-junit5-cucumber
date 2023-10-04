package com.opus.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

/**
 * A utility class for making HTTP requests using RestAssured.
 */
@Component
public class RestAssuredSteps {
    private RequestSpecification requestSpec;

    public RestAssuredSteps(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        requestSpec = builder.build();
    }

    /**
     * Sets the base URI and path for the API requests.
     *
     * @param uri  The base URI to be used for API requests.
     * @param path The base path to be used for API requests.
     */
    public void setUriAndPath(String uri, String path) {
        requestSpec.baseUri(uri);
        requestSpec.basePath(path);
    }

    /**
     * Sends a RestAssured GET request to the specified endpoint.
     *
     * @param endpoint The URL endpoint to send the GET request to.
     * @return The response received from the server.
     */
    public Response sendGetRequest(String endpoint) {
        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint);
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
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(endpoint);
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
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint);
    }

    /**
     * Sends a RestAssured DELETE request to the specified endpoint.
     *
     * @param endpoint The URL endpoint to send the DELETE request to.
     * @return The response received from the server.
     */
    public Response sendDeleteRequest(String endpoint) {
        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint);
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
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .patch(endpoint);
    }
}