package com.flipkart.service;

public class StudentImpl implements StudentInterface{
    @Override
    public int register(String name,String userId,String password,int batch,String branch,String address,String country){
        System.out.println("Registering...");
        return 0;
    }

    @Override
    public int getStudentId(String userId) {
        System.out.println("Student id is...");
        return 0;
    }

    @Override
    public boolean isApproved(int studentId) {
        System.out.println("Inside isApproved...");
        return false;
    }

}
