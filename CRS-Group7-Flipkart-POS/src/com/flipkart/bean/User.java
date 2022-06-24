package com.flipkart.bean;

import com.flipkart.constant.Role;

/**
 * Base class for student, professor and admin
 */
public class User {

    /**
     * ID of user
     */
    private String userId;

    /**
     * password of user
     */
    private String password;

    /**
     * name of user
     */
    private String userName;

    /**
     * address of user
     */
    private String address;

    /**
     * Role of user
     */
    private Role role;

    /**
     * User constructor
     */
    public User(){}

    /**
     * User constructor
     * @param userId ID of user
     * @param password password of user
     * @param userName name of user
     * @param role role of user
     */
    public User(String userId,String password,String userName,Role role){
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }

    /**
     * Role getter
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Role setter
     * @param role set role of user
     */

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * User ID getter
     * @return user ID
     */

    public String getUserId() {
        return userId;
    }

    /**
     * User Id setter
     * @param userId ID of user
     */

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Password getter
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Password setter
     * @param password set password of user
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Name getter
     * @return name
     */

    public String getUserName() {
        return userName;
    }

    /**
     * Name setter
     * @param name set name of user
     */

    public void setUserName(String name) {
        this.userName = name;
    }

    /**
     * Address getter
     * @return address
     */

    public String getAddress() {
        return address;
    }

    /**
     * Address setter
     * @param address set address of user
     */

    public void setAddress(String address) {
        this.address = address;
    }

}
