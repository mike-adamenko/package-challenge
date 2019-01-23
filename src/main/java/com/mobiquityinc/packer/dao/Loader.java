package com.mobiquityinc.packer.dao;

import com.mobiquityinc.packer.domain.Package;

import java.util.List;

/**
 *
 */
public interface Loader {
    List<Package> load() throws Exception;
}
