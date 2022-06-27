package com.flipkart.service;

import com.flipkart.exception.UserNotFoundException;

public interface UserInterface {
    /**
     * Method to authenticate the user
     * @param userId: userId of the user
     * @param password: password of user
     * @return whether user authenticated
     */
    public Boolean authenticate(String userId, String password) throws UserNotFoundException;

    /**
     * Method to getrole of the user
     * @param userId: userId of the user
     * @return the role string
     */
    public String getRole(String userId);

    /**
     * Method to update password of the user
     * @param userId userId of the user
     * @param newPassword new password of user
     * @return whether password is updated
     */
    public Boolean updatePassword(String userId, String newPassword);
}
