package com.testvagrant.apiautomation.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BaseClient {
    Response response;
    public Response get(RequestSpecification requestSpecification)
    {

        response = given().spec(requestSpecification).when().get();
        return response;
    }
}
