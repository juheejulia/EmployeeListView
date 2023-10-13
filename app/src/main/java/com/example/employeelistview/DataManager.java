package com.example.employeelistview;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Employee> employees = new ArrayList<>();

    public Employee registerEmployee(String firstName, String lastName, String role, String age,
                                     String email, String mobileNumber, String password) {

        Employee employee = new Employee (firstName, lastName, role,
                age, email, mobileNumber, password);
        employees.add(employee);
        return employee;
    }
}
