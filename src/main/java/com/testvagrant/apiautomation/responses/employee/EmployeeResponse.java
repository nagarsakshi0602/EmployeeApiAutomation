package com.testvagrant.apiautomation.responses.employee;

import java.util.List;

public class EmployeeResponse {
    public String status;
    public List<EmployeeDataResponse> data;

    public List<EmployeeDataResponse> getData() {
        return data;
    }

    public void setData(List<EmployeeDataResponse> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
