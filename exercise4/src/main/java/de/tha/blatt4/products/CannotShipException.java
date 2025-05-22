package de.tha.blatt4.products;

public class CannotShipException extends Exception {
    public CannotShipException(String message) {
        super(message);
    }
}
