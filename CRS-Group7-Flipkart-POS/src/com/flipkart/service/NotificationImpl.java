package com.flipkart.service;

public class NotificationImpl implements NotificationInterface{
    @Override
    public int sendNotification(String message) {
        System.out.println("Sending Notification....");
        return 0;
    }
}
