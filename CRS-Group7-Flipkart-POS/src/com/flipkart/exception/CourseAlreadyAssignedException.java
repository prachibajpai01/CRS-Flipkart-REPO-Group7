package com.flipkart.exception;
/**
 * Exception to check if course is already assigned to student
 */
public class CourseAlreadyAssignedException extends Exception{
    String courseId;

    /**
     * Constructor
     * @param courseId
     */
    public CourseAlreadyAssignedException(String courseId){
        this.courseId=courseId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Course with courseid : "+courseId+" is already assigned";
    }

    public static void main(String args[]) {
        String exampleCourseId = "1234";
        try {
            throw new CourseAlreadyAssignedException(exampleCourseId);
        } catch (CourseAlreadyAssignedException e) {
            System.out.println(e);
        }
    }
}
