package com.mobiquityinc.domain;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 *
 */
public class PackageTest {
    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfLimitMoreThen100(){
        new Package(new BigDecimal(150), new ArrayList<>());
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfLimitIsNull(){
        new Package(null, new ArrayList<>());
    }

}