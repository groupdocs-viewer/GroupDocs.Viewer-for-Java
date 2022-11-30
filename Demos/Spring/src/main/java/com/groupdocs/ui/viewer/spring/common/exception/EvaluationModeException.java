package com.groupdocs.ui.viewer.spring.common.exception;

/**
 * Exceptions for restrictions in evaluation mode
 */
public class EvaluationModeException extends RuntimeException {
    public static final String MESSAGE = "Document with guid '%s' can't be viewed in evaluation mode as there is a collection with more than 4 elements inside the document.";

    public EvaluationModeException(String guid) {
        super(String.format(MESSAGE, guid));
    }
}
