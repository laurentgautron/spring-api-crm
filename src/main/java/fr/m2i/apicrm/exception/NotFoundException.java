package fr.m2i.apicrm.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException() {
        super("Resource was not found");
    }
}
