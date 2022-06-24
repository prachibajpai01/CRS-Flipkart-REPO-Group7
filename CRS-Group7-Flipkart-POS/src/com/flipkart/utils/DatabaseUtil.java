package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public static Connection connection = null;

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost/CRSDatabase";
    final static String USER = "root";
    final static String PASS = "Blue_176434";

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

    public static void main(String args[]){
        Connection du = DatabaseUtil.getConnection();
    }
}
