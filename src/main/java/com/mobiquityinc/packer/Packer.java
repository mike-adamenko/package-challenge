package com.mobiquityinc.packer;

import com.mobiquityinc.packer.dao.FileLoader;
import com.mobiquityinc.packer.domain.AssembledPackage;
import com.mobiquityinc.packer.domain.Item;
import com.mobiquityinc.packer.domain.Package;
import com.mobiquityinc.packer.exception.APIException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Packer {
    public static String pack(String filePath) throws APIException {
        try {
            List<Package> packages = new FileLoader(filePath).load();

            return packages.stream().map(Packer::assemblePackage).map(AssembledPackage::toString).collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new APIException("Packing error", e);
        }
    }

    private static AssembledPackage assemblePackage(Package aPackage) {
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
