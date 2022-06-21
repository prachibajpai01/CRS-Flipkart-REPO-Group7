package com.flipkart.bean;

public class Professor extends User{
    private String department;
    private String designation;

    public Professor(String department,String designation,String id){
        this.department = department;
        this.designation = designation;
        this.setUserId(id);
    };

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
