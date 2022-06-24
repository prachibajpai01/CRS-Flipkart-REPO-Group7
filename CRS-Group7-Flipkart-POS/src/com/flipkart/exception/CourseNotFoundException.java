package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
    String courseId;

    /**
     * Parameterized constructor
     * @param courseId : course Id
     */

    public CourseNotFoundException(String courseId){
        this.courseId=courseId;
    }

    /**
     *Message thrown by exception
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
