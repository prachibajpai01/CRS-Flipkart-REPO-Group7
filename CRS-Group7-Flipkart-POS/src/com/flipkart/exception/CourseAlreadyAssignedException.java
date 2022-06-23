package com.flipkart.exception;

public class CourseAlreadyAssignedException extends Exception{
    String courseId;

    public CourseAlreadyAssignedException(String courseId){
        this.courseId=courseId;
    }

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
