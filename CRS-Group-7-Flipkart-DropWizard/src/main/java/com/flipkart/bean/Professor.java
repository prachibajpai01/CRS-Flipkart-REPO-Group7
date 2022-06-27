package com.flipkart.bean;

/**
 * Professor class for storing information on an individual professor
 */
public class Professor extends User{

    /**
     * Department of professor
     */
    private String department;

    /**
     * designation of professor
     */
    private String designation;

    /**
     * Professor constructor
     * @param department department of professor
     * @param designation designation of professor
     * @param id ID of professor
     */
    public Professor(String department,String designation,String id){
        this.department = department;
        this.designation = designation;
        this.setUserId(id);
    }

    /**
     * Professor constructor
     */
    public Professor(){}

    /**
     * Department getter
     * @return Department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Department setter
     * @param department set department of professor
     */

    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Designation getter
     * @return designation
     */

    public String getDesignation() {
        return designation;
    }

    /**
     * designation setter
     * @param designation set designation of professor
     */

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
