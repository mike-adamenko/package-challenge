package com.mobiquityinc.packer.domain;

import com.mobiquityinc.packer.exception.APIException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfMoreThen15Items(){
        List<Item> items =  new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            Item item = new Item(1, new BigDecimal(10), new BigDecimal(10));
            items.add(item);
        }
        new Package(new BigDecimal(10), items);
    }

}