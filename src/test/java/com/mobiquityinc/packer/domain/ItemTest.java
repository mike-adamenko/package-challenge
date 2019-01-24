package com.mobiquityinc.packer.domain;

import com.mobiquityinc.packer.exception.APIException;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Unit tests for {@link Item}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class ItemTest {
    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfWeghtMoreThen100() {
        new Item(1, new BigDecimal(150), new BigDecimal(25));
    }

    @Test(expected = APIException.class)
    public void shouldThrowAPIExceptionIfPriceMoreThen100() {
        new Item(1, new BigDecimal(10), new BigDecimal(125));
    }

}