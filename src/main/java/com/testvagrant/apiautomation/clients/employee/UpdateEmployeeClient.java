package com.testvagrant.apiautomation.clients.employee;

import com.testvagrant.apiautomation.clients.BaseClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployeeClient extends BaseClient {
    Response response;
    public Response updateEmployee(RequestSpecification requestSpecification)
    {
        response  = put(requestSpecification);
        return  response;
    }
}
