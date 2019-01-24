package com.mobiquityinc.packer;

import com.mobiquityinc.packer.dao.FileLoader;
import com.mobiquityinc.packer.domain.AssembledPackage;
import com.mobiquityinc.packer.domain.Package;
import com.mobiquityinc.packer.exception.APIException;
import com.mobiquityinc.packer.service.Assembler;
import com.mobiquityinc.packer.service.SortingAssembler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Main entry point.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Packer {
    private static final Assembler ASSEMBLER = new SortingAssembler();

    public static String pack(String filePath) throws APIException {
        try {
            List<Package> packages = new FileLoader(filePath).load();

            return packages.stream().map(ASSEMBLER::assemblePackage).map(AssembledPackage::toString).collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new APIException("Packing error", e);
        }
    }


}
