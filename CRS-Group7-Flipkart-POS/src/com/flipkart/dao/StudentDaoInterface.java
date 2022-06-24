package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface StudentDaoInterface {

    public void register(String userName, String userID, String password, int batch, String branch, String address);
    public String getStudentId(String userId);
    public boolean isApproved(String studentId);
    public void addCourse(String userId, String courseId);
    public void dropCourse(String userId, String courseId);
    public List<Course> viewCourseList(String studentId);
    public void viewRegisteredCourses(String userId);
    public GradeCard viewGradeCard(int studentId);

    public void addUser(User user);

}



