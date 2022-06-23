package com.flipkart.bean;

// class to store information of grade in a particular course

public class Grade {
    private int courseId; // every course has an ID
    private String grade; // grade for the course

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}
