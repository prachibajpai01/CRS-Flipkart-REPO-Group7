package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.List;

public interface StudentInterface {

    public int register(String name,String userID,String password,int batch,String branch,String address,String country);

    public int getStudentId(String userId);

    public boolean isApproved(int studentId);

    public void addCourse(int courseId);

    public void dropCourse(int courseId);

    public List<Course> viewCourseList();

    public List<Course> viewRegisteredCourses();

    public List<Grade> viewGradeCard(int studentId);
}
