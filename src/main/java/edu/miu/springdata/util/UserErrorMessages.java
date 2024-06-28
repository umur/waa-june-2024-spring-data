package edu.miu.springdata.util;

public class UserErrorMessages {

    private static final String INCORRECT_PASSWORD = "Current password is incorrect.";

    private UserErrorMessages() {
    }

    public static String userNotFound(Long userId) {
        return "User with id #" + userId + " not found.";
    }

    public static String emailAlreadyExists(String email) {
        return "User with email " + email + " already exists.";
    }

    public static String currentPasswordIsIncorrect() {
        return INCORRECT_PASSWORD;
    }
}
