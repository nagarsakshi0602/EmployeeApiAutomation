package com.testvagrant.apiautomation.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

    private RequestSpecBuilder builder;
    private RequestSpecification requestSpec;

    public RequestSpecification build()
    {
        builder = new RequestSpecBuilder();
        builder.setBaseUri("http://dummy.restapiexample.com/api/v1");
        requestSpec = builder.build();
        return  requestSpec;
    }
}
