package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection connection = null;

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost/CRSDatabase";
    final static String USER = "root";
    final static String PASS = "password";

    public static Connection getConnection() {
        if(connection != null)
            return connection;
        else{
            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL,USER,PASS);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;
    }
}