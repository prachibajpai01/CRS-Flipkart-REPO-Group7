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
import com.flipkart.utils.DBUtils;

public class ProfessorDaoOperation {

    public static void main(String args[]){
        ProfessorDaoOperation p= new ProfessorDaoOperation();
       p.addGrade("1","a","5");
       p.viewEnrolledStudents("P1");
       p.getProfessorById("P1");
    }

    public boolean addGrade(String studentId,String courseCode,String grade){

        Connection connection=DBUtils.getConnection();
        System.out.println("y");
        try {
            PreparedStatement statement = connection.prepareStatement("update GradeCard set Grade=? where courseId=? and studentId=?");

            statement.setString(1, grade);
            statement.setString(2, courseCode);
            statement.setString(3, studentId);

            int row = statement.executeUpdate();

            PreparedStatement s = connection.prepareStatement("select * from GradeCard");
            ResultSet rs =s.executeQuery();
            // System.out.println(rs);
            while(rs.next())
            {
                System.out.println(rs.getString("Grade"));
            }
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

        Connection connection=DBUtils.getConnection();
        List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
        try {
            PreparedStatement statement = connection.prepareStatement("select courseCatalogue.courseId,courseCatalogue.courseName,registeredStudent.userId from courseCatalogue inner join registeredStudent on courseCatalogue.courseId = registeredStudent.courseId where courseCatalogue.professorId = ? ");
            statement.setString(1, profId);

            ResultSet results = statement.executeQuery();
            while(results.next())
            {
                //public EnrolledStudent(String courseCode, String courseName, int studentId)
                System.out.println(results.getString("userId"));
                enrolledStudents.add(new EnrolledStudent(results.getString("courseId"),results.getString("courseName"),results.getString("userId")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(enrolledStudents.);
        return enrolledStudents;
    }


    public ArrayList<Course> getCourses(String profId, CourseCatalogueImpl courseCatalogue){

        ArrayList<Course> courseData = null;
        Connection connection=DBUtils.getConnection();
        try
        {
            PreparedStatement statement = connection.prepareStatement("select courseId,courseName, instructorId  from CourseCatalogue where professorId = ?");

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                courseData.add(new Course(rs.getString("courseId"),rs.getString("courseName"),rs.getString("professorId")));
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
            PreparedStatement statement = connection.prepareStatement("select department,designation from professor where userId = ?");

            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            professorData = (new Professor(rs.getString("department"),rs.getString("designation"),profId));

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(professorData!=null)
        System.out.println(professorData.getDepartment());
        return professorData;
    }
}
