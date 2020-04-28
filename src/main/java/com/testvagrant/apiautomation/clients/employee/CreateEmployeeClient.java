package com.testvagrant.apiautomation.clients.employee;

import com.testvagrant.apiautomation.clients.BaseClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployeeClient extends BaseClient {

    public Response postEmployee(RequestSpecification requestSpecification)
    {
        return post(requestSpecification);
    }

}
