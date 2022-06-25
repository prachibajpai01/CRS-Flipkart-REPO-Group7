package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.dao.ProfessorDaoInterface;

import java.util.*;

public class ProfessorImpl implements ProfessorInterface {

    ProfessorDaoInterface professorDaoInterface = new ProfessorDaoOperation();

    /**
     * Method to addgrade
     * @param studentId,courseCode,grade: studentId of the student,courseCode of the course,grade
     */
    @Override
    public boolean addGrade(String studentId, String courseCode, String grade) {
         return   professorDaoInterface.addGrade(studentId, courseCode, grade);

    }

    /**
     * Method to get list of enrolled students in the professor teaching course
     * @param profId: professorId of the professor
     */
    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        return  professorDaoInterface.viewEnrolledStudents(profId);
    }

    /**
     * Method to get list of courses professor is teaching
     * @param profId,courseCatalogue: professorId of the professor,CourseCatalogueImpl instance
     */
    @Override
    public ArrayList<Course> getCourses(String profId) {
            return  professorDaoInterface.getCourses(profId);
    }

}
