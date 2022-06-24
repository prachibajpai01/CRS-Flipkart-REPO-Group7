package com.flipkart.exception;
/**
 * Exception to check if student is not approved by admin
 */
public class StudentNotApprovedException extends Exception {
    String studentId;

    /**
     * Constructor
     * @param studentId: studentId of the student
     */
    public StudentNotApprovedException(String studentId){
        this.studentId=studentId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Student with studentId : "+studentId+" is not approved";
    }

    public static void main(String args[]) {
        String exampleStudentId = "123";
        try {
            throw new StudentNotApprovedException(exampleStudentId);
        } catch (StudentNotApprovedException e) {
            System.out.println(e);
        }
    }
}
