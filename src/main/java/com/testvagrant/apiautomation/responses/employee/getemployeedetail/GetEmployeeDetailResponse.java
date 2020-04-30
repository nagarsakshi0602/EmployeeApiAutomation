package com.testvagrant.apiautomation.responses.employee.getemployeedetail;

import com.testvagrant.apiautomation.responses.employee.getallemployees.EmployeeDataResponse;

public class GetEmployeeDetailResponse {
    public String status;
    public EmployeeDataResponse data;

    public EmployeeDataResponse getData() {
        return data;
    }

    public void setData(EmployeeDataResponse data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
