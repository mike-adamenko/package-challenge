package com.mobiquityinc.packer.validation;

import com.mobiquityinc.packer.domain.Package;

import java.math.BigDecimal;

import static com.mobiquityinc.packer.validation.util.ValidationHelpers.lte;
import static com.mobiquityinc.packer.validation.util.ValidationHelpers.notNull;

/**
 * Validation rules for {@link Package}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class PackageValidator implements Validator<Package> {

    public void validate(Package aPackage) {
        notNull.and(lte(new BigDecimal(100))).test(aPackage.getLimit()).throwIfInvalid("Max weight that a package can take");
        lte(15).test(aPackage.getItems().size()).throwIfInvalid("Items");
    }

}