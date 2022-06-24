package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.*;


public interface AdminInterface {
    /**
     * Method to delete course
     * @param courseCode : courseCode of the course
     */
    public void deleteCourse(String courseCode);

    /**
     * Method to add course
     * @param course : course object
     */
    public void addCourse(Course course);

    /**
     * Method to view pending admissions
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve student
     * @param studentId : studentId of student
     */
    public void approveStudent(String studentId);

    /**
     * Method to add professor
     * @param professor : professor object
     */
    public void addProfessor(Professor professor);

    /**
     * Method to assign course
     * @param courseCode,professorId : courseCode of course,professorId for professor
     */
    public void assignCourse(String courseCode, String professorId);

    /**
     * Method to view courses
     */
    public List<Course> viewCourses();

    /**
     * Method to view professor
     */
    public List<Professor> viewProfessors();

    /**
     * Method to send notifications
     * @param studentId,Notification : studentId of student,Notification object
     */
    public List<EnrolledStudent> generateGradeCard(String  studentId);
}
