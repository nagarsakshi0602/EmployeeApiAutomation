package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.employee.EmployeeClient;
import com.testvagrant.apiautomation.requests.BaseRequest;
import com.testvagrant.apiautomation.requests.employee.createemployee.CreateEmployeeRequest;
import com.testvagrant.apiautomation.responses.employee.getallemployees.EmployeeResponse;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {


    EmployeeClient employeeClient;
    BaseRequest baseRequest;
    RequestSpecification requestSpecification;
    EmployeeResponse emp;

    @BeforeTest
    public void setUp() {
        baseRequest = new BaseRequest();
        requestSpecification = baseRequest.build();
        employeeClient = new EmployeeClient();

    }

    @Test
    public void getAllEmployeesAndValidate() {
        emp = employeeClient
                .getEmployees(requestSpecification.basePath("/employees"))
                .getBody()
                .as(EmployeeResponse.class);
        Assert.assertEquals(emp.status, "success");
        Assert.assertNotNull(emp.data);
    }

    @Test
    public void createEmployee() {
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setName("test");
        createEmployeeRequest.setSalary("12333");
        createEmployeeRequest.setAge("23");
        System.out.println(employeeClient
                .postEmployee(requestSpecification
                        .basePath("/create")
                        .body(createEmployeeRequest)
                        .contentType(ContentType.JSON)).getStatusCode());

    }
    @Test
    public void updateEmployee()
    {
        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
        createEmployeeRequest.setName("test");
        createEmployeeRequest.setSalary("12333");
        createEmployeeRequest.setAge("23");
        System.out.println(employeeClient
                .updateEmployee(requestSpecification
                        .basePath("/update/3")
                        .body(createEmployeeRequest)
                        .contentType(ContentType.JSON)).getStatusCode());
    }
    @Test
    public  void deleteEmployee()
    {
        emp = employeeClient
                .getEmployees(requestSpecification.basePath("/employees"))
                .getBody()
                .as(EmployeeResponse.class);
        Assert.assertEquals(emp.status, "success");
        Assert.assertNotNull(emp.data);
    }
}
