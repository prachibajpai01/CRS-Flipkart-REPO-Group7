package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.ArrayList;

public interface CourseCatalogueInterface {
    public ArrayList<Course> sendCatalogue();
    public void enrollStudent(String studentId, String courseId);

    public void unenrollStudent(String studentId, String courseId);

    public void addCourse(String courseId, String courseName, String instructorId);
}