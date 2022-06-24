package com.flipkart.exception;

public class StudentNotApprovedException extends Exception{
    String studentId;

    public StudentNotApprovedException(String studentId){
        this.studentId=studentId;
    }

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
