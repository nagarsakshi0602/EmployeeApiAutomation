package com.testvagrant.apiautomation.clients.employee;

import com.testvagrant.apiautomation.clients.BaseClient;
import com.testvagrant.apiautomation.requests.BaseRequest;
import com.testvagrant.apiautomation.requests.employee.createemployee.CreateEmployeeRequest;
import com.testvagrant.apiautomation.requests.employee.createemployee.CreateEmployeeRequestBuilder;
import com.testvagrant.apiautomation.requests.employee.updateemployee.UpdateEmployeeRequest;
import com.testvagrant.apiautomation.requests.employee.updateemployee.UpdateEmployeeRequestBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.testvagrant.apiautomation.utilities.ConfigPropertyReader.getProperty;

public class EmployeeClient extends BaseClient {
    Response response;

    public EmployeeClient()
    {
        requestSpecification = new BaseRequest().build();
    }
    public Response postEmployee(String name,String salary,String age) {

       CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequestBuilder()
                .setEmployeeDetails(name,salary,age)
                .build();
        String basePath = getProperty("createEmployee");
        return post(basePath,createEmployeeRequest);
    }
    public Response deleteEmployee(RequestSpecification requestSpecification) {
        response = delete(requestSpecification);
        return response;
    }
    public Response updateEmployee(int id,String name,String salary,String age) {
        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequestBuilder()
                .setEmployeedetails(name,salary,age)
                .build();
        String basePath = getProperty("updateEmployee")+id;
        response = put(basePath,updateEmployeeRequest);
        return response;
    }
    public Response getEmployees()
    {
        String basePath = getProperty("allEmployees");
        return get(basePath);
    }
    public Response getEmployee(int id)
    {
        String basePath = getProperty("employee")+id;
        return get(basePath);
    }
}
