package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.employee.CreateEmployeeClient;
import com.testvagrant.apiautomation.clients.employee.GetEmployeeClient;
import com.testvagrant.apiautomation.clients.employee.UpdateEmployeeClient;
import com.testvagrant.apiautomation.requests.BaseRequest;
import com.testvagrant.apiautomation.requests.employee.EmployeeRequest;
import com.testvagrant.apiautomation.responses.employee.EmployeeResponse;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {

    GetEmployeeClient getEmployeeClient;
    CreateEmployeeClient createEmployeeClient;
    UpdateEmployeeClient updateEmployeeClient;
    BaseRequest baseRequest;
    RequestSpecification requestSpecification;
    EmployeeResponse emp;

    @BeforeTest
    public void setUp() {
        baseRequest = new BaseRequest();
        requestSpecification = baseRequest.build();
        getEmployeeClient = new GetEmployeeClient();
        createEmployeeClient = new CreateEmployeeClient();
        updateEmployeeClient = new UpdateEmployeeClient();
    }

    @Test
    public void getAllEmployeesAndValidate() {
        emp = getEmployeeClient
                .getEmployees(requestSpecification.basePath("/employees"))
                .getBody()
                .as(EmployeeResponse.class);
        Assert.assertEquals(emp.status, "success");
        Assert.assertNotNull(emp.data);
    }

    @Test
    public void createEmployee() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setName("test");
        employeeRequest.setSalary("12333");
        employeeRequest.setAge("23");
        System.out.println(createEmployeeClient
                .postEmployee(requestSpecification
                        .basePath("/create")
                        .body(employeeRequest)
                        .contentType(ContentType.JSON)).getStatusCode());

    }
    @Test
    public void updateEmployee()
    {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setName("test");
        employeeRequest.setSalary("12333");
        employeeRequest.setAge("23");
        System.out.println(updateEmployeeClient
                .updateEmployee(requestSpecification
                        .basePath("/update/3")
                        .body(employeeRequest)
                        .contentType(ContentType.JSON)).getStatusCode());
    }

}
