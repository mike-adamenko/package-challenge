package com.mobiquityinc.packer.domain;


import com.mobiquityinc.packer.validation.ItemValidator;

import java.math.BigDecimal;

/**
 * Item.
 * Pay attention on weght and price.
 * They are defined as BigDecimal as it provides full control over the precision.
 * Which is false with double and float types.
 *
 * It implements {@link Comparable} to be able to implement {@link com.mobiquityinc.packer.service.SortingAssembler}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Item implements Comparable<Item> {
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

    /**
     * Comares 2 items first by price desc and then by weght asc
     * @param item item to be comared
     * @return comparing result
     */
    @Override
    public int compareTo(Item item) {
        BigDecimal price1 = this.getPrice();
        BigDecimal price2 = item.getPrice();
        int sComp = price2.compareTo(price1);

        if (sComp != 0) {
            return sComp;
        }

        BigDecimal weght1 = this.getWeight();
        BigDecimal weght2 = item.getWeight();
        return weght1.compareTo(weght2);
    }
}
