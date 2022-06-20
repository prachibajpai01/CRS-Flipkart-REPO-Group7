package com.flipkart.service;

public class UserImpl implements UserInterface{
    @Override
    public Boolean authenticate(String userId, String password) {
        System.out.println("Inside authentication");
        return null;
    }

    @Override
    public String getRole(String userId) {
        System.out.println("Getting the role..");
        return null;
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        System.out.println("Updating password...");
        return null;
    }
}
