package edu.miu.springdata.util;

public class ReviewErrorMessages {
    private ReviewErrorMessages() {
    }

    public static String reviewNotFound(Long reviewId) {
        return "Review with id #" + reviewId + " not found.";
    }
}
