package edu.miu.springdata.util;

public class CategoryErrorMessages {
    private CategoryErrorMessages() {
    }

    public static String categoryNotFound(Long categoryId) {
        return "Category with id #" + categoryId + " not found.";
    }

    public static String categoryAlreadyExists(String name) {
        return "Category with name " + name + " already exists.";
    }

    public static String categoryInUseByProduct(Long categoryId, Long productId) {
        return "Category with id #" + categoryId + " is already in use by product #" + productId + ".";
    }
}
