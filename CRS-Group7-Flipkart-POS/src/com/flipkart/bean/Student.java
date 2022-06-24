package com.flipkart.bean;

// student inherits from user
public class Student extends User{

    private String branch; // branch of student
    private int batch; // batch of student
    private Boolean isApproved; // whether student is approved for semester


    public Student(String branch, int batch,Boolean isApproved,String id){
        this.branch = branch;
        this.batch = batch;
        this.isApproved = isApproved;
        this.setUserId(id);
    };

    // getters and setters of various attributes
    public Student(){};

    public String getBranchName() {
        return branch;
    }

    public void setBranchName(String branch) {
        this.branch = branch;
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
