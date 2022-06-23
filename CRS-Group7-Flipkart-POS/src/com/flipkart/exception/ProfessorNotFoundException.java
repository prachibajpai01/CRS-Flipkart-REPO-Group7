package com.flipkart.exception;

public class ProfessorNotFoundException extends Exception{
    private String professorId;

    public ProfessorNotFoundException(String userId) {
        this.professorId = professorId;
    }

    @Override
    public String getMessage() {
        return "User with ID: " + this.professorId + " is not found.";
    }

    public static void main(String args[]) {
        String exampleProfessorId = "1234";
        try {
            throw new ProfessorNotFoundException(exampleProfessorId);
        } catch (ProfessorNotFoundException e) {
            System.out.println(e);
        }
    }
}
