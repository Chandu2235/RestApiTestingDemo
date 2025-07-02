package com.api.automation.core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    public static RequestSpecification getRequest() {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .log().all();
    }

    public static Response get(String endpoint) {
        return getRequest().get(endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return getRequest().body(body).post(endpoint);
    }

    public static Response put(String endpoint, Object body) {
        return getRequest().body(body).put(endpoint);
    }

    public static Response delete(String endpoint) {
        return getRequest().delete(endpoint);
    }
}
