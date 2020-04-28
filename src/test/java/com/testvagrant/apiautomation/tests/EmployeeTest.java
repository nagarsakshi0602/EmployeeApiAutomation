package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.employee.GetEmployeeClient;
import com.testvagrant.apiautomation.requests.BaseRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {

    GetEmployeeClient getEmployeeClient;
    BaseRequest baseRequest;
    private RequestSpecification requestSpecification;

    @BeforeTest
    public void setUp() {
        baseRequest = new BaseRequest();
        requestSpecification = baseRequest.build().basePath("/employees");
        getEmployeeClient = new GetEmployeeClient();
    }

    @Test
    public void addEmployeeAndValidateResponse() {
        Assert.assertEquals(getEmployeeClient
                .getEmployees(requestSpecification)
                .getStatusCode(), 200);

    }
}
