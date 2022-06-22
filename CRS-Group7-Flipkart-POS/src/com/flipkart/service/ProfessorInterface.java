package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorInterface {
    public boolean addGrade(int studentId,String courseCode,String grade);
    public List<EnrolledStudent> viewEnrolledStudents(String profId);
    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue);
    public Professor getProfessorById(String profId);
}
