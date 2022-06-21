package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

public class UserImpl implements UserInterface {
    @Override
    public Boolean authenticate(String userId, String password, HashMap<String, ArrayList<String>> userData) {
        System.out.println("Inside authentication");
        if(userData.get(userId).get(0).compareToIgnoreCase(password)!=0){
            System.out.println("Wrong password");
            return false;
        } else {
            System.out.println("Logged in");
            return true;
        }
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
