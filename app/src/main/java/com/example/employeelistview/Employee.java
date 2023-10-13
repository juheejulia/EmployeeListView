package com.example.employeelistview;

public class Employee {

    private String firstName;
    private String lastName;
    private String role;
    private String age;
    private String email;
    private String mobileNumber;
    private String password;

    public Employee(String firstName, String lastName, String role, String age, String email,
                    String mobileNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Role: " + role
                + "\n" + "Age: " + age + "\n" + "e-mail: " + email + "\n"
                + "Mobile number: " + mobileNumber + "\n" + "Password: " + password;
    }
}

