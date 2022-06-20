package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.List;

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

    @Override
    public void addCourse(int courseId) {
        System.out.println("Adding course...");
    }

    @Override
    public void dropCourse(int courseId) {
        System.out.println("Dropping course...");
    }

    @Override
    public List<Course> viewCourseList() {
        System.out.println("Viewing list of courses...");
        return null;
    }

    @Override
    public List<Course> viewRegisteredCourses() {
        System.out.println("Registered courses...");
        return null;
    }

    @Override
    public List<Grade> viewGradeCard(int studentId) {
        System.out.println("Viewing grade card...");
        return null;
    }

}
