package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;

public class ProfessorDaoOperation implements ProfessorDaoInterface{

    public boolean addGrade(String studentId,String courseCode,String grade){

        Connection connection=DatabaseUtil.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);

            statement.setString(1, grade);
            statement.setString(2, courseCode);
            statement.setString(3, studentId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
        }
        catch (SQLException e) {
            System.out.println("n");
            throw new RuntimeException(e);
        }
        // return true;
    }


    public List<EnrolledStudent> viewEnrolledStudents(String profId){

        Connection connection=DatabaseUtil.getConnection();
        List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.VIEW_ENROLLED_STUDENTS);
            statement.setString(1, profId);

            ResultSet results = statement.executeQuery();
            while(results.next())
            {
                //public EnrolledStudent(String courseCode, String courseName, int studentId)
                EnrolledStudent student = new EnrolledStudent();
                student.setCourseCode(results.getString("cCode"));
                student.setStudentId(results.getString("studentId"));
                student.setSem(results.getInt("semester"));
                enrolledStudents.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enrolledStudents;
    }


    public ArrayList<Course> getCourses(String profId){

        ArrayList<Course> courseData = new ArrayList<>();
        Connection connection=DatabaseUtil.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.VIEW_ASSIGNED_COURSES);

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                courseData.add(new Course(rs.getString("cCode"),rs.getString("cName"),rs.getString("instructor")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseData;
    }
}