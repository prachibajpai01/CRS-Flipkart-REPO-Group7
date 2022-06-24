package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

/**
 * Notification class for storing information on individual notifications
 */
public class Notification {

    /**
     * ID for notification
     */
    private int notificationId;

    /**
     * message in the notification
     */
    private String message;

    /**
     * type of notification
     */
    private NotificationType notificationType;

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
        this.notificationId = notificationId;
        this.message = message;
    }

    /**
     * Notification Id getter
     * @return Notification Id
     */

    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Notification Id setter
     * @param notificationId set notification ID
     */

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
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

    public NotificationType getNotificationType() {
        return notificationType;
    }

    /**
     * Notification Type Setter
     * @param notificationType set notification type
     */

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

}
