package com.flipkart.exception;
/**
 * Exception to check if course is not found
 */
public class CourseNotFoundException extends Exception {
    String courseId;

    /**
     * Constructor
     * @param courseId: courseId of the course
     */
    public CourseNotFoundException(String courseId){
        this.courseId=courseId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Course with courseid : "+courseId+" is not found";
    }

    public static void main(String args[]) {
        String exampleCourseId = "1234";
        try {
            throw new CourseNotFoundException(exampleCourseId);
        } catch (CourseNotFoundException e) {
            System.out.println(e);
        }
    }

}
