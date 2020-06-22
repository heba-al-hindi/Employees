package com.example.employees.models.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EmployeeAddress implements Serializable {

    @SerializedName("street")
    private String street ;
    @SerializedName("suite")
    private String suite ;
    @SerializedName("city")
    private String city ;
    @SerializedName("zipcode")
    private String zipcode ;
    @SerializedName("geo")
    private EmployeeGeo employeeGeo ;


    public EmployeeAddress(String street, String suite, String city, String zipcode, EmployeeGeo employeeGeo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.employeeGeo = employeeGeo;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public EmployeeGeo getEmployeeGeo() {
        return employeeGeo;
    }

    public void setEmployeeGeo(EmployeeGeo employeeGeo) {
        this.employeeGeo = employeeGeo;
    }
}
