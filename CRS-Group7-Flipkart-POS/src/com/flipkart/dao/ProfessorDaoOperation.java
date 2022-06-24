package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.utils.DatabaseUtil;

public class ProfessorDaoOperation implements ProfessorDaoInterface{

    /*public static void main(String args[]){
        ProfessorDaoOperation p= new ProfessorDaoOperation();
        p.addGrade("1","a","5");
        p.viewEnrolledStudents("P1");
        p.getProfessorById("P1");
    }*/

    public boolean addGrade(String studentId,String courseCode,String grade){

        Connection connection=DatabaseUtil.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("update registeredCourses set grade=? where courseCode=? and studentId=?");

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
            PreparedStatement statement = connection.prepareStatement("Select course.cCode,course.cName,registeredCourses.studentId from course inner join registeredCourses on course.cCode = registeredCourses.courseCode where course.instructor = ? ");
            statement.setString(1, profId);

            ResultSet results = statement.executeQuery();
            while(results.next())
            {
                //public EnrolledStudent(String courseCode, String courseName, int studentId)
                enrolledStudents.add(new EnrolledStudent(results.getString("cCode"),results.getString("cName"),results.getString("studentId")));
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
            PreparedStatement statement = connection.prepareStatement("select cCode,cName, instructor  from course where instructor = ?");

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


    public String getProfessorById(String profId){

        Connection connection=DatabaseUtil.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement("select userId from user where userName = ?");

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();

            rs.next();
            return rs.getString("userId");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}