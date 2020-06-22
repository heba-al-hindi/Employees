package com.example.employees.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.employees.R;
import com.example.employees.databinding.ActivityEmployeeDetailsBinding;
import com.example.employees.models.response.Employee;

public class EmployeeDetailsActivity extends AppCompatActivity {

    private ActivityEmployeeDetailsBinding employeeDetailsBinding;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeDetailsBinding = ActivityEmployeeDetailsBinding.inflate(getLayoutInflater());
        View view = employeeDetailsBinding.getRoot();
        setContentView(view);

        // get Intent
        Intent intent = getIntent();
        employee = (Employee) intent.getSerializableExtra("employee");

        setViews();
    }

    // set data to views
    private void setViews() {

        // set personal info
        employeeDetailsBinding.tvEmail.setText(employee.getEmail());
        employeeDetailsBinding.tvPhone.setText(employee.getPhone());
        employeeDetailsBinding.tvWebsite.setText(employee.getWebsite());

        // set company info
        employeeDetailsBinding.tvCompanyName.setText(employee.getEmployeeCompany().getName());
        employeeDetailsBinding.tvCompanyRole.setText(employee.getEmployeeCompany().getCatchPhrase());
        employeeDetailsBinding.tvEmployeeBs.setText(employee.getEmployeeCompany().getBs());

        // set address info
        employeeDetailsBinding.tvCity.setText(employee.getEmployeeAddress().getCity());
        employeeDetailsBinding.tvStreet.setText(employee.getEmployeeAddress().getStreet());
        employeeDetailsBinding.tvZipcode.setText(employee.getEmployeeAddress().getZipcode());
    }
}