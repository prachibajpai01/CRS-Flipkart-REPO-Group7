package com.flipkart.exception;

public class UserNotFoundException extends Exception {
    private String userId;

    public UserNotFoundException(String userId) {
        this.userId = userId;
    }

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
