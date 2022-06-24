package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoOperation;

import java.util.*;

public class AdminImpl implements AdminInterface{

    AdminDaoOperation adminDaoOperation = new AdminDaoOperation();


    /**
     * Method to delete course
     * @param courseCode : courseCode of the course
     */
    @Override
    public void deleteCourse(String courseCode) {
        adminDaoOperation.deleteCourse(courseCode);
    }

    /**
     * Method to add course
     * @param course : course object
     */
    @Override
    public void addCourse(Course course) {
        adminDaoOperation.addCourse(course);
    }

    /**
     * Method to view pending admissions
     */
    @Override
    public List<Student> viewPendingAdmissions() {
        return adminDaoOperation.viewPendingAdmissions();
    }

    /**
     * Method to approve student
     * @param studentId : studentId of student
     */
    @Override
    public void approveStudent(String studentId) {
        adminDaoOperation.approveStudent(studentId);
    }

    /**
     * Method to add professor
     * @param professor : professor object
     */
    @Override
    public void addProfessor(Professor professor) {
        adminDaoOperation.addProfessor(professor);
    }

    /**
     * Method to assign course
     * @param courseCode,professorId : courseCode of course,professorId for professor
     */
    @Override
    public void assignCourse(String courseCode, String professorId) {
        adminDaoOperation.assignCourse(courseCode,professorId);
    }

    /**
     * Method to view courses
     */
    @Override
    public List<Course> viewCourses() {
        return adminDaoOperation.viewCourses();
    }

    /**
     * Method to view professor
     */
    @Override
    public List<Professor> viewProfessors() {
        return adminDaoOperation.viewProfessors();
    }

    /**
     * Method to generate report card
     * @param studentId : studentId of student
     */
    @Override
    public List<EnrolledStudent> generateGradeCard(String studentId) {
        return adminDaoOperation.generateGradeCard(studentId);
    }

}
