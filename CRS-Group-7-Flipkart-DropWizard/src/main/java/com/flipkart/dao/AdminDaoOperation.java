package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoOperation implements AdminDaoInterface{
    @Override
    public void deleteCourse(String courseCode) {
        Connection connection = DatabaseUtil.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE);
            preparedStatement.setString(1,courseCode);

            int row  = preparedStatement.executeUpdate();

            if(row == 0){
                System.out.println("Course not found in catalog");
            }

            System.out.println("Course with course code :" +courseCode+ " deleted");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
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
        Connection connection = DatabaseUtil.getConnection();

        List<Student> pendingStudentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VIEW_PENDING_ADMISSIONS);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();

                student.setUserId(resultSet.getString(1));
                student.setUserName(resultSet.getString(2));
                student.setPassword(resultSet.getString(3));
                student.setBranchName(resultSet.getString(4));
                student.setRole(Role.STUDENT);
                student.setApproved(false);

                pendingStudentList.add(student);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return pendingStudentList;
    }

    @Override
    public void approveStudent(String studentId) {
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT);
            preparedStatement.setString(1, studentId);
            int row = preparedStatement.executeUpdate();

            if(row > 0){
                System.out.println("Student with username " + studentId + " approved by admin");
            }
            else{
                System.out.println("Student with " + studentId + "not found.");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
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
            preparedStatement.setString(3,professor.getUserName());

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
            preparedStatement.setString(2,user.getUserName());
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
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ASSIGN_COURSE);

            preparedStatement.setString(1,professorId);
            preparedStatement.setString(2,courseCode);
//            System.out.println(preparedStatement);
            int resultRows = preparedStatement.executeUpdate();
            if(resultRows > 0) {
                System.out.println("Course assigned successfully");
            }
            else{
                System.out.println("Couldn't assign course");
            }

        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
    }

    @Override
    public List<Course> viewCourses() {
        Connection connection = DatabaseUtil.getConnection();

        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSE);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Course course = new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                // course code ; course name ; instructor
                courseList.add(course);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return courseList;
    }

    @Override
    public List<Professor> viewProfessors() {
        Connection connection = DatabaseUtil.getConnection();

        List<Professor> professorList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VIEW_PROFESSOR);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Professor professor = new Professor();
                professor.setRole(Role.PROFESSOR);
                professor.setUserName(resultSet.getString("userName"));
                professor.setPassword(resultSet.getString("password"));
                professor.setUserId(resultSet.getString("userId"));
                professor.setDepartment(resultSet.getString("department"));
                professor.setDesignation(resultSet.getString("designation"));

                // department ; designation ; username
                professorList.add(professor);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return professorList;
    }

   @Override
    public List<EnrolledStudent> generateGradeCard(String studentId){
        List<EnrolledStudent> gradeList = new ArrayList<>();

       Connection connection = DatabaseUtil.getConnection();

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.GENERATE_GRADE_CARD);

           ResultSet resultSet = preparedStatement.executeQuery();

           while (resultSet.next()){
               EnrolledStudent grade = new EnrolledStudent(resultSet.getString(3),resultSet.getString(1),resultSet.getInt(2), resultSet.getString(4));
               // course code ; student id ; semester ; grade
               gradeList.add(grade);
           }

       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
        return gradeList;
   }

    /**
     *  Method to get student registration status
     * @param studentId
     * @return
     * @throws SQLException
     */
    @Override
    public boolean getRegistrationStatus(String studentId) throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        PreparedStatement stmt;
        boolean status = false;
        try
        {
            stmt = conn.prepareStatement(SQLQueriesConstants.GET_REGISTRATION_STATUS);
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            status = rs.getBoolean(1);

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());

        }
        finally {
            conn.close();
        }

        return status;
    }

    /**Method to checkCourseAvailability , if course is already registered by student then return 1 ,
     * if number of registered courses by student is greater than 5 then return 0, else return 2
     * @param studentId
     * @param courseCode
     * @return
     * @throws SQLException
     */

    @Override
    public int checkCourseAvailability(String studentId, String courseCode) throws SQLException{

        Connection conn = DatabaseUtil.getConnection();
        PreparedStatement stmt;

        int count = 0;
        try {

            stmt = conn.prepareStatement(SQLQueriesConstants.CHECK_COURSE_AVAILABILITY);
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if(courseCode.equals(rs.getString("courseCode")))
                    return 1;
                count++;
            }

            if(count >= 6)
                return 0;


        }
        catch (SQLException se)
        {

            System.out.println(se.getMessage());

        }
        catch (Exception e)
        {

            System.out.println(e.getMessage());
        }
        finally
        {
            conn.close();
        }

        return 2;
    }

    /**
     * Check if seat is available for that particular course
     * @param courseCode
     * @return
     * @throws SQLException
     */
    @Override
    public boolean seatAvailable(String courseCode) throws SQLException {

        Connection conn = DatabaseUtil.getConnection();
        PreparedStatement stmt;
        try
        {
            stmt = conn.prepareStatement(SQLQueriesConstants.GET_SEATS);
            stmt.setString(1, courseCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("seats"));
                return (rs.getInt("seats") > 0);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            conn.close();
        }

        return true;


    }
}
