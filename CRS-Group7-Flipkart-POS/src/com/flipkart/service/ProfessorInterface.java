package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.List;

public interface ProfessorInterface {
    public boolean addGrade(int studentId,String courseCode,String grade);
    public List<EnrolledStudent> viewEnrolledStudents(String profId);
    public List<Course> getCourses(String profId);
    public String getProfessorById(String profId);
}
