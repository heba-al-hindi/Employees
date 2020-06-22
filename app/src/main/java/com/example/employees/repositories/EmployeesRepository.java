package com.example.employees.repositories;

import com.example.employees.models.response.Employee;
import com.example.employees.utils.NetworkUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeesRepository {

    private static EmployeesRepository employeesRepository;
    private EmployeeCallbacks employeeCallbacks;

    // vars
    private ArrayList<Employee> employeesData = new ArrayList<>();

    // get Instance of employeeRepo
    public static EmployeesRepository getEmployeesRepository() {
        if (employeesRepository == null) {
            // create employee instance

            employeesRepository = new EmployeesRepository();

        }

        // return the instance
        return employeesRepository;
    }


    // get EmployeesData
    public void getEmployeesData() {
        // make Api Call to get Data
        NetworkUtils.getEmployeeApiManager().getAllEmployees().enqueue(new Callback<ArrayList<Employee>>() {
            @Override
            public void onResponse(Call<ArrayList<Employee>> call, Response<ArrayList<Employee>> response) {
                if (response.body() != null) {
                    employeeCallbacks.onGetEmployeeSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Employee>> call, Throwable t) {
                employeeCallbacks.onGetEmployeeFail(t);

            }
        });

    }

    // initialize employeeCallbacks
    public void setEmployeeCallbacks(EmployeeCallbacks employeeCallbacks) {
        this.employeeCallbacks = employeeCallbacks;

    }


    // interface to manage callbacks
    public interface EmployeeCallbacks {

        void onGetEmployeeSuccess(ArrayList<Employee> employees);

        void onGetEmployeeFail(Throwable throwable);
    }

}
