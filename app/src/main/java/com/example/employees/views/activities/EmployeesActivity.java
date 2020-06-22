package com.example.employees.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.employees.R;
import com.example.employees.adapters.EmployeesAdapter;
import com.example.employees.databinding.ActivityEmployeesBinding;
import com.example.employees.models.response.Employee;
import com.example.employees.viewmodels.EmployeesViewModel;

import java.util.ArrayList;
import java.util.Objects;

public class EmployeesActivity extends AppCompatActivity implements EmployeesAdapter.EmployeeClickListener {

    private EmployeesViewModel employeesViewModel;
    private ActivityEmployeesBinding activityEmployeesBinding;

    // adapter
    private EmployeesAdapter employeesAdapter;
    // vars
    private ArrayList<Employee> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEmployeesBinding = ActivityEmployeesBinding.inflate(getLayoutInflater());
        View view = activityEmployeesBinding.getRoot();
        setContentView(view);


        // set Recycler
        setRecycler();
        // initialize the viewModel
        initViewModel();
        // load Employees
        loadEmployees();


    }

    private void setRecycler() {
        activityEmployeesBinding.recEmployees.setLayoutManager(new LinearLayoutManager(this));
        activityEmployeesBinding.recEmployees.hasFixedSize();
    }

    private void initViewModel() {
        employeesViewModel = new ViewModelProvider(this).get(EmployeesViewModel.class);
        employeesViewModel.initializeEmployeeViewModel();
    }

    private void loadEmployees() {

        employeesViewModel.getEmployees().observe(this, new Observer<ArrayList<Employee>>() {
            @Override
            public void onChanged(ArrayList<Employee> employees) {
                if (employees != null) {
                    employeesAdapter = new EmployeesAdapter(getApplicationContext(), employees, EmployeesActivity.this);
                    activityEmployeesBinding.recEmployees.setAdapter(employeesAdapter);
                    data.addAll(employees);
                }

            }
        });

    }

    @Override
    public void onEmployeeClicked(int position) {
        // move to EmployeeDetailsActivity
        Employee employee = data.get(position) ;
        Intent intent = new Intent(this, EmployeeDetailsActivity.class);
        intent.putExtra("employee", employee);
        startActivity(intent);
    }
}