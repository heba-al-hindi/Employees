package com.example.employees.network;

import com.example.employees.models.response.Employee;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/*
  This Interface to manage all Employees Api Calls
 */
public interface EmployeeApiManager {

    // get all employees call
    @GET("users")
    Call<ArrayList<Employee>> getAllEmployees();


}
