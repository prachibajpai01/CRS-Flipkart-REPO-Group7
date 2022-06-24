package com.flipkart.dao;

import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static Boolean authenticate(String userId, String password){
        Connection connection = DatabaseUtil.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(SQLQueries.VERIFY_CREDENTIALS);
            stmt.setString(1, userId);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("Current user: "+rs.getString("userName"));
                return true;
            }
            else{
                System.out.println("User not found");
            }
        }catch (SQLException se){
            System.out.println(se);
        }
        return false;
    }

    public static Boolean updatePassword(String userId, String newPassword){
        Connection connection = DatabaseUtil.getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(SQLQueries.UPDATE_PASSWORD);

            stmt.setString(1,newPassword);
            stmt.setString(2,userId);

            int resultRows = stmt.executeUpdate();
            if(resultRows > 0) {
                System.out.println("Updated the password successfully");
                return true;
            }
            else{
                System.out.println("Couldn't update password");
            }

        }catch (SQLException se){
            System.out.println(se);
        }
        return false;
    }
}
