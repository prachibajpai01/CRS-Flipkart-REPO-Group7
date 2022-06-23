package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;

public class UserImpl implements UserInterface{

    UserDaoOperation userDaoOperation = new UserDaoOperation();
    @Override
    public Boolean authenticate(String userId, String password) {
        return userDaoOperation.authenticate(userId,password);
    }

    @Override
    public String getRole(String userId) {
        return userDaoOperation.getRole(userId);
    }

    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        return userDaoOperation.updatePassword(userId,newPassword);
    }
}
