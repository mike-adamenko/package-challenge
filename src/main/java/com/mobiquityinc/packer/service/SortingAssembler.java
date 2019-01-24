package com.mobiquityinc.packer.service;

import com.mobiquityinc.packer.domain.AssembledPackage;
import com.mobiquityinc.packer.domain.Item;
import com.mobiquityinc.packer.domain.Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Assembler that uses collection sorting to define assembled packages.
 * <p>
 * Rules for assembling:
 * The total weight	is less	than or	equal to the package limit and the total cost is as large as possible.
 * Send	a package which	weights	less in	case there is more than one	package	with the same price.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public final class SortingAssembler implements Assembler {

    @Override
    public AssembledPackage assemblePackage(Package aPackage) {
        AssembledPackage assembledPackage = new AssembledPackage(aPackage.getLimit(), new ArrayList<>());
        List<Item> items = aPackage.getItems();
        Collections.sort(items);
        items.stream().forEach(item -> {
            if (item.getWeight().compareTo(aPackage.getLimit()) <= 0 && assembledPackage.isLessOrEqualLimit(item)) {
                assembledPackage.getItems().add(item);
            }
        });
        return assembledPackage;
    }
}
