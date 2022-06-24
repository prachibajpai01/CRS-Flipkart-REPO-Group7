package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND password = ?";
    public static final String GET_ROLE = "SELECT role FROM user WHERE userName = ?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? user WHERE userName = ?";
    public static final String ADD_COURSE = "INSERT INTO course(cCode,cName,isOffered,courseSeats) values (?,?,?,?)";

    public static final String DELETE_COURSE = "";

    public static final String ADD_USER = "Insert into user (userId,userName,password,role,address) values(?,?,?,?,?)";

    public static final String ADD_PROFESSOR = "INSERT INTO professor(department,designation,profId) values (?,?,?)";

    public static final String REGISTER_STUDENT = "Insert into student (userId,branch,isApproved) values(?,?,?)";

}
