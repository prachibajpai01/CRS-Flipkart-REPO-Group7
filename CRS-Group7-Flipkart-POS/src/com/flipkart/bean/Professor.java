package com.flipkart.bean;
;

public class Professor extends User{
    private String department;
    private String designation;
    
    public Professor(String department, String designation) {
    	this.department=department;
    	this.designation=designation;
    }
    
    public String getDepartment() {
    	return this.department;
    }
    
    public String getDesignation() {
    	return this.designation;
    }
}