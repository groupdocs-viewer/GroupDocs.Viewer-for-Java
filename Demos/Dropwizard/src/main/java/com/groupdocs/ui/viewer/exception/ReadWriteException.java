package com.groupdocs.ui.viewer.exception;

/**
 * Wrapper for reading/writing exceptions
 */
public class ReadWriteException extends RuntimeException {

    public ReadWriteException(String message) {
        super(message);
    }

    public ReadWriteException(Throwable cause) {
        super(cause);
    }
}
