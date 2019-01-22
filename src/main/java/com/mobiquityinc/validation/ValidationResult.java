package com.mobiquityinc.validation;

import com.mobiquityinc.exception.APIException;

/**
 *
 */
public class ValidationResult {

    private boolean valid;
    private String onErrorMessage;

    private ValidationResult(boolean valid){
        this.valid = valid;
    }
    private ValidationResult(boolean valid, String onErrorMessage){
        this.valid = valid;
        this.onErrorMessage = onErrorMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public String getOnErrorMessage() {
        return onErrorMessage;
    }

    public static ValidationResult ok() {
        return new ValidationResult(true);
    }

    public static ValidationResult fail(String onErrorMessage) {
        return new ValidationResult(false, onErrorMessage);
    }

    public void throwIfInvalid(String field) {
        throw new APIException(field+" "+onErrorMessage);
    }
}
