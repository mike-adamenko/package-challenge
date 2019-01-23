package com.mobiquityinc.packer.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AssembledPackage extends Package {
    public AssembledPackage(BigDecimal limit, List<Item> items) {
        super(limit, items);
    }

    public BigDecimal getPackageWeght(){
        return getItems().stream().map(item -> item.getWeight()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isLessOrEqualLimit(Item possibleItem) {
        List<Item> possibleItems = new ArrayList();
        possibleItems.addAll(getItems());
        possibleItems.add(possibleItem);
        return possibleItems.stream().map(item -> item.getWeight()).reduce(BigDecimal.ZERO, BigDecimal::add).compareTo(getLimit())<=0;
    }
}
