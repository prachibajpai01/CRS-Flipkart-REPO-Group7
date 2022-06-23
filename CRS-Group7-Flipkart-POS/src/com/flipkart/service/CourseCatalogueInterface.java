package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.ArrayList;

public interface CourseCatalogueInterface {
    /**
     * Method to view all courses with their details
     */
    public ArrayList<Course> sendCatalogue();

    /**
     * Method to enroll students
     * @param studentId,courseId: studentId of the student,courseId of the course
     */
    public void enrollStudent(String studentId, String courseId);

    /**
     * Method to unenroll students
     * @param studentId,courseId: studentId of the student,courseId of the course
     */
    public void unenrollStudent(String studentId, String courseId);

    /**
     * Method to add courses
     * @param courseId,courseName,instructorId: courseId of the course,coursename of the course,instructorid
     */
    public void addCourse(String courseId, String courseName, String instructorId);

    /**
     * Method to getcoursedetails
     * @param courseId: courseId of the course
     */
    public Course getCourseInfo(String courseId);
}
