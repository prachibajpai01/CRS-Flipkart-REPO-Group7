package com.flipkart.Service;

import com.flipkart.dao.UserDAO;

public class UserImpl implements UserInterface{

    @Override
    public Boolean authenticate(String userId, String password) {
        return UserDAO.authenticate(userId, password);
    }


}
