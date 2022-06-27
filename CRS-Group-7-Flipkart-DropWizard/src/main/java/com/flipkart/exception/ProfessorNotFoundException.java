package com.flipkart.exception;
/**
 * Exception to check if professor is not found
 */
public class ProfessorNotFoundException extends Exception{
    private String professorId;

    /**
     * Constructor
     * @param userId: professorId of the professor
     */
    public ProfessorNotFoundException(String userId) {
        this.professorId = professorId;
    }

    /**
     * Message returned when exception is thrown
     */
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
