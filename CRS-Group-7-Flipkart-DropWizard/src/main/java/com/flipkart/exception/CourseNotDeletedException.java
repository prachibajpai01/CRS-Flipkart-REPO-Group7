package com.flipkart.exception;
/**
 * Exception to check if course is not deleted
 */
public class CourseNotDeletedException extends Exception {
    private String courseId;

    /**
     * Constructor
     * @param courseId: courseId of the course
     */
    public CourseNotDeletedException(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "Course with courseid : " + courseId + " can not be deleted";
    }

    public static void main(String args[]) {
        String exampleCourseId = "1231";
        try {
            throw new CourseNotDeletedException(exampleCourseId);
        } catch (CourseNotDeletedException e) {
            System.out.println(e);
        }
    }
}