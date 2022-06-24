package com.flipkart.constant;

/**
 * SQL query templates used
 */
public class SQLQueriesConstants {

    /**
     * SQL query to verify credentials
     */
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND password = ?";

    /**
     * SQL query to get role
     */
    public static final String GET_ROLE = "SELECT role FROM user WHERE userName = ?";

    /**
     * SQL query to update password
     */
    public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? user WHERE userName = ?";

    /**
     * SQL query to add course
     */
    public static final String ADD_COURSE = "INSERT INTO course(cCode,cName,isOffered,courseSeats) values (?,?,?,?)";

    /**
     * SQL query to delete course
     */

    public static final String DELETE_COURSE = "";

    /**
     * SQL query to add user
     */

    public static final String ADD_USER = "INSERT INTO user(userId,userName,password,role) values (?,?,?,?)";

    /**
     * SQL query to add professor
     */

    public static final String ADD_PROFESSOR = "INSERT INTO professor(department,designation,proffId) values (?,?,?)";



}
