package com.flipkart.bean;

import com.flipkart.constant.Role;

// base class for User which will be inherited by student, professor and admin.
public class User {
    private String userId; // every user has a userId to identify them
    private String password; // password to authenticate

    private String userName; // name of the user
    private String address; // address of the user

    private Role role; // role of user either student, professor or admin

    public User(){}

    public User(String userId,String password,String userName,Role role){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }

    // getters and setters for all attributes
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
