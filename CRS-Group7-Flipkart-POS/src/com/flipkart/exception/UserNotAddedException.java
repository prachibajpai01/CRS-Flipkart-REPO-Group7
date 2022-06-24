package com.flipkart.exception;
/**
 * Exception to check if user is not added
 */
public class UserNotAddedException extends Exception{
    private String userId;

    /**
     * Constructor
     * @param userId: userId of the user
     */
    public UserNotAddedException(String userId) {
        this.userId = userId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "User with ID: " + this.userId + " is not added.";
    }

    public static void main(String args[]) {
        String exampleUserId = "1232";
        try {
            throw new UserNotAddedException(exampleUserId);
        } catch (UserNotAddedException e) {
            System.out.println(e);
        }
    }
}
