package com.testvagrant.apiautomation.tests;

import com.testvagrant.apiautomation.clients.employee.EmployeeClient;
import com.testvagrant.apiautomation.responses.employee.createemployee.CreateEmployeeResponse;
import com.testvagrant.apiautomation.responses.employee.getallemployees.GetAllEmployeeResponse;
import com.testvagrant.apiautomation.responses.employee.getemployeedetail.GetEmployeeDetailResponse;
import com.testvagrant.apiautomation.responses.employee.updateemployee.UpdateEmployeeResponse;
import com.testvagrant.apiautomation.utilities.YamlReader;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.testvagrant.apiautomation.utilities.YamlReader.getYamlValue;

public class EmployeeTest {

    YamlReader yaml;
    EmployeeClient employeeClient;
    GetAllEmployeeResponse getAllEmployee;
    CreateEmployeeResponse createEmployee;
    UpdateEmployeeResponse updateEmployee;
    GetEmployeeDetailResponse getEmployeeDetail;
    private Response response;

    public EmployeeTest() {
        yaml = new YamlReader("src/test/resources/TestData/data.yml");
    }

    @BeforeTest
    public void setUp() {
        employeeClient = new EmployeeClient();
    }

    @Test
    public void createEmployee() {
        String name = getYamlValue("EmployeeDetail.name");
        String salary = getYamlValue("EmployeeDetail.salary");
        String age = getYamlValue("EmployeeDetail.age");
        createEmployee = employeeClient
                .postEmployee(name, salary, age)
                .as(CreateEmployeeResponse.class);
        Assert.assertEquals(createEmployee.status, "success");
        Assert.assertEquals(createEmployee.data.name, name);
        Assert.assertEquals(createEmployee.data.salary, salary);
        Assert.assertEquals(createEmployee.data.age, age);

        int id = Integer.parseInt(createEmployee.data.id);

        getEmployeeDetail = employeeClient
                .getEmployee(id)
                .getBody()
                .as(GetEmployeeDetailResponse.class);
        Assert.assertEquals(getEmployeeDetail.data.employee_name, name);
        Assert.assertEquals(getEmployeeDetail.data.employee_salary, salary);
        Assert.assertEquals(getEmployeeDetail.data.employee_age, age);

    }

    @Test
    public void updateEmployee() {
        int id = Integer.parseInt(getYamlValue("EmployeeDetail.id"));
        String name = getYamlValue("EmployeeDetail.name") + RandomStringUtils.randomAlphabetic(2).toLowerCase();
        String salary = getYamlValue("EmployeeDetail.salary");
        String age = getYamlValue("EmployeeDetail.age");
        updateEmployee = employeeClient
                .updateEmployee(id, name, salary, age)
                .as(UpdateEmployeeResponse.class);

        Assert.assertEquals(updateEmployee.status, "success");

        getEmployeeDetail = employeeClient
                .getEmployee(id)
                .getBody()
                .as(GetEmployeeDetailResponse.class);
        Assert.assertEquals(getEmployeeDetail.data.employee_name, name);
        Assert.assertEquals(getEmployeeDetail.data.employee_salary, salary);
        Assert.assertEquals(getEmployeeDetail.data.employee_age, age);

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
    public void getEmployeeDetails() {
        int id = Integer.parseInt(getYamlValue("EmployeeDetail.id"));
        String name = getYamlValue("EmployeeDetail.name");
        String salary = getYamlValue("EmployeeDetail.salary");
        String age = getYamlValue("EmployeeDetail.age");
        getEmployeeDetail = employeeClient
                .getEmployee(id)
                .getBody()
                .as(GetEmployeeDetailResponse.class);

        Assert.assertEquals(getEmployeeDetail.status, "success");
        Assert.assertEquals(getEmployeeDetail.data.employee_name, name);
        Assert.assertEquals(getEmployeeDetail.data.employee_salary, salary);
        Assert.assertEquals(getEmployeeDetail.data.employee_age, age);
    }


}
