package com.flipkart.service;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDaoInterface;
import com.flipkart.dao.NotificationDaoOperation;

import java.sql.SQLException;
import java.util.List;

public class NotificationImpl implements NotificationInterface{

    NotificationDaoInterface notificationDaoInterface= new NotificationDaoOperation();
    /**
     * @param message:     Message to be sent
     * @param studentId:   student to be notified
     * @param referenceId: Payment Id
     * @return
     */
    @Override
    public String sendNotification(String message, String studentId, String referenceId) {
        String notificationId="";
        try
        {
            notificationId=notificationDaoInterface.sendNotification(message,studentId,referenceId);

        }
        catch(SQLException ex)
        {
            System.out.println("Error Occured :( " + ex.toString());
        }
        return notificationId;
    }

    /**
     * @param id: notification id added in the database
     * @return
     */
    @Override
    public String getReferenceId(String id) {
        String referenceId="";
        try {
            referenceId = notificationDaoInterface.getReferenceId(id);
        }
        catch(SQLException ex) {
            System.out.println("Error Occured :( " + ex.toString());
        }
        return referenceId;
    }

    /**
     * @param StudentId
     * @return
     * @throws SQLException
     */
    @Override
    public List<Notification> getAllNotifications(String StudentId) throws SQLException {
        List<Notification> notifications = null;
        try {
            notifications = notificationDaoInterface.getAllNotifications(StudentId);
        }
        catch(SQLException ex) {
            throw ex;
        }
        return notifications;
    }

    /**
     * @param StudentId
     * @param amount
     * @param status
     * @param paymentType
     * @return
     * @throws SQLException
     */
    @Override
    public String addPayment(String StudentId, int amount, boolean status, String paymentType) throws SQLException {
        String referenceId = null;
        try {
            referenceId = notificationDaoInterface.addPayment(StudentId,amount,status,paymentType);
        }
        catch(SQLException ex) {
            throw ex;
        }
        return referenceId;
    }

    /**
     * @param StudentId
     * @param Mode
     * @return
     * @throws SQLException
     */
    @Override
    public String updatePayment(String StudentId, String Mode) throws SQLException {
        String referenceId = null;
        try {
            referenceId = notificationDaoInterface.updatePayment(StudentId,Mode);
        }
        catch(SQLException ex) {
            throw ex;
        }
        return referenceId;
    }
}
