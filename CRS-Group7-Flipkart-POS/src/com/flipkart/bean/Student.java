package com.flipkart.bean;

// student inherits from user
public class Student extends User{

    private String branchName; // branch of student
    private int batch; // batch of student
    private Boolean isApproved; // whether student is approved for semester


    public Student(String branchName, int batch,Boolean isApproved,String id){
        this.branchName = branchName;
        this.batch = batch;
        this.isApproved = isApproved;
        this.setUserId(id);
    };

    // getters and setters of various attributes
    public Student(){};

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

}
