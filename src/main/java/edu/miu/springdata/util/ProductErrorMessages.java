package edu.miu.springdata.util;

public class ProductErrorMessages {
    private ProductErrorMessages() {
    }

    public static String productNotFound(Long productId) {
        return "Product with id #" + productId + " not found.";
    }
}
