package com.mobiquityinc.packer.validation;

import com.mobiquityinc.packer.domain.Item;

import java.math.BigDecimal;

import static com.mobiquityinc.packer.validation.util.ValidationHelpers.lte;
import static com.mobiquityinc.packer.validation.util.ValidationHelpers.notNull;

/**
 * Validation rules for {@link Item}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class ItemValidator implements Validator<Item> {

    @Override
    public void validate(Item item) {
        notNull.and(lte(new BigDecimal(100))).test(item.getWeight()).throwIfInvalid("Max weight of an item");
        notNull.and(lte(new BigDecimal(100))).test(item.getPrice()).throwIfInvalid("Max cost of an item");
    }
}