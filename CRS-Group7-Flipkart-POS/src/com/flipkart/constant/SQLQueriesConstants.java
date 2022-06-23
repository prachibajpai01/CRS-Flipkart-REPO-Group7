package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND password = ?";
    public static final String GET_ROLE = "SELECT role FROM user WHERE userName = ?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? user WHERE userName = ?";
    public static final String ADD_COURSE = "INSERT INTO course(cCode,cName,isOffered,courseSeats) values (?,?,?,?)";

    public static final String DELETE_COURSE = "";

    public static final String ADD_USER = "INSERT INTO user(userId,userName,password,role) values (?,?,?,?)";

    public static final String ADD_PROFESSOR = "INSERT INTO professor(department,designation,proffId) values (?,?,?)";



}
