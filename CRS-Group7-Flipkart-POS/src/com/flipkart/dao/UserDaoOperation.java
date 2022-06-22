package com.flipkart.dao;

public class UserDaoOperation implements UserDaoInterface{

    @Override
    public Boolean authenticate(String userId, String password) {
        return null;
    }

    @Override
    public String getRole(String userId) {
        return null;
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        return null;
    }
}
