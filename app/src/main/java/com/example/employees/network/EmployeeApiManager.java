package com.example.employees.network;

import com.example.employees.models.response.Employee;

import java.util.ArrayList;

import retrofit2.Call;

/*
  This Interface to manage all Employees Api Calls
 */
public interface EmployeeApiManager {

    // get all employees call
    Call<ArrayList<Employee>> getAllEmployees();


}
