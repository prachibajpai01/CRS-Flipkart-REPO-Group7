package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.List;

public class RegistrationImpl implements RegistrationInterface{
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
