package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.*;
import com.flipkart.validator.StudentValidator;

import java.sql.SQLException;
import java.util.*;

public class AdminImpl implements AdminInterface{

    AdminDaoOperation adminDaoOperation = new AdminDaoOperation();


    /**
     * Method to delete course
     * @param courseCode : courseCode of the course
     */
    @Override
    public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException {
        adminDaoOperation.deleteCourse(courseCode);
    }

    /**
     * Method to add course
     * @param course : course object
     */
    @Override
    public void addCourse(Course course) throws CourseFoundException {
        adminDaoOperation.addCourse(course);
    }

    /**
     * Method to view pending admissions
     */
    @Override
    public List<Student> viewPendingAdmissions() {
        return adminDaoOperation.viewPendingAdmissions();
    }

    /**
     * Method to approve student
     * @param studentId : studentId of student
     */
    @Override
    public void approveStudent(String studentId) throws UserNotFoundException {
        adminDaoOperation.approveStudent(studentId);
    }

    /**
     * Method to add professor
     * @param professor : professor object
     */
    @Override
    public void addProfessor(Professor professor) throws ProfessorNotFoundException ,UserIdAlreadyInUseException {
        adminDaoOperation.addProfessor(professor);
    }

    /**
     * Method to assign course
     * @param courseCode,professorId : courseCode of course,professorId for professor
     */
    @Override
    public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException {
        adminDaoOperation.assignCourse(courseCode,professorId);
    }

    /**
     * Method to view courses
     */
    @Override
    public List<Course> viewCourses() {
        return adminDaoOperation.viewCourses();
    }

    /**
     * Method to view professor
     */
    @Override
    public List<Professor> viewProfessors() {
        return adminDaoOperation.viewProfessors();
    }

    /**
     * Method to generate report card
     * @param studentId : studentId of student
     */
    @Override
    public List<EnrolledStudent> generateGradeCard(String studentId) {
        return adminDaoOperation.generateGradeCard(studentId);
    }

    /**
     *
     * @param studentId
     */
    @Override
    public boolean getRegistrationStatus(String studentId) {
        try
        {
            return adminDaoOperation.getRegistrationStatus(studentId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean checkCourse(String courseCode, String studentId, List<Course> availableCourseList) throws CourseLimitExceededException, CourseNotFoundException, CourseAlreadyRegisteredException {

        try {
            int response = adminDaoOperation.checkCourseAvailability(studentId, courseCode);

            if (response == 0){
                throw new CourseLimitExceededException(6);
            }
            else if (response == 1) {
                throw new CourseAlreadyRegisteredException(courseCode);
            }
            else if (!adminDaoOperation.seatAvailable(courseCode)) {
                throw new SeatNotAvailableException(courseCode);
            }
            else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList)){
                throw new CourseNotFoundException(courseCode);
            }

            return true;

        }
        catch (SQLException | SeatNotAvailableException e) {
            System.out.println(e.getMessage());

        }

        return false;

    }

}
