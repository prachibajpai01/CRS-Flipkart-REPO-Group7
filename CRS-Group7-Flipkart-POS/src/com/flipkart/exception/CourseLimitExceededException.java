package com.flipkart.exception;
/**
 * Exception to check if the number of courses registered by student is already 6(4primary + 2secondary)
 */
public class CourseLimitExceededException extends Exception{
    private int noOfCourses;

    /**
     * Constructor
     * @param noOfCourses: number of courses
     */
    public CourseLimitExceededException(int noOfCourses)
    {
        this.noOfCourses = noOfCourses;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage()
    {
        return "You have already registered for " + noOfCourses + " courses";
    }

    public static void main(String args[]) {
        int exampleCourseNo = 6;
        try {
            throw new CourseLimitExceededException(exampleCourseNo);
        } catch (CourseLimitExceededException e) {
            System.out.println(e);
        }
    }
}
