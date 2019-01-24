package com.mobiquityinc.packer.validation;

/**
 * Validation interface.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 * @see ItemValidator
 * @see PackageValidator
 */
public interface Validator<T> {
    void validate(T object);
}
