package com.mobiquityinc.domain;

import com.mobiquityinc.validation.PackageValidator;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public final class Package {
    private final List<Thing> things;

    private final BigDecimal limit;

    public Package(BigDecimal limit, List<Thing> things) {
        this.limit = limit;
        this.things = Collections.unmodifiableList(things);
        new PackageValidator().validate(this);
    }

    public List<Thing> getThings() {
        return things;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        if (things == null || things.isEmpty()) return "-";
        return things.stream().map(thing -> String.valueOf(thing.getId())).collect(Collectors.joining(", "));
    }
}
