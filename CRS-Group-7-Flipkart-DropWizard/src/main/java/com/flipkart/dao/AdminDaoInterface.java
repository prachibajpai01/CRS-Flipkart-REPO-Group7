package com.flipkart.dao;

import com.flipkart.bean.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface AdminDaoInterface {
    public void deleteCourse(String courseCode);
    public void addCourse(Course course);
    public List<Student> viewPendingAdmissions();
    public void approveStudent(String studentId);
    public void addProfessor(Professor professor);

    public void addUser(User user);
    public void assignCourse(String courseCode, String professorId);
    public List<Course> viewCourses();
    public List<Professor> viewProfessors();

    public List<EnrolledStudent> generateGradeCard(String studentId);

    /**
     *  Method to get student registration status
     * @param studentId
     * @return
     * @throws java.sql.SQLException
     */
    public boolean getRegistrationStatus(String studentId) throws SQLException;

    int checkCourseAvailability(String studentId, String courseCode) throws SQLException;

    boolean seatAvailable(String courseCode) throws SQLException;
}
