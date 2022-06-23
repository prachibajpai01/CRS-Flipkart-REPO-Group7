package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.List;

public interface ProfessorInterface {
    /**
     * Method to addgrade
     * @param studentId,courseCode,grade: studentId of the student,courseCode of the course,grade
     */
    public boolean addGrade(int studentId,String courseCode,String grade);

    /**
     * Method to get list of enrolled students in the professor teaching course
     * @param profId: professorId of the professor
     */
    public List<EnrolledStudent> viewEnrolledStudents(String profId);

    /**
     * Method to get list of courses professor is teaching
     * @param profId,courseCatalogue: professorId of the professor,CourseCatalogueImpl instance
     */
    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue);

    /**
     * Method to get professorId
     * @param profId,: professorId of the professor
     */
    public Professor getProfessorById(String profId);
}
