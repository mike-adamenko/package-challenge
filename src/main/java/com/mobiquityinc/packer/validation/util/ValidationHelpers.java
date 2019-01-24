package com.mobiquityinc.packer.validation.util;

import java.math.BigDecimal;

import static java.lang.String.format;

/**
 * Helper class. Defines validation methods.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class ValidationHelpers {
    public static Validation notNull = SimpleValidation.from((s) -> s != null, "must not be null.");

    public static Validation<BigDecimal> lte(BigDecimal bd) {
        return SimpleValidation.from((s) -> s.compareTo(bd) <= 0, format("must be <= %s", bd));
    }

    public static Validation<Integer> lte(int value) {
        return SimpleValidation.from((s) -> s <= value, format("must be <= %s", value));
    }

}