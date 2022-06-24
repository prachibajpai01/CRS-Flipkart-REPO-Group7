package com.flipkart.dao;

import com.flipkart.bean.*;

import com.flipkart.service.CourseCatalogueImpl;

import com.flipkart.constant.SQLQueriesConstants;

import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoOperation implements StudentDaoInterface {

    @Override
    public void register(String userName, String userId, String password, int batch, String branch, String address) {

        Connection connection = DatabaseUtil.getConnection();
        System.out.println("y");
        Student stu = new Student();
        stu.setName(userName);
        stu.setUserId(userId);
        stu.setPassword(password);
        stu.setBatch(batch);
        stu.setBranchName(branch);
        stu.setAddress(address);

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

    public static void main(String args[]){
        //System.out.println(addCourse("akash", "01"));
        //System.out.println(dropCourse("akash", "01"));
    }

    @Override
    public String getStudentId(String userId) {
        return userId;
    }

    @Override
    public boolean isApproved(String studentId) {
        return false;
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
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue) {
        return null;
    }

    @Override
    public void viewRegisteredCourses(String userId) {

    }

    @Override
    public GradeCard viewGradeCard(int studentId) {
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
    @Override
    public String getStudentId(String userId) {
        Connection connection=DatabaseUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement("studentid=?");

        try{

            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            Student stu = new Student();
            System.out.println(rs);
            if(rs.next()){
                stu.setUserId(rs.getString(1));
                stu.setBranchName(rs.getString(2));
                stu.setApproved(rs.getBoolean(3));
            }
        }
        catch( SQLException se){
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }

        return null;
    }

/*
public Student getStudentById(String userId) {
        String sql = SQLQueriesConstants.GET_STUDENT_BY_ID_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            Student st = new Student();
            System.out.println(rs);
            if (rs.next()) {
                st.setStudentID(Integer.parseInt(rs.getString(1)));
                st.setName(rs.getString(2));
                st.setBranch(rs.getString(3));
                st.setBatch(rs.getInt(4));
                st.setAddress(rs.getString(5));
                st.setApproved(rs.getBoolean(6));
                st.setHasRegistered(rs.getBoolean(7));
                st.setDonePayment(rs.getBoolean(8));
            }
            return st;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }
 */


/*

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
 */

/*

    @Override
    public boolean isApproved(String studentId) {
        Connection connection=DatabaseUtil.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("studentid=?");
            statement.setString(1, String.valueOf(studentId));
            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                if(rs.getInt(1)==1){
                    return true;
                }
            }
        }
        catch( SQLException se){
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }

        return false;
    }

    /*
    public boolean isApproved(String studentId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.IS_APPROVED_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(studentId));
            System.out.println(statement.toString());
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

     */


    /*

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
     */

    /*
    @Override
    public void addCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue) {
        Connection connection=DatabaseUtil.getConnection();
        System.out.println("y");
        try{
            String sql1 = SQLQueriesConstants.ADD_COURSE;
            PreparedStatement statement = connection.prepareStatement(sql1);
            statement.setString(1, courseId);
            ResultSet rs = statement.executeQuery();
            int availableSeats = 0;
            if (rs.next()) {
                availableSeats = rs.getInt(1);
            }
            if (availableSeats <= 0) {
                System.out.println("No seats available");
                return;
            }
            String sql2 = SQLQueriesConstants.ADD_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);

            statement.setString(1, userId);
            statement.setString(2, courseId);

            statement.setBoolean(3, primary.equals("Y"));

            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't add course");
                return;
            }
            System.out.println("Course Added Successfully");
            String sql3 = SQLQueriesConstants.UPDATE_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql3);
            statement.setString(1, courseId);

            System.out.println(statement.toString());

            statement.executeUpdate();
        }
        catch(SQLException se){
            System.out.println("exception executed");
            throw new RuntimeException(se);
        }

    }

    /*

    public boolean addCourse(String userId, String courseCode, String primary) {

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


        System.out.println(statement.toString());

        int row = statement.executeUpdate();

        if (row == 0) {
            System.out.println("Couldn't add course");
            return false;
        }
        System.out.println("Course Added Successfully");
        String sql2 = SQLQueriesConstants2.UPDATE_COURSE_STUDENT_QUERY;
        statement = connection.prepareStatement(sql2);
        statement.setString(1, courseCode);

        System.out.println(statement.toString());

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return true;
}
     */

     /*

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
     */
/*
    @Override
    public void dropCourse(String userId, String courseId, CourseCatalogueImpl courseCatalogue) {

    }
/*
public boolean dropCourse(String userId, String courseCode) {
        statement = null;
        try {
            String sql = SQLQueriesConstants2.DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);
            statement.setString(2, courseCode);

            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            System.out.println(row);
            if (row == 0) {
                System.out.println("Couldn't drop course");
                return false;
            }
            System.out.println("Dropped Successfully");
            String sql2 = SQLQueriesConstants2.UPDATE_DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);
            statement.setString(1, courseCode);

            System.out.println(statement.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
 */

   /*
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
     */

    /*
    @Override
    public ArrayList<Course> viewCourseList(CourseCatalogueImpl courseCatalogue) {
        return null;
    }

    @Override
    public void viewRegisteredCourses(String userId) {

    }

    @Override
    public List<Grade> viewGradeCard(int studentId) {
        return null;
    }
}
/*
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
 */




/*

public class StudentDaoImpl implements StudentDaoInterface {
    private static StudentDaoImpl instance = null;
    private PreparedStatement statement = null;

    private StudentDaoImpl() {
    }

    public static StudentDaoImpl getInstance() {
        if (instance == null) {
            instance = new StudentDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1 = new Student(userID, name, password, Role.STUDENT, Integer.parseInt(userID), branch, batch, false, address, false, false);
        String sql = SQLQueriesConstants.STUDENT_REGISTRATION_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userID);
            statement.setString(2, name);
            statement.setString(3, branch);
            statement.setInt(4, batch);
            statement.setString(5, address);
            statement.setBoolean(6, false);
            statement.setBoolean(7, false);
            statement.setBoolean(8, false);


            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Couldn't add the course");
            }
            System.out.println("Added successfully");

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean semesterRegistration(String userId) {

        statement = null;
        try {

            String sql1 = SQLQueriesConstants.SEMESTER_REGISTRATION_UPDATE_QUERY;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, userId);
            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't Register Student");
                return false;
            }
            System.out.println("Registered Successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentById(String userId) {
        String sql = SQLQueriesConstants.GET_STUDENT_BY_ID_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            Student st = new Student();
            System.out.println(rs);
            if (rs.next()) {
                st.setStudentID(Integer.parseInt(rs.getString(1)));
                st.setName(rs.getString(2));
                st.setBranch(rs.getString(3));
                st.setBatch(rs.getInt(4));
                st.setAddress(rs.getString(5));
                st.setApproved(rs.getBoolean(6));
                st.setHasRegistered(rs.getBoolean(7));
                st.setDonePayment(rs.getBoolean(8));
            }
            return st;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isApproved(String studentId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.IS_APPROVED_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(studentId));
            System.out.println(statement.toString());
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


                System.out.println(statement.toString());

                int row = statement.executeUpdate();

                if (row == 0) {
                System.out.println("Couldn't add course");
                return false;
                }
                System.out.println("Course Added Successfully");
                String sql2 = SQLQueriesConstants2.UPDATE_COURSE_STUDENT_QUERY;
                statement = connection.prepareStatement(sql2);
                statement.setString(1, courseCode);

                System.out.println(statement.toString());

                statement.executeUpdate();
                } catch (SQLException e) {
                e.printStackTrace();
                }
                return true;
                }

@Override
public boolean dropCourse(String userId, String courseCode) {
        statement = null;
        try {
        String sql = SQLQueriesConstants2.DROP_COURSE_STUDENT_QUERY;
        statement = connection.prepareStatement(sql);

        statement.setString(1, userId);
        statement.setString(2, courseCode);

        System.out.println(statement.toString());

        int row = statement.executeUpdate();
        System.out.println(row);
        if (row == 0) {
        System.out.println("Couldn't drop course");
        return false;
        }
        System.out.println("Dropped Successfully");
        String sql2 = SQLQueriesConstants2.UPDATE_DROP_COURSE_STUDENT_QUERY;
        statement = connection.prepareStatement(sql2);
        statement.setString(1, courseCode);

        System.out.println(statement.toString());

        statement.executeUpdate();

        } catch (SQLException e) {
        e.printStackTrace();
        }
        return true;
        }

@Override
public List<String> viewRegisteredCourses(String userId) {
        statement = null;
        List<String> registeredCourses = new ArrayList<>();
        try {
        String sql = SQLQueriesConstants2.VIEW_REGISTERED_COURSES_STUDENT_QUERY;
        statement = connection.prepareStatement(sql);
        statement.setString(1, userId);
        System.out.println(statement.toString());
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
        registeredCourses.add(resultSet.getString(2));
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return registeredCourses;
        }

@Override
public List<String> viewAddedCourses(String userId) {
        statement = null;
        List<String> registeredCourses = new ArrayList<>();
        try {
        String sql = SQLQueriesConstants2.VIEW_ADDED_COURSES_STUDENT_QUERY;
        statement = connection.prepareStatement(sql);
        statement.setString(1, userId);
        System.out.println(statement.toString());
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
        registeredCourses.add(resultSet.getString(2));
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return registeredCourses;
        }

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

@Override
public boolean approvePayment(String userId) {
        // check primary and optional courses requirements
        // make payment and update payment table
        statement = null;
        try {
        String sql1 = SQLQueriesConstants.MAKE_PAYMENT_STUDENT_QUERY;
        statement = connection.prepareStatement(sql1);
        statement.setString(1, userId);
        System.out.println(statement.toString());

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

@Override
public boolean checkRegistrationEligibility(String userId) {
        statement = null;
        try {
        String sql = SQLQueriesConstants.SEMESTER_REGISTRATION_STUDENT_QUERY;
        statement = connection.prepareStatement(sql);
        statement.setString(1, userId);
        System.out.println(statement.toString());
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
        return true;
        }

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
        System.out.println(statement.toString());

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
        }
 */