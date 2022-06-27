package com.flipkart.exception;
/**
 * Exception to check if student is not registered
 */
public class StudentNotRegisteredException extends Exception{
    String studentId;

    /**
     * Constructor
     * @param studentId: studentId of the student
     */
    public StudentNotRegisteredException(String studentId){
        this.studentId=studentId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Student with studentId : "+studentId+" is not registered";
    }

    public static void main(String args[]) {
        String exampleStudentId = "123";
        try {
            throw new StudentNotRegisteredException(exampleStudentId);
        } catch (StudentNotRegisteredException e) {
            System.out.println(e);
        }
    }
}
