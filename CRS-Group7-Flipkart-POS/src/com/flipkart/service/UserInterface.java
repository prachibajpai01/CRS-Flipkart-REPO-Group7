package com.flipkart.service;

public interface UserInterface {
    public Boolean authenticate(String username, String password);

    public String getRole(String username);

    public Boolean updatePassword(String username, String newPassword, String oldPassword);
}
