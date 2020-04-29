package com.testvagrant.apiautomation.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BaseClient {
    Response response;

    public Response get(RequestSpecification requestSpecification) {

        response = given().spec(requestSpecification).when().get();
        return response;
    }

    public Response post(RequestSpecification requestSpecification) {
        response = given().spec(requestSpecification).post();
        return response;
    }

    public Response put(RequestSpecification requestSpecification) {
        response = given().spec(requestSpecification).put();
        return response;
    }

    public Response delete(RequestSpecification requestSpecification) {
        response = given().spec(requestSpecification).delete();
        return response;
    }
}
