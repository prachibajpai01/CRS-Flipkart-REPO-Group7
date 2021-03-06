package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;

import java.util.*;

public class StudentImpl implements StudentInterface{

    StudentDaoInterface studentDaoInterface = new StudentDaoOperation();
    //userId,all courses w.r.t student

    @Override
    public void register(String name,String userId,String password,int batch,String branch){
        studentDaoInterface.register(name, userId, password, batch, branch);
    }

    /**
     * Method to get studentId
     * @param userId,: studentId of the student
     */
    @Override
    public String getStudentId(String userId){
        return studentDaoInterface.getStudentId(userId);
    }

    /**
     * Method know whether student isapproved
     * @param userId,: studentId of the student
     */
    @Override
    public boolean isApproved(String userId) {
        return studentDaoInterface.isApproved(userId);
    }

    /**
     * Method to add course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     * @return
     */
    @Override
    public Boolean addCourse(String userId, String courseId) {
        return studentDaoInterface.addCourse(userId, courseId);
    }

    /**
     * Method to drop course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    @Override
    public Boolean dropCourse(String userId, String courseId) {
        return studentDaoInterface.dropCourse(userId, courseId);
    }

    /**
     * Method to view all available courses
     * @param studentId:
     */
    @Override
    public List<Course> viewAvailableCourseList(String studentId) {

        return studentDaoInterface.viewCourseList(studentId);
    }

    /**
     * Method to view student registered courses
     *
     * @param userId: studentId of the student
     * @return
     */
    @Override
    public List<EnrolledStudent> viewRegisteredCourses(String userId) {
        return studentDaoInterface.viewRegisteredCourses(userId);
    }

    /**
     * Method to view grade of student
     * @param studentId: studentId of the student
     */
    @Override
    public List<EnrolledStudent> viewGradeCard(String studentId) {
        return studentDaoInterface.viewGradeCard(studentId);
    }
}
