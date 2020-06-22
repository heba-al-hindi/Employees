package com.example.employees.models.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
/*
  save employee Company info
 */

public class EmployeeCompany implements Serializable {


    @SerializedName("name")
    private String name ;
    @SerializedName("catchPhrase")
    private String catchPhrase ;
    @SerializedName("bs")
    private String bs  ;


    public EmployeeCompany(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
