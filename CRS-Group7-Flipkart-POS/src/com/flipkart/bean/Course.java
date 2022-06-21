package com.flipkart.bean;

public class Course {
    private String courseId;
    private String courseName;
    private String instructorId;

    public Course(){

    };
    public Course(String courseId, String courseName, String  instructorId){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
    };


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

}
