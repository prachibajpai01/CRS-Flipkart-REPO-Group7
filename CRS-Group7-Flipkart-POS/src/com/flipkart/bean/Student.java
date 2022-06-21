package com.flipkart.bean;

public class Student extends User{

    private String branchName;
    private int batch;
    private Boolean isApproved;


    public Student(String branchName, int batch,Boolean isApproved,String id){
        this.branchName = branchName;
        this.batch = batch;
        this.isApproved = isApproved;
        this.setUserId(id);
    };

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
