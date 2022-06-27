package com.flipkart.exception;
/**
 * Exception to check if user is not approved
 */
public class UserNotApprovedException extends Exception{
    private String userId;

    /**
     * Constructor
     * @param userId: userId of the user
     */
    public UserNotApprovedException(String userId) {
        this.userId = userId;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "User with ID: " + this.userId + " can not be approved.";
    }

    public static void main(String args[]) {
        String exampleUserId = "1238";
        try {
            throw new UserNotApprovedException(exampleUserId);
        } catch (UserNotApprovedException e) {
            System.out.println(e);
        }
    }
}
