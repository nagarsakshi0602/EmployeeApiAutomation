package com.testvagrant.apiautomation.clients.employee;

import com.testvagrant.apiautomation.clients.BaseClient;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeClient extends BaseClient {
    Response response;
    public Response postEmployee(RequestSpecification requestSpecification) {
        return post(requestSpecification);
    }
    public Response deleteEmployee(RequestSpecification requestSpecification) {
        response = delete(requestSpecification);
        return response;
    }
    public Response updateEmployee(RequestSpecification requestSpecification) {
        response = put(requestSpecification);
        return response;
    }
    public Response getEmployees(RequestSpecification requestSpecification)
    {
        return get(requestSpecification);
    }
}
