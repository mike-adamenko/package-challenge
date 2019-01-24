package com.mobiquityinc.packer.dao;

import com.mobiquityinc.packer.domain.Package;

import java.util.List;

/**
 * Loader interface to process external package data
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public interface Loader {
    List<Package> load() throws Exception;
}
