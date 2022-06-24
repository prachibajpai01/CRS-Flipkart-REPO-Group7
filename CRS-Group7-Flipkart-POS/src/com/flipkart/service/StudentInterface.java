package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import java.util.List;

public interface StudentInterface {

    /**
     * Method to register student
     * @param name,userId,password,batch,branch,address: name,userId,password,batch,branch,address of respective student
     */
    public void register(String name,String userID,String password,int batch,String branch,String address);

    /**
     * Method to get studentId
     * @param userId,: studentId of the student
     */
    public String getStudentId(String userId);

    /**
     * Method know whether student isapproved
     * @param studentId,: studentId of the student
     */
    public boolean isApproved(String studentId);

    /**
     * Method to add course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     * @return
     */
    public Boolean addCourse(String userId, String courseId);

    /**
     * Method to drop course
     *
     * @param userId,courseId,courseCatalogue: studentId of the student,courseId of the course,CourseCatalogueImpl instance
     */
    public Boolean dropCourse(String userId, String courseId);

    /**
     * Method to view all courses
     * @param studentId : id of the student
     */
    public List<Course> viewAvailableCourseList(String studentId);

    /**
     * Method to view student registered courses
     * @param userId: studentId of the student
     */
    public void viewRegisteredCourses(String userId);

    /**
     * Method to view grade of student
     * @param studentId: studentId of the student
     */
    public List<EnrolledStudent> viewGradeCard(String studentId);
}
