package com.testvagrant.apiautomation.requests.employee.updateemployee;

public class UpdateEmployeeRequestBuilder {
    private UpdateEmployeeRequest updateEmployeeRequest;

    public UpdateEmployeeRequestBuilder() {
        updateEmployeeRequest = new UpdateEmployeeRequest();
    }

    public UpdateEmployeeRequestBuilder setEmployeeDetails(String name, String salary, String age) {
        updateEmployeeRequest.name = name;
        updateEmployeeRequest.salary = salary;
        updateEmployeeRequest.age = age;
        return this;
    }

    public UpdateEmployeeRequest build() {
        return updateEmployeeRequest;
    }
}
