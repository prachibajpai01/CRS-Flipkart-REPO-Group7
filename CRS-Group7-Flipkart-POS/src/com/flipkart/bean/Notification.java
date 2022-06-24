package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

/**
 * Notification class for storing information on individual notifications
 */
public class Notification {

    public Notification(String notificationId,String message,String studentId,String referenceId){
        this.notificationId = notificationId;
        this.message = message;
        this.studentId = studentId;
        this.referenceId = referenceId;
    };

    /**
     * ID for notification
     */
    private String notificationId;

    /**
     * message in the notification
     */
    private String message;

    /**
     * Student ID for notification
     */
    private String studentId;

    /**
     * reference ID for notification
     */
    private String referenceId;

    /**
     * Notification Id getter
     * @return Notification Id
     */

    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Notification Id setter
     * @param  notificationId
     */

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Student Id getter
     * @return  studentId
     */

    public String getStudentId() {
        return studentId;
    }

    /**
     * Student Id setter
     * @param  studentId
     */

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Reference Id getter
     * @return  referenceId
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Reference Id setter
     * @param  referenceId
     */
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


    /**
     * Notification constructor
     */
    public Notification(){}

    /**
     * Notification constructor
     * @param notificationId ID for notification
     * @param message message for notification
     */
    public Notification(int notificationId,String message){

    }



    /**
     * Message Getter
     * @return Message
     */

    public String getMessage() {
        return message;
    }

    /**
     * Message setter
     * @param message set the message of notification
     */

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Notification Type Getter
     * @return notification type
     */


}
