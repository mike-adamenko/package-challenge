package com.mobiquityinc.validation;

import java.math.BigDecimal;

import static java.lang.String.format;

public class ValidationHelpers {
    public static Validation<BigDecimal> notNull = SimpleValidation.from((s) -> s != null, "must not be null.");

    public static Validation<String> moreThan(int size){
        return SimpleValidation.from((s) -> s.length() >= size, format("must have more than %s chars.", size));
    }

    public static Validation<String> lessThan(int size){
        return SimpleValidation.from((s) -> s.length() <= size, format("must have less than %s chars.", size));
    }

    public static Validation<String> between(int minSize, int maxSize){
        return moreThan(minSize).and(lessThan(maxSize));
    }

    public static Validation<String> contains(String c){
        return SimpleValidation.from((s) -> s.contains(c), format("must contain %s", c));
    }

    public static Validation<BigDecimal> lte(BigDecimal bd){
        return SimpleValidation.from((s) -> s.compareTo(bd) <=0 , format("must be <= %s", bd));
    }

}