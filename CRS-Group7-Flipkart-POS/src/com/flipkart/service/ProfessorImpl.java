package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
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
        try
        {
            professorDaoInterface.addGrade(studentId, courseCode, grade);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Method to get list of enrolled students in the professor teaching course
     * @param profId: professorId of the professor
     */
    @Override
    public List<EnrolledStudent> viewEnrolledStudents(String profId) {
        try
        {
          return  professorDaoInterface.viewEnrolledStudents(profId);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Method to get list of courses professor is teaching
     * @param profId,courseCatalogue: professorId of the professor,CourseCatalogueImpl instance
     */
    @Override
    public ArrayList<Course> getCourses(String profId) {
            return  professorDaoInterface.getCourses(profId);
    }

    /**
     * Method to get professorId
     * @param profId,: professorId of the professor
     */
    @Override
    public String getProfessorById(String profId) {
        return professorDaoInterface.getProfessorById(profId);
    }
}
