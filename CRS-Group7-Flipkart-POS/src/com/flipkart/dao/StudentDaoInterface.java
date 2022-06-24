package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.User;

import java.util.ArrayList;

public interface StudentDaoInterface {

    public void register(String userName, String userID, String password, int batch, String branch, String address);
    public String getStudentId(String userId);
    public boolean isApproved(String studentId);
    public void addCourse(String userId, String courseId);
    public void dropCourse(String userId, String courseId);
    public ArrayList<Course> viewCourseList();
    public void viewRegisteredCourses(String userId);
    public GradeCard viewGradeCard(int studentId);

    public void addUser(User user);

}



