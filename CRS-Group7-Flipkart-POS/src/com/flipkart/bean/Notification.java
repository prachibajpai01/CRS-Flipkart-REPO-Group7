package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

public class Notification {

    private int notificationId; // ID for a particular notification
    private String message; // the message of the notification

    private NotificationType notificationType; // type of notification

    public Notification(){}

    public Notification(int notificationId,String message){
        this.notificationId = notificationId;
        this.message = message;
    }

    // getters and setters of attributes

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

}
