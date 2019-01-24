package com.mobiquityinc.packer.exception;

/**
 * Exception that is thrown if there is any errors during processing.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class APIException extends RuntimeException {
    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }
}
