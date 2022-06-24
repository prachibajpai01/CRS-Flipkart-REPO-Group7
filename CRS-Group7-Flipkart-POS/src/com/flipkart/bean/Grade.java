package com.flipkart.bean;

// class to store information of grade in a particular course

public class Grade {

    private String courseId; // every course has an ID
    private String grade; // grade for the course

    // getters and setters for attributes

    /**
     * @return ID of course
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Set ID of course
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Get grade of course
     * @return grade of the course
     */
    public String getGrade() {
        return grade;
    }

    /**
     * set grade for course
     * @param grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
