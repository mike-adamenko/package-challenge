package com.mobiquityinc.packer.domain;

import com.mobiquityinc.packer.validation.PackageValidator;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package.
 * <p>
 * Pay attention on limit.
 * It is defined as BigDecimal as it provides full control over the precision.
 * Which is false with double and float types.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Package {
    private final List<Item> items;

    private final BigDecimal limit;

    public Package(BigDecimal limit, List<Item> items) {
        this.limit = limit;
        this.items = items;
        new PackageValidator().validate(this);
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        if (items == null || items.isEmpty()) return "-";
        return items.stream().map(thing -> String.valueOf(thing.getId())).collect(Collectors.joining(","));
    }
}
