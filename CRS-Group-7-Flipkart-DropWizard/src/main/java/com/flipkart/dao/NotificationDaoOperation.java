package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotificationDaoOperation implements NotificationDaoInterface{

    /**
     * Send Notification using SQL commands

     * @param message:     Message to be sent
     * @param studentId:   student to be notified
     * @param referenceId: ReferenceId of the payment
     * @return notification id for the record added in the database
     * @throws SQLException
     */
    @Override
    public String sendNotification(String message, String studentId, String referenceId) throws SQLException {
        String notificationId = "";
        Connection connection = DatabaseUtil.getConnection();
        try {
            // Insert Notification
            notificationId = UUID.randomUUID().toString();
            PreparedStatement ps = connection.prepareStatement(SQLQueriesConstants.INSERT_NOTIFICATION);
            ps.setString(1, notificationId);
            ps.setString(2, message);
            ps.setString(3, studentId);
            ps.setString(4, referenceId);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
        return notificationId;
    }

    /**
     * @param notificationId - Id of the notification received by the user
     * @return ReferenceId - Payment Id of the transaction
     * @throws SQLException
     */
    @Override
    public String getReferenceId(String notificationId) throws SQLException {
        String referenceId = "";
        Connection connection = DatabaseUtil.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_REFERENCE_ID);
            statement.setString(1, notificationId);

            ResultSet results = statement.executeQuery();
            if (results.next())
                referenceId = results.getString(4);
        } catch (SQLException ex) {
            throw ex;
        }
        return referenceId;
    }

    @Override
    public String addPayment(String StudentId, int amount, boolean status, String paymentType) throws SQLException {
        String referenceId;
        Connection connection = DatabaseUtil.getConnection();

        try {
            referenceId = UUID.randomUUID().toString();
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.INSERT_PAYMENT);
            statement.setString(1, referenceId);
            statement.setString(2, StudentId);
            statement.setInt(3, amount);
            statement.setBoolean(4, status);
            statement.setString(5, paymentType);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
        return referenceId;
    }

    @Override
    public String updatePayment(String StudentId, String mode) throws SQLException {
        String referenceId = "";
        Connection connection = DatabaseUtil.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_REFID_PAYMENT);
            statement.setString(1, StudentId);
            ResultSet results = statement.executeQuery();
            if (results.next())
                referenceId = results.getString(1);

            statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PAYMENT);
            statement.setString(1, mode);
            statement.setString(2, StudentId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
        return referenceId;
    }

    @Override
    public List<Notification> getAllNotifications(String studentId) throws SQLException {
        List<Notification> allnotifications = new ArrayList<>();
        Connection connection = DatabaseUtil.getConnection();

        try {
            // select * from notification where studentId=?
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ALL_NOTIFICATIONS);
            statement.setString(1, studentId);

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                allnotifications
                        .add(new Notification(results.getString("notificationId"), results.getString("message"),results.getString("studentId"),
                                 results.getString("referenceId")));
            }
        } catch (SQLException ex) {
            throw ex;
        }

        return allnotifications;
    }
}
