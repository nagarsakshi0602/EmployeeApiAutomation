package com.testvagrant.apiautomation.clients.employee;

import com.testvagrant.apiautomation.clients.BaseClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployeeClient extends BaseClient {
    public Response getEmployees(RequestSpecification requestSpecification)
    {
        return get(requestSpecification);
    }
}
