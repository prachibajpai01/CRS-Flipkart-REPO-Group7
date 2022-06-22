package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.*;

public class ProfessorImpl implements ProfessorInterface {

    @Override
    public boolean addGrade(int studentId, String courseCode, String grade) {
        return false;
    }

    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        return null;
    }

    @Override
    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue) {
       return  new ArrayList<Course>();
    }

    @Override
    public Professor getProfessorById(String profId) {
        return null;
    }
}
