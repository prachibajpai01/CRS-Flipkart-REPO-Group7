package com.flipkart.service;

public class UserImpl implements UserInterface{
    @Override
    public Boolean authenticate(String username, String password) {
        System.out.println("Inside authentication");
        return null;
    }

    @Override
    public String getRole(String username) {
        System.out.println("Getting the role..");
        return null;
    }

    @Override
    public Boolean updatePassword(String username, String newPassword, String oldPassword) {
        System.out.println("Updating password...");
        return null;
    }
}
