package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.*;

public class ProfessorImpl implements ProfessorInterface {

    /**
     * Method to addgrade
     * @param studentId,courseCode,grade: studentId of the student,courseCode of the course,grade
     */
    @Override
    public boolean addGrade(int studentId, String courseCode, String grade) {
        return false;
    }

    /**
     * Method to get list of enrolled students in the professor teaching course
     * @param profId: professorId of the professor
     */
    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        return null;
    }

    /**
     * Method to get list of courses professor is teaching
     * @param profId,courseCatalogue: professorId of the professor,CourseCatalogueImpl instance
     */
    @Override
    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue) {
       return  new ArrayList<Course>();
    }

    /**
     * Method to get professorId
     * @param profId,: professorId of the professor
     */
    @Override
    public Professor getProfessorById(String profId) {
        return null;
    }
}
