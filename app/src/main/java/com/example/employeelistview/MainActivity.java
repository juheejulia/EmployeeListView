package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// This Activity is the page to register an employee


public class MainActivity extends AppCompatActivity {

    EditText firstNameInput, lastNameInput, roleInput, ageInput,
            emailInput, mobileNumberInput, passwordInput;

    DataManager dataManager = new DataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstName);
        lastNameInput = findViewById(R.id.lastName);
        roleInput = findViewById(R.id.role);
        ageInput = findViewById(R.id.age);
        emailInput = findViewById(R.id.email);
        mobileNumberInput = findViewById(R.id.mobile_number);
        passwordInput = findViewById(R.id.password);
        Button registerButton = findViewById(R.id.btn_register);
        Button nextButton = findViewById(R.id.btn_next);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameInput.getText().toString();
                String lastName = lastNameInput.getText().toString();
                String role = roleInput.getText().toString();
                String age = ageInput.getText().toString();
                String email = emailInput.getText().toString();
                String mobileNumber = mobileNumberInput.getText().toString();
                String password = passwordInput.getText().toString();

                Employee employee = dataManager.registerEmployee
                        (firstName, lastName, role, age, email, mobileNumber, password);
                Toast.makeText(MainActivity.this,
                        "En employee is registered.", Toast.LENGTH_SHORT).show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
               startActivity(intent);
           }
        });
    }
}