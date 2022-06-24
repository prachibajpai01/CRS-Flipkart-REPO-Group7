package com.flipkart.bean;

/**
 * Admin class for storing admin information.
 */
public class Admin extends User{

    /**
     * Designation of professor
     */
    private String designation;

    /**
     * Get designation of Admin
     * @return admin designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Set designation of admin
     * @param designation designation value to set for admin
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
