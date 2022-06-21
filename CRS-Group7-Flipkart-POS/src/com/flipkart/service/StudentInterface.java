package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface StudentInterface {

    public int register(String name,String userID,String password,int batch,String branch,String address);

    public String getStudentId(String userId);

    public boolean isApproved(String studentId);

    public void addCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue);

    public void dropCourse(String userId,String courseId, CourseCatalogueImpl courseCatalogue);

    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue);

    public Set<String> viewRegisteredCourses(String userId);

    public List<Grade> viewGradeCard(int studentId);
}
