package com.opus.api;

import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestAssuredConfig {

    //@Value("${api.base-url}")
    //private String baseUrl;

    //@Bean
    //public void configureRestAssured() {
    //    RestAssured.baseURI = baseUrl;
    //}
}
