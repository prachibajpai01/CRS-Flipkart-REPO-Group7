package com.flipkart.exception;
/**
 * Exception to check if userId is already in use
 */
public class UserIdAlreadyInUseException extends Exception{
    private String userId;

    /**
     * Constructor
     * @param userId: userId of the user
     */
    public UserIdAlreadyInUseException(String userId) {
        this.userId = userId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "User with ID: " + this.userId + " is already in use.";
    }

    public static void main(String args[]) {
        String exampleUserId = "1236";
        try {
            throw new UserIdAlreadyInUseException(exampleUserId);
        } catch (UserIdAlreadyInUseException e) {
            System.out.println(e);
        }
    }
}
