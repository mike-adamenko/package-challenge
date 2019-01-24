package com.mobiquityinc.packer.validation.util;

import com.mobiquityinc.packer.exception.APIException;

/**
 * Represents how the validation ended.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class ValidationResult {

    private boolean valid;
    private String onErrorMessage;

    private ValidationResult(boolean valid) {
        this.valid = valid;
    }

    private ValidationResult(boolean valid, String onErrorMessage) {
        this.valid = valid;
        this.onErrorMessage = onErrorMessage;
    }

    public static ValidationResult ok() {
        return new ValidationResult(true);
    }

    public static ValidationResult fail(String onErrorMessage) {
        return new ValidationResult(false, onErrorMessage);
    }

    public boolean isValid() {
        return valid;
    }

    public String getOnErrorMessage() {
        return onErrorMessage;
    }

    /**
     * Throws {@link APIException} if validation result is invalid.
     *
     * @param field validated field
     */
    public void throwIfInvalid(String field) {
        if (!isValid()) throw new APIException(field + " " + onErrorMessage);
    }
}
