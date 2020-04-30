package com.testvagrant.apiautomation.requests.employee.createemployee;

public class CreateEmployeeRequestBuilder {
    private CreateEmployeeRequest createEmployeeRequest;

    public CreateEmployeeRequestBuilder() {
        createEmployeeRequest = new CreateEmployeeRequest();
    }

    public CreateEmployeeRequestBuilder setEmployeeDetails(String name, String salary, String age) {
        createEmployeeRequest.name = name;
        createEmployeeRequest.salary = salary;
        createEmployeeRequest.age = age;
        return this;
    }

    public CreateEmployeeRequest build() {
        return createEmployeeRequest;
    }
}
