package com.flipkart.constant;

public class SQLQueriesConstants {
    // user DAO operations
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userId = ? AND password = ?";
    public static final String GET_ROLE = "SELECT role FROM user WHERE userId = ?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? WHERE userName = ?";


    // admin dao operations
    public static final String ADD_COURSE = "INSERT INTO course(cCode,cName,isOffered,courseSeats) values (?,?,?,?)";

    public static final String DELETE_COURSE = "DELETE FROM course where cCode = ?";
    public static final String ADD_USER = "INSERT INTO user(userId,userName,password,role) values (?,?,?,?)";
    public static final String ADD_PROFESSOR = "INSERT INTO professor(department,designation,proffId) values (?,?,?)";

    public static final String VIEW_PROFESSOR = "SELECT * FROM professor";

    public static final String VIEW_COURSE = "SELECT cCode,cName,instructor FROM course";

    public static final String ASSIGN_COURSE = "UPDATE course SET instructor = ? WHERE cCode = ?";

    public static final String VIEW_PENDING_ADMISSIONS = "SELECT student.userId, user.userName, student.branch FROM student, user WHERE student.userId = user.userName AND approved = 0";

    public static final String APPROVE_STUDENT = "UPDATE student SET approved = 1 WHERE userId = ?";

    public static final String GENERATE_GRADE_CARD = "SELECT * FROM registered_courses WHERE studentId = ?";

    // student queries

    public static final String REGISTER_STUDENT = "Insert into student (userId,branch,approved) values(?,?,?)";

    public static final String IS_APPROVED = "SELECT isApproved FROM student WHERE userId = ? ";

    public static final String VIEW_REGISTERED_COURSES = "SELECT * FROM registered_courses where studentId=?";

}

