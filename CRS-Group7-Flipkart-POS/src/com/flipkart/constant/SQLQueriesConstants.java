package com.flipkart.constant;

public class SQLQueriesConstants {
    // user DAO operations
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND password = ?";
    public static final String GET_ROLE = "SELECT role FROM user WHERE userName = ?";
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

    public static final String VIEW_AVAILABLE_COURSES = "SELECT * FROM course WHERE cCode NOT IN  (SELECT courseCode  FROM registered_courses WHERE studentId = ?) AND course.isOffered = ?";

    public static final String VIEW_GRADE_CARD = "SELECT * FROM registered_courses WHERE studentId = ?";

    public static final String ADD_COURSE_FOR_STUDENT = "Insert into registered_courses (studentId, semester, courseCode, grade) values (?,?,?,?)";
    public static final String DROP_COURSE_FOR_STUDENT = "delete from registered_courses where studentId=? and courseCode=?";

    public static final String GET_PAYMENT_INFO = "Select * from payment where studentId=?";

    public static final String IS_APPROVED = "SELECT approved FROM student WHERE userId = ? ";

    public static final String VIEW_REGISTERED_COURSES = "SELECT * FROM registered_courses where studentId=?";

    // professor queries

    public static final String ADD_GRADE = "update registered_courses set grade = ? where courseCode = ? and studentId=?";

    public static final String VIEW_ENROLLED_STUDENTS = "Select course.cCode,course.cName,registered_courses.studentId, registered_courses.semester from course inner join registered_courses on course.cCode = registered_courses.courseCode where course.instructor = ? ";

    public static final String VIEW_ASSIGNED_COURSES = "select cCode,cName, instructor  from course where instructor = ?";

    // notification
    public static final String INSERT_NOTIFICATION = "INSERT INTO notification(notificationId,message,studentId,referenceId) VALUES(?,?,?,?)";

    public static final String GET_REFERENCE_ID = "SELECT * FROM notification WHERE notificationId=?";

    public static final String GET_ALL_NOTIFICATIONS = "SELECT * FROM notification WHERE studentId=?";

    public static final String INSERT_PAYMENT = "INSERT INTO payment(referenceId,studentId,amount,status,paymentType) VALUES(?,?,?,?,?)";

    public static final String UPDATE_PAYMENT = "UPDATE payment SET status = 1, paymentType = ? WHERE status = 0 AND studentId = ?";
    public static final String GET_REFID_PAYMENT = "SELECT referenceId FROM payment WHERE status = 0 AND studentId = ?";

    public static final String MAKE_PAYMENT = "update payment set status=true, paymentType=? where referenceId=?";

}
