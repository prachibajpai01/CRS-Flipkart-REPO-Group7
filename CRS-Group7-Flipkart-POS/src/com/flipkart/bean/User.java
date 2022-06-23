package com.flipkart.bean;

import com.flipkart.constant.Role;

public class User {
    private String userId;
    private String password;

    private String userName;
    private String address;

    private Role role;

    public User(){}

    public User(String userId,String password,String userName,Role role){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }

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
