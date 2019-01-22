package com.mobiquityinc.domain;


import java.math.BigDecimal;

/**
 * Thing.
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Thing {
    private final int id;
    private final BigDecimal weight;
    private final BigDecimal price;

    public Thing(int id, BigDecimal weight, BigDecimal price) {
        this.id = id;
        this.weight = weight;
        this.price = price;
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
}
