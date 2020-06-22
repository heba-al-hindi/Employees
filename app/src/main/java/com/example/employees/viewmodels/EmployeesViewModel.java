package com.example.employees.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.employees.models.response.Employee;
import com.example.employees.repositories.EmployeesRepository;

import java.util.ArrayList;

public class EmployeesViewModel extends ViewModel implements EmployeesRepository.EmployeeCallbacks {

    private EmployeesRepository employeesRepository;
    // vars
    MutableLiveData<ArrayList<Employee>> employees = new MutableLiveData<>();


    // init viewModel
    public void initializeEmployeeViewModel() {
        employeesRepository = EmployeesRepository.getEmployeesRepository();
        // set RepoCallbacks
        employeesRepository.setEmployeeCallbacks(this);
    }


    public LiveData<ArrayList<Employee>> getEmployees() {
        employeesRepository.getEmployeesData();
        return employees;
    }

    @Override
    public void onGetEmployeeSuccess(ArrayList<Employee> employeesList) {
        if (employeesList != null) {
            employees.setValue(employeesList);
        }
    }

    @Override
    public void onGetEmployeeFail(Throwable throwable) {
        // Do Later

    }
}
