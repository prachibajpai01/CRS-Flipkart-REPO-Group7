package com.flipkart.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserInterface {
    public Boolean authenticate(String userId, String password, HashMap<String, ArrayList<String>> userData);

    public String getRole(String userId);

    public Boolean updatePassword(String userId, String newPassword);
}
