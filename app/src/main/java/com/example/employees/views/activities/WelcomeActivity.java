package com.example.employees.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.employees.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WelcomeActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Make splash screen using handler
        new Handler().postDelayed(this::openEmployeeActivity, SPLASH_TIME_OUT);

    }

    // method to open MainActivity after splash
    private void openEmployeeActivity() {
        Intent intent = new Intent(WelcomeActivity.this, EmployeesActivity.class);
        startActivity(intent);
    }
}