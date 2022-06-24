package com.flipkart.bean;

public class EnrolledStudent {
    private String courseCode;
    private String courseName;
    private String studentId;

    public EnrolledStudent(String courseCode, String courseName, String  instructorId){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentId = instructorId;
    };

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
