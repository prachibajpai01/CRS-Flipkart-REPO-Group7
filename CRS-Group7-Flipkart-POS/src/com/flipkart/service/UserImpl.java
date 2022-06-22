package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

public class UserImpl implements UserInterface{

    HashMap<String, ArrayList<String>> userDetails = new HashMap<>(){{
        put("01", new ArrayList<>(){{
            add("qwer");
            add("professor");
        }});
        put("02", new ArrayList<>(){{
            add("asdf");
            add("professor");
        }});
    }};// userId, arraylist has 2 items - password and role

    @Override
    public Boolean authenticate(String userId, String password) {
        System.out.println("Inside authentication");
        if(!userDetails.containsKey(userId)){
            return false;
        }
        if(userDetails.get(userId).get(0).compareTo(password)!=0){
            return false;
        }
        return true;
    }

    @Override
    public String getRole(String userId) {
        System.out.println("Getting the role..");
        return userDetails.get(userId).get(1);
        //return "professor";
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        System.out.println("Updating password...");
        return null;
    }
}
