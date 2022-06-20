package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.List;

public interface RegistrationInterface {
    public void addCourse(int courseId);

    public void dropCourse(int courseId);

    public List<Course> viewCourseList();

    public List<Course> viewRegisteredCourses();

    public List<Grade> viewGradeCard(int studentId);
}
