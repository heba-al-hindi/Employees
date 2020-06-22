package com.example.employees.repositories;

import com.example.employees.models.response.Employee;

import java.util.ArrayList;

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



    }


    // initialize employeeCallbacks
    public void setEmployeeCallbacks(EmployeeCallbacks employeeCallbacks) {
        this.employeeCallbacks = employeeCallbacks;

    }


    // interface to manage callbacks
    public interface EmployeeCallbacks {

        void onGetEmployeeSuccess(ArrayList<Employee> employees);

        void onGetEmployeeFail();
    }

}
