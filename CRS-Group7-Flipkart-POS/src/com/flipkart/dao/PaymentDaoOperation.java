package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * Fetch Payment information for the student
 */

public class PaymentDaoOperation implements PaymentDaoInterface{

    @Override
    public ArrayList<Payment> getPaymentInfo(String studentId){
        ArrayList<Payment> result = new ArrayList<>();
        try{
            Connection conn = DatabaseUtil.getConnection();
            String sql = SQLQueriesConstants.GET_PAYMENT_INFO;
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Payment payment = new Payment(rs.getString("referenceId"),
                        rs.getString("studentId"),
                        rs.getInt("amount"),
                        rs.getBoolean("status"),
                        rs.getString("paymentType"));
                result.add(payment);
            }
        }catch (SQLException se){
            System.out.println("Exception thrown: ");
            System.out.println(se);
        }
        return result;
    }

}
