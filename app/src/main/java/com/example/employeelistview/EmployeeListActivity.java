package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

// This Activity is the page that deploy information of the registered employee.

public class EmployeeListActivity extends AppCompatActivity {

    ListView listView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        listView = findViewById(R.id.listViewEmployees);
        backButton = findViewById(R.id.btn_back);

        //ArrayAdapter<Employee> adapter = new ArrayAdapter<>
        //(this, android.R.layout.simple_list_item_1, DataManager.employees);
        EmployeeAdapter adapter = new EmployeeAdapter(this, DataManager.employees);

        listView.setAdapter(adapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeListActivity.this, RegisterEmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}