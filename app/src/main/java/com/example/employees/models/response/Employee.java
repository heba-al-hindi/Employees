package com.example.employees.models.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/*
   Employee Class to store employee data
 */

public class Employee implements Serializable {

    @SerializedName("id")
    private String id ;
    @SerializedName("name")
    private String username ;
    @SerializedName("email")
    private String email ;
    @SerializedName("address")
    private EmployeeAddress employeeAddress ;
    @SerializedName("phone")
    private String phone ;
    @SerializedName("website")
    private String website ;
    @SerializedName("company")
    private EmployeeCompany employeeCompany ;


    public Employee(String id, String username, String email, EmployeeAddress employeeAddress, String phone, String website, EmployeeCompany employeeCompany) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.employeeAddress = employeeAddress;
        this.phone = phone;
        this.website = website;
        this.employeeCompany = employeeCompany;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeAddress getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddress employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public EmployeeCompany getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(EmployeeCompany employeeCompany) {
        this.employeeCompany = employeeCompany;
    }
}
