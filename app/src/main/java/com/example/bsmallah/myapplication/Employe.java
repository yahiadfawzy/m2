package com.example.bsmallah.myapplication;

public class Employe {
private int id;
private String employee_name;
private int employee_salary;
private String profile_image;
private int employee_age;

    public int getId() {
        return id;
    }

    public Employe(String employee_name, int employee_salary , int employee_age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.profile_image = profile_image;
        this.employee_age = employee_age;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }
}
