package com.testvagrant.apiautomation.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {
    Response response;
    protected RequestSpecification requestSpecification;


    protected Response get(String basePath) {

        response = given()
                .spec(requestSpecification)
                .basePath(basePath)
                .when()
                .get();
        return response;
    }

    protected Response post(String basePath, Object body) {
        response = given()
                .spec(requestSpecification)
                .basePath(basePath)
                .and()
                .body(body)
                .when()
                .post();
        return response;
    }

    protected Response put(String basePath, Object body) {
        response = given()
                .spec(requestSpecification)
                .basePath(basePath)
                .body(body)
                .when()
                .put();
        return response;
    }

    protected Response delete(RequestSpecification requestSpecification) {
        response = given().spec(requestSpecification).delete();
        return response;
    }
}
