package com.mobiquityinc.packer.service;

import com.mobiquityinc.packer.domain.AssembledPackage;
import com.mobiquityinc.packer.domain.Package;

/**
 * Assembler interface. Implement it if you want to define custom package assembler.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 * @see SortingAssembler
 */
public interface Assembler {
    AssembledPackage assemblePackage(Package aPackage);
}
