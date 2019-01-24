package com.mobiquityinc.packer.validation.util;

import java.util.function.Predicate;

/**
 * Defines a {@link Predicate} and  error result with the onErrorMessage you sent in case the Predicate fails
 *
 * @param <K> validation type
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class SimpleValidation<K> implements Validation<K> {

    private Predicate<K> predicate;
    private String onErrorMessage;

    private SimpleValidation(Predicate<K> predicate, String onErrorMessage) {
        this.predicate = predicate;
        this.onErrorMessage = onErrorMessage;
    }

    public static <K> SimpleValidation<K> from(Predicate<K> predicate, String onErrorMessage) {
        return new SimpleValidation<>(predicate, onErrorMessage);
    }

    @Override
    public ValidationResult test(K param) {
        return predicate.test(param) ? ValidationResult.ok() : ValidationResult.fail(onErrorMessage);
    }

}