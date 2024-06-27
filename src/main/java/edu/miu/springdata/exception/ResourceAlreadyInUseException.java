package edu.miu.springdata.exception;

public class ResourceAlreadyInUseException extends RuntimeException {
    public ResourceAlreadyInUseException(String message) {
        super(message);
    }
}
