package com.flipkart.service;

public interface UserInterface {
    public Boolean authenticate(String userId, String password);

    public String getRole(String userId);

    public Boolean updatePassword(String userId, String newPassword);
}
