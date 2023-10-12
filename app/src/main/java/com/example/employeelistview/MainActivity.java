package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText firstNameInput, lastNameInput, roleInput, ageInput,
            emailInput, mobilePhoneInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstName);
        lastNameInput = findViewById(R.id.lastName);
        roleInput = findViewById(R.id.role);
        ageInput = findViewById(R.id.age);
        emailInput = findViewById(R.id.email);
        mobilePhoneInput = findViewById(R.id.mobile_number);
        passwordInput = findViewById(R.id.password);
    }
}