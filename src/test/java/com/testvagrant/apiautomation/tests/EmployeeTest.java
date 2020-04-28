package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.BaseClient;
import com.testvagrant.apiautomation.clients.employee.GetEmployeeClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {
    RequestSpecBuilder builder;
    RequestSpecification requestSpec;
    GetEmployeeClient baseClient;

    @BeforeTest
    public void setUp() {
        builder = new RequestSpecBuilder();
        builder.setBaseUri("http://dummy.restapiexample.com/api/v1");
        builder.setBasePath("/employees");
        requestSpec = builder.build();
        baseClient = new GetEmployeeClient();
    }

    @Test
    public void addEmployeeAndValidateResponse() {
        Response resp = baseClient.getEmployees(requestSpec);
        System.out.println(resp.getStatusCode());
    }
}
