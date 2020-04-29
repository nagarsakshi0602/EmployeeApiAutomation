package com.testvagrant.apiautomation.responses.employee.getemlpoyeedetail;

import com.testvagrant.apiautomation.responses.employee.getallemployees.EmployeeDataResponse;

import java.util.List;

public class EmployeeResponse {
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
