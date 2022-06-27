package com.flipkart.dao;

import com.flipkart.bean.*;

import com.flipkart.constant.SQLQueriesConstants;

import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoOperation implements StudentDaoInterface {

    @Override
    public void register(String userName, String userId, String password, int batch, String branch) {

        Connection connection = DatabaseUtil.getConnection();
        System.out.println("y");
        Student stu = new Student();
        stu.setUserName(userName);
        stu.setUserId(userId);
        stu.setPassword(password);
        stu.setBatch(batch);
        stu.setBranchName(branch);

        this.addUser(stu);

        try {
            String sql = SQLQueriesConstants.REGISTER_STUDENT;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, branch);
            statement.setInt(3, 0);

            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't register the student");
            } else {
                System.out.println("Student registered successfully");
            }

        } catch (SQLException se) {
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }
    }

    @Override
    public Boolean addCourse(String userId, String courseId){
        try{
            Connection connection = DatabaseUtil.getConnection();
            String sql = SQLQueriesConstants.ADD_COURSE_FOR_STUDENT;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setInt(2, 0);
            stmt.setString(3, courseId);
            stmt.setString(4, "None");

            System.out.println(stmt);
            int row = stmt.executeUpdate();

            if (row == 0) {
                System.out.println("Could not add course");
            } else {
                System.out.println("Course added successfully");
                return true;
            }

        }catch (SQLException se){
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }
        return false;
    }

    @Override
    public String getStudentId(String userId) {
        return userId;
    }

    @Override
    public boolean isApproved(String studentId) {
        Connection connection = DatabaseUtil.getConnection();

        try {
            String sql = SQLQueriesConstants.IS_APPROVED;
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, studentId);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                //return true;

                if(Integer.parseInt(resultSet.getString(1)) == 1) {
                    System.out.println("Student was approved");
                    return true;
                }
                else {
                    System.out.println("Student is not approved");
                    return false;
                }
            }
            else{
                System.out.println("Student is not approved");
                return false;
            }
        } catch (SQLException se) {
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }

    }

    @Override
    public  Boolean dropCourse(String userId, String courseId) {
        try{
            Connection connection = DatabaseUtil.getConnection();
            String sql = SQLQueriesConstants.DROP_COURSE_FOR_STUDENT;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, courseId);

            System.out.println(stmt);
            int row = stmt.executeUpdate();

            if (row == 0) {
                System.out.println("Could not drop course");
            } else {
                System.out.println("Course dropped successfully");
                return true;
            }

        }catch (SQLException se){
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }
        return false;
    }

    @Override
    public List<Course> viewCourseList(String studentId) {
        Connection connection = DatabaseUtil.getConnection();

        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VIEW_AVAILABLE_COURSES);
            preparedStatement.setString(1,studentId);
            preparedStatement.setBoolean(2,true); // is offered

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Course course = new Course();
                course.setCourseSeats(resultSet.getInt("courseSeats"));
                course.setCourseName(resultSet.getString("cName"));
                course.setCourseId(resultSet.getString("cCode"));
                course.setInstructorId(resultSet.getString("instructor"));
                course.setOffered(resultSet.getBoolean("isOffered"));
                courseList.add(course);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return courseList;
    }


    @Override
    public List<EnrolledStudent> viewRegisteredCourses(String userId) {
        Connection connection = DatabaseUtil.getConnection();

        List<EnrolledStudent> registeredCourses = new ArrayList<>();
        String sql = SQLQueriesConstants.VIEW_REGISTERED_COURSES;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                EnrolledStudent course = new EnrolledStudent();
                course.setCourseCode(resultSet.getString("courseCode"));
                course.setSem(resultSet.getInt("semester"));
                course.setStudentId(userId);
                course.setGrade(resultSet.getString("grade"));
                registeredCourses.add(course);
            }
            System.out.println("this is viewing registered courses");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registeredCourses;
    }

    @Override
    public List<EnrolledStudent> viewGradeCard(String studentId) {
        List<EnrolledStudent> registeredCourses = new ArrayList<EnrolledStudent>();
        Connection conn = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQLQueriesConstants.VIEW_GRADE_CARD);

            preparedStatement.setString(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                registeredCourses.add(new EnrolledStudent(resultSet.getString("courseCode"),
                        resultSet.getString("studentId"), resultSet.getInt("semester"), resultSet.getString("grade")));
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception Thrown : " + ex.getMessage());
        }

        return registeredCourses;
    }

    public void addUser(User user) {
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, "student");

            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("User added successfully");
            } else {
                System.out.println("User couldn't be added");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}