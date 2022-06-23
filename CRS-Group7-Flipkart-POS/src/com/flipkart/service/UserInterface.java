package com.flipkart.service;

public interface UserInterface {
    /**
     * Method to authenticate the user
     * @param userId,password: userId of the user,password of the user
     */
    public Boolean authenticate(String userId, String password);

    /**
     * Method to getrole of the user
     * @param userId: userId of the user
     */
    public String getRole(String userId);

    /**
     * Method to update password of the user
     * @param userId,newPassword: userId of the user,password of the user
     */
    public Boolean updatePassword(String userId, String newPassword);
}
