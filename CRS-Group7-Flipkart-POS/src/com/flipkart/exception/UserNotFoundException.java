package com.flipkart.exception;
/**
 * Exception to check if user is not found
 */
public class UserNotFoundException extends Exception {
    private String userId;

    /**
     * Constructor
     * @param userId: userId of the user
     */
    public UserNotFoundException(String userId) {
        this.userId = userId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "User with ID: " + this.userId + " is not found.";
    }

    public static void main(String args[]) {
        String exampleUserId = "1234";
        try {
            throw new UserNotFoundException(exampleUserId);
        } catch (UserNotFoundException e) {
            System.out.println(e);
        }
    }
}
