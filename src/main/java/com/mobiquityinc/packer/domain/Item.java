package com.mobiquityinc.packer.domain;


import com.mobiquityinc.packer.validation.ItemValidator;

import java.math.BigDecimal;

/**
 * Item.
 * Pay attention on weght and price.
 * They are defined as BigDecimal as it provides full control over the precision.
 * Which is false with double and float types.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Item implements Comparable {
    private final int id;
    private final BigDecimal weight;
    private final BigDecimal price;

    public Item(int id, BigDecimal weight, BigDecimal price) {
        this.id = id;
        this.weight = weight;
        this.price = price;
        new ItemValidator().validate(this);
    }

    public int getId() {
        return id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String toString() {
        return "(" + id + "," + weight + "," + price + ")";
    }

    @Override
    public int compareTo(Object o) {
        BigDecimal price1 = this.getPrice();
        BigDecimal price2 = ((Item) o).getPrice();
        int sComp = price2.compareTo(price1);

        if (sComp != 0) {
            return sComp;
        }

        BigDecimal weght1 = this.getWeight();
        BigDecimal weght2 = ((Item) o).getWeight();
        return weght1.compareTo(weght2);
    }
}
