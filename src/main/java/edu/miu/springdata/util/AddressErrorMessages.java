package edu.miu.springdata.util;

public class AddressErrorMessages {

    private AddressErrorMessages() {
    }

    public static String addressNotFound(Long addressId) {
        return "Address with id #" + addressId + " not found.";
    }

}
