package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.service.CourseCatalogueImpl;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorDaoInterface {

    public boolean addGrade(String studentId,String courseCode,String grade);

    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    public ArrayList<Course> getCourses(String profId);

    public String getProfessorById(String profId);
}