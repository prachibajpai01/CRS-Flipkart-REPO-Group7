package com.flipkart.bean;

public class EnrolledStudent {
    private String courseCode;
    private int sem;
    private String grade;
    private String studentId;

    public EnrolledStudent(String courseCode, String studentId, int sem, String grade) {
        super();
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.sem = sem;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String  getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
