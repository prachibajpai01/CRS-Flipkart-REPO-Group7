package com.flipkart.constant;

public class SQLQueries {
    public static final String VERIFY_CREDENTIALS = "SELECT * FROM user WHERE userName = ? AND password = ?";
    public static final String UPDATE_PASSWORD = "UPDATE user SET password=? WHERE userName=?";
}
