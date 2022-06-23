package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface StudentInterface {

    /**
     * Method to register student
     * @param name,userId,password,batch,branch,address: name,userId,password,batch,branch,address of respective student
     */
    public int register(String name,String userID,String password,int batch,String branch,String address);

    /**
     * Method to get studentId
     * @param userId,: studentId of the student
     */
    public String getStudentId(String userId);

    /**
     * Method know whether student isapproved
     * @param userId,: studentId of the student
     */
    public boolean isApproved(String studentId);

    /**
     * Method to add course
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    public void addCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue);

    /**
     * Method to drop course
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    public void dropCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue);

    /**
     * Method to view all courses
     * @param courseCatalogue: CourseCatalogueImpl instance
     */
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue);

    /**
     * Method to view student registered courses
     * @param userId: studentId of the student
     */
    public void viewRegisteredCourses(String userId);

    /**
     * Method to view grade of student
     * @param studentId: studentId of the student
     */
    public List<Grade> viewGradeCard(int studentId);
}
