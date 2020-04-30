package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.employee.EmployeeClient;
import com.testvagrant.apiautomation.responses.employee.createemployee.CreateEmployeeResponse;
import com.testvagrant.apiautomation.responses.employee.getallemployees.GetAllEmployeeResponse;
import com.testvagrant.apiautomation.responses.employee.getemployeedetail.GetEmployeeDetailResponse;
import com.testvagrant.apiautomation.responses.employee.updateemployee.UpdateEmployeeResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EmployeeTest {


    EmployeeClient employeeClient;
    GetAllEmployeeResponse getAllEmployee;
    CreateEmployeeResponse createEmployee;
    UpdateEmployeeResponse updateEmployee;
    GetEmployeeDetailResponse getEmployeeDetail;

    @BeforeTest
    public void setUp() {
       employeeClient = new EmployeeClient();
    }

    @Test
    public void getAllEmployeesAndValidate() {
        getAllEmployee = employeeClient
                .getEmployees()
                .getBody()
                .as(GetAllEmployeeResponse.class);
        Assert.assertEquals(getAllEmployee.status, "success");
        Assert.assertNotNull(getAllEmployee.data);
    }
    @Test
    public void getEmployeeDetails()
    {
        getEmployeeDetail = employeeClient
                .getEmployee(3)
                .getBody()
                .as(GetEmployeeDetailResponse.class);
        Assert.assertEquals(getEmployeeDetail.status,"success");
    }
    @Test
    public void createEmployee() {

        createEmployee = employeeClient
                .postEmployee("Sakshi","20000","23")
                .as(CreateEmployeeResponse.class);
        Assert.assertEquals(createEmployee.status,"success");
        Assert.assertEquals(createEmployee.data.name,"Sakshi");
        Assert.assertEquals(createEmployee.data.salary,"20000");
        Assert.assertEquals(createEmployee.data.age,"23");

    }
    @Test
    public void updateEmployee()
    {
        updateEmployee = employeeClient
                .updateEmployee(3,"Sakshi","20000","23")
                .as(UpdateEmployeeResponse.class);
        Assert.assertEquals(updateEmployee.status,"success");


    }
    @Test
    public  void deleteEmployee()
    {
       /* emp = employeeClient
                .getEmployees(requestSpecification.basePath("/employees"))
                .getBody()
                .as(GetAllEmployeeResponse.class);
        Assert.assertEquals(emp.status, "success");
        Assert.assertNotNull(emp.data);*/
    }
}
