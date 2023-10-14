package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This Activity is the page to register an employee

public class RegisterEmployeeActivity extends AppCompatActivity {

    EditText firstNameInput, lastNameInput, roleInput, ageInput, emailInput, mobileNumberInput;

    DataManager dataManager = new DataManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        firstNameInput = findViewById(R.id.firstName);
        lastNameInput = findViewById(R.id.lastName);
        roleInput = findViewById(R.id.role);
        ageInput = findViewById(R.id.age);
        emailInput = findViewById(R.id.email);
        mobileNumberInput = findViewById(R.id.mobile_number);
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

                // Hide keyboard when submitting form
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(registerButton.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_SHOWN);

                // All information field should be filled otherwise it will be refreshed.
                if (!allFieldsFilled()) {
                    Toast.makeText(RegisterEmployeeActivity.this,
                            "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isEmailValid = emailValidator(email);
                if (!isEmailValid) {
                    Toast.makeText(RegisterEmployeeActivity.this, "E-mail is not valid form.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isFirstNameValid = firstNameValidator(firstName);
                if(!isFirstNameValid) {
                    Toast.makeText(RegisterEmployeeActivity.this, "First name is not valid form.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Log.d("debug", "Sparar anställd");

                dataManager.registerEmployee
                        (firstName, lastName, role, age, email, mobileNumber);
                Toast.makeText(RegisterEmployeeActivity.this,
                        "An employee is registered.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterEmployeeActivity.this, EmployeeListActivity.class);
                startActivity(intent);
            }
        });

        // It proceeds to Employee List View
        nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                   Intent intent = new Intent(RegisterEmployeeActivity.this, EmployeeListActivity.class);
                   startActivity(intent);
           }
        });
    }

    public static boolean firstNameValidator(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }

        if (!firstName.matches("^[A-Za-z]+$")) {
            return false;
        }
        return true;
    }

    public static boolean emailValidator(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(email);

        // Check if the email matches the pattern
        return matcher.matches();
    }

    private boolean allFieldsFilled() {

        return !firstNameInput.getText().toString().isEmpty() &&
                !lastNameInput.getText().toString().isEmpty() &&
                !roleInput.getText().toString().isEmpty() &&
                !ageInput.getText().toString().isEmpty() &&
                !emailInput.getText().toString().isEmpty() &&
                !mobileNumberInput.getText().toString().isEmpty();
    }
}