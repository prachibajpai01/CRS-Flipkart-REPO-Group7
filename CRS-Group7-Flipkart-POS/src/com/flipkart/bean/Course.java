package com.flipkart.bean;

/**
 * Course class for storing information of an individual course.
 */
public class Course {

    /**
     * Every course has an ID
     */
    private String courseId;

    /**
     * Every course has a name
     */
    private String courseName;

    /**
     * Every course has an instructor and they have an ID
     */
    private String instructorId;

    /**
     * Whether the course is being offered or not.
     */

    private Boolean isOffered;

    /**
     * Number of seats available
     */

    private Boolean courseSeats;

    /**
     * Basic course constructor without any details
     */
    public Course(){

    };

    /**
     * Course constructor
     * @param courseId ID of course
     * @param courseName Name of course
     * @param instructorId ID of instructor for course
     */
    public Course(String courseId, String courseName, String  instructorId){
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorId = instructorId;
    };


    /**
     * Course ID getter
     * @return course ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Course ID setter
     * @param courseId course ID to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Course name getter
     * @return course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Course name setter
     * @param courseName name of course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Course instructor ID getter
     * @return instructor ID for course
     */
    public String getInstructorId() {
        return instructorId;
    }

    /**
     * Course instructor ID setter
     * @param instructorId instructor ID for course
     */
    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

}
