package com.mobiquityinc.packer.validation;

/**
 *
 */
public interface Validator<T> {
    void validate(T object);
}
