package com.flipkart.dao;

import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoOperation implements UserDaoInterface{

    @Override
    public Boolean authenticate(String userId, String password) {
        Connection connection = DatabaseUtil.getConnection();
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);

            preparedStatement.setString(1,userId);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                System.out.println("Current user is -> " + resultSet.getString("userName"));
                return true;
            }
            else{
                System.out.println("User not found");
            }

        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
        return false;
    }

    @Override
    public String getRole(String userId) {
        Connection connection = DatabaseUtil.getConnection();
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.GET_ROLE);

            preparedStatement.setString(1,userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getString("role");
            }
            else{
                System.out.println("No role assigned");
            }

        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
        return null;
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        Connection connection = DatabaseUtil.getConnection();
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);

            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,userId);

            int resultRows = preparedStatement.executeUpdate();
            if(resultRows > 0) {
                System.out.println("Updated the password successfully");
                return true;
            }
            else{
                System.out.println("Couldn't update password");
            }

        }catch (SQLException se){
            System.out.println(se.getMessage());
        }
        return false;
    }
}
