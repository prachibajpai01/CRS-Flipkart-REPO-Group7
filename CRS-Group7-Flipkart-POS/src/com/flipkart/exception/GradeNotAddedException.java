package com.flipkart.exception;
/**
 * Exception to check if grade is not assigned
 */
public class GradeNotAddedException extends Exception {
    String studentId,courseId;

    /**
     * Constructor
     * @param studentId,courseId: studentId of the student,courseId of the course
     */
    public GradeNotAddedException(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Message returned when exception is thrown
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
