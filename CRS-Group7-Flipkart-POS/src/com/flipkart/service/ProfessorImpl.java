package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.List;

public class ProfessorImpl implements ProfessorInterface{
    @Override
    public boolean addGrade(int studentId, String courseCode, String grade) {
        return false;
    }

    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        return null;
    }

    @Override
    public List<Course> getCourses(String profId) {
        return null;
    }

    @Override
    public String getProfessorById(String profId) {
        return null;
    }
}
