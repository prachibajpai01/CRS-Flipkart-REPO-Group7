package com.flipkart.exception;

public class StudentNotFoundException extends Exception{
    String studentId;

    public StudentNotFoundException(String studentId){
        this.studentId=studentId;
    }

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
