package com.flipkart.exception;

public class GradeNotAddedException extends Exception {
    String studentId,courseId;

    public GradeNotAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String getMessage(){
        return "GradeCard of student "+studentId+" for course "+courseId+" is not assigned";
    }

    public static void main(String args[]) {
        String exampleStudentId = "123";
        String exampleCourseId = "345";
        try {
            throw new GradeNotAddedException(exampleStudentId,exampleCourseId);
        } catch (GradeNotAddedException e) {
            System.out.println(e);
        }
    }
}
