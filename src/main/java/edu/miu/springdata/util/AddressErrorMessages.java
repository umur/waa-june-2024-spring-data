package edu.miu.springdata.util;

public class AddressErrorMessages {

    private AddressErrorMessages() {
    }

    public static String addressNotFound(Long addressId) {
        return "Address with id #" + addressId + " not found.";
    }

    public static String addressAlreadyInUse(Long userId, Long addressId) {
        return "Address with id #" + addressId + " is currently in use by user with id #" + userId + ".";
    }
}
