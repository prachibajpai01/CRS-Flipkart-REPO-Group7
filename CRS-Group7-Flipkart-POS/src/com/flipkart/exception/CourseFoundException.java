package com.flipkart.exception;
/**
 * Exception to check if course is already found in course catalog
 */
public class CourseFoundException extends Exception{
    private String courseId;

    /**
     * Constructor
     * @param courseId
     */
    public CourseFoundException(String courseId){
        this.courseId=courseId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Course with courseid : "+courseId+" is already found in course catalog";
    }

    public static void main(String args[]) {
        String exampleCourseId = "1123";
        try {
            throw new CourseFoundException(exampleCourseId);
        } catch (CourseFoundException e) {
            System.out.println(e);
        }
    }
}
