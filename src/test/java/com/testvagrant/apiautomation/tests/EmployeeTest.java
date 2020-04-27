package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.BaseClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {
    RequestSpecBuilder builder;
    RequestSpecification requestSpec;
    BaseClient baseClient;
    @BeforeTest
    public void setUp() {
       builder = new RequestSpecBuilder();
       builder.setBaseUri("http://dummy.restapiexample.com/api/v1");
       builder.setBasePath("/employees");
       requestSpec = builder.build();
       baseClient = new BaseClient();
    }
    @Test
    public void addEmployeeAndValidateResponse(){
            Response resp = baseClient.get(requestSpec);
            System.out.println(resp.getStatusCode());
    }
}
