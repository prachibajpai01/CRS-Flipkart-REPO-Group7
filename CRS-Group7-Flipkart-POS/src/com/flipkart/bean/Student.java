package com.flipkart.bean;

/**
 * Student class to store information of individual student
 */
public class Student extends User{

    /**
     * branch of student
     */
    private String branchName;

    /**
     * batch of student
     */
    private int batch;

    /**
     * Whether student is approved for semester
     */
    private Boolean isApproved;

    /**
     * Student constructor
     * @param branchName name of branch
     * @param batch name of batch
     * @param isApproved approval for semester
     * @param id ID of student
     */
    public Student(String branchName, int batch,Boolean isApproved,String id){
        this.branchName = branchName;
        this.batch = batch;
        this.isApproved = isApproved;
        this.setUserId(id);
    };

    public Student(){};

    /**
     * Branch name getter
     * @return Branch Name
     */

    public String getBranchName() {
        return branchName;
    }

    /**
     * Branch Name setter
     * @param branchName set branch name of student
     */

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Batch getter
     * @return batch
     */

    public int getBatch() {
        return batch;
    }

    /**
     * Batch setter
     * @param batch set batch of student
     */

    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * Approved status getter
     * @return approved
     */

    public Boolean getApproved() {
        return isApproved;
    }

    /**
     * Approved status setter
     * @param approved set approved status
     */

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

}
