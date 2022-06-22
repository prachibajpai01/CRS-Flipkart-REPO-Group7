package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

public class UserImpl implements UserInterface{

    HashMap<String, ArrayList<String>> userDetails = new HashMap<>(){{

    }};// userId, arraylist has 2 items - password and role

    @Override
    public Boolean authenticate(String userId, String password) {
        //if(!userDetails)
        System.out.println("Inside authentication");
        return true;
    }

    @Override
    public String getRole(String userId) {
        System.out.println("Getting the role..");
        return "professor";
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        System.out.println("Updating password...");
        return null;
    }
}
