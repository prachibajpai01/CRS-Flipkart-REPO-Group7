package com.flipkart.service;

import java.util.HashMap;

public class UserImpl implements UserInterface{

    @Override
    public Boolean authenticate(String userId, String password) {
        System.out.println("Inside authentication");
        return true;
    }

    @Override
    public String getRole(String userId) {
        System.out.println("Getting the role..");
        return "student";
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        System.out.println("Updating password...");
        return null;
    }
}
