package com.flipkart.dao;

import com.flipkart.bean.*;

import com.flipkart.service.CourseCatalogueImpl;

import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;

import com.flipkart.utils.DatabaseUtil;

//import com.flipkart.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoOperation implements StudentDaoInterface {

    @Override
    public void register(String name, String userId, String password, int batch, String branch, String address) {

        Connection connection = DatabaseUtil.getConnection();
        System.out.println("y");

        Student stu = new Student();
        stu.setName(name);
        stu.setUserId(userId);
        stu.setPassword(password);
        stu.setBatch(batch);
        stu.setBranchName(branch);
        stu.setAddress(address);

        this.addUser(stu);

        try {
            String sql = SQLQueriesConstants.REGISTER_STUDENT;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
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
    public void addCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue) {
        Connection connection = DatabaseUtil.getConnection();
        System.out.println("y");
        Course course = new Course();

    }

    @Override
    public void dropCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue) {

    }

    @Override
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue) {
        return null;
    }


    @Override
    public void viewRegisteredCourses(String userId) {
        Connection connection = DatabaseUtil.getConnection();
        String sql = SQLQueriesConstants.VIEW_REGISTERED_COURSES;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next())
            {
                System.out.println("Semester - " + resultSet.getInt("semester") + " - " + resultSet.getString("courseCode"));
            }
            System.out.println("this is viewing registered courses");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GradeCard> viewGradeCard(int studentId) {
        return null;
    }

    public void addUser(User user) {
        Connection connection = DatabaseUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, "student");
            preparedStatement.setString(5, user.getAddress());

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

/*
    public boolean isApproved(String studentId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.IS_APPROVED_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(studentId));
//            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCourse(String userId, String courseCode, String primary) {

        /*
        check if there are available seats
         */
/*
        statement = null;
        try {
            String sql0 = SQLQueriesConstants2.CHECK_AVAILABLE_SEATS;
            statement = connection.prepareStatement(sql0);
            statement.setString(1, courseCode);
            ResultSet rs = statement.executeQuery();
            int availableSeats = 0;
            if (rs.next()) {
                availableSeats = rs.getInt(1);
            }

            if (availableSeats <= 0) {
                System.out.println("No seats available");
                return false;
            }
            String sql = SQLQueriesConstants2.ADD_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);
            statement.setString(2, courseCode);

            statement.setBoolean(3, primary.equals("Y"));


//            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't add course");
                return false;
            }
            System.out.println("Course Added Successfully");
            String sql2 = SQLQueriesConstants2.UPDATE_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);
            statement.setString(1, courseCode);

//            System.out.println(statement.toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Method to drop course of the Student
     * @param userId
     * @param courseCode
     * @return boolean
     */

    /*
    @Override
    public boolean dropCourse(String userId, String courseCode) {
        statement = null;
        try {
            String sql = SQLQueriesConstants2.DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);
            statement.setString(2, courseCode);

//            System.out.println(statement.toString());

            int row = statement.executeUpdate();
//            System.out.println(row);
            if (row == 0) {
                System.out.println("Couldn't drop course");
                return false;
            }
            System.out.println("Dropped Successfully");
            String sql2 = SQLQueriesConstants2.UPDATE_DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);
            statement.setString(1, courseCode);

//            System.out.println(statement.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /*
    @Override
    public List<String> viewRegisteredCourses(String userId) {
        statement = null;
        List<String> registeredCourses = new ArrayList<>();
        try {
            String sql = SQLQueriesConstants2.VIEW_REGISTERED_COURSES_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                registeredCourses.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredCourses;
    }


    /*
    @Override
    public List<String> viewAddedCourses(String userId) {
        statement = null;
        List<String> registeredCourses = new ArrayList<>();
        try {
            String sql = SQLQueriesConstants2.VIEW_ADDED_COURSES_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                registeredCourses.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredCourses;
    }

    /**
     * Method to see list of all the courses
     * @return list of courses
     */

    /*
    @Override
    public List<Course> viewAllCourses() {
        statement = null;
        List<Course> courseList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseCode(resultSet.getString(1));
                course.setName(resultSet.getString(2));
                course.setInstructor(resultSet.getString(3));
                course.setPrerequisites(resultSet.getString(4));
                course.setSeats(resultSet.getInt(5));
                courseList.add(course);

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return courseList;
    }

    /**
     * Method to approve payment of Student
     * @param userId
     * @return
     * {@link Boolean}
     */

    /*
    @Override
    public boolean approvePayment(String userId) {
        // check primary and optional courses requirements
        // make payment and update payment table
        statement = null;
        try {
            String sql1 = SQLQueriesConstants.MAKE_PAYMENT_STUDENT_QUERY;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, userId);
//            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't Make Payment");
                return false;
            }
            System.out.println("Payment Successful");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Method to see the grade card of the student
     * @param userId
     * @return list of student grade
     */

    /*
    @Override
    public List<StudentGrade> viewGradeCard(String userId) {
        statement = null;
        List<StudentGrade> gradeList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants2.VIEW_GRADE_CARD;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                StudentGrade grade = new StudentGrade();
                if(resultSet.getString(3) == null){
                    grade.setGrade(Grade.NA);
                }
                else{
                    grade.setGrade(Grade.valueOf(resultSet.getString(3)));
                }
                grade.setStudentID(resultSet.getString(1));
                grade.setCourseCode(resultSet.getString(2));
                gradeList.add(grade);

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return gradeList;
    }

    /**
     * Method to Check registration eligibility of the student
     * @param userId
     * @return  Boolean
     */

    /*
    @Override
    public boolean checkRegistrationEligibility(String userId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.SEMESTER_REGISTRATION_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            int primary = 0, optional = 0;

            while (rs.next()) {
                if (rs.getInt(1) == 1)
                    primary++;
                else
                    optional++;
            }
            if (primary == 4 && optional == 2) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * method to make payment for the semester
     * @param userId
     * @param transactionId
     * @param paymentMethod
     * @param amount
     * @return Boolean
     */

    /*
    public boolean makePayment(String userId, String transactionId, String paymentMethod, float amount) {
        Payment payment = new Payment(userId, amount, paymentMethod, transactionId);
        String sql = SQLQueriesConstants.PAYMENT_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, transactionId);
            statement.setString(3, paymentMethod);
            statement.setFloat(4, amount);

            // Print query

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Couldn't add Payment");
            }
            System.out.println("Payment Added successfully");
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return true;
    }

    /*
    @Override
    public boolean courseNotAdded(String userId,String courseId){
        statement = null;
        try {

            String sql = SQLQueriesConstants.COURSE_ADD_CHECK_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, courseId);

            ResultSet rs = statement.executeQuery();
            return rs.next();

        }catch(SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
}
 */

