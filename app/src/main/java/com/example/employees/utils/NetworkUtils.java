package com.example.employees.utils;

import com.example.employees.network.EmployeeApiManager;
import com.example.employees.network.RetrofitClient;

public class NetworkUtils {


    public static EmployeeApiManager getEmployeeApiManager() {

        return RetrofitClient.getRetrofitInstance().create(EmployeeApiManager.class);

    }

}
