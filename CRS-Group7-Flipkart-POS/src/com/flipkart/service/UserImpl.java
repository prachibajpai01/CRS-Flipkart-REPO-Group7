package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;

import java.util.HashMap;

public class UserImpl implements UserInterface{

    HashMap<String, User> userList = new HashMap<String,User>(){{
        put("Ayush",new User("Ayush","flipkart","Ayush", Role.ADMIN));
        put("ABC",new User("ABC","flipkart","ABC", Role.STUDENT));
        put("DEF",new User("DEF","flipkart","DEF", Role.PROFESSOR));
    }};

    @Override
    public Boolean authenticate(String userId, String password) {
        try{
            if(userList.containsKey(userId)){
                User user = userList.get(userId);
                if(user.getPassword().equals(password)){
                    System.out.println("Authenticated Successfully");
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println("Invalid Credentials");
            return false;
        }
        System.out.println("Invalid Credentials");
        return false;
    }

    @Override
    public String getRole(String userId) {
        User user;
        if(userList.containsKey(userId)){
            user = userList.get(userId);
        }
        else{
            System.out.println("No such user with the id");
            return "";
        }
        try{
            String role = String.valueOf(user.getRole());
            return role;
        }catch (Exception e){

        }
        return "";
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        try{
            if(userList.containsKey(userId)){
                User user = userList.get(userId);
                User updatedUser = user;
                user.setPassword(newPassword);
                userList.replace(userId,user,updatedUser);
                return true;
            }
        }catch (Exception e){
            System.out.println("Couldn't update password");
            return false;
        }
        System.out.println("Couldn't update password");
        return false;
    }
}
