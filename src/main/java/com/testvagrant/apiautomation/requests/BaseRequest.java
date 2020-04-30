package com.testvagrant.apiautomation.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static com.testvagrant.apiautomation.utilities.ConfigPropertyReader.getProperty;

public class BaseRequest {

    private RequestSpecBuilder builder;
    private RequestSpecification requestSpec;

    public RequestSpecification build() {
        builder = new RequestSpecBuilder();
        builder.setBaseUri(getProperty("baseUrl"));
        requestSpec = builder.build();
        return requestSpec;
    }
}
