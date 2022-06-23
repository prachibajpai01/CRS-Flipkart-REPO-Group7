package com.flipkart.exception;

public class StudentNotRegisteredException extends Exception{
    String studentId;

    public StudentNotRegisteredException(String studentId){
        this.studentId=studentId;
    }

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
