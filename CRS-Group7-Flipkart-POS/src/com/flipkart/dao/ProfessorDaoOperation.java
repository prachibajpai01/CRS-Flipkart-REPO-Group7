package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.service.CourseCatalogueImpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDaoOperation {

    public boolean addGrade(int studentId,String courseCode,String grade){

        Connection connection=DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update GradeCard set Grade=? where courseId=? and studentId=?");

            statement.setString(1, grade);
            statement.setString(2, courseCode);
            statement.setInt(3, studentId);

            int row = statement.executeUpdate();

            if(row==1)
                return true;
            else
                return false;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    public List<EnrolledStudent> viewEnrolledStudents(String profId){

        return null;
    }


    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue){

        ArrayList<Course> courseData = null;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement("select courseId courseName instructorId  from CourseCatalogue where professorId = ?");

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                courseData.add(new Course(rs.getString("courseId"),rs.getString("courseName"),rs.getString("professorId"),results.getInt("seats")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseData;
    }


    public Professor getProfessorById(String profId){
        Professor professorData = null;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement("select department designation from Professor where professorId = ?");

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return professorData;
    }
}
