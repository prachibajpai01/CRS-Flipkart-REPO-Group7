package com.flipkart.exception;

public class GradeNotAddedException extends Exception {
    String studentId,courseId;

    /**
     * Constructor
     * @param studentId : student Id
     * @param courseId: course Id
     */

    public GradeNotAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Message to be thrown
     */

    @Override
    public String getMessage(){
        return "Grade of student "+studentId+" for course "+courseId+" is not assigned";
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
