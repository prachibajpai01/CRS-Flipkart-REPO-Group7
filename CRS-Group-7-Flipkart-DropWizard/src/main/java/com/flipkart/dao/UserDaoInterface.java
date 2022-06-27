package com.flipkart.dao;

public interface UserDaoInterface {
    public Boolean authenticate(String userId, String password);

    public String getRole(String userId);

    public Boolean updatePassword(String userId, String newPassword);
}
