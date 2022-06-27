package com.flipkart.exception;
/**
 * Exception to check if student is not found
 */
public class StudentNotFoundException extends Exception{
    String studentId;

    /**
     * Constructor
     * @param studentId: studentId of the student
     */
    public StudentNotFoundException(String studentId){
        this.studentId=studentId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage(){
        return "Student with studentId : "+studentId+" is not found";
    }

    public static void main(String args[]) {
        String exampleStudentId = "123";
        try {
            throw new StudentNotFoundException(exampleStudentId);
        } catch (StudentNotFoundException e) {
            System.out.println(e);
        }
    }
}
