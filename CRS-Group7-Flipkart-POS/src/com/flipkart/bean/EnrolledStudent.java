package com.flipkart.bean;

/**
 * A class for recording enrollment data of a student-course pair.
 */
public class EnrolledStudent {

    /**
     * ID of course
     */
    private String courseId;

    /**
     * Name of course
     */
    private String courseName;

    /**
     * ID of student taking the course
     */
    private int studentId;

    /**
     * Course code getter
     * @return the enrolled course code
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Course code setter
     * @param courseId code for the enrolled course
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Course name getter
     * @return get name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Course name setter
     * @param courseName name of course student is enrolled in
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Student ID getter
     * @return the student ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Student ID setter
     * @param studentId ID of student
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
