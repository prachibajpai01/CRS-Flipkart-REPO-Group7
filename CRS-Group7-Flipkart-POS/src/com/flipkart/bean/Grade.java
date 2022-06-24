package com.flipkart.bean;

// class to store information of grade in a particular course

/**
 * Grade class for storing grade given to a student in a course.
 */
public class Grade {

    /**
     * ID of course
     */
    private int courseId; // every course has an ID

    /**
     * Grade received in course.
     */
    private String grade; // grade for the course

    /**
     * Course code getter
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets course Id
     * @param courseId
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Shows grade
     * @return Grade
     */

    public String getGrade() {
        return grade;
    }

    /**
     * Grade setter
     * @param grade Grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }



}
