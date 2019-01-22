package com.mobiquityinc.validation;

import com.mobiquityinc.domain.Package;

import java.math.BigDecimal;

import static com.mobiquityinc.validation.ValidationHelpers.lte;
import static com.mobiquityinc.validation.ValidationHelpers.notNull;

public class PackageValidator implements Validator<Package> {

    public void validate(Package aPackage) {
        notNull.and(lte(new BigDecimal(100))).test(aPackage.getLimit()).throwIfInvalid("firstname");
    }

}