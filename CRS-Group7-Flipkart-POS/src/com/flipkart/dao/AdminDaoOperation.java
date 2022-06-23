package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface{
    @Override
    public void deleteCourse(String courseCode) {

    }

    @Override
    public void addCourse(Course course) {
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_COURSE);
            preparedStatement.setString(1, course.getCourseId());
            preparedStatement.setString(2,course.getCourseName());
            preparedStatement.setBoolean(3,true);
            preparedStatement.setInt(4,10);

            int row = preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("Course successfully added to catalog");
            }
            else{
                System.out.println("Course couldn't be added");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }

    @Override
    public void approveStudent(String studentId) {

    }

    @Override
    public void addProfessor(Professor professor) {
        try{
            this.addUser(professor);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Connection connection = DatabaseUtil.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);

            preparedStatement.setString(1,professor.getDepartment());
            preparedStatement.setString(2,professor.getDesignation());
            preparedStatement.setString(3,professor.getName());

            int row = preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("Professor added successfully");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,"professor");

            int row = preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("User added successfully");
            }
            else{
                System.out.println("User couldn't be added");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    @Override
    public Collection<Course> viewCourses() {
        return null;
    }

    @Override
    public List<Professor> viewProfessors() {
        return null;
    }

    @Override
    public void sendNotification(String studentId, Notification notification) {

    }
}
