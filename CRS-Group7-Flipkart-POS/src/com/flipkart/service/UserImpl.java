package com.flipkart.service;

import com.flipkart.dao.UserDaoOperation;

public class UserImpl implements UserInterface{

    UserDaoOperation userDaoOperation = new UserDaoOperation();
    /**
     * Method to authenticate the user
     * @param userId,password: userId of the user,password of the user
     */
    @Override
    public Boolean authenticate(String userId, String password) {
        return userDaoOperation.authenticate(userId,password);
    }

    /**
     * Method to getrole of the user
     * @param userId: userId of the user
     */
    @Override
    public String getRole(String userId) {
        return userDaoOperation.getRole(userId);
    }

    /**
     * Method to update password of the user
     * @param userId,newPassword: userId of the user,password of the user
     */
    @Override
    public Boolean updatePassword(String userId, String newPassword) {
        return userDaoOperation.updatePassword(userId,newPassword);
    }
}
