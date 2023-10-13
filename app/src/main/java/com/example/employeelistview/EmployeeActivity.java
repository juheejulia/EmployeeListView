package com.example.employeelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// This Activity is the page that deploy information of the registered employee.

public class EmployeeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emloyee);

        listView = findViewById(R.id.listViewEmployees);

        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DataManager.employees);
        //EmployeeAdapter adapter = new EmployeeAdapter(this, DataManager.employees);

        listView.setAdapter(adapter);
    }
}