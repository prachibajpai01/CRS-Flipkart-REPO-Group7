package com.flipkart.bean;

public class Professor extends User{
    private String department; // unimportant
    private String designation; // unimportant

    public Professor(String department,String designation){
        this.department = department;
        this.designation = designation;
    }

    public Professor(){}

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
